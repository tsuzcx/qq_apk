package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GestureFps
{
  private static boolean jdField_a_of_type_Boolean = true;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if ((a()) && (this.jdField_a_of_type_Int > 0))
    {
      int i = (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
      i = Math.round(1000.0F * this.jdField_a_of_type_Int / i);
      HashMap localHashMap = new HashMap();
      localHashMap.put("actType", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("actFps", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureFps", true, 0L, 0L, localHashMap, null);
      QLog.d("GestureFps", 1, new Object[] { "report ActOcrGestureFps, type:", Integer.valueOf(this.jdField_b_of_type_Int), " fps:", Integer.valueOf(i) });
    }
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      this.jdField_b_of_type_Int = paramInt;
      long l = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Long = l;
      this.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void b()
  {
    long l;
    if (a())
    {
      l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
      if (l <= 40L) {
        break label66;
      }
      Log.e("GestureFps", "Frame time: " + l);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
      label66:
      if (l > 20L) {
        Log.w("GestureFps", "Frame time: " + l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.GestureFps
 * JD-Core Version:    0.7.0.1
 */