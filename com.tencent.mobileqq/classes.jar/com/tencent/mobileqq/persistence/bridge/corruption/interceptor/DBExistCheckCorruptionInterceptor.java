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
      localObject2 = ((AppRuntime)localObject2).getApplication().getDatabasePath("chat.trace");
      if ((((File)localObject1).exists()) && ((!((File)localObject2).exists()) || (((File)localObject2).length() == 0L))) {
        FileUtils.copyFile((File)localObject1, (File)localObject2);
      }
      QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db");
      return (Void)paramChain.proceed();
    }
    localObject2 = new HashMap();
    if (((File)localObject1).exists()) {
      paramChain = "existFalse";
    } else {
      paramChain = "lenZero";
    }
    ((HashMap)localObject2).put("reason", paramChain);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.m, true, -1L, 0L, (HashMap)localObject2, null, false);
    FileUtils.deleteFile(((File)localObject1).getPath());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBExistCheckCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */