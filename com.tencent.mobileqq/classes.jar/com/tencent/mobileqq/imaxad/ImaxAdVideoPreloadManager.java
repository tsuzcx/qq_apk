package com.tencent.mobileqq.imaxad;

import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xfd.submsgtype0xfd.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xfd.submsgtype0xfd.MsgBody;

public class ImaxAdVideoPreloadManager
  implements Manager
{
  private static final String a;
  private static final String[] b = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private final Object c = new Object();
  private WeakReference<QQAppInterface> d;
  private Context e;
  private ArrayList<PAAdPreloadTask> f = new ArrayList();
  private PAAdPreloadTask g;
  private int h = 0;
  private boolean i = false;
  private TVK_ICacheMgr j;
  private TVK_UserInfo k;
  private ImaxAdVideoPreloadManager.NetInfoHandler l;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/");
    a = localStringBuilder.toString();
  }
  
  public ImaxAdVideoPreloadManager(QQAppInterface paramQQAppInterface)
  {
    this.d = new WeakReference(paramQQAppInterface);
    this.e = paramQQAppInterface.getApplication().getApplicationContext();
    if (!this.i) {
      b();
    }
  }
  
  private static MessageRecord a(String paramString, AdvertisementItem paramAdvertisementItem)
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.selfuin = paramString;
    localMessageRecord.frienduin = paramAdvertisementItem.a;
    localMessageRecord.senderuin = paramAdvertisementItem.a;
    localMessageRecord.msgtype = -1000;
    localMessageRecord.msg = paramAdvertisementItem.j;
    localMessageRecord.time = paramAdvertisementItem.m;
    localMessageRecord.shmsgseq = paramAdvertisementItem.n;
    localMessageRecord.msgUid = paramAdvertisementItem.o;
    localMessageRecord.istroop = 10005;
    localMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "1");
    return localMessageRecord;
  }
  
  private String a()
  {
    WeakReference localWeakReference = this.d;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((QQAppInterface)this.d.get()).getCurrentUin();
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (!this.i) {
      b();
    }
    for (;;)
    {
      synchronized (this.c)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startVideoDownload queueType:");
        ((StringBuilder)localObject2).append(paramInt);
        ImaxAdUtil.c(((StringBuilder)localObject2).toString());
        if (this.j == null)
        {
          ImaxAdUtil.c("startVideoDownload cache manager not init!");
          d();
          return;
        }
        if (paramInt <= this.h)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload queue(");
          ((StringBuilder)localObject2).append(this.h);
          ((StringBuilder)localObject2).append(") already run!");
          ImaxAdUtil.c(((StringBuilder)localObject2).toString());
          return;
        }
        if (this.h != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload break current queue(");
          ((StringBuilder)localObject2).append(this.h);
          ((StringBuilder)localObject2).append(")!");
          ImaxAdUtil.c(((StringBuilder)localObject2).toString());
          this.j.stopCacheData(20170807);
          d();
          break label831;
          if (this.f.size() > 0) {
            this.g = ((PAAdPreloadTask)this.f.remove(0));
          }
          if (this.g == null)
          {
            ImaxAdUtil.c("startVideoDownload no task to download");
            d();
            return;
          }
          this.h = paramInt;
          localObject2 = this.g.mVideoVid;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (!this.g.isExpire())
            {
              m = f((String)localObject2);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("startVideoDownload vid:");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(", cacheState:");
              ((StringBuilder)localObject4).append(m);
              ImaxAdUtil.c(((StringBuilder)localObject4).toString());
              if (m != 2) {
                if (this.g.isNetworkValid())
                {
                  localObject4 = e((String)localObject2);
                  localObject5 = new File((String)localObject4);
                  boolean bool = ((File)localObject5).exists();
                  if (bool) {}
                }
              }
            }
          }
          try
          {
            ((File)localObject5).createNewFile();
          }
          catch (IOException localIOException)
          {
            HashMap localHashMap;
            continue;
          }
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("startVideoDownload create tmp file failed for vid:");
          ((StringBuilder)localObject5).append((String)localObject2);
          ImaxAdUtil.c(((StringBuilder)localObject5).toString());
          localObject5 = new TVK_PlayerVideoInfo(2, (String)localObject2, "");
          localHashMap = new HashMap();
          localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
          ((TVK_PlayerVideoInfo)localObject5).setReportInfoMap(localHashMap);
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_duration", String.valueOf(-1));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_servers_type", String.valueOf(20170807));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("file_dir", (String)localObject4);
          this.j.preLoadVideoById(this.e, this.k, (TVK_PlayerVideoInfo)localObject5, "");
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ImaxAdUtil.c(((StringBuilder)localObject4).toString());
          continue;
          int m = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", networkType:");
          ((StringBuilder)localObject4).append(this.g.mNetworkType);
          ((StringBuilder)localObject4).append(", curNetType:");
          ((StringBuilder)localObject4).append(m);
          ((StringBuilder)localObject4).append(", no valid network, skip to next task");
          ImaxAdUtil.c(((StringBuilder)localObject4).toString());
          b(paramInt);
          continue;
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("vid:");
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append(", full cached, skip to next task");
            QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject4).toString());
          }
          g((String)localObject2);
          b(paramInt);
          continue;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", expireTime:");
          ((StringBuilder)localObject4).append(this.g.mExpireTime);
          ((StringBuilder)localObject4).append(", task expired, clean cache and skip to next task");
          ImaxAdUtil.c(((StringBuilder)localObject4).toString());
          b(paramInt);
          if (f((String)localObject2) != 0)
          {
            ThreadManager.executeOnFileThread(new ImaxAdVideoPreloadManager.7(this, (String)localObject2));
            continue;
            ImaxAdUtil.c("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
          return;
        }
      }
      label831:
      if (paramInt == 2) {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy)
  {
    Object localObject1 = (AdvertisementItem)paramMessageRecord.advertisementItem;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AdvertisementItem)localObject1).g.a)))
    {
      ImaxAdRecentUserManager.a().a(((AdvertisementItem)localObject1).a);
      ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject1);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((AdvertisementItem)localObject1).g.a);
      if (((AdvertisementItem)localObject1).g.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((AdvertisementItem)localObject1).g.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_uin_head_url", ((AdvertisementItem)localObject1).i);
      localObject2 = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
      localObject1 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (paramMessageRecord.frienduin.equals(((MessageRecord)localObject3).frienduin)) {
            ((List)localObject1).add(localObject3);
          }
        }
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        paramEntityManager.remove((Entity)localObject2);
        RecentUtil.b(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
        localObject3 = paramRecentUserProxy.b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localObject3 != null)
        {
          RecentDataListManager localRecentDataListManager = RecentDataListManager.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageRecord.frienduin);
          localStringBuilder.append("-");
          localStringBuilder.append(paramMessageRecord.istroop);
          localRecentDataListManager.b(localStringBuilder.toString());
          paramRecentUserProxy.a((RecentUser)localObject3);
        }
        paramQQAppInterface.getMessageFacade().a(((MessageRecord)localObject2).frienduin, 10005, true, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "isImaxAdMessage: 0");
        }
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
      }
    }
  }
  
  private void a(List<PAAdPreloadTask> paramList, AdvertisementItem paramAdvertisementItem, VideoCoverItem paramVideoCoverItem)
  {
    PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
    VideoDownloadItem localVideoDownloadItem = paramAdvertisementItem.g;
    localPAAdPreloadTask.mUserUin = a();
    localPAAdPreloadTask.mVideoVid = paramVideoCoverItem.c;
    localPAAdPreloadTask.mMsgId = paramAdvertisementItem.d;
    localPAAdPreloadTask.mSource = 2;
    long l1;
    if (paramAdvertisementItem.e > 0L) {
      l1 = paramAdvertisementItem.e;
    } else {
      l1 = NetConnInfoCenter.getServerTimeMillis();
    }
    localPAAdPreloadTask.mReceiveTime = l1;
    localPAAdPreloadTask.mExpireTime = paramAdvertisementItem.l;
    localPAAdPreloadTask.mPreloadState = 1;
    localPAAdPreloadTask.mNetworkType = localVideoDownloadItem.u;
    paramList.add(localPAAdPreloadTask);
  }
  
  private void b()
  {
    ImaxAdUtil.c("installTVKSdk");
    this.k = new TVK_UserInfo(a(), "");
    this.l = new ImaxAdVideoPreloadManager.NetInfoHandler(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.e, this.l);
    try
    {
      TVK_SDKMgr.setOnLogListener(new ImaxAdVideoPreloadManager.1(this));
      TVK_SDKMgr.initSdk(this.e, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", a());
      if (!TVK_SDKMgr.isInstalled(this.e))
      {
        TVK_SDKMgr.installPlugin(this.e, new ImaxAdVideoPreloadManager.2(this));
        return;
      }
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ImaxAdvertisement", 2, "installTVKSdk ", localThrowable);
    }
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("continueDownload queueType:");
    localStringBuilder.append(paramInt);
    ImaxAdUtil.c(localStringBuilder.toString());
    this.h = 0;
    this.g = null;
    ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.8(this, paramInt));
  }
  
  private void b(AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 advertisementItem == null");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertToMsgSystem 0xf9 advertisementItem:");
      ((StringBuilder)localObject).append(paramAdvertisementItem.a);
      QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.d.get();
    if (localObject == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 QQAppInterface == null");
      return;
    }
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    MessageRecord localMessageRecord = a(str, paramAdvertisementItem);
    localMessageRecord.advertisementItem = paramAdvertisementItem;
    paramAdvertisementItem = new ArrayList();
    paramAdvertisementItem.add(localMessageRecord);
    ((QQAppInterface)localObject).getMessageFacade().a(paramAdvertisementItem, str, false, true, true);
    ((QQAppInterface)localObject).getConversationFacade().p(localMessageRecord.frienduin, localMessageRecord.istroop).isImax = true;
    a((QQAppInterface)localObject);
  }
  
  public static boolean b(String paramString)
  {
    return f(paramString) == 2;
  }
  
  private void c()
  {
    ImaxAdUtil.c("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.j = localTVK_IProxyFactory.getCacheMgr(this.e);
      this.j.setPreloadCallback(new ImaxAdVideoPreloadManager.PreloadCallback(this, null));
      this.j.setOnPreLoadCompleteCallback(new ImaxAdVideoPreloadManager.PreloadCompleteCallback(this, null));
    }
    this.i = true;
  }
  
  public static void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearCacheVideo vid:");
    ((StringBuilder)localObject).append(paramString);
    ImaxAdUtil.c(((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new File(e(paramString));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramString = new File(d(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append(String.valueOf(20170807));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
    }
    return "";
  }
  
  private void d()
  {
    ImaxAdUtil.c("resetDownload");
    this.h = 0;
    this.g = null;
  }
  
  public static String e(String paramString)
  {
    String str = d(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(".tmp");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private void e()
  {
    PAAdPreloadTask localPAAdPreloadTask = this.g;
    if (localPAAdPreloadTask != null)
    {
      ReportController.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", localPAAdPreloadTask.mVideoVid, String.valueOf(this.g.mSource));
      return;
    }
    ReportController.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", "", "");
  }
  
  private static int f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    File localFile = new File(d(paramString));
    if ((localFile.exists()) && (localFile.length() > 0L)) {
      return 2;
    }
    paramString = new File(e(paramString));
    if ((paramString.exists()) && (paramString.length() > 0L)) {
      return 1;
    }
    return 0;
  }
  
  private void f()
  {
    if (this.h == 0)
    {
      ImaxAdUtil.c("onNetworkChange, no queue is working");
      return;
    }
    Object localObject = this.g;
    if (localObject == null)
    {
      ImaxAdUtil.c("onNetworkChange, no valid task");
      return;
    }
    if (((PAAdPreloadTask)localObject).isNetworkValid())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNetworkChange, vid:");
      ((StringBuilder)localObject).append(this.g.mVideoVid);
      ((StringBuilder)localObject).append(", networkType:");
      ((StringBuilder)localObject).append(this.g.mNetworkType);
      ((StringBuilder)localObject).append(", valid network, going on");
      ImaxAdUtil.c(((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetworkChange, vid:");
    ((StringBuilder)localObject).append(this.g.mVideoVid);
    ((StringBuilder)localObject).append(", networkType:");
    ((StringBuilder)localObject).append(this.g.mNetworkType);
    ((StringBuilder)localObject).append(", invalid network, skip to next task");
    ImaxAdUtil.c(((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      b(this.h);
    }
  }
  
  private void g(String paramString)
  {
    paramString = ImaxAdRecentUserManager.a().c(paramString).iterator();
    while (paramString.hasNext())
    {
      AdvertisementItem localAdvertisementItem = (AdvertisementItem)paramString.next();
      b(localAdvertisementItem);
      localAdvertisementItem.k = 1;
      ImaxAdUtil.b(a(), localAdvertisementItem.a, localAdvertisementItem.c());
    }
  }
  
  private void h(String paramString)
  {
    Object localObject = (QQAppInterface)this.d.get();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "";
    }
    AdvertisementStatistics.b((String)localObject, paramString);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    Object localObject1 = this.c;
    if (paramAdvertisementItem != null) {}
    try
    {
      if ((paramAdvertisementItem.g != null) && (paramAdvertisementItem.c != null) && (paramAdvertisementItem.c.size() > 0))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handlePreloadTaskFromMessage adItem ");
        ((StringBuilder)localObject2).append(paramAdvertisementItem.a);
        ImaxAdUtil.c(((StringBuilder)localObject2).toString());
        Object localObject3 = paramAdvertisementItem.g;
        localObject2 = (VideoCoverItem)paramAdvertisementItem.c.get(0);
        if (!TextUtils.isEmpty(((VideoCoverItem)localObject2).c))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = a();
          localPAAdPreloadTask.mVideoVid = ((VideoCoverItem)localObject2).c;
          if (!this.f.contains(localPAAdPreloadTask))
          {
            localPAAdPreloadTask.mMsgId = paramAdvertisementItem.d;
            localPAAdPreloadTask.mSource = 2;
            long l1;
            if (paramAdvertisementItem.e > 0L) {
              l1 = paramAdvertisementItem.e;
            } else {
              l1 = NetConnInfoCenter.getServerTimeMillis();
            }
            localPAAdPreloadTask.mReceiveTime = l1;
            localPAAdPreloadTask.mExpireTime = paramAdvertisementItem.l;
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = ((VideoDownloadItem)localObject3).u;
            this.f.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.5(this));
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject3).append(paramAdvertisementItem.d);
            ((StringBuilder)localObject3).append(", vid:");
            ((StringBuilder)localObject3).append(((VideoCoverItem)localObject2).c);
            ((StringBuilder)localObject3).append(", add to queue");
            ImaxAdUtil.c(((StringBuilder)localObject3).toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject3).append(paramAdvertisementItem.d);
            ((StringBuilder)localObject3).append(", vid:");
            ((StringBuilder)localObject3).append(((VideoCoverItem)localObject2).c);
            ((StringBuilder)localObject3).append(", exist in queue, ignore");
            ImaxAdUtil.c(((StringBuilder)localObject3).toString());
          }
        }
        return;
      }
      ImaxAdUtil.c("handlePreloadTaskFromMessage invalid item");
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ImaxAdVideoPreloadManager.4(this, paramQQAppInterface), 300L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("loadLocalConfigTaskForImax uin:");
    ((StringBuilder)???).append(paramString);
    ImaxAdUtil.c(((StringBuilder)???).toString());
    Object localObject3 = ImaxAdUtil.a(paramString);
    ??? = new ArrayList();
    Object localObject2 = new ArrayList();
    paramString = a();
    ImaxAdDeleteManager.a().c(ImaxAdUtil.b(paramString, "delete_uin_list"));
    Object localObject5;
    if (localObject3 != null)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("loadLocalConfigTaskForImax sp size:");
      ((StringBuilder)localObject4).append(((Map)localObject3).size());
      ImaxAdUtil.c(((StringBuilder)localObject4).toString());
      localObject4 = ((Map)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = AdvertisementItem.a((String)((Map)localObject3).get((String)((Iterator)localObject4).next()));
        if (localObject5 != null)
        {
          ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject5);
          ((List)???).add(localObject5);
          if ((((AdvertisementItem)localObject5).e()) || (ImaxAdDeleteManager.a().a(paramString, ((AdvertisementItem)localObject5).a)))
          {
            ((List)localObject2).add(localObject5);
            if ((((AdvertisementItem)localObject5).c != null) && (((AdvertisementItem)localObject5).c.size() > 0))
            {
              localObject5 = ((AdvertisementItem)localObject5).c.iterator();
              while (((Iterator)localObject5).hasNext()) {
                c(((VideoCoverItem)((Iterator)localObject5).next()).c);
              }
            }
          }
        }
      }
    }
    localObject3 = new ArrayList();
    Object localObject4 = ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).g();
    if (localObject4 != null)
    {
      localObject5 = ((RecentUserProxy)localObject4).a(true);
      int m = 0;
      while (m < ((List)localObject5).size())
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject5).get(m);
        Object localObject6 = ImaxAdRecentUserManager.a().b(localRecentUser.uin);
        if ((localRecentUser.getType() == 10005) && (localObject6 != null))
        {
          ((List)localObject3).add(localObject6);
          if ((((AdvertisementItem)localObject6).e()) || (ImaxAdDeleteManager.a().a(paramString, ((AdvertisementItem)localObject6).a)))
          {
            localObject6 = RecentDataListManager.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localRecentUser.uin);
            localStringBuilder.append("-");
            localStringBuilder.append(localRecentUser.getType());
            ((RecentDataListManager)localObject6).b(localStringBuilder.toString());
            ((RecentUserProxy)localObject4).a(localRecentUser);
            RecentUtil.b(paramQQAppInterface, localRecentUser.uin, 10005);
            paramQQAppInterface.getMessageFacade().a(localRecentUser.uin, 10005);
          }
        }
        m += 1;
      }
    }
    if (((List)localObject3).size() > 0) {
      a(paramQQAppInterface);
    }
    ((List)???).removeAll((Collection)localObject2);
    ImaxAdRecentUserManager.a().b();
    ImaxAdUtil.b(paramString);
    paramQQAppInterface = ((List)???).iterator();
    while (paramQQAppInterface.hasNext())
    {
      localObject4 = (AdvertisementItem)paramQQAppInterface.next();
      ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject4);
      ImaxAdUtil.b(paramString, ((AdvertisementItem)localObject4).a, ((AdvertisementItem)localObject4).c());
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("loadLocalConfigTaskForImax recentImaxAdList:");
    paramQQAppInterface.append(((List)localObject3).size());
    paramQQAppInterface.append(" expiredImaxAdList:");
    paramQQAppInterface.append(((List)localObject2).size());
    paramQQAppInterface.append(" imaxAdList:");
    paramQQAppInterface.append(((List)???).size());
    ImaxAdUtil.c(paramQQAppInterface.toString());
    paramQQAppInterface = new ArrayList();
    ??? = ((List)???).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (AdvertisementItem)((Iterator)???).next();
      if ((((AdvertisementItem)localObject2).c != null) && (((AdvertisementItem)localObject2).c.size() > 0))
      {
        localObject4 = (VideoCoverItem)((AdvertisementItem)localObject2).c.get(0);
        if (!((List)localObject3).contains(localObject2)) {
          a(paramQQAppInterface, (AdvertisementItem)localObject2, (VideoCoverItem)localObject4);
        } else if (f(((VideoCoverItem)localObject4).c) != 2) {
          a(paramQQAppInterface, (AdvertisementItem)localObject2, (VideoCoverItem)localObject4);
        }
      }
    }
    synchronized (this.c)
    {
      if (paramQQAppInterface.size() > 0)
      {
        this.f.clear();
        this.f.addAll(paramQQAppInterface);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalConfigTaskForImax taskSize:");
        ((StringBuilder)localObject2).append(paramQQAppInterface.size());
        ImaxAdUtil.c(((StringBuilder)localObject2).toString());
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.3(this));
      }
      else
      {
        ImaxAdUtil.c("loadLocalConfigTaskForImax tasklist null");
      }
      ImaxAdDeleteManager.a().d(paramString);
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("handlePreloadTaskFromGdtAd() called with: tencentVideoId = [");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append("]");
      QLog.d("ImaxAdvertisement", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.c)
    {
      PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
      localPAAdPreloadTask.mUserUin = a();
      localPAAdPreloadTask.mVideoVid = paramString;
      if (!this.f.contains(localPAAdPreloadTask))
      {
        localPAAdPreloadTask.mMsgId = MD5Utils.toMD5(localPAAdPreloadTask.mVideoVid);
        localPAAdPreloadTask.mSource = 2;
        localPAAdPreloadTask.mReceiveTime = NetConnInfoCenter.getServerTimeMillis();
        localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + 86400000L);
        localPAAdPreloadTask.mPreloadState = 1;
        this.f.add(localPAAdPreloadTask);
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.6(this));
        paramString = new StringBuilder();
        paramString.append("handlePreloadTaskFromMessage msgid:");
        paramString.append(localPAAdPreloadTask.mMsgId);
        paramString.append(", vid:");
        paramString.append(localPAAdPreloadTask.mVideoVid);
        paramString.append(", add to queue");
        ImaxAdUtil.c(paramString.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("handlePreloadTaskFromMessage msgid:");
        paramString.append(localPAAdPreloadTask.mMsgId);
        paramString.append(", vid:");
        paramString.append(localPAAdPreloadTask.mVideoVid);
        paramString.append(", exist in queue, ignore");
        ImaxAdUtil.c(paramString.toString());
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processMsg0x210Sub0xfd ");
    ((StringBuilder)localObject).append(paramInt);
    ImaxAdUtil.c(((StringBuilder)localObject).toString());
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("processMsg0x210Sub0xfd pbData == null ");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append(" threadName");
      paramArrayOfByte.append(Thread.currentThread().getName());
      QLog.e("ImaxAdvertisement", 1, paramArrayOfByte.toString());
      return;
    }
    try
    {
      paramArrayOfByte = String.valueOf(((submsgtype0xfd.MsgBody)new submsgtype0xfd.MsgBody().mergeFrom(paramArrayOfByte)).msg_AdInfo.uint64_from_uin.get());
      ImaxAdDeleteManager.a().a(paramArrayOfByte);
      ImaxAdUtil.a(a(), "delete_uin_list", ImaxAdDeleteManager.a().b());
      localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete_st_");
      localStringBuilder.append(paramArrayOfByte);
      ImaxAdUtil.a((String)localObject, localStringBuilder.toString(), String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      if (this.d.get() != null)
      {
        ImaxAdDeleteManager.a().a((QQAppInterface)this.d.get(), paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub0xfd error", paramArrayOfByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processMsg0x210Sub0xf9 ");
    ((StringBuilder)localObject).append(paramInt);
    ImaxAdUtil.c(((StringBuilder)localObject).toString());
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("processMsg0x210Sub0xf9 pbData == null ");
      paramArrayOfByte.append(paramInt);
      QLog.e("ImaxAdvertisement", 1, paramArrayOfByte.toString());
      return;
    }
    localObject = new submsgtype0xf9.MsgBody();
    try
    {
      localObject = (submsgtype0xf9.MsgBody)((submsgtype0xf9.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = null;
      if (((submsgtype0xf9.MsgBody)localObject).bytes_zip_AdInfo.has()) {
        paramArrayOfByte = ImaxAdUtil.a(((submsgtype0xf9.MsgBody)localObject).bytes_zip_AdInfo.get().toByteArray());
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        localObject = new submsgtype0xf9.AdInfo();
        ((submsgtype0xf9.AdInfo)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = AdvertisementItem.a((submsgtype0xf9.AdInfo)localObject, paramMsgInfo);
        if (ImaxAdDeleteManager.a().a(a(), paramArrayOfByte.a))
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("processMsg0x210Sub0xf9 InDeleteFilter mSenderUin ");
          paramMsgInfo.append(paramArrayOfByte.a);
          ImaxAdUtil.c(paramMsgInfo.toString());
          return;
        }
        ImaxAdRecentUserManager.a().a(paramArrayOfByte.a);
        ImaxAdRecentUserManager.a().a(paramArrayOfByte);
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("processMsg0x210Sub0xf9 sp :advertisementItem ");
        paramMsgInfo.append(paramArrayOfByte.a);
        ImaxAdUtil.c(paramMsgInfo.toString());
        ImaxAdUtil.b(a(), paramArrayOfByte.a, paramArrayOfByte.c());
        if ((paramArrayOfByte.c != null) && (paramArrayOfByte.c.size() != 0))
        {
          a(paramArrayOfByte);
          return;
        }
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("no any video resources 0xf9 error");
        paramMsgInfo.append(paramArrayOfByte.a);
        QLog.e("ImaxAdvertisement", 1, paramMsgInfo.toString());
        b(paramArrayOfByte);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("output == null ");
      paramArrayOfByte.append(paramInt);
      ImaxAdUtil.c(paramArrayOfByte.toString());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub 0xf9 error", paramArrayOfByte);
    }
  }
  
  public void onDestroy()
  {
    this.f.clear();
    Object localObject = this.j;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      this.j.removePreloadCallback();
      this.j.setOnPreLoadCompleteCallback(null);
      this.j.releasePreload(20170807);
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((ImaxAdVideoPreloadManager.NetInfoHandler)localObject).a();
      AppNetConnInfo.unregisterNetInfoHandler(this.l);
      this.l = null;
    }
    this.i = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */