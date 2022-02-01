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
  private boolean autoPauseIfNavigate;
  private boolean autoPauseIfOpenNative;
  private boolean autoplay;
  private IJsService callBackWebview;
  private String cueFilePath;
  private int curPageWebviewId;
  private String data;
  private String filePath;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasCompleted = false;
  private boolean hasPlayClicked = false;
  private boolean hasPrepared = false;
  private boolean hasStoped = false;
  private int height = -1;
  private boolean hide;
  private int initialTime;
  private volatile Boolean isHls;
  private boolean isOnPageBackGrond = false;
  private boolean isPaused = false;
  private boolean loop;
  private Map<String, String> mAttributes;
  private IMediaPlayer mMediaPlayer;
  private IMediaPlayerUtil mMediaPlayerUtil;
  private IMiniAppContext mMiniAppContext;
  private Surface mSurface = null;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private Surface mediaPlaySurface;
  private boolean muted;
  private boolean needEvent;
  private String objectFit;
  private boolean pauseByNavigate = false;
  private boolean pauseByOpenNative = false;
  private VideoTextureRenderer renderer;
  private StateMachine.State stateCanPlay;
  private StateMachine.State stateInited;
  private StateMachine.State stateInitial;
  private StateMachine.State stateVideoSurfaceCreated;
  private StateMachine.State stateX5SurfaceCreated;
  private int videoHeight = -1;
  private SurfaceTexture videoTexture;
  private int videoWidth = -1;
  private int viewId;
  private int width = -1;
  
  public VideoEmbeddedWidgetClient(IMiniAppContext paramIMiniAppContext, String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    Integer localInteger = Integer.valueOf(1);
    this.needEvent = true;
    this.hide = false;
    this.objectFit = "contain";
    this.autoplay = false;
    this.muted = false;
    this.loop = false;
    this.initialTime = 0;
    this.autoPauseIfNavigate = true;
    this.autoPauseIfOpenNative = true;
    this.filePath = "";
    this.cueFilePath = "";
    this.isHls = null;
    this.data = "";
    this.viewId = -1;
    this.stateInitial = new StateMachine.State(this, localInteger);
    this.stateInited = new StateMachine.State(this, Integer.valueOf(2));
    this.stateX5SurfaceCreated = new StateMachine.State(this, Integer.valueOf(3));
    this.stateVideoSurfaceCreated = new StateMachine.State(this, Integer.valueOf(4));
    this.stateCanPlay = new StateMachine.State(this, Integer.valueOf(5));
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
    this.mMiniAppContext = paramIMiniAppContext;
    initStateConfig();
    initMediaPlayer();
    addStateChangeListener(this);
    sendEvent(localInteger);
  }
  
  private void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = this.mMiniAppContext;
    if (localObject != null) {
      ((IMiniAppContext)localObject).performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, paramInt));
    }
    localObject = this.callBackWebview;
    if (localObject != null) {
      ((IJsService)localObject).evaluateSubscribeJS(paramString1, paramString2, this.curPageWebviewId);
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
    IMediaPlayer localIMediaPlayer = this.mMediaPlayer;
    if ((localIMediaPlayer != null) && (localIMediaPlayer.isPlaying()))
    {
      this.isPaused = true;
      QMLog.e("miniapp-embedded", "pause isPaused true");
      try
      {
        if (this.renderer != null) {
          this.renderer.pauseRender();
        }
        this.mMediaPlayer.pause();
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "pause error.", localThrowable);
      }
      sendPauseToJs(paramInt);
    }
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
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("playbackRate error.");
            paramJSONObject.append(f);
            QMLog.e("miniapp-embedded", paramJSONObject.toString());
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
    if ((this.hasCompleted) || (this.hasStoped))
    {
      Object localObject = this.mMediaPlayer;
      if (localObject != null)
      {
        ((IMediaPlayer)localObject).reset();
        this.hasPrepared = false;
        this.hasCompleted = false;
        this.hasStoped = false;
        try
        {
          if ((!this.filePath.startsWith("http")) && (!this.filePath.startsWith("https"))) {
            localObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
          } else {
            localObject = this.mMediaPlayerUtil.getUrl(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleOperateXWebVideo playUrl : ");
          localStringBuilder.append((String)localObject);
          QMLog.d("miniapp-embedded", localStringBuilder.toString());
          this.mMediaPlayer.setDataSource((String)localObject);
          this.handler.sendEmptyMessage(1003);
          setCurrState(this.stateVideoSurfaceCreated);
          this.mMediaPlayer.prepareAsync();
          this.mMediaPlayer.setSurface(this.mediaPlaySurface);
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("miniapp-embedded", "handleOperateXWebVideo  play error.", localThrowable1);
        }
      }
    }
    if (this.hasPrepared)
    {
      if (this.mMediaPlayer != null)
      {
        try
        {
          if (this.renderer != null) {
            this.renderer.resumeRender();
          }
          if (!this.isOnPageBackGrond)
          {
            this.isPaused = false;
            this.mMediaPlayer.start();
            sendTimingMsg(250L);
          }
          else
          {
            QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 1");
          }
        }
        catch (Throwable localThrowable2)
        {
          QMLog.e("miniapp-embedded", "start error.", localThrowable2);
        }
        sendPlayToJs(paramInt);
      }
    }
    else
    {
      this.hasPlayClicked = true;
      sendPlayToJs(paramInt);
    }
  }
  
  private void handleSeekEvent(JSONObject paramJSONObject)
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
            long l = (paramJSONObject.getDouble(0) * 1000.0D);
            this.mMediaPlayer.seekTo(l);
            return;
          }
        }
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("miniapp-embedded", "seek error.", paramJSONObject);
      }
    }
  }
  
  private void handleStopEvent()
  {
    if (this.mMediaPlayer != null)
    {
      this.isPaused = true;
      this.hasStoped = true;
      QMLog.e("miniapp-embedded", "pause isPaused true");
      VideoTextureRenderer localVideoTextureRenderer = this.renderer;
      if (localVideoTextureRenderer != null) {
        localVideoTextureRenderer.pauseRender();
      }
      this.mMediaPlayer.stop();
    }
  }
  
  private void handleSurfaceCreated()
  {
    VideoTextureRenderer localVideoTextureRenderer = this.renderer;
    if (localVideoTextureRenderer != null)
    {
      this.videoTexture = localVideoTextureRenderer.getVideoTexture();
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
    if ((this.isHls != null) && (this.isHls.booleanValue()))
    {
      QMLog.d("miniapp-embedded", "hls, do not send onXWebVideoTimeUpdate.");
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.mMediaPlayer != null) && (this.callBackWebview != null) && (!this.hasCompleted)) {
      sendTimeUpdateToJs();
    }
    if (!this.isPaused) {
      sendTimingMsg(l + 250L - System.currentTimeMillis());
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateSubcribeJS onXWebVideoEnded = ");
      localStringBuilder.append(localJSONObject.toString());
      QMLog.d("miniapp-embedded", localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_END  error.", localThrowable);
    }
  }
  
  private void sendLoadedMetaDataToJs()
  {
    for (;;)
    {
      try
      {
        l1 = this.mMediaPlayer.getDuration();
        if (l1 > 0L)
        {
          l1 /= 1000L;
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.data);
          localJSONObject.put("videoPlayerId", this.viewId);
          long l2 = l1;
          if (this.isHls != null)
          {
            l2 = l1;
            if (this.isHls.booleanValue()) {
              l2 = 0L;
            }
          }
          localJSONObject.put("duration", l2);
          localJSONObject.put("width", this.mMediaPlayer.getVideoWidth() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
          localJSONObject.put("height", this.mMediaPlayer.getVideoHeight() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
          evaluateSubscribeJS("onXWebVideoLoadedMetaData", localJSONObject.toString(), this.curPageWebviewId);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("evaluateSubcribeJS onXWebVideoLoadedMetaData = ");
          localStringBuilder.append(localJSONObject.toString());
          QMLog.d("miniapp-embedded", localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "VIDEO_EVENT_LOADED_METADATA error.", localThrowable);
        return;
      }
      long l1 = 0L;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateSubcribeJS onXWebVideoPause = ");
      localStringBuilder.append(localJSONObject.toString());
      QMLog.d("miniapp-embedded", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateSubcribeJS onXWebVideoPlay = ");
      localStringBuilder.append(localJSONObject.toString());
      QMLog.d("miniapp-embedded", localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", localThrowable);
    }
  }
  
  private void sendTimeUpdateToJs()
  {
    for (;;)
    {
      try
      {
        l1 = this.mMediaPlayer.getDuration();
        if (l1 > 0L)
        {
          l1 /= 1000L;
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.data);
          long l2 = this.mMediaPlayer.getCurrentPosition();
          double d = l2;
          Double.isNaN(d);
          d /= 1000.0D;
          localJSONObject.put("position", d);
          l2 = l1;
          if (this.isHls != null)
          {
            l2 = l1;
            if (this.isHls.booleanValue()) {
              l2 = 0L;
            }
          }
          localJSONObject.put("duration", l2);
          localJSONObject.put("videoPlayerId", this.viewId);
          evaluateSubscribeJS("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE error.", localThrowable);
        return;
      }
      long l1 = 0L;
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
    Object localObject = this.mMediaPlayer;
    if (localObject != null)
    {
      if (this.muted) {
        ((IMediaPlayer)localObject).setVolume(0.0F, 0.0F);
      } else {
        ((IMediaPlayer)localObject).setVolume(1.0F, 1.0F);
      }
      this.mMediaPlayer.setLooping(this.loop);
      int i = this.initialTime;
      if (i > 0)
      {
        long l = i * 1000;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("before seekTo ");
        ((StringBuilder)localObject).append(l);
        QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
        this.mMediaPlayer.seekTo(l);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after seekTo ");
        ((StringBuilder)localObject).append(l);
        QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void updateRenderer()
  {
    VideoTextureRenderer localVideoTextureRenderer = this.renderer;
    if (localVideoTextureRenderer != null)
    {
      int i = this.width;
      int j;
      if (i >= 0)
      {
        j = this.height;
        if (j >= 0) {
          localVideoTextureRenderer.setSurfaceSize(i, j);
        }
      }
      i = this.videoWidth;
      if (i >= 0)
      {
        j = this.videoHeight;
        if (j >= 0) {
          this.renderer.setVideoSize(i, j, this.objectFit);
        }
      }
      localVideoTextureRenderer = this.renderer;
      if (localVideoTextureRenderer != null) {
        localVideoTextureRenderer.resumeRender();
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
    if ((paramIJsService instanceof BrandPageWebview))
    {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService).getWebViewId();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cant get webviewId from ");
      localStringBuilder.append(paramIJsService);
      QMLog.e("miniapp-embedded", localStringBuilder.toString());
    }
    if (paramJSONObject != null)
    {
      paramIJsService = new StringBuilder();
      paramIJsService.append("handleInsertXWebVideo : ");
      paramIJsService.append(paramJSONObject.toString());
      QMLog.d("miniapp-embedded", paramIJsService.toString());
      if (paramJSONObject.has("position"))
      {
        paramIJsService = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("width", -1) + 0.5F));
        this.height = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService.optInt("height", -1) + 0.5F));
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
    paramJSONObject = this.renderer;
    if (paramJSONObject != null) {
      paramJSONObject.setSurfaceSize(this.width, this.height);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1003: 
      handleIsHLS();
      break;
    case 1002: 
      handleSurfaceCreated();
      break;
    case 1001: 
      handleUpdate();
    }
    return false;
  }
  
  public void handleOperateXWebVideo(JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOperateXWebVideo : ");
    ((StringBuilder)localObject).append(paramJSONObject.toString());
    QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
    int i = paramJSONObject.optInt("viewId", -1);
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      localObject = paramJSONObject.optString("type");
      if ("play".equals(localObject))
      {
        handlePlayEvent(i);
        return;
      }
      if ("pause".equals(localObject))
      {
        handlePauseEvent(i);
        return;
      }
      if ("seek".equals(localObject))
      {
        handleSeekEvent(paramJSONObject);
        return;
      }
      if (("playbackRate".equals(localObject)) && (!TextUtils.isEmpty(this.data)))
      {
        handlePlayBackRateEvent(paramJSONObject);
        return;
      }
      if ("stop".equals(localObject)) {
        handleStopEvent();
      }
    }
  }
  
  public void handleUpdateXWebVideo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUpdateXWebVideo : ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
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
              localObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
            } else {
              localObject = this.mMediaPlayerUtil.getUrl(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleUpdateXWebVideo playUrl : ");
            localStringBuilder.append((String)localObject);
            QMLog.d("miniapp-embedded", localStringBuilder.toString());
            this.mMediaPlayer.setDataSource((String)localObject);
            this.handler.sendEmptyMessage(1003);
            this.mMediaPlayer.prepareAsync();
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("miniapp-embedded", "handleUpdateXWebVideo  play error.", localThrowable);
        }
        if (paramJSONObject.has("position"))
        {
          paramJSONObject = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("width", -1) + 0.5F));
          this.height = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("height", -1) + 0.5F));
          paramJSONObject = this.renderer;
          if (paramJSONObject != null)
          {
            paramJSONObject.setSurfaceSize(this.width, this.height);
            this.renderer.setVideoSize(this.videoWidth, this.videoHeight, this.objectFit);
          }
          else
          {
            QMLog.e("miniapp-embedded", "handleUpdateXWebVideo renderer is null!");
          }
        }
        paramJSONObject = this.mMediaPlayer;
        if (paramJSONObject != null)
        {
          if (this.muted) {
            paramJSONObject.setVolume(0.0F, 0.0F);
          } else {
            paramJSONObject.setVolume(1.0F, 1.0F);
          }
          this.mMediaPlayer.setLooping(this.loop);
        }
      }
    }
  }
  
  public void nativeDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.nativeDestroy ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoEmbeddedWidgetClient.nativePause ");
    ((StringBuilder)localObject).append(this);
    QMLog.i("miniapp-embedded", ((StringBuilder)localObject).toString());
    this.isOnPageBackGrond = true;
    localObject = this.mMediaPlayer;
    if ((localObject != null) && (((IMediaPlayer)localObject).isPlaying()) && (!this.isPaused) && (this.autoPauseIfOpenNative))
    {
      this.pauseByOpenNative = true;
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
  }
  
  public void nativeResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.nativeResume ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByOpenNative))
    {
      this.pauseByOpenNative = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoEmbeddedWidgetClient.webviewResume isPaused ");
        localStringBuilder.append(this.isPaused);
        QMLog.i("miniapp-embedded", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.onRectChanged, rect:");
    localStringBuilder.append(paramRect.toString());
    localStringBuilder.append("； size : ");
    localStringBuilder.append(paramRect.right - paramRect.left);
    localStringBuilder.append(",");
    localStringBuilder.append(paramRect.bottom - paramRect.top);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
  }
  
  public void onRequestRedraw()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onStateChanged()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStateChanged : ");
    localStringBuilder.append(getCurrState());
    localStringBuilder.append("; videoTexture : ");
    localStringBuilder.append(this.videoTexture);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
    if (this.isOnPageBackGrond) {
      return;
    }
    if ((getCurrState() == this.stateCanPlay) && (this.videoTexture != null) && (this.mMediaPlayer != null))
    {
      QMLog.d("miniapp-embedded", "stateCanPlay!!!!");
      this.mediaPlaySurface = new Surface(this.videoTexture);
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
      updateRenderer();
      if ((this.autoplay) || (this.hasPlayClicked))
      {
        try
        {
          if (!this.isOnPageBackGrond)
          {
            this.isPaused = false;
            this.mMediaPlayer.start();
            sendTimingMsg(250L);
            updateMediaPlayer();
          }
          else
          {
            QMLog.e("miniapp-embedded", "isOnPageBackGrond when mediaPlayerStart - 4");
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("miniapp-embedded", "mMediaPlayer.start() error.", localThrowable);
        }
        if (this.callBackWebview != null)
        {
          if ((this.autoplay) || (!this.hasPlayClicked)) {
            sendPlayToJs(this.viewId);
          }
          if (this.mMediaPlayer != null) {
            sendTimeUpdateToJs();
          }
        }
      }
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated: ");
    localStringBuilder.append(paramSurface);
    QMLog.d("miniapp-embedded", localStringBuilder.toString());
    if ((paramSurface != null) && (paramSurface.isValid()))
    {
      this.mSurface = paramSurface;
      this.renderer = new VideoTextureRenderer(AppLoaderFactory.g().getContext(), this.mSurface, this.width, this.height, this.handler);
      sendEvent(Integer.valueOf(2));
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated isValid() : ");
    if (paramSurface != null) {
      paramSurface = Boolean.valueOf(paramSurface.isValid());
    } else {
      paramSurface = null;
    }
    localStringBuilder.append(paramSurface);
    QMLog.e("miniapp-embedded", localStringBuilder.toString());
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.onSurfaceDestroyed");
    onDestroy();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.onTouchEvent, rect:");
    localStringBuilder.append(paramMotionEvent.toString());
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.onVisibilityChanged ： ");
    localStringBuilder.append(paramBoolean);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
  }
  
  public void webViewDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.webViewDestroy ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoEmbeddedWidgetClient.webviewPause ");
    ((StringBuilder)localObject).append(this);
    QMLog.i("miniapp-embedded", ((StringBuilder)localObject).toString());
    this.isOnPageBackGrond = true;
    localObject = this.mMediaPlayer;
    if ((localObject != null) && (((IMediaPlayer)localObject).isPlaying()) && (this.autoPauseIfNavigate))
    {
      this.pauseByNavigate = true;
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
  }
  
  public void webViewResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEmbeddedWidgetClient.webviewResume ");
    localStringBuilder.append(this);
    QMLog.i("miniapp-embedded", localStringBuilder.toString());
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByNavigate))
    {
      this.pauseByNavigate = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoEmbeddedWidgetClient.webviewResume isPaused ");
        localStringBuilder.append(this.isPaused);
        QMLog.i("miniapp-embedded", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */