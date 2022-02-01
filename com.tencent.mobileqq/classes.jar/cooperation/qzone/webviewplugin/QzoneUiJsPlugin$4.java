package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QzoneUiJsPlugin$4
  extends BroadcastReceiver
{
  QzoneUiJsPlugin$4(QzoneUiJsPlugin paramQzoneUiJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneUiJsPlugin", 2, paramContext);
    }
    if ("com.qzone.topic.video.FakeFeed".equals(paramContext)) {
      if (!TextUtils.isEmpty(QzoneUiJsPlugin.access$000(this.this$0))) {}
    }
    int i;
    do
    {
      JSONObject localJSONObject;
      do
      {
        return;
        paramContext = paramIntent.getStringExtra("key_topic_video_thumb_path");
        i = paramIntent.getIntExtra("key_topic_video_thumb_width", 0);
        int j = paramIntent.getIntExtra("key_topic_video_thumb_height", 0);
        if (TextUtils.isEmpty(paramContext))
        {
          QLog.w("QzoneUiJsPlugin", 1, "topic video upload, video path is empty");
          return;
        }
        localObject2 = QzoneDynamicAlbumPlugin.encodeBase64File(paramContext, i, j, true);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.w("QzoneUiJsPlugin", 1, "topic video upload pic not exist,imageBase64 empty. path=" + paramContext);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QzoneUiJsPlugin", 2, "topicUploadVideo base64=data:image/jpg;base64," + (String)localObject2);
        }
        localObject1 = paramIntent.getStringExtra("key_topic_video_shuoshuo_content");
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = "";
        }
        paramIntent = paramIntent.getStringExtra("key_topic_video_clientkey");
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("code", 0);
          localJSONObject = new JSONObject();
          localJSONObject.put("content", paramContext);
          localJSONObject.put("msg", "");
          localJSONObject.put("base64", "data:image/jpg;base64," + (String)localObject2);
          localJSONObject.put("timestamp", paramIntent);
          localJSONObject.put("isFakeFeed", true);
          ((JSONObject)localObject1).put("data", localJSONObject);
          this.this$0.parentPlugin.callJs(QzoneUiJsPlugin.access$000(this.this$0), new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
        catch (JSONException paramContext)
        {
          QLog.w("QzoneUiJsPlugin", 1, "topicUploadVideo fake feed  callback error", paramContext);
          return;
        }
        if (!"com.qzone.topic.video.HalfFakeFeed".equals(paramContext)) {
          break;
        }
      } while (TextUtils.isEmpty(QzoneUiJsPlugin.access$000(this.this$0)));
      paramContext = paramIntent.getStringExtra("key_topic_video_publish_msg");
      localObject1 = paramIntent.getStringExtra("key_topic_video_tid");
      paramIntent = paramIntent.getStringExtra("key_topic_video_clientkey");
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("code", 0);
        localJSONObject = new JSONObject();
        localJSONObject.put("msg", paramContext);
        localJSONObject.put("timestamp", paramIntent);
        localJSONObject.put("ugcKey", localObject1);
        ((JSONObject)localObject2).put("data", localJSONObject);
        this.this$0.parentPlugin.callJs(QzoneUiJsPlugin.access$000(this.this$0), new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (JSONException paramContext)
      {
        QLog.w("QzoneUiJsPlugin", 1, "topicUploadVideo half fake feed  callback error", paramContext);
        return;
      }
    } while ((!"com.qzone.h5.video.recordCallback".equals(paramContext)) || (TextUtils.isEmpty(QzoneUiJsPlugin.access$100(this.this$0))));
    paramContext = paramIntent.getStringExtra("param.thumbnailPath");
    if (TextUtils.isEmpty(paramContext))
    {
      QLog.e("QzoneUiJsPlugin", 1, "recordVideo callback thumbnailPath is empty");
      return;
    }
    Object localObject2 = QzoneDynamicAlbumPlugin.encodeBase64File(paramContext, paramIntent.getIntExtra("param.thumbnailWidth", 0), paramIntent.getIntExtra("param.thumbnailHeight", 0), true);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.w("QzoneUiJsPlugin", 1, "h5 video record pic not exist,imageBase64 empty. thumbnailPath=" + paramContext);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneUiJsPlugin", 2, "h5 video record base64=data:image/jpg;base64," + (String)localObject2);
    }
    Object localObject1 = paramIntent.getStringExtra("param.content");
    paramContext = (Context)localObject1;
    if (localObject1 == null) {
      paramContext = "";
    }
    boolean bool = paramIntent.getBooleanExtra("param.topicSyncQzone", false);
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", paramContext);
        if (bool)
        {
          i = 1;
          ((JSONObject)localObject1).put("sync_qzone", i);
          ((JSONObject)localObject1).put("thumbnail", "data:image/jpg;base64," + (String)localObject2);
          ((JSONObject)localObject1).put("video_info", QzoneUiJsPlugin.access$200(this.this$0, paramIntent));
          this.this$0.parentPlugin.callJs(QzoneUiJsPlugin.access$100(this.this$0), new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
      }
      catch (JSONException paramContext)
      {
        QLog.w("QzoneUiJsPlugin", 1, "recordVideo callback error", paramContext);
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUiJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */