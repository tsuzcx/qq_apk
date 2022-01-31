package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadPkgInstallReceiver
  extends BroadcastReceiver
{
  private static IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private static UniformDownloadPkgInstallReceiver jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadPkgInstallReceiver = new UniformDownloadPkgInstallReceiver();
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    jdField_a_of_type_AndroidContentIntentFilter.addDataScheme("package");
    jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    if (paramContext != null) {}
    try
    {
      paramContext.registerReceiver(jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadPkgInstallReceiver, jdField_a_of_type_AndroidContentIntentFilter);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] package operate broadcast. action:" + paramContext + " pkgName:" + paramIntent);
    }
    ThreadManager.executeOnSubThread(new UniformDownloadPkgInstallReceiver.1(this, paramContext, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */