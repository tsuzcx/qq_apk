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
    QFlutterContainerDelegate.b(this.a).a(paramLaunchResult);
    QFlutterContainerDelegate.a(this.a, paramLaunchResult);
    if (paramLaunchResult.a())
    {
      QFlutterContainerDelegate.a(this.a, true);
      if (QFlutterContainerDelegate.c(this.a) == null)
      {
        QFlutterContainerDelegate.d(this.a);
        if (QFlutterContainerDelegate.e(this.a)) {
          QFlutterContainerDelegate.f(this.a);
        }
        if (QFlutterContainerDelegate.g(this.a)) {
          QFlutterContainerDelegate.h(this.a);
        }
      }
    }
    else
    {
      QQToast.makeText(QFlutterContainerDelegate.i(this.a).getContext(), 1, 2131891374, 1).show();
      QFlutterContainerDelegate.i(this.a).b().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate.2
 * JD-Core Version:    0.7.0.1
 */