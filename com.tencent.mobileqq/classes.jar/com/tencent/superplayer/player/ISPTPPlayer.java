package com.tencent.superplayer.player;

import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import java.util.Map;

abstract interface ISPTPPlayer
{
  public static final int PLAYER_BASE_COMPLETE = 0;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_AVSRC_ERROR = 112101;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_BUFFERING_TIMEOUT = 112160;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_DECODER_FAILED = 112106;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_DOLBY_FAILED = 112107;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_DRM_CREATE_CRYPTO_ERROR = 112203;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_DRM_ERROR = 112201;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_DRM_LICENSE_LOAD_ERR = 112204;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_DRM_UNSUPPORT = 112202;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_HEVC_FAILED = 112108;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_NETWORK_ERR = 112141;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_OPEN_FAILED = 112112;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_PREPARED_TIMEOUT = 112162;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_RENDER_INITFAILED = 112163;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_SET_DEC_FAILED = 112105;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_START_EXCE = 112113;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_SYS_CLOCK_BIG_JUMP = 112161;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_TIMEOUT = 112142;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_UNKNOW = 112100;
  public static final int PLAYER_BASE_ERR_SELFPLAYER_URL_ERROR = 112111;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_BUFFER_LAST_TOO_LONG = 113014;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_EARLY_ONCOMPLETE = 113015;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_MALFORMED = 113006;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 113008;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_ON_ERROR_NET_ERR = 113016;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_OPEN_GENERAL_EXCEPTION = 113013;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_OPEN_ILLEGALARGUMENT_EXCEPTION = 113004;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_OPEN_ILLEGALSTATE_EXCEPTION = 113003;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_OPEN_IO_EXCEPTION = 113012;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_OPEN_SECURITY_EXCEPTION = 113005;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_POSITION_NO_CHANGE_LAST_TOO_LONG = 113009;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_PREPARED_BUT_NODATA = 113002;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_PREPARE_TIMEOUT = 113001;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_PROXY_ERR = 113017;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_SVR_DIED = 113011;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_TIMEOUT = 113010;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_UNKNOW = 113000;
  public static final int PLAYER_BASE_ERR_SYSPLAYER_UNSUPPORTED = 113007;
  public static final int PLAYER_BASE_INFO_ENDOF_BUFFERING = 22;
  public static final int PLAYER_BASE_INFO_FIRST_AUDIO_FRAME_RENDERED = 40;
  public static final int PLAYER_BASE_INFO_FIRST_VIDEO_FRAME_RENDERED = 39;
  public static final int PLAYER_BASE_INFO_GET_STREAM_DATA_TIME = 30;
  public static final int PLAYER_BASE_INFO_GET_SYNC_FRAME_TIME = 31;
  public static final int PLAYER_BASE_INFO_HW_DECODE_SLOW_FPS = 35;
  public static final int PLAYER_BASE_INFO_NATIVE_SET_DECODER_MODE = 36;
  public static final int PLAYER_BASE_INFO_NOMORE_DATA = 26;
  public static final int PLAYER_BASE_INFO_PLAYER_APPEND_VID_START = 43;
  public static final int PLAYER_BASE_INFO_PLAYER_NEED_ROTATE_SURFACE = 41;
  public static final int PLAYER_BASE_INFO_PRIVATE_HLS_M3U8_TAG = 38;
  public static final int PLAYER_BASE_INFO_REDIRECT_IPADDR = 27;
  public static final int PLAYER_BASE_INFO_RETRY_CONNECT = 28;
  public static final int PLAYER_BASE_INFO_SKIP_CURRENT_TS = 33;
  public static final int PLAYER_BASE_INFO_SKIP_MANY_FRAMES = 37;
  public static final int PLAYER_BASE_INFO_START_BUFFERING = 21;
  public static final int PLAYER_BASE_INFO_START_RENDERING = 23;
  public static final int PLAYER_BASE_INFO_SUCC_SET_DECODER_MODE = 24;
  public static final int PLAYER_BASE_INFO_SW_DECODE_SLOW_FPS = 34;
  public static final int PLAYER_BASE_INFO_TCP_CONNECT_TIME = 29;
  public static final int PLAYER_BASE_INFO_UNKNOW = 20;
  public static final int PLAYER_BASE_INFO_USE_DOLBY_DECODE = 32;
  public static final int PLAYER_BASE_LOOPBACK_CHANGED = 10;
  public static final int PLAYER_BASE_LOOPBACK_START_ONE_LOOP = 12;
  public static final int PLAYER_BASE_MEDIACODEC_FORMAT_CHANGE = 16;
  public static final int PLAYER_BASE_ONE_LOOP_COMPLETE = 11;
  public static final int PLAYER_BASE_PERMISSION_TIMEOUT = 4;
  public static final int PLAYER_BASE_PREPARED = 2;
  public static final int PLAYER_BASE_READY_TO_SWITCH_AUDIO = 13;
  public static final int PLAYER_BASE_READY_TO_SWITCH_DEF = 8;
  public static final int PLAYER_BASE_SEEK_COMPLETED = 1;
  public static final int PLAYER_BASE_SIZE_CHANGE = 3;
  public static final int PLAYER_BASE_SKIP_LOTS_OF_FRAMES = 7;
  public static final int PLAYER_BASE_SUB_ERROR = 6;
  public static final int PLAYER_BASE_SUB_FINISH = 5;
  public static final int PLAYER_BASE_SWITCH_AUDIOTRACK_DONE = 14;
  public static final int PLAYER_BASE_SWITCH_AUDIOTRACK_FAIL = 15;
  public static final int PLAYER_BASE_SWITCH_DEF_DONE = 9;
  public static final int PLAYER_BASS_INFO_PLAYER_APPEND_VID_EOF = 42;
  public static final int PLAYER_DESC_ID_ANDROIDPLAYER = 1;
  public static final int PLAYER_DESC_ID_FFMPEGPLAYER = 2;
  public static final int PLAYER_DESC_ID_FFMPEGPLAYER_SOFT_DEC = 3;
  public static final int PLAYER_DESC_ID_UNKNOWN = 0;
  public static final int PLAYER_SEEK_MODE_AccuratePos = 16;
  public static final int PLAYER_SEEK_MODE_FILEPOSITION = 1;
  public static final int PLAYER_SEEK_MODE_FrameFastDecode = 32;
  public static final int PLAYER_SEEK_MODE_PERCENT = 4;
  public static final int PLAYER_SEEK_MODE_SEQNUMNBER = 8;
  public static final int PLAYER_SEEK_MODE_TIMESTAMP = 2;
  
  public abstract void captureVideo(TPCaptureParams paramTPCaptureParams, ISPTPPlayer.IOnCaptureCallback paramIOnCaptureCallback);
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract ITPPlayerProxy getPlayerProxy();
  
  public abstract long getPropertyLong(int paramInt);
  
  public abstract String getPropertyString(int paramInt);
  
  public abstract ITPBusinessReportManager getReportManager();
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void setDataSource(ITPMediaAsset paramITPMediaAsset);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDataSource(String paramString, Map<String, String> paramMap);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnCompletionListener(ISPTPPlayer.IOnCompletionListener paramIOnCompletionListener);
  
  public abstract void setOnErrorListener(ISPTPPlayer.IOnErrorListener paramIOnErrorListener);
  
  public abstract void setOnInfoListener(ISPTPPlayer.IOnInfoListener paramIOnInfoListener);
  
  public abstract void setOnPreparedListener(ISPTPPlayer.IOnPreparedListener paramIOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(ISPTPPlayer.IOnSeekCompleteListener paramIOnSeekCompleteListener);
  
  public abstract void setOnVideoFrameOutListener(ISPTPPlayer.IOnVideoFrameOutListener paramIOnVideoFrameOutListener);
  
  public abstract void setOnVideoSizeChangedListener(ISPTPPlayer.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setTPVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.ISPTPPlayer
 * JD-Core Version:    0.7.0.1
 */