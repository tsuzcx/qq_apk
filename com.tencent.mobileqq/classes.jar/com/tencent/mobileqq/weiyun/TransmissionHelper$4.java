package com.tencent.mobileqq.weiyun;

import com.tencent.mobileqq.weiyun.utils.WyReportUtils;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

final class TransmissionHelper$4
  implements UploadManager.IUploadStatusListener
{
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramStatusInfo.state == 6)
      {
        WyReportUtils.a(paramString, "actFileWyUp", paramStatusInfo, false, paramLong);
        return;
      }
      if (paramStatusInfo.state == 5) {
        WyReportUtils.a(paramString, "actFileWyUp", paramStatusInfo, true, paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.4
 * JD-Core Version:    0.7.0.1
 */