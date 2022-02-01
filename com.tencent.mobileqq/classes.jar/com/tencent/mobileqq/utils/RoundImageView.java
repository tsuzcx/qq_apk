package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class RoundImageView
  extends URLImageView
{
  private static final ImageView.ScaleType b = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config c = Bitmap.Config.ARGB_8888;
  String a;
  private final RectF d = new RectF();
  private final RectF e = new RectF();
  private final Matrix f = new Matrix();
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private int i = -16777216;
  private int j = 0;
  private Bitmap k;
  private BitmapShader l;
  private int m;
  private int n;
  private float o;
  private float p;
  private boolean q;
  private boolean r;
  
  public RoundImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
        localBitmap = Bitmap.createBitmap(1, 1, c);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), c);
      }
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  private void b()
  {
    if (!this.q)
    {
      this.r = true;
      return;
    }
    Object localObject = this.k;
    if (localObject == null) {
      return;
    }
    this.l = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.g.setAntiAlias(true);
    this.g.setShader(this.l);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setAntiAlias(true);
    this.h.setColor(this.i);
    this.h.setStrokeWidth(this.j);
    this.n = this.k.getHeight();
    this.m = this.k.getWidth();
    this.e.set(0.0F, 0.0F, getWidth(), getHeight());
    this.p = Math.min((this.e.height() - this.j) / 2.0F, (this.e.width() - this.j) / 2.0F);
    localObject = this.d;
    int i1 = this.j;
    ((RectF)localObject).set(i1, i1, this.e.width() - this.j, this.e.height() - this.j);
    this.o = Math.min(this.d.height() / 2.0F, this.d.width() / 2.0F);
    c();
    invalidate();
  }
  
  private void c()
  {
    this.f.set(null);
    float f1 = this.m;
    float f2 = this.d.height();
    float f4 = this.d.width();
    float f5 = this.n;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.d.height() / this.n;
      f2 = (this.d.width() - this.m * f1) * 0.5F;
    }
    else
    {
      f1 = this.d.width() / this.m;
      f3 = (this.d.height() - this.n * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.f.setScale(f1, f1);
    Matrix localMatrix = this.f;
    int i1 = (int)(f2 + 0.5F);
    int i2 = this.j;
    localMatrix.postTranslate(i1 + i2, (int)(f3 + 0.5F) + i2);
    this.l.setLocalMatrix(this.f);
  }
  
  public void a()
  {
    this.q = true;
    if (this.r)
    {
      b();
      this.r = false;
    }
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o, this.g);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.p, this.h);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 4, "onLoadSuccessed");
    }
    setImageDrawable(paramURLDrawable);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.k = paramBitmap;
    b();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.k = a(paramDrawable);
    b();
  }
  
  public void setImageFilePath(String paramString)
  {
    String str = this.a;
    if ((str != null) && (str.equals(paramString))) {
      return;
    }
    try
    {
      setImageBitmap(BitmapFactory.decodeFile(paramString));
      this.a = paramString;
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("RoundImageView", 1, "setImageFilePath oom", paramString);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.k = a(getDrawable());
    b();
  }
  
  public void setIsready()
  {
    this.q = true;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == b) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RoundImageView
 * JD-Core Version:    0.7.0.1
 */