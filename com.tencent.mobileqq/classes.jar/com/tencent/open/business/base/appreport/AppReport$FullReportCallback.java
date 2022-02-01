package com.tencent.open.business.base.appreport;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public class AppReport$FullReportCallback
  implements HttpCgiAsyncTask.Callback
{
  protected Context a;
  protected WebView a;
  protected String a;
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<AppReport> FullReportCallback onException >>> ");
    localStringBuilder.append(paramException.toString());
    LogUtility.b("AppReport", localStringBuilder.toString());
    AppReport.b(this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      LogUtility.c("AppReport", "<AppReport> onException get app update list after full report");
      paramException = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      if (paramException != null) {
        paramException = paramException.getUin();
      } else {
        paramException = "";
      }
      AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, paramException);
    }
    AppReport.a = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("<AppReport> FullReportCallback onResult >>> ");
    paramJSONObject.append(localJSONObject.toString());
    LogUtility.b("AppReport", paramJSONObject.toString());
    int i = localJSONObject.optInt("code", -1);
    if (i == 0) {
      AppReport.a(this.jdField_a_of_type_AndroidContentContext);
    } else {
      AppReport.b(this.jdField_a_of_type_AndroidContentContext);
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      LogUtility.c("AppReport", "<AppReport> onResult get app update list after full report");
      paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.getUin();
      } else {
        paramJSONObject = "";
      }
      if (i == 0) {
        AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, true, paramJSONObject);
      } else {
        AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, paramJSONObject);
      }
    }
    AppReport.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.FullReportCallback
 * JD-Core Version:    0.7.0.1
 */