package cooperation.qzone.webviewplugin.mood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class QzoneSelectMoodPictureJsPlugin
  extends WebViewPlugin
{
  public static final String KEY_WEB_PICTURE_ATTACHINFO = "mood_web_pic_attachinfo";
  public static final String KEY_WEB_PICTURE_HEIGHT = "mood_web_pic_height";
  public static final String KEY_WEB_PICTURE_ID = "mood_web_pic_id";
  public static final String KEY_WEB_PICTURE_SOURCEID = "mood_web_pic_sourceid";
  public static final String KEY_WEB_PICTURE_URL = "mood_web_pic_url";
  public static final String KEY_WEB_PICTURE_WIDTH = "mood_web_pic_width";
  public static final String MUSIC_METHOD_NAMESPACE = "QzMoodSelectPicture";
  public static final String select_picture_func_name = "selectPicture";
  private String TAG = QzoneSelectMoodPictureJsPlugin.class.getSimpleName();
  
  public QzoneSelectMoodPictureJsPlugin()
  {
    this.mPluginNameSpace = "QzMoodSelectPicture";
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMoodSelectPicture")) {
      return false;
    }
    if ((paramString3.equals("selectPicture")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramJsBridgeListener = new Intent();
      paramString1 = new Bundle();
    }
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramString1.putString("mood_web_pic_url", paramString2.getString("url"));
      paramString1.putString("mood_web_pic_id", paramString2.getString("imageId"));
      paramString1.putInt("mood_web_pic_width", paramString2.getInt("width"));
      paramString1.putInt("mood_web_pic_height", paramString2.getInt("height"));
      paramString1.putInt("mood_web_pic_sourceid", paramString2.optInt("sourceid"));
      paramString1.putString("mood_web_pic_attachinfo", paramString2.getString("quickselect"));
    }
    catch (Exception paramString2)
    {
      label135:
      break label135;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 2, "select mood picture,decode param error");
    }
    paramJsBridgeListener.putExtras(paramString1);
    if (this.mRuntime.d() != null)
    {
      this.mRuntime.d().setResult(-1, paramJsBridgeListener);
      this.mRuntime.d().finish();
    }
    return true;
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", "https://www.baidu.com");
    localIntent.putExtras(localBundle);
    this.mRuntime.d().setResult(50, localIntent);
  }
  
  protected void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.mood.QzoneSelectMoodPictureJsPlugin
 * JD-Core Version:    0.7.0.1
 */