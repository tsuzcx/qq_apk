package dov.com.qq.im.ae.download.old;

import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.List;

class AEOldShortVideoResDownload$2
  implements AEOldShortVideoResStatus.ISVConfig
{
  AEOldShortVideoResDownload$2(AEOldShortVideoResDownload paramAEOldShortVideoResDownload, AEOldShortVideoResStatus.ISVConfig_V2 paramISVConfig_V2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = AEOldShortVideoResDownload.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
      AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
      AEOldShortVideoResDownload.a(this.b);
      localObject = this.a;
      if (localObject != null) {
        ((AEOldShortVideoResStatus.ISVConfig_V2)localObject).b(paramInt1, paramInt2);
      }
    }
    else if (paramInt2 != 0)
    {
      AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
      AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
      AEOldShortVideoResDownload.a(this.b);
      localObject = this.a;
      if (localObject != null) {
        ((AEOldShortVideoResStatus.ISVConfig_V2)localObject).b(paramInt1, paramInt2);
      }
    }
    else
    {
      localObject = new ArrayList(1);
      if (AEOldShortVideoResManager.a(AEOldShortVideoResDownload.b(this.b), (List)localObject) == 0)
      {
        AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        AEOldShortVideoResDownload.c(this.b).a();
        localObject = this.a;
        if (localObject != null) {
          ((AEOldShortVideoResStatus.ISVConfig_V2)localObject).b(paramInt1, paramInt2);
        }
      }
      else
      {
        AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        AEQLog.b(AEOldShortVideoResDownload.b(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        AEOldShortVideoResDownload.a(this.b);
        localObject = this.a;
        if (localObject != null) {
          ((AEOldShortVideoResStatus.ISVConfig_V2)localObject).b(paramInt1, paramInt2);
        }
      }
    }
    localObject = AEOldShortVideoResDownload.b();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", serverError=");
    localStringBuilder.append(paramInt2);
    AEQLog.b((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload.2
 * JD-Core Version:    0.7.0.1
 */