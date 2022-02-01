package com.tencent.mobileqq.flutter.launch;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFlutterLauncher$1
  implements QuickInstaller.OnQuickInstallResult
{
  QFlutterLauncher$1(QFlutterLauncher paramQFlutterLauncher) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("QFlutter.launcher", 1, "onQuickInstallResult suc=" + paramBoolean);
    if (paramBoolean)
    {
      QFlutterLauncher.a().a(QFlutterLauncher.InstallResult.a(paramBundle));
      return;
    }
    QFlutterLauncher.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QFlutterLauncher.1
 * JD-Core Version:    0.7.0.1
 */