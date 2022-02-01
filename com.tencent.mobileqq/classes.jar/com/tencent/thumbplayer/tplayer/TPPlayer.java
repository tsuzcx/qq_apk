package com.tencent.thumbplayer.tplayer;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.adapter.ITPPlayerAdapter;
import com.tencent.thumbplayer.adapter.TPPlayerAdapter;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaDrmInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.datatransport.TPPlayManagerImpl;
import com.tencent.thumbplayer.datatransport.resourceloader.ITPAssetResourceLoader;
import com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoader;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginBase;
import com.tencent.thumbplayer.tplayer.plugins.ITPPluginManager;
import com.tencent.thumbplayer.tplayer.plugins.TPPluginManager;
import com.tencent.thumbplayer.tplayer.plugins.report.TPLogPlugin;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager;
import com.tencent.thumbplayer.tplayer.plugins.report.TPReportPlugin;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPThreadAnnotations.ThreadSwitch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class TPPlayer
  implements ITPPlayer
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
  private static final int MSG_ON_PROXY_PCDN_FAILED = 282;
  private static final int MSG_ON_PROXY_PLAYERROR = 268;
  private static final int MSG_ON_PROXY_PLAY_CDN_INFO_UPDATE = 270;
  private static final int MSG_ON_PROXY_PLAY_CDN_URL_UPDATE = 269;
  private static final int MSG_ON_PROXY_PROGRESS_UPDATE = 274;
  private static final int MSG_ON_PROXY_PROTOCOL_UPDATE = 273;
  private static final int MSG_ON_PROXY_QUIC_STATUS_UPDATE = 281;
  private static final int MSG_ON_PROXY_SWITCH_DEFINITION = 278;
  private static final int MSG_ON_SEEK_COMPLETE = 263;
  private static final int MSG_ON_STOP_ASYNC_COMPLETE = 280;
  private static final int MSG_ON_SUBTITLE_DATA = 265;
  private static final int MSG_ON_SUBTITLE_FRAME_BUFFER = 279;
  private static final int MSG_ON_VIDEOFRAMEOUT = 266;
  private static final int MSG_ON_VIDEO_SIZE_CHANGE = 264;
  private static AtomicInteger sLifeCycleId = new AtomicInteger(1000);
  private static int sPlayId;
  private String TAG = "TPPlayer";
  private ITPAssetResourceLoader mAssetResourceLoader;
  private Context mContext;
  private long mCurrentDownloadSizeByte;
  private long mDownloadPlayableDurationMs;
  private String mFlowId;
  private HandlerThread mHandlerThread;
  private TPBaseLogger mLogger;
  private ITPPlayManager mPlayProxyManager;
  private AtomicInteger mPlayTaskId = new AtomicInteger(1000);
  private ITPPlayerAdapter mPlayerAdapter;
  private TPPlayerListeners mPlayerListeners;
  private int mProxyStatus = -1;
  private TPReportManager mReportManager;
  private ITPPluginManager mTPPluginManager;
  private Looper mThreadLooper;
  private long mTotalFileSizeByte;
  private TPPlayer.EventHandler mTransformCallbackHandler;
  private String mUrl = null;
  private boolean mUseProxy = true;
  private boolean mUsingDefaultLogContext = false;
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
    this(paramContext, paramLooper1, paramLooper2, null);
  }
  
  public TPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2, TPLoggerContext paramTPLoggerContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.TAG);
    ((StringBuilder)localObject).append(", playId:");
    ((StringBuilder)localObject).append(sPlayId);
    this.TAG = ((StringBuilder)localObject).toString();
    sPlayId += 1;
    if (paramTPLoggerContext != null)
    {
      localObject = new TPLoggerContext(paramTPLoggerContext, this.TAG);
    }
    else
    {
      localObject = new TPLoggerContext("ThumbPlayer", String.valueOf(sLifeCycleId.incrementAndGet()), String.valueOf(this.mPlayTaskId.incrementAndGet()), this.TAG);
      this.mUsingDefaultLogContext = true;
    }
    this.mLogger = new TPBaseLogger((TPLoggerContext)localObject);
    this.mLogger.info("create TPPlayer");
    this.mContext = paramContext.getApplicationContext();
    this.mTPPluginManager = new TPPluginManager();
    if (paramLooper1 != null)
    {
      paramTPLoggerContext = paramLooper1;
      if (paramLooper1 != Looper.getMainLooper()) {}
    }
    else
    {
      this.mHandlerThread = new HandlerThread("TP-workthread");
      this.mHandlerThread.start();
      paramTPLoggerContext = this.mHandlerThread.getLooper();
    }
    this.mReportManager = new TPReportManager(this.mContext, paramTPLoggerContext);
    this.mTPPluginManager.addPlugin(this.mReportManager);
    pushEvent(100, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
    TPPlayer.InnerPlayerListener localInnerPlayerListener = new TPPlayer.InnerPlayerListener(this);
    this.mPlayerListeners = new TPPlayerListeners(this.mLogger.getTag());
    this.mPlayerAdapter = new TPPlayerAdapter(this.mContext, (TPLoggerContext)localObject);
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
    this.mPlayerAdapter.setOnVideoProcessOutputListener(localInnerPlayerListener);
    this.mPlayerAdapter.setOnAudioProcessOutputListener(localInnerPlayerListener);
    this.mPlayerAdapter.setOnPlayerStateChangeListener(localInnerPlayerListener);
    if (paramTPLoggerContext != null)
    {
      paramLooper1 = paramTPLoggerContext;
      if (paramTPLoggerContext != Looper.getMainLooper()) {}
    }
    else
    {
      this.mHandlerThread = new HandlerThread("TP-workthread");
      this.mHandlerThread.start();
      paramLooper1 = this.mHandlerThread.getLooper();
    }
    this.mThreadLooper = paramLooper1;
    if (paramLooper2 == null)
    {
      if (Looper.myLooper() == null) {
        this.mTransformCallbackHandler = new TPPlayer.EventHandler(this, this, this.mThreadLooper);
      } else {
        this.mTransformCallbackHandler = new TPPlayer.EventHandler(this, this);
      }
    }
    else {
      this.mTransformCallbackHandler = new TPPlayer.EventHandler(this, this, paramLooper2);
    }
    pushEvent(101, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
    this.mPlayProxyManager = new TPPlayManagerImpl(paramContext, this.mThreadLooper);
    this.mPlayProxyManager.setPlayListener(localInnerPlayerListener);
    this.mTPPluginManager.addPlugin(new TPReportPlugin());
    this.mTPPluginManager.addPlugin(new TPLogPlugin());
    this.proxyTrackUrls = new ArrayList();
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
    TPHashMapBuilder localTPHashMapBuilder = new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(3));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt2);
    pushEvent(108, paramInt1, paramInt2, "", localTPHashMapBuilder.put("code", localStringBuilder.toString()).build());
    this.mPlayProxyManager.setProxyPlayState(3);
    this.mPlayProxyManager.pauseDownload();
  }
  
  private void handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (paramInt == 200)
    {
      this.mPlayProxyManager.setProxyPlayState(4);
      pushEvent(114, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("ptime", Long.valueOf(getCurrentPositionMs())).put("url", this.mUrl).build());
      return;
    }
    if (paramInt == 201)
    {
      setProxyStatePlayingOrPause();
      pushEvent(115, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).build());
      return;
    }
    Object localObject;
    if (paramInt == 3)
    {
      paramLong1 = -1L;
      if ((paramObject instanceof Long)) {
        paramLong1 = ((Long)paramObject).longValue();
      }
      paramObject = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switch definition finish defId:");
      ((StringBuilder)localObject).append(paramLong1);
      paramObject.info(((StringBuilder)localObject).toString());
      if (paramLong1 > 0L) {
        this.mPlayProxyManager.playerSwitchDefComplete(paramLong1);
      }
      paramObject = new TPHashMapBuilder();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("");
      pushEvent(121, 0, 0, null, paramObject.put("switch", ((StringBuilder)localObject).toString()).build());
      return;
    }
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
    if (paramInt == 4)
    {
      paramObject = new TPHashMapBuilder().put("opaque", paramObject).put("etime", Long.valueOf(System.currentTimeMillis()));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramLong2);
      pushEvent(123, 0, 0, null, paramObject.put("code", ((StringBuilder)localObject).toString()).build());
      return;
    }
    if (paramInt == 101)
    {
      pushEvent(124, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      return;
    }
    if ((paramInt == 505) && ((paramObject instanceof TPPlayerMsg.TPMediaDrmInfo)))
    {
      paramObject = (TPPlayerMsg.TPMediaDrmInfo)paramObject;
      localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TPMediaDrmInfo secureDecoder:");
      localStringBuilder.append(paramObject.supportSecureDecoder);
      localStringBuilder.append(" secureDecrypt:");
      localStringBuilder.append(paramObject.supportSecureDecrypt);
      localStringBuilder.append(" componentName:");
      localStringBuilder.append(paramObject.componentName);
      localStringBuilder.append(" drmType:");
      localStringBuilder.append(paramObject.drmType);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    }
  }
  
  private void handlePlayerCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    TPPlayer.EventHandler localEventHandler = this.mTransformCallbackHandler;
    if (localEventHandler != null)
    {
      Message localMessage = localEventHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      localEventHandler.sendMessage(localMessage);
    }
  }
  
  private void handlePlayerCallbackDelay(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    Object localObject = this.mTransformCallbackHandler;
    if (localObject != null)
    {
      localObject = ((TPPlayer.EventHandler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).arg1 = paramInt2;
      ((Message)localObject).arg2 = paramInt3;
      ((Message)localObject).obj = paramObject;
      this.mTransformCallbackHandler.removeMessages(paramInt1);
      this.mTransformCallbackHandler.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  private void handleSelectAudioTrack(Object paramObject)
  {
    if (!(paramObject instanceof TPPlayerMsg.TPAudioTrackInfo)) {
      return;
    }
    paramObject = (TPPlayerMsg.TPAudioTrackInfo)paramObject;
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSelectAudioTrack, audioTrack url:");
    localStringBuilder.append(paramObject.audioTrackUrl);
    localTPBaseLogger.info(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramObject.audioTrackUrl)) {
      try
      {
        this.mPlayProxyManager.startDemuxer(paramObject.audioTrackUrl, paramObject.keyId);
        return;
      }
      catch (Exception paramObject)
      {
        this.mLogger.printException(paramObject);
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
      this.mLogger.printException(paramObject);
    }
  }
  
  private void internalStop()
  {
    this.mPlayerAdapter.stop();
    pushEvent(107, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
    this.mPlayProxyManager.setProxyPlayState(5);
    this.mPlayProxyManager.pauseDownload();
    this.mDownloadPlayableDurationMs = -1L;
    this.mCurrentDownloadSizeByte = -1L;
    this.mTotalFileSizeByte = -1L;
  }
  
  private boolean isUseProxyEnable()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUseProxyEnable, mPlayProxyManager.isEnable()=");
    localStringBuilder.append(this.mPlayProxyManager.isEnable());
    localStringBuilder.append(" TPPlayerConfig.isUseP2P()=");
    localStringBuilder.append(TPPlayerConfig.isUseP2P());
    localStringBuilder.append(" mUseProxy=");
    localStringBuilder.append(this.mUseProxy);
    localTPBaseLogger.info(localStringBuilder.toString());
    return (this.mPlayProxyManager.isEnable()) && (TPPlayerConfig.isUseP2P()) && (this.mUseProxy);
  }
  
  private void notifyIsUseProxyInfo()
  {
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    long l;
    if (isUseProxyEnable()) {
      l = 1L;
    } else {
      l = 0L;
    }
    localTPSwitchCommonParams.arg1 = l;
    handlePlayerCallback(261, 1009, 0, localTPSwitchCommonParams);
  }
  
  private void pushEvent(int paramInt)
  {
    pushEvent(paramInt, 0, 0, "", null);
  }
  
  private void pushEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    try
    {
      if (this.mTPPluginManager != null)
      {
        this.mTPPluginManager.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        return;
      }
    }
    catch (Exception paramString)
    {
      this.mLogger.printException(paramString);
    }
  }
  
  private void removePlayerCallback(int paramInt)
  {
    TPPlayer.EventHandler localEventHandler = this.mTransformCallbackHandler;
    if (localEventHandler != null) {
      localEventHandler.removeMessages(paramInt);
    }
  }
  
  private void setProxyStatePlayingOrPause()
  {
    int i;
    if (this.mPlayerAdapter.isPlaying()) {
      i = 0;
    } else {
      i = 5;
    }
    this.mPlayProxyManager.setProxyPlayState(i);
  }
  
  private boolean validCallSwitchDef()
  {
    int i = this.mPlayerAdapter.getCurrentState();
    return (i == 4) || (i == 5) || (i == 6) || (i == 7);
  }
  
  private boolean validStateCall(int paramInt)
  {
    int i = this.mPlayerAdapter.getCurrentState();
    if (paramInt == 2)
    {
      if (i == 1) {
        return true;
      }
    }
    else
    {
      if ((paramInt != 17) || (i == 4) || (i == 5) || (i == 6)) {
        break label54;
      }
      if (i == 7) {
        return true;
      }
    }
    return false;
    label54:
    return true;
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("addAudioTrackSource, url:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", name:");
    localStringBuilder.append(paramString2);
    localTPBaseLogger.info(localStringBuilder.toString());
    addAudioTrackSource(paramString1, paramString2, null);
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    Object localObject1 = this.mLogger;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(LOG_API_CALL_PREFIX);
    ((StringBuilder)localObject2).append("addAudioTrackSource, url:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(", name:");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(", downloadParamData:");
    ((StringBuilder)localObject2).append(paramTPDownloadParamData);
    ((TPBaseLogger)localObject1).info(((StringBuilder)localObject2).toString());
    if (!isUseProxyEnable())
    {
      this.mLogger.error("handleAddAudioSource, proxy is not enable.");
      return;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (TPCommonUtils.isUrl(paramString1))) {
      try
      {
        localObject1 = new ArrayList();
        localObject2 = new TPOptionalParam();
        if (paramTPDownloadParamData != null) {
          ((TPOptionalParam)localObject2).buildString(6, paramTPDownloadParamData.getAudioTrackKeyId());
        }
        ((List)localObject1).add(localObject2);
        this.mPlayerAdapter.addAudioTrackSource(paramString1, paramString2, (List)localObject1);
        return;
      }
      catch (Exception paramString1)
      {
        this.mLogger.printException(paramString1);
        return;
      }
    }
    this.mLogger.error("handleAddAudioSource, illegal argument.");
  }
  
  public ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase)
  {
    ITPPluginManager localITPPluginManager = this.mTPPluginManager;
    if (localITPPluginManager != null) {
      localITPPluginManager.addPlugin(paramITPPluginBase);
    }
    return null;
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("addSubtitleSource, url:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", mimeType:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", name:");
    localStringBuilder.append(paramString3);
    localTPBaseLogger.info(localStringBuilder.toString());
    addSubtitleSource(paramString1, paramString2, paramString3, null);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void addSubtitleSource(@NonNull String paramString1, String paramString2, @NonNull String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("addSubtitleSource, url:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", name:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(", downloadParamData:");
    localStringBuilder.append(paramTPDownloadParamData);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      long l = System.currentTimeMillis();
      if ((isUseProxyEnable()) && (TPCommonUtils.isUrl(paramString1)))
      {
        paramTPDownloadParamData = this.mPlayProxyManager.startDownLoadTrackUrl(3, paramString1, paramTPDownloadParamData);
        this.proxyTrackUrls.add(paramTPDownloadParamData);
        this.mPlayerAdapter.addSubtitleSource(paramTPDownloadParamData, paramString2, paramString3);
      }
      else
      {
        this.mPlayerAdapter.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      pushEvent(118, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(l)).put("etime", Long.valueOf(System.currentTimeMillis())).put("url", paramString1).put("name", paramString3).build());
      return;
    }
    catch (Exception paramString1)
    {
      this.mLogger.printException(paramString1);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("captureVideo, params:");
    localStringBuilder.append(paramTPCaptureParams);
    localStringBuilder.append(", captureCallBack:");
    localStringBuilder.append(paramTPCaptureCallBack);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      return;
    }
    catch (Exception paramTPCaptureParams)
    {
      this.mLogger.printException(paramTPCaptureParams);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void deselectTrack(int paramInt, long paramLong)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("deselectTrack, trackIndex:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", opaque:");
    localStringBuilder.append(paramLong);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.deselectTrack(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper)
  {
    if (paramITPAssetResourceLoaderListener != null)
    {
      this.mPlayProxyManager.setIsUseResourceLoader(true);
      ITPAssetResourceLoader localITPAssetResourceLoader = this.mAssetResourceLoader;
      if (localITPAssetResourceLoader != null)
      {
        localITPAssetResourceLoader.release();
        this.mAssetResourceLoader = null;
      }
      this.mAssetResourceLoader = new TPAssetResourceLoader(this.mContext, paramLooper);
      this.mAssetResourceLoader.setTPAssetResourceLoaderListener(paramITPAssetResourceLoaderListener);
      this.mAssetResourceLoader.fillInContentInformation();
      return;
    }
    this.mPlayProxyManager.setIsUseResourceLoader(false);
  }
  
  public int getBufferPercent()
  {
    if (this.mPlayerAdapter.getDurationMs() == 0L) {
      return 0;
    }
    return (int)((float)(this.mPlayerAdapter.getPlayableDurationMs() - this.mPlayerAdapter.getCurrentPositionMs()) * 100.0F / (float)this.mPlayerAdapter.getDurationMs());
  }
  
  public long getCurrentPositionMs()
  {
    return this.mPlayerAdapter.getCurrentPositionMs();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getCurrentState()
  {
    return this.mPlayerAdapter.getCurrentState();
  }
  
  public long getDurationMs()
  {
    return this.mPlayerAdapter.getDurationMs();
  }
  
  public long getFileSizeBytes()
  {
    return this.mTotalFileSizeByte;
  }
  
  public Looper getLooper()
  {
    return this.mThreadLooper;
  }
  
  public long getPlayableDurationMs()
  {
    if (isUseProxyEnable())
    {
      long l1 = this.mCurrentDownloadSizeByte;
      if (l1 > 0L)
      {
        long l2 = this.mTotalFileSizeByte;
        if (l2 > 0L)
        {
          double d1 = l1;
          Double.isNaN(d1);
          double d2 = l2;
          Double.isNaN(d2);
          d1 = d1 * 1.0D / d2;
          d2 = this.mPlayerAdapter.getDurationMs();
          Double.isNaN(d2);
          return (d1 * d2);
        }
      }
      return this.mDownloadPlayableDurationMs;
    }
    return this.mPlayerAdapter.getPlayableDurationMs();
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    return this.mPlayProxyManager;
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getPlayerType()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getPlayerType");
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getPlayerType();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public TPProgramInfo[] getProgramInfo()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getProgramInfo");
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getProgramInfo();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public long getPropertyLong(int paramInt)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getPropertyLong, paramId:");
    localStringBuilder.append(paramInt);
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getPropertyLong(paramInt);
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public String getPropertyString(int paramInt)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getPropertyString, paramId:");
    localStringBuilder.append(paramInt);
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getPropertyString(paramInt);
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    TPReportManager localTPReportManager = this.mReportManager;
    ReportThumbPlayer.getInstance().getReportManager(this, localTPReportManager);
    return localTPReportManager;
  }
  
  public String getTag()
  {
    return this.mLogger.getTag();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public TPTrackInfo[] getTrackInfo()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getTrackInfo");
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getTrackInfo();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getVideoHeight()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getVideoHeight");
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getVideoHeight();
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public int getVideoWidth()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("getVideoWidth");
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mPlayerAdapter.getVideoWidth();
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void pause()
  {
    ReportThumbPlayer.getInstance().pause(this);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("pause");
    localTPBaseLogger.info(localStringBuilder.toString());
    this.mPlayerAdapter.pause();
    try
    {
      pushEvent(106, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager.setProxyPlayState(5);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void pauseDownload()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("pauseDownload");
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = new TPOptionalParam().buildLong(502, 0L);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam((TPOptionalParam)localObject);
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
    this.mPlayProxyManager.pauseDownload();
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void prepareAsync()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(LOG_API_CALL_PREFIX);
    localStringBuilder2.append("prepareAsync");
    localTPBaseLogger.info(localStringBuilder2.toString());
    try
    {
      this.mPlayProxyManager.resumeDownload();
      this.mPlayerAdapter.prepareAsync();
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mLogger.printException(localRuntimeException);
    }
    try
    {
      if (TextUtils.isEmpty(this.mFlowId))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(UUID.randomUUID().toString());
        localStringBuilder1.append(System.nanoTime());
        localStringBuilder1.append("_");
        localStringBuilder1.append(TPPlayerConfig.getPlatform());
        this.mFlowId = localStringBuilder1.toString();
      }
      pushEvent(102, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("url", this.mUrl).put("p2p", Boolean.valueOf(isUseProxyEnable())).put("flowid", this.mFlowId).build());
      pushEvent(501, this.mPlayerAdapter.getNativePlayerId(), 0, null, null);
      notifyIsUseProxyInfo();
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void release()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("release");
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    this.mPlayerAdapter.release();
    pushEvent(112, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
    localObject = this.mTransformCallbackHandler;
    if (localObject != null)
    {
      ((TPPlayer.EventHandler)localObject).removeCallbacksAndMessages(null);
      this.mTransformCallbackHandler = null;
    }
    this.mPlayerListeners.clear();
    this.mPlayerListeners = null;
    this.mPlayProxyManager.release();
    this.proxyTrackUrls.clear();
    localObject = this.mAssetResourceLoader;
    if (localObject != null)
    {
      ((ITPAssetResourceLoader)localObject).release();
      this.mAssetResourceLoader = null;
    }
    this.mDownloadPlayableDurationMs = -1L;
    this.mCurrentDownloadSizeByte = -1L;
    this.mTotalFileSizeByte = -1L;
    localObject = this.mHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.mHandlerThread = null;
    }
    this.mTPPluginManager.release();
    ReportThumbPlayer.getInstance().release(this);
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void reset()
  {
    ReportThumbPlayer.getInstance().reset(this);
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("reset");
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    if (this.mUsingDefaultLogContext)
    {
      this.mLogger.updateTaskId(String.valueOf(this.mPlayTaskId.incrementAndGet()));
      this.mPlayerAdapter.updateLoggerContext(this.mLogger.getTPLoggerContext());
      this.mPlayerListeners.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
    this.mPlayerAdapter.reset();
    pushEvent(113, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(1)).build());
    this.mPlayProxyManager.stopDownload();
    this.mProxyStatus = -1;
    this.proxyTrackUrls.clear();
    localObject = this.mAssetResourceLoader;
    if (localObject != null) {
      ((ITPAssetResourceLoader)localObject).reset();
    }
    localObject = this.mTransformCallbackHandler;
    if (localObject != null) {
      ((TPPlayer.EventHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.mDownloadPlayableDurationMs = -1L;
    this.mCurrentDownloadSizeByte = -1L;
    this.mTotalFileSizeByte = -1L;
    this.mFlowId = null;
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void resumeDownload()
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("resumeDownload");
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    this.mPlayProxyManager.resumeDownload();
    localObject = new TPOptionalParam().buildLong(502, 1L);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam((TPOptionalParam)localObject);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void seekTo(int paramInt)
  {
    ReportThumbPlayer.getInstance().seekTo(this, paramInt);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("seekTo, positionMs:");
    localStringBuilder.append(paramInt);
    localTPBaseLogger.info(localStringBuilder.toString());
    this.mPlayerAdapter.seekTo(paramInt);
    this.mPlayProxyManager.setProxyPlayState(1);
    pushEvent(109, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("pstime", Long.valueOf(getCurrentPositionMs())).build());
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void seekTo(int paramInt1, int paramInt2)
  {
    ReportThumbPlayer.getInstance().seekTo(this, paramInt1);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("seekTo, positionMs:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", mode:");
    localStringBuilder.append(paramInt2);
    localTPBaseLogger.info(localStringBuilder.toString());
    if (paramInt2 > 0) {
      this.mPlayerAdapter.seekTo(paramInt1, paramInt2);
    } else {
      this.mPlayerAdapter.seekTo(paramInt1);
    }
    this.mPlayProxyManager.setProxyPlayState(1);
    pushEvent(109, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).put("format", Integer.valueOf(0)).put("pstime", Long.valueOf(getCurrentPositionMs())).build());
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void selectProgram(int paramInt, long paramLong)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("selectProgram, programIndex:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", opaque:");
    localStringBuilder.append(paramLong);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.selectProgram(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void selectTrack(int paramInt, long paramLong)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("selectTrack, trackIndex:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", opaque:");
    localStringBuilder.append(paramLong);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    try
    {
      localObject = this.mPlayerAdapter.getTrackInfo();
      if ((localObject != null) && (localObject.length > paramInt)) {
        pushEvent(122, 0, 0, null, new TPHashMapBuilder().put("opaque", Long.valueOf(paramLong)).put("tracktype", Integer.valueOf(localObject[paramInt].getTrackType())).put("name", localObject[paramInt].getName()).put("stime", Long.valueOf(System.currentTimeMillis())).build());
      }
      this.mPlayerAdapter.selectTrack(paramInt, paramLong);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setAudioGainRatio(float paramFloat)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setAudioGainRatio, gainRatio:");
    localStringBuilder.append(paramFloat);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setAudioGainRatio(paramFloat);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setAudioNormalizeVolumeParams(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.mLogger.printException(paramString);
    }
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mPlayProxyManager.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null)
    {
      if (this.mPlayerAdapter.getCurrentState() == 1)
      {
        TPBaseLogger localTPBaseLogger = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(LOG_API_CALL_PREFIX);
        localStringBuilder.append("setDataSource, ParcelFileDescriptor");
        localTPBaseLogger.info(localStringBuilder.toString());
        try
        {
          this.mPlayerAdapter.setDataSource(paramParcelFileDescriptor);
          return;
        }
        catch (SecurityException paramParcelFileDescriptor)
        {
          this.mLogger.printException(paramParcelFileDescriptor);
          return;
        }
        catch (IOException paramParcelFileDescriptor)
        {
          this.mLogger.printException(paramParcelFileDescriptor);
          return;
        }
      }
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    throw new IllegalArgumentException("error : setDataSource , param is null");
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    if (paramITPMediaAsset != null)
    {
      Object localObject;
      if ((paramITPMediaAsset instanceof ITPMediaDRMAsset)) {
        if (!TextUtils.isEmpty(paramITPMediaAsset.getUrl()))
        {
          localObject = (ITPMediaDRMAsset)paramITPMediaAsset;
          if ((((ITPMediaDRMAsset)localObject).getDrmAllProperties() != null) && (!((ITPMediaDRMAsset)localObject).getDrmAllProperties().isEmpty())) {}
        }
        else
        {
          throw new IllegalArgumentException("error : setDataSource , drm asset url is null or drm property is null");
        }
      }
      if (this.mPlayerAdapter.getCurrentState() == 1)
      {
        localObject = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(LOG_API_CALL_PREFIX);
        localStringBuilder.append("setDataSource, ITPMediaAsset");
        ((TPBaseLogger)localObject).info(localStringBuilder.toString());
        if (paramITPMediaAsset != null)
        {
          localObject = paramITPMediaAsset;
          try
          {
            if (isUseProxyEnable()) {
              localObject = this.mPlayProxyManager.startDownloadPlayByAsset(paramITPMediaAsset);
            }
            if (localObject != null)
            {
              paramITPMediaAsset = this.mLogger;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("handleSetDataSource mediaAsset=");
              localStringBuilder.append(((ITPMediaAsset)localObject).getUrl());
              paramITPMediaAsset.info(localStringBuilder.toString());
              this.mPlayerAdapter.setDataSource((ITPMediaAsset)localObject);
              return;
            }
          }
          catch (SecurityException paramITPMediaAsset)
          {
            this.mLogger.printException(paramITPMediaAsset);
            return;
          }
          catch (IOException paramITPMediaAsset)
          {
            this.mLogger.printException(paramITPMediaAsset);
          }
        }
        return;
      }
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    throw new IllegalArgumentException("error : setDataSource , param is null");
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mPlayerAdapter.getCurrentState() == 1)
      {
        Object localObject1 = this.mLogger;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(LOG_API_CALL_PREFIX);
        ((StringBuilder)localObject2).append("setDataSource, url:");
        ((StringBuilder)localObject2).append(paramString);
        ((TPBaseLogger)localObject1).info(((StringBuilder)localObject2).toString());
        if (!TextUtils.isEmpty(paramString))
        {
          this.mUrl = paramString;
          localObject1 = new TPUrlDataSource(paramString);
          localObject2 = this.mLogger;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleSetDataSource originalUrl=");
          localStringBuilder.append(paramString);
          ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
          try
          {
            if (isUseProxyEnable())
            {
              localObject1 = this.mPlayProxyManager.startDownloadPlay(paramString, null);
              paramString = this.mLogger;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleSetDataSource selfPlayerUrl=");
              ((StringBuilder)localObject2).append(((TPUrlDataSource)localObject1).getSelfPlayerUrl());
              paramString.info(((StringBuilder)localObject2).toString());
              paramString = this.mLogger;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleSetDataSource systemPlayerUrl=");
              ((StringBuilder)localObject2).append(((TPUrlDataSource)localObject1).getSystemPlayerUrl());
              paramString.info(((StringBuilder)localObject2).toString());
            }
            this.mPlayerAdapter.setDataSource((TPUrlDataSource)localObject1);
            return;
          }
          catch (Exception paramString)
          {
            this.mLogger.printException(paramString);
          }
        }
        return;
      }
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    throw new IllegalArgumentException("error : setDataSource , param is invalid");
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mPlayerAdapter.getCurrentState() == 1)
      {
        Object localObject1 = this.mLogger;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(LOG_API_CALL_PREFIX);
        ((StringBuilder)localObject2).append("setDataSource, url:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", httpHeader:");
        ((StringBuilder)localObject2).append(paramMap);
        ((TPBaseLogger)localObject1).info(((StringBuilder)localObject2).toString());
        if (!TextUtils.isEmpty(paramString))
        {
          this.mUrl = paramString;
          localObject1 = new TPUrlDataSource(paramString);
          localObject2 = this.mLogger;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleSetDataSource originalUrl=");
          localStringBuilder.append(paramString);
          ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
          try
          {
            if (isUseProxyEnable())
            {
              localObject1 = this.mPlayProxyManager.startDownloadPlay(paramString, paramMap);
              paramString = this.mLogger;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleSetDataSource selfPlayerUrl=");
              ((StringBuilder)localObject2).append(((TPUrlDataSource)localObject1).getSelfPlayerUrl());
              paramString.info(((StringBuilder)localObject2).toString());
              paramString = this.mLogger;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleSetDataSource systemPlayerUrl=");
              ((StringBuilder)localObject2).append(((TPUrlDataSource)localObject1).getSystemPlayerUrl());
              paramString.info(((StringBuilder)localObject2).toString());
            }
            this.mPlayerAdapter.setDataSource((TPUrlDataSource)localObject1, paramMap);
            return;
          }
          catch (Exception paramString)
          {
            this.mLogger.printException(paramString);
          }
        }
        return;
      }
      throw new IllegalStateException("error : setDataSource , state invalid");
    }
    throw new IllegalArgumentException("error : setDataSource , param is invalid");
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    this.mPlayProxyManager.setIsActive(paramBoolean);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void setLoopback(boolean paramBoolean)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setLoopback(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().setLoopback(this, paramBoolean, paramLong1, paramLong2);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setLoopback, isLoopback:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", loopStartPositionMs:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", loopEndPositionMs:");
    localStringBuilder.append(paramLong2);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setLoopback(paramBoolean, paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnAudioPcmOutputListener(paramIOnAudioFrameOutputListener);
    }
  }
  
  public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnAudioProcessOutputListener(paramIOnAudioProcessFrameOutputListener);
    }
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnCompletionListener(paramIOnCompletionListener);
    }
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnErrorListener(paramIOnErrorListener);
    }
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnInfoListener(paramIOnInfoListener);
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnPlayerStateChangeListener(paramIOnStateChangeListener);
    }
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnPreparedListener(paramIOnPreparedListener);
    }
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
    }
  }
  
  public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnStopAsyncCompleteListener(paramIOnStopAsyncCompleteListener);
    }
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
    }
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
    }
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
    }
  }
  
  public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnVideoProcessOutputListener(paramIOnVideoProcessFrameOutputListener);
    }
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    TPPlayerListeners localTPPlayerListeners = this.mPlayerListeners;
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setOutputMute(boolean paramBoolean)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setOutputMute, isOutputMute:");
    localStringBuilder.append(paramBoolean);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setOutputMute(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(removeRepeat=true)
  public void setPlaySpeedRatio(float paramFloat)
  {
    ReportThumbPlayer.getInstance().setPlaySpeedRatio(this, paramFloat);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setPlaySpeedRatio, speedRatio:");
    localStringBuilder.append(paramFloat);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setPlaySpeedRatio(paramFloat);
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
    pushEvent(116, 0, 0, null, new TPHashMapBuilder().put("scene", Float.valueOf(paramFloat)).build());
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    ReportThumbPlayer.getInstance().setPlayerOptionalParam(this, paramTPOptionalParam);
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 205))
    {
      this.mUseProxy = paramTPOptionalParam.getParamBoolean().value;
      paramTPOptionalParam = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayerOptionalParam, use p2p proxy, OPTION_ID_BEFORE_BOOLEAN_USE_PROXY=");
      localStringBuilder.append(this.mUseProxy);
      paramTPOptionalParam.info(localStringBuilder.toString());
      return;
    }
    this.mPlayProxyManager.setPlayerOptionalParam(paramTPOptionalParam);
    try
    {
      this.mPlayerAdapter.setPlayerOptionalParam(paramTPOptionalParam);
      return;
    }
    catch (Exception paramTPOptionalParam)
    {
      this.mLogger.printException(paramTPOptionalParam);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setRichMediaSynchronizer(@Nullable ITPRichMediaSynchronizer paramITPRichMediaSynchronizer)
  {
    this.mPlayerAdapter.setRichMediaSynchronizer(paramITPRichMediaSynchronizer);
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setSurface(Surface paramSurface)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setSurface, surface:");
    localStringBuilder.append(paramSurface);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setSurface(paramSurface);
      return;
    }
    catch (Exception paramSurface)
    {
      this.mLogger.printException(paramSurface);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setSurfaceHolder, SurfaceHolder:");
    localStringBuilder.append(paramSurfaceHolder);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      this.mPlayerAdapter.setSurfaceHolder(paramSurfaceHolder);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.mLogger.printException(paramSurfaceHolder);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void setTPSurface(ITPSurface paramITPSurface)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("setTPSurface, tpSurface:");
    localStringBuilder.append(paramITPSurface);
    localTPBaseLogger.info(localStringBuilder.toString());
    try
    {
      if ((paramITPSurface instanceof TPSurface))
      {
        this.mPlayerAdapter.setSurface(((TPSurface)paramITPSurface).getSurface());
        return;
      }
    }
    catch (Exception paramITPSurface)
    {
      this.mLogger.printException(paramITPSurface);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true)
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo != null) {
      try
      {
        this.mPlayProxyManager.setVideoInfo(paramTPVideoInfo);
        this.mPlayerAdapter.setVideoInfo(paramTPVideoInfo);
        if ((paramTPVideoInfo.getDownloadPraramList() != null) && (paramTPVideoInfo.getDownloadPraramList().size() > 0))
        {
          this.mFlowId = ((TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0)).getFlowId();
          return;
        }
      }
      catch (Exception paramTPVideoInfo)
      {
        this.mLogger.printException(paramTPVideoInfo);
      }
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void start()
  {
    ReportThumbPlayer.getInstance().start(this);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("start");
    localTPBaseLogger.info(localStringBuilder.toString());
    this.mPlayerAdapter.start();
    try
    {
      pushEvent(104, 0, 0, null, new TPHashMapBuilder().put("stime", Long.valueOf(System.currentTimeMillis())).build());
      this.mPlayProxyManager.setProxyPlayState(0);
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  @TPThreadAnnotations.ThreadSwitch(needWait=true)
  public void stop()
  {
    ReportThumbPlayer.getInstance().stop(this);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("stop");
    localTPBaseLogger.info(localStringBuilder.toString());
    internalStop();
  }
  
  @TPThreadAnnotations.ThreadSwitch
  public void stopAsync()
  {
    ReportThumbPlayer.getInstance().stop(this);
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("stopAsync");
    localTPBaseLogger.info(localStringBuilder.toString());
    internalStop();
    handlePlayerCallback(280, 0, 0, null);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("switchDefinition, mediaAsset:");
    localStringBuilder.append(paramITPMediaAsset);
    localStringBuilder.append(", defID:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", videoInfo:");
    localStringBuilder.append(paramTPVideoInfo);
    localTPBaseLogger.info(localStringBuilder.toString());
    switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, 0);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    if (validCallSwitchDef())
    {
      Object localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(LOG_API_CALL_PREFIX);
      localStringBuilder.append("switchDefinition, mediaAsset:");
      localStringBuilder.append(paramITPMediaAsset);
      localStringBuilder.append(", defID:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", videoInfo:");
      localStringBuilder.append(paramTPVideoInfo);
      localStringBuilder.append(", mode:");
      localStringBuilder.append(paramInt);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
      localObject = paramITPMediaAsset;
      if (isUseProxyEnable()) {
        localObject = this.mPlayProxyManager.startSwitchDefTaskByAsset(paramITPMediaAsset, paramLong, paramTPVideoInfo);
      }
      if (localObject != null)
      {
        paramITPMediaAsset = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleSwitchDef, proxyMediaAsset:");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", defID:");
        localStringBuilder.append(paramLong);
        paramITPMediaAsset.info(localStringBuilder.toString());
        this.mPlayerAdapter.updateVideoInfo(paramTPVideoInfo);
        this.mPlayerAdapter.switchDefinition((ITPMediaAsset)localObject, 0, paramLong);
        paramITPMediaAsset = new TPHashMapBuilder();
        paramTPVideoInfo = new StringBuilder();
        paramTPVideoInfo.append(paramLong);
        paramTPVideoInfo.append("");
        pushEvent(120, 0, 0, null, paramITPMediaAsset.put("switch", paramTPVideoInfo.toString()).build());
      }
      return;
    }
    throw new IllegalStateException("error : switchDefinition , state invalid");
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("switchDefinition, defUrl:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", defID:");
    localStringBuilder.append(paramLong);
    localTPBaseLogger.info(localStringBuilder.toString());
    switchDefinition(paramString, paramLong, paramTPVideoInfo, 0);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    if (validCallSwitchDef())
    {
      Object localObject1 = this.mLogger;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(LOG_API_CALL_PREFIX);
      ((StringBuilder)localObject2).append("switchDefinition, defUrl:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", defID:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(", mode:");
      ((StringBuilder)localObject2).append(paramInt);
      ((TPBaseLogger)localObject1).info(((StringBuilder)localObject2).toString());
      localObject1 = new TPUrlDataSource(paramString);
      if (isUseProxyEnable())
      {
        localObject1 = this.mPlayProxyManager.startSwitchDefTask(paramLong, paramString, paramTPVideoInfo, null);
        localObject2 = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchDefinition selfPlayerUrl=");
        localStringBuilder.append(((TPUrlDataSource)localObject1).getSelfPlayerUrl());
        ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
        localObject2 = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchDefinition systemPlayerUrl=");
        localStringBuilder.append(((TPUrlDataSource)localObject1).getSystemPlayerUrl());
        ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
      }
      localObject2 = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchDefinition, proxyUrl:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", defID:");
      localStringBuilder.append(paramLong);
      ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
      this.mPlayerAdapter.updateVideoInfo(paramTPVideoInfo);
      this.mPlayerAdapter.switchDefinition((TPUrlDataSource)localObject1, paramInt, paramLong);
      paramString = new TPHashMapBuilder();
      paramTPVideoInfo = new StringBuilder();
      paramTPVideoInfo.append(paramLong);
      paramTPVideoInfo.append("");
      pushEvent(120, 0, 0, null, paramString.put("switch", paramTPVideoInfo.toString()).build());
      return;
    }
    throw new IllegalStateException("error : switchDefinition , state invalid");
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_API_CALL_PREFIX);
    localStringBuilder.append("switchDefinition, defUrl:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", defID:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", videoInfo:");
    localStringBuilder.append(paramTPVideoInfo);
    localStringBuilder.append(", httpHeader:");
    localStringBuilder.append(paramMap);
    localTPBaseLogger.info(localStringBuilder.toString());
    switchDefinition(paramString, paramLong, paramTPVideoInfo, paramMap, 0);
  }
  
  @TPThreadAnnotations.ThreadSwitch(checkObj=true, removeRepeat=true)
  public void switchDefinition(@NonNull String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap, int paramInt)
  {
    if (validCallSwitchDef())
    {
      Object localObject1 = this.mLogger;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(LOG_API_CALL_PREFIX);
      ((StringBuilder)localObject2).append("switchDefinition, defUrl:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", defID:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(", httpHeader:");
      ((StringBuilder)localObject2).append(paramMap);
      ((StringBuilder)localObject2).append(", mode:");
      ((StringBuilder)localObject2).append(paramInt);
      ((TPBaseLogger)localObject1).info(((StringBuilder)localObject2).toString());
      localObject1 = new TPUrlDataSource(paramString);
      if (isUseProxyEnable())
      {
        localObject1 = this.mPlayProxyManager.startSwitchDefTask(paramLong, paramString, paramTPVideoInfo, paramMap);
        localObject2 = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchDefinition selfPlayerUrl=");
        localStringBuilder.append(((TPUrlDataSource)localObject1).getSelfPlayerUrl());
        ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
        localObject2 = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchDefinition systemPlayerUrl=");
        localStringBuilder.append(((TPUrlDataSource)localObject1).getSystemPlayerUrl());
        ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
      }
      localObject2 = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchDefinition, proxyUrl:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", defID:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", httpHeader:");
      localStringBuilder.append(paramMap);
      ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
      this.mPlayerAdapter.updateVideoInfo(paramTPVideoInfo);
      this.mPlayerAdapter.switchDefinition((TPUrlDataSource)localObject1, paramMap, paramInt, paramLong);
      paramString = new TPHashMapBuilder();
      paramTPVideoInfo = new StringBuilder();
      paramTPVideoInfo.append(paramLong);
      paramTPVideoInfo.append("");
      pushEvent(120, 0, 0, null, paramString.put("switch", paramTPVideoInfo.toString()).build());
      return;
    }
    throw new IllegalStateException("error : switchDefinition , state invalid");
  }
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    if (paramTPLoggerContext != null)
    {
      this.mUsingDefaultLogContext = false;
      this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, this.TAG));
      this.mPlayerAdapter.updateLoggerContext(this.mLogger.getTPLoggerContext());
      this.mPlayerListeners.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer
 * JD-Core Version:    0.7.0.1
 */