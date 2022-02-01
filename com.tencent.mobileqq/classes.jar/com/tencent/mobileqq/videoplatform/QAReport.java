package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.util.HashMap;

public class QAReport
{
  public static final String LOG_TAG = "[VideoPlatForm]QAReport";
  public static final String REPORT_EVENT_NAME = "actVideoSDKPlay";
  public static final String REPORT_KEY_AUDIO_BITRATE = "param_audioBitRate";
  public static final String REPORT_KEY_AUDIO_CHANNELS = "param_audioChannels";
  public static final String REPORT_KEY_AUDIO_CODEC = "param_audioCodec";
  public static final String REPORT_KEY_AUDIO_PROFILE = "param_audioProfile";
  public static final String REPORT_KEY_AUDIO_SAMPLERATE = "param_audioSampleRate";
  public static final String REPORT_KEY_BUFF_COUNT = "param_buffCount";
  public static final String REPORT_KEY_BUFF_TOTAL_COMSUME = "param_buffTotalConsume";
  public static final String REPORT_KEY_BUSI_TPYE = "param_busiType";
  public static final String REPORT_KEY_CONTAINER_FORMAT = "param_containerFormat";
  public static final String REPORT_KEY_DECODE_FF_COST = "param_decodeFFCost";
  public static final String REPORT_KEY_ERR_CODE = "param_errCode";
  public static final String REPORT_KEY_ERR_INFO = "param_errInfo";
  public static final String REPORT_KEY_ERR_MODULE = "param_errModule";
  public static final String REPORT_KEY_ERR_TYPE = "param_errType";
  public static final String REPORT_KEY_FILE_ID = "param_fileID";
  public static final String REPORT_KEY_FILE_SIZE = "param_fileSize";
  public static final String REPORT_KEY_FIRST_BUFF_COMSUME = "param_firstBuffConsume";
  public static final String REPORT_KEY_FIST_DECODE = "param_firsDecode";
  public static final String REPORT_KEY_HA_ERRO = "param_haErro";
  public static final String REPORT_KEY_HA_STRATEGY = "param_haStrategy";
  public static final String REPORT_KEY_IS_LOOP = "param_isLoop";
  public static final String REPORT_KEY_IS_MEDIACODEC = "param_ismediacodec";
  public static final String REPORT_KEY_IS_MUTE = "param_isMute";
  public static final String REPORT_KEY_LAST_DECODE = "param_lastDecode";
  public static final String REPORT_KEY_PLAYER_TYPE = "param_playerType";
  public static final String REPORT_KEY_PLAY_TYPE = "param_playType";
  public static final String REPORT_KEY_PLAY_URL = "param_playUrl";
  public static final String REPORT_KEY_SKIP_FRAMES_COUNT = "param_skipFramesCount";
  public static final String REPORT_KEY_SKIP_LOT_FRAMES = "param_skipLotFrame";
  public static final String REPORT_KEY_SUCCESSED = "param_isSuccessed";
  public static final String REPORT_KEY_TOTAL_PLAY_TIME = "param_totalPlayTime";
  public static final String REPORT_KEY_VIDEO_BITRATE = "param_videoBitRate";
  public static final String REPORT_KEY_VIDEO_CODEC = "param_videoCodec";
  public static final String REPORT_KEY_VIDEO_DURATION = "param_videoDuration";
  public static final String REPORT_KEY_VIDEO_HEIGHT = "param_videoHeight";
  public static final String REPORT_KEY_VIDEO_PROFILE = "param_videoProfile";
  public static final String REPORT_KEY_VIDEO_WIDTH = "param_videoWidth";
  public static final String REPORT_PLAYER_VER = "param_playerVer";
  public long audioBitRate;
  public int audioChannels;
  public String audioCodec;
  public String audioProfile;
  public long audioSampleRate;
  public long bufferCount;
  public String containerFormat;
  public long decodeFirstFrameCost;
  public int dwErrCode;
  public int errCode;
  public String errDetailInfo;
  public int errModule;
  public int errType;
  public long fileSize;
  public long firstBuffConsume;
  public long firstRenderTime;
  public int firstTryDecoderMode = -1;
  public int haStrategyReturnCode = -1;
  public boolean hasStarted;
  public int isMediaCodec;
  public boolean isSkipLotsOfFrames;
  public boolean isSuccessed;
  public int lastTryDecoderMode = -1;
  public long openPlayerTime;
  public int playerHaErrorCode = -1;
  public int playerType;
  public String playerVersion;
  public int skipFramesTotalCount;
  public long startPlayTime;
  public long stopPlayTime;
  public long totalBufferingDuration;
  public long totalPlayTime;
  public long videoBitRate;
  public String videoCodec;
  public long videoDuration;
  public int videoHeight;
  public VideoPlayParam videoPlayParam;
  public String videoProfile;
  public int videoWidth;
  
  private void addVideoInfo(HashMap<String, String> paramHashMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void doReport(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      boolean bool = this.hasStarted;
      if (!bool) {
        return;
      }
      HashMap localHashMap = new HashMap();
      addVideoInfo(localHashMap);
      this.stopPlayTime = System.currentTimeMillis();
      this.playerVersion = SuperPlayerSDKMgr.getSDKVersion();
      this.isSuccessed = paramBoolean;
      if ((this.startPlayTime > 0L) && (this.stopPlayTime > 0L)) {
        this.totalPlayTime = (this.stopPlayTime - this.startPlayTime);
      }
      if ((this.openPlayerTime > 0L) && (this.firstRenderTime > 0L)) {
        this.firstBuffConsume = (this.firstRenderTime - this.openPlayerTime);
      }
      localHashMap.put("param_playerVer", this.playerVersion);
      localHashMap.put("param_isSuccessed", String.valueOf(this.isSuccessed));
      localHashMap.put("param_errCode", String.valueOf(this.errCode));
      localHashMap.put("param_errModule", String.valueOf(this.errModule));
      localHashMap.put("param_errType", String.valueOf(this.errType));
      localHashMap.put("param_errInfo", this.errDetailInfo);
      localHashMap.put("param_firstBuffConsume", String.valueOf(this.firstBuffConsume));
      localHashMap.put("param_buffCount", String.valueOf(this.bufferCount));
      localHashMap.put("param_buffTotalConsume", String.valueOf(this.totalBufferingDuration));
      localHashMap.put("param_skipLotFrame", String.valueOf(this.isSkipLotsOfFrames));
      localHashMap.put("param_skipFramesCount", String.valueOf(this.skipFramesTotalCount));
      localHashMap.put("param_playerType", String.valueOf(this.playerType));
      localHashMap.put("param_firsDecode", String.valueOf(this.firstTryDecoderMode));
      localHashMap.put("param_lastDecode", String.valueOf(this.lastTryDecoderMode));
      localHashMap.put("param_haStrategy", String.valueOf(this.haStrategyReturnCode));
      localHashMap.put("param_haErro", String.valueOf(this.playerHaErrorCode));
      localHashMap.put("param_videoDuration", String.valueOf(this.videoDuration));
      localHashMap.put("param_videoCodec", this.videoCodec);
      localHashMap.put("param_videoProfile", this.videoProfile);
      localHashMap.put("param_videoBitRate", String.valueOf(this.videoBitRate));
      localHashMap.put("param_audioCodec", this.audioCodec);
      localHashMap.put("param_audioProfile", this.audioProfile);
      localHashMap.put("param_audioSampleRate", String.valueOf(this.audioSampleRate));
      localHashMap.put("param_audioChannels", String.valueOf(this.audioChannels));
      localHashMap.put("param_audioBitRate", String.valueOf(this.audioBitRate));
      localHashMap.put("param_totalPlayTime", String.valueOf(this.totalPlayTime));
      localHashMap.put("param_fileSize", String.valueOf(this.fileSize));
      localHashMap.put("param_decodeFFCost", String.valueOf(this.decodeFirstFrameCost));
      localHashMap.put("param_videoHeight", String.valueOf(this.videoHeight));
      localHashMap.put("param_videoWidth", String.valueOf(this.videoWidth));
      localHashMap.put("param_containerFormat", this.containerFormat);
      localHashMap.put("param_ismediacodec", String.valueOf(this.isMediaCodec));
      ReportUtil.report(null, "actVideoSDKPlay", this.isSuccessed, 0L, 0L, localHashMap, "");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.QAReport
 * JD-Core Version:    0.7.0.1
 */