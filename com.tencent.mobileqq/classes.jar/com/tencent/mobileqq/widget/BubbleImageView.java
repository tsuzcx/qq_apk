package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

public class BubbleImageView
  extends ChatThumbView
{
  public static final float[] d = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  protected static boolean x;
  private float A = 8.0F;
  private float B = 0.0F;
  private float C = 5.0F;
  private float D = 4.0F;
  private float E = 10.0F;
  private float F = 10.0F;
  private float G = 16.0F;
  private float H = 1.0F;
  private float I = 14.0F;
  private Paint J;
  private float K;
  private boolean L = true;
  private boolean M = false;
  private boolean N = false;
  private int O = 1610612736;
  private int P = (int)(Math.random() * 1000.0D);
  private Paint Q;
  private Path R;
  private float a = 14.0F;
  public int e;
  public float f = Math.abs(this.B - this.F);
  Paint g;
  Bitmap h;
  Canvas i;
  Shader j;
  ComposeShader k;
  BitmapShader l;
  Path m;
  Path n;
  RectF o;
  RectF p;
  Paint q;
  float[] r;
  Path s;
  RectF t;
  protected Resources u;
  public boolean v;
  public boolean w;
  protected boolean y = false;
  protected boolean z;
  
  static
  {
    String str = Build.MODEL.toUpperCase();
    boolean bool;
    if ((!str.contains("BV0720")) && (!str.contains("M821")) && ((Build.VERSION.SDK_INT != 21) || ((!str.contains("NX511J")) && (!str.contains("MI 5")) && (!str.contains("GT-I9508")) && (!str.contains("X9077")) && (!str.contains("COOLPAD 8675-A"))))) {
      bool = false;
    } else {
      bool = true;
    }
    x = bool;
  }
  
  public BubbleImageView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    if (this.M)
    {
      if (this.J == null)
      {
        this.J = new Paint();
        this.J.setShader(getShadowMaskShader());
      }
      paramCanvas.drawPaint(this.J);
    }
    if (this.N) {
      paramCanvas.drawColor(this.O);
    }
    a(paramCanvas);
    Paint localPaint = this.Q;
    if (localPaint != null)
    {
      Path localPath = this.R;
      if (localPath != null) {
        paramCanvas.drawPath(localPath, localPaint);
      }
    }
    paramCanvas.restoreToCount(i1);
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if ((i1 > 0) && (i2 > 0))
    {
      localObject = this.h;
      if ((localObject != null) && ((((Bitmap)localObject).getWidth() != i1) || (this.h.getHeight() != i2)))
      {
        this.h = null;
        this.o.setEmpty();
        this.m = null;
        this.p.setEmpty();
        this.n = null;
        this.j = null;
      }
      if (this.h != null) {}
    }
    label141:
    try
    {
      this.h = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label108:
      label123:
      break label108;
    }
    try
    {
      this.h = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label123;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      this.h = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      break label141;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((Canvas)localObject).setBitmap(this.h);
    }
    localObject = this.h;
    if (localObject == null)
    {
      super.draw(paramCanvas);
      return;
    }
    if (this.i == null)
    {
      this.i = new Canvas((Bitmap)localObject);
      this.i.setBitmap(this.h);
    }
    if (this.l == null) {
      this.l = new BitmapShader(this.h, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
    if (this.M)
    {
      if (this.k == null)
      {
        localObject = getShadowMaskShader();
        if (localObject != null) {
          this.k = new ComposeShader(this.l, (Shader)localObject, PorterDuff.Mode.SRC_OVER);
        }
      }
      this.j = this.k;
    }
    else
    {
      this.j = this.l;
    }
    this.g.setShader(this.j);
    super.draw(this.i);
    if (this.N) {
      this.i.drawColor(this.O);
    }
    d(paramCanvas);
    return;
    super.draw(paramCanvas);
  }
  
  private void d(Canvas paramCanvas)
  {
    Object localObject = this.u;
    int i1 = getWidth();
    int i2 = getHeight();
    float f1;
    if (!this.L)
    {
      this.o.set(0.0F, 0.0F, i1, i2);
      localObject = this.o;
      f1 = this.K;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.g);
      return;
    }
    Path localPath;
    float f2;
    if (this.v)
    {
      if (this.o.isEmpty())
      {
        f1 = a(this.f, (Resources)localObject);
        this.o.set(0.0F, 0.0F, i1 - f1, i2);
      }
      if (this.m == null)
      {
        f1 = a(this.C, (Resources)localObject);
        localPath = new Path();
        localPath.moveTo(i1 - a(this.a, (Resources)localObject), a(this.A, (Resources)localObject));
        f2 = i1;
        localPath.quadTo(i1 - a(this.D, (Resources)localObject), a(this.E, (Resources)localObject), f2, f1);
        f1 = i1 - a(this.F, (Resources)localObject);
        f2 = a(this.G, (Resources)localObject);
        localPath.quadTo(i1 - a(this.H, (Resources)localObject), a(this.I, (Resources)localObject), f1, f2);
        localPath.close();
        this.m = localPath;
      }
    }
    else
    {
      if (this.p.isEmpty())
      {
        f1 = a(this.f, (Resources)localObject);
        this.p.set(f1, 0.0F, i1, i2);
      }
      if (this.n == null)
      {
        f1 = a(this.C, (Resources)localObject);
        localPath = new Path();
        localPath.moveTo(a(this.a, (Resources)localObject), a(this.A, (Resources)localObject));
        localPath.quadTo(a(this.D, (Resources)localObject), a(this.E, (Resources)localObject), 0.0F, f1);
        f1 = a(this.F, (Resources)localObject);
        f2 = a(this.G, (Resources)localObject);
        localPath.quadTo(a(this.H, (Resources)localObject), a(this.I, (Resources)localObject), f1, f2);
        localPath.close();
        this.n = localPath;
      }
    }
    if (this.v)
    {
      localObject = this.o;
      f1 = this.K;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.g);
      paramCanvas.drawPath(this.m, this.g);
      localObject = this.Q;
      if (localObject != null) {
        paramCanvas.drawPath(this.m, (Paint)localObject);
      }
    }
    else
    {
      localObject = this.p;
      f1 = this.K;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.g);
      paramCanvas.drawPath(this.n, this.g);
      localObject = this.Q;
      if (localObject != null) {
        paramCanvas.drawPath(this.n, (Paint)localObject);
      }
    }
  }
  
  protected void a() {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.L)
    {
      this.t.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      this.s.reset();
      this.s.addRoundRect(this.t, this.r, Path.Direction.CW);
      if (this.y) {
        this.s.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      }
      localObject = this.R;
      if (localObject != null)
      {
        ((Path)localObject).reset();
        this.R.addRoundRect(this.t, this.r, Path.Direction.CW);
      }
      return;
    }
    Object localObject = this.u;
    float f1 = a(this.f, (Resources)localObject);
    if (this.v) {
      this.t.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
    } else {
      this.t.set(f1, 0.0F, paramFloat1, paramFloat2);
    }
    this.s.reset();
    float f11 = a(this.C, (Resources)localObject);
    Path localPath2;
    Path localPath3;
    int i1;
    if (this.v)
    {
      if (this.y)
      {
        localPath1 = new Path();
        localPath1.addRoundRect(this.t, this.r, Path.Direction.CW);
        localPath1.setFillType(Path.FillType.EVEN_ODD);
        localPath2 = new Path();
        f1 = paramFloat1 - a(this.a, (Resources)localObject);
        f4 = a(this.A, (Resources)localObject);
        localPath2.moveTo(f1, f4);
        f5 = paramFloat1 - a(this.B, (Resources)localObject);
        f7 = paramFloat1 - a(this.D, (Resources)localObject);
        f9 = a(this.E, (Resources)localObject);
        localPath2.quadTo(f7, f9, f5, f11);
        f8 = paramFloat1 - a(this.F, (Resources)localObject);
        f6 = a(this.G, (Resources)localObject);
        f3 = paramFloat1 - a(this.H, (Resources)localObject);
        f2 = a(this.I, (Resources)localObject);
        localPath2.quadTo(f3, f2, f8, f6);
        localPath2.setFillType(Path.FillType.EVEN_ODD);
        localPath3 = new Path();
        i1 = Build.VERSION.SDK_INT;
        if (i1 >= 19) {
          localPath3.op(localPath1, localPath2, Path.Op.UNION);
        }
        localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        this.s = localPath3;
      }
      else
      {
        this.s.addRoundRect(this.t, this.r, Path.Direction.CW);
        f3 = paramFloat1 - a(this.a, (Resources)localObject);
        f4 = a(this.A, (Resources)localObject);
        this.s.moveTo(f3, f4);
        f5 = paramFloat1 - a(this.B, (Resources)localObject);
        f7 = paramFloat1 - a(this.D, (Resources)localObject);
        f9 = a(this.E, (Resources)localObject);
        this.s.quadTo(f7, f9, f5, f11);
        f8 = paramFloat1 - a(this.F, (Resources)localObject);
        f6 = a(this.G, (Resources)localObject);
        f1 = paramFloat1 - a(this.H, (Resources)localObject);
        f2 = a(this.I, (Resources)localObject);
        this.s.quadTo(f1, f2, f8, f6);
        break label1013;
      }
    }
    else
    {
      if (!this.y) {
        break label854;
      }
      localPath1 = new Path();
      localPath1.addRoundRect(this.t, this.r, Path.Direction.CW);
      localPath1.setFillType(Path.FillType.EVEN_ODD);
      localPath2 = new Path();
      f1 = a(this.a, (Resources)localObject);
      f4 = a(this.A, (Resources)localObject);
      localPath2.moveTo(f1, f4);
      f5 = this.B;
      f7 = a(this.D, (Resources)localObject);
      f9 = a(this.E, (Resources)localObject);
      localPath2.quadTo(f7, f9, f5, f11);
      f8 = a(this.F, (Resources)localObject);
      f6 = a(this.G, (Resources)localObject);
      f3 = a(this.H, (Resources)localObject);
      f2 = a(this.I, (Resources)localObject);
      localPath2.quadTo(f3, f2, f8, f6);
      localPath3 = new Path();
      i1 = Build.VERSION.SDK_INT;
      if (i1 >= 19) {
        localPath3.op(localPath1, localPath2, Path.Op.UNION);
      }
      localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      this.s = localPath3;
    }
    float f10 = f1;
    f1 = f3;
    float f3 = f10;
    break label1013;
    label854:
    this.s.addRoundRect(this.t, this.r, Path.Direction.CCW);
    f3 = a(this.a, (Resources)localObject);
    float f4 = a(this.A, (Resources)localObject);
    this.s.moveTo(f3, f4);
    float f5 = this.B;
    float f7 = a(this.D, (Resources)localObject);
    float f9 = a(this.E, (Resources)localObject);
    this.s.quadTo(f7, f9, f5, f11);
    float f8 = a(this.F, (Resources)localObject);
    float f6 = a(this.G, (Resources)localObject);
    f1 = a(this.H, (Resources)localObject);
    float f2 = a(this.I, (Resources)localObject);
    this.s.quadTo(f1, f2, f8, f6);
    label1013:
    this.s.close();
    Path localPath1 = this.R;
    if (localPath1 != null)
    {
      localPath1.reset();
      f10 = this.K * 2.0F;
      float f12;
      float f13;
      if (this.v)
      {
        paramFloat1 = (float)(Math.asin(a(this.G - this.A, (Resources)localObject) / this.r[2]) * 180.0D / 3.141592653589793D);
        this.R.moveTo(f8, f6);
        this.R.lineTo(f8, paramFloat2 - this.K);
        localObject = this.t;
        f12 = f8 - f10;
        f13 = paramFloat2 - f10;
        ((RectF)localObject).set(f12, f13, f8, paramFloat2);
        this.R.arcTo(this.t, 0.0F, 90.0F);
        this.R.lineTo(this.K + 0.0F, paramFloat2);
        this.t.set(0.0F, f13, f10, paramFloat2);
        this.R.arcTo(this.t, 90.0F, 90.0F);
        this.R.lineTo(0.0F, this.K);
        this.t.set(0.0F, 0.0F, f10, f10);
        this.R.arcTo(this.t, 180.0F, 90.0F);
        this.R.lineTo(f8 - this.K, 0.0F);
        this.t.set(f12, 0.0F, f8, f10);
        this.R.arcTo(this.t, 270.0F, 90.0F - paramFloat1);
        this.R.lineTo(f3, f4);
        this.R.quadTo(f7, f9, f5, f11);
        this.R.quadTo(f1, f2, f8, f6);
      }
      else
      {
        f13 = (float)(Math.asin(a(this.G - this.A, (Resources)localObject) / this.r[0]) * 180.0D / 3.141592653589793D);
        this.R.moveTo(f3, f4);
        localObject = this.t;
        f12 = f8 + f10;
        ((RectF)localObject).set(f8, 0.0F, f12, f10);
        this.R.arcTo(this.t, f13 + 180.0F, 90.0F - f13);
        this.R.lineTo(paramFloat1 - this.K, 0.0F);
        localObject = this.t;
        f13 = paramFloat1 - f10;
        ((RectF)localObject).set(f13, 0.0F, paramFloat1, f10);
        this.R.arcTo(this.t, 270.0F, 90.0F);
        this.R.lineTo(paramFloat1, paramFloat2 - this.K);
        localObject = this.t;
        f10 = paramFloat2 - f10;
        ((RectF)localObject).set(f13, f10, paramFloat1, paramFloat2);
        this.R.arcTo(this.t, 0.0F, 90.0F);
        this.R.lineTo(this.K + f8, paramFloat2);
        this.t.set(f8, f10, f12, paramFloat2);
        this.R.arcTo(this.t, 90.0F, 90.0F);
        this.R.lineTo(f8, this.K);
        this.R.lineTo(f8, f6);
        this.R.quadTo(f1, f2, f5, f11);
        this.R.quadTo(f7, f9, f3, f4);
      }
      this.R.close();
    }
  }
  
  public void a(int paramInt)
  {
    setSharpCornerCor(d);
    if ((this.Q == null) || (this.R == null))
    {
      this.Q = new Paint();
      this.Q.setColor(paramInt);
      this.Q.setAntiAlias(true);
      this.Q.setStrokeWidth(Math.max(1, a(0.5F, getResources())));
      this.Q.setStyle(Paint.Style.STROKE);
      this.R = new Path();
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.s, this.q);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean != this.M)
    {
      this.M = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  protected void b()
  {
    this.w = x;
    if (VersionUtils.e()) {
      this.e = 1;
    } else {
      this.e = 2;
    }
    a();
    this.u = getResources();
    int i1 = this.e;
    if (i1 == 1)
    {
      this.q = new Paint();
      this.q.setStyle(Paint.Style.FILL);
      this.q.setAntiAlias(true);
      this.q.setFilterBitmap(true);
      this.q.setColor(-16777216);
      this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.s = new Path();
      this.t = new RectF();
      this.r = new float[8];
      return;
    }
    if (i1 == 2)
    {
      this.g = new Paint();
      this.g.setAntiAlias(true);
      this.g.setFilterBitmap(true);
      this.o = new RectF();
      this.p = new RectF();
      this.s = new Path();
      this.t = new RectF();
      this.r = new float[8];
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.N != paramBoolean)
    {
      this.N = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.L != paramBoolean)
    {
      this.L = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    if (this.z)
    {
      super.draw(paramCanvas);
    }
    else
    {
      int i1 = this.e;
      if (i1 == 1) {
        b(paramCanvas);
      } else if (i1 == 2) {
        c(paramCanvas);
      } else {
        super.draw(paramCanvas);
      }
    }
    l1 = System.currentTimeMillis() - l1;
    boolean bool = false;
    if (VersionUtils.e()) {
      bool = paramCanvas.isHardwareAccelerated();
    }
    if ((QLog.isColorLevel()) && (l1 > 10L))
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("BubbleImageView");
      paramCanvas.append(this.P);
      paramCanvas = paramCanvas.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("draw(): isHardwaveAccelerated= ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", drawMode = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", cost =");
      localStringBuilder.append(l1);
      QLog.w(paramCanvas, 2, localStringBuilder.toString());
    }
  }
  
  public Shader getShadowMaskShader()
  {
    return null;
  }
  
  public void invalidate()
  {
    super.invalidate();
  }
  
  @TargetApi(11)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.w)
    {
      setLayerType(1, null);
      return;
    }
    if ((this.e == 1) && (VersionUtils.e())) {
      setLayerType(2, null);
    }
  }
  
  @TargetApi(11)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.e == 1) && (VersionUtils.e())) {
      setLayerType(0, null);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.e == 1)) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.O = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.K = a(paramFloat, this.u);
    float[] arrayOfFloat = this.r;
    if (arrayOfFloat != null) {
      Arrays.fill(arrayOfFloat, this.K);
    }
  }
  
  public void setRadiusBottom(float paramFloat)
  {
    this.K = a(paramFloat, this.u);
    float[] arrayOfFloat = this.r;
    if (arrayOfFloat != null)
    {
      Arrays.fill(arrayOfFloat, 0, 4, 0.0F);
      Arrays.fill(this.r, 4, 8, this.K);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.K = a(paramFloat, this.u);
    float[] arrayOfFloat = this.r;
    if (arrayOfFloat != null)
    {
      Arrays.fill(arrayOfFloat, 0, 4, this.K);
      Arrays.fill(this.r, 4, 8, 0.0F);
    }
  }
  
  public void setSend(boolean paramBoolean)
  {
    if (this.v != paramBoolean)
    {
      this.v = paramBoolean;
      if ((getWidth() != 0) && (getHeight() != 0)) {
        a(getWidth(), getHeight());
      }
    }
  }
  
  public void setSharpCornerCor(float[] paramArrayOfFloat)
  {
    this.a = paramArrayOfFloat[0];
    this.A = paramArrayOfFloat[1];
    this.B = paramArrayOfFloat[2];
    this.C = paramArrayOfFloat[3];
    this.D = paramArrayOfFloat[4];
    this.E = paramArrayOfFloat[5];
    this.F = paramArrayOfFloat[6];
    this.G = paramArrayOfFloat[7];
    this.H = paramArrayOfFloat[8];
    this.I = paramArrayOfFloat[9];
    this.f = Math.abs(this.B - this.F);
  }
  
  public void setShowEdge(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(Color.parseColor("#14000000"));
      return;
    }
    this.Q = null;
    this.R = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleImageView
 * JD-Core Version:    0.7.0.1
 */