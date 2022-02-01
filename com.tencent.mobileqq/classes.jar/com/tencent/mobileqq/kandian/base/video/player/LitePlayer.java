package com.tencent.mobileqq.kandian.base.video.player;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class LitePlayer
  implements OnVideoPluginInstallListener
{
  private static int f;
  private LitePlayer.UiHandler A;
  private String B;
  private boolean C;
  private boolean D;
  @NonNull
  protected Context a;
  @NonNull
  protected VideoPlayerWrapper b;
  @NonNull
  protected ViewGroup c;
  protected boolean d;
  private final String e;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private float r;
  private int s;
  private int t;
  private int u;
  @Nullable
  private LitePlayer.PlayParams v;
  private ConcurrentLinkedQueue<PlayerStatusListener> w;
  private ConcurrentLinkedQueue<IPlayerReporter> x;
  private VideoPluginInstall y;
  private LitePlayer.MediaPlayListenerAdapterImpl z;
  
  @UiThread
  public LitePlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LitePlayer<");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(">");
    this.e = localStringBuilder.toString();
    this.g = false;
    this.h = false;
    this.i = true;
    this.j = false;
    this.k = false;
    this.l = false;
    this.m = false;
    this.n = true;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = 1.0F;
    this.s = 0;
    this.u = 100;
    this.d = false;
    this.z = new LitePlayer.MediaPlayListenerAdapterImpl(this);
    this.A = new LitePlayer.UiHandler(this);
    this.D = true;
    this.B = paramString;
    this.C = paramBoolean;
    this.a = paramContext.getApplicationContext();
    this.y = new VideoPluginInstall();
    this.y.a(this);
    this.w = new ConcurrentLinkedQueue();
    this.c = new FrameLayout(this.a);
    this.b = G();
    this.x = new ConcurrentLinkedQueue();
    if (!this.y.b()) {
      this.y.a();
    }
    f += 1;
    if (QLog.isColorLevel())
    {
      paramContext = this.e;
      paramString = new StringBuilder();
      paramString.append("LitePlayer: create player, player_num=");
      paramString.append(f);
      QLog.d(paramContext, 2, paramString.toString());
    }
  }
  
  @UiThread
  private VideoPlayerWrapper G()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(this.a.getApplicationContext(), this.B);
    localVideoPlayerWrapper.a(this.z);
    this.c.removeAllViews();
    localVideoPlayerWrapper.a(this.c, TextUtils.isEmpty(this.B) ^ true, this.C);
    View localView = localVideoPlayerWrapper.b();
    if (localView != null)
    {
      localView.setId(2131444264);
      this.c.setKeepScreenOn(true);
    }
    localVideoPlayerWrapper.a(this.q);
    localVideoPlayerWrapper.g(this.p);
    localVideoPlayerWrapper.i(this.n);
    localVideoPlayerWrapper.a(this.r);
    localVideoPlayerWrapper.h(this.o);
    localVideoPlayerWrapper.b(this.s);
    return localVideoPlayerWrapper;
  }
  
  @UiThread
  private void H()
  {
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPlayer: tag=");
      localStringBuilder.append(this.b.E());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((this.b.E() != null) || (!this.b.r()))
    {
      b(this.b);
      this.b.D();
      this.b = G();
    }
    this.c.setKeepScreenOn(true);
  }
  
  private void I()
  {
    this.m = false;
    this.A.removeMessages(1);
    if (this.i)
    {
      e();
      LitePlayer.PlayParams localPlayParams = this.v;
      if ((localPlayParams != null) && (localPlayParams.d / 1000L != this.b.C() / 1000L)) {
        b((int)(this.v.d / 1000L));
      }
    }
    else
    {
      this.j = true;
    }
  }
  
  private void J()
  {
    Object localObject = this.b;
    if (((VideoPlayerWrapper)localObject).n())
    {
      long l1 = ((VideoPlayerWrapper)localObject).C();
      if (l1 >= ((VideoPlayerWrapper)localObject).I() - 500L)
      {
        this.l = true;
      }
      else if ((l1 >= 0L) && (this.l) && (((VideoPlayerWrapper)localObject).R()))
      {
        if (QLog.isColorLevel())
        {
          String str = this.e;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onVideoReplayOnLoop: pos=");
          localStringBuilder.append(l1);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.l = false;
        this.t += 1;
        ((VideoPlayerWrapper)localObject).N();
        localObject = this.w;
        if (localObject != null)
        {
          localObject = ((ConcurrentLinkedQueue)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((PlayerStatusListener)((Iterator)localObject).next()).onVideoEnd(this.t);
          }
        }
      }
      localObject = this.w;
      if (localObject != null)
      {
        localObject = ((ConcurrentLinkedQueue)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((PlayerStatusListener)((Iterator)localObject).next()).onProgressChanged(l1);
        }
      }
    }
  }
  
  private void a(LitePlayer.PlayParams paramPlayParams)
  {
    if (TextUtils.isEmpty(paramPlayParams.b))
    {
      a(paramPlayParams.a, paramPlayParams.c, paramPlayParams.d);
      return;
    }
    a(paramPlayParams.a, paramPlayParams.b, paramPlayParams.c, paramPlayParams.d, paramPlayParams.e);
  }
  
  static void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openByUrl: vid=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", playType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", startPosition=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", mainThread=");
      boolean bool;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!this.h) && (this.D))
    {
      if ((paramBoolean1) && (TextUtils.isEmpty(paramString2)))
      {
        this.z.a(null, 201, 61, 0, "url null", null);
        return;
      }
      if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)))
      {
        this.z.a(null, 201, 61, 0, "vid null", null);
        return;
      }
      if (a(paramLong)) {
        return;
      }
      this.v = new LitePlayer.PlayParams(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
      if (!this.y.b())
      {
        this.y.a();
        return;
      }
      H();
      b(paramString1, paramString2);
      this.b.c(this.d);
      if (ViolaUtils.isBindDataOpmOpen())
      {
        b(new LitePlayer.3(this, paramBoolean1, paramString1, paramString2, paramInt1, paramLong, paramInt2, paramBoolean2, paramString3));
        return;
      }
      a(new LitePlayer.4(this, paramBoolean1, paramString1, paramString2, paramInt1, paramLong, paramInt2, paramBoolean2, paramString3));
      return;
    }
    this.z.a(null, 201, 109, 0, "player had destoryed", null);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.v != null) && (this.m) && (this.b.E() == this.v))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkPreload: status=");
        localStringBuilder.append(this.b.h());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.v.d = paramLong;
      if ((!s()) && (!t()) && (!v()))
      {
        if ((!p()) && (!q()))
        {
          this.m = false;
          if (QLog.isColorLevel())
          {
            QLog.d(this.e, 2, "checkPreload: checkPreload player was preload but status error");
            return false;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.e, 2, "checkPreload: prePlaying, just do nothing ");
          }
          localObject = this.x.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((IPlayerReporter)((Iterator)localObject).next()).a(false);
          }
          this.m = false;
          this.b.B();
          this.b.Y();
          this.g = true;
          this.A.sendEmptyMessageDelayed(1, 10000L);
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.e, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localObject = this.x.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IPlayerReporter)((Iterator)localObject).next()).a(true);
        }
        localObject = this.x.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IPlayerReporter)((Iterator)localObject).next()).b(this.b);
        }
        this.b.B();
        this.b.Y();
        I();
        return true;
      }
    }
    return false;
  }
  
  private void b(LitePlayer.PlayParams paramPlayParams)
  {
    this.b.a(paramPlayParams);
    this.g = true;
    this.t = 0;
    this.A.removeMessages(1);
  }
  
  private void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {
      return;
    }
    paramVideoPlayerWrapper.T();
    if (!paramVideoPlayerWrapper.r())
    {
      if (paramVideoPlayerWrapper.q()) {
        return;
      }
      paramVideoPlayerWrapper.x();
      paramVideoPlayerWrapper.a(null);
    }
  }
  
  static void b(Runnable paramRunnable)
  {
    if (Looper.myLooper() == ThreadManager.getSubThreadLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.executeOnSubThread(paramRunnable);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ((IPlayerReporter)localIterator.next()).a(paramString1, paramString2, this.m, this.q);
    }
    paramString1 = this.w.iterator();
    while (paramString1.hasNext()) {
      ((PlayerStatusListener)paramString1.next()).onVideoOpen();
    }
    b(this.v);
  }
  
  public void A()
  {
    this.z.a(this.b, null);
  }
  
  public Map<String, String> B()
  {
    return VideoPlayUtils.a(this.b);
  }
  
  public void C()
  {
    this.i = false;
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause() isPlaying()=");
      localStringBuilder.append(u());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((u()) || (v()))
    {
      this.k = true;
      this.g = false;
      f();
    }
  }
  
  public void D()
  {
    this.i = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.e, 2, "onResume: ");
    }
    if ((this.j) && (s()))
    {
      I();
    }
    else if (this.k)
    {
      this.g = true;
      g();
    }
    this.k = false;
    this.j = false;
  }
  
  public void E()
  {
    h();
    this.A.removeCallbacksAndMessages(null);
    this.w.clear();
    this.x.clear();
    this.i = true;
    this.k = false;
    this.j = false;
  }
  
  public void F()
  {
    if (!this.h) {
      f -= 1;
    }
    this.h = true;
    this.i = false;
    if (QLog.isColorLevel())
    {
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDestory: destroy player, player_num=");
      localStringBuilder.append(f);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    h();
    this.b.D();
    Object localObject = this.y;
    if (localObject != null) {
      ((VideoPluginInstall)localObject).c();
    }
    this.A.removeCallbacksAndMessages(null);
    this.w.clear();
    this.x.clear();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("replay: ");
      localStringBuilder.append(this.v);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    b(this.b);
    Object localObject = this.v;
    if (localObject != null) {
      a((LitePlayer.PlayParams)localObject);
    }
  }
  
  public void a(float paramFloat)
  {
    this.r = paramFloat;
    this.b.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
    this.b.b(paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.z.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach: ");
      localStringBuilder.append(paramViewGroup);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    m();
    if ((this.c.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.c.getParent()).removeView(this.c);
    }
    n();
    paramViewGroup.addView(this.c, -1, -1);
  }
  
  public void a(IPlayerReporter paramIPlayerReporter)
  {
    this.x.add(paramIPlayerReporter);
  }
  
  public void a(PlayerStatusListener paramPlayerStatusListener)
  {
    this.w.add(paramPlayerStatusListener);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper != null) {
      b(paramVideoPlayerWrapper);
    }
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(new LitePlayer.1(this, paramString, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a("", paramString, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.A.removeMessages(0);
    this.A.sendEmptyMessage(0);
    b(new LitePlayer.PlayParams(this, paramString1, paramString2, 0, 0L, 0));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInstallComplete: success=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mHasDestory=");
      localStringBuilder.append(this.h);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (!this.h)
      {
        if (!this.D) {
          return;
        }
        this.b = G();
        localObject = this.v;
        if (localObject == null) {
          return;
        }
        a((LitePlayer.PlayParams)localObject);
      }
    }
    else
    {
      localObject = this.w.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlayerStatusListener)((Iterator)localObject).next()).onVideoError(123, 99, null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = true;
    this.q = paramBoolean;
    this.b.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPreload: coverFrame=");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    return this.m;
  }
  
  public void c()
  {
    this.b.d();
  }
  
  public void c(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.b.i(paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    this.o = paramBoolean;
    this.b.h(paramBoolean);
  }
  
  public boolean d()
  {
    return (this.b.E() == null) && (this.b.r());
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start: status=");
      localStringBuilder.append(l());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.w.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PlayerStatusListener)((Iterator)localObject).next()).beforeVideoStart();
    }
    this.b.u();
    this.A.removeMessages(0);
    this.A.sendEmptyMessage(0);
    ThreadUtil.a(new LitePlayer.5(this));
    localObject = this.x.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPlayerReporter)((Iterator)localObject).next()).a(this.b);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.p = paramBoolean;
    this.b.g(paramBoolean);
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause: status=");
      localStringBuilder.append(l());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((u()) || (v()))
    {
      this.b.w();
      ThreadUtil.a(new LitePlayer.6(this));
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      String str = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restart: status=");
      localStringBuilder.append(l());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((t()) || (s()))
    {
      this.b.v();
      ThreadUtil.a(new LitePlayer.7(this));
    }
  }
  
  public void h()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop: mPlayParam=");
      localStringBuilder.append(this.v);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.v != null)
    {
      localObject = this.w.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlayerStatusListener)((Iterator)localObject).next()).onVideoStop();
      }
      localObject = this.x.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IPlayerReporter)((Iterator)localObject).next()).a(this.b, this.t);
      }
    }
    b(this.b);
    this.m = false;
    this.n = true;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = 1.0F;
    this.s = 0;
    this.v = null;
    this.t = 0;
    this.B = null;
    this.c.setKeepScreenOn(false);
    this.A.removeMessages(0);
  }
  
  public boolean i()
  {
    return this.b.Q();
  }
  
  public long j()
  {
    return this.b.I();
  }
  
  public long k()
  {
    return this.b.C();
  }
  
  public int l()
  {
    return this.b.h();
  }
  
  public void m()
  {
    this.b.f();
  }
  
  public void n()
  {
    this.b.g();
  }
  
  public boolean o()
  {
    return (this.v != null) && ((q()) || (s()) || (t()) || (u()) || (v()));
  }
  
  public boolean p()
  {
    return this.b.i();
  }
  
  public boolean q()
  {
    return this.b.j();
  }
  
  public boolean r()
  {
    return this.b.k();
  }
  
  public boolean s()
  {
    return this.b.l();
  }
  
  public boolean t()
  {
    return this.b.m();
  }
  
  public boolean u()
  {
    return this.b.n();
  }
  
  public boolean v()
  {
    return this.b.o();
  }
  
  public int w()
  {
    return this.b.F();
  }
  
  public int x()
  {
    return this.b.G();
  }
  
  public String y()
  {
    return this.b.V();
  }
  
  public void z()
  {
    this.b.W();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer
 * JD-Core Version:    0.7.0.1
 */