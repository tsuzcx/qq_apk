package com.tencent.mobileqq.identification;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class FaceConfigManager$1
  implements FaceConfigDownloader.IConfigObserver
{
  FaceConfigManager$1(AppRuntime paramAppRuntime, FaceConfigDownloader.IDownloadCallback paramIDownloadCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("FaceConfigManager", 1, new Object[] { "requestConfigJson failed, errorMsg : ", paramString, " code : ", Integer.valueOf(paramInt) });
    FaceConfigManager.a(this.b);
  }
  
  public void a(String paramString)
  {
    QLog.d("FaceConfigManager", 1, "requestConfigJson success");
    FaceConfigManager.a(this.a, paramString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConfigManager.1
 * JD-Core Version:    0.7.0.1
 */