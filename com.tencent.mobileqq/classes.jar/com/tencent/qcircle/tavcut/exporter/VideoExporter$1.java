package com.tencent.qcircle.tavcut.exporter;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ErrorInterceptor;
import com.tencent.tav.core.ExportConfig;

class VideoExporter$1
  implements AssetExportSession.ErrorInterceptor
{
  VideoExporter$1(VideoExporter paramVideoExporter) {}
  
  public boolean needRetry(AssetExportSession paramAssetExportSession, int paramInt)
  {
    if (paramInt > 0) {
      return false;
    }
    paramAssetExportSession = paramAssetExportSession.getExportConfig();
    paramAssetExportSession.setAudioChannelCount(1);
    paramAssetExportSession.setHighProfile(false);
    paramAssetExportSession.reset();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.VideoExporter.1
 * JD-Core Version:    0.7.0.1
 */