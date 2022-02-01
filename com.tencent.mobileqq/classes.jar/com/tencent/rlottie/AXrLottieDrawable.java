package com.tencent.rlottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.rlottie.decoder.DispatchQueuePool;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AXrLottieDrawable
  extends BitmapDrawable
  implements Animatable
{
  private static final Handler F = new Handler(Looper.getMainLooper());
  private static final DispatchQueuePool J = new DispatchQueuePool(4);
  private static ThreadPoolExecutor K;
  private boolean A;
  private int B;
  private boolean C;
  private boolean D;
  private final Rect E = new Rect();
  private volatile boolean G;
  private volatile boolean H;
  private volatile long I;
  private AXrLottieDrawable.OnFrameChangedListener L = null;
  private AXrLottieDrawable.OnFrameRenderListener M = null;
  private AXrLottieDrawable.OnLottieLoaderListener N = null;
  private final Runnable O = new AXrLottieDrawable.1(this);
  private final Runnable P = new AXrLottieDrawable.2(this);
  private final Runnable Q = new AXrLottieDrawable.3(this);
  private final Runnable R = new AXrLottieDrawable.4(this);
  private final Runnable S = new AXrLottieDrawable.5(this);
  private String T;
  protected float a = 1.0F;
  protected float b = 1.0F;
  private final int c;
  private final int d;
  private final int[] e = new int[3];
  private int f;
  private float g = 1.0F;
  private int h = -1;
  private int i = -1;
  private boolean j = false;
  private int k = -1;
  private int l;
  private int m = 1;
  private boolean n = false;
  private long o;
  private volatile boolean p;
  private Runnable q;
  private Runnable r;
  private volatile Bitmap s;
  private volatile Bitmap t;
  private volatile Bitmap u;
  private boolean v;
  private CountDownLatch w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public AXrLottieDrawable(AXrLottieDrawable.Builder paramBuilder)
  {
    if (paramBuilder.m != null) {
      a(paramBuilder.m);
    }
    int i1 = paramBuilder.b;
    int i2 = 200;
    if (i1 == -100) {
      i1 = 200;
    } else {
      i1 = paramBuilder.b;
    }
    this.c = i1;
    if (paramBuilder.c == -100) {
      i1 = i2;
    } else {
      i1 = paramBuilder.c;
    }
    this.d = i1;
    this.C = paramBuilder.e;
    this.T = paramBuilder.a;
    getPaint().setFlags(2);
    i1 = AXrLottieDrawable.6.a[AXrLottieDrawable.Builder.a(paramBuilder).ordinal()];
    if (i1 != 1)
    {
      if (i1 == 2) {
        a(AXrLottieDrawable.Builder.c(paramBuilder), paramBuilder.d, paramBuilder.f);
      }
    }
    else {
      a(AXrLottieDrawable.Builder.b(paramBuilder), paramBuilder.d);
    }
    if (paramBuilder.g != -100) {
      a(paramBuilder.g);
    }
    if (paramBuilder.h != -100) {
      b(paramBuilder.h);
    }
    if (paramBuilder.j != -100) {
      c(paramBuilder.j);
    }
    if (paramBuilder.i != -100) {
      d(paramBuilder.i);
    }
    if (paramBuilder.o > 0.0F) {
      a(paramBuilder.o);
    }
    if (paramBuilder.k != null) {
      a(paramBuilder.k);
    }
    if (paramBuilder.l != null) {
      a(paramBuilder.l);
    }
    if (paramBuilder.n) {
      start();
    }
  }
  
  public static AXrLottieDrawable.Builder a(@NonNull Context paramContext, @NonNull File paramFile)
  {
    return new AXrLottieDrawable.Builder(paramContext, paramFile);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.u = this.s;
    this.s = this.t;
    this.t = null;
    Object localObject = this.M;
    if (localObject != null) {
      ((AXrLottieDrawable.OnFrameRenderListener)localObject).a(this, this.B, paramLong2, paramBoolean);
    }
    if (this.p) {
      c(true);
    }
    this.r = null;
    this.z = true;
    this.v = false;
    if (AXrLottie.b() <= 60.0F) {
      this.o = paramLong1;
    } else {
      this.o = (paramLong1 - Math.min(16L, paramLong2 - paramLong3));
    }
    if ((paramBoolean) && (this.A))
    {
      this.z = false;
      this.A = false;
    }
    localObject = this.L;
    if (localObject != null) {
      ((AXrLottieDrawable.OnFrameChangedListener)localObject).onFrameChanged(this, this.B);
    }
    r();
  }
  
  private void a(File paramFile, boolean paramBoolean)
  {
    String str = AXrLottie.c(null).a(paramFile);
    if ((paramBoolean) && (!TextUtils.isEmpty(str))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.I = AXrLottieNative.create(paramFile.getAbsolutePath(), this.c, this.d, this.e, this.C, paramBoolean, str);
    if ((paramBoolean) && (K == null)) {
      K = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
    if ((this.C) && (this.e[1] < 60)) {
      this.C = false;
    }
    int i1;
    if (this.C) {
      i1 = 33;
    } else {
      i1 = 16;
    }
    this.f = Math.max(i1, (int)(1000.0F / this.e[1]));
    k();
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      File localFile = AXrLottie.c(null).a(paramString, g());
      if (localFile != null)
      {
        a(localFile, true);
        return;
      }
    }
    this.I = AXrLottieNative.createWithJson(paramString, g(), this.e);
    int i1;
    if (this.C) {
      i1 = 33;
    } else {
      i1 = 16;
    }
    this.f = Math.max(i1, (int)(1000.0F / this.e[1]));
    if (paramBoolean2) {
      a(true);
    }
    k();
  }
  
  private void n()
  {
    Runnable localRunnable = this.q;
    if ((localRunnable != null) && (K.remove(localRunnable))) {
      this.q = null;
    }
    if ((this.t != null) && (this.r != null))
    {
      this.r = null;
      this.t = null;
    }
  }
  
  private void o()
  {
    if (this.x)
    {
      n();
      if ((this.r == null) && (this.q == null) && (this.I != 0L))
      {
        AXrLottieNative.destroy(this.I);
        this.I = 0L;
      }
    }
    if (this.I == 0L)
    {
      p();
      return;
    }
    this.v = true;
    r();
  }
  
  private void p()
  {
    if (this.s != null)
    {
      this.s.recycle();
      this.s = null;
    }
    if (this.u != null)
    {
      this.u.recycle();
      this.u = null;
    }
  }
  
  private void q()
  {
    if (getCallback() != null) {
      invalidateSelf();
    }
  }
  
  private boolean r()
  {
    if (!f()) {
      return false;
    }
    if ((this.r == null) && (this.t == null) && (this.I != 0L) && (!this.x))
    {
      if (!this.G)
      {
        boolean bool = this.y;
        if (!bool) {
          break label89;
        }
        if ((bool) && (this.z)) {
          return false;
        }
      }
      DispatchQueuePool localDispatchQueuePool = J;
      Runnable localRunnable = this.S;
      this.r = localRunnable;
      localDispatchQueuePool.a(localRunnable);
      return true;
    }
    label89:
    return false;
  }
  
  protected int a()
  {
    if (this.C) {
      return 2;
    }
    return 1;
  }
  
  protected Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = this.M;
    if (localObject != null) {
      localObject = ((AXrLottieDrawable.OnFrameRenderListener)localObject).a(this, paramBitmap, paramInt);
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return paramBitmap;
    }
    return localObject;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    this.g = paramFloat;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > this.e[0]) {
      return;
    }
    this.i = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.e[0]) {
        return;
      }
      this.B = paramInt;
      this.p = false;
      this.z = false;
      if (((!paramBoolean1) || (paramBoolean2)) && (this.v) && (this.t != null))
      {
        this.u = this.t;
        this.t = null;
        this.r = null;
        this.v = false;
      }
      if ((!paramBoolean1) && (this.r == null)) {
        this.w = new CountDownLatch(1);
      }
      if (r())
      {
        if (!paramBoolean1)
        {
          try
          {
            this.w.await();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          this.w = null;
        }
      }
      else {
        this.A = true;
      }
      q();
    }
  }
  
  public void a(AXrLottieDrawable.OnFrameChangedListener paramOnFrameChangedListener)
  {
    this.L = paramOnFrameChangedListener;
  }
  
  public void a(AXrLottieDrawable.OnFrameRenderListener paramOnFrameRenderListener)
  {
    this.M = paramOnFrameRenderListener;
  }
  
  public void a(AXrLottieDrawable.OnLottieLoaderListener paramOnLottieLoaderListener)
  {
    this.N = paramOnLottieLoaderListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
    if (this.y)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAllowDecodeSingleFrame, value:");
      localStringBuilder.append(paramBoolean);
      Log.d("AXrLottieDrawable", localStringBuilder.toString());
      r();
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > this.e[0]) {
      return;
    }
    this.h = Math.max(paramInt, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = -1;
    } else {
      i1 = 0;
    }
    c(i1);
  }
  
  protected boolean b()
  {
    return this.i > 0;
  }
  
  protected int c()
  {
    int i1 = this.i;
    if (i1 > 0) {
      return i1;
    }
    return this.e[0];
  }
  
  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (this.l >= paramInt)) {
      return;
    }
    if (this.m < -1) {
      return;
    }
    this.k = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.G = false;
    AXrLottieDrawable.OnFrameChangedListener localOnFrameChangedListener = this.L;
    if (localOnFrameChangedListener != null) {
      localOnFrameChangedListener.onStop(paramBoolean);
    }
  }
  
  protected int d()
  {
    return Math.min(Math.max(this.h, 0), this.e[0]);
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    this.m = paramInt;
    if (this.m != 2) {
      this.n = false;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.I != 0L)
    {
      if (this.x) {
        return;
      }
      long l1 = SystemClock.elapsedRealtime();
      long l2 = Math.abs(l1 - this.o);
      int i1;
      if (AXrLottie.b() <= 60.0F) {
        i1 = e() - 6;
      } else {
        i1 = e();
      }
      if (this.G)
      {
        if ((this.s == null) && (this.t == null)) {
          r();
        } else if ((this.t != null) && ((this.s == null) || (l2 >= i1))) {
          a(l1, l2, i1, false);
        }
      }
      else if (((this.A) || ((this.y) && (l2 >= i1))) && (this.t != null)) {
        a(l1, l2, i1, true);
      }
      if (this.s != null)
      {
        if (this.D)
        {
          this.E.set(getBounds());
          this.a = (this.E.width() / this.c);
          this.b = (this.E.height() / this.d);
          this.D = false;
        }
        paramCanvas.save();
        paramCanvas.translate(this.E.left, this.E.top);
        paramCanvas.scale(this.a, this.b);
        paramCanvas.drawBitmap(a(this.s, this.B), 0.0F, 0.0F, getPaint());
        if (this.G) {
          q();
        }
        paramCanvas.restore();
      }
    }
  }
  
  protected int e()
  {
    return (int)(this.f / this.g);
  }
  
  public void e(int paramInt)
  {
    a(paramInt, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AXrLottieDrawable)) {
      return false;
    }
    paramObject = (AXrLottieDrawable)paramObject;
    if (this.c != paramObject.c) {
      return false;
    }
    if (this.d != paramObject.d) {
      return false;
    }
    if (c() != paramObject.c()) {
      return false;
    }
    if (d() != paramObject.d()) {
      return false;
    }
    if (this.k != paramObject.k) {
      return false;
    }
    if (this.m != paramObject.m) {
      return false;
    }
    return this.T.equals(paramObject.T);
  }
  
  public boolean f()
  {
    return this.I != 0L;
  }
  
  protected void finalize()
  {
    try
    {
      j();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String g()
  {
    return this.T;
  }
  
  public int getIntrinsicHeight()
  {
    return this.d;
  }
  
  public int getIntrinsicWidth()
  {
    return this.c;
  }
  
  public int getMinimumHeight()
  {
    return this.d;
  }
  
  public int getMinimumWidth()
  {
    return this.c;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public int h()
  {
    return this.B;
  }
  
  public int i()
  {
    return c();
  }
  
  public boolean isRunning()
  {
    return this.G;
  }
  
  public void j()
  {
    if (this.G)
    {
      AXrLottieDrawable.OnFrameChangedListener localOnFrameChangedListener = this.L;
      if (localOnFrameChangedListener != null) {
        localOnFrameChangedListener.onRecycle();
      }
    }
    this.G = false;
    this.H = true;
    n();
    if ((this.r == null) && (this.q == null))
    {
      if (this.I != 0L)
      {
        AXrLottieNative.destroy(this.I);
        this.I = 0L;
      }
      p();
      return;
    }
    this.x = true;
  }
  
  protected void k()
  {
    if (this.N != null)
    {
      if (f())
      {
        this.N.a(this);
        return;
      }
      this.N.a(this, new RuntimeException("Couldn't load lottie!"));
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.D = true;
  }
  
  public void start()
  {
    if (this.G) {
      return;
    }
    AXrLottieDrawable.OnFrameChangedListener localOnFrameChangedListener = this.L;
    if (localOnFrameChangedListener != null) {
      localOnFrameChangedListener.onStart();
    }
    this.G = true;
    this.n = false;
    r();
    q();
  }
  
  public void stop()
  {
    c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieDrawable
 * JD-Core Version:    0.7.0.1
 */