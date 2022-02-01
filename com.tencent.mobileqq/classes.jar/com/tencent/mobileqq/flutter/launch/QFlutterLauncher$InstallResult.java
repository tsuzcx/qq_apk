package com.tencent.mobileqq.flutter.launch;

import android.os.Bundle;

public class QFlutterLauncher$InstallResult
{
  boolean a;
  String b;
  boolean c;
  boolean d;
  String e;
  boolean f;
  
  public static InstallResult a(Bundle paramBundle)
  {
    InstallResult localInstallResult = new InstallResult();
    localInstallResult.a = paramBundle.getBoolean("KEY_INSTALL_RESULT");
    localInstallResult.b = paramBundle.getString("KEY_INSTALL_DIR");
    localInstallResult.c = paramBundle.getBoolean("KEY_IS_ENGINE_EXIST");
    localInstallResult.d = paramBundle.getBoolean("KEY_IS_APP_EXIST");
    localInstallResult.e = paramBundle.getString("KEY_QFLUTTER_VERSION");
    localInstallResult.f = paramBundle.getBoolean("KEY_FROM_QUICK_INSTALL", false);
    return localInstallResult;
  }
  
  public static InstallResult a(String paramString, boolean paramBoolean)
  {
    InstallResult localInstallResult = new InstallResult();
    localInstallResult.a = paramBoolean;
    localInstallResult.b = paramString;
    localInstallResult.c = true;
    localInstallResult.d = true;
    localInstallResult.e = "local-engine;local-app";
    localInstallResult.f = false;
    return localInstallResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QFlutterLauncher.InstallResult
 * JD-Core Version:    0.7.0.1
 */