package com.tencent.mobileqq.kandian.biz.flutter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJFlutterUtils$preDownloadFlutterActual$1
  implements Runnable
{
  RIJFlutterUtils$preDownloadFlutterActual$1(AppRuntime paramAppRuntime) {}
  
  public final void run()
  {
    QFlutterInstaller.a((QQAppInterface)this.a, (InstallCallback)new RIJFlutterUtils.preDownloadFlutterActual.1.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils.preDownloadFlutterActual.1
 * JD-Core Version:    0.7.0.1
 */