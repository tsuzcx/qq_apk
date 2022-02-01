package com.tencent.superplayer.report;

import android.content.Context;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.reuse.ReusePolicy.EraseType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SPReportEvent
{
  public static final int PLATFORM_ANDROID = 1;
  public static final int PREPLAY_FULL = 1;
  public static final int PREPLAY_NO = 0;
  public static final int PREPLAY_NOT_FULL = 2;
  public String CDNIP;
  public int appId;
  public boolean audioCodecEnable;
  public String audioCodecJson;
  public boolean audioCodecReused;
  public long audioTotalCodecDuration;
  public int avgHttpSpeed;
  public int avgP2PSpeed;
  public int avgPcdnSpeed;
  public float bitrate;
  public String codecErrorCodeList;
  public String codecErrorMsgList;
  public String codecMimeType;
  public String configExt;
  public String deviceInfoJson;
  public long duration;
  public String errCode;
  public String errDetailInfo;
  public Map<String, String> extReportData = new HashMap();
  public long fileSize;
  public String flowId;
  public boolean hadSeek;
  public boolean hadStart;
  public int hardwareLevel;
  public String hdrSupport = "notSupport";
  public String headerClientIP;
  public String headerServerIP;
  public int height;
  public int httpDownloadCompleteCnt;
  public int httpDownloadFailCnt;
  public long httpDownloadSize;
  public long httpRepeatedSize;
  public boolean isDownloadByQuic;
  public boolean isDownloadByQuicPlaintext;
  public boolean isEnableQuicConnectionMigration;
  public boolean isEnableQuicPlaintext;
  public long p2pDownloadSize;
  public long p2pRepeatedSize;
  public int pcdnDownloadFailCount;
  public long pcdnDownloadSize;
  public int pcdnDownloadSuccessCount;
  public int pcdnErrorCount;
  public int pcdnErrorSize;
  public long pcdnRepeatedSize;
  public int pcdnRequestCount;
  public long pcdnRequestSize;
  public String pcdnStopReason;
  public int platform = 1;
  public long playDuration;
  public int prePlay = 0;
  public long prepareDuration;
  public int quicCongestionType;
  public int quicDownloadCompleteCnt;
  public int quicDownloadFailCnt;
  public int quicEnableMode;
  public long realPrepareDuration;
  public long realRenderDuration;
  public long renderDuration;
  public int sceneId;
  public int screenHeight;
  public int screenWidth;
  public String sdkVersion;
  public int secondBufferCount;
  public long secondBufferDuration;
  public int seekBufferCount;
  public int seekBufferDuration;
  public int seekCount;
  public int seekDuration;
  public float seekPercent;
  public float seekStartPercent;
  public long seekStartTime;
  public long startPosition;
  public long stopPosition;
  public boolean success = true;
  public int totalBufferCount;
  public long totalBufferDuration;
  public long totalDownloadedSize;
  public String url;
  public String vid;
  public String videoCodec;
  public boolean videoCodecEnable;
  public String videoCodecJson;
  public boolean videoCodecReused;
  public String videoFormat;
  public int videoFrameCheckCode = -1;
  public String videoProfile;
  public int videoSource;
  public long videoTotalCodecDuration;
  public int width;
  
  public Map<String, String> getDataMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("param_appId", String.valueOf(this.appId));
    localLinkedHashMap.put("param_sceneId", String.valueOf(this.sceneId));
    if (SuperPlayerSDKMgr.getContext() == null) {
      localObject = "";
    } else {
      localObject = SuperPlayerSDKMgr.getContext().getPackageName();
    }
    localLinkedHashMap.put("param_packagename", localObject);
    localLinkedHashMap.put("param_uin", SuperPlayerSDKMgr.getUid());
    localLinkedHashMap.put("param_videoSource", String.valueOf(this.videoSource));
    localLinkedHashMap.put("param_vid", this.vid);
    localLinkedHashMap.put("param_url", this.url);
    localLinkedHashMap.put("param_width", String.valueOf(this.width));
    localLinkedHashMap.put("param_height", String.valueOf(this.height));
    localLinkedHashMap.put("param_fileSize", String.valueOf(this.fileSize));
    localLinkedHashMap.put("param_duration", String.valueOf(this.duration));
    localLinkedHashMap.put("param_bitrate", String.valueOf(this.bitrate));
    localLinkedHashMap.put("param_videoFormat", String.valueOf(this.videoFormat));
    localLinkedHashMap.put("param_videoCodec", this.videoCodec);
    localLinkedHashMap.put("param_videoProfile", this.videoProfile);
    localLinkedHashMap.put("param_codecMimeType", this.codecMimeType);
    localLinkedHashMap.put("param_platform", String.valueOf(this.platform));
    localLinkedHashMap.put("param_hardwareLevel", String.valueOf(this.hardwareLevel));
    localLinkedHashMap.put("param_deviceInfoJson", this.deviceInfoJson);
    localLinkedHashMap.put("param_screenWidth", String.valueOf(this.screenWidth));
    localLinkedHashMap.put("param_screenHeight", String.valueOf(this.screenHeight));
    localLinkedHashMap.put("param_sdkVersion", this.sdkVersion);
    localLinkedHashMap.put("param_flowId", this.flowId);
    localLinkedHashMap.put("param_configExt", this.configExt);
    localLinkedHashMap.put("param_success", String.valueOf(this.success));
    localLinkedHashMap.put("param_errCode", this.errCode);
    localLinkedHashMap.put("param_errDetailInfo", this.errDetailInfo);
    localLinkedHashMap.put("param_prePlay", String.valueOf(this.prePlay));
    localLinkedHashMap.put("param_totalBufferDuration", String.valueOf(this.totalBufferDuration));
    localLinkedHashMap.put("param_totalBufferCount", String.valueOf(this.totalBufferCount));
    localLinkedHashMap.put("param_startPosition", String.valueOf(this.startPosition));
    localLinkedHashMap.put("param_stopPosition", String.valueOf(this.stopPosition));
    localLinkedHashMap.put("param_prepareDuration", String.valueOf(this.prepareDuration));
    localLinkedHashMap.put("param_renderDuration", String.valueOf(this.renderDuration));
    localLinkedHashMap.put("param_realPrepareDuration", String.valueOf(this.realPrepareDuration));
    localLinkedHashMap.put("param_realRenderDuration", String.valueOf(this.realRenderDuration));
    localLinkedHashMap.put("param_videoCodecEnable", String.valueOf(this.videoCodecEnable));
    localLinkedHashMap.put("param_videoCodecReused", String.valueOf(this.videoCodecReused));
    localLinkedHashMap.put("param_videoTotalCodecDuration", String.valueOf(this.videoTotalCodecDuration));
    localLinkedHashMap.put("param_videoCodecJson", String.valueOf(this.videoCodecJson));
    localLinkedHashMap.put("param_audioCodecEnable", String.valueOf(this.audioCodecEnable));
    localLinkedHashMap.put("param_audioCodecReused", String.valueOf(this.audioCodecReused));
    localLinkedHashMap.put("param_audioTotalCodecDuration", String.valueOf(this.audioTotalCodecDuration));
    localLinkedHashMap.put("param_audioCodecJson", String.valueOf(this.audioCodecJson));
    localLinkedHashMap.put("param_codecErrorCodeList", String.valueOf(this.codecErrorCodeList));
    localLinkedHashMap.put("param_codecErrorMsgList", String.valueOf(this.codecErrorMsgList));
    localLinkedHashMap.put("param_secondBufferDuration", String.valueOf(this.secondBufferDuration));
    localLinkedHashMap.put("param_secondBufferCount", String.valueOf(this.secondBufferCount));
    localLinkedHashMap.put("param_videoFrameCheckCode", String.valueOf(this.videoFrameCheckCode));
    localLinkedHashMap.put("param_codecErasePolicy", String.valueOf(TCodecManager.getInstance().getReusePolicy().eraseType.ordinal()));
    localLinkedHashMap.put("param_playDuration", String.valueOf(this.playDuration));
    localLinkedHashMap.put("param_hadStart", String.valueOf(this.hadStart));
    localLinkedHashMap.put("param_hadSeek", String.valueOf(this.hadSeek));
    localLinkedHashMap.put("param_quicEnableMode", String.valueOf(this.quicEnableMode));
    localLinkedHashMap.put("param_isEnableQuicPlaintext", String.valueOf(this.isEnableQuicPlaintext));
    localLinkedHashMap.put("param_isEnableQuicConnectionMigration", String.valueOf(this.isEnableQuicConnectionMigration));
    localLinkedHashMap.put("param_quicCongestionType", String.valueOf(this.quicCongestionType));
    localLinkedHashMap.put("param_isDownloadByQuic", String.valueOf(this.isDownloadByQuic));
    localLinkedHashMap.put("param_quicDownloadCompleteCnt", String.valueOf(this.quicDownloadCompleteCnt));
    localLinkedHashMap.put("param_quicDownloadFailCnt", String.valueOf(this.quicDownloadFailCnt));
    localLinkedHashMap.put("param_httpDownloadCompleteCnt", String.valueOf(this.httpDownloadCompleteCnt));
    localLinkedHashMap.put("param_httpDownloadFailCnt", String.valueOf(this.httpDownloadFailCnt));
    localLinkedHashMap.put("param_isDownloadByQuicPlaintext", String.valueOf(this.isDownloadByQuicPlaintext));
    localLinkedHashMap.put("param_headerServerIP", String.valueOf(this.headerServerIP));
    localLinkedHashMap.put("param_headerClientIP", String.valueOf(this.headerClientIP));
    localLinkedHashMap.put("param_CDNIP", String.valueOf(this.CDNIP));
    localLinkedHashMap.put("param_seekCount", String.valueOf(this.seekCount));
    localLinkedHashMap.put("param_seekBufferCount", String.valueOf(this.seekBufferCount));
    localLinkedHashMap.put("param_seekBufferDuration", String.valueOf(this.seekBufferDuration));
    localLinkedHashMap.put("param_seekDuration", String.valueOf(this.seekDuration));
    localLinkedHashMap.put("param_seekPercent", String.valueOf(this.seekPercent));
    localLinkedHashMap.put("param_seekStartPercent", String.valueOf(this.seekStartPercent));
    localLinkedHashMap.put("param_hdrSupport", String.valueOf(this.hdrSupport));
    localLinkedHashMap.put("param_totalDownloadedSize", String.valueOf(this.totalDownloadedSize));
    localLinkedHashMap.put("param_httpDownloadSize", String.valueOf(this.httpDownloadSize));
    localLinkedHashMap.put("param_httpRepeatedSize", String.valueOf(this.httpRepeatedSize));
    localLinkedHashMap.put("param_pcdnDownloadSize", String.valueOf(this.pcdnDownloadSize));
    localLinkedHashMap.put("param_pcdnRepeatedSize", String.valueOf(this.pcdnRepeatedSize));
    localLinkedHashMap.put("param_p2pDownloadSize", String.valueOf(this.p2pDownloadSize));
    localLinkedHashMap.put("param_p2pRepeatedSize", String.valueOf(this.p2pRepeatedSize));
    localLinkedHashMap.put("param_pcdnRequestSize", String.valueOf(this.pcdnRequestSize));
    localLinkedHashMap.put("param_pcdnRequestCount", String.valueOf(this.pcdnRequestCount));
    localLinkedHashMap.put("param_pcdnDownloadFailCount", String.valueOf(this.pcdnDownloadFailCount));
    localLinkedHashMap.put("param_pcdnDownloadSuccessCount", String.valueOf(this.pcdnDownloadSuccessCount));
    localLinkedHashMap.put("param_avgHttpSpeed", String.valueOf(this.avgHttpSpeed));
    localLinkedHashMap.put("param_avgPcdnSpeed", String.valueOf(this.avgPcdnSpeed));
    localLinkedHashMap.put("param_avgP2PSpeed", String.valueOf(this.avgP2PSpeed));
    localLinkedHashMap.put("param_pcdnErrorCount", String.valueOf(this.pcdnErrorCount));
    localLinkedHashMap.put("param_pcdnErrorSize", String.valueOf(this.pcdnErrorSize));
    localLinkedHashMap.put("param_pcdnStopReason", this.pcdnStopReason);
    Object localObject = this.extReportData.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return localLinkedHashMap;
  }
  
  public String getEventName()
  {
    return "actSuperPlayer";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.report.SPReportEvent
 * JD-Core Version:    0.7.0.1
 */