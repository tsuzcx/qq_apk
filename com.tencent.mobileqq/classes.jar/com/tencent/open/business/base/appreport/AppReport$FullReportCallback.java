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
    LogUtility.b("AppReport", "<AppReport> FullReportCallback onException >>> " + paramException.toString());
    AppReport.b(this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      LogUtility.c("AppReport", "<AppReport> onException get app update list after full report");
      SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      paramException = "";
      if (localSimpleAccount != null) {
        paramException = localSimpleAccount.getUin();
      }
      AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, paramException);
    }
    AppReport.a = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    LogUtility.b("AppReport", "<AppReport> FullReportCallback onResult >>> " + ((JSONObject)localObject).toString());
    int i = ((JSONObject)localObject).optInt("code", -1);
    if (i == 0)
    {
      AppReport.a(this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        LogUtility.c("AppReport", "<AppReport> onResult get app update list after full report");
        localObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
        paramJSONObject = "";
        if (localObject != null) {
          paramJSONObject = ((SimpleAccount)localObject).getUin();
        }
        if (i != 0) {
          break label136;
        }
        AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, true, paramJSONObject);
      }
    }
    for (;;)
    {
      AppReport.a = false;
      return;
      AppReport.b(this.jdField_a_of_type_AndroidContentContext);
      break;
      label136:
      AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.FullReportCallback
 * JD-Core Version:    0.7.0.1
 */