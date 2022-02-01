package com.tencent.mobileqq.shortvideo.gesture;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class GestureMgrAppDownload
{
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  GestureMgrAppDownload.DownloadContrl jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl = null;
  boolean jdField_a_of_type_Boolean = false;
  
  GestureMgrAppDownload()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl = new GestureMgrAppDownload.DownloadContrl();
  }
  
  static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.gesturemgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "onEnterBackground");
    }
    a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    GestureMgr.a().a.b(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = DownloadInfo.getSP();
    String str;
    if ((paramInt & 0x1) == 1)
    {
      str = paramDownloadInfo.MD5_zip_so;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
      a(paramDownloadInfo.so_name);
    }
    if ((paramInt & 0x2) == 2)
    {
      str = paramDownloadInfo.MD5_zip_model;
      localSharedPreferences.edit().putString("model_zip_md5", str).commit();
    }
    if ((paramInt & 0x3) == 3)
    {
      paramDownloadInfo = paramDownloadInfo.MD5_zip_gamemodel;
      localSharedPreferences.edit().putString("gamemodel_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_so_version_");
    localStringBuilder.append(paramString);
    localEditor.putString(localStringBuilder.toString(), AppSetting.g()).commit();
  }
  
  public static boolean a()
  {
    return GestureMgr.a().a.b();
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = ((DownloadInfo)paramConfigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handle_QAG_Gesture_Config, configInfo[");
    paramQQAppInterface.append(paramConfigInfo);
    paramQQAppInterface.append("], mDownloadInfo[");
    paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    paramQQAppInterface.append("]");
    QLog.w("QavGesture", 1, paramQQAppInterface.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo != null) {
        a();
      }
    }
  }
  
  boolean b()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool2 = localObject instanceof QQAppInterface;
    boolean bool1 = true;
    if (bool2)
    {
      if (((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
      {
        QLog.d("QavGesture", 1, "innerDownload, getNetEngine 为空");
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo;
      if (localObject == null)
      {
        this.jdField_a_of_type_Boolean = true;
        return false;
      }
      if (11 != GestureUtil.a((DownloadInfo)localObject)) {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.a((DownloadInfo)localObject);
      }
      return bool2;
    }
    QLog.d("QavGesture", 1, "appRuntime 不是 QQAppInterface");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload
 * JD-Core Version:    0.7.0.1
 */