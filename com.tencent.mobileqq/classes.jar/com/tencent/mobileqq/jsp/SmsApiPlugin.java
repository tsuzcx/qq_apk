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
  private SmsApiPlugin.MyHandler jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler;
  private SmsApiPlugin.SMSContentObserver jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public SmsApiPlugin()
  {
    this.mPluginNameSpace = "sms";
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver != null))
    {
      Context localContext = a();
      if (localContext != null) {
        localContext.getContentResolver().unregisterContentObserver(this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver);
      }
    }
    this.jdField_a_of_type_Boolean = false;
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
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("callback", null);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str)))
      {
        if (i <= 0) {
          return;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject = a();
          if (localObject == null) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler = new SmsApiPlugin.MyHandler(this);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver == null) {
            this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver = new SmsApiPlugin.SMSContentObserver(this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler, (Context)localObject, paramString, str);
          }
          this.jdField_a_of_type_Boolean = true;
          ((Context)localObject).getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver.a(paramString, str);
        }
        this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler.sendEmptyMessageDelayed(2, i * 1000);
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected Context a()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.a();
    }
    return null;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString });
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
          b();
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = this.TAG;
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
    b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver;
    if (localObject != null)
    {
      ((SmsApiPlugin.SMSContentObserver)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$SMSContentObserver = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler;
    if (localObject != null)
    {
      ((SmsApiPlugin.MyHandler)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqJspSmsApiPlugin$MyHandler = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.SmsApiPlugin
 * JD-Core Version:    0.7.0.1
 */