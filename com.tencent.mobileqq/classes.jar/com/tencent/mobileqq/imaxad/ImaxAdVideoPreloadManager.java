package com.tencent.mobileqq.imaxad;

import OnlinePushPack.MsgInfo;
import aebg;
import aebh;
import aebi;
import aebj;
import aebk;
import aebl;
import aebm;
import aebn;
import aebo;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class ImaxAdVideoPreloadManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private int jdField_a_of_type_Int = 0;
  private aebm jdField_a_of_type_Aebm;
  private Context jdField_a_of_type_AndroidContentContext;
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public ImaxAdVideoPreloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication().getApplicationContext();
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      File localFile = new File(a(paramString));
      if ((localFile.exists()) && (localFile.length() > 0L)) {
        return 2;
      }
      paramString = new File(b(paramString));
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return 1;
  }
  
  private static MessageRecord a(String paramString, AdvertisementItem paramAdvertisementItem)
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.selfuin = paramString;
    localMessageRecord.frienduin = paramAdvertisementItem.jdField_a_of_type_JavaLangString;
    localMessageRecord.senderuin = paramAdvertisementItem.jdField_a_of_type_JavaLangString;
    localMessageRecord.msgtype = -1000;
    localMessageRecord.msg = paramAdvertisementItem.f;
    localMessageRecord.time = paramAdvertisementItem.jdField_c_of_type_Long;
    localMessageRecord.shmsgseq = paramAdvertisementItem.jdField_a_of_type_Short;
    localMessageRecord.msgUid = paramAdvertisementItem.d;
    localMessageRecord.istroop = 10005;
    localMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "1");
    return localMessageRecord;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      str1 = str2;
      if (localFile.exists())
      {
        str1 = str2;
        if (localFile.isDirectory()) {
          str1 = jdField_a_of_type_JavaLangString + String.valueOf(20170807) + "_" + paramString;
        }
      }
    }
    return str1;
  }
  
  private void a()
  {
    ImaxAdUtil.b("installTVKSdk");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo(a(), "");
    this.jdField_a_of_type_Aebm = new aebm(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aebm);
    try
    {
      TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", a());
      if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
      {
        TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new aebg(this));
        return;
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ImaxAdvertisement", 2, "installTVKSdk ", localThrowable);
    }
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ImaxAdUtil.b("startVideoDownload queueType:" + paramInt);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)
      {
        ImaxAdUtil.b("startVideoDownload cache manager not init!");
        c();
        return;
      }
      if (paramInt <= this.jdField_a_of_type_Int)
      {
        ImaxAdUtil.b("startVideoDownload queue(" + this.jdField_a_of_type_Int + ") already run!");
        return;
      }
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      ImaxAdUtil.b("startVideoDownload break current queue(" + this.jdField_a_of_type_Int + ")!");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        ImaxAdUtil.b("startVideoDownload no task to download");
        c();
        return;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_a_of_type_JavaUtilArrayList.remove(0));
        }
      }
      else
      {
        this.jdField_a_of_type_Int = paramInt;
        String str1 = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid;
        int i;
        String str2;
        Object localObject3;
        if (!TextUtils.isEmpty(str1)) {
          if (!this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isExpire())
          {
            i = a(str1);
            ImaxAdUtil.b("startVideoDownload vid:" + str1 + ", cacheState:" + i);
            if (i != 2) {
              if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
              {
                str2 = b(str1);
                localObject3 = new File(str2);
                boolean bool = ((File)localObject3).exists();
                if (bool) {}
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            ((File)localObject3).createNewFile();
            localObject3 = new TVK_PlayerVideoInfo(2, str1, "");
            HashMap localHashMap = new HashMap();
            localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
            ((TVK_PlayerVideoInfo)localObject3).setReportInfoMap(localHashMap);
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("cache_duration", String.valueOf(-1));
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("cache_servers_type", String.valueOf(20170807));
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("file_dir", str2);
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, (TVK_PlayerVideoInfo)localObject3, "");
            ImaxAdUtil.b("startVideoDownload vid:" + str1);
            return;
          }
          catch (IOException localIOException)
          {
            ImaxAdUtil.b("startVideoDownload create tmp file failed for vid:" + str1);
            continue;
          }
          i = NetworkUtil.a(BaseApplication.getContext());
          ImaxAdUtil.b("startVideoDownload vid:" + str1 + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", curNetType:" + i + ", no valid network, skip to next task");
          b(paramInt);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "vid:" + str1 + ", full cached, skip to next task");
          }
          b(str1);
          b(paramInt);
          continue;
          ImaxAdUtil.b("startVideoDownload vid:" + str1 + ", expireTime:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime + ", task expired, clean cache and skip to next task");
          b(paramInt);
          if (a(str1) != 0)
          {
            ThreadManager.executeOnFileThread(new aebk(this, str1));
            continue;
            ImaxAdUtil.b("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
        }
        switch (paramInt)
        {
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new aebi(this, paramQQAppInterface), 300L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy)
  {
    Object localObject1 = paramMessageRecord.advertisementItem;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString)))
    {
      ImaxAdRecentUserManager.a().a(((AdvertisementItem)localObject1).jdField_a_of_type_JavaLangString);
      ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject1);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString);
      if (((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((AdvertisementItem)localObject1).jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_uin_head_url", ((AdvertisementItem)localObject1).e);
      localObject2 = paramEntityManager.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
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
        paramEntityManager.b((Entity)localObject2);
        RecentUtil.b(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
        localObject3 = paramRecentUserProxy.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localObject3 != null)
        {
          RecentDataListManager.a().a(paramMessageRecord.frienduin + "-" + paramMessageRecord.istroop);
          paramRecentUserProxy.b((RecentUser)localObject3);
        }
        paramQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, 10005, true, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "isImaxAdMessage: 0");
        }
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
      }
    }
  }
  
  public static void a(String paramString)
  {
    ImaxAdUtil.b("clearCacheVideo vid:" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(b(paramString));
      if (localFile.exists()) {
        localFile.delete();
      }
      paramString = new File(a(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void a(List paramList, AdvertisementItem paramAdvertisementItem, VideoCoverItem paramVideoCoverItem)
  {
    PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
    VideoDownloadItem localVideoDownloadItem = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    localPAAdPreloadTask.mUserUin = a();
    localPAAdPreloadTask.mVideoVid = paramVideoCoverItem.b;
    localPAAdPreloadTask.mMsgId = paramAdvertisementItem.jdField_c_of_type_JavaLangString;
    localPAAdPreloadTask.mSource = 2;
    if (paramAdvertisementItem.jdField_a_of_type_Long > 0L) {}
    for (long l = paramAdvertisementItem.jdField_a_of_type_Long;; l = NetConnInfoCenter.getServerTimeMillis())
    {
      localPAAdPreloadTask.mReceiveTime = l;
      localPAAdPreloadTask.mExpireTime = paramAdvertisementItem.b;
      localPAAdPreloadTask.mPreloadState = 1;
      localPAAdPreloadTask.mNetworkType = localVideoDownloadItem.e;
      paramList.add(localPAAdPreloadTask);
      return;
    }
  }
  
  public static String b(String paramString)
  {
    String str = a(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str)) {
      paramString = str + ".tmp";
    }
    return paramString;
  }
  
  private void b()
  {
    ImaxAdUtil.b("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new aebn(this, null));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(new aebo(this, null));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    ImaxAdUtil.b("continueDownload queueType:" + paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
    ThreadManager.executeOnNetWorkThread(new aebl(this, paramInt));
  }
  
  private void b(AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 advertisementItem == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "insertToMsgSystem 0xf9 advertisementItem:" + paramAdvertisementItem.jdField_a_of_type_JavaLangString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 QQAppInterface == null");
      return;
    }
    String str = localQQAppInterface.getCurrentAccountUin();
    MessageRecord localMessageRecord = a(str, paramAdvertisementItem);
    localMessageRecord.advertisementItem = paramAdvertisementItem;
    paramAdvertisementItem = new ArrayList();
    paramAdvertisementItem.add(localMessageRecord);
    localQQAppInterface.a().a(paramAdvertisementItem, str, false, true, true);
    localQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop).isImax = true;
    a(localQQAppInterface);
  }
  
  private void b(String paramString)
  {
    paramString = ImaxAdRecentUserManager.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      AdvertisementItem localAdvertisementItem = (AdvertisementItem)paramString.next();
      b(localAdvertisementItem);
      localAdvertisementItem.jdField_a_of_type_Int = 1;
      ImaxAdUtil.a(a(), localAdvertisementItem.jdField_a_of_type_JavaLangString, localAdvertisementItem.a());
    }
  }
  
  private void c()
  {
    ImaxAdUtil.b("resetDownload");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
  }
  
  private void c(String paramString)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      AdvertisementStatistics.b((String)localObject, paramString);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask != null)
    {
      ReportController.b(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mSource));
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 0) {
      ImaxAdUtil.b("onNetworkChange, no queue is working");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        ImaxAdUtil.b("onNetworkChange, no valid task");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
      {
        ImaxAdUtil.b("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", valid network, going on");
        return;
      }
      ImaxAdUtil.b("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", invalid network, skip to next task");
    } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramAdvertisementItem != null) {}
    for (;;)
    {
      VideoCoverItem localVideoCoverItem;
      try
      {
        if ((paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem == null) || (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
        {
          ImaxAdUtil.b("handlePreloadTaskFromMessage invalid item");
          return;
        }
        ImaxAdUtil.b("handlePreloadTaskFromMessage adItem " + paramAdvertisementItem.jdField_a_of_type_JavaLangString);
        VideoDownloadItem localVideoDownloadItem = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
        localVideoCoverItem = (VideoCoverItem)paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!TextUtils.isEmpty(localVideoCoverItem.b))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = a();
          localPAAdPreloadTask.mVideoVid = localVideoCoverItem.b;
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask)) {
            break label287;
          }
          localPAAdPreloadTask.mMsgId = paramAdvertisementItem.jdField_c_of_type_JavaLangString;
          localPAAdPreloadTask.mSource = 2;
          if (paramAdvertisementItem.jdField_a_of_type_Long > 0L)
          {
            l = paramAdvertisementItem.jdField_a_of_type_Long;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = paramAdvertisementItem.b;
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = localVideoDownloadItem.e;
            this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new aebj(this));
            ImaxAdUtil.b("handlePreloadTaskFromMessage msgid:" + paramAdvertisementItem.jdField_c_of_type_JavaLangString + ", vid:" + localVideoCoverItem.b + ", add to queue");
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      long l = NetConnInfoCenter.getServerTimeMillis();
      continue;
      label287:
      ImaxAdUtil.b("handlePreloadTaskFromMessage msgid:" + paramAdvertisementItem.jdField_c_of_type_JavaLangString + ", vid:" + localVideoCoverItem.b + ", exist in queue, ignore");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String arg2)
  {
    ImaxAdUtil.b("loadLocalConfigTaskForImax uin:" + ???);
    Object localObject2 = ImaxAdUtil.a(???);
    ??? = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject4;
    if (localObject2 != null)
    {
      ImaxAdUtil.b("loadLocalConfigTaskForImax sp size:" + ((Map)localObject2).size());
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = AdvertisementItem.a((String)((Map)localObject2).get((String)((Iterator)localObject3).next()));
        if (localObject4 != null)
        {
          ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject4);
          ???.add(localObject4);
          if (((AdvertisementItem)localObject4).c())
          {
            ((List)localObject1).add(localObject4);
            if ((((AdvertisementItem)localObject4).jdField_a_of_type_JavaUtilArrayList != null) && (((AdvertisementItem)localObject4).jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              localObject4 = ((AdvertisementItem)localObject4).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject4).hasNext()) {
                a(((VideoCoverItem)((Iterator)localObject4).next()).b);
              }
            }
          }
        }
      }
    }
    localObject2 = new ArrayList();
    Object localObject3 = ((ProxyManager)paramQQAppInterface.getManager(17)).a();
    if (localObject3 != null)
    {
      localObject4 = ((RecentUserProxy)localObject3).a(true);
      int i = 0;
      while (i < ((List)localObject4).size())
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject4).get(i);
        AdvertisementItem localAdvertisementItem = ImaxAdRecentUserManager.a().a(localRecentUser.uin);
        if ((localRecentUser.type == 10005) && (localAdvertisementItem != null))
        {
          ((List)localObject2).add(localAdvertisementItem);
          if (localAdvertisementItem.c())
          {
            RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
            ((RecentUserProxy)localObject3).b(localRecentUser);
            RecentUtil.b(paramQQAppInterface, localRecentUser.uin, 10005);
            paramQQAppInterface.a().c(localRecentUser.uin, 10005);
          }
        }
        i += 1;
      }
    }
    if (((List)localObject2).size() > 0) {
      a(paramQQAppInterface);
    }
    ???.removeAll((Collection)localObject1);
    paramQQAppInterface = a();
    ImaxAdRecentUserManager.a().a();
    ImaxAdUtil.a(paramQQAppInterface);
    localObject3 = ???.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (AdvertisementItem)((Iterator)localObject3).next();
      ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject4);
      ImaxAdUtil.a(paramQQAppInterface, ((AdvertisementItem)localObject4).jdField_a_of_type_JavaLangString, ((AdvertisementItem)localObject4).a());
    }
    ImaxAdUtil.b("loadLocalConfigTaskForImax recentImaxAdList:" + ((List)localObject2).size() + " expiredImaxAdList:" + ((List)localObject1).size() + " imaxAdList:" + ???.size());
    paramQQAppInterface = new ArrayList();
    ??? = ???.iterator();
    while (???.hasNext())
    {
      localObject1 = (AdvertisementItem)???.next();
      if ((((AdvertisementItem)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (((AdvertisementItem)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject3 = (VideoCoverItem)((AdvertisementItem)localObject1).jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!((List)localObject2).contains(localObject1)) {
          a(paramQQAppInterface, (AdvertisementItem)localObject1, (VideoCoverItem)localObject3);
        } else if (a(((VideoCoverItem)localObject3).b) != 2) {
          a(paramQQAppInterface, (AdvertisementItem)localObject1, (VideoCoverItem)localObject3);
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramQQAppInterface.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
        ImaxAdUtil.b("loadLocalConfigTaskForImax taskSize:" + paramQQAppInterface.size());
        ThreadManager.executeOnNetWorkThread(new aebh(this));
        return;
      }
      ImaxAdUtil.b("loadLocalConfigTaskForImax tasklist null");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub0xf9 pbData == null " + paramInt);
      return;
    }
    Object localObject = new submsgtype0xf9.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (submsgtype0xf9.MsgBody)((submsgtype0xf9.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!paramArrayOfByte.bytes_zip_AdInfo.has()) {
          break label261;
        }
        paramArrayOfByte = ImaxAdUtil.a(paramArrayOfByte.bytes_zip_AdInfo.get().toByteArray());
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          ImaxAdUtil.b("output == null " + paramInt);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub 0xf9 error", paramArrayOfByte);
        return;
      }
      localObject = new submsgtype0xf9.AdInfo();
      ((submsgtype0xf9.AdInfo)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = AdvertisementItem.a((submsgtype0xf9.AdInfo)localObject, paramMsgInfo);
      ImaxAdRecentUserManager.a().a(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      ImaxAdRecentUserManager.a().a(paramArrayOfByte);
      ImaxAdUtil.b("processMsg0x210Sub0xf9 sp :advertisementItem " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
      ImaxAdUtil.a(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.a());
      if ((paramArrayOfByte.jdField_a_of_type_JavaUtilArrayList == null) || (paramArrayOfByte.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        QLog.e("ImaxAdvertisement", 1, "no any video resources 0xf9 error" + paramArrayOfByte.jdField_a_of_type_JavaLangString);
        b(paramArrayOfByte);
        return;
      }
      a(paramArrayOfByte);
      return;
      label261:
      paramArrayOfByte = null;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(null);
    }
    if (this.jdField_a_of_type_Aebm != null)
    {
      this.jdField_a_of_type_Aebm.a();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Aebm);
      this.jdField_a_of_type_Aebm = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */