package com.tencent.mobileqq.extendfriend.utils;

import android.os.RemoteException;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.plugin.QZoneRemotePluginHandler;

public class ECPreInstallLiveVideoApk
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public static volatile ECPreInstallLiveVideoApk a;
  private IQZonePluginManager jdField_a_of_type_CooperationQzonePluginIQZonePluginManager;
  private String jdField_a_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsECPreInstallLiveVideoApk = null;
  }
  
  public void onQzonePluginClientReady(IQZonePluginManager paramIQZonePluginManager)
  {
    QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady start");
    if (paramIQZonePluginManager == null) {
      QZonePluginMangerHelper.getQzonePluginClient(BaseApplicationImpl.getContext(), this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQStoryContext.a();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null)
      {
        QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady: getAppRuntime return null.");
        localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (localQQAppInterface1 != null) {
        QZoneRemotePluginHandler.getInstance().setAppInterface(localQQAppInterface1);
      }
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = paramIQZonePluginManager;
      paramIQZonePluginManager = this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.queryPlugin(this.jdField_a_of_type_JavaLangString);
      if (paramIQZonePluginManager != null)
      {
        if (paramIQZonePluginManager.state == 4)
        {
          this.jdField_a_of_type_Boolean = false;
          QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady installed");
          return;
        }
        if (paramIQZonePluginManager.state == 2)
        {
          try
          {
            this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.installPlugin(this.jdField_a_of_type_JavaLangString, null, 0);
          }
          catch (RemoteException paramIQZonePluginManager)
          {
            QLog.e("ECPreInstallLiveVideoApk", 1, paramIQZonePluginManager, new Object[0]);
          }
        }
        else
        {
          QLog.d("ECPreInstallLiveVideoApk", 1, " has not installed");
          if (QZonePluginManager.canDownloadPlugin()) {
            try
            {
              this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.installPlugin(this.jdField_a_of_type_JavaLangString, null, 0);
            }
            catch (RemoteException paramIQZonePluginManager)
            {
              QLog.e("ECPreInstallLiveVideoApk", 1, "installPluginSilence", paramIQZonePluginManager);
            }
          }
        }
      }
      else
      {
        QLog.d("ECPreInstallLiveVideoApk", 1, "record is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ECPreInstallLiveVideoApk
 * JD-Core Version:    0.7.0.1
 */