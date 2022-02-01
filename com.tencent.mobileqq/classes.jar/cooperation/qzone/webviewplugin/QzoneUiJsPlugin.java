package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneUiJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private static final String LOG_TAG = "QzoneUiJsPlugin";
  private BroadcastReceiver broadcastReceiver = new QzoneUiJsPlugin.4(this);
  private String getVideoCoverCallback;
  private boolean isBroadcastReceiverRegistered = false;
  private String recordVideoCallback;
  private String uploadVideoCallback;
  
  private JSONObject convertVideoInfoToJson(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("param.videoPath");
    int i = paramIntent.getIntExtra("param.videoType", 0);
    Object localObject2 = paramIntent.getStringExtra("param.content");
    long l1 = paramIntent.getLongExtra("param.videoSize", 0L);
    String str1 = paramIntent.getStringExtra("param.thumbnailPath");
    long l2 = paramIntent.getLongExtra("param.duration", 0L);
    long l3 = paramIntent.getLongExtra("param.startTime", 0L);
    long l4 = paramIntent.getLongExtra("param.totalDuration", 0L);
    boolean bool1 = paramIntent.getBooleanExtra("param.needProcess", true);
    boolean bool2 = paramIntent.getBooleanExtra("param.topicSyncQzone", false);
    String str2 = paramIntent.getStringExtra("param.newFakeVid");
    Bundle localBundle = paramIntent.getBundleExtra("param.extras");
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("videoPath", localObject1);
      paramIntent.put("videoType", i);
      paramIntent.put("content", localObject2);
      paramIntent.put("videoSize", l1);
      paramIntent.put("thumbnailPath", str1);
      paramIntent.put("duration", l2);
      paramIntent.put("totalDuration", l4);
      paramIntent.put("needProcess", bool1);
      paramIntent.put("syncQzone", bool2);
      paramIntent.put("fakeVid", str2);
      paramIntent.put("startTime", l3);
      localObject1 = new JSONObject();
      if (localBundle != null)
      {
        localObject2 = localBundle.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str1 = (String)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(str1, localBundle.getInt(str1));
        }
      }
      paramIntent.put("encodeExtras", localObject1);
      return paramIntent;
    }
    catch (JSONException localJSONException)
    {
      QLog.w("QzoneUiJsPlugin", 1, "convertVideoInfoToJson error", localJSONException);
    }
    return paramIntent;
  }
  
  private void handleGetVideoCover(String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetVideoCover json=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QzoneUiJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.getString("callback");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.getVideoCoverCallback = ((String)localObject);
        paramString = paramString.getString("timestamp");
        if (!TextUtils.isEmpty(paramString))
        {
          this.parentPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneUiJsPlugin.3(this, paramString));
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneUiJsPlugin", 1, "handleGetVideoCover error", paramString);
    }
  }
  
  private void handlePreviewVideo(String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePreviewVideo json=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QzoneUiJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramString).optJSONObject("video_info");
      if (localObject == null)
      {
        QLog.e("QzoneUiJsPlugin", 1, "handlePreviewVideo video_info is empty");
        return;
      }
      paramString = ((JSONObject)localObject).optString("videoPath");
      int i = ((JSONObject)localObject).optInt("videoType");
      long l1 = ((JSONObject)localObject).optLong("startTime");
      long l2 = ((JSONObject)localObject).optLong("duration");
      localObject = ((JSONObject)localObject).optJSONObject("encodeExtras");
      Bundle localBundle = new Bundle();
      if (localObject != null)
      {
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putInt(str, ((JSONObject)localObject).optInt(str));
        }
      }
      if (i == 0)
      {
        QZoneVideoCommonUtils.gotoRecordPreview(this.parentPlugin.mRuntime.a(), i, paramString, l2, localBundle);
        return;
      }
      if (i == 1)
      {
        QZoneHelper.forwardToPreviewLocalView(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), i, paramString, l1, l2 + l1);
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneUiJsPlugin", 1, "handlePreviewVideo error", paramString);
    }
  }
  
  private void handleRecordVideo(String paramString)
  {
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRecordVideo json=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("QzoneUiJsPlugin", 4, ((StringBuilder)localObject1).toString());
    }
    registerBroadcast();
    for (;;)
    {
      int j;
      int k;
      int m;
      boolean bool2;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = paramString.getString("callback");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label502;
        }
        this.recordVideoCallback = ((String)localObject1);
        localObject1 = paramString.optString("ptv_id");
        String str1 = paramString.optString("confirm_btn_text");
        j = paramString.optInt("need_input_text", 0);
        if (j == 0) {
          break label503;
        }
        i = paramString.optInt("need_sync_qzone", 0);
        k = paramString.optInt("is_original_video", 0);
        m = paramString.optInt("need_edit_video", 0);
        boolean bool6 = paramString.optBoolean("support_local_video", true);
        Object localObject2 = paramString.optJSONObject("last_video");
        if ((localObject2 != null) && (((JSONObject)localObject2).optInt("videoType") == 0))
        {
          localObject2 = ((JSONObject)localObject2).optString("videoPath");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.parentPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneUiJsPlugin.1(this, (String)localObject2));
          }
        }
        localObject2 = new Intent();
        bool1 = paramString.optBoolean("support_beauty", true);
        bool2 = paramString.optBoolean("support_dd", true);
        bool3 = paramString.optBoolean("support_filter", true);
        bool4 = paramString.optBoolean("dd_category_unfold", false);
        String str2 = paramString.optString("dd_category_name");
        try
        {
          String str3 = paramString.optString("dd_item_id");
          bool5 = paramString.optBoolean("filter_category_unfold", false);
          String str4 = paramString.optString("filter_category_name");
          String str5 = paramString.optString("filter_item_id");
          int n = paramString.optInt("force_camera", 0);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_BEAUTY", bool1);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_SUPPORT_DD", bool2);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_SUPPORT_FILTER", bool3);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_UNFOLD_DD", bool4);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_DD_CATEGORY_NAME", str2);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_DD_ITEM_ID", str3);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_UNFOLD_FILTER", bool5);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_FILTER_CATEGORY_NAME", str4);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_FILTER_ITEM_ID", str5);
          ((Intent)localObject2).putExtra("PeakConstants.ARG_FORCE_CAMERA", n);
          paramString = this.parentPlugin.mRuntime.a();
          if (QZoneVipInfoManager.a().a() <= 0) {
            break label508;
          }
          bool1 = true;
        }
        catch (JSONException paramString)
        {
          break label492;
        }
        QZoneVideoCommonUtils.installVideoActivity(paramString, "ref_h5_record_video", bool1, bool2, bool3, bool4, bool5, bool6, (String)localObject1, str1, (Intent)localObject2);
        return;
      }
      catch (JSONException paramString) {}
      label492:
      QLog.w("QzoneUiJsPlugin", 1, "handleRecordVideo error", paramString);
      label502:
      return;
      label503:
      int i = 0;
      continue;
      label508:
      boolean bool1 = false;
      if (j > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (m > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if (i > 0) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      if (k > 0) {
        bool5 = true;
      } else {
        bool5 = false;
      }
    }
  }
  
  private void handleTopicUploadVideo(String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTopicUploadVideo json=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QzoneUiJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
    registerBroadcast();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.getString("callback");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.uploadVideoCallback = ((String)localObject);
        }
        localObject = paramString.getString("topicId");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        boolean bool2 = "ptucamera".equals(paramString.optString("shoot"));
        paramString = this.parentPlugin.mRuntime.a();
        if (QZoneVipInfoManager.a().a() > 0)
        {
          bool1 = true;
          QZoneVideoCommonUtils.installVideoActivity(0L, paramString, true, true, "QZonePublishMoodTabActivity", bool1, true, (String)localObject, bool2, null, null, null);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.w("QzoneUiJsPlugin", 1, "topicUploadVideo error", paramString);
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private void handleUploadVideo(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleUploadVideo json=");
      localStringBuilder.append(paramString);
      QLog.d("QzoneUiJsPlugin", 4, localStringBuilder.toString());
    }
    try
    {
      if (new JSONObject(paramString).optJSONObject("video_info") == null)
      {
        QLog.e("QzoneUiJsPlugin", 1, "handleUploadVideo video_info is empty");
        return;
      }
      this.parentPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneUiJsPlugin.2(this, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneUiJsPlugin", 1, "handleUploadVideo error", paramString);
    }
  }
  
  private void registerBroadcast()
  {
    if (this.isBroadcastReceiverRegistered) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qzone.topic.video.FakeFeed");
    localIntentFilter.addAction("com.qzone.topic.video.HalfFakeFeed");
    localIntentFilter.addAction("com.qzone.h5.video.recordCallback");
    this.parentPlugin.mRuntime.a().registerReceiver(this.broadcastReceiver, localIntentFilter);
    this.isBroadcastReceiverRegistered = true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qzui".equals(paramString2))
    {
      if (this.parentPlugin == null) {
        return false;
      }
      if (("topicUploadVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        handleTopicUploadVideo(paramVarArgs[0]);
        return true;
      }
      if (("getVideoFaceData".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        handleGetVideoCover(paramVarArgs[0]);
        return true;
      }
      if (("recordVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        handleRecordVideo(paramVarArgs[0]);
        return true;
      }
      if (("previewVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        handlePreviewVideo(paramVarArgs[0]);
        return true;
      }
      if (("uploadVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        handleUploadVideo(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.isBroadcastReceiverRegistered)
    {
      this.parentPlugin.mRuntime.a().unregisterReceiver(this.broadcastReceiver);
      this.isBroadcastReceiverRegistered = false;
    }
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    super.onDestroy();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("QzoneUiJsPlugin", 1, "call js function,bundle is empty");
        return;
      }
      if ("cmd.videoGetFakeFeedCover".equals(paramString))
      {
        if (TextUtils.isEmpty(this.getVideoCoverCallback)) {
          return;
        }
        paramString = paramBundle.getString("param.videoCoverPath");
        int i = paramBundle.getInt("param.videoCoverWidth", 0);
        int j = paramBundle.getInt("param.videoCoverHeight", 0);
        paramBundle = paramBundle.getString("param.videoClientKey");
        if (TextUtils.isEmpty(paramString)) {
          paramString = "";
        } else {
          paramString = QzoneDynamicAlbumPlugin.encodeBase64File(paramString, i, j);
        }
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject1.put("code", 0);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("msg", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("data:image/jpg;base64,");
          localStringBuilder.append(paramString);
          localJSONObject2.put("base64", localStringBuilder.toString());
          localJSONObject2.put("timestamp", paramBundle);
          localJSONObject2.put("isFakeFeed", true);
          localJSONObject1.put("data", localJSONObject2);
          this.parentPlugin.callJs(this.getVideoCoverCallback, new String[] { localJSONObject1.toString() });
          return;
        }
        catch (JSONException paramString)
        {
          QLog.w("QzoneUiJsPlugin", 1, "topicUploadVideo fake feed  callback error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUiJsPlugin
 * JD-Core Version:    0.7.0.1
 */