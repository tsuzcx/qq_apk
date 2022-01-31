package com.tencent.mobileqq.data;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import acbi;
import acbj;
import acbl;
import acbm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneConversationStatusRequest;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class FeedsManager
  implements Manager, BusinessObserver
{
  private static Map showStatusUIns = new ConcurrentHashMap();
  private QQAppInterface app;
  private EntityManager em;
  public Map feedInfoCache = new ConcurrentHashMap();
  private volatile boolean hasRequest;
  private volatile boolean inited;
  public long serverTimeDiv;
  
  public FeedsManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    intCache();
  }
  
  private QZoneConversationStatusRequest buildRequest(HashMap paramHashMap)
  {
    return new QZoneConversationStatusRequest(this.app.getLongAccountUin(), paramHashMap);
  }
  
  public static String convertAtStruct(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramString;
      }
      Object localObject = Pattern.compile("@\\{uin:\\d+?,nick:(.+?)\\}").matcher(paramString);
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      for (int i = 0; ((Matcher)localObject).find(); i = ((Matcher)localObject).end())
      {
        localStringBuilder.append(paramString.substring(i, ((Matcher)localObject).start()));
        localStringBuilder.append("@" + decodeNick(((Matcher)localObject).group(1)));
      }
      localStringBuilder.append(paramString.substring(i));
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FeedsManager", 2, "", localThrowable);
    }
    return paramString;
  }
  
  private static String decodeNick(String paramString)
  {
    return paramString;
  }
  
  public static void hideStatus(String paramString)
  {
    showStatusUIns.remove(paramString);
  }
  
  private boolean inCodeDuring()
  {
    long l2 = 1800000L;
    long l1 = this.serverTimeDiv * 1000L;
    if ((NetworkState.getNetworkType() == 3) || (NetworkState.getNetworkType() == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, " updateQzoneFeeds 2g 和3g下要降频，只能4小时请求一次");
      }
      l1 = 14400000L;
    }
    if (l1 < 1800000L)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("FeedsManager", 2, "updateQzoneFeeds timeDiv<=30分钟，使用默认的时间间隔");
        l1 = l2;
      }
    }
    for (;;)
    {
      l2 = System.currentTimeMillis();
      long l3 = getLastReqTime();
      if (l1 + l3 > System.currentTimeMillis())
      {
        if (QLog.isColorLevel()) {
          QLog.i("FeedsManager", 2, String.format("timeDiv(%d)+lastReqTimes(%d)>System.currentTimeMillis()(%d),serverTime (%d s)暂不发请求", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(this.serverTimeDiv) }));
        }
        return true;
      }
      return false;
    }
  }
  
  private void intCache()
  {
    ThreadManagerV2.excute(new acbi(this), 32, new acbj(this), true);
  }
  
  public static boolean isShowStatus(String paramString)
  {
    return showStatusUIns.containsKey(paramString);
  }
  
  private void saveAndUpdateCache(ArrayList paramArrayList)
  {
    Object localObject = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      feed_info localfeed_info = (feed_info)paramArrayList.next();
      FeedInfo localFeedInfo = new FeedInfo();
      localFeedInfo.appid = localfeed_info.appid;
      localFeedInfo.content = localfeed_info.strcontent;
      localFeedInfo.feedTime = localfeed_info.time;
      localFeedInfo.hasPic = ((int)localfeed_info.has_pic);
      localFeedInfo.typeId = localfeed_info.typeId;
      localFeedInfo.ownerUin = localfeed_info.opuin;
      localFeedInfo.strkey = localfeed_info.strkey;
      ((ArrayList)localObject).add(localFeedInfo);
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, String.valueOf(localFeedInfo));
      }
    }
    if ((!((ArrayList)localObject).isEmpty()) && (saveFeedInfoToDb((ArrayList)localObject)))
    {
      paramArrayList = ((ArrayList)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (FeedInfo)paramArrayList.next();
        this.feedInfoCache.put(String.valueOf(((FeedInfo)localObject).ownerUin), localObject);
      }
    }
    if (!this.feedInfoCache.isEmpty()) {
      this.app.notifyObservers(QZoneFeedsObserver.class, 10000, true, null);
    }
  }
  
  /* Error */
  private boolean saveFeedInfoToDb(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 326	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 330	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   10: aload_1
    //   11: invokevirtual 242	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_1
    //   15: aload_1
    //   16: invokeinterface 247 1 0
    //   21: ifeq +52 -> 73
    //   24: aload_1
    //   25: invokeinterface 251 1 0
    //   30: checkcast 255	com/tencent/mobileqq/data/qzone/FeedInfo
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 50	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: aload_2
    //   39: invokevirtual 334	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   42: goto -27 -> 15
    //   45: astore_1
    //   46: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +12 -> 61
    //   52: ldc 154
    //   54: iconst_2
    //   55: ldc 156
    //   57: aload_1
    //   58: invokestatic 336	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   61: aload_0
    //   62: getfield 50	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   65: invokevirtual 326	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   68: invokevirtual 338	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_0
    //   74: getfield 50	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   77: invokevirtual 326	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   80: invokevirtual 341	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   83: aload_0
    //   84: getfield 50	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   87: invokevirtual 326	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   90: invokevirtual 338	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   93: iconst_1
    //   94: ireturn
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 50	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   100: invokevirtual 326	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   103: invokevirtual 338	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	FeedsManager
    //   0	108	1	paramArrayList	ArrayList
    //   33	6	2	localFeedInfo	FeedInfo
    // Exception table:
    //   from	to	target	type
    //   10	15	45	java/lang/Throwable
    //   15	42	45	java/lang/Throwable
    //   73	83	45	java/lang/Throwable
    //   10	15	95	finally
    //   15	42	95	finally
    //   46	61	95	finally
    //   73	83	95	finally
  }
  
  public static void showStatus(String paramString)
  {
    showStatusUIns.put(paramString, "");
  }
  
  public long getLastReqTime()
  {
    return this.app.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong("last_req_status_time_in_conversation", 0L);
  }
  
  public ArrayList getRecentUinList()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int k = QZoneHelper.e();
    if (k <= 0)
    {
      QLog.w("FeedsManager", 1, "wns  下发的最大请求个数是 小于0，");
      return localArrayList;
    }
    int j = k;
    if (k > 100)
    {
      QLog.w("FeedsManager", 1, "wns  下发的最大请求个数是 大于100，取值100");
      j = 100;
    }
    Object localObject = this.app.a().a().a(true, false);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if (localRecentUser.type == 0)
        {
          if (i >= j) {}
        }
        else {
          for (;;)
          {
            try
            {
              localArrayList.add(Long.valueOf(Long.parseLong(localRecentUser.uin)));
              i += 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.e("FeedsManager", 1, "wtf getRecentUinList uin  不是一个数字");
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String getSummary(String paramString)
  {
    Object localObject = null;
    if (QZoneHelper.k())
    {
      QLog.i("FeedsManager", 2, "getSummary 下发配置隐藏新动态");
      return localObject;
    }
    localObject = (FeedInfo)this.feedInfoCache.get(paramString);
    if ((localObject != null) && (((FeedInfo)localObject).showInTab)) {}
    for (localObject = ((FeedInfo)localObject).content;; localObject = null)
    {
      String str = convertAtStruct((String)localObject);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      localObject = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FeedsManager", 2, "getSummary uin:" + paramString + " showQzoneStatus content:" + str);
      return str;
    }
  }
  
  public void onDestroy()
  {
    this.inited = false;
    this.feedInfoCache.clear();
    showStatusUIns.clear();
    if (QLog.isColorLevel()) {
      QLog.i("FeedsManager", 2, "onDestroy");
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FeedsManager", 2, String.format(" onReceive,type:%d,success:%b,bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), String.valueOf(paramBundle) }));
    }
    if (paramBoolean)
    {
      paramBundle = (newest_feeds_rsp)paramBundle.getSerializable("key_response");
      ArrayList localArrayList = paramBundle.vec_feed_info;
      this.serverTimeDiv = paramBundle.uNextTime;
      ThreadManagerV2.excute(new acbl(this, localArrayList), 32, null, true);
    }
  }
  
  public void reportClickExpose()
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064(722, 1, 2);
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
  }
  
  public void reportExposeStatus(String paramString)
  {
    paramString = (FeedInfo)this.feedInfoCache.get(paramString);
    if ((paramString != null) && (!paramString.isExpose))
    {
      paramString.isExpose = true;
      paramString = new LpReportInfo_pf00064(722, 1, 1);
      LpReportManager.getInstance().reportToPF00064(paramString, false, false);
    }
  }
  
  public void saveLastReqTime(long paramLong)
  {
    this.app.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong("last_req_status_time_in_conversation", paramLong).apply();
  }
  
  public boolean setFeedInfoRead(String paramString)
  {
    FeedInfo localFeedInfo = (FeedInfo)this.feedInfoCache.get(paramString);
    if (localFeedInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FeedsManager", 2, "setFeedInfoRead ,feedInfo= null :" + paramString);
      }
      return false;
    }
    if (localFeedInfo.showInTab)
    {
      localFeedInfo.showInTab = false;
      if (QLog.isColorLevel()) {
        QLog.e("FeedsManager", 2, "setFeedInfoRead start :" + paramString);
      }
      ThreadManagerV2.excute(new acbm(this, localFeedInfo, paramString), 32, null, true);
    }
    return true;
  }
  
  public void updateQzoneFeeds()
  {
    if (QZoneHelper.k()) {
      QLog.i("FeedsManager", 2, "updateQzoneFeeds 下发配置隐藏新动态");
    }
    do
    {
      do
      {
        return;
        if (this.inited) {
          break;
        }
        this.hasRequest = true;
      } while (!QLog.isColorLevel());
      QLog.i("FeedsManager", 2, "updateQzoneFeeds 缓存尚未初始化完毕，等待缓存初始完毕再刷新空间新动态");
      return;
      this.hasRequest = false;
    } while (inCodeDuring());
    Object localObject;
    try
    {
      localObject = getRecentUinList();
      HashMap localHashMap = new HashMap();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          FeedInfo localFeedInfo = (FeedInfo)this.feedInfoCache.get(String.valueOf(localLong));
          long l = 0L;
          if (localFeedInfo != null) {
            l = localFeedInfo.feedTime;
          }
          localHashMap.put(localLong, Long.valueOf(l));
        }
      }
      localObject = new QzoneCommonIntent(this.app.getApp(), QZoneCommonServlet.class);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FeedsManager", 1, "", localThrowable);
      return;
    }
    ((QzoneCommonIntent)localObject).setObserver(this);
    QZoneConversationStatusRequest localQZoneConversationStatusRequest = buildRequest(localThrowable);
    if (QLog.isColorLevel()) {
      QLog.i("FeedsManager", 2, String.valueOf(localQZoneConversationStatusRequest));
    }
    ((QzoneCommonIntent)localObject).setRequest(localQZoneConversationStatusRequest);
    this.app.startServlet((NewIntent)localObject);
    saveLastReqTime(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager
 * JD-Core Version:    0.7.0.1
 */