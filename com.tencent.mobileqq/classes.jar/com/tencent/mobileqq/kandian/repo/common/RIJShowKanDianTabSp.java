package com.tencent.mobileqq.kandian.repo.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class RIJShowKanDianTabSp
{
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static int a(AppRuntime paramAppRuntime)
  {
    int i = -1;
    if (paramAppRuntime == null) {
      return -1;
    }
    String str = paramAppRuntime.getAccount();
    if (TextUtils.isEmpty(str)) {
      return -1;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) == null)
    {
      int j = RIJSPUtils.a(paramAppRuntime, true, true).getInt("user_kandian_show_config", -1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(j));
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("uin : ");
      paramAppRuntime.append(str);
      paramAppRuntime.append(" user kandiantab show config : ");
      paramAppRuntime.append(j);
      QLog.d("RIJShowKanDianTabSp", 2, paramAppRuntime.toString());
    }
    paramAppRuntime = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    if (paramAppRuntime != null) {
      i = paramAppRuntime.intValue();
    }
    return i;
  }
  
  public static Integer a(String paramString)
  {
    String str = RIJQQAppInterfaceUtil.a();
    Map localMap = jdField_a_of_type_JavaUtilMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    paramString = (Integer)localMap.get(localStringBuilder.toString());
    int i;
    if (paramString == null) {
      i = -1;
    } else {
      i = paramString.intValue();
    }
    return Integer.valueOf(i);
  }
  
  public static void a(int paramInt)
  {
    a("local_kd_tab_switch", Integer.valueOf(paramInt));
  }
  
  public static void a(String paramString, Integer paramInteger)
  {
    String str = RIJQQAppInterfaceUtil.a();
    Object localObject = jdField_a_of_type_JavaUtilMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    ((Map)localObject).put(localStringBuilder.toString(), paramInteger);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateKDTabConfigCache k: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", v: ");
    ((StringBuilder)localObject).append(paramInteger);
    ((StringBuilder)localObject).append(", account");
    ((StringBuilder)localObject).append(str);
    QLog.d("RIJShowKanDianTabSp", 1, ((StringBuilder)localObject).toString());
  }
  
  public static void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    int j = 0;
    if (localObject1 == null)
    {
      QLog.d("RIJShowKanDianTabSp", 1, new Object[] { "app is null, isShowKandianTabNew, isShowKandian = ", Integer.valueOf(0) });
      return false;
    }
    Object localObject2;
    boolean bool;
    int i;
    if (a("local_kd_tab_switch").intValue() == -1)
    {
      localObject2 = RIJSPUtils.a((AppRuntime)localObject1, true, true);
      if (localObject2 != null) {
        bool = ((SharedPreferences)localObject2).getBoolean("local_kd_tab_switch", true);
      } else {
        bool = false;
      }
      if (bool) {
        i = 1;
      } else {
        i = 0;
      }
      a(i);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isShowKandianTabNew cache is null, read from sp, ");
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      QLog.d("RIJShowKanDianTabSp", 1, ((StringBuilder)localObject2).toString());
    }
    else if (a("local_kd_tab_switch").intValue() == 1)
    {
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      ((StringBuilder)localObject2).append(" isShowKandianTab, isShowKandian = ");
      localObject1 = ((StringBuilder)localObject2).toString();
      i = j;
      if (bool) {
        i = 1;
      }
      QLog.d("RIJShowKanDianTabSp", 1, new Object[] { localObject1, Integer.valueOf(i) });
    }
    return b(bool);
  }
  
  public static boolean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isReadinjoyVideoChannel() channelType=");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
    }
    return paramInt == 3;
  }
  
  public static boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_daily_child_refresh_channelID");
    localStringBuilder.append(paramLong);
    return ((Boolean)RIJSPUtils.a(localStringBuilder.toString(), Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString, Object paramObject)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime != null)
    {
      if (paramObject == null) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJShowKanDianTabSp", 2, new Object[] { "updateKDSPWithKeyAndValue, key = ", paramString, ", value = ", paramObject });
      }
      paramAppRuntime = paramAppRuntime.edit();
      if ((paramObject instanceof String))
      {
        paramAppRuntime.putString(paramString, (String)paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break label109;
        }
        paramAppRuntime.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      }
      RIJSPUtils.a(paramAppRuntime, true);
      return true;
      label109:
      QLog.d("RIJShowKanDianTabSp", 2, "updateKDSPWithKeyAndValue, now not support this kind of instance.");
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean b()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = bool3;
    try
    {
      RIJMaybeInitializedAladdinConfig.a();
      bool1 = bool3;
      Object localObject = Aladdin.getConfig(394);
      bool1 = bool3;
      if (StudyModeManager.a())
      {
        bool2 = bool4;
        bool1 = bool3;
        if (((AladdinConfig)localObject).getIntegerFromString("hide_rijtab_in_study_mode", 0) == 1) {
          bool2 = true;
        }
        bool1 = bool2;
        localObject = new StringBuilder();
        bool1 = bool2;
        ((StringBuilder)localObject).append("study mode!  hideKandianTab, flag=");
        bool1 = bool2;
        ((StringBuilder)localObject).append(bool2);
        bool1 = bool2;
        QLog.d("RIJShowKanDianTabSp", 1, ((StringBuilder)localObject).toString());
        return bool2;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideKandianTab error! msg=");
      localStringBuilder.append(localException);
      QLog.d("RIJShowKanDianTabSp", 1, localStringBuilder.toString());
      bool2 = bool1;
    }
    return bool2;
  }
  
  private static boolean b(boolean paramBoolean)
  {
    return (paramBoolean) && (!b());
  }
  
  public static boolean c()
  {
    boolean bool2 = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance(StudyModeManager.a());
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    int i = a(RIJQQAppInterfaceUtil.a());
    if (i != -1)
    {
      a(true);
      if (i == 1) {
        bool1 = true;
      }
      a(bool1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("user_kandian_show_config");
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      }
    }
    return a();
  }
  
  public static boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp
 * JD-Core Version:    0.7.0.1
 */