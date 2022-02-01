package com.tencent.mobileqq.qqlive.player;

import android.content.Context;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoViewCallback;
import com.tencent.mobileqq.qqlive.view.TPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.util.Random;

public class AsyncMediaPlayerManager
  implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener
{
  private final String a;
  private final Context b;
  private TPPlayerVideoView c;
  private final IlivePlayerWrapper d;
  private boolean e;
  private boolean f;
  private PlayerStatusChangeListener g;
  private final ITPPlayerVideoView.IVideoViewCallback h = new AsyncMediaPlayerManager.1(this);
  
  public AsyncMediaPlayerManager(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPPlayer[AsyncMediaPlayer");
    localStringBuilder.append(new Random().nextInt());
    localStringBuilder.append("]");
    this.a = localStringBuilder.toString();
    this.b = paramContext.getApplicationContext();
    this.d = new IlivePlayerWrapper(this.b);
    g();
    if (QLog.isColorLevel()) {
      QLog.i(this.a, 1, "create tp player");
    }
  }
  
  private void g()
  {
    this.d.a(new TPOptionalParam().buildLong(102, 3000L));
    this.d.a(new TPOptionalParam().buildLong(117, 60000L));
    this.d.a(new TPOptionalParam().buildLong(105, 1000L));
    this.d.a(new TPOptionalParam().buildLong(106, 10000L));
    this.d.a(new TPOptionalParam().buildLong(107, 15000L));
    this.d.a(new TPOptionalParam().buildLong(109, 10L));
    h();
  }
  
  private void h()
  {
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
  }
  
  public void a()
  {
    TPPlayerVideoView localTPPlayerVideoView = this.c;
    if (localTPPlayerVideoView != null) {
      this.d.a(localTPPlayerVideoView.getViewSurface());
    }
  }
  
  public void a(PlayerStatusChangeListener paramPlayerStatusChangeListener)
  {
    this.g = paramPlayerStatusChangeListener;
  }
  
  public void a(TPPlayerVideoView paramTPPlayerVideoView)
  {
    this.c = paramTPPlayerVideoView;
    if (this.c.a()) {
      a();
    }
    paramTPPlayerVideoView = this.c;
    if (paramTPPlayerVideoView != null) {
      paramTPPlayerVideoView.a(this.h);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      g();
      if (this.d.b())
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a, 1, "openMediaPlayer media has prepare");
        }
        b();
        return;
      }
      this.d.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play error ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void b()
  {
    try
    {
      this.d.c();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPlay error ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
    this.e = true;
    this.f = false;
  }
  
  public void c()
  {
    try
    {
      this.d.g();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pausePlay error ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
    this.f = true;
  }
  
  public void d()
  {
    try
    {
      this.d.e();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPlay error ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
    this.e = false;
  }
  
  public void e()
  {
    this.e = false;
    this.f = false;
    TPPlayerVideoView localTPPlayerVideoView = this.c;
    if (localTPPlayerVideoView != null) {
      localTPPlayerVideoView.b(this.h);
    }
    this.c = null;
    this.g = null;
    this.d.d();
  }
  
  public void f()
  {
    try
    {
      this.d.f();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset error ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onCompletion(paramITPPlayer);
    if (QLog.isColorLevel()) {
      QLog.i(this.a, 1, "onCompletion");
    }
    paramITPPlayer = this.g;
    if (paramITPPlayer != null) {
      paramITPPlayer.onComplete();
    }
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
    QLog.e(paramITPPlayer, 1, localStringBuilder.toString());
    paramITPPlayer = this.g;
    if (paramITPPlayer != null) {
      paramITPPlayer.onError(paramInt1);
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    if (paramInt != 106)
    {
      if (paramInt != 209)
      {
        if (paramInt != 200)
        {
          if (paramInt != 201)
          {
            if (paramInt != 5001)
            {
              if (paramInt != 5002) {
                return;
              }
              QLog.e(this.a, 1, "buffer time out");
              return;
            }
            QLog.e(this.a, 1, "prepare time out");
            return;
          }
          paramITPPlayer = this.g;
          if (paramITPPlayer != null) {
            paramITPPlayer.onBufferEnd();
          }
        }
        else
        {
          paramITPPlayer = this.g;
          if (paramITPPlayer != null) {
            paramITPPlayer.onStartBuffer();
          }
        }
      }
      else
      {
        paramITPPlayer = this.a;
        paramObject = new StringBuilder();
        paramObject.append("lost frame rate is ");
        paramObject.append(paramLong1 * 100L / paramLong2);
        QLog.e(paramITPPlayer, 1, paramObject.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "first frame render");
      }
      paramITPPlayer = this.g;
      if (paramITPPlayer != null) {
        paramITPPlayer.onFirstFrameRender();
      }
    }
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onPrepared(paramITPPlayer);
    if (QLog.isColorLevel()) {
      QLog.i(this.a, 1, "onPrepared");
    }
    paramITPPlayer = this.g;
    if (paramITPPlayer != null)
    {
      paramITPPlayer.onPrepared();
      this.f = false;
    }
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a, 1, "onSeekComplete");
    }
    paramITPPlayer = this.g;
    if (paramITPPlayer != null) {
      paramITPPlayer.onSeekComplete();
    }
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange pre: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" cur: ");
      localStringBuilder.append(paramInt2);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramInt2 != 5)
    {
      if (paramInt2 != 6) {
        return;
      }
      localObject = this.g;
      if (localObject != null) {
        ((PlayerStatusChangeListener)localObject).onPause();
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        ((PlayerStatusChangeListener)localObject).onStart();
      }
    }
  }
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a, 1, "onStopAsyncComplete");
    }
    paramITPPlayer = this.g;
    if (paramITPPlayer != null) {
      paramITPPlayer.onStop();
    }
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer) {}
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      paramITPPlayer = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoSizeChanged width is ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" h is ");
      localStringBuilder.append(paramLong2);
      QLog.i(paramITPPlayer, 1, localStringBuilder.toString());
    }
    paramITPPlayer = this.c;
    if (paramITPPlayer != null) {
      paramITPPlayer.setFixedSize((int)paramLong1, (int)paramLong2);
    }
    paramITPPlayer = this.g;
    if (paramITPPlayer != null) {
      paramITPPlayer.onVideoSizeChanged((int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.AsyncMediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */