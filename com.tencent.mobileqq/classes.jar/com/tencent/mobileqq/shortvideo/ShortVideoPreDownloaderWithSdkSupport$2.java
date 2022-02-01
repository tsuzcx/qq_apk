package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import java.util.Map;

class ShortVideoPreDownloaderWithSdkSupport$2
  implements ISPlayerDownloader.Listener
{
  ShortVideoPreDownloaderWithSdkSupport$2(ShortVideoPreDownloaderWithSdkSupport paramShortVideoPreDownloaderWithSdkSupport, ShortVideoReq paramShortVideoReq) {}
  
  public void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(int paramInt, String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError, preLoadId = ");
      localStringBuilder.append(this.a.p);
      localStringBuilder.append(" , uniseq = ");
      localStringBuilder.append(this.a.j.uniseq);
      localStringBuilder.append(", moduleID = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", errorCode = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", extInfo = ");
      localStringBuilder.append(paramString);
      QLog.d("ShortVideoPreDownloader", 2, localStringBuilder.toString());
    }
    paramString = this.a;
    if ((paramString != null) && (paramString.o != null)) {
      this.a.o.a(paramInt3);
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFinish, preLoadId = ");
      ((StringBuilder)localObject).append(this.a.p);
      ((StringBuilder)localObject).append(" , uniseq = ");
      ((StringBuilder)localObject).append(this.a.j.uniseq);
      QLog.d("ShortVideoPreDownloader", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if ((localObject != null) && (((ShortVideoReq)localObject).o != null)) {
      this.a.o.a(0);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadProgressUpdate, preLoadId = ");
      paramString.append(this.a.p);
      paramString.append(" , uniseq = ");
      paramString.append(this.a.j.uniseq);
      paramString.append("currentDownloadSizeByte = ");
      paramString.append(paramLong1);
      paramString.append(", totalFileSizeByte = ");
      paramString.append(paramLong2);
      QLog.d("ShortVideoPreDownloader", 2, paramString.toString());
    }
    if ((this.a.o != null) && (this.a.j != null))
    {
      if (paramLong1 > this.a.r) {
        this.a.r = paramLong1;
      } else {
        paramLong1 = this.a.r;
      }
      paramLong2 = this.a.j.videoFileSize;
      if ((paramLong2 > 0L) && (paramLong1 <= paramLong2))
      {
        double d1 = paramLong1;
        Double.isNaN(d1);
        double d2 = paramLong2;
        Double.isNaN(d2);
        paramInt1 = (int)(d1 * 1.0D / d2 * 100.0D);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onDownloadProgressUpdate, preLoadId = ");
          paramString.append(this.a.p);
          paramString.append(", pogress = ");
          paramString.append(paramInt1);
          paramString.append(" , uniseq = ");
          paramString.append(this.a.j.uniseq);
          QLog.d("ShortVideoPreDownloader", 2, paramString.toString());
        }
        this.a.o.b(paramInt1);
      }
    }
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2) {}
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.2
 * JD-Core Version:    0.7.0.1
 */