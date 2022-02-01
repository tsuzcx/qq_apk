package com.tencent.mobileqq.qqlive.api.impl.room;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.player.AsyncMediaPlayerManager;
import com.tencent.mobileqq.qqlive.player.PlayerStatusChangeListener;
import com.tencent.mobileqq.qqlive.view.TPPlayerVideoView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class AudienceRoomPlayModule
{
  private static final int NOT_PREPARE = 0;
  public static final int PLAY_STATUS_COMPLETE = 3;
  public static final int PLAY_STATUS_PLAYING = 1;
  public static final int PLAY_STATUS_STOP = 2;
  private static final int PREPARED = 2;
  private static final int PREPARING = 1;
  private static final long RETRY_INTERVAL_TIME = 2000L;
  private static final String TAG = "AudienceRoomPlayModule";
  private int currentStatus = 0;
  private String currentUrl;
  private long intervalTime = 2000L;
  private boolean isDestroy = false;
  private boolean isPlaySoon = false;
  private boolean isSdkPreparing = false;
  private AsyncMediaPlayerManager player;
  final CopyOnWriteArrayList<AudienceRoomPlayerListener> playerListeners = new CopyOnWriteArrayList();
  private final PlayerStatusChangeListener playerStatusChangeListener = new AudienceRoomPlayModule.3(this);
  public TPPlayerVideoView playerView;
  private final List<Runnable> preOperate = new ArrayList();
  private int prepareStatus = 0;
  private final Runnable retryRunnable = new AudienceRoomPlayModule.1(this);
  private AudienceRoomPlayModule.PlayRetryStrategy retryStrategy = new ResumeRetryStrategy();
  
  public AudienceRoomPlayModule()
  {
    this(false);
  }
  
  public AudienceRoomPlayModule(boolean paramBoolean)
  {
    Context localContext = BaseApplication.getContext().getApplicationContext();
    this.playerView = new TPPlayerVideoView(localContext);
    this.retryStrategy.bindPlayModule(this);
    if (QQVideoPlaySDKManager.isSDKReady())
    {
      initPlayer(localContext, paramBoolean);
      return;
    }
    initVideoSdk(localContext, paramBoolean);
  }
  
  private void checkNeedReOpen(String paramString)
  {
    if ((!TextUtils.isEmpty(this.currentUrl)) && (!paramString.equals(this.currentUrl)))
    {
      paramString = this.player;
      if (paramString != null)
      {
        paramString.d();
        this.prepareStatus = 0;
      }
    }
  }
  
  private boolean checkSdkStatus(String paramString, boolean paramBoolean)
  {
    if (this.player != null) {
      return true;
    }
    if (this.isSdkPreparing)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play when sdk is preparing isPreload is ");
      localStringBuilder.append(paramBoolean);
      QLog.e("AudienceRoomPlayModule", 1, localStringBuilder.toString());
      this.preOperate.add(new AudienceRoomPlayModule.4(this, paramBoolean, paramString));
    }
    else
    {
      QLog.e("AudienceRoomPlayModule", 1, "play when but sdk init failed");
      paramString = this.playerListeners.iterator();
      while (paramString.hasNext()) {
        ((AudienceRoomPlayerListener)paramString.next()).onError(5104, "videoSDK init failed");
      }
    }
    return false;
  }
  
  private void executePreOperate()
  {
    if (this.preOperate.size() > 0)
    {
      Iterator localIterator = this.preOperate.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.preOperate.clear();
  }
  
  private void initPlayer(Context paramContext, boolean paramBoolean)
  {
    if (this.isDestroy) {
      return;
    }
    this.player = new AsyncMediaPlayerManager(paramContext);
    this.player.a(this.playerView);
    this.player.a(paramBoolean);
    this.player.a(this.playerStatusChangeListener);
  }
  
  private void initVideoSdk(Context paramContext, boolean paramBoolean)
  {
    QLog.e("AudienceRoomPlayModule", 1, "waite videoSdk init");
    this.isSdkPreparing = true;
    QQVideoPlaySDKManager.initSDKAsync(paramContext, new AudienceRoomPlayModule.2(this, paramContext, paramBoolean));
  }
  
  private void playWhenUrlIsNullOrEqCurUrl()
  {
    int i = this.prepareStatus;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.player.b();
        return;
      }
      this.isPlaySoon = true;
      return;
    }
    if (!TextUtils.isEmpty(this.currentUrl))
    {
      String str = this.currentUrl;
      this.currentUrl = "";
      startPlay(str);
    }
  }
  
  private void stopRetry()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.retryRunnable);
  }
  
  public void destroy()
  {
    this.isDestroy = true;
    stopRetry();
    this.preOperate.clear();
    this.playerListeners.clear();
    Object localObject = this.player;
    if (localObject != null)
    {
      ((AsyncMediaPlayerManager)localObject).e();
      this.player = null;
    }
    localObject = this.playerView;
    if (localObject != null)
    {
      ((TPPlayerVideoView)localObject).release();
      this.playerView = null;
    }
  }
  
  public int getCurrentStatus()
  {
    return this.currentStatus;
  }
  
  public String getPlayUrl()
  {
    return this.currentUrl;
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AudienceRoomPlayModule", 1, "pause play");
    }
    AsyncMediaPlayerManager localAsyncMediaPlayerManager = this.player;
    if (localAsyncMediaPlayerManager != null)
    {
      localAsyncMediaPlayerManager.c();
      return;
    }
    if (this.isSdkPreparing)
    {
      QLog.e("AudienceRoomPlayModule", 1, "pause when sdk is preparing");
      this.preOperate.clear();
    }
  }
  
  public void preloadUrl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cur: ");
      localStringBuilder.append(this.currentUrl);
      localStringBuilder.append(" status is ");
      localStringBuilder.append(this.prepareStatus);
      QLog.i("AudienceRoomPlayModule", 1, localStringBuilder.toString());
    }
    stopRetry();
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!checkSdkStatus(paramString, true)) {
      return;
    }
    checkNeedReOpen(paramString);
    if ((this.player != null) && (!paramString.equals(this.currentUrl)))
    {
      this.currentUrl = paramString;
      this.player.a(paramString);
    }
  }
  
  public void registerRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    if (!this.playerListeners.contains(paramAudienceRoomPlayerListener)) {
      this.playerListeners.add(paramAudienceRoomPlayerListener);
    }
  }
  
  public void reset()
  {
    if (this.isDestroy) {
      return;
    }
    this.playerListeners.clear();
    this.preOperate.clear();
    this.prepareStatus = 0;
    this.currentUrl = "";
    this.isPlaySoon = false;
    Object localObject = this.playerView;
    if (localObject != null)
    {
      localObject = ((TPPlayerVideoView)localObject).getCurrentDisplayView().getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.playerView.getCurrentDisplayView());
      }
    }
    resetPlayer();
  }
  
  public void resetPlayer()
  {
    AsyncMediaPlayerManager localAsyncMediaPlayerManager = this.player;
    if (localAsyncMediaPlayerManager != null)
    {
      localAsyncMediaPlayerManager.d();
      this.player.f();
    }
    stopRetry();
    this.retryStrategy.reset();
  }
  
  void retry()
  {
    stopRetry();
    ThreadManager.getUIHandler().postDelayed(this.retryRunnable, this.intervalTime);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AsyncMediaPlayerManager localAsyncMediaPlayerManager = this.player;
    if (localAsyncMediaPlayerManager != null) {
      localAsyncMediaPlayerManager.a(paramBoolean);
    }
  }
  
  public void setPlayUrl(String paramString)
  {
    this.currentUrl = paramString;
  }
  
  public void setRetryParams(long paramLong, int paramInt)
  {
    long l = paramLong;
    if (paramLong == -1L) {
      l = 2000L;
    }
    this.intervalTime = l;
    Object localObject;
    if (paramInt == -1)
    {
      localObject = new ResumeRetryStrategy();
    }
    else
    {
      localObject = new NormalRetryStrategy();
      ((NormalRetryStrategy)localObject).retryTime = paramInt;
    }
    ((AudienceRoomPlayModule.PlayRetryStrategy)localObject).bindPlayModule(this);
    this.retryStrategy = ((AudienceRoomPlayModule.PlayRetryStrategy)localObject);
  }
  
  public void setVideoSurface()
  {
    if (this.isDestroy) {
      return;
    }
    AsyncMediaPlayerManager localAsyncMediaPlayerManager = this.player;
    if (localAsyncMediaPlayerManager != null) {
      localAsyncMediaPlayerManager.a();
    }
  }
  
  public void startPlay(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cur: ");
      localStringBuilder.append(this.currentUrl);
      localStringBuilder.append(" status is ");
      localStringBuilder.append(this.prepareStatus);
      QLog.i("AudienceRoomPlayModule", 1, localStringBuilder.toString());
    }
    stopRetry();
    if (!checkSdkStatus(paramString, false)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.currentUrl)))
    {
      checkNeedReOpen(paramString);
      if (this.prepareStatus == 0)
      {
        this.isPlaySoon = true;
        this.currentUrl = paramString;
        this.player.a(paramString);
      }
      return;
    }
    playWhenUrlIsNullOrEqCurUrl();
  }
  
  public void unRegisterRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    this.playerListeners.remove(paramAudienceRoomPlayerListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule
 * JD-Core Version:    0.7.0.1
 */