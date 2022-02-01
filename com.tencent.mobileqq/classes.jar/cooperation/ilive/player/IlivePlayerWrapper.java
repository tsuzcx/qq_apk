package cooperation.ilive.player;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class IlivePlayerWrapper
{
  private static int d = 1;
  private ITPPlayer a;
  private AtomicBoolean b = new AtomicBoolean();
  private AtomicBoolean c = new AtomicBoolean();
  private ITPPlayerListener.IOnPreparedListener e;
  private ITPPlayerListener.IOnInfoListener f;
  private ITPPlayerListener.IOnErrorListener g;
  private ITPPlayerListener.IOnCompletionListener h;
  private ITPPlayerListener.IOnSeekCompleteListener i;
  private ITPPlayerListener.IOnStopAsyncCompleteListener j;
  private Context k;
  private IlivePlayerHandlerWrapper l;
  
  public IlivePlayerWrapper(Context paramContext)
  {
    this.k = paramContext;
    paramContext = IliveAsyncHandlerManager.a();
    int m = d;
    d = m + 1;
    this.l = paramContext.a(m);
    a(new IlivePlayerWrapper.1(this));
  }
  
  private void a(Runnable paramRunnable)
  {
    this.l.a(new IlivePlayerWrapper.RunnableWrapper(paramRunnable));
  }
  
  private void p()
  {
    QLog.i("CachePlayer", 1, "start createTPPlayer");
    this.a = IliveTPPlayerPool.a().a(this.k, this.l.a(), Looper.getMainLooper());
    this.a.setOnPreparedListener(new IlivePlayerWrapper.2(this));
    this.a.setOnInfoListener(new IlivePlayerWrapper.3(this));
    this.a.setOnErrorListener(new IlivePlayerWrapper.4(this));
    this.a.setOnSeekCompleteListener(new IlivePlayerWrapper.5(this));
    this.a.setOnCompletionListener(new IlivePlayerWrapper.6(this));
    this.a.setOnStopAsyncCompleteListener(new IlivePlayerWrapper.7(this));
    QLog.i("CachePlayer", 1, "finish createTPPlayer");
  }
  
  private void q()
  {
    this.b.set(false);
    this.c.set(false);
    c();
  }
  
  public void a(float paramFloat)
  {
    a(new IlivePlayerWrapper.18(this, paramFloat));
  }
  
  public void a(int paramInt)
  {
    a(new IlivePlayerWrapper.15(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(new IlivePlayerWrapper.16(this, paramInt1, paramInt2));
  }
  
  public void a(Surface paramSurface)
  {
    QLog.i("CachePlayer", 1, "start setSurface");
    a(new IlivePlayerWrapper.9(this, paramSurface));
  }
  
  public void a(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.h = paramIOnCompletionListener;
  }
  
  public void a(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    this.g = paramIOnErrorListener;
  }
  
  public void a(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    this.f = paramIOnInfoListener;
  }
  
  public void a(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.e = paramIOnPreparedListener;
  }
  
  public void a(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.i = paramIOnSeekCompleteListener;
  }
  
  public void a(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    this.j = paramIOnStopAsyncCompleteListener;
  }
  
  public void a(TPOptionalParam paramTPOptionalParam)
  {
    a(new IlivePlayerWrapper.22(this, paramTPOptionalParam));
  }
  
  public void a(String paramString)
  {
    if (a())
    {
      QLog.e("CachePlayer", 1, "CachePlayer load url media wait CachePlayer prepare ");
      return;
    }
    QLog.e("CachePlayer", 1, "CachePlayer start loadUrl");
    a(new IlivePlayerWrapper.8(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    a(new IlivePlayerWrapper.17(this, paramBoolean));
  }
  
  public boolean a()
  {
    return this.c.get();
  }
  
  public long b(int paramInt)
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getPropertyLong(paramInt);
    }
    return 0L;
  }
  
  public void b(float paramFloat)
  {
    a(new IlivePlayerWrapper.19(this, paramFloat));
  }
  
  public void b(boolean paramBoolean)
  {
    a(new IlivePlayerWrapper.20(this, paramBoolean));
  }
  
  public boolean b()
  {
    return this.b.get();
  }
  
  public void c()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (this.a != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\nmCallPrepareState = ");
      localStringBuilder2.append(this.c.get());
      localStringBuilder2.append(" mPrepareState = ");
      localStringBuilder2.append(this.b.get());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      localStringBuilder1.append("\nmPlayer = null");
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("logCacheStatus: ");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("CachePlayer", 1, localStringBuilder2.toString());
  }
  
  public void d()
  {
    a(new IlivePlayerWrapper.10(this));
  }
  
  public void e()
  {
    q();
    a(new IlivePlayerWrapper.12(this));
  }
  
  public void f()
  {
    q();
    a(new IlivePlayerWrapper.13(this));
  }
  
  public void g()
  {
    a(new IlivePlayerWrapper.14(this));
  }
  
  public long h()
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public int i()
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public int j()
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long k()
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public int l()
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getBufferPercent();
    }
    return 0;
  }
  
  public void m()
  {
    a(new IlivePlayerWrapper.21(this));
  }
  
  public ITPBusinessReportManager n()
  {
    ITPPlayer localITPPlayer = this.a;
    if (localITPPlayer != null) {
      return localITPPlayer.getReportManager();
    }
    return null;
  }
  
  public void o()
  {
    a(new IlivePlayerWrapper.23(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper
 * JD-Core Version:    0.7.0.1
 */