package com.tencent.mobileqq.search.util;

import android.content.Context;
import android.os.SystemClock;
import anvx;
import bcnj;
import bhdj;
import bhhd;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VADHelper
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = VADHelper.class.getSimpleName();
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static boolean a;
  private static ConcurrentHashMap<String, Long[]> b;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_Int = bhhd.b;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap());
    jdField_a_of_type_Boolean = false;
  }
  
  public static float a(String paramString)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (jdField_a_of_type_Boolean)
    {
      f1 = f2;
      if (paramString != null)
      {
        Long[] arrayOfLong = (Long[])jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        f1 = f2;
        if (arrayOfLong != null)
        {
          f1 = f2;
          if (arrayOfLong[0].longValue() > 0L)
          {
            f2 = (float)arrayOfLong[1].longValue() / (float)arrayOfLong[0].longValue();
            f1 = f2;
            if (QLog.isColorLevel())
            {
              QLog.i(jdField_a_of_type_JavaLangString, 2, paramString + ", AVG.cost=" + arrayOfLong[1].longValue() / arrayOfLong[0].longValue() + " totalTime:" + arrayOfLong[1] + " count:" + arrayOfLong[0]);
              f1 = f2;
            }
          }
        }
      }
    }
    return f1;
  }
  
  public static long a(String paramString)
  {
    if ((jdField_a_of_type_Boolean) && (paramString != null))
    {
      Long[] arrayOfLong = (Long[])jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((arrayOfLong != null) && (arrayOfLong[0].longValue() > 0L))
      {
        Long localLong = arrayOfLong[1];
        if (localLong != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, paramString + ", AVG.cost=" + arrayOfLong[1].longValue() / arrayOfLong[0].longValue() + " totalTime:" + arrayOfLong[1] + " count:" + arrayOfLong[0]);
          }
          return localLong.longValue();
        }
        return 0L;
      }
    }
    return 0L;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("服务器识别耗时：" + a("voice_search_server_cost") + " ms \n");
    localStringBuilder.append("预搜索耗时：" + a("voice_search_pre_cost") + " ms \n");
    localStringBuilder.append("精确搜索耗时：" + a("voice_search_accurate_cost") + " ms \n");
    localStringBuilder.append("模糊搜索耗时：" + a("voice_search_approximate_cost") + " ms \n");
    localStringBuilder.append("本地搜索总耗时：" + a("voice_search_als_cost") + " ms \n");
    localStringBuilder.append("语音搜索总耗时：" + a("voice_search_all_cost") + " ms \n");
    localStringBuilder.append("EditDistance总耗时：" + a("voice_search_distance_cost") + " ms,平均 ：" + String.format("%.4f", new Object[] { Float.valueOf(a("voice_search_distance_cost")) }) + " ms \n");
    localStringBuilder.append("声母韵母总耗时：" + a("voice_search_sy_cost") + " ms,平均 ：" + String.format("%.4f", new Object[] { Float.valueOf(a("voice_search_sy_cost")) }) + " ms");
    QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    if ((jdField_b_of_type_Boolean) && (!c))
    {
      bhdj.a(paramContext, 230, anvx.a(2131715396), localStringBuilder.toString(), "", "ok", new bcnj(), null).show();
      c = true;
    }
    a();
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      long l = SystemClock.uptimeMillis();
      if (paramString != null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
      }
    }
  }
  
  public static void b(String paramString)
  {
    long l1;
    Long localLong;
    Long[] arrayOfLong;
    if (jdField_a_of_type_Boolean)
    {
      l1 = SystemClock.uptimeMillis();
      if (paramString != null)
      {
        localLong = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localLong != null)
        {
          arrayOfLong = (Long[])jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (arrayOfLong != null) {
            break label87;
          }
          arrayOfLong = new Long[2];
          arrayOfLong[0] = Long.valueOf(1L);
          arrayOfLong[1] = Long.valueOf(l1 - localLong.longValue());
        }
      }
    }
    for (;;)
    {
      jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, arrayOfLong);
      return;
      label87:
      arrayOfLong[0] = Long.valueOf(arrayOfLong[0].longValue() + 1L);
      long l2 = arrayOfLong[1].longValue();
      arrayOfLong[1] = Long.valueOf(l1 - localLong.longValue() + l2);
    }
  }
  
  public native int calcOneFrameBytes(int paramInt1, int paramInt2);
  
  public native long create(String paramString);
  
  public native int destroy(long paramLong);
  
  public native int init(long paramLong, int paramInt1, int paramInt2);
  
  public native int process(long paramLong, byte[] paramArrayOfByte, int paramInt, float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.VADHelper
 * JD-Core Version:    0.7.0.1
 */