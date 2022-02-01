package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import bifw;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

class QZoneSharePictureJsPlugin$7
  implements Runnable
{
  QZoneSharePictureJsPlugin$7(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, JSONObject paramJSONObject, String paramString, bifw parambifw) {}
  
  public void run()
  {
    String str1 = this.val$jsonObject.optString("base64UBBText");
    if (!TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      try
      {
        str1 = new String(Base64.decode(str1, 2));
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool)
        {
          String str2 = this.val$jsonObject.optString("shareSource");
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(URLDecoder.decode(this.val$filePath));
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("images", localArrayList);
          localBundle.putInt("req_type", 1);
          localBundle.putBoolean("key_need_save_draft", false);
          localBundle.putString("shareSource", str2);
          int i = QZoneHelper.generateRequestCode(this.this$0.parentPlugin, this.val$runtime, 5);
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("summary", str1);
          }
          QZoneShareManager.publishToQzone(this.val$runtime.a(), this.val$runtime.a(), localBundle, null, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "writeMood: parse base64UBBText error:", localThrowable);
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */