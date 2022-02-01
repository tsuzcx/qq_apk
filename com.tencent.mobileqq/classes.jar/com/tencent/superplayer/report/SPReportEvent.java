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
  public int appId;
  public boolean audioCodecEnable;
  public String audioCodecJson;
  public boolean audioCodecReused;
  public long audioTotalCodecDuration;
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
  public int height;
  public int netType;
  public int platform = 1;
  public long playDuration;
  public int prePlay = 0;
  public long prepareDuration;
  public long realPrepareDuration;
  public long realRenderDuration;
  public long renderDuration;
  public int sceneId;
  public String sdkVersion;
  public int secondBufferCount;
  public long secondBufferDuration;
  public long startPosition;
  public long stopPosition;
  public boolean success = true;
  public int totalBufferCount;
  public long totalBufferDuration;
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
    if (SuperPlayerSDKMgr.getContext() == null) {}
    for (Object localObject = "";; localObject = SuperPlayerSDKMgr.getContext().getPackageName())
    {
      localLinkedHashMap.put("param_packagename", localObject);
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
      localLinkedHashMap.put("param_sdkVersion", this.sdkVersion);
      localLinkedHashMap.put("param_flowId", this.flowId);
      localLinkedHashMap.put("param_configExt", this.configExt);
      localLinkedHashMap.put("param_netType", String.valueOf(this.netType));
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
      localObject = this.extReportData.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localLinkedHashMap;
  }
  
  public String getEventName()
  {
    return "actSuperPlayer";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.report.SPReportEvent
 * JD-Core Version:    0.7.0.1
 */