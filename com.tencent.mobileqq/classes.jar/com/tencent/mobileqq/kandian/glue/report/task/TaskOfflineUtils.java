package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class TaskOfflineUtils
{
  private static String a = "kandianreport.TaskOfflineUtils";
  
  public static TaskOfflineUtils.ConfigData a(String paramString, int paramInt)
  {
    TaskOfflineUtils.ConfigData localConfigData = new TaskOfflineUtils.ConfigData();
    Object localObject = OfflineEnvHelper.a(paramString);
    if (localObject == null)
    {
      QLog.d(a, 2, "checkOffLineConfig: offline root dir is null");
      return localConfigData;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("log_task_config.geojson");
    paramString = ((StringBuilder)localObject).toString();
    localObject = new File(paramString);
    try
    {
      if (!((File)localObject).exists())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkOffLineConfig: there is not file ");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        return localConfigData;
      }
      paramString = new JSONObject(a(new FileInputStream((File)localObject)));
      int i = paramString.getInt("version_id");
      int j = paramString.getInt("support_min_version_id");
      localConfigData.jdField_a_of_type_Int = i;
      localConfigData.b = j;
      paramString = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("version_id : ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("  support_min_version_id: ");
      ((StringBuilder)localObject).append(j);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      if (i == paramInt)
      {
        localConfigData.jdField_a_of_type_Boolean = true;
        return localConfigData;
      }
      if ((i > paramInt) && (j <= paramInt))
      {
        localConfigData.jdField_a_of_type_Boolean = true;
        return localConfigData;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e(a, 1, "checkOffLineConfig: throwable", paramString);
    }
    return localConfigData;
  }
  
  public static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        try
        {
          String str = localBufferedReader.readLine();
          if (str != null)
          {
            localStringBuilder.append(str);
            continue;
          }
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            QLog.e(a, 1, QLog.getStackTraceString(paramInputStream));
          }
          QLog.d(a, 2, "fail to read string from input stream due to OOM");
        }
        finally
        {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        continue;
      }
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException paramInputStream)
      {
        QLog.e(a, 1, QLog.getStackTraceString(paramInputStream));
        return null;
      }
    }
    QLog.d(a, 2, "fail to read string from input stream");
    paramInputStream.close();
    return localObject.toString();
    try
    {
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      QLog.e(a, 1, QLog.getStackTraceString(paramInputStream));
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bid : ");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    try
    {
      HtmlOffline.a();
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a, 1, "HtmlOffline init ", localThrowable);
    }
    ThreadManager.executeOnFileThread(new TaskOfflineUtils.1(paramString, paramInt, paramOfflineCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils
 * JD-Core Version:    0.7.0.1
 */