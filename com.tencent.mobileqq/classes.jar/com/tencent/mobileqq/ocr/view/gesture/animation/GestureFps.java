package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GestureFps
{
  private static boolean d = true;
  private long a;
  private long b;
  private int c;
  private int e;
  
  public static boolean a()
  {
    return d;
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      this.e = paramInt;
      long l = SystemClock.uptimeMillis();
      this.a = l;
      this.b = l;
      this.c = 0;
    }
  }
  
  public void b()
  {
    if ((a()) && (this.c > 0))
    {
      int i = (int)(SystemClock.uptimeMillis() - this.b);
      i = Math.round(this.c * 1000.0F / i);
      HashMap localHashMap = new HashMap();
      localHashMap.put("actType", String.valueOf(this.e));
      localHashMap.put("actFps", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureFps", true, 0L, 0L, localHashMap, null);
      QLog.d("GestureFps", 1, new Object[] { "report ActOcrGestureFps, type:", Integer.valueOf(this.e), " fps:", Integer.valueOf(i) });
    }
  }
  
  public void c()
  {
    if (a())
    {
      long l = SystemClock.uptimeMillis() - this.a;
      StringBuilder localStringBuilder;
      if (l > 40L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Frame time: ");
        localStringBuilder.append(l);
        Log.e("GestureFps", localStringBuilder.toString());
      }
      else if (l > 20L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Frame time: ");
        localStringBuilder.append(l);
        Log.w("GestureFps", localStringBuilder.toString());
      }
      this.c += 1;
      this.a = SystemClock.uptimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.GestureFps
 * JD-Core Version:    0.7.0.1
 */