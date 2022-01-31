package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import begz;
import bjdt;
import bjev;
import bjxe;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

public class QZoneSharePictureJsPlugin$7
  implements Runnable
{
  public QZoneSharePictureJsPlugin$7(bjxe parambjxe, JSONObject paramJSONObject, String paramString, begz parambegz) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("base64UBBText");
    if (!TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      try
      {
        str1 = new String(Base64.decode(str1, 2));
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool)
        {
          String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("shareSource");
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(URLDecoder.decode(this.jdField_a_of_type_JavaLangString));
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("images", localArrayList);
          localBundle.putInt("req_type", 1);
          localBundle.putBoolean("key_need_save_draft", false);
          localBundle.putString("shareSource", str2);
          int i = bjdt.a(this.this$0.a, this.jdField_a_of_type_Begz, 5);
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("summary", str1);
          }
          bjev.a(this.jdField_a_of_type_Begz.a(), this.jdField_a_of_type_Begz.a(), localBundle, null, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */