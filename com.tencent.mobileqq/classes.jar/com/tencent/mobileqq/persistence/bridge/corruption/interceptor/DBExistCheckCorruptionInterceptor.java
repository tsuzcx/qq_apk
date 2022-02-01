package com.tencent.mobileqq.persistence.bridge.corruption.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBExistCheckCorruptionInterceptor
  extends CorruptionInterceptor
{
  public Void a(Interceptor.Chain<Void> paramChain)
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    localObject = ((AppRuntime)localObject).getApplication().getDatabasePath(((AppRuntime)localObject).getAccount() + ".db");
    if ((!((File)localObject).exists()) || (((File)localObject).length() == 0L))
    {
      HashMap localHashMap = new HashMap();
      if (((File)localObject).exists()) {}
      for (paramChain = "existFalse";; paramChain = "lenZero")
      {
        localHashMap.put("reason", paramChain);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.l, true, -1L, 0L, localHashMap, null, false);
        FileUtils.e(((File)localObject).getPath());
        return null;
      }
    }
    return (Void)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBExistCheckCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */