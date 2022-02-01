package com.tencent.mobileqq.flashshow.widgets.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.tencent.biz.flashshow.impl.R.styleable;

public class FSRoundImageView
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private int i = -16777216;
  private int j = 0;
  private int k = 0;
  private int l = 255;
  private Bitmap m;
  private Canvas n;
  private float o;
  private float p;
  private ColorFilter q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  
  public FSRoundImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FSRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bg, paramInt, 0);
    this.j = paramContext.getDimensionPixelSize(R.styleable.bj, 0);
    this.i = paramContext.getColor(R.styleable.bh, -16777216);
    this.u = paramContext.getBoolean(R.styleable.bi, false);
    this.k = paramContext.getColor(R.styleable.bk, 0);
    paramContext.recycle();
    a();
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      Bitmap localBitmap;
      if ((paramDrawable instanceof ColorDrawable)) {
        localBitmap = Bitmap.createBitmap(2, 2, b);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b);
      }
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    this.r = true;
    super.setScaleType(a);
    this.f.setAntiAlias(true);
    this.f.setDither(true);
    this.f.setFilterBitmap(true);
    this.f.setAlpha(this.l);
    this.f.setColorFilter(this.q);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.i);
    this.g.setStrokeWidth(this.j);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setAntiAlias(true);
    this.h.setColor(this.k);
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new FSRoundImageView.OutlineProvider(this, null));
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.d.isEmpty()) {
      return true;
    }
    return Math.pow(paramFloat1 - this.d.centerX(), 2.0D) + Math.pow(paramFloat2 - this.d.centerY(), 2.0D) <= Math.pow(this.p, 2.0D);
  }
  
  private void b()
  {
    this.m = a(getDrawable());
    Bitmap localBitmap = this.m;
    if ((localBitmap != null) && (localBitmap.isMutable())) {
      this.n = new Canvas(this.m);
    } else {
      this.n = null;
    }
    if (!this.r) {
      return;
    }
    if (this.m != null)
    {
      e();
      return;
    }
    this.f.setShader(null);
  }
  
  private void c()
  {
    this.d.set(d());
    this.p = Math.min((this.d.height() - this.j) / 2.0F, (this.d.width() - this.j) / 2.0F);
    this.c.set(this.d);
    if (!this.u)
    {
      int i1 = this.j;
      if (i1 > 0) {
        this.c.inset(i1 - 1.0F, i1 - 1.0F);
      }
    }
    this.o = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    e();
  }
  
  private RectF d()
  {
    int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i2 = getHeight() - getPaddingTop() - getPaddingBottom();
    int i3 = Math.min(i1, i2);
    float f1 = getPaddingLeft() + (i1 - i3) / 2.0F;
    float f2 = getPaddingTop() + (i2 - i3) / 2.0F;
    float f3 = i3;
    return new RectF(f1, f2, f1 + f3, f3 + f2);
  }
  
  private void e()
  {
    if (this.m == null) {
      return;
    }
    this.e.set(null);
    int i1 = this.m.getHeight();
    float f1 = this.m.getWidth();
    float f2 = this.c.height();
    float f5 = this.c.width();
    float f4 = i1;
    float f3 = 0.0F;
    if (f2 * f1 > f5 * f4)
    {
      f2 = this.c.height() / f4;
      f1 = (this.c.width() - f1 * f2) * 0.5F;
    }
    else
    {
      f2 = this.c.width() / f1;
      f3 = (this.c.height() - f4 * f2) * 0.5F;
      f1 = 0.0F;
    }
    this.e.setScale(f2, f2);
    this.e.postTranslate((int)(f1 + 0.5F) + this.c.left, (int)(f3 + 0.5F) + this.c.top);
    this.s = true;
  }
  
  public int getBorderColor()
  {
    return this.i;
  }
  
  public int getBorderWidth()
  {
    return this.j;
  }
  
  public int getCircleBackgroundColor()
  {
    return this.k;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.q;
  }
  
  public int getImageAlpha()
  {
    return this.l;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    this.t = true;
    invalidate();
  }
  
  @SuppressLint({"CanvasSize"})
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.v)
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.k != 0) {
      paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.o, this.h);
    }
    if (this.m != null)
    {
      Object localObject;
      if ((this.t) && (this.n != null))
      {
        this.t = false;
        localObject = getDrawable();
        ((Drawable)localObject).setBounds(0, 0, this.n.getWidth(), this.n.getHeight());
        ((Drawable)localObject).draw(this.n);
      }
      if (this.s)
      {
        this.s = false;
        localObject = new BitmapShader(this.m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        ((BitmapShader)localObject).setLocalMatrix(this.e);
        this.f.setShader((Shader)localObject);
      }
      paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.o, this.f);
    }
    if (this.j > 0) {
      paramCanvas.drawCircle(this.d.centerX(), this.d.centerY(), this.p, this.g);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
    invalidate();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.v) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return (a(paramMotionEvent.getX(), paramMotionEvent.getY())) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("adjustViewBounds not supported.");
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    this.g.setColor(paramInt);
    invalidate();
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.u) {
      return;
    }
    this.u = paramBoolean;
    c();
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    this.g.setStrokeWidth(paramInt);
    c();
    invalidate();
  }
  
  public void setCircleBackgroundColor(@ColorInt int paramInt)
  {
    if (paramInt == this.k) {
      return;
    }
    this.k = paramInt;
    this.h.setColor(paramInt);
    invalidate();
  }
  
  @Deprecated
  public void setCircleBackgroundColorResource(@ColorRes int paramInt)
  {
    setCircleBackgroundColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.q) {
      return;
    }
    this.q = paramColorFilter;
    if (this.r)
    {
      this.f.setColorFilter(paramColorFilter);
      invalidate();
    }
  }
  
  public void setDisableCircularTransformation(boolean paramBoolean)
  {
    if (paramBoolean == this.v) {
      return;
    }
    this.v = paramBoolean;
    if (paramBoolean)
    {
      this.m = null;
      this.n = null;
      this.f.setShader(null);
    }
    else
    {
      b();
    }
    invalidate();
  }
  
  public void setImageAlpha(int paramInt)
  {
    paramInt &= 0xFF;
    if (paramInt == this.l) {
      return;
    }
    this.l = paramInt;
    if (this.r)
    {
      this.f.setAlpha(paramInt);
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    b();
    invalidate();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    b();
    invalidate();
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    super.setImageResource(paramInt);
    b();
    invalidate();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    b();
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
    invalidate();
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == a) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSRoundImageView
 * JD-Core Version:    0.7.0.1
 */