package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.AppUtil;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class AppUpdate$GetUpdateAppCallback
  implements HttpCgiAsyncTask.Callback
{
  protected Context a;
  protected final WebView b;
  protected final String c;
  protected final String d;
  protected final String e;
  protected boolean f;
  
  public AppUpdate$GetUpdateAppCallback(Context paramContext, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramWebView;
    this.d = paramString3;
    this.c = paramString2;
    this.e = paramString1;
    this.f = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppUpdate onException >>> ");
    localStringBuilder.append(paramException.toString());
    LogUtility.c("AppUpdate", localStringBuilder.toString());
    if ((!this.f) && (AppUtil.c(this.a))) {
      AppReport.b(this.a);
    }
    if (TextUtils.isEmpty(this.d))
    {
      paramException = new StringBuilder();
      paramException.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
      paramException.append(this.e);
      paramException.append("\"});}void(0);");
      paramException = paramException.toString();
    }
    else
    {
      paramException = new StringBuilder();
      paramException.append("javascript:");
      paramException.append(this.d);
      paramException.append("({\"guid\":\"");
      paramException.append(this.e);
      paramException.append("\",\"err\":\"\"});void(0);");
      paramException = paramException.toString();
    }
    try
    {
      this.b.loadUrl(paramException);
      return;
    }
    catch (Exception paramException) {}
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("AppUpdate onResult >>> ");
    paramJSONObject.append(localJSONObject.toString());
    LogUtility.c("AppUpdate", paramJSONObject.toString());
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("guid", this.e);
      paramJSONObject.put("content", localJSONObject.toString());
      if (TextUtils.isEmpty(this.c))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess',");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        ((StringBuilder)localObject).append(");}void(0);");
        paramJSONObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("javascript:");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        ((StringBuilder)localObject).append(");void(0);");
        paramJSONObject = ((StringBuilder)localObject).toString();
      }
      localObject = paramJSONObject;
      if (this.f) {
        break label334;
      }
      localObject = paramJSONObject;
      if (!AppUtil.c(this.a)) {
        break label334;
      }
      if (localJSONObject.optInt("code", -1) == 0)
      {
        AppReport.a(this.a);
        localObject = paramJSONObject;
      }
      else
      {
        AppReport.b(this.a);
        localObject = paramJSONObject;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          label334:
          if (this.b != null) {
            this.b.loadUrl((String)localObject);
          }
          return;
        }
        catch (Exception paramJSONObject) {}
        paramJSONObject = paramJSONObject;
      }
    }
    if (TextUtils.isEmpty(this.d))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
      paramJSONObject.append(this.e);
      paramJSONObject.append("\"});}void(0);");
      localObject = paramJSONObject.toString();
    }
    else
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:");
      paramJSONObject.append(this.d);
      paramJSONObject.append("({\"guid\":\"");
      paramJSONObject.append(this.e);
      paramJSONObject.append("\",\"err\":\"json format error\"});void(0);");
      localObject = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppUpdate.GetUpdateAppCallback
 * JD-Core Version:    0.7.0.1
 */