package com.tencent.mobileqq.guild.audio.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.qphone.base.util.QLog;

public class MicSpeakDrawable
  extends Drawable
{
  private float A;
  private LinearGradient B;
  private LinearGradient C;
  private LinearGradient D;
  private float E = -1.0F;
  private final int a = 100;
  private final int b = 5;
  private final int c;
  private final int d;
  private final Rect e = new Rect();
  private final Bitmap f;
  private final int[] g = { -16733697, -16738561 };
  private final int[] h = { -16738561, -16720129 };
  private final int[] i = { 1291902719, 1291884287 };
  private Paint j;
  private RectF k;
  private volatile int l = 0;
  private int m = 0;
  private float n;
  private ValueAnimator o;
  private ValueAnimator p;
  private Bitmap q;
  private Canvas r;
  private Path s;
  private Path t;
  private Path u;
  private Path v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public MicSpeakDrawable(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = a(paramContext, 2130840724);
    this.k = new RectF(0.0F, 0.0F, this.c, this.d);
    a();
  }
  
  private LinearGradient a(float paramFloat, @ColorInt @NonNull int[] paramArrayOfInt)
  {
    float f1 = this.w;
    float f2 = this.y;
    return new LinearGradient(f2 / 2.0F + f1, paramFloat, f1 + f2 / 2.0F, paramFloat + this.z, paramArrayOfInt, null, Shader.TileMode.CLAMP);
  }
  
  private void a()
  {
    this.q = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
    this.r = new Canvas(this.q);
    this.j = new Paint(6);
    this.j.setAntiAlias(true);
    this.t = new Path();
    this.u = new Path();
    this.v = new Path();
    b();
  }
  
  private void a(float paramFloat1, Path paramPath, float paramFloat2)
  {
    paramPath.reset();
    if (!d()) {
      return;
    }
    float f3 = this.y;
    float f2 = f3 / 2.0F;
    float f1 = this.x + this.z - paramFloat1;
    paramFloat2 = this.w - paramFloat2 % f3 * 4.0F / 3.0F;
    paramPath.moveTo(paramFloat2, f1);
    f2 = f2 * 2.0F / 3.0F;
    int i1;
    float f4;
    for (paramFloat1 = 0.0F;; paramFloat1 += f4)
    {
      i1 = this.c;
      if (paramFloat1 > i1) {
        break;
      }
      f3 = -this.n;
      f4 = f2 * 2.0F;
      paramPath.rQuadTo(f2, f3, f4, 0.0F);
      paramPath.rQuadTo(f2, this.n, f4, 0.0F);
    }
    paramPath.lineTo(i1, this.z + f1);
    paramPath.lineTo(paramFloat2, f1 + this.z);
    paramPath.close();
  }
  
  private void b()
  {
    float f1 = this.c / 60.0F;
    this.w = (19.0F * f1);
    this.x = (3.0F * f1);
    this.y = (22.0F * f1);
    this.z = (f1 * 39.0F);
    float f2 = this.y / 2.0F;
    this.n = (this.z / 6.0F);
    this.s = new Path();
    this.s.moveTo(this.w + f2, this.x + f2);
    Path localPath = this.s;
    float f3 = this.w;
    float f4 = this.x;
    float f5 = this.y;
    f1 = 2.0F * f2;
    localPath.addArc(f3, f4, f3 + f5, f4 + f1, -180.0F, 180.0F);
    localPath = this.s;
    f3 = this.w;
    f4 = this.x;
    localPath.addRect(f3, f4 + f2, f3 + this.y, f4 + this.z - f2, Path.Direction.CW);
    this.s.moveTo(this.w + f2, this.x + this.z - f2);
    localPath = this.s;
    f2 = this.w;
    f3 = this.x;
    f4 = this.z;
    localPath.addArc(f2, f3 + f4 - f1, f2 + this.y, f3 + f4, 0.0F, 180.0F);
  }
  
  private float c()
  {
    return this.z * this.l * 1.0F / 100.0F;
  }
  
  private boolean d()
  {
    return this.l >= 5;
  }
  
  private void e()
  {
    if (this.p == null)
    {
      this.p = ValueAnimator.ofFloat(new float[] { 0.0F, this.y * 4.0F });
      this.p.setDuration(8000L);
      this.p.setRepeatMode(1);
      this.p.setInterpolator(new LinearInterpolator());
      this.p.addUpdateListener(new MicSpeakDrawable.2(this));
    }
    if (!this.p.isRunning()) {
      this.p.start();
    }
  }
  
  private void f()
  {
    this.q.eraseColor(0);
    float f1 = c();
    float f2 = this.x + this.z - f1;
    int i1;
    if (this.E == f2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.E = f2;
    a(f1, this.t, this.A);
    if ((i1 != 0) || (this.B == null)) {
      this.B = a(f2, this.g);
    }
    this.j.setShader(this.B);
    this.r.drawPath(this.t, this.j);
    a(f1, this.u, this.A * 2.0F);
    this.j.setColor(Color.argb(255, 0, 0, 255));
    if ((i1 != 0) || (this.C == null)) {
      this.C = a(f2, this.h);
    }
    this.j.setShader(this.C);
    this.r.drawPath(this.u, this.j);
    a(f1, this.v, this.A * 3.0F);
    this.j.setColor(Color.argb(255, 0, 255, 0));
    if ((i1 != 0) || (this.D == null)) {
      this.D = a(f2, this.i);
    }
    this.j.setShader(this.D);
    this.r.drawPath(this.v, this.j);
    this.j.setShader(null);
  }
  
  public Bitmap a(Context paramContext, int paramInt)
  {
    Object localObject = ContextCompat.getDrawable(paramContext, paramInt);
    if (localObject != null)
    {
      if ((localObject instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
      paramContext = (Context)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        paramContext = DrawableCompat.wrap((Drawable)localObject).mutate();
      }
      localObject = Bitmap.createBitmap(paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramContext.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramContext.draw(localCanvas);
      return localObject;
    }
    throw new IllegalArgumentException("[MicSpeakDrawable] [getBitmapFromDrawable] unsupported drawable type");
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setVolumeLevel] level = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("MicSpeakDrawable", 4, ((StringBuilder)localObject).toString());
    int i2 = this.m;
    this.m = paramInt;
    if (this.m != i2)
    {
      localObject = this.o;
      int i1;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
      {
        paramInt = ((Integer)this.o.getAnimatedValue()).intValue();
        this.o.cancel();
        i1 = paramInt;
      }
      else
      {
        i1 = -1;
        paramInt = i2;
      }
      if (this.o == null)
      {
        this.o = new ValueAnimator();
        this.o.addUpdateListener(new MicSpeakDrawable.1(this));
      }
      if (this.m > paramInt) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      localObject = this.o;
      long l1;
      if (i2 != 0) {
        l1 = 100L;
      } else {
        l1 = 200L;
      }
      ((ValueAnimator)localObject).setDuration(l1);
      localObject = this.o;
      i2 = i1;
      if (i1 == -1) {
        i2 = paramInt;
      }
      ((ValueAnimator)localObject).setIntValues(new int[] { i2, this.m });
      this.o.start();
      return;
    }
    this.l = paramInt;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.e.set(0, 0, this.f.getWidth(), this.f.getHeight());
    paramCanvas.drawBitmap(this.f, this.e, this.k, this.j);
    int i1 = paramCanvas.saveLayer(0.0F, 0.0F, this.c, this.d, this.j);
    this.j.setColor(-16777216);
    this.j.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.s, this.j);
    f();
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    paramCanvas.drawBitmap(this.q, 0.0F, 0.0F, this.j);
    this.j.setXfermode(null);
    paramCanvas.restoreToCount(i1);
    e();
  }
  
  public int getIntrinsicHeight()
  {
    return this.d;
  }
  
  public int getIntrinsicWidth()
  {
    return this.c;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.k = new RectF(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.j.getAlpha() == paramInt) {
      return;
    }
    this.j.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.j.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.MicSpeakDrawable
 * JD-Core Version:    0.7.0.1
 */