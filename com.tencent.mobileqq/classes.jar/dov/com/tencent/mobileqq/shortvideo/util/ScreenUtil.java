package dov.com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class ScreenUtil
{
  private static float jdField_a_of_type_Float;
  public static int a;
  private static Context jdField_a_of_type_AndroidContentContext = ;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 320;
    b = 480;
    WindowManager localWindowManager = (WindowManager)jdField_a_of_type_AndroidContentContext.getSystemService("window");
    jdField_a_of_type_Int = localWindowManager.getDefaultDisplay().getWidth();
    b = localWindowManager.getDefaultDisplay().getHeight();
  }
  
  public static int a(float paramFloat)
  {
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + jdField_a_of_type_Float);
    }
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
  
  @TargetApi(13)
  public static int a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (b = localPoint.y;; b = paramContext.getDefaultDisplay().getHeight()) {
      return b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil
 * JD-Core Version:    0.7.0.1
 */