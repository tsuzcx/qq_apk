package cooperation.qzone;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import agzl;
import ahmw;
import ahnm;
import ahns;
import ahoa;
import alnr;
import amsw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import apke;
import apzd;
import apze;
import aqxc;
import aqxl;
import aqya;
import aydf;
import com.tencent.biz.qcircleshadow.local.requests.QCircleDoFollowRequest;
import com.tencent.biz.qcircleshadow.local.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qcircleshadow.local.requests.QCircleGetRecommendTagRequest;
import com.tencent.biz.qcircleshadow.local.requests.QCirclePublishFeedRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConstants;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.events.QCircleFeedEvent;
import cooperation.qqcircle.events.QCircleSelectTabEvent;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleTaskReportInfo;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;
import cooperation.qzone.feed.CertifiedFakeFeed;
import cooperation.qzone.model.QCirclePublishPictureTagInfo;
import cooperation.qzone.util.QzonePublicAccountHelper;
import eipc.EIPCResult;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StExifInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudTagcategorysvr.PicRecomEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import lld;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ugf;

public class QzoneIPCModule
  extends QIPCModule
{
  public static final String ACTION_CLOSE_PUSH_SETTING_BANNER = "action_qzone_close_push_setting_banner";
  public static final String ACTION_GET_HOST_INFO = "getHostInfo";
  public static final String ACTION_GET_THEMEID = "action_qzone_get_themeid";
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
  
  private void checkQCircleFeedCompleted(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, QzoneIPCModule.ResultParmas paramResultParmas)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFeedDetailRequest(paramQCircleFakeFeed.getFeedId(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQCircleFakeFeed.getCreateTime(), true), new QzoneIPCModule.5(this, paramQCircleFakeFeed, paramResultParmas, paramInt));
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
  
  private void getQCircleRecommendTag(Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramBundle.setClassLoader(QCirclePublishPictureTagInfo.class.getClassLoader());
    Object localObject1 = ((ArrayList)paramBundle.getSerializable("key_qcircle_pic_tag")).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCirclePublishPictureTagInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        FeedCloudTagcategorysvr.PicRecomEntry localPicRecomEntry = new FeedCloudTagcategorysvr.PicRecomEntry();
        if (!TextUtils.isEmpty(((QCirclePublishPictureTagInfo)localObject2).picId)) {
          localPicRecomEntry.picId.set(((QCirclePublishPictureTagInfo)localObject2).picId);
        }
        localPicRecomEntry.recomTags.set(((QCirclePublishPictureTagInfo)localObject2).picTags);
        if (!TextUtils.isEmpty(((QCirclePublishPictureTagInfo)localObject2).materialId)) {
          localPicRecomEntry.materialId.set(((QCirclePublishPictureTagInfo)localObject2).materialId);
        }
        if (!TextUtils.isEmpty(((QCirclePublishPictureTagInfo)localObject2).filterId)) {
          localPicRecomEntry.filterId.set(((QCirclePublishPictureTagInfo)localObject2).filterId);
        }
        FeedCloudMeta.StExifInfo localStExifInfo = new FeedCloudMeta.StExifInfo();
        if ((((QCirclePublishPictureTagInfo)localObject2).exif != null) && (((QCirclePublishPictureTagInfo)localObject2).exif.size() > 0))
        {
          localObject2 = ((QCirclePublishPictureTagInfo)localObject2).exif.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            localStExifInfo.kvs.add(QCircleReportHelper.newEntry(localEntry));
            QLog.i("QzoneIPCModule", 2, "getQCircleRecommendTag  exif key:" + (String)localEntry.getKey() + " value:" + (String)localEntry.getValue());
          }
          localPicRecomEntry.exifInfo.set(localStExifInfo);
        }
        localArrayList.add(localPicRecomEntry);
      }
    }
    localObject1 = new FeedCloudMeta.StGPSV2();
    paramBundle = paramBundle.getByteArray("key_qcircle_gps_info");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle = (FeedCloudMeta.StGPSV2)((FeedCloudMeta.StGPSV2)localObject1).mergeFrom(paramBundle);
        paramBundle = new QCircleGetRecommendTagRequest(paramBundle, localArrayList);
        VSNetworkHelper.getInstance().sendRequest(paramBundle, new QzoneIPCModule.3(this, paramInt));
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle = (Bundle)localObject1;
        continue;
      }
      paramBundle = (Bundle)localObject1;
    }
  }
  
  private static List<ahnm> parseJson2Sticker(String paramString1, String paramString2, int paramInt)
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
      ahnm localahnm = new ahnm();
      localahnm.b(str);
      localahnm.d(paramString1);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.equals(str))
        {
          localahnm.b(true);
          paramString1 = null;
        }
      }
      localLinkedList.add(localahnm);
      i += 1;
      paramString2 = paramString1;
    }
  }
  
  public static JSONObject parseSticker2Json(List<ahmw> paramList)
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
      Object localObject2 = (ahmw)paramList.next();
      if ((localObject2 != null) && ((localObject2 instanceof ahnm)))
      {
        localObject2 = (ahnm)localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", ((ahnm)localObject2).a()).put("thumbUrl", ((ahnm)localObject2).b()).put("md5", ((ahnm)localObject2).c());
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
      paramBundle = (alnr)paramQQAppInterface.getManager(153);
      paramQQAppInterface = (VasExtensionHandler)paramQQAppInterface.getBusinessHandler(71);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ApolloBaseInfo localApolloBaseInfo = paramBundle.b(str);
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
  
  private void processPublishData(QzoneIPCModule.ResultParmas paramResultParmas)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "processPublishData... notify qzone");
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_return_code", paramResultParmas.retCode);
    localBundle.putString("key_error_msg", paramResultParmas.errMsg);
    localBundle.putString("key_stfeed_id", paramResultParmas.feedId);
    localBundle.putString("key_trace_id", paramResultParmas.traceId);
    localBundle.putString("key_clientkey", paramResultParmas.clientKey);
    callbackResult(paramResultParmas.callbackId, EIPCResult.createResult(0, localBundle));
  }
  
  private void reportImageQualityEvent(QCircleTaskReportInfo paramQCircleTaskReportInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("album_id:").append(paramQCircleTaskReportInfo.albumId).append(",");
    localStringBuilder.append("photo_id:").append(paramQCircleTaskReportInfo.lloc).append(",");
    localStringBuilder.append("trace_id:").append(paramQCircleTaskReportInfo.traceId).append(",");
    localStringBuilder.append("orig_pic_width:").append(paramQCircleTaskReportInfo.origPicWidth).append(",");
    localStringBuilder.append("orig_pic_height:").append(paramQCircleTaskReportInfo.origPicHeight).append(",");
    localStringBuilder.append("orig_pic_size:").append(paramQCircleTaskReportInfo.origPicSize).append(",");
    localStringBuilder.append("edited_pic_width:").append(paramQCircleTaskReportInfo.edited_pic_width).append(",");
    localStringBuilder.append("edited_pic_height:").append(paramQCircleTaskReportInfo.edited_pic_height).append(",");
    localStringBuilder.append("edited_pic_size:").append(paramQCircleTaskReportInfo.edited_pic_size).append(",");
    localStringBuilder.append("client_compress_pic_width:").append(paramQCircleTaskReportInfo.client_compress_pic_width).append(",");
    localStringBuilder.append("client_compress_pic_height:").append(paramQCircleTaskReportInfo.client_compress_pic_height).append(",");
    localStringBuilder.append("client_compress_pic_size:").append(paramQCircleTaskReportInfo.client_compress_pic_size).append(",");
    localStringBuilder.append("backend_pic_width:").append(paramQCircleTaskReportInfo.backendPicWidth).append(",");
    localStringBuilder.append("backend_pic_height:").append(paramQCircleTaskReportInfo.backendPicHeight).append(",");
    localStringBuilder.append("hasCompress:").append(paramQCircleTaskReportInfo.hasCompress);
    QLog.i("[QzoneIPCModule_upload2]QCircle", 1, "reportPicQuality pic quality:" + localStringBuilder.toString());
    QCircleQualityReporter.reportQualityEvent("image_publish_full_link", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  private void reportPicQuality(ArrayList<QCircleTaskReportInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QCircleTaskReportInfo localQCircleTaskReportInfo = (QCircleTaskReportInfo)paramArrayList.next();
      if (localQCircleTaskReportInfo != null) {
        if (localQCircleTaskReportInfo.is_video == 0) {
          reportImageQualityEvent(localQCircleTaskReportInfo);
        } else if (localQCircleTaskReportInfo.is_video == 1) {
          reportVideoQualityEvent(localQCircleTaskReportInfo);
        }
      }
    }
  }
  
  private void reportVideoQualityEvent(QCircleTaskReportInfo paramQCircleTaskReportInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vid:").append(paramQCircleTaskReportInfo.vid).append(",");
    localStringBuilder.append("trace_id:").append(paramQCircleTaskReportInfo.traceId).append(",");
    localStringBuilder.append("orig_video_width:").append(paramQCircleTaskReportInfo.origPicWidth).append(",");
    localStringBuilder.append("orig_video_height:").append(paramQCircleTaskReportInfo.origPicHeight).append(",");
    localStringBuilder.append("orig_video_size:").append(paramQCircleTaskReportInfo.origPicSize).append(",");
    localStringBuilder.append("orig_video_bitrate:").append(paramQCircleTaskReportInfo.mediaOriginBitrate).append(",");
    localStringBuilder.append("edited_video_width:").append(paramQCircleTaskReportInfo.edited_pic_width).append(",");
    localStringBuilder.append("edited_video_height:").append(paramQCircleTaskReportInfo.edited_pic_height).append(",");
    localStringBuilder.append("edited_video_size:").append(paramQCircleTaskReportInfo.edited_pic_size).append(",");
    localStringBuilder.append("edited_video_bitrate:").append(paramQCircleTaskReportInfo.edited_video_mediaBitrate).append(",");
    localStringBuilder.append("client_compress_video_width:").append(paramQCircleTaskReportInfo.client_compress_pic_width).append(",");
    localStringBuilder.append("client_compress_video_height:").append(paramQCircleTaskReportInfo.client_compress_pic_height).append(",");
    localStringBuilder.append("client_compress_video_size:").append(paramQCircleTaskReportInfo.client_compress_pic_size).append(",");
    localStringBuilder.append("client_compress_video_bitrate:").append(paramQCircleTaskReportInfo.client_compress_mediaBitrate);
    QLog.i("[QzoneIPCModule_upload2]QCircle", 1, "reportPicQuality video quality:" + localStringBuilder.toString());
    QCircleQualityReporter.reportQualityEvent(5530, "video_publish_full_link", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public void getCertifiedAccountTaskList()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PubAccountIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new QzoneIPCModule.7(this));
  }
  
  public void getQCircleTaskList()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "QQCirCleClientIPCModule", "cooperation.qzone.ACTION_QCIRCLE_GET_TASK_LIST", null, new QzoneIPCModule.6(this));
  }
  
  protected boolean needRetry(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, QzoneIPCModule.ResultParmas paramResultParmas)
  {
    if (paramInt >= QCircleConstants.MAX_FETCH_FAKE_FEED_RETRY_COUNT)
    {
      QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "retryCount >= QCircleFakeAdapter.MAX_RETYR_COUNT");
      return false;
    }
    paramQCircleFakeFeed = new QzoneIPCModule.RetryRequestFeed(this, paramQCircleFakeFeed, paramInt + 1, paramResultParmas);
    ThreadManager.getSubThreadHandler().postDelayed(paramQCircleFakeFeed, 2000 * paramInt);
    return true;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
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
        paramString = ((amsw)localQQAppInterface.getManager(51)).c(localQQAppInterface.getCurrentAccountUin());
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
      }
    }
    for (;;)
    {
      return null;
      boolean bool1;
      if ("isFriend".equals(paramString))
      {
        long l = 0L;
        if (paramBundle != null) {}
        try
        {
          l = paramBundle.getLong("uin");
          bool1 = ((amsw)localQQAppInterface.getManager(51)).b(String.valueOf(l));
          paramString = new Bundle();
          paramString.putBoolean("isFriend", bool1);
          paramString = EIPCResult.createResult(0, paramString);
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        }
      }
      else
      {
        if ("startDownloadVoicechangeSo".equals(paramString)) {
          for (;;)
          {
            try
            {
              paramInt = lld.f();
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
              paramString = ((aqxc)localQQAppInterface.getManager(77)).a(aqya.e());
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
        if ("action_qzone_pic_pre_send".equals(paramString))
        {
          try
          {
            aydf.a(localQQAppInterface, paramBundle);
            paramString = new Bundle();
            paramString.putBoolean("qzone_pre_send_result", true);
            paramString = EIPCResult.createResult(0, paramString);
            return paramString;
          }
          catch (Exception paramString)
          {
            QLog.e("QzoneIPCModule", 1, "action QzonePic preSend exception: ", paramString);
          }
        }
        else
        {
          Object localObject2;
          if ("action_qzone_get_sticker_rec_gif".equals(paramString))
          {
            localObject1 = null;
            paramString = null;
            if (paramBundle != null)
            {
              localObject1 = paramBundle.getString("analyze_text");
              paramString = paramBundle.getString("toUin");
            }
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString)))
            {
              QLog.w("QzoneIPCModule", 1, "empty text or unit " + (String)localObject1 + " , " + paramString);
              return null;
            }
            localObject2 = ahns.a(localQQAppInterface);
            ((ahns)localObject2).a();
            if (!((ahns)localObject2).b())
            {
              QLog.i("QzoneIPCModule", 1, "emo rec is not open");
              return null;
            }
            paramBundle = new QzoneIPCModule.StickerRecReq((String)localObject1, null);
            this.stickerRecReq.set(paramBundle);
            if (!((ahns)localObject2).a((String)localObject1, 0, paramString))
            {
              this.stickerRecReq.compareAndSet(paramBundle, null);
              return null;
            }
            try
            {
              QzoneIPCModule.StickerRecReq.access$100(paramBundle).await(2L, TimeUnit.SECONDS);
              if (TextUtils.isEmpty(QzoneIPCModule.StickerRecReq.access$200(paramBundle)))
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
              paramString.putString("analyze_text", QzoneIPCModule.StickerRecReq.access$300(paramBundle));
              paramString.putString("resp_data", QzoneIPCModule.StickerRecReq.access$200(paramBundle));
              paramString.putString("resp_pass", QzoneIPCModule.StickerRecReq.access$400(paramBundle));
              return EIPCResult.createSuccessResult(paramString);
            }
          }
          Object localObject3;
          if ("action_qzone_report_sticker_gif".equals(paramString))
          {
            paramString = null;
            String str = null;
            localObject3 = null;
            localObject2 = null;
            localObject1 = null;
            paramInt = 0;
            if (paramBundle != null)
            {
              str = paramBundle.getString("rpt_data");
              localObject3 = paramBundle.getString("rpt_click");
              paramString = paramBundle.getString("toUin");
              localObject2 = paramBundle.getString("rpt_pass");
              localObject1 = paramBundle.getString("analyze_text");
              paramInt = paramBundle.getInt("rpt_expose_cnt", 0);
            }
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (paramInt < 1)) {
              return null;
            }
            paramBundle = new ahoa();
            paramBundle.jdField_a_of_type_JavaLangString = ((String)localObject1);
            paramBundle.b = ((String)localObject2);
            paramBundle.jdField_a_of_type_JavaUtilList = parseJson2Sticker(str, (String)localObject3, paramInt);
            localObject1 = ahns.a(localQQAppInterface);
            ((ahns)localObject1).a();
            ((ahns)localObject1).a(Collections.singletonList(paramBundle), true, 11000, paramString);
            return EIPCResult.createSuccessResult(null);
          }
          if ("action_save_customenotion".equals(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("pic_path");
              if (!TextUtils.isEmpty(paramString))
              {
                paramInt = agzl.a(localQQAppInterface, paramString);
                paramString = new Bundle();
                paramString.putInt("resultCode", paramInt);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
          }
          else if ("action_pre_pull_mini_app".equals(paramString))
          {
            if (paramBundle != null)
            {
              QLog.d("QzoneIPCModule", 4, "ACTION_PRE_PULL_MINI_APP change to qq_process by QzoneIPCModule");
              paramString = paramBundle.getString("miniapp_preload_link");
              paramInt = paramBundle.getInt("miniapp_preload_link_type");
              bool1 = paramBundle.getBoolean("miniapp_repload_with_package_and_cache_preload", false);
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramInt, bool1, new QzoneIPCModule.1(this));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(paramString, 1));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(paramString, 2));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(paramString, 3));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
            SimpleEventBus.getInstance().dispatchEvent(new PublishBoxStatusEvent(paramBundle));
            SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(4));
          }
          else if ("action_qzone_get_themeid".equalsIgnoreCase(paramString))
          {
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
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("uin", null);
              if (paramString != null)
              {
                ugf.a(localQQAppInterface, localQQAppInterface.getApp().getApplicationContext(), paramString, false, null, true);
                QzonePublicAccountHelper.broadcastFollowIfNeed(localQQAppInterface.getApp().getApplicationContext(), paramString, 0);
              }
            }
          }
          else if ("action_qzone_main_process_prop_set".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("key", null);
              if (paramString != null)
              {
                bool1 = paramBundle.getBoolean("value");
                localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).edit().putBoolean(paramString, bool1).apply();
                return EIPCResult.createSuccessResult(null);
              }
            }
          }
          else if ("action_qzone_main_process_prop_get".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("key", null);
              if (paramString != null)
              {
                bool1 = localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).getBoolean(paramString, false);
                paramString = new Bundle();
                paramString.putBoolean("value", bool1);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
          }
          else
          {
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
                  bool1 = ExoticEventPool.getInstance().onEventReceived(paramString);
                  paramString = new Bundle();
                  paramString.putBoolean("re", bool1);
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
                  continue;
                }
                paramString = (CertifiedAccountMeta.StFeed)paramBundle.mergeFrom(paramString);
                QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH publishFeed" + paramString.id.get());
                SimpleEventBus.getInstance().dispatchEvent(new SubscribePublishFeedsEvent(paramString, 1));
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                QLog.e("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH error" + paramString);
              }
            }
            else
            {
              if ("action_qzone_show_push_setting_banner".equalsIgnoreCase(paramString))
              {
                paramString = new Bundle();
                paramBundle = apke.a(localQQAppInterface);
                if (paramBundle == null)
                {
                  QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null mgr");
                  return EIPCResult.createResult(-102, null);
                }
                bool1 = paramBundle.b();
                paramString.putBoolean("visible", bool1);
                if (bool1)
                {
                  localObject1 = apze.a();
                  if (localObject1 == null) {
                    break label1848;
                  }
                  paramBundle = ((apzd)localObject1).a();
                  localObject1 = ((apzd)localObject1).b();
                  paramString.putString("msg", paramBundle);
                  paramString.putString("setting", (String)localObject1);
                }
                for (;;)
                {
                  return EIPCResult.createSuccessResult(paramString);
                  label1848:
                  QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null conf bean");
                }
              }
              if ("action_qzone_close_push_setting_banner".equalsIgnoreCase(paramString))
              {
                paramString = apke.a(localQQAppInterface);
                if (paramString == null)
                {
                  QLog.d("QzoneIPCModule", 1, "ACTION_CLOSE_PUSH_SETTING_BANNER null mgr");
                  return EIPCResult.createResult(-102, null);
                }
                paramString.a();
                return EIPCResult.createSuccessResult(null);
              }
              if ("cooperation.qzone.ACTION_QCIRCLE_PULISH_FEED".equalsIgnoreCase(paramString))
              {
                QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PULISH_FEED to qq_process by QzoneIPCModule");
                publishQCircleFeed(paramBundle, paramInt);
              }
              else
              {
                if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT to qq_process by QzoneIPCModule");
                  paramString = (ArrayList)paramBundle.getSerializable("key_report_info");
                  if (paramString != null) {}
                  for (paramInt = paramString.size();; paramInt = 0)
                  {
                    QLog.d("[QzoneIPCModule_upload2]QCircle", 4, new Object[] { "ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT size:", Integer.valueOf(paramInt) });
                    QCircleLpReportDc05494.report(paramString);
                    reportPicQuality(paramString);
                    break;
                  }
                }
                if ("cooperation.qzone.ACTION_QQCIRCLE_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QQCIRCLE_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramString, 1));
                    SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(1).needScrollTop());
                  }
                  else
                  {
                    QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QQCIRCLE_FAKE_FEED_CREATE fakeFeed == null");
                  }
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_QUEUE_CHANGED".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_QUEUE_CHANGED to qq_process by QzoneIPCModule");
                  getQCircleTaskList();
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramString, 3));
                  }
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS".equals(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_STATUS to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramString.getFeedId(), 5));
                  }
                }
                else
                {
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
                    bool1 = paramBundle.getBoolean("circle_follow");
                    paramBundle = new FeedCloudMeta.StUser();
                    paramBundle.id.set((String)localObject1);
                    localObject2 = new CountDownLatch(1);
                    localObject1 = new boolean[1];
                    localObject1[0] = 0;
                    localObject3 = VSNetworkHelper.getInstance();
                    if (bool1) {}
                    for (paramInt = 1;; paramInt = 0)
                    {
                      ((VSNetworkHelper)localObject3).sendRequest(new QCircleDoFollowRequest(paramBundle, paramInt, null), new QzoneIPCModule.2(this, (boolean[])localObject1, (CountDownLatch)localObject2));
                      bool1 = false;
                      try
                      {
                        boolean bool2 = ((CountDownLatch)localObject2).await(10L, TimeUnit.SECONDS);
                        bool1 = bool2;
                      }
                      catch (InterruptedException paramBundle)
                      {
                        for (;;)
                        {
                          QLog.w("QzoneIPCModule", 1, "flow qq circle is interrupted", paramBundle);
                        }
                        if (!bool1) {
                          break label2507;
                        }
                        QLog.d("QzoneIPCModule", 1, "flow qq circle failed");
                        paramString.putInt("code", -2);
                        return EIPCResult.createResult(-102, paramString);
                        QLog.d("QzoneIPCModule", 1, "flow qq circle over time");
                        paramString.putInt("code", -3);
                        return EIPCResult.createResult(-102, paramString);
                      }
                      if (localObject1[0] == 0) {
                        break;
                      }
                      QLog.d("QzoneIPCModule", 1, "flow qq circle ok");
                      return EIPCResult.createSuccessResult(null);
                    }
                  }
                  label2507:
                  if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG".equalsIgnoreCase(paramString))
                  {
                    if (QLog.isDevelopLevel()) {
                      QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG to qq_process by QzoneIPCModule");
                    }
                    getQCircleRecommendTag(paramBundle, paramInt);
                  }
                  else if ("action_qzone_preload_cm_data".equalsIgnoreCase(paramString))
                  {
                    preloadCmData(paramBundle, localQQAppInterface);
                  }
                  else if ((!"cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO".equalsIgnoreCase(paramString)) && ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_REPORT".equalsIgnoreCase(paramString)) && (paramBundle != null))
                  {
                    paramInt = paramBundle.getInt("key_qcircle_report_action_type");
                    int i = paramBundle.getInt("key_qcircle_report_sub_action_type");
                    int j = paramBundle.getInt("key_qcircle_report_thr_action_type");
                    paramString = paramBundle.getString("key_qcircle_report_ext1");
                    paramBundle = paramBundle.getString("key_qcircle_report_ext6");
                    QCircleLpReportDc05504.report(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt, i, j, paramString, "", paramBundle, "", "", QCircleReportHelper.getInstance().getPageId());
                  }
                }
              }
            }
          }
        }
      }
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
  
  public void publishQCircleFeed(Bundle paramBundle, int paramInt)
  {
    String str;
    Object localObject1;
    Object localObject2;
    try
    {
      str = paramBundle.getString("key_clientkey");
      localObject1 = paramBundle.getByteArray("key_stfeed");
      paramBundle = (HashMap)paramBundle.getSerializable("key_common_ext");
      localObject2 = new FeedCloudMeta.StFeed();
      if (localObject1 != null)
      {
        localObject1 = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = new FeedCloudCommon.StCommonExt();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.entrySet().iterator();
          while (paramBundle.hasNext()) {
            ((FeedCloudCommon.StCommonExt)localObject2).mapInfo.add(QCircleReportHelper.newEntry((Map.Entry)paramBundle.next()));
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED error" + paramBundle);
    }
    paramBundle = new QCirclePublishFeedRequest((FeedCloudCommon.StCommonExt)localObject2, (FeedCloudMeta.StFeed)localObject1);
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED publishFeed id:" + ((FeedCloudMeta.StFeed)localObject1).id.get());
    VSNetworkHelper.getInstance().sendRequest(paramBundle, new QzoneIPCModule.4(this, str, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule
 * JD-Core Version:    0.7.0.1
 */