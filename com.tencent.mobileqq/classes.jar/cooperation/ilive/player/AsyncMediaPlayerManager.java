package cooperation.ilive.player;

import android.content.Context;
import android.util.Log;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnCompletionListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnErrorListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnInfoListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnPreparedListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnSeekCompleteListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnStopAsyncCompleteListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnSurfaceChangeListener;
import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnVideoFrameOutListener;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase.IVideoViewCallback;
import com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import java.util.Random;

public class AsyncMediaPlayerManager
  implements IMediaPlayerMgr, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener
{
  private String a;
  private Context b;
  private ITPPlayerVideoViewBase c;
  private IlivePlayerWrapper d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private IMediaPlayerMgr.OnPreparedListener i;
  private IMediaPlayerMgr.OnCompletionListener j;
  private IMediaPlayerMgr.OnErrorListener k;
  private IMediaPlayerMgr.OnInfoListener l;
  private IMediaPlayerMgr.OnSeekCompleteListener m;
  private IMediaPlayerMgr.OnVideoFrameOutListener n;
  private IMediaPlayerMgr.OnSurfaceChangeListener o;
  private IMediaPlayerMgr.OnStopAsyncCompleteListener p;
  private ITPPlayerVideoViewBase.IVideoViewCallback q = new AsyncMediaPlayerManager.1(this);
  
  public AsyncMediaPlayerManager(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncMediaPlayerManager is ready:");
      localStringBuilder.append(QQVideoPlaySDKManager.isSDKReady());
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TPPlayer[AsyncMediaPlayer");
    ((StringBuilder)localObject).append(new Random().nextInt());
    ((StringBuilder)localObject).append("]");
    this.a = ((StringBuilder)localObject).toString();
    this.b = paramContext.getApplicationContext();
    this.d = new IlivePlayerWrapper(this.b);
    a();
    TPLogUtil.i(this.a, "create tp player");
  }
  
  private void a()
  {
    this.d.a(new TPOptionalParam().buildLong(102, 3000L));
    this.d.a(new TPOptionalParam().buildLong(117, 60000L));
    this.d.a(new TPOptionalParam().buildLong(105, 1000L));
    this.d.a(new TPOptionalParam().buildLong(106, 10000L));
    this.d.a(new TPOptionalParam().buildLong(107, 15000L));
    this.d.a(new TPOptionalParam().buildLong(109, 10L));
    b();
  }
  
  private void a(IlivePlayerWrapper paramIlivePlayerWrapper)
  {
    TPCommonUtils.requireNotNull(paramIlivePlayerWrapper, "TPPlayer is null, create MediaPlayerMgr first");
  }
  
  private void b()
  {
    a(this.d);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
  }
  
  public void adVideoView(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase)
  {
    if ((paramITPPlayerVideoViewBase instanceof TPPlayerVideoView)) {
      this.c = paramITPPlayerVideoViewBase;
    }
    paramITPPlayerVideoViewBase = this.c;
    if (paramITPPlayerVideoViewBase != null) {
      paramITPPlayerVideoViewBase.addVideoViewCallback(this.q);
    }
  }
  
  public void continuePlay()
  {
    if (this.f)
    {
      this.f = false;
      try
      {
        this.d.d();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("continuePlay exception: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        TPLogUtil.e(str, localStringBuilder.toString());
        localIllegalStateException.printStackTrace();
      }
    }
  }
  
  public int getBufferPercent()
  {
    a(this.d);
    return this.d.l();
  }
  
  public long getCurrentPositionMs()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.d;
    if (localIlivePlayerWrapper == null) {
      return 0L;
    }
    return localIlivePlayerWrapper.k();
  }
  
  public long getDecodeFrameCount()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.d;
    if (localIlivePlayerWrapper == null) {
      return 0L;
    }
    return localIlivePlayerWrapper.b(208);
  }
  
  public long getDurationMs()
  {
    a(this.d);
    return this.d.h();
  }
  
  public long getRenderFrameCount()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.d;
    if (localIlivePlayerWrapper == null) {
      return 0L;
    }
    return localIlivePlayerWrapper.b(209);
  }
  
  public int getVideoHeight()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.d;
    if (localIlivePlayerWrapper == null) {
      return 0;
    }
    return localIlivePlayerWrapper.j();
  }
  
  public int getVideoWidth()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.d;
    if (localIlivePlayerWrapper == null) {
      return 0;
    }
    return localIlivePlayerWrapper.i();
  }
  
  public boolean isLoopBack()
  {
    if (this.d == null) {
      return false;
    }
    return this.h;
  }
  
  public boolean isPaused()
  {
    return this.f;
  }
  
  public boolean isPlaying()
  {
    return this.e;
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onCompletion(paramITPPlayer);
    TPLogUtil.i(this.a, "onCompletion : 播放完成");
    paramITPPlayer = this.j;
    if (paramITPPlayer != null) {
      paramITPPlayer.onCompletion(this);
    }
    this.g = true;
    this.e = false;
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().onError(paramITPPlayer, paramInt1, paramInt2);
    paramITPPlayer = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError : errorType = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("errorCode = ");
    localStringBuilder.append(paramInt2);
    TPLogUtil.e(paramITPPlayer, localStringBuilder.toString());
    paramITPPlayer = this.k;
    if (paramITPPlayer != null) {
      paramITPPlayer.onError(this, paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    if (this.l != null)
    {
      if (paramInt == 106) {}
      try
      {
        IliveLiteDataReport.a().d();
        this.l.onInfo(this, paramInt, paramLong1, paramLong2, paramObject);
        return;
      }
      catch (Exception paramITPPlayer)
      {
        paramITPPlayer.printStackTrace();
      }
    }
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onPrepared(paramITPPlayer);
    TPLogUtil.i(this.a, "onPrepared");
    paramITPPlayer = this.i;
    if (paramITPPlayer != null)
    {
      paramITPPlayer.onPrepared(this);
      this.f = false;
      return;
    }
    TPLogUtil.e(this.a, "OnPreparedListener is null, do something when player prepared");
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(this.a, "Seek completion");
    paramITPPlayer = this.m;
    if (paramITPPlayer != null) {
      paramITPPlayer.onSeekComplete(this);
    }
  }
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    paramITPPlayer = this.p;
    if (paramITPPlayer != null) {
      paramITPPlayer.a();
    }
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    IMediaPlayerMgr.OnVideoFrameOutListener localOnVideoFrameOutListener = this.n;
    if (localOnVideoFrameOutListener != null) {
      localOnVideoFrameOutListener.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
    }
  }
  
  public void openMediaPlayer(String paramString)
  {
    a(this.d);
    try
    {
      a();
      if (this.d.b())
      {
        TPLogUtil.e(this.a, "CachePlayer openMediaPlayer media has prepare ");
        startPlay();
        return;
      }
      this.d.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      TPLogUtil.e(this.a, Log.getStackTraceString(paramString));
    }
  }
  
  public void pausePlay()
  {
    a(this.d);
    try
    {
      this.d.m();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pausePlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.f = true;
  }
  
  public void release()
  {
    this.e = false;
    this.f = false;
    Object localObject = this.c;
    if (localObject != null) {
      ((ITPPlayerVideoViewBase)localObject).removeVideoViewCallback(this.q);
    }
    this.c = null;
    this.i = null;
    this.l = null;
    this.k = null;
    this.j = null;
    this.m = null;
    this.n = null;
    a(this.d);
    localObject = this.d;
    if (localObject != null) {
      ((IlivePlayerWrapper)localObject).g();
    }
  }
  
  public void reset()
  {
    a(this.d);
    try
    {
      this.d.f();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void seek(int paramInt)
  {
    a(this.d);
    try
    {
      this.d.a(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void seek(int paramInt1, int paramInt2)
  {
    a(this.d);
    try
    {
      this.d.a(paramInt1, paramInt2);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    a(this.d);
    this.d.a(paramFloat);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    a(this.d);
    this.h = paramBoolean;
    this.d.b(this.h);
  }
  
  public void setOnCompletionListener(IMediaPlayerMgr.OnCompletionListener paramOnCompletionListener)
  {
    this.j = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayerMgr.OnErrorListener paramOnErrorListener)
  {
    this.k = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayerMgr.OnInfoListener paramOnInfoListener)
  {
    this.l = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(IMediaPlayerMgr.OnPreparedListener paramOnPreparedListener)
  {
    this.i = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayerMgr.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.m = paramOnSeekCompleteListener;
  }
  
  public void setOnStopAsyncCompleteListener(IMediaPlayerMgr.OnStopAsyncCompleteListener paramOnStopAsyncCompleteListener)
  {
    this.p = paramOnStopAsyncCompleteListener;
  }
  
  public void setOnSurfaceChangeListener(IMediaPlayerMgr.OnSurfaceChangeListener paramOnSurfaceChangeListener)
  {
    this.o = paramOnSurfaceChangeListener;
  }
  
  public void setOnVideoFrameOutListener(IMediaPlayerMgr.OnVideoFrameOutListener paramOnVideoFrameOutListener)
  {
    this.n = paramOnVideoFrameOutListener;
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    a(this.d);
    this.d.a(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    a(this.d);
    this.d.b(paramFloat);
  }
  
  public void setPlayerSurface()
  {
    a(this.d);
    ITPPlayerVideoViewBase localITPPlayerVideoViewBase = this.c;
    if (localITPPlayerVideoViewBase != null) {
      this.d.a(localITPPlayerVideoViewBase.getViewSurface());
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((IlivePlayerWrapper)localObject).n();
      if (localObject != null) {
        ((ITPBusinessReportManager)localObject).setReportInfoGetter(paramTPDefaultReportInfo);
      }
    }
  }
  
  public void startPlay()
  {
    a(this.d);
    try
    {
      this.d.d();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.e = true;
    this.f = false;
  }
  
  public void stopAsyncPlay()
  {
    a(this.d);
    this.d.o();
    this.e = false;
  }
  
  public void stopPlay()
  {
    a(this.d);
    try
    {
      this.d.e();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.AsyncMediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */