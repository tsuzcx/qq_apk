package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class InitHook
  extends Step
{
  private static boolean a = false;
  
  @TargetApi(9)
  private static void a(boolean paramBoolean, Throwable paramThrowable, int paramInt)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("reportJavaHook", "");
    Object localObject3 = new Date();
    localObject3 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject3);
    if (((String)localObject3).equals(localObject2)) {
      return;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putString("reportJavaHook", (String)localObject3);
    if (Build.VERSION.SDK_INT > 8) {
      ((SharedPreferences.Editor)localObject1).apply();
    } else {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    if (paramBoolean)
    {
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "JavaHookSdkLoadSo", paramBoolean, 0L, 0L, null, "", true);
      return;
    }
    localObject1 = new HashMap();
    if (paramThrowable != null)
    {
      localObject2 = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter((Writer)localObject2));
      ((HashMap)localObject1).put("detail", localObject2.toString());
    }
    ((HashMap)localObject1).put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "JavaHookSdkLoadSo", paramBoolean, 0L, 0L, (HashMap)localObject1, "", true);
  }
  
  private static void b()
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      a = true;
      try
      {
        if (!"1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.hook_switch.name(), "0")))
        {
          QLog.d("InitHook", 1, "DPC OFF");
          a(false, null, 90002);
          return;
        }
        a(true, null, 0);
      }
      catch (Error localError)
      {
        a(false, localError, 90001);
      }
      catch (Exception localException)
      {
        a(false, localException, 90001);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "InitHook", true, 0L, 0L, null, "", true);
      return;
    }
    finally {}
  }
  
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (((IDPCApi)QRoute.api(IDPCApi.class)).getServerDataCurrentStateWithoutAccountManager() == 4)
      {
        b();
        return true;
      }
      ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(new InitHook.MyDPCObserver(null));
      return true;
    }
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitHook
 * JD-Core Version:    0.7.0.1
 */