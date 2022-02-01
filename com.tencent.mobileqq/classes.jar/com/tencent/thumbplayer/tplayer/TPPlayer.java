package com.tencent.thumbplayer.tplayer;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.adapter.ITPPlayerAdapter;
import com.tencent.thumbplayer.adapter.TPPlayerAdapter;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.datatransport.TPPlayManagerImpl;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager;
import com.tencent.thumbplayer.tplayer.plugins.TPPluginManager;
import com.tencent.thumbplayer.tplayer.plugins.report.TPLogPlugin;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportPlugin;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TPPlayer
  implements ITPPlayer, TPPlayerInternal.ITPPlayerSwitchThreadListener
{
  private static String LOG_API_CALL_PREFIX = "api call:";
  private static final int MSG_INDEX = 256;
  private static final int MSG_ON_AUDIOPCMOUT = 267;
  private static final int MSG_ON_COMPLETION = 260;
  private static final int MSG_ON_ERROR = 262;
  private static final int MSG_ON_INFO = 261;
  private static final int MSG_ON_PLAYER_STATE_CHANGE = 277;
  private static final int MSG_ON_PREPARED = 257;
  private static final int MSG_ON_PROXY_ALL_DOWNLOAD_FINISH = 271;
  private static final int MSG_ON_PROXY_CDN_URL_EXPIRED = 275;
  private static final int MSG_ON_PROXY_DOWN_LOAD_STATUS_UPDATE = 272;
  private static final int MSG_ON_PROXY_NO_MORE_DATA = 276;
  private static final int MSG_ON_PROXY_PLAYERROR = 268;
  private static final int MSG_ON_PROXY_PLAY_CDN_INFO_UPDATE = 270;
  private static final int MSG_ON_PROXY_PLAY_CDN_URL_UPDATE = 269;
  private static final int MSG_ON_PROXY_PROGRESS_UPDATE = 274;
  private static final int MSG_ON_PROXY_PROTOCOL_UPDATE = 273;
  private static final int MSG_ON_PROXY_SWITCH_DEFINITION = 278;
  private static final int MSG_ON_SEEK_COMPLETE = 263;
  private static final int MSG_ON_SUBTITLE_DATA = 265;
  private static final int MSG_ON_SUBTITLE_FRAME_BUFFER = 279;
  private static final int MSG_ON_VIDEOFRAMEOUT = 266;
  private static final int MSG_ON_VIDEO_SIZE_CHANGE = 264;
  private static int sPlayId = 0;
  private String TAG = "TPThumbPlayer[TPPlayer.java]";
  private Context mContext;
  private long mCurrentDownloadSizeByte;
  private long mDownloadPlayableDurationMs;
  private HandlerThread mHandlerThread;
  private ITPPlayManager mPlayProxyManager;
  private ITPPlayerAdapter mPlayerAdapter;
  private TPPlayerInternal mPlayerInternal;
  private TPPlayerListeners mPlayerListeners;
  private int mProxyStatus = -1;
  private TPReportManager mReportManager;
  private ITPPluginManager mTPPluginManager;
  private long mTotalFileSizeByte;
  private TPPlayer.EventHandler mTransformCallbackHandler;
  private String mUrl = null;
  private boolean mUseProxy = true;
  private ArrayList<String> proxyTrackUrls;
  
  public TPPlayer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPPlayer(Context paramContext, Looper paramLooper)
  {
    this(paramContext, paramLooper, null);
  }
  
  public TPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    sPlayId += 1;
    TPLogUtil.i(this.TAG, "create TPPlayer");
    this.mContext = paramContext.getApplicationContext();
    this.mTPPluginManager = new TPPluginManager();
    this.mReportManager = new TPReportManager(this.mContext);
    this.mTPPluginManager.addPlugin(this.mReportManager);
    pushEvent(100, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
    if (paramLooper2 == null) {}
    for (this.mTransformCallbackHandler = new TPPlayer.EventHandler(this, this);; this.mTransformCallbackHandler = new TPPlayer.EventHandler(this, this, paramLooper2))
    {
      TPPlayer.InnerPlayerListener localInnerPlayerListener = new TPPlayer.InnerPlayerListener(this);
      this.mPlayerListeners = new TPPlayerListeners(this.TAG);
      this.mPlayerAdapter = new TPPlayerAdapter(this.mContext);
      this.mPlayerAdapter.setOnPreparedListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnCompletionListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnInfoListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoSizeChangedListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnErrorListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnSeekCompleteListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoSizeChangedListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnSubtitleDataListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnSubtitleFrameOutListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnAudioPcmOutputListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnVideoFrameOutListener(localInnerPlayerListener);
      this.mPlayerAdapter.setOnPlayerStateChangeListener(localInnerPlayerListener);
      if (paramLooper1 != null)
      {
        paramLooper2 = paramLooper1;
        if (paramLooper1 != Looper.getMainLooper()) {}
      }
      else
      {
        this.mHandlerThread = new HandlerThread("TP-workthread");
        this.mHandlerThread.start();
        paramLooper2 = this.mHandlerThread.getLooper();
      }
      this.mPlayerInternal = new TPPlayerInternal(this.mContext, paramLooper2, this);
      pushEvent(101, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager = new TPPlayManagerImpl(paramContext);
      this.mPlayProxyManager.setPlayListener(localInnerPlayerListener);
      this.mTPPluginManager.addPlugin(new TPReportPlugin()).addPlugin(new TPLogPlugin());
      this.proxyTrackUrls = new ArrayList();
      return;
    }
  }
  
  private void handleAudioTrackProxy(Object paramObject)
  {
    if (!(paramObject instanceof TPPlayerMsg.TPAudioTrackInfo)) {
      return;
    }
    paramObject = (TPPlayerMsg.TPAudioTrackInfo)paramObject;
    String str = this.mPlayProxyManager.startDownLoadTrackUrl(2, paramObject.audioTrackUrl, null);
    this.proxyTrackUrls.add(str);
    paramObject.proxyUrl = str;
  }
  
  private void handleOnError(int paramInt1, int paramInt2)
  {
    pushEvent(108, paramInt1, paramInt2, "", new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(3)).put("code", paramInt1 + "." + paramInt2).build());
    this.mPlayProxyManager.setProxyPlayState(3);
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramInt == 200)
    {
      this.mPlayProxyManager.setProxyPlayState(4);
      pushEvent(114, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("ptime", Long.valueOf(handleGetCurrentPositionMs())).put("url", this.mUrl).build());
      return;
    }
    if (paramInt == 201)
    {
      setProxyStatePlayingOrPause();
      pushEvent(115, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      return;
    }
    if (paramInt == 3) {
      if (!(paramObject instanceof Long)) {
        break label405;
      }
    }
    label405:
    for (paramLong1 = ((Long)paramObject).longValue();; paramLong1 = -1L)
    {
      TPLogUtil.i(this.TAG, "switch definition finish defId:" + paramLong1);
      if (paramLong1 > 0L) {
        this.mPlayProxyManager.playerSwitchDefComplete(paramLong1);
      }
      pushEvent(121, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong1 + "").build());
      return;
      if (paramInt == 106)
      {
        pushEvent(105, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
        return;
      }
      if (paramInt == 501)
      {
        pushEvent(117, 0, 0, null, paramObject);
        return;
      }
      if (paramInt == 107)
      {
        pushEvent(119, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
        return;
      }
      if (paramInt != 4) {
        break;
      }
      pushEvent(123, 0, 0, null, new TPHashMapBuilder().put("opaque", paramObject).put("etime", Long.valueOf(System.currentTimeMillis())).put("code", paramLong1 + "." + paramLong2).build());
      return;
    }
  }
  
  private void handlePlayerCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.mTransformCallbackHandler != null)
    {
      Message localMessage = this.mTransformCallbackHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.mTransformCallbackHandler.sendMessage(localMessage);
    }
  }
  
  private void handlePlayerCallbackDelay(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    if (this.mTransformCallbackHandler != null)
    {
      Message localMessage = this.mTransformCallbackHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.mTransformCallbackHandler.removeMessages(paramInt1);
      this.mTransformCallbackHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void handleSelectAudioTrack(Object paramObject)
  {
    if (!(paramObject instanceof TPPlayerMsg.TPAudioTrackInfo)) {
      return;
    }
    paramObject = (TPPlayerMsg.TPAudioTrackInfo)paramObject;
    if (!TextUtils.isEmpty(paramObject.audioTrackUrl)) {
      try
      {
        this.mPlayProxyManager.startDemuxer(paramObject.audioTrackUrl, paramObject.keyId);
        return;
      }
      catch (Exception paramObject)
      {
        TPLogUtil.e(this.TAG, paramObject);
        return;
      }
    }
    try
    {
      this.mPlayProxyManager.stopDemuxer();
      return;
    }
    catch (Exception paramObject)
    {
      TPLogUtil.e(this.TAG, paramObject);
    }
  }
  
  private boolean isUseProxyEnable()
  {
    return (this.mPlayProxyManager.isEnable()) && (TPPlayerConfig.isUseP2P()) && (this.mUseProxy);
  }
  
  private void notifyIsUseProxyInfo()
  {
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    if (isUseProxyEnable()) {}
    for (long l = 1L;; l = 0L)
    {
      localTPSwitchCommonParams.arg1 = l;
      handlePlayerCallback(261, 1009, 0, localTPSwitchCommonParams);
      return;
    }
  }
  
  private void pushEvent(int paramInt)
  {
    pushEvent(paramInt, 0, 0, "", null);
  }
  
  private void pushEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    try
    {
      if (this.mTPPluginManager != null) {
        this.mTPPluginManager.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.e(this.TAG, paramString);
    }
  }
  
  private void removePlayerCallback(int paramInt)
  {
    if (this.mTransformCallbackHandler != null) {
      this.mTransformCallbackHandler.removeMessages(paramInt);
    }
  }
  
  private void setProxyStatePlayingOrPause()
  {
    if (this.mPlayerAdapter.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.mPlayProxyManager.setProxyPlayState(i);
      return;
    }
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2);
    this.mPlayerInternal.addAudioTrackSource(paramString1, paramString2, null);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2 + ", downloadParamData:" + paramTPDownloadParamData);
    this.mPlayerInternal.addAudioTrackSource(paramString1, paramString2, paramTPDownloadParamData);
  }
  
  public ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase)
  {
    if (this.mTPPluginManager != null) {
      this.mTPPluginManager.addPlugin(paramITPPluginBase);
    }
    return null;
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "addSubtitleSource, url:" + paramString1 + ", mimeType:" + paramString2 + ", name:" + paramString3);
    this.mPlayerInternal.addSubtitleSource(paramString1, paramString2, paramString3, null);
  }
  
  public void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "addSubtitleSource, url:" + paramString1 + ", name:" + paramString3 + ", downloadParamData:" + paramTPDownloadParamData);
    this.mPlayerInternal.addSubtitleSource(paramString1, paramString2, paramString3, paramTPDownloadParamData);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "captureVideo, params:" + paramTPCaptureParams + ", captureCallBack:" + paramTPCaptureCallBack);
    this.mPlayerInternal.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "deselectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.mPlayerInternal.deselectTrack(paramInt, paramLong);
  }
  
  public int getBufferPercent()
  {
    return this.mPlayerInternal.getBufferPercent();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerInternal.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerInternal.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mPlayerInternal.getFileSizeBytes();
  }
  
  public long getPlayableDurationMs()
  {
    return this.mPlayerInternal.getPlayableDurationMs();
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    return this.mPlayProxyManager;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "getProgramInfo");
    return this.mPlayerInternal.getProgramInfo();
  }
  
  public long getPropertyLong(int paramInt)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "getPropertyLong, paramId:" + paramInt);
    return this.mPlayerInternal.getPropertyLong(paramInt);
  }
  
  public String getPropertyString(int paramInt)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "getPropertyString, paramId:" + paramInt);
    return this.mPlayerInternal.getPropertyString(paramInt);
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    return this.mReportManager;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "getTrackInfo");
    return this.mPlayerInternal.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "getVideoHeight");
    return this.mPlayerInternal.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "getVideoWidth");
    return this.mPlayerInternal.getVideoWidth();
  }
  
  public void handleAddAudioSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    if (!isUseProxyEnable())
    {
      TPLogUtil.e(this.TAG, "handleAddAudioSource, proxy is not enable.");
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!TPCommonUtils.isUrl(paramString1)))
    {
      TPLogUtil.e(this.TAG, "handleAddAudioSource, illegal argument.");
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      TPOptionalParam localTPOptionalParam = new TPOptionalParam();
      if (paramTPDownloadParamData != null) {
        localTPOptionalParam.buildString(6, paramTPDownloadParamData.getAudioTrackKeyId());
      }
      localArrayList.add(localTPOptionalParam);
      this.mPlayerAdapter.addAudioTrackSource(paramString1, paramString2, localArrayList);
      return;
    }
    catch (Exception paramString1)
    {
      TPLogUtil.e(this.TAG, paramString1);
    }
  }
  
  public void handleAddSubTitle(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((isUseProxyEnable()) && (TPCommonUtils.isUrl(paramString1)))
      {
        paramTPDownloadParamData = this.mPlayProxyManager.startDownLoadTrackUrl(3, paramString1, paramTPDownloadParamData);
        this.proxyTrackUrls.add(paramTPDownloadParamData);
        this.mPlayerAdapter.addSubtitleSource(paramTPDownloadParamData, paramString2, paramString3);
      }
      for (;;)
      {
        pushEvent(118, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(l)).put("etime", Long.valueOf(System.currentTimeMillis())).put("url", paramString1).build());
        return;
        this.mPlayerAdapter.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      TPLogUtil.e(this.TAG, paramString1);
    }
  }
  
  public void handleDeselectTrack(int paramInt, long paramLong)
  {
    try
    {
      this.mPlayerAdapter.deselectTrack(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public long handleGetAdvRemainTime()
  {
    ITPPlayerProxyListener localITPPlayerProxyListener = this.mPlayProxyManager.getTPPlayerProxyListener();
    if (localITPPlayerProxyListener != null) {
      return localITPPlayerProxyListener.getAdvRemainTimeMs();
    }
    return -1L;
  }
  
  public int handleGetBufferPercent()
  {
    if (this.mPlayerAdapter.getDurationMs() == 0L) {
      return 0;
    }
    return (int)(100.0F * (float)(this.mPlayerAdapter.getPlayableDurationMs() - this.mPlayerAdapter.getCurrentPositionMs()) / (float)this.mPlayerAdapter.getDurationMs());
  }
  
  public int handleGetCurrentPlayClipNo()
  {
    ITPPlayerAdapter localITPPlayerAdapter = this.mPlayerAdapter;
    if (localITPPlayerAdapter != null) {
      return localITPPlayerAdapter.getCurrentPlayClipNo();
    }
    return 0;
  }
  
  public long handleGetCurrentPositionMs()
  {
    return this.mPlayerAdapter.getCurrentPositionMs();
  }
  
  public long handleGetDurationMs()
  {
    return this.mPlayerAdapter.getDurationMs();
  }
  
  public long handleGetFileSizeBytes()
  {
    return this.mTotalFileSizeByte;
  }
  
  public Object handleGetPlayInfo(long paramLong)
  {
    return null;
  }
  
  public Object handleGetPlayInfo(String paramString)
  {
    return null;
  }
  
  public long handleGetPlayableDurationMs()
  {
    if (isUseProxyEnable())
    {
      if ((this.mCurrentDownloadSizeByte > 0L) && (this.mTotalFileSizeByte > 0L)) {
        return (this.mCurrentDownloadSizeByte * 1.0D / this.mTotalFileSizeByte * this.mPlayerAdapter.getDurationMs());
      }
      return this.mDownloadPlayableDurationMs;
    }
    return this.mPlayerAdapter.getPlayableDurationMs();
  }
  
  public long handleGetPlayerBufferLength()
  {
    ITPPlayerAdapter localITPPlayerAdapter = this.mPlayerAdapter;
    if (localITPPlayerAdapter != null) {
      return localITPPlayerAdapter.getPlayableDurationMs() - this.mPlayerAdapter.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public TPProgramInfo[] handleGetProgramInfo()
  {
    return this.mPlayerAdapter.getProgramInfo();
  }
  
  public long handleGetPropertyLong(int paramInt)
  {
    try
    {
      long l = this.mPlayerAdapter.getPropertyLong(paramInt);
      return l;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
    return 0L;
  }
  
  public String handleGetPropertyString(int paramInt)
  {
    try
    {
      String str = this.mPlayerAdapter.getPropertyString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
    return null;
  }
  
  public TPTrackInfo[] handleGetTrackInfo()
  {
    return this.mPlayerAdapter.getTrackInfo();
  }
  
  public int handleGetVideoHeight()
  {
    return this.mPlayerAdapter.getVideoHeight();
  }
  
  public int handleGetVideoWidth()
  {
    return this.mPlayerAdapter.getVideoWidth();
  }
  
  public void handleOnDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    TPLogUtil.i(this.TAG, "onDownloadCdnUrlExpired");
    handlePlayerCallback(275, 0, 0, paramMap);
  }
  
  public void handleOnDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = new TPPlayerMsg.TPCDNURLInfo();
    paramString4.url = paramString1;
    paramString4.cdnIp = paramString2;
    paramString4.uIp = paramString3;
    pushEvent(201, 0, 0, null, new TPHashMapBuilder().put("url", paramString1).put("cdnip", paramString2).put("cdnuip", paramString3).build());
    handlePlayerCallback(270, 0, 0, paramString4);
  }
  
  public void handleOnDownloadCdnUrlUpdate(String paramString)
  {
    TPLogUtil.i(this.TAG, "handleOnDownloadCdnUrlUpdate, url:" + paramString);
    handlePlayerCallback(269, 0, 0, paramString);
  }
  
  public void handleOnDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    TPLogUtil.i(this.TAG, "handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    handleOnError(paramInt1, paramInt2);
    handlePlayerCallback(268, paramInt1, paramInt2, paramString);
  }
  
  public void handleOnDownloadFinish()
  {
    TPLogUtil.i(this.TAG, "onDownloadFinish");
    handlePlayerCallback(271, 0, 0, Integer.valueOf(0));
  }
  
  public void handleOnDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    this.mDownloadPlayableDurationMs = paramInt1;
    this.mCurrentDownloadSizeByte = paramLong1;
    this.mTotalFileSizeByte = paramLong2;
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    TPLogUtil.i(this.TAG, "handleOnDownloadProgressUpdate");
    pushEvent(200, 0, 0, null, new TPHashMapBuilder().put("speed", Integer.valueOf(paramInt2)).build());
    handlePlayerCallback(274, 0, 0, localTPDownLoadProgressInfo);
  }
  
  public void handleOnDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    TPLogUtil.i(this.TAG, "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    handlePlayerCallback(273, 0, 0, localTPProtocolInfo);
  }
  
  public void handleOnDownloadStatusUpdate(int paramInt)
  {
    handlePlayerCallback(272, paramInt, 0, null);
  }
  
  public Object handleOnPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      TPLogUtil.i(this.TAG, "onDownloadNoMoreData");
      handlePlayerCallback(276, 0, 0, paramObject1);
      return null;
    }
    if (!(paramObject3 instanceof Integer))
    {
      TPLogUtil.i(this.TAG, "MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
      return null;
    }
    handlePlayerCallback(278, ((Integer)paramObject3).intValue(), 0, null);
    return null;
  }
  
  public void handlePause()
  {
    try
    {
      this.mPlayerAdapter.pause();
      pushEvent(106, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager.setProxyPlayState(5);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handlePrepareAsync()
  {
    try
    {
      this.mPlayerAdapter.prepareAsync();
      String str = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
      pushEvent(102, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("url", this.mUrl).put("p2p", Boolean.valueOf(isUseProxyEnable())).put("flowid", str).build());
      pushEvent(501, this.mPlayerAdapter.getNativePlayerId(), 0, null, null);
      notifyIsUseProxyInfo();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleRelease()
  {
    try
    {
      this.mPlayerAdapter.release();
      pushEvent(112, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
      if (this.mTransformCallbackHandler != null)
      {
        this.mTransformCallbackHandler.removeCallbacksAndMessages(null);
        this.mTransformCallbackHandler = null;
      }
      this.mPlayerListeners.clear();
      this.mPlayerListeners = null;
      this.mPlayProxyManager.release();
      this.proxyTrackUrls.clear();
      this.mDownloadPlayableDurationMs = -1L;
      this.mCurrentDownloadSizeByte = -1L;
      this.mTotalFileSizeByte = -1L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e(this.TAG, localException);
      }
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
  }
  
  public void handleReset()
  {
    try
    {
      this.mPlayerAdapter.reset();
      pushEvent(113, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
      this.mPlayProxyManager.stopDownload();
      this.mProxyStatus = -1;
      this.proxyTrackUrls.clear();
      this.mDownloadPlayableDurationMs = -1L;
      this.mCurrentDownloadSizeByte = -1L;
      this.mTotalFileSizeByte = -1L;
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSeekTo(int paramInt1, int paramInt2)
  {
    pushEvent(109, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("pstime", Long.valueOf(handleGetCurrentPositionMs())).build());
    if (paramInt2 > 0) {
      this.mPlayerAdapter.seekTo(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.mPlayProxyManager.setProxyPlayState(1);
      return;
      this.mPlayerAdapter.seekTo(paramInt1);
    }
  }
  
  public void handleSelectProgram(int paramInt, long paramLong)
  {
    try
    {
      this.mPlayerAdapter.selectProgram(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSelectTrack(int paramInt, long paramLong)
  {
    try
    {
      TPTrackInfo[] arrayOfTPTrackInfo = this.mPlayerAdapter.getTrackInfo();
      if ((arrayOfTPTrackInfo != null) && (arrayOfTPTrackInfo.length > paramInt)) {
        pushEvent(122, 0, 0, null, new TPHashMapBuilder().put("opaque", Long.valueOf(paramLong)).put("tracktype", Integer.valueOf(arrayOfTPTrackInfo[paramInt].getTrackType())).put("stime", Long.valueOf(System.currentTimeMillis())).build());
      }
      this.mPlayerAdapter.selectTrack(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSetAudioGainRatio(float paramFloat)
  {
    try
    {
      this.mPlayerAdapter.setAudioGainRatio(paramFloat);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSetDataSource(TPThreadSwitchCommons.TPDataSourceParams paramTPDataSourceParams)
  {
    if (paramTPDataSourceParams != null)
    {
      try
      {
        if (!TextUtils.isEmpty(paramTPDataSourceParams.url))
        {
          this.mUrl = paramTPDataSourceParams.url;
          TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramTPDataSourceParams.url);
          TPLogUtil.i(this.TAG, "handleSetDataSource originalUrl=" + paramTPDataSourceParams.url);
          if (isUseProxyEnable())
          {
            localTPUrlDataSource = this.mPlayProxyManager.startDownloadPlay(paramTPDataSourceParams.url);
            TPLogUtil.i(this.TAG, "handleSetDataSource selfPlayerUrl=" + localTPUrlDataSource.getSelfPlayerUrl());
            TPLogUtil.i(this.TAG, "handleSetDataSource systemPlayerUrl=" + localTPUrlDataSource.getSystemPlayerUrl());
            TPLogUtil.d("SuperPlayer", "日志过滤(DataTransport)：【" + TPCommonUtils.getTaskIdFromDataTransportUrl(localTPUrlDataSource.getSelfPlayerUrl()) + "】, playId:" + (sPlayId - 1) + " , originalUrl=" + paramTPDataSourceParams.url + ", localUrl=" + localTPUrlDataSource.getSelfPlayerUrl());
          }
          if (paramTPDataSourceParams.httpHeader != null)
          {
            this.mPlayerAdapter.setDataSource(localTPUrlDataSource, paramTPDataSourceParams.httpHeader);
            return;
          }
          this.mPlayerAdapter.setDataSource(localTPUrlDataSource);
          return;
        }
      }
      catch (Exception paramTPDataSourceParams)
      {
        TPLogUtil.e(this.TAG, paramTPDataSourceParams);
        return;
      }
      if (paramTPDataSourceParams.mediaAsset != null)
      {
        if (isUseProxyEnable()) {
          paramTPDataSourceParams.mediaAsset = this.mPlayProxyManager.startDownloadPlayByAsset(paramTPDataSourceParams.mediaAsset);
        }
        if (paramTPDataSourceParams.mediaAsset != null)
        {
          TPLogUtil.i(this.TAG, "handleSetDataSource mediaAsset=" + paramTPDataSourceParams.mediaAsset.getUrl());
          this.mPlayerAdapter.setDataSource(paramTPDataSourceParams.mediaAsset);
        }
      }
      else
      {
        this.mPlayerAdapter.setDataSource(paramTPDataSourceParams.pfd);
      }
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean)
  {
    try
    {
      this.mPlayerAdapter.setLoopback(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    try
    {
      this.mPlayerAdapter.setLoopback(paramBoolean, paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSetOutputMute(boolean paramBoolean)
  {
    try
    {
      this.mPlayerAdapter.setOutputMute(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSetPlaySpeedRatio(float paramFloat)
  {
    try
    {
      this.mPlayerAdapter.setPlaySpeedRatio(paramFloat);
      pushEvent(116, 0, 0, null, new TPHashMapBuilder().put("scene", Float.valueOf(paramFloat)).build());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e(this.TAG, localException);
      }
    }
  }
  
  public void handleSetPlayerOptionParams(TPOptionalParam paramTPOptionalParam)
  {
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 205))
    {
      this.mUseProxy = paramTPOptionalParam.getParamBoolean().value;
      return;
    }
    this.mPlayProxyManager.setPlayerOptionalParam(paramTPOptionalParam);
    this.mPlayerAdapter.setPlayerOptionalParam(paramTPOptionalParam);
  }
  
  public void handleSetSurface(Surface paramSurface)
  {
    this.mPlayerAdapter.setSurface(paramSurface);
  }
  
  public void handleStart()
  {
    try
    {
      this.mPlayerAdapter.start();
      pushEvent(104, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager.setProxyPlayState(0);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleStop()
  {
    try
    {
      this.mPlayerAdapter.stop();
      pushEvent(107, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
      this.mPlayProxyManager.setProxyPlayState(5);
      this.mDownloadPlayableDurationMs = -1L;
      this.mCurrentDownloadSizeByte = -1L;
      this.mTotalFileSizeByte = -1L;
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException);
    }
  }
  
  public void handleSwitchDef(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    paramITPMediaAsset = this.mPlayProxyManager.startSwitchDefTaskByAsset(paramITPMediaAsset, paramLong, paramTPVideoInfo);
    if (paramITPMediaAsset != null) {}
    try
    {
      TPLogUtil.i(this.TAG, "handleSwitchDef, proxyMediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong);
      this.mPlayerAdapter.switchDefinition(paramITPMediaAsset, paramInt, paramLong);
      pushEvent(120, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong + "").build());
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      TPLogUtil.e(this.TAG, paramITPMediaAsset);
    }
  }
  
  public void handleSwitchDef(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    paramTPVideoInfo = this.mPlayProxyManager.startSwitchDefTask(paramLong, paramString, paramTPVideoInfo);
    try
    {
      TPLogUtil.i(this.TAG, "handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
      this.mPlayerAdapter.switchDefinition(paramTPVideoInfo, paramInt, paramLong);
      pushEvent(120, 0, 0, null, new TPHashMapBuilder().put("switch", paramLong + "").build());
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.e(this.TAG, paramString);
    }
  }
  
  public void handlerCaptureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    try
    {
      this.mPlayerAdapter.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      return;
    }
    catch (Exception paramTPCaptureParams)
    {
      TPLogUtil.e(this.TAG, paramTPCaptureParams);
    }
  }
  
  public void handlerSetVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo != null) {}
    try
    {
      this.mPlayProxyManager.setVideoInfo(paramTPVideoInfo);
      this.mPlayerAdapter.setVideoInfo(paramTPVideoInfo);
      return;
    }
    catch (Exception paramTPVideoInfo)
    {
      TPLogUtil.e(this.TAG, paramTPVideoInfo);
    }
  }
  
  public void pause()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "pause");
    this.mPlayerInternal.pause();
  }
  
  public void pauseDownload()
  {
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 0L);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam(localTPOptionalParam);
      this.mPlayProxyManager.pauseDownload();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e(this.TAG, localException.getMessage());
      }
    }
  }
  
  public void prepareAsync()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "prepareAsync");
    this.mPlayerInternal.prepareAsync();
  }
  
  public void release()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "release");
    this.mPlayerInternal.release();
    this.mTPPluginManager.release();
  }
  
  public void reset()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "reset");
    this.mPlayerInternal.reset();
  }
  
  public void resumeDownload()
  {
    this.mPlayProxyManager.resumeDownload();
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 1L);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam(localTPOptionalParam);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e(this.TAG, localException.getMessage());
    }
  }
  
  public void seekTo(int paramInt)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "seekTo, positionMs:" + paramInt);
    this.mPlayerInternal.seekTo(paramInt);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.mPlayerInternal.seekTo(paramInt1, paramInt2);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "selectProgram, programIndex:" + paramInt + ", opaque:" + paramLong);
    this.mPlayerInternal.selectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "selectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.mPlayerInternal.selectTrack(paramInt, paramLong);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.mPlayerInternal.setAudioGainRatio(paramFloat);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mPlayProxyManager.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setDataSource, ParcelFileDescriptor");
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("error : setDataSource , pfd invalid");
    }
    this.mPlayerInternal.setDataSource(paramParcelFileDescriptor);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setDataSource, ITPMediaAsset");
    if (paramITPMediaAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (((paramITPMediaAsset instanceof ITPMediaDRMAsset)) && ((TextUtils.isEmpty(paramITPMediaAsset.getUrl())) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties() == null) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties().isEmpty()))) {
      throw new IllegalArgumentException("drm asset url is null or drm property is null");
    }
    this.mPlayerInternal.setDataSource(paramITPMediaAsset);
  }
  
  public void setDataSource(String paramString)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("error : setDataSource , data source invalid");
    }
    this.mPlayerInternal.setDataSource(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setDataSource, url:" + paramString + ", httpHeader:" + paramMap);
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("error : setDataSource , data source invalid");
    }
    this.mPlayerInternal.setDataSource(paramString, paramMap);
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    this.mPlayProxyManager.setIsActive(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setLoopback, isLoopback:" + paramBoolean);
    this.mPlayerInternal.setLoopback(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    this.mPlayerInternal.setLoopback(paramBoolean, paramLong1, paramLong2);
  }
  
  public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnAudioPcmOutputListener(paramIOnAudioFrameOutputListener);
    }
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnCompletionListener(paramIOnCompletionListener);
    }
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnErrorListener(paramIOnErrorListener);
    }
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnInfoListener(paramIOnInfoListener);
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnPlayerStateChangeListener(paramIOnStateChangeListener);
    }
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnPreparedListener(paramIOnPreparedListener);
    }
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
    }
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
    }
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
    }
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
    }
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    if (this.mPlayerListeners != null) {
      this.mPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
    }
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setOutputMute, isOutputMute:" + paramBoolean);
    this.mPlayerInternal.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.mPlayerInternal.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    this.mPlayerInternal.setPlayerOptionalParam(paramTPOptionalParam);
  }
  
  public void setSurface(Surface paramSurface)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "setSurface, surface:" + paramSurface);
    this.mPlayerInternal.setSurface(paramSurface);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    this.mPlayerInternal.setVideoInfo(paramTPVideoInfo);
  }
  
  public void start()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "start");
    this.mPlayerInternal.start();
  }
  
  public void stop()
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "stop");
    this.mPlayerInternal.stop();
  }
  
  public void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo);
    this.mPlayerInternal.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, 2);
  }
  
  public void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo + ", mode:" + paramInt);
    this.mPlayerInternal.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, paramInt);
  }
  
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong);
    this.mPlayerInternal.switchDefinition(paramString, paramLong, paramTPVideoInfo, 2);
  }
  
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    TPLogUtil.i(this.TAG, LOG_API_CALL_PREFIX + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", mode:" + paramInt);
    this.mPlayerInternal.switchDefinition(paramString, paramLong, paramTPVideoInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer
 * JD-Core Version:    0.7.0.1
 */