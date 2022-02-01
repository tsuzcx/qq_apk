package dov.com.qq.im.ae.config;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.AEPath.GIF.FILES;
import dov.com.qq.im.ae.AEPath.Watermark.FILES;

class CameraDataServiceHandler$2
  implements Runnable
{
  CameraDataServiceHandler$2(CameraDataServiceHandler paramCameraDataServiceHandler) {}
  
  public void run()
  {
    QLog.d(CameraDataServiceHandler.a(), 4, "[deleteOldMaterialFile]");
    if (FileUtils.a(AEPath.CAMERA.FILES.d))
    {
      QLog.d(CameraDataServiceHandler.a(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_ZIP_DOWNLOAD_OLD");
      FileUtils.a(AEPath.CAMERA.FILES.d);
    }
    if (FileUtils.a(AEPath.CAMERA.FILES.e))
    {
      QLog.d(CameraDataServiceHandler.a(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_FINAL_USABLE_OLD");
      FileUtils.a(AEPath.CAMERA.FILES.e);
    }
    if (FileUtils.a(AEPath.CAMERA.FILES.f))
    {
      QLog.d(CameraDataServiceHandler.a(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_OLD");
      FileUtils.a(AEPath.CAMERA.FILES.f);
    }
    if (FileUtils.a(AEPath.Watermark.FILES.b))
    {
      QLog.d(CameraDataServiceHandler.a(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_JSON_OLD");
      FileUtils.a(AEPath.CAMERA.FILES.f);
    }
    if (FileUtils.a(AEPath.GIF.FILES.f))
    {
      QLog.d(CameraDataServiceHandler.a(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_JSON_OLD");
      FileUtils.a(AEPath.CAMERA.FILES.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CameraDataServiceHandler.2
 * JD-Core Version:    0.7.0.1
 */