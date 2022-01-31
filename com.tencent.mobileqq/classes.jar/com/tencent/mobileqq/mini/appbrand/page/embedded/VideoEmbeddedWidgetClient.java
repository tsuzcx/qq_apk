package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.fsm.StateMachine;
import com.tencent.mobileqq.mini.appbrand.fsm.StateMachine.OnStateChangeListener;
import com.tencent.mobileqq.mini.appbrand.fsm.StateMachine.State;
import com.tencent.mobileqq.mini.appbrand.fsm.StateMachine.StateTransfer;
import com.tencent.mobileqq.mini.appbrand.page.embedded.TextureRender.VideoTextureRenderer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class VideoEmbeddedWidgetClient
  extends StateMachine
  implements Handler.Callback, StateMachine.OnStateChangeListener, IEmbeddedWidgetClient
{
  private static final int DEFAULT_INTERVAL_TIME = 400;
  private static final int EVENT_INIT_SUCC = 1;
  private static final int EVENT_MEDIAPLAYER_PREPARED = 5;
  private static final int EVENT_VIDEOSURFACE_SUCC = 3;
  private static final int EVENT_X5SURFACE_SUCC = 2;
  public static final int MSG_IS_HLS = 1003;
  public static final int MSG_TIME_UPDATE = 1001;
  public static final int MSG_VIDEO_SURFACE_CREATED = 1002;
  private static final String TAG = "miniapp-embedded";
  public static volatile boolean mIsInited;
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private static final float[] rateSupportArray = { 0.5F, 0.8F, 1.0F, 1.25F, 1.5F, 2.0F };
  private boolean autoPauseIfNavigate = true;
  private boolean autoPauseIfOpenNative = true;
  private boolean autoplay;
  private JsRuntime callBackWebview;
  private String cueFilePath = "";
  private BaseAppBrandRuntime curAppBrandRuntime;
  private int curPageWebviewId;
  private String data = "";
  private String filePath = "";
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasCompleted;
  private boolean hasPlayClicked;
  private boolean hasPrepared;
  private boolean hasStoped;
  private int height = -1;
  private boolean hide;
  private int initialTime;
  private volatile Boolean isHls;
  private boolean isOnPageBackGrond;
  private boolean isPaused;
  private boolean loop;
  private Map<String, String> mAttributes;
  private IMediaPlayer mMediaPlayer;
  private Surface mSurface;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private Surface mediaPlaySurface;
  private boolean muted;
  private boolean needEvent = true;
  private String objectFit = "contain";
  private boolean pauseByNavigate;
  private boolean pauseByOpenNative;
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
  
  public VideoEmbeddedWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
    initStateConfig();
    initMediaPlayer();
    addStateChangeListener(this);
    sendEvent(Integer.valueOf(1));
  }
  
  private void initMediaPlayer()
  {
    if (!PlayerConfig.hasInit())
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (localBaseApplication == null) {
        throw new RuntimeException("BaseApplicationImpl ctx is null");
      }
      PlayerConfig.init(localBaseApplication);
      PlayerConfig.g().setLogger(new EmbeddedVideoLogger());
    }
    if (!VideoManager.hasInit()) {
      VideoManager.init(BaseApplicationImpl.getContext());
    }
    initOskOnce(BaseApplicationImpl.getContext());
    this.mMediaPlayer = new OskExoMediaPlayer();
    this.mMediaPlayer.setOnCompletionListener(new VideoEmbeddedWidgetClient.1(this));
    this.mMediaPlayer.setOnPreparedListener(new VideoEmbeddedWidgetClient.2(this));
    this.mMediaPlayer.setOnInfoListener(new VideoEmbeddedWidgetClient.3(this));
    this.mMediaPlayer.setOnBufferingUpdateListener(new VideoEmbeddedWidgetClient.4(this));
    this.mMediaPlayer.setOnVideoSizeChangedListener(new VideoEmbeddedWidgetClient.5(this));
    this.mMediaPlayer.setOnLoopStartListener(new VideoEmbeddedWidgetClient.6(this));
  }
  
  public static void initOskOnce(Context paramContext)
  {
    if (!mIsInited)
    {
      OskPlayerConfig localOskPlayerConfig = new OskPlayerConfig();
      localOskPlayerConfig.setEnableHLSCache(true);
      localOskPlayerConfig.setDebugVersion(true);
      localOskPlayerConfig.setLogger(new DefaultLogger());
      localOskPlayerConfig.setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), localOskPlayerConfig);
      paramContext = PlayerConfig.g().getContentTypeList();
      if (paramContext == null) {
        break label126;
      }
    }
    for (;;)
    {
      try
      {
        paramContext.addAll(Arrays.asList(oskPlayerContentTypeList.split("|")));
        PlayerConfig.g().setContentTypeList(paramContext);
        mIsInited = true;
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("miniapp-embedded", 1, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + paramContext);
        continue;
      }
      label126:
      QLog.e("miniapp-embedded", 1, "getContentTypeList null");
    }
  }
  
  private void initStateConfig()
  {
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInitial).next(this.stateInited).registEvent(Integer.valueOf(1)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateInited).next(this.stateX5SurfaceCreated).registEvent(Integer.valueOf(2)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateX5SurfaceCreated).next(this.stateVideoSurfaceCreated).registEvent(Integer.valueOf(3)));
    addStateTransfer(new StateMachine.StateTransfer(this).from(this.stateVideoSurfaceCreated).next(this.stateCanPlay).registEvent(Integer.valueOf(5)));
    setCurrState(this.stateInitial);
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
        break label118;
      }
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
    }
    for (;;)
    {
      this.mMediaPlayer.setLooping(this.loop);
      if (this.initialTime > 0)
      {
        QLog.d("miniapp-embedded", 1, "before seekTo " + this.initialTime);
        this.mMediaPlayer.seekTo(this.initialTime);
        QLog.d("miniapp-embedded", 1, "after seekTo " + this.initialTime);
      }
      return;
      label118:
      this.mMediaPlayer.setVolume(1.0F, 1.0F);
    }
  }
  
  public void handleInsertXWebVideo(JSONObject paramJSONObject, JsRuntime paramJsRuntime, BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.callBackWebview = paramJsRuntime;
    this.curAppBrandRuntime = paramBaseAppBrandRuntime;
    this.curPageWebviewId = paramJsRuntime.getPageWebViewId();
    if (paramJSONObject != null)
    {
      QLog.d("miniapp-embedded", 2, "handleInsertXWebVideo : " + paramJSONObject.toString());
      if (paramJSONObject.has("position"))
      {
        paramJsRuntime = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(this.callBackWebview.getContextEx()) * paramJsRuntime.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(this.callBackWebview.getContextEx());
        this.height = ((int)(paramJsRuntime.optInt("height", -1) * f + 0.5F));
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
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l2 = 0L;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.isHls != null) && (this.isHls.booleanValue()))
      {
        QLog.d("miniapp-embedded", 1, "hls, do not send onXWebVideoTimeUpdate.");
      }
      else
      {
        long l3 = System.currentTimeMillis();
        if ((this.mMediaPlayer != null) && (this.callBackWebview != null) && (!this.hasCompleted)) {}
        for (;;)
        {
          try
          {
            l1 = this.mMediaPlayer.getDuration();
            if (l1 <= 0L) {
              continue;
            }
            l1 /= 1000L;
            paramMessage = new JSONObject();
            paramMessage.put("data", this.data);
            paramMessage.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
            if ((this.isHls == null) || (!this.isHls.booleanValue())) {
              continue;
            }
            l1 = l2;
            paramMessage.put("duration", l1);
            paramMessage.put("videoPlayerId", this.viewId);
            ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS("onXWebVideoTimeUpdate", paramMessage.toString(), this.curPageWebviewId);
            this.callBackWebview.evaluateSubcribeJS("onXWebVideoTimeUpdate", paramMessage.toString(), this.curPageWebviewId);
          }
          catch (Throwable paramMessage)
          {
            long l1;
            QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_TIME_UPDATE error.", paramMessage);
            continue;
          }
          if (this.isPaused) {
            break;
          }
          sendTimingMsg(400L + l3 - System.currentTimeMillis());
          break;
          l1 = 0L;
        }
        if (this.renderer != null)
        {
          this.videoTexture = this.renderer.getVideoTexture();
          if (this.videoTexture != null) {
            sendEvent(Integer.valueOf(3));
          } else {
            QLog.e("miniapp-embedded", 1, "MSG_VIDEO_SURFACE_CREATED videoTexture is null!");
          }
        }
        else
        {
          QLog.e("miniapp-embedded", 1, "MSG_VIDEO_SURFACE_CREATED renderer is null!");
          continue;
          QLog.d("miniapp-embedded", 1, "MSG_IS_HLS");
          ThreadManager.getSubThreadHandler().post(new VideoEmbeddedWidgetClient.7(this));
        }
      }
    }
  }
  
  public void handleOperateXWebVideo(JSONObject paramJSONObject)
  {
    QLog.d("miniapp-embedded", 2, "handleOperateXWebVideo : " + paramJSONObject.toString());
    int i = paramJSONObject.optInt("viewId", -1);
    String str;
    if ((i == this.viewId) && (paramJSONObject.has("type")))
    {
      str = paramJSONObject.optString("type");
      if (!"play".equals(str)) {
        break label617;
      }
      this.isPaused = false;
      if (((this.hasCompleted) || (this.hasStoped)) && (this.mMediaPlayer != null))
      {
        this.mMediaPlayer.reset();
        this.hasPrepared = false;
        this.hasCompleted = false;
        this.hasStoped = false;
      }
    }
    try
    {
      if ((!this.filePath.startsWith("http")) && (!this.filePath.startsWith("https"))) {
        break label418;
      }
      paramJSONObject = OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(this.filePath));
      QLog.d("miniapp-embedded", 1, "handleOperateXWebVideo playUrl : " + paramJSONObject);
      this.mMediaPlayer.setDataSource(paramJSONObject);
      this.handler.sendEmptyMessage(1003);
      setCurrState(this.stateVideoSurfaceCreated);
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        QLog.e("miniapp-embedded", 1, "handleOperateXWebVideo  play error.", paramJSONObject);
        continue;
        QLog.e("miniapp-embedded", 1, "isOnPageBackGrond when mediaPlayerStart - 1");
      }
    }
    if (this.hasPrepared) {
      if (this.mMediaPlayer == null) {}
    }
    label418:
    label617:
    do
    {
      float f;
      for (;;)
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
            sendTimingMsg(400L);
          }
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("miniapp-embedded", 1, "start error.", paramJSONObject);
          continue;
        }
        try
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("data", this.data);
          paramJSONObject.put("videoPlayerId", i);
          paramJSONObject.put("timeStamp", System.currentTimeMillis());
          ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          this.callBackWebview.evaluateSubcribeJS("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoPlay = " + paramJSONObject.toString());
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_PLAY error.", paramJSONObject);
          return;
        }
        paramJSONObject = MiniAppFileManager.getInstance().getAbsolutePath(this.filePath);
        break;
        this.hasPlayClicked = true;
        try
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("data", this.data);
          paramJSONObject.put("videoPlayerId", i);
          paramJSONObject.put("timeStamp", System.currentTimeMillis());
          ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          this.callBackWebview.evaluateSubcribeJS("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoPlay = " + paramJSONObject.toString());
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_PLAY error.", paramJSONObject);
          return;
        }
        if ("pause".equals(str))
        {
          if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
          {
            this.isPaused = true;
            QLog.e("miniapp-embedded", 1, "pause isPaused true");
            for (;;)
            {
              try
              {
                if (this.renderer != null) {
                  this.renderer.pauseRender();
                }
                this.mMediaPlayer.pause();
              }
              catch (Throwable paramJSONObject)
              {
                QLog.e("miniapp-embedded", 1, "pause error.", paramJSONObject);
                continue;
              }
              try
              {
                paramJSONObject = new JSONObject();
                paramJSONObject.put("data", this.data);
                paramJSONObject.put("videoPlayerId", i);
                paramJSONObject.put("timeStamp", System.currentTimeMillis());
                ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS("onXWebVideoPause", paramJSONObject.toString(), this.curPageWebviewId);
                this.callBackWebview.evaluateSubcribeJS("onXWebVideoPause", paramJSONObject.toString(), this.curPageWebviewId);
                QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoPlay = " + paramJSONObject.toString());
                return;
              }
              catch (Throwable paramJSONObject)
              {
                QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_PAUSE error.", paramJSONObject);
                return;
              }
            }
          }
        }
        else if ("seek".equals(str))
        {
          if (this.mMediaPlayer != null) {
            try
            {
              paramJSONObject = paramJSONObject.optString("data");
              if (TextUtils.isEmpty(paramJSONObject)) {
                continue;
              }
              paramJSONObject = new JSONArray(paramJSONObject);
              if (paramJSONObject.length() != 1) {
                continue;
              }
              long l = (paramJSONObject.getDouble(0) * 1000.0D);
              this.mMediaPlayer.seekTo(l);
              return;
            }
            catch (Throwable paramJSONObject)
            {
              QLog.e("miniapp-embedded", 1, "seek error.", paramJSONObject);
              return;
            }
          }
        }
        else
        {
          if ((!"playbackRate".equals(str)) || (TextUtils.isEmpty(this.data))) {
            break label1045;
          }
          if (this.mMediaPlayer != null) {
            try
            {
              paramJSONObject = paramJSONObject.optString("data");
              if (!TextUtils.isEmpty(paramJSONObject))
              {
                paramJSONObject = new JSONArray(paramJSONObject);
                if (paramJSONObject.length() == 1)
                {
                  f = Float.parseFloat(paramJSONObject.optString(0, "1.0"));
                  if (Arrays.binarySearch(rateSupportArray, f) >= 0)
                  {
                    ((OskExoMediaPlayer)this.mMediaPlayer).setRate(f);
                    return;
                  }
                }
              }
            }
            catch (Throwable paramJSONObject)
            {
              QLog.e("miniapp-embedded", 1, "playbackRate error.", paramJSONObject);
              return;
            }
          }
        }
      }
      QLog.e("miniapp-embedded", 1, "playbackRate error." + f);
      return;
    } while ((!"stop".equals(str)) || (this.mMediaPlayer == null));
    label1045:
    this.isPaused = true;
    this.hasStoped = true;
    QLog.e("miniapp-embedded", 1, "pause isPaused true");
    if (this.renderer != null) {
      this.renderer.pauseRender();
    }
    this.mMediaPlayer.stop();
  }
  
  public void handleUpdateXWebVideo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QLog.d("miniapp-embedded", 2, "handleUpdateXWebVideo : " + paramJSONObject.toString());
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
          str = OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(this.filePath));
          QLog.d("miniapp-embedded", 1, "handleUpdateXWebVideo playUrl : " + str);
          this.mMediaPlayer.setDataSource(str);
          this.handler.sendEmptyMessage(1003);
          this.mMediaPlayer.prepareAsync();
        }
      }
      catch (Throwable localThrowable)
      {
        String str;
        float f;
        QLog.e("miniapp-embedded", 1, "handleUpdateXWebVideo  play error.", localThrowable);
        continue;
        QLog.e("miniapp-embedded", 1, "handleUpdateXWebVideo renderer is null!");
        continue;
        this.mMediaPlayer.setVolume(1.0F, 1.0F);
        continue;
      }
      if (paramJSONObject.has("position"))
      {
        paramJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(this.callBackWebview.getContextEx()) * paramJSONObject.optInt("width", -1) + 0.5F));
        f = DisplayUtil.getDensity(this.callBackWebview.getContextEx());
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
      str = MiniAppFileManager.getInstance().getAbsolutePath(this.filePath);
    }
  }
  
  public void nativeDestroy()
  {
    QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.nativeDestroy " + this);
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
    QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.nativePause " + this);
    if ((this.mMediaPlayer != null) && (this.autoPauseIfOpenNative)) {
      this.pauseByOpenNative = true;
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
      QLog.e("miniapp-embedded", 1, "nativePause mMediaPlayer.pause() error.", localThrowable);
    }
  }
  
  public void nativeResume()
  {
    QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.nativeResume " + this);
    if ((this.mMediaPlayer != null) && (this.pauseByOpenNative))
    {
      this.pauseByOpenNative = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
          return;
        }
        QLog.e("miniapp-embedded", 1, "isOnPageBackGrond when mediaPlayerStart - 3");
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-embedded", 1, "nativeResume mMediaPlayer.start() error.", localThrowable);
      }
    }
  }
  
  public void onActive()
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onDestroy");
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
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onStateChanged()
  {
    QLog.i("miniapp-embedded", 1, "onStateChanged : " + getCurrState() + "; videoTexture : " + this.videoTexture);
    if (this.isOnPageBackGrond) {
      break label49;
    }
    for (;;)
    {
      label49:
      return;
      if ((getCurrState() != this.stateCanPlay) || (this.videoTexture == null)) {
        continue;
      }
      QLog.d("miniapp-embedded", 1, "stateCanPlay!!!!");
      this.mediaPlaySurface = new Surface(this.videoTexture);
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
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
      if (((!this.autoplay) && (!this.hasPlayClicked)) || (this.mMediaPlayer == null)) {
        break;
      }
      try
      {
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
          updateMediaPlayer();
          if (this.callBackWebview == null) {
            continue;
          }
          if (!this.autoplay) {
            if (this.hasPlayClicked) {
              break label387;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("data", this.data);
            localJSONObject.put("videoPlayerId", this.viewId);
            localJSONObject.put("timeStamp", System.currentTimeMillis());
            ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
            this.callBackWebview.evaluateSubcribeJS("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
            QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoPlay = " + localJSONObject.toString());
            label387:
            if (this.mMediaPlayer == null) {
              break;
            }
            try
            {
              l1 = this.mMediaPlayer.getDuration();
              if (l1 <= 0L) {
                break label644;
              }
              l1 /= 1000L;
              localJSONObject = new JSONObject();
              localJSONObject.put("data", this.data);
              localJSONObject.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
              long l2 = l1;
              if (this.isHls != null)
              {
                l2 = l1;
                if (this.isHls.booleanValue()) {
                  l2 = 0L;
                }
              }
              localJSONObject.put("duration", l2);
              localJSONObject.put("videoPlayerId", this.viewId);
              ((AppBrandRuntime)this.curAppBrandRuntime).serviceRuntime.evaluateSubcribeJS("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
              this.callBackWebview.evaluateSubcribeJS("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
              QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoTimeUpdateo nStateChanged = " + localJSONObject.toString());
              return;
            }
            catch (Throwable localThrowable1)
            {
              QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_TIME_UPDATE error.", localThrowable1);
              return;
            }
            QLog.e("miniapp-embedded", 1, "isOnPageBackGrond when mediaPlayerStart - 4");
          }
          localThrowable2 = localThrowable2;
          QLog.e("miniapp-embedded", 1, "mMediaPlayer.start() error.", localThrowable2);
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_PLAY error.", localThrowable3);
            continue;
            label644:
            long l1 = 0L;
          }
        }
      }
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QLog.d("miniapp-embedded", 1, "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null) {}
      for (paramSurface = Boolean.valueOf(paramSurface.isValid());; paramSurface = null)
      {
        QLog.e("miniapp-embedded", 1, paramSurface);
        return;
      }
    }
    this.mSurface = paramSurface;
    this.renderer = new VideoTextureRenderer(BaseApplicationImpl.getContext(), this.mSurface, this.width, this.height, this.handler);
    sendEvent(Integer.valueOf(2));
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QLog.i("miniapp-embedded", 2, "VideoEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void webviewDestory()
  {
    QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.webviewDestory " + this);
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
  
  public void webviewPause()
  {
    QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.webviewPause " + this);
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
      QLog.e("miniapp-embedded", 1, "webviewPause mMediaPlayer.pause() error.", localThrowable);
    }
  }
  
  public void webviewResume()
  {
    QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.webviewResume " + this);
    this.isOnPageBackGrond = false;
    if ((this.mMediaPlayer != null) && (this.pauseByNavigate))
    {
      this.pauseByNavigate = false;
      try
      {
        if (this.renderer != null) {
          this.renderer.resumeRender();
        }
        QLog.i("miniapp-embedded", 1, "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
        if (!this.isOnPageBackGrond)
        {
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
          return;
        }
        QLog.e("miniapp-embedded", 1, "isOnPageBackGrond when mediaPlayerStart - 2");
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-embedded", 1, "webviewResume mMediaPlayer.start() error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */