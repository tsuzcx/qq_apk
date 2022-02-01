package cooperation.qzone;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerReportItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.chat.NotificationBannerManager;
import com.tencent.mobileqq.config.business.NotificationBannerBean;
import com.tencent.mobileqq.config.business.NotificationBannerConfProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.PicAioQzonePreSendMgr;
import com.tencent.mobileqq.qcircle.api.requests.QCircleDoFollowRequest;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;
import cooperation.qzone.feed.CertifiedFakeFeed;
import cooperation.qzone.util.QzonePublicAccountHelper;
import eipc.EIPCResult;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneIPCModule
  extends QIPCModule
{
  public static final String ACTION_CLOSE_PUSH_SETTING_BANNER = "action_qzone_close_push_setting_banner";
  public static final String ACTION_EXTEND_FORBIDDEN = "action_extend_forbidden";
  public static final String ACTION_EXTEND_REPORT = "action_extend_report";
  public static final String ACTION_GET_HOST_INFO = "getHostInfo";
  public static final String ACTION_GET_THEMEID = "action_qzone_get_themeid";
  public static final String ACTION_IS_FLUTTER_EXTEND = "action_is_flutter_extend";
  public static final String ACTION_IS_FRIEND = "isFriend";
  public static final String ACTION_PRE_PULL_MINI_APP = "action_pre_pull_mini_app";
  public static final String ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE";
  public static final String ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE";
  public static final String ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE";
  public static final String ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH";
  public static final String ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST";
  public static final String ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED";
  public static final String ACTION_PUBLIC_ACCOUNT_UNFOLLOW = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW";
  public static final String ACTION_QCIRCLE_FAKE_FEED_DELETE = "cooperation.qzone.ACTION_QCIRCLE_FAKE_FEED_DELETE";
  public static final String ACTION_QCIRCLE_GET_TASK_LIST = "cooperation.qzone.ACTION_QCIRCLE_GET_TASK_LIST";
  public static final String ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT";
  public static final String ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS";
  public static final String ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO";
  public static final String ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG";
  public static final String ACTION_QCIRCLE_PUBLISH_REPORT = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_REPORT";
  public static final String ACTION_QCIRCLE_PULISH_FEED = "cooperation.qzone.ACTION_QCIRCLE_PULISH_FEED";
  public static final String ACTION_QCIRCLE_QUEUE_CHANGED = "cooperation.qzone.ACTION_QCIRCLE_QUEUE_CHANGED";
  public static final String ACTION_QQCIRCLE_FAKE_FEED_CREATE = "cooperation.qzone.ACTION_QQCIRCLE_FAKE_FEED_CREATE";
  public static final String ACTION_QZONE_FLOW_QQ_CIRCLE = "action_qzone_follow_qq_circle";
  public static final String ACTION_QZONE_GET_STICKER_REC_GIF = "action_qzone_get_sticker_rec_gif";
  public static final String ACTION_QZONE_MAIN_PROCESS_PROP_GET = "action_qzone_main_process_prop_get";
  public static final String ACTION_QZONE_MAIN_PROCESS_PROP_SET = "action_qzone_main_process_prop_set";
  public static final String ACTION_QZONE_PIC_PRE_SEND = "action_qzone_pic_pre_send";
  public static final String ACTION_QZONE_PRELOAD_CM_DATA = "action_qzone_preload_cm_data";
  public static final String ACTION_QZONE_REPORT_STICKER_GIF = "action_qzone_report_sticker_gif";
  public static final String ACTION_QZONE_SEND_EVENT = "action_qzone_send_event";
  public static final String ACTION_SAVE_CUSTOMEMOTION = "action_save_customenotion";
  public static final String ACTION_SHOW_PUSH_SETTING_BANNER = "action_qzone_show_push_setting_banner";
  public static final String ACTION_START_DOWNLOAD_VOICECHANGE_SO = "startDownloadVoicechangeSo";
  public static final String BUNDLE_KEY_FEED_BYTE_ARRAY = "bundle_key_feed_byte_array";
  public static final String EXTEND_KEY_FORBIDDEN_END_TIME = "forbidden_end_time";
  public static final String EXTEND_KEY_IS_FORBIDDEN = "is_forbidden";
  public static final String MINIAPP_PRELOAD_ENTRY_PATH = "miniapp_preload_entry_path";
  public static final String MINIAPP_PRELOAD_ID = "miniapp_preload_id";
  public static final String MINIAPP_PRELOAD_LINK = "miniapp_preload_link";
  public static final String MINIAPP_PRELOAD_LINK_TYPE = "miniapp_preload_link_type";
  public static final String MINIAPP_PRELOAD_WITH_PACKAGE_AND_CACHE_PRELOAD = "miniapp_repload_with_package_and_cache_preload";
  public static final String NAME = "QzoneIPCModule";
  public static final String NAME_CLIENT_PUBACCOUNT = "PubAccountIPCModule";
  public static final String NAME_CLIENT_QQCIRCLE = "QQCirCleClientIPCModule";
  public static final String PIC_PATH = "pic_path";
  public static final String PREFS_NAME_QZ_MAIN_SETTING = "QZ_main_setting";
  public static final String RESULT_CODE = "resultCode";
  public static final String TAG = "QzoneIPCModule";
  public static final String TAG_QCIRCLE = "[QzoneIPCModule_upload2]QCircle";
  private static QzoneIPCModule sInstance;
  private final AtomicReference<QzoneIPCModule.StickerRecReq> stickerRecReq = new AtomicReference();
  
  public QzoneIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QzoneIPCModule getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QzoneIPCModule("QzoneIPCModule");
      }
      return sInstance;
    }
    finally {}
  }
  
  private static List<StickerRecData> parseJson2Sticker(String paramString1, String paramString2, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    JSONArray localJSONArray;
    int i;
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 == null) {
        return localLinkedList;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.w("QzoneIPCModule", 2, "parseJson2Sticker: failed to parse json", paramString1);
        paramString1 = null;
      }
      localJSONArray = paramString1.optJSONArray("data");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        paramString2 = new StringBuilder().append("parseJson2Sticker: empty data ");
        if (localJSONArray == null) {}
        for (paramString1 = "null";; paramString1 = "0")
        {
          QLog.i("QzoneIPCModule", 2, paramString1);
          return localLinkedList;
        }
      }
      i = 0;
    }
    for (;;)
    {
      if ((i >= localJSONArray.length()) || (i > paramInt)) {
        return localLinkedList;
      }
      paramString1 = localJSONArray.optJSONObject(i);
      String str = paramString1.optString("url");
      paramString1 = paramString1.optString("md5");
      StickerRecData localStickerRecData = new StickerRecData();
      localStickerRecData.c(str);
      localStickerRecData.e(paramString1);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.equals(str))
        {
          localStickerRecData.b(true);
          paramString1 = null;
        }
      }
      localLinkedList.add(localStickerRecData);
      i += 1;
      paramString2 = paramString1;
    }
  }
  
  public static JSONObject parseSticker2Json(List<IStickerRecEmoticon> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = new StringBuilder().append("parseSticker2Json: empty img list ");
      if (paramList == null) {}
      for (paramList = "null";; paramList = Integer.valueOf(paramList.size()))
      {
        QLog.i("QzoneIPCModule", 2, paramList);
        return null;
      }
    }
    Object localObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (IStickerRecEmoticon)paramList.next();
      if ((localObject2 != null) && ((localObject2 instanceof StickerRecData)))
      {
        localObject2 = (StickerRecData)localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", ((StickerRecData)localObject2).a()).put("thumbUrl", ((StickerRecData)localObject2).b()).put("md5", ((StickerRecData)localObject2).c());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to create data json", localJSONException);
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("data", localJSONArray);
      return localObject1;
    }
    catch (JSONException paramList)
    {
      QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to put data json", paramList);
    }
    return null;
  }
  
  private void preloadCmData(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramBundle.getStringArrayList("uins");
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof QQAppInterface)));
      paramBundle = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      paramQQAppInterface = (IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ApolloBaseInfo localApolloBaseInfo = paramBundle.getApolloBaseInfo(str);
        if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)) {
          localArrayList.add(str);
        }
      }
    } while (localArrayList.isEmpty());
    QLog.i("QzoneIPCModule", 1, "CmShow preloadCmData but ApolloBaseInfo need update size:" + localArrayList.size());
    paramBundle = new String[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      paramBundle[i] = ((String)localArrayList.get(i));
      i += 1;
    }
    paramQQAppInterface.a(paramBundle);
  }
  
  public void getCertifiedAccountTaskList()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PubAccountIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new QzoneIPCModule.3(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPCModule", 2, "action = " + paramString + " callbackId:" + paramInt);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
    if ("getHostInfo".equals(paramString)) {
      try
      {
        paramString = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localQQAppInterface.getCurrentAccountUin());
        paramBundle = new Bundle();
        paramBundle.putLong("age", paramString.age);
        paramBundle.putLong("gender", paramString.shGender);
        paramBundle.putLong("constellation", paramString.constellation);
        paramBundle.putString("country", paramString.strCountry);
        paramBundle.putString("province", paramString.strProvince);
        paramBundle.putString("city", paramString.strCity);
        paramString = EIPCResult.createResult(0, paramBundle);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        return null;
      }
    }
    boolean bool;
    if ("isFriend".equals(paramString))
    {
      long l = 0L;
      if (paramBundle != null) {}
      try
      {
        l = paramBundle.getLong("uin");
        bool = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(String.valueOf(l));
        paramString = new Bundle();
        paramString.putBoolean("isFriend", bool);
        paramString = EIPCResult.createResult(0, paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        return null;
      }
    }
    if ("startDownloadVoicechangeSo".equals(paramString)) {
      for (;;)
      {
        try
        {
          paramInt = VcSystemInfo.getCpuArchitecture();
          if (paramInt > 2) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
          continue;
          AVSoUtils.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
          continue;
        }
        try
        {
          paramString = ((EarlyDownloadManager)localQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(QavSoDownloadHandler.e());
          if (paramString == null) {
            continue;
          }
          paramString.a(false);
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo Exception:" + paramString.getMessage());
          continue;
        }
        return EIPCResult.createResult(0, new Bundle());
        QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo null == earlyHandler:");
      }
    }
    if ("action_qzone_pic_pre_send".equals(paramString)) {
      try
      {
        PicAioQzonePreSendMgr.a(localQQAppInterface, paramBundle);
        paramString = new Bundle();
        paramString.putBoolean("qzone_pre_send_result", true);
        paramString = EIPCResult.createResult(0, paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, "action QzonePic preSend exception: ", paramString);
        return null;
      }
    }
    if ("action_qzone_get_sticker_rec_gif".equals(paramString))
    {
      if (paramBundle == null) {
        break label2378;
      }
      paramString = paramBundle.getString("analyze_text");
      localObject1 = paramBundle.getString("toUin");
      paramBundle = paramString;
      paramString = (String)localObject1;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramBundle)) || (TextUtils.isEmpty(paramString)))
      {
        QLog.w("QzoneIPCModule", 1, "empty text or unit " + paramBundle + " , " + paramString);
        return null;
      }
      Object localObject2 = StickerRecManager.a(localQQAppInterface);
      ((StickerRecManager)localObject2).a();
      if (!((StickerRecManager)localObject2).b())
      {
        QLog.i("QzoneIPCModule", 1, "emo rec is not open");
        return null;
      }
      localObject1 = new QzoneIPCModule.StickerRecReq(paramBundle, null);
      this.stickerRecReq.set(localObject1);
      if (!((StickerRecManager)localObject2).a(paramBundle, 0, paramString))
      {
        this.stickerRecReq.compareAndSet(localObject1, null);
        return null;
      }
      try
      {
        QzoneIPCModule.StickerRecReq.access$100((QzoneIPCModule.StickerRecReq)localObject1).await(2L, TimeUnit.SECONDS);
        if (TextUtils.isEmpty(QzoneIPCModule.StickerRecReq.access$200((QzoneIPCModule.StickerRecReq)localObject1)))
        {
          QLog.i("QzoneIPCModule", 1, "empty sticker rec resp list");
          return EIPCResult.createResult(-102, null);
        }
      }
      catch (InterruptedException paramString)
      {
        for (;;)
        {
          QLog.w("QzoneIPCModule", 1, "waiting req interrupted ", paramString);
        }
        paramString = new Bundle();
        paramString.putString("analyze_text", QzoneIPCModule.StickerRecReq.access$300((QzoneIPCModule.StickerRecReq)localObject1));
        paramString.putString("resp_data", QzoneIPCModule.StickerRecReq.access$200((QzoneIPCModule.StickerRecReq)localObject1));
        paramString.putString("resp_pass", QzoneIPCModule.StickerRecReq.access$400((QzoneIPCModule.StickerRecReq)localObject1));
        return EIPCResult.createSuccessResult(paramString);
      }
      Object localObject3;
      Object localObject4;
      if ("action_qzone_report_sticker_gif".equals(paramString))
      {
        if (paramBundle == null) {
          break label2359;
        }
        localObject3 = paramBundle.getString("rpt_data");
        localObject2 = paramBundle.getString("rpt_click");
        paramString = paramBundle.getString("toUin");
        localObject1 = paramBundle.getString("rpt_pass");
        localObject4 = paramBundle.getString("analyze_text");
        paramInt = paramBundle.getInt("rpt_expose_cnt", 0);
        paramBundle = (Bundle)localObject4;
      }
      for (;;)
      {
        for (;;)
        {
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramBundle)) || (paramInt < 1)) {
            break label2376;
          }
          localObject4 = new StickerReportItem();
          ((StickerReportItem)localObject4).jdField_a_of_type_JavaLangString = paramBundle;
          ((StickerReportItem)localObject4).b = ((String)localObject1);
          ((StickerReportItem)localObject4).jdField_a_of_type_JavaUtilList = parseJson2Sticker((String)localObject3, (String)localObject2, paramInt);
          paramBundle = StickerRecManager.a(localQQAppInterface);
          paramBundle.a();
          paramBundle.a(Collections.singletonList(localObject4), true, 11000, paramString);
          return EIPCResult.createSuccessResult(null);
          if ("action_save_customenotion".equals(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("pic_path");
            if (TextUtils.isEmpty(paramString)) {
              break;
            }
            paramInt = AIOGalleryUtils.a(localQQAppInterface, paramString);
            paramString = new Bundle();
            paramString.putInt("resultCode", paramInt);
            return EIPCResult.createSuccessResult(paramString);
          }
          if ("action_pre_pull_mini_app".equals(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            QLog.d("QzoneIPCModule", 4, "ACTION_PRE_PULL_MINI_APP change to qq_process by QzoneIPCModule");
            paramString = paramBundle.getString("miniapp_preload_link");
            paramInt = paramBundle.getInt("miniapp_preload_link_type");
            bool = paramBundle.getBoolean("miniapp_repload_with_package_and_cache_preload", false);
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(paramString, paramInt, bool, new QzoneIPCModule.1(this));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if (!(paramString instanceof CertifiedFakeFeed)) {
              break;
            }
            paramString = (CertifiedFakeFeed)paramString;
            SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(paramString, 1));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if (!(paramString instanceof CertifiedFakeFeed)) {
              break;
            }
            paramString = (CertifiedFakeFeed)paramString;
            SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(paramString, 2));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if (!(paramString instanceof CertifiedFakeFeed)) {
              break;
            }
            paramString = (CertifiedFakeFeed)paramString;
            SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(paramString, 3));
            return null;
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
            SimpleEventBus.getInstance().dispatchEvent(new PublishBoxStatusEvent(paramBundle));
            SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(4));
            return null;
          }
          if ("action_qzone_get_themeid".equalsIgnoreCase(paramString)) {
            try
            {
              paramString = new Bundle();
              paramString.putString("themeId", ThemeUtil.getCurrentThemeId());
              paramString = EIPCResult.createResult(0, paramString);
              return paramString;
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, "action getThemeId exception: ", paramString);
              return null;
            }
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW".equalsIgnoreCase(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("uin", null);
            if (paramString == null) {
              break;
            }
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin(localQQAppInterface, localQQAppInterface.getApp().getApplicationContext(), paramString, false, null, true);
            QzonePublicAccountHelper.broadcastFollowIfNeed(localQQAppInterface.getApp().getApplicationContext(), paramString, 0);
            return null;
          }
          if ("action_qzone_main_process_prop_set".equalsIgnoreCase(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("key", null);
            if (paramString == null) {
              break;
            }
            bool = paramBundle.getBoolean("value");
            localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).edit().putBoolean(paramString, bool).apply();
            return EIPCResult.createSuccessResult(null);
          }
          if ("action_qzone_main_process_prop_get".equalsIgnoreCase(paramString))
          {
            if (paramBundle == null) {
              break;
            }
            paramString = paramBundle.getString("key", null);
            if (paramString == null) {
              break;
            }
            bool = localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).getBoolean(paramString, false);
            paramString = new Bundle();
            paramString.putBoolean("value", bool);
            return EIPCResult.createSuccessResult(paramString);
          }
          if ("action_qzone_send_event".equalsIgnoreCase(paramString))
          {
            if (QZoneApiProxy.isInQZoneEnvironment()) {
              return EIPCResult.createResult(-1, null);
            }
            if (paramBundle != null)
            {
              paramBundle.setClassLoader(ExoticEvent.getLoader());
              paramString = (ExoticEvent)paramBundle.getParcelable("event");
              if (paramString != null)
              {
                bool = ExoticEventPool.getInstance().onEventReceived(paramString);
                paramString = new Bundle();
                paramString.putBoolean("re", bool);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
            return EIPCResult.createResult(-1, null);
          }
          if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH to qq_process by QzoneIPCModule");
            try
            {
              paramString = paramBundle.getByteArray("bundle_key_feed_byte_array");
              paramBundle = new CertifiedAccountMeta.StFeed();
              if (paramString == null) {
                break;
              }
              paramString = (CertifiedAccountMeta.StFeed)paramBundle.mergeFrom(paramString);
              QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH publishFeed" + paramString.id.get());
              SimpleEventBus.getInstance().dispatchEvent(new SubscribePublishFeedsEvent(paramString, 1));
              return null;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              QLog.e("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH error" + paramString);
              return null;
            }
          }
        }
        if ("action_qzone_show_push_setting_banner".equalsIgnoreCase(paramString))
        {
          paramString = new Bundle();
          paramBundle = NotificationBannerManager.a(localQQAppInterface);
          if (paramBundle == null)
          {
            QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null mgr");
            return EIPCResult.createResult(-102, null);
          }
          bool = paramBundle.b();
          paramString.putBoolean("visible", bool);
          if (bool)
          {
            localObject1 = NotificationBannerConfProcessor.a();
            if (localObject1 == null) {
              break label1851;
            }
            paramBundle = ((NotificationBannerBean)localObject1).a();
            localObject1 = ((NotificationBannerBean)localObject1).b();
            paramString.putString("msg", paramBundle);
            paramString.putString("setting", (String)localObject1);
          }
          for (;;)
          {
            return EIPCResult.createSuccessResult(paramString);
            label1851:
            QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null conf bean");
          }
        }
        if ("action_qzone_close_push_setting_banner".equalsIgnoreCase(paramString))
        {
          paramString = NotificationBannerManager.a(localQQAppInterface);
          if (paramString == null)
          {
            QLog.d("QzoneIPCModule", 1, "ACTION_CLOSE_PUSH_SETTING_BANNER null mgr");
            return EIPCResult.createResult(-102, null);
          }
          paramString.a();
          return EIPCResult.createSuccessResult(null);
        }
        if ("action_qzone_follow_qq_circle".equalsIgnoreCase(paramString))
        {
          paramString = new Bundle();
          if (paramBundle == null)
          {
            QLog.w("QzoneIPCModule", 1, "flow qq circle no param");
            paramString.putInt("code", -1);
            return EIPCResult.createResult(-102, paramString);
          }
          localObject1 = paramBundle.getString("circle_uin");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            QLog.w("QzoneIPCModule", 1, "flow qq circle no uin");
          }
          bool = paramBundle.getBoolean("circle_follow");
          paramBundle = new FeedCloudMeta.StUser();
          paramBundle.id.set((String)localObject1);
          localObject2 = new CountDownLatch(1);
          localObject1 = new boolean[1];
          localObject1[0] = 0;
          localObject3 = VSNetworkHelper.getInstance();
          if (bool) {
            paramInt = 1;
          }
          for (;;)
          {
            ((VSNetworkHelper)localObject3).sendRequest(new QCircleDoFollowRequest(paramBundle, paramInt, null), new QzoneIPCModule.2(this, (boolean[])localObject1, (CountDownLatch)localObject2));
            try
            {
              bool = ((CountDownLatch)localObject2).await(10L, TimeUnit.SECONDS);
              if (localObject1[0] != 0)
              {
                QLog.d("QzoneIPCModule", 1, "flow qq circle ok");
                return EIPCResult.createSuccessResult(null);
                paramInt = 0;
              }
            }
            catch (InterruptedException paramBundle)
            {
              for (;;)
              {
                QLog.w("QzoneIPCModule", 1, "flow qq circle is interrupted", paramBundle);
                bool = false;
              }
              if (bool)
              {
                QLog.d("QzoneIPCModule", 1, "flow qq circle failed");
                paramString.putInt("code", -2);
                return EIPCResult.createResult(-102, paramString);
              }
              QLog.d("QzoneIPCModule", 1, "flow qq circle over time");
              paramString.putInt("code", -3);
              return EIPCResult.createResult(-102, paramString);
            }
          }
        }
        if ("action_qzone_preload_cm_data".equalsIgnoreCase(paramString))
        {
          preloadCmData(paramBundle, localQQAppInterface);
          return null;
        }
        if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO".equalsIgnoreCase(paramString)) {
          break;
        }
        if ("action_is_flutter_extend".equalsIgnoreCase(paramString))
        {
          paramString = (ExtendFriendManager)localQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
          paramBundle = new Bundle();
          paramBundle.putBoolean("action_is_flutter_extend", paramString.f());
          return EIPCResult.createSuccessResult(paramBundle);
        }
        if ("action_extend_report".equalsIgnoreCase(paramString))
        {
          paramString = paramBundle.getString("event");
          if ("click#all_page#entrance".equals(paramString))
          {
            paramString = paramBundle.getString("source");
            ExpandReportUtils.b(paramString);
            ExpandReportUtils.a(paramString);
            return null;
          }
          ExpandReportUtils.a(paramString, true, new HashMap());
          return null;
        }
        if (!"action_extend_forbidden".equals(paramString)) {
          break;
        }
        paramString = (ExtendFriendManager)localQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        paramBundle = new Bundle();
        paramBundle.putBoolean("is_forbidden", paramString.p());
        paramBundle.putLong("forbidden_end_time", paramString.d());
        return EIPCResult.createSuccessResult(paramBundle);
        label2359:
        paramBundle = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        paramString = null;
        paramInt = i;
      }
      label2376:
      break;
      label2378:
      paramString = null;
      paramBundle = null;
    }
  }
  
  public void onGetStickerRecResp(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QzoneIPCModule.StickerRecReq localStickerRecReq;
    do
    {
      return;
      QLog.i("QzoneIPCModule", 1, "onGetStickerRecResp: " + paramString1 + " " + paramString2);
      localStickerRecReq = (QzoneIPCModule.StickerRecReq)this.stickerRecReq.get();
    } while ((localStickerRecReq == null) || (!paramString1.equals(QzoneIPCModule.StickerRecReq.access$300(localStickerRecReq))) || (!this.stickerRecReq.compareAndSet(localStickerRecReq, null)));
    QzoneIPCModule.StickerRecReq.access$202(localStickerRecReq, paramString2);
    QzoneIPCModule.StickerRecReq.access$402(localStickerRecReq, paramString3);
    QzoneIPCModule.StickerRecReq.access$100(localStickerRecReq).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule
 * JD-Core Version:    0.7.0.1
 */