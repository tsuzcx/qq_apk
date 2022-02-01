package com.tencent.rfw.barrage.util;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class RFWBarrageUtils
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
  private static final Date b = new Date();
  private static final StringBuilder c = new StringBuilder();
  private static final Formatter d = new Formatter(c, Locale.getDefault());
  private static float e = -1.0F;
  
  public static int a(float paramFloat)
  {
    Resources localResources = RFWQQUtils.a();
    if (e < 0.0F) {
      e = localResources.getDisplayMetrics().density;
    }
    return (int)(paramFloat * e + 0.5F);
  }
  
  public static int a(RFWBaseBarrage paramRFWBaseBarrage1, RFWBaseBarrage paramRFWBaseBarrage2)
  {
    if (paramRFWBaseBarrage1 == paramRFWBaseBarrage2) {
      return 0;
    }
    if (paramRFWBaseBarrage1 == null) {
      return -1;
    }
    if (paramRFWBaseBarrage2 == null) {
      return 1;
    }
    if (paramRFWBaseBarrage1.equals(paramRFWBaseBarrage2)) {
      return 0;
    }
    long l = paramRFWBaseBarrage1.x() - paramRFWBaseBarrage2.x();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    int i = paramRFWBaseBarrage1.y() - paramRFWBaseBarrage2.y();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    i = paramRFWBaseBarrage1.D() - paramRFWBaseBarrage2.D();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    i = paramRFWBaseBarrage1.z() - paramRFWBaseBarrage2.z();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    l = paramRFWBaseBarrage1.w() - paramRFWBaseBarrage2.w();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    i = paramRFWBaseBarrage1.q() - paramRFWBaseBarrage2.q();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return i;
  }
  
  public static int a(RFWBaseBarrage paramRFWBaseBarrage1, RFWBaseBarrage paramRFWBaseBarrage2, long paramLong)
  {
    if (!paramRFWBaseBarrage1.b(paramLong))
    {
      if (paramRFWBaseBarrage2.b(paramLong)) {
        return -1;
      }
      float[] arrayOfFloat1 = paramRFWBaseBarrage1.e(paramRFWBaseBarrage1.Q());
      float[] arrayOfFloat2 = paramRFWBaseBarrage2.e(paramRFWBaseBarrage1.Q());
      if (arrayOfFloat1 != null)
      {
        if (arrayOfFloat2 == null) {
          return -1;
        }
        int j = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / paramRFWBaseBarrage2.g());
        arrayOfFloat1 = paramRFWBaseBarrage1.e(paramRFWBaseBarrage1.j());
        paramRFWBaseBarrage1 = paramRFWBaseBarrage2.e(paramRFWBaseBarrage1.j());
        int i = j;
        if (arrayOfFloat1 != null)
        {
          i = j;
          if (paramRFWBaseBarrage1 != null) {
            i = Math.max(j, (int)((paramRFWBaseBarrage1[0] - arrayOfFloat1[2]) / paramRFWBaseBarrage2.g()));
          }
        }
        return i;
      }
    }
    return -1;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarrageUtils
 * JD-Core Version:    0.7.0.1
 */