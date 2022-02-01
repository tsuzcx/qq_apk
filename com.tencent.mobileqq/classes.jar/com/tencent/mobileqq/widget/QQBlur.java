package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(19)
public class QQBlur
{
  private static Field G;
  public static int a;
  private static HandlerThread p = ThreadManagerV2.newFreeHandlerThread("QQBlur", -8);
  private long A;
  private long B;
  private String C;
  private int D = 0;
  private boolean E;
  private List<View> F = new ArrayList();
  private long H;
  private int I = 2;
  private QQBlur.onCalculateLocationListener J;
  private Context b;
  private View c;
  private volatile View d;
  private volatile Bitmap e;
  private Paint f;
  private Canvas g;
  private float h = 8.0F;
  private int i = 6;
  private float j = 1.0F;
  private float k = 1.0F;
  private long l;
  private long m;
  private long n;
  private long o;
  private Handler q;
  private QQBlur.OnDrawBgListener r;
  private volatile boolean s = true;
  private Drawable t = new ColorDrawable(Color.parseColor("#DAFAFAFC"));
  private boolean u;
  private RectF v = new RectF();
  private float w;
  private float x;
  private QQBlur.BackgroundViewDirtyListener y;
  private long z;
  
  static
  {
    p.start();
  }
  
  private static int a(float paramFloat1, float paramFloat2)
  {
    return (int)Math.ceil(paramFloat1 / paramFloat2);
  }
  
  public static int a(int paramInt)
  {
    int i1 = paramInt % 16;
    if (i1 == 0) {
      return paramInt;
    }
    return paramInt - i1 + 16;
  }
  
  private void a(View paramView, int paramInt)
  {
    SystemClock.uptimeMillis();
    try
    {
      if (G == null) {
        G = ReflectionUtil.a("android.view.View", "mViewFlags");
      }
      int i1 = G.getInt(paramView);
      G.setInt(paramView, paramInt & 0xC | i1 & 0xFFFFFFF3);
    }
    catch (Exception paramView)
    {
      QLog.e("QQBlur", 1, "setViewInvisible: ", paramView);
    }
    SystemClock.uptimeMillis();
    if (this.H >= 100000L) {
      this.H = 0L;
    }
    this.H += 1L;
    long l1 = this.H;
  }
  
  private void a(View paramView, List<View> paramList)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getVisibility() != 0) {
      return;
    }
    paramList.add(paramView);
    a(paramView, 4);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i2 = paramView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(paramView.getChildAt(i1), paramList);
        i1 += 1;
      }
    }
  }
  
  private void a(StackBlurManager paramStackBlurManager)
  {
    paramStackBlurManager = new QQBlur.1(this, paramStackBlurManager);
    this.q.post(paramStackBlurManager);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i1 = a(paramInt1, this.h);
    int i2 = a(paramInt2, this.h);
    int i3 = a(i1);
    int i4 = a(i2);
    if (i3 > this.d.getResources().getDisplayMetrics().widthPixels)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("prepareBlurBitmapCore: roundScaledWidth = ");
      ((StringBuilder)localObject1).append(i3);
      ((StringBuilder)localObject1).append(", viewWidth = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", scaleFactor = ");
      ((StringBuilder)localObject1).append(this.h);
      QLog.e("QQBlur", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    if (i4 > this.d.getResources().getDisplayMetrics().heightPixels)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("prepareBlurBitmapCore: roundScaledHeight = ");
      ((StringBuilder)localObject1).append(i4);
      ((StringBuilder)localObject1).append(", viewHeight = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", scaleFactor = ");
      ((StringBuilder)localObject1).append(this.h);
      QLog.e("QQBlur", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    this.k = (i2 / i4);
    this.j = (i1 / i3);
    float f2 = this.h;
    float f1 = this.j * f2;
    f2 *= this.k;
    Object localObject1 = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
      localObject1 = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQBlur", 1, "prepareBlurBitmapCore: ", localThrowable);
    }
    if (localObject1 == null) {
      return true;
    }
    this.z = ((Bitmap)localObject1).getWidth();
    this.A = ((Bitmap)localObject1).getHeight();
    if (Build.VERSION.SDK_INT >= 19) {
      this.B = ((Bitmap)localObject1).getAllocationByteCount();
    } else {
      this.B = ((Bitmap)localObject1).getByteCount();
    }
    ((Bitmap)localObject1).eraseColor(this.D);
    this.g.setBitmap((Bitmap)localObject1);
    Object localObject2 = new int[2];
    this.d.getLocationInWindow((int[])localObject2);
    Object localObject3 = new int[2];
    this.c.getLocationInWindow((int[])localObject3);
    Object localObject4 = this.J;
    if (localObject4 != null) {
      ((QQBlur.onCalculateLocationListener)localObject4).a(this.c, this.d, (int[])localObject3, (int[])localObject2);
    }
    this.g.save();
    this.g.translate(-(localObject2[0] - localObject3[0]) / f1, -(localObject2[1] - localObject3[1]) / f2);
    this.g.scale(1.0F / f1, 1.0F / f2);
    localObject2 = new StackBlurManager((Bitmap)localObject1);
    ((StackBlurManager)localObject2).setDbg(false);
    ((StackBlurManager)localObject2).setExecutorThreads(((StackBlurManager)localObject2).getExecutorThreads());
    localObject3 = new Bundle();
    localObject4 = this.r;
    if (localObject4 != null) {
      ((QQBlur.OnDrawBgListener)localObject4).a((Bundle)localObject3);
    }
    this.E = true;
    if ((Build.VERSION.SDK_INT > 27) && (this.d.getContext().getApplicationInfo().targetSdkVersion > 27))
    {
      this.c.draw(this.g);
    }
    else
    {
      localObject4 = this.g.getClipBounds();
      ((Rect)localObject4).inset(-((Bitmap)localObject1).getWidth(), -((Bitmap)localObject1).getHeight());
      if (this.g.clipRect((Rect)localObject4, Region.Op.REPLACE)) {
        this.c.draw(this.g);
      } else {
        QLog.e("QQBlur", 1, "prepareBlurBitmapCore: canvas clip rect empty. Cannot draw!!!");
      }
    }
    this.g.restore();
    l();
    this.E = false;
    localObject1 = this.r;
    if (localObject1 != null) {
      ((QQBlur.OnDrawBgListener)localObject1).b((Bundle)localObject3);
    }
    a((StackBlurManager)localObject2);
    return false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPolicyChange() called with: from = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], to = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d("QQBlur", 2, localStringBuilder.toString());
    }
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
  }
  
  private CharSequence e(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "StackBlur.Java";
        }
        return "GaussBlur.RS";
      }
      return "StackBlur.RS";
    }
    return "StackBlur.Native";
  }
  
  private void j()
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.c != null) && (this.d != null))
    {
      int i1 = this.d.getWidth();
      int i2 = this.d.getHeight();
      if ((i1 > 0) && (i2 > 0))
      {
        if (a(i1, i2)) {
          return;
        }
        long l2 = SystemClock.elapsedRealtime();
        this.l += 1L;
        this.m += l2 - l1;
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareBlurBitmap: viewWidth = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" viewHeight = ");
      localStringBuilder.append(i2);
      QLog.e("QQBlur", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prepareBlurBitmap: mBgView = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mBlurView = ");
    localStringBuilder.append(this.d);
    QLog.e("QQBlur", 1, localStringBuilder.toString());
  }
  
  private void k()
  {
    if ((this.b != null) && (this.c != null)) {
      View localView = this.d;
    }
  }
  
  private void l()
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        a(localView, 0);
      }
    }
  }
  
  public QQBlur a(View paramView)
  {
    this.c = paramView;
    return this;
  }
  
  public QQBlur a(QQBlur.OnDrawBgListener paramOnDrawBgListener)
  {
    this.r = paramOnDrawBgListener;
    return this;
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void a(ColorDrawable paramColorDrawable)
  {
    this.e = BlurUtil.a(paramColorDrawable);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.t = paramDrawable;
  }
  
  public void a(View paramView, Canvas paramCanvas)
  {
    Bitmap localBitmap = this.e;
    if (localBitmap != null)
    {
      paramCanvas.save();
      paramCanvas.scale(paramView.getWidth() * 1.0F / localBitmap.getWidth(), paramView.getHeight() * 1.0F / localBitmap.getHeight());
      if (this.f == null) {
        this.f = new Paint(1);
      }
      this.f.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.v.set(0.0F, 0.0F, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawRoundRect(this.v, this.w, this.x, this.f);
      paramView = this.t;
      if (paramView != null)
      {
        paramView.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        this.t.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
    paramCanvas = new StringBuilder();
    paramCanvas.append("onDrawBlur: blured bitmap is null ");
    paramCanvas.append(Integer.toHexString(System.identityHashCode(paramView)));
    QLog.e("QQBlur", 1, paramCanvas.toString());
  }
  
  public void a(QQBlur.BackgroundViewDirtyListener paramBackgroundViewDirtyListener)
  {
    this.y = paramBackgroundViewDirtyListener;
  }
  
  public void a(QQBlur.onCalculateLocationListener paramonCalculateLocationListener)
  {
    this.J = paramonCalculateLocationListener;
  }
  
  public void a(String paramString)
  {
    this.C = paramString;
  }
  
  boolean a()
  {
    return this.u;
  }
  
  public QQBlur b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onCreate() called");
    }
    boolean bool = this.u;
    this.b = this.d.getContext();
    this.g = new Canvas();
    this.q = new Handler(p.getLooper());
    this.u = true;
    k();
    return this;
  }
  
  public QQBlur b(View paramView)
  {
    this.d = paramView;
    return this;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c()
  {
    this.s = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQBlur.");
    localStringBuilder.append(this.C);
    QLog.i(localStringBuilder.toString(), 2, g());
  }
  
  public void c(int paramInt)
  {
    a = paramInt;
  }
  
  public void d()
  {
    this.s = false;
  }
  
  public void d(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onDestroy() called");
    }
    if (this.u)
    {
      this.u = false;
      this.q.removeCallbacksAndMessages(null);
      this.q = null;
      this.c = null;
      this.d = null;
      this.g.setBitmap(null);
      this.g = null;
      this.f = null;
      this.r = null;
      this.b = null;
    }
  }
  
  public boolean f()
  {
    Object localObject = this.y;
    boolean bool;
    if (localObject != null)
    {
      bool = ((QQBlur.BackgroundViewDirtyListener)localObject).isDirty();
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        bool = ((View)localObject).isDirty();
      } else {
        bool = false;
      }
    }
    localObject = this.d;
    if ((!this.s) && (bool) && (localObject != null) && (((View)localObject).isShown()))
    {
      j();
      ((View)localObject).invalidate();
    }
    return true;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("方案=");
    localStringBuilder1.append(e(a));
    localStringBuilder1.append(",");
    localStringBuilder1.append("缩放倍数=");
    localStringBuilder1.append(this.h);
    localStringBuilder1.append(",");
    localStringBuilder1.append("模糊半径=");
    localStringBuilder1.append(this.i);
    localStringBuilder1.append(",");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("尺寸=");
    localStringBuilder2.append(this.z);
    localStringBuilder2.append("x");
    localStringBuilder2.append(this.A);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("空间=");
    localStringBuilder2.append(this.B / 1000L);
    localStringBuilder2.append("KB");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("并发数=");
    localStringBuilder2.append(this.I);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("主线程采样=[");
    localStringBuilder2.append(String.format("%.2f", new Object[] { Float.valueOf((float)this.m / (float)this.l) }));
    localStringBuilder2.append("]ms");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("后台线程处理=[");
    localStringBuilder2.append(String.format("%.2f", new Object[] { Float.valueOf((float)this.o / (float)this.n) }));
    localStringBuilder2.append("]ms");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public boolean h()
  {
    return this.E;
  }
  
  public void i()
  {
    this.F.clear();
    a(this.c.getRootView(), this.F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur
 * JD-Core Version:    0.7.0.1
 */