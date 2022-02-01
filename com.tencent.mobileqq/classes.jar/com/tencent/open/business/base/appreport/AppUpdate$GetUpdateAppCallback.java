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
  protected final WebView a;
  protected final String a;
  protected boolean a;
  protected final String b;
  protected final String c;
  
  public AppUpdate$GetUpdateAppCallback(Context paramContext, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.b = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppUpdate onException >>> ");
    localStringBuilder.append(paramException.toString());
    LogUtility.c("AppUpdate", localStringBuilder.toString());
    if ((!this.jdField_a_of_type_Boolean) && (AppUtil.a(this.jdField_a_of_type_AndroidContentContext))) {
      AppReport.b(this.jdField_a_of_type_AndroidContentContext);
    }
    if (TextUtils.isEmpty(this.b))
    {
      paramException = new StringBuilder();
      paramException.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
      paramException.append(this.c);
      paramException.append("\"});}void(0);");
      paramException = paramException.toString();
    }
    else
    {
      paramException = new StringBuilder();
      paramException.append("javascript:");
      paramException.append(this.b);
      paramException.append("({\"guid\":\"");
      paramException.append(this.c);
      paramException.append("\",\"err\":\"\"});void(0);");
      paramException = paramException.toString();
    }
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramException);
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
      paramJSONObject.put("guid", this.c);
      paramJSONObject.put("content", localJSONObject.toString());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        ((StringBuilder)localObject).append(");void(0);");
        paramJSONObject = ((StringBuilder)localObject).toString();
      }
      localObject = paramJSONObject;
      if (this.jdField_a_of_type_Boolean) {
        break label334;
      }
      localObject = paramJSONObject;
      if (!AppUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label334;
      }
      if (localJSONObject.optInt("code", -1) == 0)
      {
        AppReport.a(this.jdField_a_of_type_AndroidContentContext);
        localObject = paramJSONObject;
      }
      else
      {
        AppReport.b(this.jdField_a_of_type_AndroidContentContext);
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
          if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
            this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl((String)localObject);
          }
          return;
        }
        catch (Exception paramJSONObject) {}
        paramJSONObject = paramJSONObject;
      }
    }
    if (TextUtils.isEmpty(this.b))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"");
      paramJSONObject.append(this.c);
      paramJSONObject.append("\"});}void(0);");
      localObject = paramJSONObject.toString();
    }
    else
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("javascript:");
      paramJSONObject.append(this.b);
      paramJSONObject.append("({\"guid\":\"");
      paramJSONObject.append(this.c);
      paramJSONObject.append("\",\"err\":\"json format error\"});void(0);");
      localObject = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppUpdate.GetUpdateAppCallback
 * JD-Core Version:    0.7.0.1
 */