package com.tencent.mobileqq.danmaku.util;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class DanmakuUtils
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
  private static final Date jdField_a_of_type_JavaUtilDate = new Date();
  private static final Formatter jdField_a_of_type_JavaUtilFormatter;
  
  static
  {
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    jdField_a_of_type_JavaUtilFormatter = new Formatter(jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
  }
  
  public static int a(float paramFloat)
  {
    if (jdField_a_of_type_Float < 0.0F) {
      jdField_a_of_type_Float = DanmakuDependImp.a().a().a().getDisplayMetrics().density;
    }
    return (int)(paramFloat * jdField_a_of_type_Float + 0.5F);
  }
  
  public static int a(BaseDanmaku paramBaseDanmaku1, BaseDanmaku paramBaseDanmaku2)
  {
    if (paramBaseDanmaku1 == paramBaseDanmaku2) {
      return 0;
    }
    if (paramBaseDanmaku1 == null) {
      return -1;
    }
    if (paramBaseDanmaku2 == null) {
      return 1;
    }
    if (paramBaseDanmaku1.equals(paramBaseDanmaku2)) {
      return 0;
    }
    long l = paramBaseDanmaku1.d() - paramBaseDanmaku2.d();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    int i = paramBaseDanmaku1.b() - paramBaseDanmaku2.b();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    i = paramBaseDanmaku1.e() - paramBaseDanmaku2.e();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    i = paramBaseDanmaku1.c() - paramBaseDanmaku2.c();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    l = paramBaseDanmaku1.c() - paramBaseDanmaku2.c();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    i = paramBaseDanmaku1.a() - paramBaseDanmaku2.a();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return i;
  }
  
  public static int a(BaseDanmaku paramBaseDanmaku1, BaseDanmaku paramBaseDanmaku2, long paramLong)
  {
    if (!paramBaseDanmaku1.b(paramLong))
    {
      if (paramBaseDanmaku2.b(paramLong)) {
        return -1;
      }
      float[] arrayOfFloat1 = paramBaseDanmaku1.a(paramBaseDanmaku1.e());
      float[] arrayOfFloat2 = paramBaseDanmaku2.a(paramBaseDanmaku1.e());
      if (arrayOfFloat1 != null)
      {
        if (arrayOfFloat2 == null) {
          return -1;
        }
        int j = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / paramBaseDanmaku2.c());
        arrayOfFloat1 = paramBaseDanmaku1.a(paramBaseDanmaku1.b());
        paramBaseDanmaku1 = paramBaseDanmaku2.a(paramBaseDanmaku1.b());
        int i = j;
        if (arrayOfFloat1 != null)
        {
          i = j;
          if (paramBaseDanmaku1 != null) {
            i = Math.max(j, (int)((paramBaseDanmaku1[0] - arrayOfFloat1[2]) / paramBaseDanmaku2.c()));
          }
        }
        return i;
      }
    }
    return -1;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 86400000L)
    {
      paramLong /= 1000L;
      long l1 = paramLong % 60L;
      long l2 = paramLong / 60L % 60L;
      long l3 = paramLong / 3600L;
      paramLong = l1;
      if (l1 < 0L) {
        paramLong = 0L;
      }
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      if (l2 > 0L) {
        return jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
      }
      return jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    jdField_a_of_type_JavaUtilDate.setTime(paramLong);
    return jdField_a_of_type_JavaTextSimpleDateFormat.format(jdField_a_of_type_JavaUtilDate);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.util.DanmakuUtils
 * JD-Core Version:    0.7.0.1
 */