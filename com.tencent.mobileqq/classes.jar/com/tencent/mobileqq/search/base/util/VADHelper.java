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
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  private static String d = "VADHelper";
  private static int e = RecordParams.b;
  private static ConcurrentHashMap<String, Long> f = new ConcurrentHashMap(new HashMap(8));
  private static ConcurrentHashMap<String, Long[]> g = new ConcurrentHashMap(new HashMap());
  
  public static void a()
  {
    f.clear();
    g.clear();
  }
  
  public static void a(Context paramContext)
  {
    if (!a) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("服务器识别耗时：");
      localStringBuilder2.append(c("voice_search_server_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("预搜索耗时：");
      localStringBuilder2.append(c("voice_search_pre_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("精确搜索耗时：");
      localStringBuilder2.append(c("voice_search_accurate_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("模糊搜索耗时：");
      localStringBuilder2.append(c("voice_search_approximate_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("本地搜索总耗时：");
      localStringBuilder2.append(c("voice_search_als_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("语音搜索总耗时：");
      localStringBuilder2.append(c("voice_search_all_cost"));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("EditDistance总耗时：");
      localStringBuilder2.append(c("voice_search_distance_cost"));
      localStringBuilder2.append(" ms,平均 ：");
      localStringBuilder2.append(String.format("%.4f", new Object[] { Float.valueOf(d("voice_search_distance_cost")) }));
      localStringBuilder2.append(" ms \n");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("声母韵母总耗时：");
      localStringBuilder2.append(c("voice_search_sy_cost"));
      localStringBuilder2.append(" ms,平均 ：");
      localStringBuilder2.append(String.format("%.4f", new Object[] { Float.valueOf(d("voice_search_sy_cost")) }));
      localStringBuilder2.append(" ms");
      localStringBuilder1.append(localStringBuilder2.toString());
      QLog.i(d, 2, localStringBuilder1.toString());
      if ((b) && (!c))
      {
        DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131913244), localStringBuilder1.toString(), "", "ok", new VADHelper.1(), null).show();
        c = true;
      }
      a();
    }
  }
  
  public static void a(String paramString)
  {
    if (a)
    {
      long l = SystemClock.uptimeMillis();
      if (paramString != null) {
        f.put(paramString, Long.valueOf(l));
      }
    }
  }
  
  public static void b(String paramString)
  {
    if (a)
    {
      long l = SystemClock.uptimeMillis();
      if (paramString != null)
      {
        Long localLong = (Long)f.remove(paramString);
        if (localLong != null)
        {
          Long[] arrayOfLong = (Long[])g.get(paramString);
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
          g.put(paramString, arrayOfLong);
        }
      }
    }
  }
  
  public static long c(String paramString)
  {
    boolean bool = a;
    long l2 = 0L;
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (paramString != null)
      {
        Long[] arrayOfLong = (Long[])g.get(paramString);
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
                String str = d;
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
  
  public static float d(String paramString)
  {
    if ((a) && (paramString != null))
    {
      Long[] arrayOfLong = (Long[])g.get(paramString);
      if ((arrayOfLong != null) && (arrayOfLong[0].longValue() > 0L))
      {
        float f2 = (float)arrayOfLong[1].longValue() / (float)arrayOfLong[0].longValue();
        f1 = f2;
        if (!QLog.isColorLevel()) {
          return f1;
        }
        String str = d;
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
  
  public native int calcOneFrameBytes(int paramInt1, int paramInt2);
  
  public native long create(String paramString);
  
  public native int destroy(long paramLong);
  
  public native int init(long paramLong, int paramInt1, int paramInt2);
  
  public native int process(long paramLong, byte[] paramArrayOfByte, int paramInt, float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.VADHelper
 * JD-Core Version:    0.7.0.1
 */