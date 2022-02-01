package com.tencent.superplayer.report;

import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener;

final class SPBeaconReporter$1
  implements ITPDownloadListener
{
  public void onDownloadInfoReportUpdate(String paramString)
  {
    paramString = SPDownloadEvent.parseEvent(paramString);
    if (paramString.needReport())
    {
      LogUtil.d(".SPBeaconReporter", "spDownloadEvent report, name:" + paramString.getEventName() + " map:" + paramString.getDataMap());
      SPBeaconReporter.report(paramString.getEventName(), paramString.getDataMap());
    }
  }
  
  public void onQuicQualityReportUpdate(String paramString)
  {
    paramString = SPQuicInfoEvent.parseEvent(paramString);
    if (paramString.needReport())
    {
      LogUtil.d(".SPBeaconReporter", "quicQuality report, name:" + paramString.getEventName() + " map:" + paramString.getDataMap());
      SPBeaconReporter.report(paramString.getEventName(), paramString.getDataMap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.report.SPBeaconReporter.1
 * JD-Core Version:    0.7.0.1
 */