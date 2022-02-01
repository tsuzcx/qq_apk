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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.f);
      localStringBuilder.append(" , uniseq = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      localStringBuilder.append(", moduleID = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", errorCode = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", extInfo = ");
      localStringBuilder.append(paramString);
      QLog.d("ShortVideoPreDownloader", 2, localStringBuilder.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback.a(paramInt3);
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFinish, preLoadId = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.f);
      ((StringBuilder)localObject).append(" , uniseq = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      QLog.d("ShortVideoPreDownloader", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    if ((localObject != null) && (((ShortVideoReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback.a(0);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadProgressUpdate, preLoadId = ");
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.f);
      paramString.append(" , uniseq = ");
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      paramString.append("currentDownloadSizeByte = ");
      paramString.append(paramLong1);
      paramString.append(", totalFileSizeByte = ");
      paramString.append(paramLong2);
      QLog.d("ShortVideoPreDownloader", 2, paramString.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      if (paramLong1 > this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Long) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Long = paramLong1;
      } else {
        paramLong1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Long;
      }
      paramLong2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
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
          paramString.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.f);
          paramString.append(", pogress = ");
          paramString.append(paramInt1);
          paramString.append(" , uniseq = ");
          paramString.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          QLog.d("ShortVideoPreDownloader", 2, paramString.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback.b(paramInt1);
      }
    }
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2) {}
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.2
 * JD-Core Version:    0.7.0.1
 */