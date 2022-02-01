package com.tencent.mobileqq.weiyun;

import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.mobileqq.weiyun.utils.WyReportUtils;

final class TransmissionHelper$3
  implements IDownloadStatusListener
{
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramWeiyunDownloadStatusInfo.a == 5)
      {
        WyReportUtils.a(paramString, "actFileWyDown", paramWeiyunDownloadStatusInfo, false, paramLong);
        return;
      }
      if (paramWeiyunDownloadStatusInfo.a == 4) {
        WyReportUtils.a(paramString, "actFileWyDown", paramWeiyunDownloadStatusInfo, true, paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.3
 * JD-Core Version:    0.7.0.1
 */