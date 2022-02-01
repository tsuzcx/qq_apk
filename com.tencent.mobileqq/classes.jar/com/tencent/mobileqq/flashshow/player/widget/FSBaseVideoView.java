package com.tencent.mobileqq.flashshow.player.widget;

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
import com.tencent.mobileqq.flashshow.player.FSPlayer;
import com.tencent.mobileqq.flashshow.player.FSPlayerCallback;
import com.tencent.mobileqq.flashshow.player.FSVideoManager;
import com.tencent.mobileqq.flashshow.player.FSVideoReporter;
import com.tencent.mobileqq.flashshow.player.timer.FSVideoTimerManager;
import com.tencent.mobileqq.flashshow.player.timer.IFSVideoTimerListener;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public abstract class FSBaseVideoView
  extends FSBaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, FSPlayerCallback, IFSVideoTimerListener
{
  protected boolean a;
  protected boolean b;
  protected boolean c;
  protected FSBaseVideoView.SeekInfo d;
  protected ImageView e;
  protected FSBaseVideoViewListenerSets f;
  private Handler g;
  private boolean h;
  private FSPlayer i;
  private volatile String j;
  private int k = 0;
  private FSBaseVideoView.InitListener l;
  
  public FSBaseVideoView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("FSBaseVideoView", 1, "generateUniqueKey():playUrl is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    this.j = localStringBuilder.toString();
  }
  
  private void a(boolean paramBoolean)
  {
    getMainHandler().post(new FSBaseVideoView.3(this, paramBoolean));
  }
  
  private FSPlayer getQCirclePlayer()
  {
    return this.i;
  }
  
  private void q()
  {
    if (getProgressBar() != null) {
      getProgressBar().setOnSeekBarChangeListener(this);
    }
  }
  
  private void r()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[addVideoView] player not ready");
      return;
    }
    s();
    addView(getQCirclePlayer().k(), 0, new FrameLayout.LayoutParams(-1, -1));
    QLog.w("FSBaseVideoView", 1, "[addVideoView] player  ready");
  }
  
  private void s()
  {
    View localView = getChildAt(0);
    if ((localView instanceof ISPlayerVideoView))
    {
      removeView(localView);
      QLog.d("FSBaseVideoView", 1, "remove is player");
    }
  }
  
  private void setSeekBarDuration(SeekBar paramSeekBar)
  {
    QLog.d("FSBaseVideoView", 4, "setSeekBarDuration");
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = paramSeekBar.getProgress();
    localMessage.arg2 = ((int)getSuperPlayer().getDurationMs());
    localMessage.obj = Boolean.valueOf(false);
    if (p()) {
      a(paramSeekBar.getProgress());
    }
    getMainHandler().sendMessage(localMessage);
  }
  
  private void t()
  {
    FSBaseVideoView.SeekInfo localSeekInfo = this.d;
    if (localSeekInfo != null)
    {
      a(localSeekInfo.a, this.d.b, this.d.c, this.d.d);
      this.d = null;
    }
  }
  
  private void u()
  {
    FSVideoTimerManager.a().b(this);
  }
  
  public void a()
  {
    FSBaseVideoView.InitListener localInitListener = this.l;
    if (localInitListener != null) {
      localInitListener.a();
    }
    r();
    if (!this.h) {
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
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[seek] player not ready");
      return;
    }
    getQCirclePlayer().a(paramLong);
  }
  
  protected abstract void a(long paramLong1, long paramLong2);
  
  protected abstract void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  protected void a(long paramLong, String paramString, Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    FSVideoReporter.a().a(paramLong, paramString, paramObject, paramList);
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer == null) {
      return;
    }
    if (getProgressBar() != null)
    {
      q();
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
    q();
  }
  
  public void b()
  {
    f();
  }
  
  protected abstract void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
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
    getQCirclePlayer().r();
    getQCirclePlayer().a(o() ^ true);
    getQCirclePlayer().a(this, null);
  }
  
  public Handler getMainHandler()
  {
    if (this.g == null) {
      this.g = new Handler(Looper.getMainLooper(), this);
    }
    return this.g;
  }
  
  public boolean getOutPutMute()
  {
    if (getQCirclePlayer() == null) {
      return false;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[getOutPutMute] player not ready");
      return false;
    }
    return getQCirclePlayer().l();
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
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[getSuperPlayer] player not ready");
      return null;
    }
    return getQCirclePlayer().i();
  }
  
  public ImageView getVideoCover()
  {
    return this.e;
  }
  
  public long getVideoPlayId()
  {
    if (getQCirclePlayer() != null) {
      return getQCirclePlayer().p();
    }
    return -1L;
  }
  
  protected void h()
  {
    u();
    getMainHandler().removeCallbacksAndMessages(null);
    getMainHandler().post(new FSBaseVideoView.1(this));
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
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[start] player not ready");
      return;
    }
    if (!getQCirclePlayer().n())
    {
      setInterrupt(false);
      getQCirclePlayer().a();
      this.a = false;
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
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[pause] player not ready");
      return;
    }
    if (getQCirclePlayer().n())
    {
      getQCirclePlayer().b();
      this.a = true;
      a(getQCirclePlayer().j(), getQCirclePlayer().o());
      a(false);
    }
  }
  
  public void k()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[replay] player not ready");
      return;
    }
    getQCirclePlayer().d();
    this.a = false;
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
    int m = 0;
    if ((f1 == 0.0F) && (getProgressBar() != null)) {
      getProgressBar().setProgress(0);
    }
    if ((!this.c) && (d2 != 0.0D))
    {
      if (getQCirclePlayer().m()) {
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
        m = (int)(d1 * d2);
      }
      if (this.k != m)
      {
        getMainHandler().post(new FSBaseVideoView.2(this, m));
        this.k = m;
      }
    }
  }
  
  protected abstract void n();
  
  protected boolean o()
  {
    QLog.w("FSBaseVideoView", 1, "biz has cancel perf report");
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.h = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getMainHandler().removeCallbacksAndMessages(null);
    this.h = true;
    release();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.c)
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
    this.c = true;
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[onStartTrackingTouch] player not ready");
      return;
    }
    this.d = new FSBaseVideoView.SeekInfo();
    this.d.c(getQCirclePlayer().j());
    this.d.d(getQCirclePlayer().o());
    this.d.a(paramSeekBar.getProgress());
    getQCirclePlayer().g();
    FSBaseVideoViewListenerSets localFSBaseVideoViewListenerSets = this.f;
    if (localFSBaseVideoViewListenerSets != null) {
      localFSBaseVideoViewListenerSets.a(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (getQCirclePlayer() != null)
    {
      this.c = false;
      if (!getQCirclePlayer().h())
      {
        QLog.w("FSBaseVideoView", 1, "[onStopTrackingTouch] player not ready");
      }
      else
      {
        Object localObject = this.d;
        if (localObject != null) {
          ((FSBaseVideoView.SeekInfo)localObject).b(paramSeekBar.getProgress());
        }
        t();
        getQCirclePlayer().a(paramSeekBar.getProgress(), paramSeekBar.getMax());
        localObject = this.f;
        if (localObject != null) {
          ((FSBaseVideoViewListenerSets)localObject).b(paramSeekBar);
        }
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  protected boolean p()
  {
    return true;
  }
  
  public void release()
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    FSVideoManager.a().b(this.j);
    s();
    u();
    this.a = false;
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
  
  public void setInitListener(FSBaseVideoView.InitListener paramInitListener)
  {
    this.l = paramInitListener;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h()) {
      QLog.w("FSBaseVideoView", 1, "[setLoopBack] player not ready");
    }
    getQCirclePlayer().b(paramBoolean);
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (getQCirclePlayer() == null) {
      return;
    }
    if (!getQCirclePlayer().h())
    {
      QLog.w("FSBaseVideoView", 1, "[setOutPutMute] player not ready");
      return;
    }
    getQCirclePlayer().c(paramBoolean);
  }
  
  public void setVideoCover(ImageView paramImageView)
  {
    this.e = paramImageView;
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    a(paramString2);
    h();
    this.i = FSVideoManager.a().a(this.j);
    if (getQCirclePlayer() == null) {
      return;
    }
    g();
    getQCirclePlayer().a(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSBaseVideoView
 * JD-Core Version:    0.7.0.1
 */