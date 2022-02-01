package com.tencent.mobileqq.lyric.widget;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricContext;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class LyricViewController
{
  protected final String a;
  protected LyricViewInternal b;
  protected Lyric c;
  protected long d;
  protected volatile boolean e;
  protected volatile boolean f;
  protected int g;
  protected int h;
  protected TimerTaskManager i;
  protected LyricScrollHelper j;
  protected TimerTaskManager.TimerTaskRunnable k;
  private LyricViewScroll l;
  private volatile int m;
  private boolean n;
  private boolean o;
  private LyricViewScroll.LyricViewScrollListener p;
  
  public LyricViewController(LyricView paramLyricView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_name_lyric_draw_");
    localStringBuilder.append(System.currentTimeMillis());
    this.a = localStringBuilder.toString();
    this.e = false;
    this.m = 0;
    this.n = false;
    this.o = false;
    this.i = LyricContext.a();
    this.j = new LyricScrollHelper();
    this.p = new LyricViewController.1(this);
    this.k = new LyricViewController.2(this);
    this.l = paramLyricView.getScrollView();
    this.b = paramLyricView.getLyricViewInternal();
    this.l.setScrollListener(this.p);
  }
  
  private void e()
  {
    this.c = this.b.getMeasuredLyric();
    Lyric localLyric = this.c;
    if ((localLyric != null) && (!localLyric.f()) && (!this.e))
    {
      int i1 = (int)(SystemClock.elapsedRealtime() - this.d);
      if (this.f)
      {
        int i2 = this.h;
        if (i1 >= i2) {
          i1 = i2;
        }
      }
      this.m = i1;
      a(localLyric.a(i1), i1);
      return;
    }
    if (this.e) {
      Log.d("ModuleController", "onRefresh -> is scrolling");
    }
  }
  
  public void a()
  {
    Log.d("ModuleController", "start");
    LyricContext.b().post(new LyricViewController.4(this));
    this.i.a(this.a, 100L, 100L, this.k);
    this.n = true;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seek ");
    localStringBuilder.append(paramInt);
    Log.d("ModuleController", localStringBuilder.toString());
    LyricContext.b().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((LyricViewInternal)localObject).getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.9(this, paramInt1, paramInt2));
    }
    localObject = this.l;
    if ((localObject != null) && (((LyricViewScroll)localObject).getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.10(this));
    }
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    LyricContext.b().post(new LyricViewController.3(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(LyricView paramLyricView)
  {
    this.l = paramLyricView.getScrollView();
    this.b = paramLyricView.getLyricViewInternal();
    this.l.setScrollListener(this.p);
  }
  
  public void b()
  {
    Log.d("ModuleController", "stop");
    this.i.a(this.a);
    this.d = 0L;
    this.n = false;
  }
  
  protected void b(int paramInt)
  {
    this.e = false;
    if ((this.c != null) || (this.b != null))
    {
      paramInt = this.b.b(paramInt);
      Object localObject = this.c;
      if ((localObject == null) || (((Lyric)localObject).f())) {
        break label376;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStop -> scroll to lineNo：");
      ((StringBuilder)localObject).append(paramInt);
      Log.d("ModuleController", ((StringBuilder)localObject).toString());
      if ((paramInt >= 0) && (paramInt < this.c.b.size()))
      {
        if (this.c.b.get(paramInt) == null)
        {
          Log.w("ModuleController", "onScrollStop -> current sentence is null");
          return;
        }
        long l2 = ((Sentence)this.c.b.get(paramInt)).b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> start time of current sentence：");
        ((StringBuilder)localObject).append(l2);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        long l1 = l2;
        if (this.f)
        {
          paramInt = this.g;
          if ((paramInt >= 0) && (l2 < paramInt)) {}
          do
          {
            l1 = paramInt;
            break;
            paramInt = this.h;
            l1 = l2;
            if (paramInt < 0) {
              break;
            }
            l1 = l2;
          } while (l2 > paramInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> correct start time：");
        ((StringBuilder)localObject).append(l1);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> output time：");
        ((StringBuilder)localObject).append(l1);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        this.j.a(l1);
        if ((!this.n) && (this.o)) {
          a((int)l1);
        }
      }
      else
      {
        Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
      }
    }
    return;
    label376:
    Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
  }
  
  public void c()
  {
    this.i.a(this.a);
    this.n = false;
  }
  
  protected void c(int paramInt)
  {
    if ((this.c != null) || (this.b != null))
    {
      paramInt = this.b.a(paramInt);
      Lyric localLyric = this.c;
      if ((localLyric != null) && (!localLyric.f()))
      {
        if ((paramInt >= 0) && (paramInt < this.c.b.size()))
        {
          if (this.c.b.get(paramInt) == null)
          {
            Log.w("ModuleController", "onScrollStop -> current sentence is null");
            return;
          }
          long l2 = ((Sentence)this.c.b.get(paramInt)).b;
          long l1 = l2;
          if (this.f)
          {
            paramInt = this.g;
            if ((paramInt >= 0) && (l2 < paramInt)) {}
            do
            {
              l1 = paramInt;
              break;
              paramInt = this.h;
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              l1 = l2;
            } while (l2 > paramInt);
          }
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          l1 = l2 / 10L;
          this.j.b((l1 + 1L) * 10L);
          return;
        }
        Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
      }
    }
    else
    {
      return;
    }
    Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
  }
  
  public boolean d()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController
 * JD-Core Version:    0.7.0.1
 */