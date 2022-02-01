package com.tencent.mobileqq.kandian.base.view.widget;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyScreenShotReporter
{
  private static ReadInJoyScreenShotReporter jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter;
  private ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
  private Integer jdField_a_of_type_JavaLangInteger;
  private Integer b;
  
  public static ReadInJoyScreenShotReporter a(Activity paramActivity)
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter == null)
    {
      jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter = new ReadInJoyScreenShotReporter();
      Object localObject = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      try
      {
        jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(paramActivity, i, j);
        jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(new ReadInJoyScreenShotReporter.1());
      }
      catch (SecurityException paramActivity)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SecurityException error = ");
        ((StringBuilder)localObject).append(paramActivity.toString());
        QLog.e("ReadInJoyScreenShotReporter", 1, ((StringBuilder)localObject).toString());
        jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
      }
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter;
  }
  
  public void a()
  {
    ReadInJoyScreenShotReporter localReadInJoyScreenShotReporter = jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter;
    if (localReadInJoyScreenShotReporter != null)
    {
      localReadInJoyScreenShotReporter.jdField_a_of_type_JavaLangInteger = null;
      localReadInJoyScreenShotReporter.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyScreenShotReporter localReadInJoyScreenShotReporter = jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter;
    if (localReadInJoyScreenShotReporter != null)
    {
      localReadInJoyScreenShotReporter.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter;
    if (localObject != null)
    {
      localObject = ((ReadInJoyScreenShotReporter)localObject).jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
      if (localObject != null)
      {
        ((ScreenshotContentObserver)localObject).a();
        jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
      }
    }
    jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyScreenShotReporter = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter
 * JD-Core Version:    0.7.0.1
 */