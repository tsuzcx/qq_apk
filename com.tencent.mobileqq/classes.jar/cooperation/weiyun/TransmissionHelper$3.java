package cooperation.weiyun;

import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadStatusListener;
import cooperation.weiyun.utils.WyReportUtils;

final class TransmissionHelper$3
  implements WyDownloader.IDownloadStatusListener
{
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong, DownloadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramStatusInfo.a != 5) {
        break label25;
      }
      WyReportUtils.a(paramString, "actFileWyDown", paramStatusInfo, false, paramLong);
    }
    label25:
    while (paramStatusInfo.a != 4) {
      return;
    }
    WyReportUtils.a(paramString, "actFileWyDown", paramStatusInfo, true, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.TransmissionHelper.3
 * JD-Core Version:    0.7.0.1
 */