package com.tencent.mobileqq.shortvideo;

import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.List;

class ShortVideoResDownload$1
  implements ShortVideoResourceStatus.ISVConfig
{
  ShortVideoResDownload$1(ShortVideoResDownload paramShortVideoResDownload, ShortVideoResourceStatus.ISVConfig_V2 paramISVConfig_V2) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = ShortVideoResDownload.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
      AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
      ShortVideoResDownload.a(this.b);
      localObject = this.a;
      if (localObject != null) {
        ((ShortVideoResourceStatus.ISVConfig_V2)localObject).a(paramInt1, paramInt2);
      }
    }
    else if (paramInt2 != 0)
    {
      AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
      AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
      ShortVideoResDownload.a(this.b);
      localObject = this.a;
      if (localObject != null) {
        ((ShortVideoResourceStatus.ISVConfig_V2)localObject).a(paramInt1, paramInt2);
      }
    }
    else
    {
      localObject = new ArrayList(1);
      if (ShortVideoResourceManager.a(ShortVideoResDownload.b(this.b), (List)localObject) == 0)
      {
        AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        ShortVideoResDownload.c(this.b).a();
        localObject = this.a;
        if (localObject != null) {
          ((ShortVideoResourceStatus.ISVConfig_V2)localObject).a(paramInt1, paramInt2);
        }
      }
      else
      {
        AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        AEQLog.b(ShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        ShortVideoResDownload.a(this.b);
        localObject = this.a;
        if (localObject != null) {
          ((ShortVideoResourceStatus.ISVConfig_V2)localObject).a(paramInt1, paramInt2);
        }
      }
    }
    localObject = ShortVideoResDownload.b();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload.1
 * JD-Core Version:    0.7.0.1
 */