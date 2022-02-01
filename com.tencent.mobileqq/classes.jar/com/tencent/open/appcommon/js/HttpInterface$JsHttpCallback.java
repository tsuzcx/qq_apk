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
  protected final String b;
  protected final String c;
  protected final String d;
  protected final boolean e;
  
  public HttpInterface$JsHttpCallback(HttpInterface paramHttpInterface, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.a = paramWebView;
    this.c = paramString3;
    this.b = paramString2;
    this.d = paramString1;
    this.e = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    if (this.f.hasRight())
    {
      if (this.f.mHandler == null) {
        return;
      }
      LogUtility.c("HttpInterface", "onException >>> ");
      paramException = this.f.mHandler.obtainMessage(0);
      WebViewJS localWebViewJS = new WebViewJS();
      localWebViewJS.a = this.a;
      paramException.obj = localWebViewJS;
      paramException.arg1 = 0;
      StringBuilder localStringBuilder;
      if (TextUtils.isEmpty(this.c))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
        localStringBuilder.append(this.d);
        localStringBuilder.append("\"});}void(0);");
        localWebViewJS.b = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(this.c);
        localStringBuilder.append("({\"guid\":\"");
        localStringBuilder.append(this.d);
        localStringBuilder.append("\",\"err\":\"\"});void(0);");
        localWebViewJS.b = localStringBuilder.toString();
      }
      this.f.mHandler.sendMessage(paramException);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    Message localMessage;
    WebViewJS localWebViewJS;
    if (this.f.hasRight())
    {
      if (this.f.mHandler == null) {
        return;
      }
      localObject = paramJSONObject;
      if (paramJSONObject == null) {
        localObject = new JSONObject();
      }
      localMessage = this.f.mHandler.obtainMessage(0);
      localWebViewJS = new WebViewJS();
      localWebViewJS.a = this.a;
      localMessage.obj = localWebViewJS;
      localMessage.arg1 = 0;
    }
    try
    {
      boolean bool = this.e;
      if (bool)
      {
        ((JSONObject)localObject).put("guid", this.d);
        paramJSONObject = ((JSONObject)localObject).toString();
      }
      else
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("guid", this.d);
        paramJSONObject.put("content", ((JSONObject)localObject).toString());
        paramJSONObject = paramJSONObject.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResult >>> ");
      ((StringBuilder)localObject).append(paramJSONObject);
      LogUtility.a("HttpInterface", ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(this.b))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess',");
        ((StringBuilder)localObject).append(paramJSONObject);
        ((StringBuilder)localObject).append(");}void(0);");
        localWebViewJS.b = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("javascript:");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramJSONObject);
        ((StringBuilder)localObject).append(");void(0);");
        localWebViewJS.b = ((StringBuilder)localObject).toString();
      }
    }
    catch (JSONException paramJSONObject)
    {
      label278:
      break label278;
    }
    if (TextUtils.isEmpty(this.c))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
      paramJSONObject.append(this.d);
      paramJSONObject.append("\"});}void(0);");
      localWebViewJS.b = paramJSONObject.toString();
    }
    else
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:");
      paramJSONObject.append(this.c);
      paramJSONObject.append("({\"guid\":\"");
      paramJSONObject.append(this.d);
      paramJSONObject.append("\",\"err\":\"json format error\"});void(0);");
      localWebViewJS.b = paramJSONObject.toString();
    }
    this.f.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.HttpInterface.JsHttpCallback
 * JD-Core Version:    0.7.0.1
 */