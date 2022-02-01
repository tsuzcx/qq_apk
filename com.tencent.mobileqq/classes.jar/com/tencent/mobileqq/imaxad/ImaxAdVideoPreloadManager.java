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
  private static final String jdField_a_of_type_JavaLangString;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private ImaxAdVideoPreloadManager.NetInfoHandler jdField_a_of_type_ComTencentMobileqqImaxadImaxAdVideoPreloadManager$NetInfoHandler;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<PAAdPreloadTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
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
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    File localFile = new File(a(paramString));
    if ((localFile.exists()) && (localFile.length() > 0L)) {
      return 2;
    }
    paramString = new File(b(paramString));
    if ((paramString.exists()) && (paramString.length() > 0L)) {
      return 1;
    }
    return 0;
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
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentUin();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(String.valueOf(20170807));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
    }
    return "";
  }
  
  private void a()
  {
    ImaxAdUtil.b("installTVKSdk");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo(a(), "");
    this.jdField_a_of_type_ComTencentMobileqqImaxadImaxAdVideoPreloadManager$NetInfoHandler = new ImaxAdVideoPreloadManager.NetInfoHandler(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqImaxadImaxAdVideoPreloadManager$NetInfoHandler);
    try
    {
      TVK_SDKMgr.setOnLogListener(new ImaxAdVideoPreloadManager.1(this));
      TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", a());
      if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
      {
        TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new ImaxAdVideoPreloadManager.2(this));
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
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startVideoDownload queueType:");
        ((StringBuilder)localObject2).append(paramInt);
        ImaxAdUtil.b(((StringBuilder)localObject2).toString());
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)
        {
          ImaxAdUtil.b("startVideoDownload cache manager not init!");
          c();
          return;
        }
        if (paramInt <= this.jdField_a_of_type_Int)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload queue(");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(") already run!");
          ImaxAdUtil.b(((StringBuilder)localObject2).toString());
          return;
        }
        if (this.jdField_a_of_type_Int != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startVideoDownload break current queue(");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(")!");
          ImaxAdUtil.b(((StringBuilder)localObject2).toString());
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
          c();
          break label843;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
            this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_a_of_type_JavaUtilArrayList.remove(0));
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
          {
            ImaxAdUtil.b("startVideoDownload no task to download");
            c();
            return;
          }
          this.jdField_a_of_type_Int = paramInt;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (!this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isExpire())
            {
              i = a((String)localObject2);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("startVideoDownload vid:");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(", cacheState:");
              ((StringBuilder)localObject4).append(i);
              ImaxAdUtil.b(((StringBuilder)localObject4).toString());
              if (i != 2) {
                if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
                {
                  localObject4 = b((String)localObject2);
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
          ImaxAdUtil.b(((StringBuilder)localObject5).toString());
          localObject5 = new TVK_PlayerVideoInfo(2, (String)localObject2, "");
          localHashMap = new HashMap();
          localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
          ((TVK_PlayerVideoInfo)localObject5).setReportInfoMap(localHashMap);
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_duration", String.valueOf(-1));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("cache_servers_type", String.valueOf(20170807));
          ((TVK_PlayerVideoInfo)localObject5).setConfigMap("file_dir", (String)localObject4);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, (TVK_PlayerVideoInfo)localObject5, "");
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ImaxAdUtil.b(((StringBuilder)localObject4).toString());
          continue;
          int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", networkType:");
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType);
          ((StringBuilder)localObject4).append(", curNetType:");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append(", no valid network, skip to next task");
          ImaxAdUtil.b(((StringBuilder)localObject4).toString());
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
          c((String)localObject2);
          b(paramInt);
          continue;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startVideoDownload vid:");
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(", expireTime:");
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime);
          ((StringBuilder)localObject4).append(", task expired, clean cache and skip to next task");
          ImaxAdUtil.b(((StringBuilder)localObject4).toString());
          b(paramInt);
          if (a((String)localObject2) != 0)
          {
            ThreadManager.executeOnFileThread(new ImaxAdVideoPreloadManager.7(this, (String)localObject2));
            continue;
            ImaxAdUtil.b("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
          return;
        }
      }
      label843:
      if (paramInt == 2) {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy)
  {
    Object localObject1 = (AdvertisementItem)paramMessageRecord.advertisementItem;
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
        localObject3 = paramRecentUserProxy.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localObject3 != null)
        {
          RecentDataListManager localRecentDataListManager = RecentDataListManager.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageRecord.frienduin);
          localStringBuilder.append("-");
          localStringBuilder.append(paramMessageRecord.istroop);
          localRecentDataListManager.a(localStringBuilder.toString());
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
    VideoDownloadItem localVideoDownloadItem = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    localPAAdPreloadTask.mUserUin = a();
    localPAAdPreloadTask.mVideoVid = paramVideoCoverItem.b;
    localPAAdPreloadTask.mMsgId = paramAdvertisementItem.jdField_c_of_type_JavaLangString;
    localPAAdPreloadTask.mSource = 2;
    long l;
    if (paramAdvertisementItem.jdField_a_of_type_Long > 0L) {
      l = paramAdvertisementItem.jdField_a_of_type_Long;
    } else {
      l = NetConnInfoCenter.getServerTimeMillis();
    }
    localPAAdPreloadTask.mReceiveTime = l;
    localPAAdPreloadTask.mExpireTime = paramAdvertisementItem.b;
    localPAAdPreloadTask.mPreloadState = 1;
    localPAAdPreloadTask.mNetworkType = localVideoDownloadItem.e;
    paramList.add(localPAAdPreloadTask);
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString) == 2;
  }
  
  public static String b(String paramString)
  {
    String str = a(paramString);
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
  
  private void b()
  {
    ImaxAdUtil.b("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new ImaxAdVideoPreloadManager.PreloadCallback(this, null));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(new ImaxAdVideoPreloadManager.PreloadCompleteCallback(this, null));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("continueDownload queueType:");
    localStringBuilder.append(paramInt);
    ImaxAdUtil.b(localStringBuilder.toString());
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
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
      ((StringBuilder)localObject).append(paramAdvertisementItem.jdField_a_of_type_JavaLangString);
      QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
    ((QQAppInterface)localObject).getConversationFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop).isImax = true;
    a((QQAppInterface)localObject);
  }
  
  public static void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clearCacheVideo vid:");
    ((StringBuilder)localObject).append(paramString);
    ImaxAdUtil.b(((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new File(b(paramString));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramString = new File(a(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
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
    paramString = ImaxAdRecentUserManager.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      AdvertisementItem localAdvertisementItem = (AdvertisementItem)paramString.next();
      b(localAdvertisementItem);
      localAdvertisementItem.jdField_a_of_type_Int = 1;
      ImaxAdUtil.b(a(), localAdvertisementItem.jdField_a_of_type_JavaLangString, localAdvertisementItem.a());
    }
  }
  
  private void d()
  {
    PAAdPreloadTask localPAAdPreloadTask = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
    if (localPAAdPreloadTask != null)
    {
      ReportController.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", localPAAdPreloadTask.mVideoVid, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mSource));
      return;
    }
    ReportController.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", "", "");
  }
  
  private void d(String paramString)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "";
    }
    AdvertisementStatistics.b((String)localObject, paramString);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ImaxAdUtil.b("onNetworkChange, no queue is working");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
    if (localObject == null)
    {
      ImaxAdUtil.b("onNetworkChange, no valid task");
      return;
    }
    if (((PAAdPreloadTask)localObject).isNetworkValid())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNetworkChange, vid:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid);
      ((StringBuilder)localObject).append(", networkType:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType);
      ((StringBuilder)localObject).append(", valid network, going on");
      ImaxAdUtil.b(((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetworkChange, vid:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid);
    ((StringBuilder)localObject).append(", networkType:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType);
    ((StringBuilder)localObject).append(", invalid network, skip to next task");
    ImaxAdUtil.b(((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramAdvertisementItem != null) {}
    try
    {
      if ((paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handlePreloadTaskFromMessage adItem ");
        ((StringBuilder)localObject2).append(paramAdvertisementItem.jdField_a_of_type_JavaLangString);
        ImaxAdUtil.b(((StringBuilder)localObject2).toString());
        Object localObject3 = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
        localObject2 = (VideoCoverItem)paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!TextUtils.isEmpty(((VideoCoverItem)localObject2).b))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = a();
          localPAAdPreloadTask.mVideoVid = ((VideoCoverItem)localObject2).b;
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask))
          {
            localPAAdPreloadTask.mMsgId = paramAdvertisementItem.jdField_c_of_type_JavaLangString;
            localPAAdPreloadTask.mSource = 2;
            long l;
            if (paramAdvertisementItem.jdField_a_of_type_Long > 0L) {
              l = paramAdvertisementItem.jdField_a_of_type_Long;
            } else {
              l = NetConnInfoCenter.getServerTimeMillis();
            }
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = paramAdvertisementItem.b;
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = ((VideoDownloadItem)localObject3).e;
            this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.5(this));
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject3).append(paramAdvertisementItem.jdField_c_of_type_JavaLangString);
            ((StringBuilder)localObject3).append(", vid:");
            ((StringBuilder)localObject3).append(((VideoCoverItem)localObject2).b);
            ((StringBuilder)localObject3).append(", add to queue");
            ImaxAdUtil.b(((StringBuilder)localObject3).toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handlePreloadTaskFromMessage msgid:");
            ((StringBuilder)localObject3).append(paramAdvertisementItem.jdField_c_of_type_JavaLangString);
            ((StringBuilder)localObject3).append(", vid:");
            ((StringBuilder)localObject3).append(((VideoCoverItem)localObject2).b);
            ((StringBuilder)localObject3).append(", exist in queue, ignore");
            ImaxAdUtil.b(((StringBuilder)localObject3).toString());
          }
        }
        return;
      }
      ImaxAdUtil.b("handlePreloadTaskFromMessage invalid item");
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
    ImaxAdUtil.b(((StringBuilder)???).toString());
    Object localObject3 = ImaxAdUtil.a(paramString);
    ??? = new ArrayList();
    Object localObject2 = new ArrayList();
    paramString = a();
    ImaxAdDeleteManager.a().b(ImaxAdUtil.a(paramString, "delete_uin_list"));
    Object localObject5;
    if (localObject3 != null)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("loadLocalConfigTaskForImax sp size:");
      ((StringBuilder)localObject4).append(((Map)localObject3).size());
      ImaxAdUtil.b(((StringBuilder)localObject4).toString());
      localObject4 = ((Map)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = AdvertisementItem.a((String)((Map)localObject3).get((String)((Iterator)localObject4).next()));
        if (localObject5 != null)
        {
          ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject5);
          ((List)???).add(localObject5);
          if ((((AdvertisementItem)localObject5).c()) || (ImaxAdDeleteManager.a().a(paramString, ((AdvertisementItem)localObject5).jdField_a_of_type_JavaLangString)))
          {
            ((List)localObject2).add(localObject5);
            if ((((AdvertisementItem)localObject5).jdField_a_of_type_JavaUtilArrayList != null) && (((AdvertisementItem)localObject5).jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              localObject5 = ((AdvertisementItem)localObject5).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject5).hasNext()) {
                b(((VideoCoverItem)((Iterator)localObject5).next()).b);
              }
            }
          }
        }
      }
    }
    localObject3 = new ArrayList();
    Object localObject4 = ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).a();
    if (localObject4 != null)
    {
      localObject5 = ((RecentUserProxy)localObject4).a(true);
      int i = 0;
      while (i < ((List)localObject5).size())
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject5).get(i);
        Object localObject6 = ImaxAdRecentUserManager.a().b(localRecentUser.uin);
        if ((localRecentUser.getType() == 10005) && (localObject6 != null))
        {
          ((List)localObject3).add(localObject6);
          if ((((AdvertisementItem)localObject6).c()) || (ImaxAdDeleteManager.a().a(paramString, ((AdvertisementItem)localObject6).jdField_a_of_type_JavaLangString)))
          {
            localObject6 = RecentDataListManager.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localRecentUser.uin);
            localStringBuilder.append("-");
            localStringBuilder.append(localRecentUser.getType());
            ((RecentDataListManager)localObject6).a(localStringBuilder.toString());
            ((RecentUserProxy)localObject4).a(localRecentUser);
            RecentUtil.b(paramQQAppInterface, localRecentUser.uin, 10005);
            paramQQAppInterface.getMessageFacade().a(localRecentUser.uin, 10005);
          }
        }
        i += 1;
      }
    }
    if (((List)localObject3).size() > 0) {
      a(paramQQAppInterface);
    }
    ((List)???).removeAll((Collection)localObject2);
    ImaxAdRecentUserManager.a().a();
    ImaxAdUtil.a(paramString);
    paramQQAppInterface = ((List)???).iterator();
    while (paramQQAppInterface.hasNext())
    {
      localObject4 = (AdvertisementItem)paramQQAppInterface.next();
      ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject4);
      ImaxAdUtil.b(paramString, ((AdvertisementItem)localObject4).jdField_a_of_type_JavaLangString, ((AdvertisementItem)localObject4).a());
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("loadLocalConfigTaskForImax recentImaxAdList:");
    paramQQAppInterface.append(((List)localObject3).size());
    paramQQAppInterface.append(" expiredImaxAdList:");
    paramQQAppInterface.append(((List)localObject2).size());
    paramQQAppInterface.append(" imaxAdList:");
    paramQQAppInterface.append(((List)???).size());
    ImaxAdUtil.b(paramQQAppInterface.toString());
    paramQQAppInterface = new ArrayList();
    ??? = ((List)???).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (AdvertisementItem)((Iterator)???).next();
      if ((((AdvertisementItem)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (((AdvertisementItem)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject4 = (VideoCoverItem)((AdvertisementItem)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!((List)localObject3).contains(localObject2)) {
          a(paramQQAppInterface, (AdvertisementItem)localObject2, (VideoCoverItem)localObject4);
        } else if (a(((VideoCoverItem)localObject4).b) != 2) {
          a(paramQQAppInterface, (AdvertisementItem)localObject2, (VideoCoverItem)localObject4);
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramQQAppInterface.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalConfigTaskForImax taskSize:");
        ((StringBuilder)localObject2).append(paramQQAppInterface.size());
        ImaxAdUtil.b(((StringBuilder)localObject2).toString());
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.3(this));
      }
      else
      {
        ImaxAdUtil.b("loadLocalConfigTaskForImax tasklist null");
      }
      ImaxAdDeleteManager.a().c(paramString);
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
      localPAAdPreloadTask.mUserUin = a();
      localPAAdPreloadTask.mVideoVid = paramString;
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask))
      {
        localPAAdPreloadTask.mMsgId = MD5Utils.toMD5(localPAAdPreloadTask.mVideoVid);
        localPAAdPreloadTask.mSource = 2;
        localPAAdPreloadTask.mReceiveTime = NetConnInfoCenter.getServerTimeMillis();
        localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + 86400000L);
        localPAAdPreloadTask.mPreloadState = 1;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.6(this));
        paramString = new StringBuilder();
        paramString.append("handlePreloadTaskFromMessage msgid:");
        paramString.append(localPAAdPreloadTask.mMsgId);
        paramString.append(", vid:");
        paramString.append(localPAAdPreloadTask.mVideoVid);
        paramString.append(", add to queue");
        ImaxAdUtil.b(paramString.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("handlePreloadTaskFromMessage msgid:");
        paramString.append(localPAAdPreloadTask.mMsgId);
        paramString.append(", vid:");
        paramString.append(localPAAdPreloadTask.mVideoVid);
        paramString.append(", exist in queue, ignore");
        ImaxAdUtil.b(paramString.toString());
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processMsg0x210Sub0xfd ");
    ((StringBuilder)localObject).append(paramInt);
    ImaxAdUtil.b(((StringBuilder)localObject).toString());
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
      ImaxAdUtil.a(a(), "delete_uin_list", ImaxAdDeleteManager.a().a());
      localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete_st_");
      localStringBuilder.append(paramArrayOfByte);
      ImaxAdUtil.a((String)localObject, localStringBuilder.toString(), String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ImaxAdDeleteManager.a().a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramArrayOfByte);
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
    ImaxAdUtil.b(((StringBuilder)localObject).toString());
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
        if (ImaxAdDeleteManager.a().a(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString))
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("processMsg0x210Sub0xf9 InDeleteFilter mSenderUin ");
          paramMsgInfo.append(paramArrayOfByte.jdField_a_of_type_JavaLangString);
          ImaxAdUtil.b(paramMsgInfo.toString());
          return;
        }
        ImaxAdRecentUserManager.a().a(paramArrayOfByte.jdField_a_of_type_JavaLangString);
        ImaxAdRecentUserManager.a().a(paramArrayOfByte);
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("processMsg0x210Sub0xf9 sp :advertisementItem ");
        paramMsgInfo.append(paramArrayOfByte.jdField_a_of_type_JavaLangString);
        ImaxAdUtil.b(paramMsgInfo.toString());
        ImaxAdUtil.b(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.a());
        if ((paramArrayOfByte.jdField_a_of_type_JavaUtilArrayList != null) && (paramArrayOfByte.jdField_a_of_type_JavaUtilArrayList.size() != 0))
        {
          a(paramArrayOfByte);
          return;
        }
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("no any video resources 0xf9 error");
        paramMsgInfo.append(paramArrayOfByte.jdField_a_of_type_JavaLangString);
        QLog.e("ImaxAdvertisement", 1, paramMsgInfo.toString());
        b(paramArrayOfByte);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("output == null ");
      paramArrayOfByte.append(paramInt);
      ImaxAdUtil.b(paramArrayOfByte.toString());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub 0xf9 error", paramArrayOfByte);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localObject != null)
    {
      ((TVK_ICacheMgr)localObject).stopCacheData(20170807);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(20170807);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqImaxadImaxAdVideoPreloadManager$NetInfoHandler;
    if (localObject != null)
    {
      ((ImaxAdVideoPreloadManager.NetInfoHandler)localObject).a();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqImaxadImaxAdVideoPreloadManager$NetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqImaxadImaxAdVideoPreloadManager$NetInfoHandler = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */