package com.tencent.timi.game.sp;

import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TGSharedPreferenceUtil
{
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tg_personal_sp_");
    localStringBuilder.append(ServerEnv.c());
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString, float paramFloat)
  {
    a(paramString, Float.valueOf(paramFloat));
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, Integer.valueOf(paramInt));
  }
  
  public static void a(String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong));
  }
  
  public static void a(String paramString, Object paramObject)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    BaseSharedPreUtil.a(localBaseApplication, a(), str, true, paramString, paramObject);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static float b(String paramString, float paramFloat)
  {
    paramString = b(paramString, Float.valueOf(paramFloat));
    if ((paramString instanceof Float)) {
      return ((Float)paramString).floatValue();
    }
    return paramFloat;
  }
  
  public static int b(String paramString, int paramInt)
  {
    paramString = b(paramString, Integer.valueOf(paramInt));
    if ((paramString instanceof Integer)) {
      return ((Integer)paramString).intValue();
    }
    return paramInt;
  }
  
  public static long b(String paramString, long paramLong)
  {
    paramString = b(paramString, Long.valueOf(paramLong));
    if ((paramString instanceof Long)) {
      return ((Long)paramString).longValue();
    }
    return paramLong;
  }
  
  public static Object b(String paramString, Object paramObject)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    return BaseSharedPreUtil.a(localBaseApplication, a(), str, paramString, paramObject);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1, paramString2);
    if ((paramString1 instanceof String)) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    paramString = b(paramString, Boolean.valueOf(paramBoolean));
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.TGSharedPreferenceUtil
 * JD-Core Version:    0.7.0.1
 */