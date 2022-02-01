package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.State;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.StateTransfer;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.util.TextureRender.VideoTextureRenderer;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoEmbeddedWidgetClient
  extends StateMachine
  implements Handler.Callback, StateMachine.OnStateChangeListener, IExtendedEmbeddedWidgetClient
{
  private static final int DEFAULT_INTERVAL_TIME = 250;
  private static final int EVENT_INIT_SUCC = 1;
  private static final int EVENT_MEDIAPLAYER_PREPARED = 5;
  private static final int EVENT_VIDEOSURFACE_SUCC = 3;
  private static final int EVENT_X5SURFACE_SUCC = 2;
  public static final int MSG_IS_HLS = 1003;
  public static final int MSG_TIME_UPDATE = 1001;
  public static final int MSG_VIDEO_SURFACE_CREATED = 1002;
  private static final String TAG = "miniapp-embedded";
  private static final float[] rateSupportArray = { 0.5F, 0.8F, 1.0F, 1.25F, 1.5F, 2.0F };
  private boolean autoPauseIfNavigate = true;
  private boolean autoPauseIfOpenNative = true;
  private boolean autoplay = false;
  private IJsService callBackWebview;
  private String cueFilePath = "";
  private int curPageWebviewId;
  private String data = "";
  private String filePath = "";
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasCompleted = false;
  private boolean hasPlayClicked = false;
  private boolean hasPrepared = false;
  private boolean hasStoped = false;
  private int height = -1;
  private boolean hide = false;
  private int initialTime = 0;
  private volatile Boolean isHls = null;
  private boolean isOnPageBackGrond = false;
  private boolean isPaused = false;
  private boolean loop = false;
  private Map<String, String> mAttributes;
  private IMediaPlayer mMediaPlayer;
  private IMediaPlayerUtil mMediaPlayerUtil;
  private IMiniAppContext mMiniAppContext;
  private Surface mSurface = null;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private Surface mediaPlaySurface;
  private boolean muted = false;
  private boolean needEvent = true;
  private String objectFit = "contain";
  private boolean pauseByNavigate = false;
  private boolean pauseByOpenNative = false;
  private VideoTextureRenderer renderer;
  private StateMachine.State stateCanPlay = new StateMachine.State(this, Integer.valueOf(5));
  private StateMachine.State stateInited = new StateMachine.State(this, Integer.valueOf(2));
  private StateMachine.State stateInitial = new StateMachine.State(this, Integer.valueOf(1));
  private StateMachine.State stateVideoSurfaceCreated = new StateMachine.State(this, Integer.valueOf(4));
  private StateMachine.State stateX5SurfaceCreated = new StateMachine.State(this, Integer.valueOf(3));
  private int videoHeight = -1;
  private SurfaceTexture videoTexture;
  private int videoWidth = -1;
  private int viewId = -1;
  private int width = -1;
  
  public VideoEmbeddedWidgetClient(IMiniAppContext paramIMiniAppContext, String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
    this.mMiniAppContext = paramIMiniAppContext;
    initStateConfig();
    initMediaPlayer();
    addStateChangeListener(this);
    sendEvent(Integer.valueOf(1));
  }
  
  private void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    if (this.mMiniAppContext != null) {
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, paramInt));
    }
    if (this.callBackWebview != null) {
      this.callBackWebview.evaluateSubscribeJS(paramString1, paramString2, this.curPageWebviewId);
    }
  }
  
  private IMediaPlayer.OnBufferingUpdateListener getOnBufferingUpdateListener()
  {
    return new VideoEmbeddedWidgetClient.5(this);
  }
  
  private IMediaPlayer.OnCompletionListener getOnCompletionListener()
  {
    return new VideoEmbeddedWidgetClient.8(this);
  }
  
  private IMediaPlayer.OnInfoListener getOnInfoListener()
  {
    return new VideoEmbeddedWidgetClient.6(this);
  }
  
  private IMediaPlayer.OnPreparedListener getOnPreparedListener()
  {
    return new VideoEmbeddedWidgetClient.7(this);
  }
  
  private IMediaPlayer.OnVideoSizeChangedListener getOnVideoSizeChangedListener()
  {
    return new VideoEmbeddedWidgetClient.4(this);
  }
  
  private void handleIsHLS()
  {
    QMLog.d("miniapp-embedded", "MSG_IS_HLS");
    ThreadManager.getSubThreadHandler().post(new VideoEmbeddedWidgetClient.9(this));
  }
  
  private void handlePauseEvent(int paramInt)
  {
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
    {
      this.isPaused = true;
      QMLog.e("miniapp-embedded", "pause isPaused true");
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.pauseRender();
      }
      this.mMediaPlayer.pause();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("miniapp-embedded", "pause error.", localThrowable);
      }
    }
    sendPauseToJs(paramInt);
  }
  
  private void handlePlayBackRateEvent(JSONObject paramJSONObject)
  {
    if (this.mMediaPlayer != null) {
      try
      {
        paramJSONObject = paramJSONObject.optString("data");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONArray(paramJSONObject);
          if (paramJSONObject.length() == 1)
          {
            float f = Float.parseFloat(paramJSONObject.optString(0, "1.0"));
            if (Arrays.binarySearch(rateSupportArray, f) >= 0)
            {
              this.mMediaPlayer.setRate(f);
              return;
            }
            QMLog.e("miniapp-embedded", "playbackRate error." + f);
            return;
          }
        }
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("miniapp-embedded", "playbackRate error.", paramJSONObject);
      }
    }
  }
  
  private void handlePlayEvent(int paramInt)
  {
    this.isPaused = false;
    if (((this.hasCompleted) || (this.hasStoped)) && (this.mMediaPlayer != null))
    {
      this.mMediaPlayer.reset();
      this.hasPrepared = false;
      this.hasCompleted = false;
      this.hasStoped = false;
    }
    for (;;)
    {
      try
      {
        if ((!this.filePath.startsWith("http")) && (!this.filePath.startsWith("https"))) {
          continue;
        }
        str = this.mMediaPlayerUtil.getUrl(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
        QMLog.d("miniapp-embedded", "handleOperateXWebVideo playUrl : " + str);
        this.mMediaPlayer.setDataSource(str);
        this.handler.sendEmptyMessage(1003);
        setCurrState(this.stateVideoSurfaceCreated);
        this.mMediaPlayer.prepareAsync();
        this.mMediaPlayer.setSurface(this.mediaPlaySurface);
      }
      catch (Throwable localThrowable1)
      {
        String str;
        QMLog.e("miniapp-embedded", "handleOperateXWebVideo  play error.", localThrowable1);
        continue;
        QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 1");
        continue;
        this.hasPlayClicked = true;
        sendPlayToJs(paramInt);
      }
      if (!this.hasPrepared) {
        continue;
      }
      if (this.mMediaPlayer != null) {}
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        if (this.isOnPageBackGrond) {
          continue;
        }
        this.isPaused = false;
        this.mMediaPlayer.start();
        sendTimingMsg(250L);
      }
      catch (Throwable localThrowable2)
      {
        QMLog.e("miniapp-embedded", "start error.", localThrowable2);
        continue;
      }
      sendPlayToJs(paramInt);
      return;
      str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
    }
  }
  
  private void handleSeekEvent(JSONObject paramJSONObject)
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      paramJSONObject = paramJSONObject.optString("data");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = new JSONArray(paramJSONObject);
        if (paramJSONObject.length() == 1)
        {
          long l = (paramJSONObject.getDouble(0) * 1000.0D);
          this.mMediaPlayer.seekTo(l);
        }
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QMLog.e("miniapp-embedded", "seek error.", paramJSONObject);
    }
  }
  
  private void handleStopEvent()
  {
    if (this.mMediaPlayer != null)
    {
      this.isPaused = true;
      this.hasStoped = true;
      QMLog.e("miniapp-embedded", "pause isPaused true");
      if (this.renderer != null) {
        this.renderer.pauseRender();
      }
      this.mMediaPlayer.stop();
    }
  }
  
  private void handleSurfaceCreated()
  {
    if (this.renderer != null)
    {
      this.videoTexture = this.renderer.getVideoTexture();
      if (this.videoTexture != null)
      {
        sendEvent(Integer.valueOf(3));
        return;
      }
      QMLog.e("miniapp-embedded", "MSG_VIDEO_SURFACE_CREATED videoTexture is null!");
      return;
    }
    QMLog.e("miniapp-embedded", "MSG_VIDEO_SURFACE_CREATED renderer is null!");
  }
  
  private void handleUpdate()
  {
    if ((this.isHls != null) && (this.isHls.booleanValue())) {
      QMLog.d("miniapp-embedded", "hls, do not send onXWebVideoTimeUpdate.");
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      if ((this.mMediaPlayer != null) && (this.callBackWebview != null) && (!this.hasCompleted)) {
        sendTimeUpdateToJs();
      }
    } while (this.isPaused);
    sendTimingMsg(l + 250L - System.currentTimeMillis());
  }
  
  private void initMediaPlayer()
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    this.mMediaPlayer = localChannelProxy.getMediaPlayer();
    this.mMediaPlayerUtil = localChannelProxy.getMediaPlayerUtil();
    this.mMediaPlayer.setOnCompletionListener(getOnCompletionListener());
    this.mMediaPlayer.setOnPreparedListener(getOnPreparedListener());
    this.mMediaPlayer.setOnInfoListener(getOnInfoListener());
    this.mMediaPlayer.setOnBufferingUpdateListener(getOnBufferingUpdateListener());
    this.mMediaPlayer.setOnVideoSizeChangedListener(getOnVideoSizeChangedListener());
    this.mMediaPlayer.setOnLoopStartListener(new VideoEmbeddedWidgetClient.1(this));
    this.mMediaPlayer.setOnSeekCompleteListener(new VideoEmbeddedWidgetClient.2(this));
    this.mMediaPlayer.setOnErrorListener(new VideoEmbeddedWidgetClient.3(this));
  }
  
  private void initStateConfig()
  {
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInitial).next(this.stateInited).registEvent(Integer.valueOf(1)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInited).next(this.stateX5SurfaceCreated).registEvent(Integer.valueOf(2)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateX5SurfaceCreated).next(this.stateVideoSurfaceCreated).registEvent(Integer.valueOf(3)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateVideoSurfaceCreated).next(this.stateCanPlay).registEvent(Integer.valueOf(5)));
    setCurrState(this.stateInitial);
  }
  
  private void sendEndToJs()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoPlayerId", this.viewId);
      evaluateSubscribeJS("onXWebVideoEnded", localJSONObject.toString(), this.curPageWebviewId);
      QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoEnded = " + localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_END  error.", localThrowable);
    }
  }
  
  private void sendLoadedMetaDataToJs()
  {
    long l2 = 0L;
    try
    {
      long l1 = this.mMediaPlayer.getDuration();
      JSONObject localJSONObject;
      if (l1 > 0L)
      {
        l1 /= 1000L;
        localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        localJSONObject.put("videoPlayerId", this.viewId);
        if ((this.isHls == null) || (!this.isHls.booleanValue())) {
          break label199;
        }
        l1 = l2;
      }
      label199:
      for (;;)
      {
        localJSONObject.put("duration", l1);
        localJSONObject.put("width", this.mMediaPlayer.getVideoWidth() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
        localJSONObject.put("height", this.mMediaPlayer.getVideoHeight() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
        evaluateSubscribeJS("onXWebVideoLoadedMetaData", localJSONObject.toString(), this.curPageWebviewId);
        QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoLoadedMetaData = " + localJSONObject.toString());
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_LOADED_METADATA error.", localThrowable);
    }
  }
  
  private void sendPauseToJs(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoPlayerId", paramInt);
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      evaluateSubscribeJS("onXWebVideoPause", localJSONObject.toString(), this.curPageWebviewId);
      QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPause = " + localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_PAUSE error.", localThrowable);
    }
  }
  
  private void sendPlayToJs(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoPlayerId", paramInt);
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      evaluateSubscribeJS("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
      QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", localThrowable);
    }
  }
  
  private void sendTimeUpdateToJs()
  {
    long l2 = 0L;
    try
    {
      long l1 = this.mMediaPlayer.getDuration();
      JSONObject localJSONObject;
      if (l1 > 0L)
      {
        l1 /= 1000L;
        localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        localJSONObject.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
        if ((this.isHls == null) || (!this.isHls.booleanValue())) {
          break label133;
        }
        l1 = l2;
      }
      label133:
      for (;;)
      {
        localJSONObject.put("duration", l1);
        localJSONObject.put("videoPlayerId", this.viewId);
        evaluateSubscribeJS("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE error.", localThrowable);
    }
  }
  
  private void sendTimingMsg(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    this.handler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void updateMediaPlayer()
  {
    if (this.mMediaPlayer != null)
    {
      if (!this.muted) {
        break label116;
      }
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
    }
    for (;;)
    {
      this.mMediaPlayer.setLooping(this.loop);
      if (this.initialTime > 0)
      {
        QMLog.d("miniapp-embedded", "before seekTo " + this.initialTime);
        this.mMediaPlayer.seekTo(this.initialTime);
        QMLog.d("miniapp-embedded", "after seekTo " + this.initialTime);
      }
      return;
      label116:
      this.mMediaPlayer.setVolume(1.0F, 1.0F);
    }
  }
  
  private void updateRenderer()
  {
    if (this.renderer != null)
    {
      if ((this.width >= 0) && (this.height >= 0)) {
        this.renderer.setSurfaceSize(this.width, this.height);
      }
      if ((this.videoWidth >= 0) && (this.videoHeight >= 0)) {
        this.renderer.setVideoSize(this.videoWidth, this.videoHeight, this.objectFit);
      }
      if (this.renderer != null) {
        this.renderer.resumeRender();
      }
    }
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  public void handleInsertXWebVideo(JSONObject paramJSONObject, IJsService paramIJsService)
  {
    this.callBackWebview = paramIJsService;
    if ((paramIJsService instanceof BrandPageWebview)) {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService).getWebViewId();
    }
    for (;;)
    {
      if (paramJSONObject != null)
      {
        QMLog.d("miniapp-embedded", "handleInsertXWebVideo : " + paramJSONObject.toString());
        if (paramJSONObject.has("position"))
        {
          paramIJsService = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("width", -1) + 0.5F));
          float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
          this.height = ((int)(paramIJsService.optInt("height", -1) * f + 0.5F));
        }
        this.viewId = paramJSONObject.optInt("viewId", -1);
        this.needEvent = paramJSONObject.optBoolean("needEvent", true);
        this.hide = paramJSONObject.optBoolean("hide", false);
        this.objectFit = paramJSONObject.optString("objectFit", "contain");
        this.autoplay = paramJSONObject.optBoolean("autoplay", false);
        this.muted = paramJSONObject.optBoolean("muted", false);
        this.loop = paramJSONObject.optBoolean("loop", false);
        this.initialTime = paramJSONObject.optInt("initialTime", 0);
        this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", true);
        this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", true);
        this.data = paramJSONObject.optString("data");
      }
      if (this.renderer != null) {
        this.renderer.setSurfaceSize(this.width, this.height);
      }
      return;
      QMLog.e("miniapp-embedded", "cant get webviewId from " + paramIJsService);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      handleUpdate();
      continue;
      handleSurfaceCreated();
      continue;
      handleIsHLS();
    }
  }
  
  public void handleOperateXWebVideo(JSONObject paramJSONObject)
  {
    QMLog.d("miniapp-embedded", "handleOperateXWebVideo : " + paramJSONObject.toString());
    int i = paramJSONObject.optInt("viewId", -1);
    String str;
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      str = paramJSONObject.optString("type");
      if (!"play".equals(str)) {
        break label79;
      }
      handlePlayEvent(i);
    }
    label79:
    do
    {
      return;
      if ("pause".equals(str))
      {
        handlePauseEvent(i);
        return;
      }
      if ("seek".equals(str))
      {
        handleSeekEvent(paramJSONObject);
        return;
      }
      if (("playbackRate".equals(str)) && (!TextUtils.isEmpty(this.data)))
      {
        handlePlayBackRateEvent(paramJSONObject);
        return;
      }
    } while (!"stop".equals(str));
    handleStopEvent();
  }
  
  public void handleUpdateXWebVideo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QMLog.d("miniapp-embedded", "handleUpdateXWebVideo : " + paramJSONObject.toString());
      if (paramJSONObject.optInt("viewId", -1) == this.viewId)
      {
        this.needEvent = paramJSONObject.optBoolean("needEvent", this.needEvent);
        this.hide = paramJSONObject.optBoolean("hide", this.hide);
        this.objectFit = paramJSONObject.optString("objectFit", this.objectFit);
        this.autoplay = paramJSONObject.optBoolean("autoplay", this.autoplay);
        this.muted = paramJSONObject.optBoolean("muted", this.muted);
        this.loop = paramJSONObject.optBoolean("loop", this.loop);
        this.initialTime = paramJSONObject.optInt("initialTime", this.initialTime);
        this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
        this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
        if (paramJSONObject.has("filePath")) {
          this.filePath = paramJSONObject.optString("filePath");
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!this.cueFilePath.equals(this.filePath))
        {
          this.cueFilePath = this.filePath;
          if (!TextUtils.isEmpty(this.cueFilePath)) {
            setCurrState(this.stateVideoSurfaceCreated);
          }
          this.isPaused = false;
          this.hasPrepared = false;
          this.hasCompleted = false;
          if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
          }
          this.mMediaPlayer.reset();
          if ((!this.filePath.startsWith("http")) && (!this.filePath.startsWith("https"))) {
            continue;
          }
          str = this.mMediaPlayerUtil.getUrl(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
          QMLog.d("miniapp-embedded", "handleUpdateXWebVideo playUrl : " + str);
          this.mMediaPlayer.setDataSource(str);
          this.handler.sendEmptyMessage(1003);
          this.mMediaPlayer.prepareAsync();
        }
      }
      catch (Throwable localThrowable)
      {
        String str;
        float f;
        QMLog.e("miniapp-embedded", "handleUpdateXWebVideo  play error.", localThrowable);
        continue;
        QMLog.e("miniapp-embedded", "handleUpdateXWebVideo renderer is null!");
        continue;
        this.mMediaPlayer.setVolume(1.0F, 1.0F);
        continue;
      }
      if (paramJSONObject.has("position"))
      {
        paramJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("width", -1) + 0.5F));
        f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
        this.height = ((int)(paramJSONObject.optInt("height", -1) * f + 0.5F));
        if (this.renderer == null) {
          continue;
        }
        this.renderer.setSurfaceSize(this.width, this.height);
        this.renderer.setVideoSize(this.videoWidth, this.videoHeight, this.objectFit);
      }
      if (this.mMediaPlayer != null)
      {
        if (!this.muted) {
          continue;
        }
        this.mMediaPlayer.setVolume(0.0F, 0.0F);
        this.mMediaPlayer.setLooping(this.loop);
      }
      return;
      str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
    }
  }
  
  public void nativeDestroy()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.nativeDestroy " + this);
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.pauseRender();
        this.renderer.onPause();
        this.renderer = null;
      }
      if (this.videoTexture != null)
      {
        this.videoTexture.release();
        this.videoTexture = null;
      }
      if (this.mediaPlaySurface != null)
      {
        this.mediaPlaySurface.release();
        this.mediaPlaySurface = null;
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      return;
    }
    finally {}
  }
  
  public void nativePause()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.nativePause " + this);
    this.isOnPageBackGrond = true;
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()) && (!this.isPaused) && (this.autoPauseIfOpenNative)) {
      this.pauseByOpenNative = true;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.pauseRender();
      }
      this.mMediaPlayer.pause();
      this.isPaused = true;
      sendPauseToJs(this.viewId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "nativePause mMediaPlayer.pause() error.", localThrowable);
    }
  }
  
  public void nativeResume()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.nativeResume " + this);
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByOpenNative))
    {
      this.pauseByOpenNative = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendPauseToJs(this.viewId);
          sendTimingMsg(250L);
          return;
        }
        QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 3");
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "nativeResume mMediaPlayer.start() error.", localThrowable);
      }
    }
  }
  
  public void onActive()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onDestroy");
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.pauseRender();
        this.renderer.onPause();
        this.renderer = null;
      }
      if (this.videoTexture != null)
      {
        this.videoTexture.release();
        this.videoTexture = null;
      }
      if (this.mediaPlaySurface != null)
      {
        this.mediaPlaySurface.release();
        this.mediaPlaySurface = null;
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      return;
    }
    finally {}
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onStateChanged()
  {
    QMLog.i("miniapp-embedded", "onStateChanged : " + getCurrState() + "; videoTexture : " + this.videoTexture);
    if (this.isOnPageBackGrond) {
      break label48;
    }
    for (;;)
    {
      label48:
      return;
      if ((getCurrState() != this.stateCanPlay) || (this.videoTexture == null) || (this.mMediaPlayer == null)) {
        continue;
      }
      QMLog.d("miniapp-embedded", "stateCanPlay!!!!");
      this.mediaPlaySurface = new Surface(this.videoTexture);
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
      updateRenderer();
      if ((!this.autoplay) && (!this.hasPlayClicked)) {
        break;
      }
      try
      {
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(250L);
          updateMediaPlayer();
        }
        while (this.callBackWebview != null)
        {
          if ((this.autoplay) || (!this.hasPlayClicked)) {
            sendPlayToJs(this.viewId);
          }
          if (this.mMediaPlayer == null) {
            break;
          }
          sendTimeUpdateToJs();
          return;
          QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 4");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("miniapp-embedded", "mMediaPlayer.start() error.", localThrowable);
        }
      }
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded", "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null) {}
      for (paramSurface = Boolean.valueOf(paramSurface.isValid());; paramSurface = null)
      {
        QMLog.e("miniapp-embedded", paramSurface);
        return;
      }
    }
    this.mSurface = paramSurface;
    this.renderer = new VideoTextureRenderer(AppLoaderFactory.g().getContext(), this.mSurface, this.width, this.height, this.handler);
    sendEvent(Integer.valueOf(2));
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onSurfaceDestroyed");
    onDestroy();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void webViewDestroy()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webViewDestroy " + this);
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.pauseRender();
        this.renderer.onPause();
        this.renderer = null;
      }
      if (this.videoTexture != null)
      {
        this.videoTexture.release();
        this.videoTexture = null;
      }
      if (this.mediaPlaySurface != null)
      {
        this.mediaPlaySurface.release();
        this.mediaPlaySurface = null;
      }
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
      }
      return;
    }
    finally {}
  }
  
  public void webViewPause()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewPause " + this);
    this.isOnPageBackGrond = true;
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()) && (this.autoPauseIfNavigate)) {
      this.pauseByNavigate = true;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.pauseRender();
      }
      this.mMediaPlayer.pause();
      this.isPaused = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "webviewPause mMediaPlayer.pause() error.", localThrowable);
    }
  }
  
  public void webViewResume()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume " + this);
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByNavigate))
    {
      this.pauseByNavigate = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(250L);
          return;
        }
        QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 2");
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "webviewResume mMediaPlayer.start() error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */