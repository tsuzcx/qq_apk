package com.tencent.mobileqq.winkpublish.player.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.winkpublish.player.FSPlayer;
import com.tencent.mobileqq.winkpublish.player.FSPlayerCallback;
import com.tencent.mobileqq.winkpublish.player.FSVideoManager;
import com.tencent.mobileqq.winkpublish.player.timer.FSVideoTimerManager;
import com.tencent.mobileqq.winkpublish.player.timer.IFSVideoTimerListener;
import com.tencent.mobileqq.winkpublish.widget.PublishBaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

public abstract class PublishBaseVideoView
  extends PublishBaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, FSPlayerCallback, IFSVideoTimerListener
{
  private Handler a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected ImageView e;
  protected FSBaseVideoViewListenerSets f;
  private boolean g;
  private boolean h = false;
  private boolean i;
  private FSPlayer j;
  private volatile String k;
  private int l = 0;
  private PublishBaseVideoView.InitListener m;
  
  public PublishBaseVideoView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PublishBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PublishBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("BaseVideoView", 1, "generateUniqueKey():playUrl is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    this.k = localStringBuilder.toString();
  }
  
  private void a(boolean paramBoolean)
  {
    getMainHandler().post(new PublishBaseVideoView.3(this, paramBoolean));
  }
  
  private FSPlayer getQCirclePlayer()
  {
    return this.j;
  }
  
  private void r()
  {
    if (getProgressBar() != null) {
      getProgressBar().setOnSeekBarChangeListener(this);
    }
  }
  
  private void s()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[addVideoView] player not ready");
      return;
    }
    addView(getQCirclePlayer().j(), 0, new FrameLayout.LayoutParams(-1, -1));
    QLog.w("BaseVideoView", 1, "[addVideoView] player  ready");
  }
  
  private void setSeekBarDuration(SeekBar paramSeekBar)
  {
    QLog.d("BaseVideoView", 4, "setSeekBarDuration");
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = paramSeekBar.getProgress();
    localMessage.arg2 = ((int)getSuperPlayer().getDurationMs());
    localMessage.obj = Boolean.valueOf(false);
    if (q()) {
      a(paramSeekBar.getProgress());
    }
    getMainHandler().sendMessage(localMessage);
  }
  
  private void t()
  {
    View localView = getChildAt(0);
    if ((localView instanceof ISPlayerVideoView))
    {
      removeView(localView);
      QLog.d("BaseVideoView", 1, "remove is player");
    }
  }
  
  private void u()
  {
    FSVideoTimerManager.a().b(this);
  }
  
  public void a()
  {
    PublishBaseVideoView.InitListener localInitListener = this.m;
    if (localInitListener != null) {
      localInitListener.a();
    }
    s();
    if (!this.i) {
      k();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    b(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void a(long paramLong)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[seek] player not ready");
      return;
    }
    getQCirclePlayer().a(paramLong);
  }
  
  protected abstract void a(long paramLong1, long paramLong2);
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer == null) {
      return;
    }
    if (getProgressBar() != null)
    {
      r();
      getProgressBar().setMax((int)paramISuperPlayer.getDurationMs());
    }
    FSBaseVideoViewListenerSets localFSBaseVideoViewListenerSets = this.f;
    if (localFSBaseVideoViewListenerSets != null) {
      localFSBaseVideoViewListenerSets.a(paramISuperPlayer);
    }
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    b(paramSuperPlayerVideoInfo);
  }
  
  protected void afterInflateView(Context paramContext, int paramInt)
  {
    r();
  }
  
  public void b()
  {
    f();
  }
  
  protected abstract void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  protected abstract void b(long paramLong1, long paramLong2);
  
  public void b(ISuperPlayer paramISuperPlayer) {}
  
  protected void b(SuperPlayerVideoInfo paramSuperPlayerVideoInfo) {}
  
  public void c() {}
  
  public void d()
  {
    m();
  }
  
  protected void e()
  {
    ImageView localImageView = this.e;
    if (localImageView != null) {
      localImageView.setVisibility(0);
    }
  }
  
  protected void f()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.f;
    if (localObject != null) {
      ((FSBaseVideoViewListenerSets)localObject).a();
    }
  }
  
  public void g()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    getQCirclePlayer().q();
    getQCirclePlayer().a(p() ^ true);
    getQCirclePlayer().a(this, null);
  }
  
  public Handler getMainHandler()
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper(), this);
    }
    return this.a;
  }
  
  public boolean getOutPutMute()
  {
    if (getQCirclePlayer() == null) {
      return false;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[getOutPutMute] player not ready");
      return false;
    }
    return getQCirclePlayer().k();
  }
  
  public abstract SeekBar getProgressBar();
  
  public Object getReportData()
  {
    return getData();
  }
  
  public ISuperPlayer getSuperPlayer()
  {
    if (getQCirclePlayer() == null) {
      return null;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[getSuperPlayer] player not ready");
      return null;
    }
    return getQCirclePlayer().h();
  }
  
  public ImageView getVideoCover()
  {
    return this.e;
  }
  
  public long getVideoPlayId()
  {
    if (getQCirclePlayer() != null) {
      return getQCirclePlayer().o();
    }
    return -1L;
  }
  
  protected void h()
  {
    u();
    getMainHandler().removeCallbacksAndMessages(null);
    getMainHandler().post(new PublishBaseVideoView.1(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == -1001)
    {
      FSBaseVideoViewListenerSets localFSBaseVideoViewListenerSets = this.f;
      if (localFSBaseVideoViewListenerSets != null) {
        localFSBaseVideoViewListenerSets.a("", paramMessage.arg2, paramMessage.arg1);
      }
    }
    return false;
  }
  
  public void i()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[start] player not ready");
      return;
    }
    if (!getQCirclePlayer().m())
    {
      setInterrupt(false);
      getQCirclePlayer().a();
      this.b = false;
      l();
      n();
      a(true);
    }
  }
  
  public void j()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[pause] player not ready");
      return;
    }
    if (getQCirclePlayer().m())
    {
      getQCirclePlayer().b();
      this.b = true;
      b(getQCirclePlayer().i(), getQCirclePlayer().n());
      a(false);
    }
  }
  
  public void k()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[replay] player not ready");
      return;
    }
    getQCirclePlayer().d();
    this.b = false;
  }
  
  public void l()
  {
    u();
    FSVideoTimerManager.a().a(this);
  }
  
  @CallSuper
  protected void m()
  {
    Object localObject = getSuperPlayer();
    if (localObject == null) {
      return;
    }
    double d2 = ((ISuperPlayer)localObject).getCurrentPositionMs();
    float f1 = (float)((ISuperPlayer)localObject).getDurationMs();
    int n = 0;
    if ((f1 == 0.0F) && (getProgressBar() != null)) {
      getProgressBar().setProgress(0);
    }
    if ((!this.d) && (d2 != 0.0D))
    {
      if (getQCirclePlayer().l()) {
        return;
      }
      localObject = Message.obtain();
      ((Message)localObject).what = -1001;
      ((Message)localObject).arg1 = ((int)d2);
      ((Message)localObject).arg2 = ((int)f1);
      ((Message)localObject).obj = Boolean.valueOf(true);
      getMainHandler().sendMessage((Message)localObject);
      if (getProgressBar() != null)
      {
        double d1 = getProgressBar().getMax();
        double d3 = f1;
        Double.isNaN(d2);
        Double.isNaN(d3);
        d2 /= d3;
        Double.isNaN(d1);
        n = (int)(d1 * d2);
      }
      if (this.l != n)
      {
        getMainHandler().post(new PublishBaseVideoView.2(this, n));
        this.l = n;
      }
    }
  }
  
  protected abstract void n();
  
  public boolean o()
  {
    return this.c;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.i = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getHandler().removeCallbacksAndMessages(null);
    this.i = true;
    release();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.d)
    {
      setSeekBarDuration(paramSeekBar);
      FSBaseVideoViewListenerSets localFSBaseVideoViewListenerSets = this.f;
      if (localFSBaseVideoViewListenerSets != null) {
        localFSBaseVideoViewListenerSets.a(paramSeekBar, paramInt, paramBoolean);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    this.d = true;
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[onStartTrackingTouch] player not ready");
      return;
    }
    getQCirclePlayer().f();
    a(getQCirclePlayer().i(), getQCirclePlayer().n());
    FSBaseVideoViewListenerSets localFSBaseVideoViewListenerSets = this.f;
    if (localFSBaseVideoViewListenerSets != null) {
      localFSBaseVideoViewListenerSets.a(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (getQCirclePlayer() != null)
    {
      this.d = false;
      if (!getQCirclePlayer().g())
      {
        QLog.w("BaseVideoView", 1, "[onStopTrackingTouch] player not ready");
      }
      else
      {
        getQCirclePlayer().a(paramSeekBar.getProgress(), paramSeekBar.getMax());
        FSBaseVideoViewListenerSets localFSBaseVideoViewListenerSets = this.f;
        if (localFSBaseVideoViewListenerSets != null) {
          localFSBaseVideoViewListenerSets.b(paramSeekBar);
        }
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  protected boolean p()
  {
    QLog.w("BaseVideoView", 1, "biz has cancel perf report");
    return false;
  }
  
  protected boolean q()
  {
    return true;
  }
  
  public void release()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    FSVideoManager.a().b(this.k);
    t();
    u();
    this.b = false;
    if (getProgressBar() != null)
    {
      getProgressBar().setProgress(0);
      getProgressBar().setOnSeekBarChangeListener(null);
    }
    this.e = null;
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void setBaseVideoViewListenerSets(FSBaseVideoViewListenerSets paramFSBaseVideoViewListenerSets)
  {
    this.f = paramFSBaseVideoViewListenerSets;
  }
  
  public void setInitListener(PublishBaseVideoView.InitListener paramInitListener)
  {
    this.m = paramInitListener;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g()) {
      QLog.w("BaseVideoView", 1, "[setLoopBack] player not ready");
    }
    getQCirclePlayer().b(paramBoolean);
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().g())
    {
      QLog.w("BaseVideoView", 1, "[setOutPutMute] player not ready");
      return;
    }
    getQCirclePlayer().c(paramBoolean);
  }
  
  public void setVideoCover(ImageView paramImageView)
  {
    this.g = true;
    this.e = paramImageView;
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    a(paramString2);
    h();
    this.j = FSVideoManager.a().a(this.k);
    if (getQCirclePlayer() == null) {
      return;
    }
    g();
    getQCirclePlayer().a(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.PublishBaseVideoView
 * JD-Core Version:    0.7.0.1
 */