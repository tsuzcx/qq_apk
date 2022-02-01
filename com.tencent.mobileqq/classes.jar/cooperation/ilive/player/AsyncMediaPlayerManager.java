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
import java.util.Random;

public class AsyncMediaPlayerManager
  implements IMediaPlayerMgr, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IMediaPlayerMgr.OnCompletionListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnCompletionListener;
  private IMediaPlayerMgr.OnErrorListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnErrorListener;
  private IMediaPlayerMgr.OnInfoListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnInfoListener;
  private IMediaPlayerMgr.OnPreparedListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnPreparedListener;
  private IMediaPlayerMgr.OnSeekCompleteListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnSeekCompleteListener;
  private IMediaPlayerMgr.OnStopAsyncCompleteListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnStopAsyncCompleteListener;
  private IMediaPlayerMgr.OnSurfaceChangeListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnSurfaceChangeListener;
  private IMediaPlayerMgr.OnVideoFrameOutListener jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnVideoFrameOutListener;
  private ITPPlayerVideoViewBase.IVideoViewCallback jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase$IVideoViewCallback = new AsyncMediaPlayerManager.1(this);
  private ITPPlayerVideoViewBase jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase;
  private IlivePlayerWrapper jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public AsyncMediaPlayerManager(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPPlayer[AsyncMediaPlayer");
    localStringBuilder.append(new Random().nextInt());
    localStringBuilder.append("]");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper = new IlivePlayerWrapper(this.jdField_a_of_type_AndroidContentContext);
    a();
    TPLogUtil.i(this.jdField_a_of_type_JavaLangString, "create tp player");
  }
  
  private void a()
  {
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(new TPOptionalParam().buildLong(102, 3000L));
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(new TPOptionalParam().buildLong(117, 60000L));
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(new TPOptionalParam().buildLong(105, 1000L));
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(new TPOptionalParam().buildLong(106, 10000L));
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(new TPOptionalParam().buildLong(107, 15000L));
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(new TPOptionalParam().buildLong(109, 10L));
    b();
  }
  
  private void a(IlivePlayerWrapper paramIlivePlayerWrapper)
  {
    TPCommonUtils.requireNotNull(paramIlivePlayerWrapper, "TPPlayer is null, create MediaPlayerMgr first");
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(this);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(this);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(this);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(this);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(this);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(this);
  }
  
  public void adVideoView(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase)
  {
    if ((paramITPPlayerVideoViewBase instanceof TPPlayerVideoView)) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase = paramITPPlayerVideoViewBase;
    }
    paramITPPlayerVideoViewBase = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase;
    if (paramITPPlayerVideoViewBase != null) {
      paramITPPlayerVideoViewBase.addVideoViewCallback(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase$IVideoViewCallback);
    }
  }
  
  public void continuePlay()
  {
    if (this.b)
    {
      this.b = false;
      try
      {
        this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.b();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        String str = this.jdField_a_of_type_JavaLangString;
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
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    return this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.c();
  }
  
  public long getCurrentPositionMs()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
    if (localIlivePlayerWrapper == null) {
      return 0L;
    }
    return localIlivePlayerWrapper.b();
  }
  
  public long getDecodeFrameCount()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
    if (localIlivePlayerWrapper == null) {
      return 0L;
    }
    return localIlivePlayerWrapper.a(208);
  }
  
  public long getDurationMs()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    return this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a();
  }
  
  public long getRenderFrameCount()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
    if (localIlivePlayerWrapper == null) {
      return 0L;
    }
    return localIlivePlayerWrapper.a(209);
  }
  
  public int getVideoHeight()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
    if (localIlivePlayerWrapper == null) {
      return 0;
    }
    return localIlivePlayerWrapper.b();
  }
  
  public int getVideoWidth()
  {
    IlivePlayerWrapper localIlivePlayerWrapper = this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
    if (localIlivePlayerWrapper == null) {
      return 0;
    }
    return localIlivePlayerWrapper.a();
  }
  
  public boolean isLoopBack()
  {
    if (this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper == null) {
      return false;
    }
    return this.d;
  }
  
  public boolean isPaused()
  {
    return this.b;
  }
  
  public boolean isPlaying()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onCompletion(paramITPPlayer);
    TPLogUtil.i(this.jdField_a_of_type_JavaLangString, "onCompletion : 播放完成");
    paramITPPlayer = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnCompletionListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.onCompletion(this);
    }
    this.c = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().onError(paramITPPlayer, paramInt1, paramInt2);
    paramITPPlayer = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError : errorType = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("errorCode = ");
    localStringBuilder.append(paramInt2);
    TPLogUtil.e(paramITPPlayer, localStringBuilder.toString());
    paramITPPlayer = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnErrorListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.onError(this, paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    paramITPPlayer = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnInfoListener;
    if (paramITPPlayer != null) {
      try
      {
        paramITPPlayer.onInfo(this, paramInt, paramLong1, paramLong2, paramObject);
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
    TPLogUtil.i(this.jdField_a_of_type_JavaLangString, "onPrepared");
    paramITPPlayer = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnPreparedListener;
    if (paramITPPlayer != null)
    {
      paramITPPlayer.onPrepared(this);
      this.b = false;
      return;
    }
    TPLogUtil.e(this.jdField_a_of_type_JavaLangString, "OnPreparedListener is null, do something when player prepared");
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(this.jdField_a_of_type_JavaLangString, "Seek completion");
    paramITPPlayer = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnSeekCompleteListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.onSeekComplete(this);
    }
  }
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    paramITPPlayer = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnStopAsyncCompleteListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.a();
    }
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    IMediaPlayerMgr.OnVideoFrameOutListener localOnVideoFrameOutListener = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnVideoFrameOutListener;
    if (localOnVideoFrameOutListener != null) {
      localOnVideoFrameOutListener.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
    }
  }
  
  public void openMediaPlayer(String paramString)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      a();
      if (this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.b())
      {
        TPLogUtil.e(this.jdField_a_of_type_JavaLangString, "CachePlayer openMediaPlayer media has prepare ");
        startPlay();
        return;
      }
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      TPLogUtil.e(this.jdField_a_of_type_JavaLangString, Log.getStackTraceString(paramString));
    }
  }
  
  public void pausePlay()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.f();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pausePlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.b = true;
  }
  
  public void release()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    ITPPlayerVideoViewBase localITPPlayerVideoViewBase = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase;
    if (localITPPlayerVideoViewBase != null) {
      localITPPlayerVideoViewBase.removeVideoViewCallback(this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase$IVideoViewCallback);
    }
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase = null;
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnPreparedListener = null;
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnInfoListener = null;
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnErrorListener = null;
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnCompletionListener = null;
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnSeekCompleteListener = null;
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnVideoFrameOutListener = null;
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.c();
  }
  
  public void reset()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.e();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void seek(int paramInt)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void seek(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(paramInt1, paramInt2);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(paramFloat);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.d = paramBoolean;
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.b(this.d);
  }
  
  public void setOnCompletionListener(IMediaPlayerMgr.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayerMgr.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayerMgr.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(IMediaPlayerMgr.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayerMgr.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnStopAsyncCompleteListener(IMediaPlayerMgr.OnStopAsyncCompleteListener paramOnStopAsyncCompleteListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnStopAsyncCompleteListener = paramOnStopAsyncCompleteListener;
  }
  
  public void setOnSurfaceChangeListener(IMediaPlayerMgr.OnSurfaceChangeListener paramOnSurfaceChangeListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnSurfaceChangeListener = paramOnSurfaceChangeListener;
  }
  
  public void setOnVideoFrameOutListener(IMediaPlayerMgr.OnVideoFrameOutListener paramOnVideoFrameOutListener)
  {
    this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerIMediaPlayerMgr$OnVideoFrameOutListener = paramOnVideoFrameOutListener;
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.b(paramFloat);
  }
  
  public void setPlayerSurface()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    ITPPlayerVideoViewBase localITPPlayerVideoViewBase = this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerRenderviewITPPlayerVideoViewBase;
    if (localITPPlayerVideoViewBase != null) {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.a(localITPPlayerVideoViewBase.getViewSurface());
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    Object localObject = this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
    if (localObject != null)
    {
      localObject = ((IlivePlayerWrapper)localObject).a();
      if (localObject != null) {
        ((ITPBusinessReportManager)localObject).setReportInfoGetter(paramTPDefaultReportInfo);
      }
    }
  }
  
  public void startPlay()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.b();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
  }
  
  public void stopAsyncPlay()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.g();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void stopPlay()
  {
    a(this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper);
    try
    {
      this.jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper.d();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.player.AsyncMediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */