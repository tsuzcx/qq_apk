package dov.com.tencent.mobileqq.shortvideo.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ShortVideoJsApiPlugin$1
  extends BroadcastReceiver
{
  ShortVideoJsApiPlugin$1(ShortVideoJsApiPlugin paramShortVideoJsApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    String str1 = paramIntent.getStringExtra("uuid");
    String str2 = paramIntent.getStringExtra("md5");
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("uuid", str1);
      paramIntent.put("md5", str2);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoJsApiPlugin", 2, "call webView, uuid" + str1 + ", md5:" + str2);
      }
      this.a.callJs(paramContext, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoJsApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */