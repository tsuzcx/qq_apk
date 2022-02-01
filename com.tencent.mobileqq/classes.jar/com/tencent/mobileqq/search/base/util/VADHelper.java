package com.tencent.mobileqq.search.base.util;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VADHelper
{
  private static int jdField_a_of_type_Int = RecordParams.b;
  private static String jdField_a_of_type_JavaLangString = "VADHelper";
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  public static boolean a;
  private static ConcurrentHashMap<String, Long[]> b;
  public static boolean b;
  public static boolean c = false;
  
  static
  {
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap());
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public static float a(String paramString)
  {
    if ((jdField_a_of_type_Boolean) && (paramString != null))
    {
      Long[] arrayOfLong = (Long[])jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((arrayOfLong != null) && (arrayOfLong[0].longValue() > 0L))
      {
        float f2 = (float)arrayOfLong[1].longValue() / (float)arrayOfLong[0].longValue();
        f1 = f2;
        if (!QLog.isColorLevel()) {
          return f1;
        }
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(", AVG.cost=");
        localStringBuilder.append(arrayOfLong[1].longValue() / arrayOfLong[0].longValue());
        localStringBuilder.append(" totalTime:");
        localStringBuilder.append(arrayOfLong[1]);
        localStringBuilder.append(" count:");
        localStringBuilder.append(arrayOfLong[0]);
        QLog.i(str, 2, localStringBuilder.toString());
        return f2;
      }
    }
    float f1 = 0.0F;
    return f1;
  }
  
  public static long a(String paramString)
  {
    boolean bool = jdField_a_of_type_Boolean;
    long l2 = 0L;
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (paramString != null)
      {
        Long[] arrayOfLong = (Long[])jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        l1 = l2;
        if (arrayOfLong != null)
        {
          l1 = l2;
          if (arrayOfLong[0].longValue() > 0L)
          {
            Long localLong = arrayOfLong[1];
            l1 = l2;
            if (localLong != null)
            {
              if (QLog.isColorLevel())
              {
                String str = jdField_a_of_type_JavaLangString;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(paramString);
                localStringBuilder.append(", AVG.cost=");
                localStringBuilder.append(arrayOfLong[1].longValue() / arrayOfLong[0].longValue());
                localStringBuilder.append(" totalTime:");
                localStringBuilder.append(arrayOfLong[1]);
                localStringBuilder.append(" count:");
                localStringBuilder.append(arrayOfLong[0]);
                QLog.i(str, 2, localStringBuilder.toString());
              }
              l1 = localLong.longValue();
            }
          }
        }
      }
    }
    return l1;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("服务器识别耗时：");
      localStringBuilder2.append(a("voice_search_server_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("预搜索耗时：");
      localStringBuilder2.append(a("voice_search_pre_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("精确搜索耗时：");
      localStringBuilder2.append(a("voice_search_accurate_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("模糊搜索耗时：");
      localStringBuilder2.append(a("voice_search_approximate_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("本地搜索总耗时：");
      localStringBuilder2.append(a("voice_search_als_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("语音搜索总耗时：");
      localStringBuilder2.append(a("voice_search_all_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("EditDistance总耗时：");
      localStringBuilder2.append(a("voice_search_distance_cost"));
      localStringBuilder2.append(" ms,平均 ：");
      localStringBuilder2.append(String.format("%.4f", new Object[] { Float.valueOf(a("voice_search_distance_cost")) }));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("声母韵母总耗时：");
      localStringBuilder2.append(a("voice_search_sy_cost"));
      localStringBuilder2.append(" ms,平均 ：");
      localStringBuilder2.append(String.format("%.4f", new Object[] { Float.valueOf(a("voice_search_sy_cost")) }));
      localStringBuilder2.append(" ms");
      localStringBuilder1.append(localStringBuilder2.toString());
      QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder1.toString());
      if ((jdField_b_of_type_Boolean) && (!c))
      {
        DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131715786), localStringBuilder1.toString(), "", "ok", new VADHelper.1(), null).show();
        c = true;
      }
      a();
    }
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
    if (jdField_a_of_type_Boolean)
    {
      long l = SystemClock.uptimeMillis();
      if (paramString != null)
      {
        Long localLong = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localLong != null)
        {
          Long[] arrayOfLong = (Long[])jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (arrayOfLong == null)
          {
            arrayOfLong = new Long[2];
            arrayOfLong[0] = Long.valueOf(1L);
            arrayOfLong[1] = Long.valueOf(l - localLong.longValue());
          }
          else
          {
            arrayOfLong[0] = Long.valueOf(arrayOfLong[0].longValue() + 1L);
            arrayOfLong[1] = Long.valueOf(arrayOfLong[1].longValue() + (l - localLong.longValue()));
          }
          jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, arrayOfLong);
        }
      }
    }
  }
  
  public native int calcOneFrameBytes(int paramInt1, int paramInt2);
  
  public native long create(String paramString);
  
  public native int destroy(long paramLong);
  
  public native int init(long paramLong, int paramInt1, int paramInt2);
  
  public native int process(long paramLong, byte[] paramArrayOfByte, int paramInt, float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.VADHelper
 * JD-Core Version:    0.7.0.1
 */