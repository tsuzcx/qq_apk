package com.tencent.mobileqq.data;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCommonRequest;
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
  private static Map<String, String> showStatusUIns = new ConcurrentHashMap();
  private static Map<String, Long> tokenMap = new ConcurrentHashMap();
  private QQAppInterface app;
  private EntityManager em;
  Map<String, FeedInfo> feedInfoCache = new ConcurrentHashMap();
  private volatile boolean hasRequest = false;
  private volatile boolean inited = false;
  public long serverTimeDiv = 0L;
  
  public FeedsManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    intCache();
  }
  
  private QZoneConversationStatusRequest buildRequest(HashMap<Long, Long> paramHashMap)
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
      StringBuilder localStringBuilder1 = new StringBuilder(paramString.length());
      for (int i = 0; ((Matcher)localObject).find(); i = ((Matcher)localObject).end())
      {
        localStringBuilder1.append(paramString.substring(i, ((Matcher)localObject).start()));
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("@");
        localStringBuilder2.append(decodeNick(((Matcher)localObject).group(1)));
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(paramString.substring(i));
      localObject = localStringBuilder1.toString();
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
  
  private long getAIOLatestFeedsTime(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    if (bool) {
      return 0L;
    }
    paramString = this.app.getMessageFacade().a(paramString, 0, new int[] { -2015 });
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.size() > 0)
      {
        paramString = (MessageForQzoneFeed)paramString.get(paramString.size() - 1);
        l1 = l2;
        if (paramString != null)
        {
          paramString.doParse();
          l1 = paramString.feedTime;
        }
      }
    }
    return l1;
  }
  
  private long getServerTimeDiv()
  {
    long l = this.serverTimeDiv;
    if (l > 0L) {
      return l;
    }
    this.serverTimeDiv = this.app.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong("time_server_div", 1800000L);
    return this.serverTimeDiv;
  }
  
  public static long getToken(String paramString)
  {
    if (tokenMap.containsKey(paramString))
    {
      paramString = (Long)tokenMap.get(paramString);
      if (paramString != null) {
        return paramString.longValue();
      }
    }
    return 0L;
  }
  
  public static void hideStatus(String paramString)
  {
    showStatusUIns.remove(paramString);
  }
  
  private boolean inCodeDuring()
  {
    long l1 = getServerTimeDiv() * 1000L;
    if ((NetworkState.getNetworkType() == 2) || (NetworkState.getNetworkType() == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, " updateQzoneFeeds 2g 和3g下要降频，只能4小时请求一次");
      }
      l1 = 14400000L;
    }
    long l2 = l1;
    if (l1 < 1800000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, "updateQzoneFeeds timeDiv<=30分钟，使用默认的时间间隔");
      }
      l2 = 1800000L;
    }
    l1 = System.currentTimeMillis();
    long l3 = getLastReqTime();
    if (l2 + l3 > System.currentTimeMillis())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, String.format("timeDiv(%d)+lastReqTimes(%d)>System.currentTimeMillis()(%d),serverTime (%d s)暂不发请求", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(this.serverTimeDiv) }));
      }
      return true;
    }
    return false;
  }
  
  private void intCache()
  {
    ThreadManagerV2.excute(new FeedsManager.1(this), 32, new FeedsManager.2(this), true);
  }
  
  public static boolean isShowStatus(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Map localMap = showStatusUIns;
      if (localMap != null) {
        return localMap.containsKey(paramString);
      }
    }
    return false;
  }
  
  private void saveAndUpdateCache(ArrayList<feed_info> paramArrayList)
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
      localFeedInfo.strImgUrl = localfeed_info.strImgUrl;
      localFeedInfo.typeId = localfeed_info.typeId;
      localFeedInfo.ownerUin = localfeed_info.opuin;
      localFeedInfo.strkey = localfeed_info.strkey;
      ((ArrayList)localObject).add(localFeedInfo);
      long l = getAIOLatestFeedsTime(String.valueOf(localFeedInfo.ownerUin));
      if (localFeedInfo.feedTime <= l)
      {
        QLog.w("FeedsManager", 1, String.format("aio feeds lastes time is %d > this feed time (%d),说明用户已经在aio看到过最新feeds，不再显示新动态", new Object[] { Long.valueOf(l), Long.valueOf(localFeedInfo.feedTime) }));
        localFeedInfo.showInTab = false;
      }
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
  private boolean saveFeedInfoToDb(ArrayList<FeedInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 405	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokevirtual 308	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_1
    //   15: aload_1
    //   16: invokeinterface 313 1 0
    //   21: ifeq +24 -> 45
    //   24: aload_1
    //   25: invokeinterface 317 1 0
    //   30: checkcast 321	com/tencent/mobileqq/data/qzone/FeedInfo
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 62	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: aload_3
    //   39: invokevirtual 414	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   42: goto -27 -> 15
    //   45: aload_0
    //   46: getfield 62	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: invokevirtual 405	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   52: invokevirtual 417	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   55: iconst_1
    //   56: istore_2
    //   57: goto +25 -> 82
    //   60: astore_1
    //   61: goto +33 -> 94
    //   64: astore_1
    //   65: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +12 -> 80
    //   71: ldc 164
    //   73: iconst_2
    //   74: ldc 166
    //   76: aload_1
    //   77: invokestatic 419	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 62	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   86: invokevirtual 405	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   89: invokevirtual 421	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   92: iload_2
    //   93: ireturn
    //   94: aload_0
    //   95: getfield 62	com/tencent/mobileqq/data/FeedsManager:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   98: invokevirtual 405	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   101: invokevirtual 421	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   104: goto +5 -> 109
    //   107: aload_1
    //   108: athrow
    //   109: goto -2 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	FeedsManager
    //   0	112	1	paramArrayList	ArrayList<FeedInfo>
    //   56	37	2	bool	boolean
    //   33	6	3	localFeedInfo	FeedInfo
    // Exception table:
    //   from	to	target	type
    //   10	15	60	finally
    //   15	42	60	finally
    //   45	55	60	finally
    //   65	80	60	finally
    //   10	15	64	java/lang/Throwable
    //   15	42	64	java/lang/Throwable
    //   45	55	64	java/lang/Throwable
  }
  
  private void saveServerTimeDiv(long paramLong)
  {
    this.serverTimeDiv = paramLong;
    this.app.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong("time_server_div", paramLong).apply();
  }
  
  public static void saveToken(String paramString, long paramLong)
  {
    tokenMap.put(paramString, Long.valueOf(paramLong));
  }
  
  public static void showStatus(String paramString)
  {
    showStatusUIns.put(paramString, "");
  }
  
  public long getLastReqTime()
  {
    return this.app.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong("last_req_status_time_in_conversation", 0L);
  }
  
  public ArrayList<Long> getRecentUinList()
  {
    ArrayList localArrayList = new ArrayList();
    int j = QZoneHelper.getMaxRecentUserNum();
    if (j <= 0)
    {
      QLog.w("FeedsManager", 1, "wns  下发的最大请求个数是 小于0，");
      return localArrayList;
    }
    int i = j;
    if (j > 100)
    {
      QLog.w("FeedsManager", 1, "wns  下发的最大请求个数是 大于100，取值100");
      i = 100;
    }
    Object localObject = this.app.getProxyManager().a();
    j = 0;
    localObject = ((RecentUserProxy)localObject).a(true, false);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if (localRecentUser.getType() == 0) {
          if (j >= i) {
            break;
          }
        }
        try
        {
          localArrayList.add(Long.valueOf(Long.parseLong(localRecentUser.uin)));
          j += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label154:
          break label154;
        }
        QLog.e("FeedsManager", 1, "wtf getRecentUinList uin  不是一个数字");
      }
    }
    return localArrayList;
  }
  
  public String getSummary(String paramString)
  {
    boolean bool = QZoneHelper.hideQzoneStatusInConverstation();
    StringBuilder localStringBuilder = null;
    if (bool)
    {
      QLog.i("FeedsManager", 2, "getSummary 下发配置隐藏新动态");
      return null;
    }
    FeedInfo localFeedInfo = (FeedInfo)this.feedInfoCache.get(paramString);
    Object localObject = localStringBuilder;
    if (localFeedInfo != null)
    {
      localObject = localStringBuilder;
      if (localFeedInfo.showInTab) {
        localObject = localFeedInfo.content;
      }
    }
    localObject = convertAtStruct((String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummary uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" showQzoneStatus content:");
      localStringBuilder.append((String)localObject);
      QLog.i("FeedsManager", 2, localStringBuilder.toString());
    }
    return localObject;
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
      saveServerTimeDiv(paramBundle.uNextTime);
      ThreadManagerV2.excute(new FeedsManager.3(this, localArrayList), 32, null, true);
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
      paramString = (BeancurdManager)this.app.getManager(QQManagerFactory.BEANCURD_MANAGER);
      if (paramString != null) {
        paramString.a(1, 2);
      }
    }
  }
  
  public void saveLastReqTime(long paramLong)
  {
    this.app.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong("last_req_status_time_in_conversation", paramLong).apply();
  }
  
  public boolean setFeedInfoRead(String paramString)
  {
    Object localObject = (FeedInfo)this.feedInfoCache.get(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setFeedInfoRead ,feedInfo= null :");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("FeedsManager", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (((FeedInfo)localObject).showInTab)
    {
      ((FeedInfo)localObject).showInTab = false;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setFeedInfoRead start :");
        localStringBuilder.append(paramString);
        QLog.e("FeedsManager", 2, localStringBuilder.toString());
      }
      ThreadManagerV2.excute(new FeedsManager.4(this, (FeedInfo)localObject, paramString), 32, null, true);
    }
    return true;
  }
  
  public void updateQzoneFeeds()
  {
    if (QZoneHelper.hideQzoneStatusInConverstation())
    {
      QLog.i("FeedsManager", 2, "updateQzoneFeeds 下发配置隐藏新动态");
      return;
    }
    if (!this.inited)
    {
      this.hasRequest = true;
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, "updateQzoneFeeds 缓存尚未初始化完毕，等待缓存初始完毕再刷新空间新动态");
      }
      return;
    }
    this.hasRequest = false;
    if (inCodeDuring()) {
      return;
    }
    try
    {
      Object localObject2 = getRecentUinList();
      Object localObject1 = new HashMap();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject2).next();
          FeedInfo localFeedInfo = (FeedInfo)this.feedInfoCache.get(String.valueOf(localLong));
          long l = 0L;
          if (localFeedInfo != null) {
            l = localFeedInfo.feedTime;
          }
          ((HashMap)localObject1).put(localLong, Long.valueOf(l));
        }
      }
      localObject2 = new QzoneCommonIntent(this.app.getApp(), QZoneCommonServlet.class);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      localObject1 = buildRequest((HashMap)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, String.valueOf(localObject1));
      }
      ((QzoneCommonIntent)localObject2).setRequest((QZoneCommonRequest)localObject1);
      this.app.startServlet((NewIntent)localObject2);
      saveLastReqTime(System.currentTimeMillis());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FeedsManager", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager
 * JD-Core Version:    0.7.0.1
 */