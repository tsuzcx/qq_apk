package com.tencent.mobileqq.kandian.base.imagecrop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.kandian.base.imagecrop.model.ExifInfo;
import com.tencent.mobileqq.kandian.base.imagecrop.util.RectUtils;

public class TransformImageView
  extends ImageView
{
  protected final float[] a = new float[8];
  protected final float[] b = new float[2];
  protected Matrix c = new Matrix();
  protected float d;
  protected float e;
  protected int f;
  protected int g;
  protected TransformImageView.TransformImageListener h;
  protected boolean i = false;
  protected boolean j = false;
  private final float[] k = new float[9];
  private float[] l;
  private float[] m;
  private int n = 0;
  private String o;
  private String p;
  private ExifInfo q;
  
  public TransformImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void a()
  {
    this.c.mapPoints(this.a, this.l);
    this.c.mapPoints(this.b, this.m);
  }
  
  public float a(@NonNull Matrix paramMatrix)
  {
    return (float)Math.sqrt(Math.pow(a(paramMatrix, 0), 2.0D) + Math.pow(a(paramMatrix, 3), 2.0D));
  }
  
  protected float a(@NonNull Matrix paramMatrix, @IntRange(from=0L, to=9L) int paramInt)
  {
    paramMatrix.getValues(this.k);
    return this.k[paramInt];
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.c.postTranslate(paramFloat1, paramFloat2);
      setImageMatrix(this.c);
    }
  }
  
  public float b(@NonNull Matrix paramMatrix)
  {
    return (float)-(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  protected void b()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    float f1 = ((Drawable)localObject).getIntrinsicWidth();
    float f2 = ((Drawable)localObject).getIntrinsicHeight();
    Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[] { Integer.valueOf((int)f1), Integer.valueOf((int)f2) }));
    localObject = new RectF(0.0F, 0.0F, f1, f2);
    this.l = RectUtils.a((RectF)localObject);
    this.m = RectUtils.b((RectF)localObject);
    this.j = true;
    localObject = this.h;
    if (localObject != null) {
      ((TransformImageView.TransformImageListener)localObject).a();
    }
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.d = paramFloat2;
      this.e = paramFloat3;
      this.c.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.c);
      TransformImageView.TransformImageListener localTransformImageListener = this.h;
      if (localTransformImageListener != null) {
        localTransformImageListener.b(a(this.c));
      }
    }
  }
  
  protected void d()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public float getCurrentAngle()
  {
    return b(this.c);
  }
  
  public float getCurrentScale()
  {
    return a(this.c);
  }
  
  public ExifInfo getExifInfo()
  {
    return this.q;
  }
  
  public String getImageInputPath()
  {
    return this.o;
  }
  
  public String getImageOutputPath()
  {
    return this.p;
  }
  
  public int getMaxBitmapSize()
  {
    return this.n;
  }
  
  @Nullable
  public Bitmap getViewBitmap()
  {
    if (getDrawable() == null) {
      return null;
    }
    if ((getDrawable() instanceof FastBitmapDrawable)) {
      return ((FastBitmapDrawable)getDrawable()).a();
    }
    if ((getDrawable() instanceof BitmapDrawable)) {
      return ((BitmapDrawable)getDrawable()).getBitmap();
    }
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || ((this.i) && (!this.j)))
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i1 = getHeight();
      int i2 = getPaddingBottom();
      this.f = (paramInt3 - paramInt4 - paramInt1);
      this.g = (i1 - i2 - paramInt2);
      b();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new FastBitmapDrawable(paramBitmap));
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
    this.c.set(paramMatrix);
    a();
  }
  
  public void setMaxBitmapSize(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      super.setScaleType(paramScaleType);
      return;
    }
    Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
  }
  
  public void setTransformImageListener(TransformImageView.TransformImageListener paramTransformImageListener)
  {
    this.h = paramTransformImageListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.TransformImageView
 * JD-Core Version:    0.7.0.1
 */