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
  protected Context a;
  protected String b;
  protected int c;
  protected String d;
  protected WebView e;
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<AppReport> IncrementalReportCallback onException >>> ");
    localStringBuilder.append(paramException.toString());
    LogUtility.b("AppReport", localStringBuilder.toString());
    if (this.d == null)
    {
      paramException = this.b;
      if (paramException != null) {
        AppReport.a(this.a, paramException, this.c);
      }
    }
    if ((this.d != null) && (this.e != null))
    {
      LogUtility.c("AppReport", "<AppReport> onException get app update list after incremental report");
      paramException = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      if (paramException != null) {
        paramException = paramException.getUin();
      } else {
        paramException = "";
      }
      AppUpdate.a(this.a, this.e, this.d, false, paramException);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("<AppReport> IncrementalReportCallback onResult >>> ");
    paramJSONObject.append(localJSONObject.toString());
    LogUtility.b("AppReport", paramJSONObject.toString());
    int i = localJSONObject.optInt("code", -1);
    paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.getUin();
    } else {
      paramJSONObject = "";
    }
    if (i == 0)
    {
      AppReport.a.lock();
      this.a.deleteFile("appcenter_app_report_storage_file.txt");
      AppReport.a.unlock();
      try
      {
        if (localJSONObject.optInt("report_all") != 1) {
          break label158;
        }
        AppReport.a(this.a, this.d, this.e, paramJSONObject, true);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    else
    {
      AppReport.a(this.a, this.b, this.c);
    }
    label158:
    if ((this.d != null) && (this.e != null))
    {
      LogUtility.c("AppReport", "<AppReport> onResult get app update list after incremental report");
      if (i == 0)
      {
        AppUpdate.a(this.a, this.e, this.d, true, paramJSONObject);
        return;
      }
      AppUpdate.a(this.a, this.e, this.d, false, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.IncrementalReportCallback
 * JD-Core Version:    0.7.0.1
 */