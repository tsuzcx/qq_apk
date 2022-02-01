package com.tencent.mobileqq.persistence.bridge.corruption.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBExistCheckCorruptionInterceptor
  extends CorruptionInterceptor
{
  public Void a(Interceptor.Chain<Void> paramChain)
  {
    Object localObject2 = a();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = ((AppRuntime)localObject2).getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((AppRuntime)localObject2).getAccount());
    localStringBuilder.append(".db");
    localObject1 = ((MobileQQ)localObject1).getDatabasePath(localStringBuilder.toString());
    if ((((File)localObject1).exists()) && (((File)localObject1).length() != 0L))
    {
      a((AppRuntime)localObject2, (File)localObject1);
      return (Void)paramChain.proceed();
    }
    localObject2 = new HashMap();
    if (((File)localObject1).exists()) {
      paramChain = "existFalse";
    } else {
      paramChain = "lenZero";
    }
    ((HashMap)localObject2).put("reason", paramChain);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.w, true, -1L, 0L, (HashMap)localObject2, null, false);
    FileUtils.deleteFile(((File)localObject1).getPath());
    return null;
  }
  
  public void a(AppRuntime paramAppRuntime, File paramFile)
  {
    Object localObject = paramAppRuntime.getApplication().getDatabasePath("chat.trace");
    if ((paramFile.exists()) && ((!((File)localObject).exists()) || (((File)localObject).length() == 0L)))
    {
      QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db");
      FileUtils.copyFile(paramFile, (File)localObject);
    }
    paramFile = paramAppRuntime.getApplication();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAppRuntime.getAccount());
    ((StringBuilder)localObject).append(".db-wal");
    paramFile = paramFile.getDatabasePath(((StringBuilder)localObject).toString());
    localObject = paramAppRuntime.getApplication().getDatabasePath("chat.trace-wal");
    if ((!((File)localObject).exists()) && (paramFile.exists()) && (paramFile.length() > 0L))
    {
      QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db-wal");
      FileUtils.copyFile(paramFile, (File)localObject);
    }
    paramFile = paramAppRuntime.getApplication();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAppRuntime.getAccount());
    ((StringBuilder)localObject).append(".db-shm");
    paramFile = paramFile.getDatabasePath(((StringBuilder)localObject).toString());
    paramAppRuntime = paramAppRuntime.getApplication().getDatabasePath("chat.trace-shm");
    if ((!paramAppRuntime.exists()) && (paramFile.exists()) && (paramFile.length() > 0L))
    {
      QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db-shm");
      FileUtils.copyFile(paramFile, paramAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBExistCheckCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */