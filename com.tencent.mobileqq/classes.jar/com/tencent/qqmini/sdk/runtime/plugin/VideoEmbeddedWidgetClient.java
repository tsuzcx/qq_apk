package com.tencent.qqmini.sdk.runtime.plugin;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import bghn;
import bgjm;
import bhax;
import bhay;
import bhaz;
import bhba;
import bhbi;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.util.TextureRender.VideoTextureRenderer;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoEmbeddedWidgetClient
  extends bhax
  implements Handler.Callback, bhay, IEmbeddedWidgetClient
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
  private static final float[] rateSupportArray = { 0.5F, 0.8F, 1.0F, 1.25F, 1.5F, 2.0F };
  private boolean autoPauseIfNavigate = true;
  private boolean autoPauseIfOpenNative = true;
  private boolean autoplay;
  private bghn callBackWebview;
  private String cueFilePath = "";
  private bghn curAppBrandRuntime;
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
  private boolean isPaused;
  private boolean loop;
  private Map<String, String> mAttributes;
  private IMediaPlayer mMediaPlayer;
  private IMediaPlayerUtil mMediaPlayerUtil;
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
  private bhaz stateCanPlay = new bhaz(this, Integer.valueOf(5));
  private bhaz stateInited = new bhaz(this, Integer.valueOf(2));
  private bhaz stateInitial = new bhaz(this, Integer.valueOf(1));
  private bhaz stateVideoSurfaceCreated = new bhaz(this, Integer.valueOf(4));
  private bhaz stateX5SurfaceCreated = new bhaz(this, Integer.valueOf(3));
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
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    this.mMediaPlayer = localChannelProxy.getMediaPlayer();
    this.mMediaPlayerUtil = localChannelProxy.getMediaPlayerUtil();
    this.mMediaPlayer.setOnCompletionListener(new VideoEmbeddedWidgetClient.1(this));
    this.mMediaPlayer.setOnPreparedListener(new VideoEmbeddedWidgetClient.2(this));
    this.mMediaPlayer.setOnInfoListener(new VideoEmbeddedWidgetClient.3(this));
    this.mMediaPlayer.setOnBufferingUpdateListener(new VideoEmbeddedWidgetClient.4(this));
    this.mMediaPlayer.setOnVideoSizeChangedListener(new VideoEmbeddedWidgetClient.5(this));
    this.mMediaPlayer.setOnLoopStartListener(new VideoEmbeddedWidgetClient.6(this));
  }
  
  private void initStateConfig()
  {
    addStateTransfer(new bhba(this).a(this.stateInitial).b(this.stateInited).a(Integer.valueOf(1)));
    addStateTransfer(new bhba(this).a(this.stateInited).b(this.stateX5SurfaceCreated).a(Integer.valueOf(2)));
    addStateTransfer(new bhba(this).a(this.stateX5SurfaceCreated).b(this.stateVideoSurfaceCreated).a(Integer.valueOf(3)));
    addStateTransfer(new bhba(this).a(this.stateVideoSurfaceCreated).b(this.stateCanPlay).a(Integer.valueOf(5)));
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
  
  public void handleInsertXWebVideo(JSONObject paramJSONObject, bghn parambghn1, bghn parambghn2)
  {
    this.callBackWebview = parambghn1;
    this.curAppBrandRuntime = parambghn2;
    if ((parambghn1 instanceof bhbi)) {
      this.curPageWebviewId = ((bhbi)parambghn1).a();
    }
    for (;;)
    {
      if (paramJSONObject != null)
      {
        QMLog.d("miniapp-embedded", "handleInsertXWebVideo : " + paramJSONObject.toString());
        if (paramJSONObject.has("position"))
        {
          parambghn1 = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * parambghn1.optInt("width", -1) + 0.5F));
          float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
          this.height = ((int)(parambghn1.optInt("height", -1) * f + 0.5F));
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
        this.renderer.a(this.width, this.height);
      }
      return;
      QMLog.e("miniapp-embedded", "cant get webviewId from " + parambghn1);
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
      if ((this.isHls != null) && (this.isHls.booleanValue()))
      {
        QMLog.d("miniapp-embedded", "hls, do not send onXWebVideoTimeUpdate.");
      }
      else
      {
        long l1 = System.currentTimeMillis();
        if ((this.mMediaPlayer != null) && (this.callBackWebview != null) && (!this.hasCompleted)) {}
        for (;;)
        {
          try
          {
            paramMessage = new JSONObject();
            paramMessage.put("data", this.data);
            paramMessage.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
            if ((this.isHls == null) || (!this.isHls.booleanValue())) {
              continue;
            }
            d = 0.0D;
            paramMessage.put("duration", d);
            paramMessage.put("videoPlayerId", this.viewId);
            this.curAppBrandRuntime.a("onXWebVideoTimeUpdate", paramMessage.toString(), this.curPageWebviewId);
            this.callBackWebview.a("onXWebVideoTimeUpdate", paramMessage.toString(), this.curPageWebviewId);
          }
          catch (Throwable paramMessage)
          {
            double d;
            long l2;
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE error.", paramMessage);
            continue;
          }
          if (this.isPaused) {
            break;
          }
          sendTimingMsg(400L + l1 - System.currentTimeMillis());
          break;
          l2 = this.mMediaPlayer.getDuration();
          d = l2 / 1000.0D;
        }
        if (this.renderer != null)
        {
          this.videoTexture = this.renderer.a();
          if (this.videoTexture != null) {
            sendEvent(Integer.valueOf(3));
          } else {
            QMLog.e("miniapp-embedded", "MSG_VIDEO_SURFACE_CREATED videoTexture is null!");
          }
        }
        else
        {
          QMLog.e("miniapp-embedded", "MSG_VIDEO_SURFACE_CREATED renderer is null!");
          continue;
          QMLog.d("miniapp-embedded", "MSG_IS_HLS");
          ThreadManager.a().post(new VideoEmbeddedWidgetClient.7(this));
        }
      }
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
        break label581;
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
        break label405;
      }
      paramJSONObject = this.mMediaPlayerUtil.getUrl(bgjm.a().a(this.filePath));
      QMLog.d("miniapp-embedded", "handleOperateXWebVideo playUrl : " + paramJSONObject);
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
        QMLog.e("miniapp-embedded", "handleOperateXWebVideo  play error.", paramJSONObject);
      }
    }
    if (this.hasPrepared) {
      if (this.mMediaPlayer == null) {}
    }
    label405:
    label581:
    label995:
    do
    {
      float f;
      for (;;)
      {
        try
        {
          if (this.renderer != null) {
            this.renderer.e();
          }
          this.isPaused = false;
          this.mMediaPlayer.start();
          sendTimingMsg(400L);
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("miniapp-embedded", "start error.", paramJSONObject);
          continue;
        }
        try
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("data", this.data);
          paramJSONObject.put("videoPlayerId", i);
          paramJSONObject.put("timeStamp", System.currentTimeMillis());
          this.curAppBrandRuntime.a("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          this.callBackWebview.a("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramJSONObject.toString());
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", paramJSONObject);
          return;
        }
        paramJSONObject = bgjm.a().a(this.filePath);
        break;
        this.hasPlayClicked = true;
        try
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("data", this.data);
          paramJSONObject.put("videoPlayerId", i);
          paramJSONObject.put("timeStamp", System.currentTimeMillis());
          this.curAppBrandRuntime.a("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          this.callBackWebview.a("onXWebVideoPlay", paramJSONObject.toString(), this.curPageWebviewId);
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramJSONObject.toString());
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", paramJSONObject);
          return;
        }
        if ("pause".equals(str))
        {
          if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
          {
            this.isPaused = true;
            QMLog.e("miniapp-embedded", "pause isPaused true");
            for (;;)
            {
              try
              {
                if (this.renderer != null) {
                  this.renderer.d();
                }
                this.mMediaPlayer.pause();
              }
              catch (Throwable paramJSONObject)
              {
                QMLog.e("miniapp-embedded", "pause error.", paramJSONObject);
                continue;
              }
              try
              {
                paramJSONObject = new JSONObject();
                paramJSONObject.put("data", this.data);
                paramJSONObject.put("videoPlayerId", i);
                paramJSONObject.put("timeStamp", System.currentTimeMillis());
                this.curAppBrandRuntime.a("onXWebVideoPause", paramJSONObject.toString(), this.curPageWebviewId);
                this.callBackWebview.a("onXWebVideoPause", paramJSONObject.toString(), this.curPageWebviewId);
                QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramJSONObject.toString());
                return;
              }
              catch (Throwable paramJSONObject)
              {
                QMLog.e("miniapp-embedded", "VIDEO_EVENT_PAUSE error.", paramJSONObject);
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
              QMLog.e("miniapp-embedded", "seek error.", paramJSONObject);
              return;
            }
          }
        }
        else
        {
          if ((!"playbackRate".equals(str)) || (TextUtils.isEmpty(this.data))) {
            break label995;
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
                    this.mMediaPlayer.setRate(f);
                    return;
                  }
                }
              }
            }
            catch (Throwable paramJSONObject)
            {
              QMLog.e("miniapp-embedded", "playbackRate error.", paramJSONObject);
              return;
            }
          }
        }
      }
      QMLog.e("miniapp-embedded", "playbackRate error." + f);
      return;
    } while ((!"stop".equals(str)) || (this.mMediaPlayer == null));
    this.isPaused = true;
    this.hasStoped = true;
    QMLog.e("miniapp-embedded", "pause isPaused true");
    if (this.renderer != null) {
      this.renderer.d();
    }
    this.mMediaPlayer.stop();
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
          str = this.mMediaPlayerUtil.getUrl(bgjm.a().a(this.filePath));
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
        this.renderer.a(this.width, this.height);
        this.renderer.a(this.videoWidth, this.videoHeight, this.objectFit);
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
      str = bgjm.a().a(this.filePath);
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
        this.renderer.d();
        this.renderer.c();
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
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()) && (this.autoPauseIfOpenNative)) {
      this.pauseByOpenNative = true;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.d();
      }
      this.mMediaPlayer.pause();
      this.isPaused = true;
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
    if ((this.mMediaPlayer != null) && (this.pauseByOpenNative)) {
      this.pauseByOpenNative = false;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.e();
      }
      QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
      this.isPaused = false;
      this.mMediaPlayer.start();
      sendTimingMsg(400L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "nativeResume mMediaPlayer.start() error.", localThrowable);
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
        this.renderer.d();
        this.renderer.c();
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
    if ((getCurrState() == this.stateCanPlay) && (this.videoTexture != null))
    {
      QMLog.d("miniapp-embedded", "stateCanPlay!!!!");
      this.mediaPlaySurface = new Surface(this.videoTexture);
      this.mMediaPlayer.setSurface(this.mediaPlaySurface);
      if (this.renderer != null)
      {
        if ((this.width >= 0) && (this.height >= 0)) {
          this.renderer.a(this.width, this.height);
        }
        if ((this.videoWidth >= 0) && (this.videoHeight >= 0)) {
          this.renderer.a(this.videoWidth, this.videoHeight, this.objectFit);
        }
        if (this.renderer != null) {
          this.renderer.e();
        }
      }
      if (((!this.autoplay) && (!this.hasPlayClicked)) || (this.mMediaPlayer == null)) {}
    }
    try
    {
      this.isPaused = false;
      this.mMediaPlayer.start();
      sendTimingMsg(400L);
      updateMediaPlayer();
      if (this.callBackWebview != null) {
        if (!this.autoplay) {
          if (this.hasPlayClicked) {
            break label363;
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        localJSONObject.put("videoPlayerId", this.viewId);
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        this.curAppBrandRuntime.a("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
        this.callBackWebview.a("onXWebVideoPlay", localJSONObject.toString(), this.curPageWebviewId);
        QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + localJSONObject.toString());
        label363:
        if (this.mMediaPlayer == null) {}
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.data);
          localJSONObject.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0D);
          if ((this.isHls != null) && (this.isHls.booleanValue())) {}
          long l;
          for (double d = 0.0D;; d = l / 1000.0D)
          {
            localJSONObject.put("duration", d);
            localJSONObject.put("videoPlayerId", this.viewId);
            this.curAppBrandRuntime.a("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
            this.callBackWebview.a("onXWebVideoTimeUpdate", localJSONObject.toString(), this.curPageWebviewId);
            QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoTimeUpdateo nStateChanged = " + localJSONObject.toString());
            return;
            localThrowable1 = localThrowable1;
            QMLog.e("miniapp-embedded", "mMediaPlayer.start() error.", localThrowable1);
            break;
            localThrowable2 = localThrowable2;
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", localThrowable2);
            break label363;
            l = this.mMediaPlayer.getDuration();
          }
          return;
        }
        catch (Throwable localThrowable3)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE error.", localThrowable3);
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
  
  public void webviewDestory()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewDestory " + this);
    this.isPaused = true;
    try
    {
      if (this.renderer != null)
      {
        this.renderer.d();
        this.renderer.c();
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
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewPause " + this);
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()) && (this.autoPauseIfNavigate)) {
      this.pauseByNavigate = true;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.d();
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
  
  public void webviewResume()
  {
    QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume " + this);
    if ((this.mMediaPlayer != null) && (this.pauseByNavigate)) {
      this.pauseByNavigate = false;
    }
    try
    {
      if (this.renderer != null) {
        this.renderer.e();
      }
      QMLog.i("miniapp-embedded", "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
      this.isPaused = false;
      this.mMediaPlayer.start();
      sendTimingMsg(400L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "webviewResume mMediaPlayer.start() error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */