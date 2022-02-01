package com.tencent.mobileqq.kandian.base.view.widget;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyScreenShotReporter
{
  private static ReadInJoyScreenShotReporter a;
  private ScreenshotContentObserver b;
  private Integer c;
  private Integer d;
  
  public static ReadInJoyScreenShotReporter a(Activity paramActivity)
  {
    if (a == null)
    {
      a = new ReadInJoyScreenShotReporter();
      Object localObject = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      try
      {
        a.b = new ScreenshotContentObserver(paramActivity, i, j);
        a.b.a(new ReadInJoyScreenShotReporter.1());
      }
      catch (SecurityException paramActivity)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SecurityException error = ");
        ((StringBuilder)localObject).append(paramActivity.toString());
        QLog.e("ReadInJoyScreenShotReporter", 1, ((StringBuilder)localObject).toString());
        a.b = null;
      }
    }
    return a;
  }
  
  public void a()
  {
    ReadInJoyScreenShotReporter localReadInJoyScreenShotReporter = a;
    if (localReadInJoyScreenShotReporter != null)
    {
      localReadInJoyScreenShotReporter.c = null;
      localReadInJoyScreenShotReporter.d = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyScreenShotReporter localReadInJoyScreenShotReporter = a;
    if (localReadInJoyScreenShotReporter != null)
    {
      localReadInJoyScreenShotReporter.c = new Integer(paramInt2);
      a.d = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    Object localObject = a;
    if (localObject != null)
    {
      localObject = ((ReadInJoyScreenShotReporter)localObject).b;
      if (localObject != null)
      {
        ((ScreenshotContentObserver)localObject).a();
        a.b = null;
      }
    }
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter
 * JD-Core Version:    0.7.0.1
 */