package com.tencent.mobileqq.colornote.swipeback;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class TouchStateDetector
{
  private static double jdField_a_of_type_Double = 0.25D;
  private static float jdField_a_of_type_Float;
  private static double jdField_b_of_type_Double = 0.5D;
  private static float jdField_b_of_type_Float;
  private static float c;
  private int jdField_a_of_type_Int;
  private int jdField_b_of_type_Int;
  
  public TouchStateDetector(Context paramContext)
  {
    a(paramContext);
    paramContext = paramContext.getResources();
    jdField_a_of_type_Float = paramContext.getDimensionPixelSize(2131297589);
    jdField_b_of_type_Float = paramContext.getDimensionPixelSize(2131297590);
    c = paramContext.getDimensionPixelSize(2131297588);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      this.jdField_a_of_type_Int = paramContext.getDefaultDisplay().getWidth();
      this.jdField_b_of_type_Int = paramContext.getDefaultDisplay().getHeight();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("TouchStateDetector", 1, paramContext, new Object[0]);
    }
  }
  
  public double a(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getRawX();
    paramMotionEvent.getRawY();
    if (f <= jdField_a_of_type_Double * this.jdField_a_of_type_Int) {
      return 0.0D;
    }
    if (f >= jdField_b_of_type_Double * this.jdField_a_of_type_Int) {
      return 1.0D;
    }
    return (f - jdField_a_of_type_Double * this.jdField_a_of_type_Int) / ((jdField_b_of_type_Double - jdField_a_of_type_Double) * this.jdField_a_of_type_Int);
  }
  
  public boolean a(MotionEvent paramMotionEvent, Context paramContext)
  {
    return (a(paramMotionEvent) + 1.0E-008D > 1.0D) && (paramMotionEvent.getRawX() > this.jdField_a_of_type_Int - jdField_b_of_type_Float) && (paramMotionEvent.getRawY() > this.jdField_b_of_type_Int - jdField_a_of_type_Float - c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.TouchStateDetector
 * JD-Core Version:    0.7.0.1
 */