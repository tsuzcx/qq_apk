package com.tencent.mobileqq.jsp;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SmsApiPlugin
  extends WebViewPlugin
{
  private SmsApiPlugin.MyHandler a;
  private SmsApiPlugin.SMSContentObserver b;
  private boolean c;
  private String d;
  
  public SmsApiPlugin()
  {
    this.mPluginNameSpace = "sms";
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("senderMatcher", null);
      String str = ((JSONObject)localObject).optString("smsContentMatcher", null);
      int i = ((JSONObject)localObject).optInt("timeout", 0);
      this.d = ((JSONObject)localObject).optString("callback", null);
      if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(str)))
      {
        if (i <= 0) {
          return;
        }
        if (!this.c)
        {
          localObject = b();
          if (localObject == null) {
            return;
          }
          if (this.a == null) {
            this.a = new SmsApiPlugin.MyHandler(this);
          }
          if (this.b == null) {
            this.b = new SmsApiPlugin.SMSContentObserver(this.a, (Context)localObject, paramString, str);
          }
          this.c = true;
          ((Context)localObject).getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.b);
        }
        else if (this.b != null)
        {
          this.b.a(paramString, str);
        }
        this.a.removeMessages(2);
        this.a.sendEmptyMessageDelayed(2, i * 1000);
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c()
  {
    if ((this.c) && (this.b != null))
    {
      Context localContext = b();
      if (localContext != null) {
        localContext.getContentResolver().unregisterContentObserver(this.b);
      }
    }
    this.c = false;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(this.d)) {
      return;
    }
    callJs(this.d, new String[] { paramString });
  }
  
  protected Context b()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.d();
    }
    return null;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      if ("sms".equals(paramString2))
      {
        if ("startReceiver".equals(paramString3))
        {
          if (paramVarArgs != null)
          {
            if (paramVarArgs.length <= 0) {
              return false;
            }
            b(paramVarArgs[0]);
            return true;
          }
          return false;
        }
        if ("stopReceiver".equals(paramString3))
        {
          c();
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = this.mTAG;
          paramString1 = new StringBuilder();
          paramString1.append("can not handle objectname:");
          paramString1.append(paramString2);
          paramString1.append(" methodname:");
          paramString1.append(paramString3);
          QLog.i(paramJsBridgeListener, 2, paramString1.toString());
        }
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    c();
    Object localObject = this.b;
    if (localObject != null)
    {
      ((SmsApiPlugin.SMSContentObserver)localObject).a();
      this.b = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((SmsApiPlugin.MyHandler)localObject).a();
      this.a = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.SmsApiPlugin
 * JD-Core Version:    0.7.0.1
 */