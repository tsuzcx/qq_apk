package com.tencent.mobileqq.miniapp;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class AKOfflineDownloader$1
  implements AsyncBack
{
  AKOfflineDownloader$1(AKOfflineDownloader paramAKOfflineDownloader, String paramString1, String paramString2, String paramString3, Object paramObject, long paramLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpByBusinessId loaded, code:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", param :");
      localStringBuilder.append(paramString);
      QLog.d("AKOfflineDownloader", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        ThreadManagerV2.excute(new AKOfflineDownloader.1.1(this), 64, null, true);
        return;
      }
      if (paramString.contains("url"))
      {
        AKOfflineDownloader.a(true, this.b, this.c, 2, this.a, this.d);
        QLog.d("AKOfflineDownloader", 2, new Object[] { "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.e) });
        return;
      }
      ThreadManagerV2.excute(new AKOfflineDownloader.1.2(this), 64, null, true);
      return;
    }
    AKOfflineDownloader.a(false, this.b, this.c, -1, this.a, this.d);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.AKOfflineDownloader.1
 * JD-Core Version:    0.7.0.1
 */