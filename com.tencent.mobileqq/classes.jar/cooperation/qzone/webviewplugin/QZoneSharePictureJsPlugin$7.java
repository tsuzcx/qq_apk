package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

class QZoneSharePictureJsPlugin$7
  implements Runnable
{
  QZoneSharePictureJsPlugin$7(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, JSONObject paramJSONObject, String paramString, WebViewPlugin.PluginRuntime paramPluginRuntime) {}
  
  public void run()
  {
    String str1 = this.val$jsonObject.optString("base64UBBText");
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        str1 = new String(Base64.decode(str1, 2));
        boolean bool = TextUtils.isEmpty(str1);
        if (bool) {
          localCharSequence = null;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "writeMood: parse base64UBBText error:", localThrowable);
      }
    }
    CharSequence localCharSequence;
    String str2 = this.val$jsonObject.optString("shareSource");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(URLDecoder.decode(this.val$filePath));
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("images", localArrayList);
    localBundle.putInt("req_type", 1);
    localBundle.putBoolean("key_need_save_draft", false);
    localBundle.putString("shareSource", str2);
    int i = QZoneHelperProxyImpl.generateRequestCode(this.this$0.parentPlugin, this.val$runtime, 5);
    if (!TextUtils.isEmpty(localCharSequence)) {
      localBundle.putString("summary", localCharSequence);
    }
    QZoneShareManager.publishToQzone(this.val$runtime.a(), this.val$runtime.a(), localBundle, null, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */