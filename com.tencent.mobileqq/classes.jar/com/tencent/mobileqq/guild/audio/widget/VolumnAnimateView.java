package com.tencent.mobileqq.guild.audio.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class VolumnAnimateView
  extends View
{
  private static final float[] o = { 151.0F, 90.0F, 151.0F, 106.62F, 144.36F, 121.68F, 133.58F, 132.67999F, 122.51F, 143.99001F, 107.07F, 151.0F, 90.0F, 151.0F, 56.310001F, 151.0F, 29.0F, 123.69F, 29.0F, 90.0F, 29.0F, 73.040001F, 35.919998F, 57.709999F, 47.080002F, 46.650002F, 58.110001F, 35.740002F, 73.269997F, 29.0F, 90.0F, 29.0F, 123.69F, 29.0F, 151.0F, 56.310001F, 151.0F, 90.0F, 153.98F, 90.019997F, 153.98F, 108.47F, 146.17F, 125.09F, 133.67999F, 136.77F, 122.25F, 147.47F, 106.88F, 154.02F, 89.980003F, 154.02F, 54.630001F, 154.02F, 25.98F, 125.37F, 25.98F, 90.019997F, 25.98F, 73.639999F, 32.139999F, 58.689999F, 42.259998F, 47.369999F, 53.98F, 34.27F, 71.019997F, 26.02F, 89.980003F, 26.02F, 125.33F, 26.02F, 153.98F, 54.669998F, 153.98F, 90.019997F, 157.98F, 90.019997F, 157.98F, 108.9F, 150.28F, 125.99F, 137.85001F, 138.31F, 125.56F, 150.49001F, 108.65F, 158.02F, 89.980003F, 158.02F, 52.43F, 158.02F, 21.98F, 127.57F, 21.98F, 90.019997F, 21.98F, 70.690002F, 30.040001F, 53.25F, 42.990002F, 40.869999F, 55.200001F, 29.190001F, 71.75F, 22.02F, 89.980003F, 22.02F, 127.54F, 22.02F, 157.98F, 52.459999F, 157.98F, 90.019997F };
  private static final float[] p = { 152.14F, 101.72F, 150.07001F, 118.8F, 148.21001F, 128.53F, 137.45F, 139.50999F, 126.4F, 150.78999F, 107.25F, 153.14999F, 90.220001F, 153.14999F, 56.599998F, 153.14999F, 29.34F, 126.91F, 26.190001F, 90.169998F, 24.610001F, 71.68F, 26.190001F, 48.18F, 40.889999F, 34.540001F, 55.389999F, 21.07F, 81.410004F, 27.73F, 98.610001F, 30.34F, 133.25F, 35.59F, 156.34F, 67.080002F, 152.14F, 101.72F, 157.0F, 90.93F, 157.0F, 109.34F, 153.77F, 127.44F, 141.35001F, 139.09F, 129.97F, 149.77F, 106.68F, 158.39F, 90.220001F, 156.89F, 55.790001F, 153.75F, 19.27F, 126.53F, 14.05F, 90.93F, 11.63F, 74.43F, 10.92F, 53.23F, 31.790001F, 39.619999F, 55.950001F, 23.860001F, 73.989998F, 22.790001F, 90.220001F, 23.91F, 120.48F, 26.01F, 157.0F, 55.650002F, 157.0F, 90.93F, 161.28F, 93.260002F, 161.28F, 112.09F, 158.03F, 133.12F, 145.64F, 145.39999F, 133.38F, 157.53999F, 106.88F, 160.0F, 88.269997F, 160.0F, 50.82F, 160.0F, 22.559999F, 129.75999F, 17.34F, 90.129997F, 14.66F, 69.739998F, 14.86F, 35.740002F, 27.77F, 23.4F, 39.939999F, 11.76F, 72.620003F, 12.97F, 90.349998F, 15.06F, 126.89F, 19.35F, 161.28F, 55.830002F, 161.28F, 93.260002F };
  private final int a = 3;
  private Path[] b = new Path[3];
  private Drawable[] c = new Drawable[3];
  private int[] d = { 204, 150, 100 };
  private float[] e = { 0.0F, 0.0F, 0.0F };
  private float f = 1.0F;
  private Matrix g = new Matrix();
  private int h;
  private int i;
  private ValueAnimator j;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m = 0.0F;
  private boolean n = false;
  private float[] q = new float[o.length];
  
  @RequiresApi(api=21)
  public VolumnAnimateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @RequiresApi(api=21)
  public VolumnAnimateView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @RequiresApi(api=21)
  public VolumnAnimateView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  @RequiresApi(api=21)
  public VolumnAnimateView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private void a()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      this.b[i1] = new Path();
      i1 += 1;
    }
    e();
    d();
    c();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.n ^= true;
    }
    else
    {
      this.n = false;
      this.l = this.m;
      int i1 = 0;
      while (i1 < 3)
      {
        this.e[i1] = ((float)(Math.random() * 360.0D));
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetAnimator: onlyReverse=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", deflating=");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(", targetFraction=");
      ((StringBuilder)localObject).append(this.l);
      QLog.i("VolumnAnimateView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.j;
    paramBoolean = this.n;
    float f2 = 0.0F;
    float f1;
    if (paramBoolean) {
      f1 = this.l;
    } else {
      f1 = 0.0F;
    }
    if (!this.n) {
      f2 = this.l;
    }
    ((ValueAnimator)localObject).setFloatValues(new float[] { f1, f2 });
    this.j.start();
  }
  
  private void b()
  {
    try
    {
      Field localField = ValueAnimator.class.getDeclaredField("sDurationScale");
      localField.setAccessible(true);
      if (Float.compare(localField.getFloat(null), 0.0F) == 0)
      {
        QLog.e("VolumnAnimateView", 1, "Settings.Global.ANIMATOR_DURATION_SCALE was 0, reset to 1");
        localField.setFloat(null, 1.0F);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VolumnAnimateView", 1, localThrowable.getMessage());
    }
  }
  
  private void c()
  {
    this.j = new ValueAnimator();
    this.j.setInterpolator(new AccelerateDecelerateInterpolator());
    this.j.addUpdateListener(new VolumnAnimateView.1(this));
    this.j.setDuration(150L);
    b();
  }
  
  private void d()
  {
    this.h = getWidth();
    this.i = getHeight();
    this.f = (this.h * 1.0F / 180.0F);
    int i1 = 0;
    while (i1 < 3)
    {
      this.c[i1].setBounds(-10, -10, this.h + 10, this.i + 10);
      i1 += 1;
    }
    f();
    invalidate();
  }
  
  private void e()
  {
    Drawable[] arrayOfDrawable = this.c;
    Drawable localDrawable = getResources().getDrawable(2130840699);
    int i1 = 0;
    arrayOfDrawable[0] = localDrawable;
    this.c[1] = getResources().getDrawable(2130840698);
    this.c[2] = getResources().getDrawable(2130840697);
    while (i1 < 3)
    {
      this.c[i1].setAlpha(this.d[i1]);
      i1 += 1;
    }
  }
  
  private void f()
  {
    h();
    g();
    j();
    i();
  }
  
  private void g()
  {
    int i2 = 0;
    int i1 = -1;
    while (i2 < 3)
    {
      this.b[i2].reset();
      Path localPath = this.b[i2];
      float[] arrayOfFloat = this.q;
      i1 += 1;
      float f1 = arrayOfFloat[i1];
      i1 += 1;
      localPath.moveTo(f1, arrayOfFloat[i1]);
      int i3 = 0;
      while (i3 < 6)
      {
        localPath = this.b[i2];
        arrayOfFloat = this.q;
        i1 += 1;
        f1 = arrayOfFloat[i1];
        i1 += 1;
        float f2 = arrayOfFloat[i1];
        i1 += 1;
        float f3 = arrayOfFloat[i1];
        i1 += 1;
        float f4 = arrayOfFloat[i1];
        i1 += 1;
        float f5 = arrayOfFloat[i1];
        i1 += 1;
        localPath.cubicTo(f1, f2, f3, f4, f5, arrayOfFloat[i1]);
        i3 += 1;
      }
      this.b[i2].close();
      i2 += 1;
    }
  }
  
  private void h()
  {
    int i1 = 0;
    for (;;)
    {
      float[] arrayOfFloat1 = o;
      if (i1 >= arrayOfFloat1.length) {
        break;
      }
      float[] arrayOfFloat2 = this.q;
      arrayOfFloat1[i1] += (p[i1] - arrayOfFloat1[i1]) * this.k;
      if (i1 % 2 == 1)
      {
        float f1 = arrayOfFloat2[i1];
        int i2 = this.i;
        if (f1 > i2 * 5.0F / 6.0F) {
          arrayOfFloat2[i1] = (i2 * 5.0F / 6.0F);
        }
      }
      i1 += 1;
    }
  }
  
  private void i()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      float f1 = this.e[i1];
      float f2 = this.k;
      this.g.reset();
      this.g.postRotate((f1 + f2 * 5.0F) % 360.0F, this.h / 2, this.i / 2);
      this.b[i1].transform(this.g);
      i1 += 1;
    }
  }
  
  private void j()
  {
    this.g.reset();
    Matrix localMatrix = this.g;
    float f1 = this.f;
    localMatrix.postScale(f1, f1);
    int i1 = 0;
    while (i1 < 3)
    {
      this.b[i1].transform(this.g);
      i1 += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = 2;
    while (i1 >= 0)
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.b[i1]);
      this.c[i1].draw(paramCanvas);
      paramCanvas.restore();
      i1 -= 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setVolumn(int paramInt)
  {
    float f2 = paramInt * 1.0F / 100.0F;
    float f1 = f2;
    if (Float.compare(f2, 0.0F) == 0) {
      f1 = 0.01F;
    }
    this.m = f1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVolumn: volumn=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", fraction=");
      localStringBuilder.append(f1);
      QLog.i("VolumnAnimateView", 2, localStringBuilder.toString());
    }
    if (!this.j.isRunning()) {
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.VolumnAnimateView
 * JD-Core Version:    0.7.0.1
 */