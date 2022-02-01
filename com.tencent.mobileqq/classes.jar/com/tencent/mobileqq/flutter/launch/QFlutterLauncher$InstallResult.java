package com.tencent.mobileqq.flutter.launch;

import android.os.Bundle;

public class QFlutterLauncher$InstallResult
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  boolean d;
  
  public static InstallResult a(Bundle paramBundle)
  {
    InstallResult localInstallResult = new InstallResult();
    localInstallResult.jdField_a_of_type_Boolean = paramBundle.getBoolean("KEY_INSTALL_RESULT");
    localInstallResult.jdField_a_of_type_JavaLangString = paramBundle.getString("KEY_INSTALL_DIR");
    localInstallResult.jdField_b_of_type_Boolean = paramBundle.getBoolean("KEY_IS_ENGINE_EXIST");
    localInstallResult.c = paramBundle.getBoolean("KEY_IS_APP_EXIST");
    localInstallResult.jdField_b_of_type_JavaLangString = paramBundle.getString("KEY_QFLUTTER_VERSION");
    localInstallResult.d = paramBundle.getBoolean("KEY_FROM_QUICK_INSTALL", false);
    return localInstallResult;
  }
  
  public static InstallResult a(String paramString, boolean paramBoolean)
  {
    InstallResult localInstallResult = new InstallResult();
    localInstallResult.jdField_a_of_type_Boolean = paramBoolean;
    localInstallResult.jdField_a_of_type_JavaLangString = paramString;
    localInstallResult.jdField_b_of_type_Boolean = true;
    localInstallResult.c = true;
    localInstallResult.jdField_b_of_type_JavaLangString = "local-engine;local-app";
    localInstallResult.d = false;
    return localInstallResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QFlutterLauncher.InstallResult
 * JD-Core Version:    0.7.0.1
 */