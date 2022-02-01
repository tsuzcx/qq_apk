package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpInterface$JsHttpCallback
  implements HttpCgiAsyncTask.Callback
{
  protected final WebView a;
  protected final String a;
  protected final boolean a;
  protected final String b;
  protected final String c;
  
  public HttpInterface$JsHttpCallback(HttpInterface paramHttpInterface, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.b = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.hasRight())
    {
      if (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler == null) {
        return;
      }
      LogUtility.c("HttpInterface", "onException >>> ");
      paramException = this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.obtainMessage(0);
      WebViewJS localWebViewJS = new WebViewJS();
      localWebViewJS.jdField_a_of_type_ComTencentSmttSdkWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
      paramException.obj = localWebViewJS;
      paramException.arg1 = 0;
      StringBuilder localStringBuilder;
      if (TextUtils.isEmpty(this.b))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
        localStringBuilder.append(this.c);
        localStringBuilder.append("\"});}void(0);");
        localWebViewJS.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(this.b);
        localStringBuilder.append("({\"guid\":\"");
        localStringBuilder.append(this.c);
        localStringBuilder.append("\",\"err\":\"\"});void(0);");
        localWebViewJS.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.sendMessage(paramException);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    Message localMessage;
    WebViewJS localWebViewJS;
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.hasRight())
    {
      if (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler == null) {
        return;
      }
      localObject = paramJSONObject;
      if (paramJSONObject == null) {
        localObject = new JSONObject();
      }
      localMessage = this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.obtainMessage(0);
      localWebViewJS = new WebViewJS();
      localWebViewJS.jdField_a_of_type_ComTencentSmttSdkWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
      localMessage.obj = localWebViewJS;
      localMessage.arg1 = 0;
    }
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool)
      {
        ((JSONObject)localObject).put("guid", this.c);
        paramJSONObject = ((JSONObject)localObject).toString();
      }
      else
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("guid", this.c);
        paramJSONObject.put("content", ((JSONObject)localObject).toString());
        paramJSONObject = paramJSONObject.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResult >>> ");
      ((StringBuilder)localObject).append(paramJSONObject);
      LogUtility.a("HttpInterface", ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess',");
        ((StringBuilder)localObject).append(paramJSONObject);
        ((StringBuilder)localObject).append(");}void(0);");
        localWebViewJS.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("javascript:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramJSONObject);
        ((StringBuilder)localObject).append(");void(0);");
        localWebViewJS.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      }
    }
    catch (JSONException paramJSONObject)
    {
      label278:
      break label278;
    }
    if (TextUtils.isEmpty(this.b))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
      paramJSONObject.append(this.c);
      paramJSONObject.append("\"});}void(0);");
      localWebViewJS.jdField_a_of_type_JavaLangString = paramJSONObject.toString();
    }
    else
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:");
      paramJSONObject.append(this.b);
      paramJSONObject.append("({\"guid\":\"");
      paramJSONObject.append(this.c);
      paramJSONObject.append("\",\"err\":\"json format error\"});void(0);");
      localWebViewJS.jdField_a_of_type_JavaLangString = paramJSONObject.toString();
    }
    this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.HttpInterface.JsHttpCallback
 * JD-Core Version:    0.7.0.1
 */