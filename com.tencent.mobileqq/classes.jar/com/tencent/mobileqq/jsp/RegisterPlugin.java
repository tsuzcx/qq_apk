package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterPlugin
  extends WebViewPlugin
{
  private boolean a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("reg_sig");
      localObject = ((JSONObject)localObject).getString("face_result");
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        QLog.e("RegisterPlugin", 1, "handleFaceRecogResult: regSig or faceResult is empty");
        return false;
      }
      Intent localIntent = new Intent("action_qq_register_face_recognize_assist");
      localIntent.setPackage(this.mRuntime.a().getPackageName());
      localIntent.putExtra("reg_sig", paramString);
      localIntent.putExtra("face_result", (String)localObject);
      this.mRuntime.a().sendBroadcast(localIntent);
      QLog.d("RegisterPlugin", 1, "handleFaceRecogResult: sendBroadcast.");
      return true;
    }
    catch (JSONException paramString)
    {
      QLog.e("RegisterPlugin", 1, "handleJsRequest: JsonException", paramString);
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    QLog.d("RegisterPlugin", 1, "handleJsRequest: " + paramString3);
    if ((!"register".equals(paramString2)) || (this.mRuntime == null) || (this.mRuntime.a() == null)) {
      QLog.d("RegisterPlugin", 1, "handleJsRequest: null check fail return false");
    }
    while (!"notifyFaceRecogResult".equals(paramString3)) {
      return false;
    }
    if (paramVarArgs.length < 1)
    {
      QLog.e("RegisterPlugin", 1, "handleJsRequest: args length: " + paramVarArgs.length);
      return false;
    }
    return a(paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.RegisterPlugin
 * JD-Core Version:    0.7.0.1
 */