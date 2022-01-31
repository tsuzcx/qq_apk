package com.tencent.mobileqq.shortvideo.gesture;

import aibn;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class GestureMgrAppDownload
{
  aibn jdField_a_of_type_Aibn = null;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  
  GestureMgrAppDownload()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_Aibn = new aibn();
  }
  
  public static void a(int paramInt)
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, BusinessCommonConfig.ConfigInfo paramConfigInfo)
  {
    GestureMgr.a().a.b(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = DownloadInfo.a();
    String str;
    if ((paramInt & 0x1) == 1)
    {
      str = paramDownloadInfo.c;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
      a(paramDownloadInfo.g);
    }
    if ((paramInt & 0x2) == 2)
    {
      str = paramDownloadInfo.e;
      localSharedPreferences.edit().putString("model_zip_md5", str).commit();
    }
    if ((paramInt & 0x3) == 3)
    {
      paramDownloadInfo = paramDownloadInfo.j;
      localSharedPreferences.edit().putString("gamemodel_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      i = Integer.valueOf("349884").intValue();
      BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit().putInt("key_so_version_" + paramString, i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static boolean a()
  {
    return GestureMgr.a().a.b();
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString, BusinessCommonConfig.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = ((DownloadInfo)paramConfigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
    }
    QLog.w("QavGesture", 1, "handle_QAG_Gesture_Config, configInfo[" + paramConfigInfo + "], mDownloadInfo[" + this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo + "]");
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
    boolean bool2;
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(20) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGesture", 4, "innerDownload, getNetEngine 为空");
        }
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo;
    if (localObject == null)
    {
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == GestureUtil.a((DownloadInfo)localObject)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      return this.jdField_a_of_type_Aibn.a((DownloadInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload
 * JD-Core Version:    0.7.0.1
 */