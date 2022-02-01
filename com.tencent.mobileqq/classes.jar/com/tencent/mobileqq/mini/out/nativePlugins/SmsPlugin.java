package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SmsPlugin
  implements NativePlugin
{
  public static final String API_SEND_SMS = "sendMsg";
  public static final String KEY_CONTENT = "text";
  public static final String KEY_DATA = "data";
  public static final String KEY_NUMBER = "to";
  public static final String KEY_SYSTEM_SMS_CONTENT = "sms_body";
  public static final String KEY_SYSTEM_SMS_PHONE = "address";
  public static final String KEY_SYSTEM_SMS_TYPE = "vnd.android-dir/mms-sms";
  public static final String KEY_SYSTEM_SMS_URI = "smsto:";
  private static final String TAG = "SmsPlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    QLog.d("SmsPlugin", 1, "start onInvoke");
    paramJSContext = paramJSContext.getActivity();
    if (paramJSContext == null)
    {
      QLog.d("SmsPlugin", 1, "SmsPlugin invoke, but activity is null");
      return;
    }
    Object localObject = paramJSONObject.optJSONObject("data");
    if (localObject == null)
    {
      QLog.d("SmsPlugin", 1, "SmsPlugin invoke, but dataJson is null");
      return;
    }
    paramJSONObject = ((JSONObject)localObject).optString("to", "");
    localObject = ((JSONObject)localObject).optString("text", "");
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse("smsto:"));
      localIntent1.setType("vnd.android-dir/mms-sms");
      localIntent1.putExtra("address", paramJSONObject);
      localIntent1.putExtra("sms_body", (String)localObject);
      paramJSContext.startActivity(localIntent1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SmsPlugin", 1, new Object[] { "sendSms exception : ", localException.getMessage() });
      Intent localIntent2 = new Intent("android.intent.action.SENDTO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramJSONObject);
      localIntent2.setData(Uri.parse(localStringBuilder.toString()));
      localIntent2.putExtra("sms_body", (String)localObject);
      paramJSContext.startActivity(localIntent2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin
 * JD-Core Version:    0.7.0.1
 */