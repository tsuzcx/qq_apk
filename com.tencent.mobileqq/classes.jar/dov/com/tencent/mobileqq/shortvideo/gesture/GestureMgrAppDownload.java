package dov.com.tencent.mobileqq.shortvideo.gesture;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

public class GestureMgrAppDownload
{
  DownloadInfo jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = null;
  GestureMgrAppDownload.DownloadContrl jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl = null;
  boolean jdField_a_of_type_Boolean = false;
  
  GestureMgrAppDownload()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl = new GestureMgrAppDownload.DownloadContrl();
  }
  
  static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.gesturemgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = GestureUtil.a();
    String str;
    if ((paramInt & 0x1) == 1)
    {
      str = paramDownloadInfo.b;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
      a(paramDownloadInfo.g);
    }
    if ((paramInt & 0x2) == 2)
    {
      str = paramDownloadInfo.d;
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
    BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit().putString("key_so_version_" + paramString, AppSetting.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload
 * JD-Core Version:    0.7.0.1
 */