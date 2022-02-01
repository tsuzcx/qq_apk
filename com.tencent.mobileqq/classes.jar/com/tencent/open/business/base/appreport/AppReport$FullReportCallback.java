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
  protected String b;
  protected WebView c;
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<AppReport> FullReportCallback onException >>> ");
    localStringBuilder.append(paramException.toString());
    LogUtility.b("AppReport", localStringBuilder.toString());
    AppReport.b(this.a);
    if ((this.b != null) && (this.c != null))
    {
      LogUtility.c("AppReport", "<AppReport> onException get app update list after full report");
      paramException = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      if (paramException != null) {
        paramException = paramException.getUin();
      } else {
        paramException = "";
      }
      AppUpdate.a(this.a, this.c, this.b, false, paramException);
    }
    AppReport.b = false;
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
      AppReport.a(this.a);
    } else {
      AppReport.b(this.a);
    }
    if ((this.b != null) && (this.c != null))
    {
      LogUtility.c("AppReport", "<AppReport> onResult get app update list after full report");
      paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.getUin();
      } else {
        paramJSONObject = "";
      }
      if (i == 0) {
        AppUpdate.a(this.a, this.c, this.b, true, paramJSONObject);
      } else {
        AppUpdate.a(this.a, this.c, this.b, false, paramJSONObject);
      }
    }
    AppReport.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.FullReportCallback
 * JD-Core Version:    0.7.0.1
 */