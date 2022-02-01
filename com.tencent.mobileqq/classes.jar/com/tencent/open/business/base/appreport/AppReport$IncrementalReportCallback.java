package com.tencent.open.business.base.appreport;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.locks.Lock;
import org.json.JSONObject;

public class AppReport$IncrementalReportCallback
  implements HttpCgiAsyncTask.Callback
{
  protected int a;
  protected Context a;
  protected WebView a;
  protected String a;
  protected String b;
  
  public void a(Exception paramException)
  {
    LogUtility.b("AppReport", "<AppReport> IncrementalReportCallback onException >>> " + paramException.toString());
    if ((this.b == null) && (this.jdField_a_of_type_JavaLangString != null)) {
      AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      LogUtility.c("AppReport", "<AppReport> onException get app update list after incremental report");
      SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      paramException = "";
      if (localSimpleAccount != null) {
        paramException = localSimpleAccount.getUin();
      }
      AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, false, paramException);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    LogUtility.b("AppReport", "<AppReport> IncrementalReportCallback onResult >>> " + localJSONObject.toString());
    int i = localJSONObject.optInt("code", -1);
    paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.getUin();; paramJSONObject = "")
    {
      if (i == 0)
      {
        AppReport.a.lock();
        this.jdField_a_of_type_AndroidContentContext.deleteFile("appcenter_app_report_storage_file.txt");
        AppReport.a.unlock();
      }
      for (;;)
      {
        try
        {
          if (localJSONObject.optInt("report_all") == 1)
          {
            AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, paramJSONObject, true);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        while ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
        {
          LogUtility.c("AppReport", "<AppReport> onResult get app update list after incremental report");
          if (i != 0) {
            break label189;
          }
          AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, true, paramJSONObject);
          return;
          AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
      }
      label189:
      AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, false, paramJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.IncrementalReportCallback
 * JD-Core Version:    0.7.0.1
 */