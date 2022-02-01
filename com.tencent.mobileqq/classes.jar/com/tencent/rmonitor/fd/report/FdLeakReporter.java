package com.tencent.rmonitor.fd.report;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.lifecycle.ActivityInfo;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.fd.FdLeakConfigHelper;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.dumpers.FdProcFdDumper;
import com.tencent.rmonitor.fd.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FdLeakReporter
{
  private void a(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = new ReportData(0, paramString, true, 1L, 1L, paramJSONObject, true, true, BaseInfo.userMeta.uin);
    FdLeakAttaReporter.a(paramString);
    if (FdLeakConfigHelper.d()) {
      paramString = new FdLeakAttaReporter(paramString);
    } else {
      paramString = null;
    }
    ReporterMachine.a.a(paramJSONObject, paramString, true);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject.put("process_name", AppInfo.a(BaseInfo.app));
    paramJSONObject.put("plugin", 151);
    paramJSONObject.put("fd_max_limit", FdProcFdDumper.c());
    paramJSONObject.put("fd_threshold", FdLeakConfigHelper.e());
    paramJSONObject.put("fd_type", FdProcFdDumper.b(paramInt));
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fd_event", "fd_ceil");
      a(localJSONObject, paramInt);
      a("FdLeakReport", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportFdCeil failed: ");
      localStringBuilder.append(localJSONException.getMessage());
      LogUtils.d("FdLeakReporter", localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("fd_event", "fd_ceil_detail");
      a((JSONObject)localObject, paramInt1);
      ((JSONObject)localObject).put("fileObj", paramString);
      ((JSONObject)localObject).put("fd_count", paramInt2);
      ((JSONObject)localObject).put("is_client_analyzed", false);
      ((JSONObject)localObject).put("scene", ActivityInfo.a());
      a("FdLeakReportDump", (JSONObject)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDumpFileWithoutAnalyze failed: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      LogUtils.d("FdLeakReporter", ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(FdLeakIssueResult paramFdLeakIssueResult, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fd_event", "fd_ceil_detail");
      a(localJSONObject, paramFdLeakIssueResult.getFdType());
      localJSONObject.put("fileObj", paramString);
      localJSONObject.put("fd_count", paramFdLeakIssueResult.getFdCount());
      localJSONObject.put("is_client_analyzed", true);
      localJSONObject.put("scene", ActivityInfo.a());
      localJSONObject.put("fd_issue_content", paramFdLeakIssueResult.toJsonObject());
      a("FdLeakAnalyzed", localJSONObject);
      return;
    }
    catch (JSONException paramFdLeakIssueResult)
    {
      paramString = new StringBuilder();
      paramString.append("reportAnalyzeResult failed: ");
      paramString.append(paramFdLeakIssueResult.getMessage());
      LogUtils.d("FdLeakReporter", paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.report.FdLeakReporter
 * JD-Core Version:    0.7.0.1
 */