package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.util.Arrays;

public class MessageProgressView
  extends View
{
  public float A = 23.0F;
  public Drawable B;
  Rect C;
  private float D = 10.0F;
  private float E = 10.0F;
  private float F = 16.0F;
  private float G = 1.0F;
  private float H = 14.0F;
  private Path I;
  private RectF J;
  private Path K;
  private float[] L;
  private boolean M;
  private boolean N = true;
  private float O;
  private float P;
  private float Q;
  private float R;
  private float S;
  private float T;
  private float U;
  private float V;
  private float W;
  private float Z = -1.0F;
  private float a = 14.0F;
  private int aa;
  private RectF ab;
  private int ac = -1;
  private float ad;
  private RectF ae;
  private float af;
  private float ag;
  private Paint ah;
  private RectF ai;
  private Paint aj;
  private Paint ak;
  private Paint al;
  private Paint am;
  private float b = 8.0F;
  private float c = 0.0F;
  private float d = 5.0F;
  private float e = 4.0F;
  public final String f = "MessageProgressView";
  public int g = -1;
  public int h = 0;
  public String i;
  public long j = -1L;
  public float k;
  public float l;
  public Resources m;
  public MessageProgressView.AnimRunnableListener n;
  AccelerateDecelerateInterpolator o;
  public float p = Math.abs(this.c - this.E);
  public long q = 534L;
  public long r = 400L;
  public long s = 767L;
  public int t = 2130706432;
  public float u;
  public float v;
  public long w = 667L;
  public Drawable x;
  public int y = 0;
  public Path z;
  
  public MessageProgressView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public MessageProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public MessageProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 >= paramFloat1)
    {
      if (paramFloat3 > paramFloat2) {
        return paramFloat3;
      }
      paramFloat2 -= paramFloat1;
    }
    try
    {
      float f1 = new BigDecimal((paramFloat3 - paramFloat1) / paramFloat2).setScale(3, 4).floatValue();
      f1 = this.o.getInterpolation(f1);
      if (f1 >= 0.0F)
      {
        if (f1 > 1.0F) {
          return paramFloat3;
        }
        return f1 * paramFloat2 + paramFloat1;
      }
      return paramFloat3;
    }
    catch (Exception localException) {}
    return paramFloat3;
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(Canvas paramCanvas, Path paramPath1, Path paramPath2)
  {
    if (this.h < 100)
    {
      this.am.setColor(this.t);
      paramCanvas.drawPath(this.I, this.am);
      return;
    }
    float f1 = (float)Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight());
    float f2 = (float)this.j / (float)this.q * f1;
    this.O = a(0.0F, f1, f2);
    this.K.reset();
    this.K.addCircle(this.k, this.l, f2, Path.Direction.CW);
    this.K.close();
    int i1 = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.clipPath(this.K, Region.Op.DIFFERENCE);
    paramCanvas.drawPath(this.I, this.am);
    paramCanvas.restoreToCount(i1);
  }
  
  private void h(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if (!this.N)
    {
      this.J.set(0.0F, 0.0F, i1, i2);
      this.I.reset();
      this.I.addRoundRect(this.J, this.L, Path.Direction.CW);
      this.I.close();
    }
    else
    {
      Resources localResources = this.m;
      if (this.M) {
        this.J.set(0.0F, 0.0F, i1 - this.u, i2);
      } else {
        this.J.set(this.u, 0.0F, i1, i2);
      }
      this.I.reset();
      float f1 = a(this.d, localResources);
      float f2;
      float f3;
      float f4;
      if (this.M)
      {
        this.I.addRoundRect(this.J, this.L, Path.Direction.CW);
        f2 = i1 - a(this.a, localResources);
        f3 = a(this.b, localResources);
        this.I.moveTo(f2, f3);
        f2 = i1;
        f3 = this.c;
        f4 = i1 - a(this.e, localResources);
        float f5 = a(this.D, localResources);
        this.I.quadTo(f4, f5, f2 - f3, f1);
        f1 = i1 - a(this.E, localResources);
        f2 = a(this.F, localResources);
        f3 = i1 - a(this.G, localResources);
        f4 = a(this.H, localResources);
        this.I.quadTo(f3, f4, f1, f2);
      }
      else
      {
        this.I.addRoundRect(this.J, this.L, Path.Direction.CCW);
        f2 = a(this.a, localResources);
        f3 = a(this.b, localResources);
        this.I.moveTo(f2, f3);
        f2 = this.c;
        f3 = a(this.e, localResources);
        f4 = a(this.D, localResources);
        this.I.quadTo(f3, f4, f2, f1);
        f1 = a(this.E, localResources);
        f2 = a(this.F, localResources);
        f3 = a(this.G, localResources);
        f4 = a(this.H, localResources);
        this.I.quadTo(f3, f4, f1, f2);
      }
      this.I.close();
    }
    a(paramCanvas, this.I, this.K);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i1 = this.h;
    if (i1 < 0) {
      return;
    }
    if (i1 >= 100) {
      return;
    }
    Object localObject = this.ab;
    float f1 = this.k;
    float f2 = this.P;
    float f3 = this.l;
    ((RectF)localObject).set(f1 - f2, f3 - f2, f1 + f2, f3 + f2);
    this.aj.setTextSize(this.aa);
    localObject = this.aj.getFontMetrics();
    f1 = ((Paint.FontMetrics)localObject).top;
    f2 = ((Paint.FontMetrics)localObject).bottom;
    i1 = (int)(this.ab.centerY() - f1 / 2.0F - f2 / 2.0F);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("%");
    paramCanvas.drawText(((StringBuilder)localObject).toString(), this.ab.centerX(), i1, this.aj);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat)
  {
    int i1 = this.h;
    if (i1 < 0)
    {
      super.draw(paramCanvas);
      return;
    }
    if (i1 >= 100) {
      return;
    }
    float f2 = (this.R + this.Q) / 2.0F;
    float f1 = this.P + f2;
    this.ah.setStrokeWidth(f2);
    RectF localRectF = this.ai;
    f2 = this.k;
    float f3 = this.l;
    localRectF.set(f2 - f1, f3 - f1, f2 + f1, f3 + f1);
    paramCanvas.drawArc(this.ai, -90.0F, paramFloat * 360.0F, false, this.ah);
  }
  
  protected void a(Canvas paramCanvas, String paramString)
  {
    Object localObject = this.ab;
    float f1 = this.k;
    float f2 = this.P;
    float f3 = this.l;
    ((RectF)localObject).set(f1 - f2, f3 - f2, f1 + f2, f3 + f2);
    this.aj.setTextSize(a(10.0F, getResources()));
    localObject = this.aj.getFontMetrics();
    f1 = ((Paint.FontMetrics)localObject).top;
    f2 = ((Paint.FontMetrics)localObject).bottom;
    int i1 = (int)(this.ab.centerY() - f1 / 2.0F - f2 / 2.0F);
    paramCanvas.drawText(paramString, this.ab.centerX(), i1, this.aj);
  }
  
  public void a(String paramString)
  {
    RefreshProgressRunnable localRefreshProgressRunnable = MessageProgressController.a().a(paramString);
    if (localRefreshProgressRunnable != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" bind  key=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" animRunnable.mProgress = ");
        localStringBuilder.append(localRefreshProgressRunnable.c);
        QLog.d("MessageProgressView", 2, localStringBuilder.toString());
      }
      localRefreshProgressRunnable.a(this, localRefreshProgressRunnable.c);
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if ((i1 > 0) && (i2 > 0))
    {
      if (this.h < 0) {
        return;
      }
      h(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" stopAnim  key=");
      localStringBuilder.append(paramString);
      QLog.d("MessageProgressView", 2, localStringBuilder.toString());
    }
    MessageProgressController.a().b(paramString);
  }
  
  @TargetApi(11)
  public void c()
  {
    this.m = getResources();
    this.o = new AccelerateDecelerateInterpolator();
    this.P = a(22.0F, getResources());
    this.R = a(2.5F, getResources());
    this.Q = a(5.0F, getResources());
    this.S = a(5.0F, getResources());
    this.T = a(2.5F, getResources());
    this.aa = a(16.0F, getResources());
    this.ah = new Paint();
    this.ah.setStyle(Paint.Style.STROKE);
    this.ah.setColor(-1);
    this.ah.setAntiAlias(true);
    this.ai = new RectF();
    this.aj = new Paint();
    this.aj.setAntiAlias(true);
    this.aj.setTextSize(this.aa);
    this.aj.setColor(this.ac);
    this.aj.setTextAlign(Paint.Align.CENTER);
    this.ak = new Paint();
    this.ak.setStyle(Paint.Style.STROKE);
    this.ak.setColor(-1);
    this.ak.setAntiAlias(true);
    this.al = new Paint();
    this.al.setStyle(Paint.Style.FILL);
    this.al.setColor(-1);
    this.al.setAntiAlias(true);
    this.z = new Path();
    this.am = new Paint();
    this.am.setAntiAlias(true);
    this.am.setFilterBitmap(true);
    this.am.setStyle(Paint.Style.FILL);
    this.I = new Path();
    this.J = new RectF();
    this.K = new Path();
    this.L = new float[8];
    this.C = new Rect();
    this.ab = new RectF();
    this.ae = new RectF();
    this.u = a(this.p, getResources());
    this.v = a(70.0F, getResources());
    setLayerType(1, null);
  }
  
  protected void c(Canvas paramCanvas)
  {
    int i1 = this.h;
    if (i1 < 0) {
      return;
    }
    if (i1 >= 100) {
      return;
    }
    long l1 = this.j;
    float f1 = (float)l1;
    long l2 = this.w;
    float f3 = f1 / (float)l2;
    f1 = this.S;
    float f2 = this.T;
    this.W = (f3 * (f1 - f2) + f2);
    f3 = (float)l1 / (float)l2;
    float f4 = this.Q;
    float f5 = this.R;
    this.V = (f3 * (f4 - f5) + f5);
    f1 = a(f2, f1, this.W);
    f2 = a(this.R, this.Q, this.V);
    this.U = (this.P + f2 / 2.0F);
    this.ah.setStrokeWidth(f1);
    Object localObject2 = null;
    Object localObject1;
    try
    {
      localObject1 = new BlurMaskFilter(f1, BlurMaskFilter.Blur.SOLID);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create BlurMaskFilter exp:");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.e("MessageProgressView", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      this.ah.setMaskFilter((MaskFilter)localObject1);
    }
    paramCanvas.drawCircle(this.k, this.l, this.U, this.ah);
  }
  
  public boolean c(String paramString)
  {
    return MessageProgressController.a().a(paramString) != null;
  }
  
  protected void d()
  {
    if (this.N)
    {
      if (this.M) {
        this.k = (getWidth() / 2.0F - this.u / 2.0F);
      } else {
        this.k = (getWidth() / 2.0F + this.u / 2.0F);
      }
    }
    else {
      this.k = (getWidth() / 2);
    }
    this.l = (getHeight() / 2);
    if (Math.min(getWidth(), getHeight()) < this.v)
    {
      this.P = a(10.0F, getResources());
      this.R = a(1.25F, getResources());
      this.Q = a(2.5F, getResources());
      this.S = a(4.0F, getResources());
      this.T = a(2.0F, getResources());
      this.aa = a(9.0F, getResources());
      float f1 = this.Z;
      if (f1 > 0.0F) {
        this.P = f1;
      }
    }
  }
  
  protected void d(Canvas paramCanvas)
  {
    if ((this.h == 100) && (this.y == 1))
    {
      long l1 = this.j;
      long l2 = this.r;
      if (l1 >= l2)
      {
        long l3 = this.s;
        if (l1 < l3)
        {
          this.ad = (((float)l1 - (float)l2) / (float)(l3 - l2) * 360.0F);
          this.ak.setStrokeWidth(this.Q);
          RectF localRectF = this.ae;
          float f1 = this.k;
          float f2 = this.P;
          float f3 = this.l;
          localRectF.set(f1 - f2, f3 - f2, f1 + f2, f3 + f2);
          paramCanvas.drawArc(this.ae, -90.0F, -this.ad, false, this.ak);
        }
      }
    }
  }
  
  public void e(Canvas paramCanvas)
  {
    if (this.h == 100)
    {
      if (this.y == 1)
      {
        float f3 = this.P * 2.0F / 3.0F;
        float f2 = (float)Math.sqrt(f3 * 5.0F * f3 / 4.0F);
        this.z.reset();
        Path localPath = this.z;
        float f1 = this.k;
        f3 /= 2.0F;
        float f4 = this.l;
        f2 /= 2.0F;
        localPath.moveTo(f1 - f3 + 5.0F, f4 - f2);
        this.z.lineTo(this.k - f3 + 5.0F, this.l + f2);
        this.z.lineTo(this.k + f3 + 5.0F, this.l);
        this.z.close();
        long l1 = this.j;
        long l2 = this.r;
        if (l1 >= l2)
        {
          long l3 = this.s;
          if (l1 < l3)
          {
            this.af = ((1.0F - ((float)l1 - (float)l2) / (float)(l3 - l2)) * this.A);
            this.ag = (((float)l1 - (float)l2) / (float)(l3 - l2) * 1.0F);
            paramCanvas.save();
            paramCanvas.rotate(this.af, this.k, this.l);
            f1 = this.ag;
            paramCanvas.scale(f1, f1, this.k, this.l);
            paramCanvas.drawPath(this.z, this.al);
            paramCanvas.restore();
          }
        }
      }
      if (this.j >= this.s)
      {
        int i1 = this.y;
        if (i1 == 1)
        {
          setDrawStatus(2);
          return;
        }
        if (i1 == 2)
        {
          setDrawStatus(3);
          setImageDrawable(this.x);
        }
      }
    }
  }
  
  public void f(Canvas paramCanvas)
  {
    this.ak.setStrokeWidth(this.Q);
    Object localObject = this.ae;
    float f1 = this.k;
    float f2 = this.P;
    float f3 = this.l;
    ((RectF)localObject).set(f1 - f2, f3 - f2, f1 + f2, f3 + f2);
    paramCanvas.drawArc(this.ae, 0.0F, 360.0F, false, this.ak);
    f3 = this.P * 2.0F / 3.0F;
    f2 = (float)Math.sqrt(f3 * 5.0F * f3 / 4.0F);
    this.z.reset();
    localObject = this.z;
    f1 = this.k;
    f3 /= 2.0F;
    float f4 = this.l;
    f2 /= 2.0F;
    ((Path)localObject).moveTo(f1 - f3 + 5.0F, f4 - f2);
    this.z.lineTo(this.k - f3 + 5.0F, this.l + f2);
    this.z.lineTo(this.k + f3 + 5.0F, this.l);
    this.z.close();
    paramCanvas.drawPath(this.z, this.al);
  }
  
  public void g(Canvas paramCanvas)
  {
    Drawable localDrawable = this.B;
    if (localDrawable != null)
    {
      int i1 = localDrawable.getIntrinsicWidth();
      this.C.set(0, 0, i1, i1);
      float f1;
      if (this.N)
      {
        if (this.M) {
          f1 = (getWidth() - i1) / 2.0F - this.u / 2.0F;
        } else {
          f1 = (getWidth() - i1) / 2.0F + this.u / 2.0F;
        }
      }
      else {
        f1 = (getWidth() - i1) / 2.0F;
      }
      this.C.offset((int)f1, (getHeight() - i1) / 2);
      this.B.setBounds(this.C);
      this.B.draw(paramCanvas);
    }
  }
  
  public int getProgress()
  {
    return this.h;
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    int i1 = this.g;
    if (i1 == 1)
    {
      d();
      b(paramCanvas);
      c(paramCanvas);
      String str = this.i;
      if (str != null) {
        a(paramCanvas, str);
      } else {
        a(paramCanvas);
      }
      d(paramCanvas);
      e(paramCanvas);
      return;
    }
    if (i1 == 2)
    {
      d();
      f(paramCanvas);
      return;
    }
    if (i1 == 3)
    {
      d();
      g(paramCanvas);
    }
  }
  
  public void setAnimProgress(int paramInt, String paramString)
  {
    this.i = null;
    this.h = paramInt;
    if (this.g == 1)
    {
      RefreshProgressRunnable localRefreshProgressRunnable = MessageProgressController.a().a(paramString);
      if (localRefreshProgressRunnable == null)
      {
        localRefreshProgressRunnable = new RefreshProgressRunnable(this, paramString, paramInt);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" setAnimProgress new AnimRunnable key=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" progress=");
          localStringBuilder.append(paramInt);
          QLog.d("MessageProgressView", 2, localStringBuilder.toString());
        }
        MessageProgressController.a().a(paramString, localRefreshProgressRunnable);
        ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
        return;
      }
      localRefreshProgressRunnable.a(this, paramInt);
    }
  }
  
  public void setAnimProgress(String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.h = 0;
    if (this.g == 1)
    {
      RefreshProgressRunnable localRefreshProgressRunnable = MessageProgressController.a().a(paramString2);
      StringBuilder localStringBuilder;
      if (localRefreshProgressRunnable == null)
      {
        localRefreshProgressRunnable = new RefreshProgressRunnable(this, paramString2, this.h);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" setAnimProgress new AnimRunnable key=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" text =");
          localStringBuilder.append(paramString1);
          QLog.d("MessageProgressView", 2, localStringBuilder.toString());
        }
        MessageProgressController.a().a(paramString2, localRefreshProgressRunnable);
        ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" setAnimProgress , animRunnable exist, key=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" text =");
        localStringBuilder.append(paramString1);
        QLog.d("MessageProgressView", 2, localStringBuilder.toString());
      }
      localRefreshProgressRunnable.a(this, this.h);
    }
  }
  
  public void setAnimRunnableListener(MessageProgressView.AnimRunnableListener paramAnimRunnableListener)
  {
    this.n = paramAnimRunnableListener;
  }
  
  public void setBreathingCircleRadius(float paramFloat)
  {
    this.Z = a(paramFloat, getResources());
  }
  
  public void setCornerDirection(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    this.P = a(15.0F, getResources());
    this.R = a(2.0F, getResources());
    this.Q = a(4.0F, getResources());
    this.S = a(5.0F, getResources());
    this.T = a(2.5F, getResources());
    this.aa = a(13.0F, getResources());
  }
  
  public void setDisplayInTextView(int paramInt1, int paramInt2)
  {
    this.aa = paramInt1;
    this.ac = paramInt2;
  }
  
  public void setDrawFinishDefault(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.y = 1;
      return;
    }
    this.y = 0;
  }
  
  public void setDrawFinishDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.y = 2;
      this.x = paramDrawable;
      return;
    }
    this.y = 0;
  }
  
  public void setDrawFinishResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.x = getResources().getDrawable(paramInt);
      if (this.x != null)
      {
        this.y = 2;
        return;
      }
      this.y = 0;
    }
  }
  
  public void setDrawStatus(int paramInt)
  {
    this.g = paramInt;
    if (paramInt != 1) {
      invalidate();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.B = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.B = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setProgressBackgroudColor(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setRadius(float paramFloat, boolean paramBoolean)
  {
    float f1 = paramFloat;
    if (paramBoolean) {
      f1 = a(paramFloat, this.m);
    }
    float[] arrayOfFloat = this.L;
    if (arrayOfFloat != null) {
      Arrays.fill(arrayOfFloat, f1);
    }
  }
  
  public void setSharpCornerCor(float[] paramArrayOfFloat)
  {
    this.a = paramArrayOfFloat[0];
    this.b = paramArrayOfFloat[1];
    this.c = paramArrayOfFloat[2];
    this.d = paramArrayOfFloat[3];
    this.e = paramArrayOfFloat[4];
    this.D = paramArrayOfFloat[5];
    this.E = paramArrayOfFloat[6];
    this.F = paramArrayOfFloat[7];
    this.G = paramArrayOfFloat[8];
    this.H = paramArrayOfFloat[9];
    this.p = Math.abs(this.c - this.E);
    this.u = a(this.p, getResources());
  }
  
  public void setShowCorner(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MessageProgressView
 * JD-Core Version:    0.7.0.1
 */