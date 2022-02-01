package com.tencent.mobileqq.kandian.glue.report.task;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TaskException
{
  private static String a = "kandianreport.TaskException";
  
  public static void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exception", paramString);
      paramString = new StringBuilder();
      paramString.append(KandianReportSoLoader.a());
      paramString.append("");
      localJSONObject.put("so_version", paramString.toString());
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("sys_version", DeviceInfoUtil.e());
      localJSONObject.put("qq_version", DeviceInfoUtil.c());
      paramString = new StringBuilder();
      paramString.append(TaskManager.a);
      paramString.append("");
      localJSONObject.put("version", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(AppSetting.a());
      paramString.append("");
      localJSONObject.put("appid", paramString.toString());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800982E", "0X800982E", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exception", paramString2);
      localJSONObject.put("taskId", paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(KandianReportSoLoader.a());
      paramString1.append("");
      localJSONObject.put("so_version", paramString1.toString());
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("sys_version", DeviceInfoUtil.e());
      localJSONObject.put("qq_version", DeviceInfoUtil.c());
      paramString1 = new StringBuilder();
      paramString1.append(TaskManager.a);
      paramString1.append("");
      localJSONObject.put("version", paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(AppSetting.a());
      paramString1.append("");
      localJSONObject.put("appid", paramString1.toString());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009830", "0X8009830", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exception", paramString);
      paramString = new StringBuilder();
      paramString.append(TaskManager.a);
      paramString.append("");
      localJSONObject.put("version", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(KandianReportSoLoader.a());
      paramString.append("");
      localJSONObject.put("so_version", paramString.toString());
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("sys_version", DeviceInfoUtil.e());
      localJSONObject.put("qq_version", DeviceInfoUtil.c());
      paramString = new StringBuilder();
      paramString.append(AppSetting.a());
      paramString.append("");
      localJSONObject.put("appid", paramString.toString());
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportException: ");
      localStringBuilder.append(localJSONObject.toString());
      QLog.d(paramString, 1, localStringBuilder.toString());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009831", "0X8009831", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskException
 * JD-Core Version:    0.7.0.1
 */