package com.tencent.mobileqq.flutter.container;

import android.app.Activity;
import com.tencent.mobileqq.flutter.launch.LaunchListener;
import com.tencent.mobileqq.flutter.launch.LaunchResult;
import com.tencent.mobileqq.flutter.report.FirstFrameTrace;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QFlutterContainerDelegate$2
  implements LaunchListener
{
  QFlutterContainerDelegate$2(QFlutterContainerDelegate paramQFlutterContainerDelegate) {}
  
  public void a(LaunchResult paramLaunchResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launch onResult, ");
    localStringBuilder.append(paramLaunchResult);
    QLog.d("QFlutterContainerDelegate", 1, localStringBuilder.toString());
    QFlutterContainerDelegate.a(this.a).a(paramLaunchResult);
    QFlutterContainerDelegate.a(this.a, paramLaunchResult);
    if (paramLaunchResult.a())
    {
      QFlutterContainerDelegate.a(this.a, true);
      if (QFlutterContainerDelegate.a(this.a) == null)
      {
        QFlutterContainerDelegate.b(this.a);
        if (QFlutterContainerDelegate.a(this.a)) {
          QFlutterContainerDelegate.c(this.a);
        }
        if (QFlutterContainerDelegate.b(this.a)) {
          QFlutterContainerDelegate.d(this.a);
        }
      }
    }
    else
    {
      QQToast.a(QFlutterContainerDelegate.a(this.a).getContext(), 1, 2131693799, 1).a();
      QFlutterContainerDelegate.a(this.a).a().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate.2
 * JD-Core Version:    0.7.0.1
 */