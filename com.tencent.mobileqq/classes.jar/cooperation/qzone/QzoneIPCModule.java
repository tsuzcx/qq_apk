package cooperation.qzone;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
  public static final String EXPAND_KEY_FORBIDDEN_INFO = "expand_forbidden_info";
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
  private static final IStickerRecManager.ImgUpdateListener qzoneImgUpdateListener = new QzoneIPCModule.4();
  private static QzoneIPCModule sInstance;
  private final AtomicReference<QzoneIPCModule.StickerRecReq> stickerRecReq = new AtomicReference();
  
  public QzoneIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QzoneIPCModule getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QzoneIPCModule("QzoneIPCModule");
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private static List<StickerRecData> parseJson2Sticker(String paramString1, String paramString2, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramString1 = new JSONObject(paramString1);
    }
    catch (JSONException paramString1)
    {
      QLog.w("QzoneIPCModule", 2, "parseJson2Sticker: failed to parse json", paramString1);
      paramString1 = null;
    }
    if (paramString1 == null) {
      return localLinkedList;
    }
    JSONArray localJSONArray = paramString1.optJSONArray("data");
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        if (i > paramInt) {
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
      return localLinkedList;
    }
    paramString2 = new StringBuilder();
    paramString2.append("parseJson2Sticker: empty data ");
    if (localJSONArray == null) {
      paramString1 = "null";
    } else {
      paramString1 = "0";
    }
    paramString2.append(paramString1);
    QLog.i("QzoneIPCModule", 2, paramString2.toString());
    return localLinkedList;
  }
  
  public static JSONObject parseSticker2Json(List<IStickerRecEmoticon> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = new JSONObject();
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
        return null;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parseSticker2Json: empty img list ");
    if (paramList == null) {
      paramList = "null";
    } else {
      paramList = Integer.valueOf(paramList.size());
    }
    ((StringBuilder)localObject1).append(paramList);
    QLog.i("QzoneIPCModule", 2, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public void getCertifiedAccountTaskList()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PubAccountIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new QzoneIPCModule.3(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onGetStickerRecResp(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetStickerRecResp: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("QzoneIPCModule", 1, ((StringBuilder)localObject).toString());
      localObject = (QzoneIPCModule.StickerRecReq)this.stickerRecReq.get();
      if ((localObject != null) && (paramString1.equals(QzoneIPCModule.StickerRecReq.access$300((QzoneIPCModule.StickerRecReq)localObject))))
      {
        if (!this.stickerRecReq.compareAndSet(localObject, null)) {
          return;
        }
        QzoneIPCModule.StickerRecReq.access$202((QzoneIPCModule.StickerRecReq)localObject, paramString2);
        QzoneIPCModule.StickerRecReq.access$402((QzoneIPCModule.StickerRecReq)localObject, paramString3);
        QzoneIPCModule.StickerRecReq.access$100((QzoneIPCModule.StickerRecReq)localObject).countDown();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule
 * JD-Core Version:    0.7.0.1
 */