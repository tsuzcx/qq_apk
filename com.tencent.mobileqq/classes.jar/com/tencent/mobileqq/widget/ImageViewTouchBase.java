package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class ImageViewTouchBase
  extends ImageView
{
  static final float SCALE_RATE = 1.15F;
  private boolean bShadow = false;
  protected Matrix mBaseMatrix = new Matrix();
  protected final RotateBitmap mBitmapDisplayed = new RotateBitmap(null);
  private final Matrix mDisplayMatrix = new Matrix();
  protected Handler mHandler = new Handler();
  private final float[] mMatrixValues = new float[9];
  float mMaxZoom = 3.0F;
  float mMinZoom = 0.5F;
  private Runnable mOnLayoutRunnable = null;
  private ImageViewTouchBase.Recycler mRecycler;
  protected Matrix mSuppMatrix = new Matrix();
  int mThisHeight = -1;
  int mThisWidth = -1;
  private RectF tmpRect = new RectF();
  
  public ImageViewTouchBase(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void getProperBaseMatrix(RotateBitmap paramRotateBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramRotateBitmap.f();
    float f4 = paramRotateBitmap.e();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, 3.0F), Math.min(f2 / f4, 3.0F));
    paramMatrix.postConcat(paramRotateBitmap.c());
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }
  
  private void init()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void setImageBitmap(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Object localObject = getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setDither(true);
    }
    localObject = this.mBitmapDisplayed.b();
    this.mBitmapDisplayed.a(paramBitmap);
    this.mBitmapDisplayed.a(paramInt);
    if ((localObject != null) && (localObject != paramBitmap))
    {
      paramBitmap = this.mRecycler;
      if (paramBitmap != null) {
        paramBitmap.a((Bitmap)localObject);
      }
    }
  }
  
  public void SetMinZoom(float paramFloat)
  {
    this.mMinZoom = paramFloat;
  }
  
  protected void center(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mBitmapDisplayed.b() == null) {
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    float f1 = this.mBitmapDisplayed.b().getWidth();
    float f2 = this.mBitmapDisplayed.b().getHeight();
    float f3 = 0.0F;
    RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
    localMatrix.mapRect(localRectF);
    f1 = localRectF.height();
    float f5 = localRectF.width();
    if (paramBoolean2)
    {
      f2 = getHeight();
      if (f1 < f2) {
        f2 = (f2 - f1) / 2.0F;
      }
      for (f1 = localRectF.top;; f1 = localRectF.bottom)
      {
        f1 = f2 - f1;
        break label169;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label169;
        }
        if (localRectF.bottom >= f2) {
          break;
        }
        f2 = getHeight();
      }
    }
    f1 = 0.0F;
    label169:
    f2 = f3;
    if (paramBoolean1)
    {
      float f4 = getWidth();
      if (f5 < f4)
      {
        f3 = (f4 - f5) / 2.0F;
        f2 = localRectF.left;
      }
      for (;;)
      {
        f2 = f3 - f2;
        break;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
          break;
        }
        f2 = f3;
        if (localRectF.right >= f4) {
          break;
        }
        f2 = localRectF.right;
        f3 = f4;
      }
    }
    postTranslate(f2, f1);
    setImageMatrix(getImageViewMatrix());
  }
  
  public void clear()
  {
    setImageBitmapResetBase(null, true);
  }
  
  public RectF getDisplayRect()
  {
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    if (this.mBitmapDisplayed.b() != null) {
      localRectF.set(0.0F, 0.0F, this.mBitmapDisplayed.b().getWidth(), this.mBitmapDisplayed.b().getHeight());
    }
    localMatrix.mapRect(localRectF);
    return localRectF;
  }
  
  public int getImageHeight()
  {
    return this.mBitmapDisplayed.b().getHeight();
  }
  
  protected Matrix getImageViewMatrix()
  {
    this.mDisplayMatrix.set(this.mBaseMatrix);
    this.mDisplayMatrix.postConcat(this.mSuppMatrix);
    return this.mDisplayMatrix;
  }
  
  public int getImageWidth()
  {
    return this.mBitmapDisplayed.b().getWidth();
  }
  
  public float getMaxZoom()
  {
    return this.mMaxZoom;
  }
  
  public RotateBitmap getRotateBitmap()
  {
    return this.mBitmapDisplayed;
  }
  
  public float getScale()
  {
    return getScale(this.mSuppMatrix);
  }
  
  protected float getScale(Matrix paramMatrix)
  {
    return getValue(paramMatrix, 0);
  }
  
  protected RectF getShownRect()
  {
    return this.tmpRect;
  }
  
  protected float getValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[paramInt];
  }
  
  protected float maxZoom()
  {
    if (this.mBitmapDisplayed.b() == null) {
      return 1.0F;
    }
    float f2 = Math.max(this.mBitmapDisplayed.f() / this.mThisWidth, this.mBitmapDisplayed.e() / this.mThisHeight) * 4.0F;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 3.0F;
    }
    return f1;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      if ((this.mBitmapDisplayed != null) && (this.mBitmapDisplayed.b() != null))
      {
        Paint localPaint = new Paint();
        Object localObject = getImageViewMatrix();
        this.tmpRect.set(0.0F, 0.0F, this.mBitmapDisplayed.b().getWidth(), this.mBitmapDisplayed.b().getHeight());
        ((Matrix)localObject).mapRect(this.tmpRect);
        if (this.bShadow)
        {
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setStrokeWidth(1.0F);
          int j = -14606047;
          localObject = this.tmpRect;
          ((RectF)localObject).right -= 1.0F;
          int i = 0;
          while (i < 5)
          {
            localObject = this.tmpRect;
            ((RectF)localObject).left -= 1.0F;
            localObject = this.tmpRect;
            ((RectF)localObject).top -= 1.0F;
            localObject = this.tmpRect;
            ((RectF)localObject).right += 1.0F;
            localObject = this.tmpRect;
            ((RectF)localObject).bottom += 1.0F;
            localPaint.setColor(j);
            localObject = this.tmpRect;
            float f = i;
            paramCanvas.drawRoundRect((RectF)localObject, f, f, localPaint);
            int k = 5 - i;
            j += (k | k << 16 | k << 8);
            i += 1;
          }
        }
      }
      return;
    }
    catch (RuntimeException paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (getScale() > 1.0F))
    {
      zoomTo(1.0F);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mThisWidth = (paramInt3 - paramInt1);
    this.mThisHeight = (paramInt4 - paramInt2);
    Runnable localRunnable = this.mOnLayoutRunnable;
    if (localRunnable != null)
    {
      this.mOnLayoutRunnable = null;
      localRunnable.run();
    }
    if (this.mBitmapDisplayed.b() != null)
    {
      getProperBaseMatrix(this.mBitmapDisplayed, this.mBaseMatrix);
      setImageMatrix(getImageViewMatrix());
    }
  }
  
  public void panBy(float paramFloat1, float paramFloat2)
  {
    postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
  }
  
  protected void postTranslate(float paramFloat1, float paramFloat2)
  {
    this.mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap, 0);
  }
  
  public void setImageBitmapResetBase(Bitmap paramBitmap, boolean paramBoolean)
  {
    setImageRotateBitmapResetBase(new RotateBitmap(paramBitmap), paramBoolean);
  }
  
  public void setImageRotateBitmapResetBase(RotateBitmap paramRotateBitmap, boolean paramBoolean)
  {
    if (getWidth() <= 0)
    {
      this.mOnLayoutRunnable = new ImageViewTouchBase.1(this, paramRotateBitmap, paramBoolean);
      return;
    }
    if (paramRotateBitmap.b() != null)
    {
      getProperBaseMatrix(paramRotateBitmap, this.mBaseMatrix);
      setImageBitmap(paramRotateBitmap.b(), paramRotateBitmap.a());
    }
    else
    {
      this.mBaseMatrix.reset();
      setImageBitmap(null);
    }
    if (paramBoolean) {
      this.mSuppMatrix.reset();
    }
    setImageMatrix(getImageViewMatrix());
    this.mMaxZoom = maxZoom();
  }
  
  public void setRecycler(ImageViewTouchBase.Recycler paramRecycler)
  {
    this.mRecycler = paramRecycler;
  }
  
  public void setShadow(boolean paramBoolean)
  {
    this.bShadow = paramBoolean;
  }
  
  public float zoomBy(float paramFloat)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    this.mSuppMatrix.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    center(true, true);
    return getScale();
  }
  
  public void zoomIn()
  {
    zoomIn(1.15F);
  }
  
  protected void zoomIn(float paramFloat)
  {
    if (getScale() >= this.mMaxZoom) {
      return;
    }
    if (this.mBitmapDisplayed.b() == null) {
      return;
    }
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    this.mSuppMatrix.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    center(true, true);
  }
  
  public void zoomOut()
  {
    zoomOut(1.15F);
  }
  
  protected void zoomOut(float paramFloat)
  {
    if (this.mBitmapDisplayed.b() == null) {
      return;
    }
    float f1 = paramFloat;
    if (getScale() / paramFloat < this.mMinZoom) {
      f1 = getScale() / this.mMinZoom;
    }
    paramFloat = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    Matrix localMatrix = new Matrix(this.mSuppMatrix);
    f1 = 1.0F / f1;
    localMatrix.postScale(f1, f1, paramFloat, f2);
    if (getScale(localMatrix) > 0.5F) {
      this.mSuppMatrix.postScale(f1, f1, paramFloat, f2);
    }
    setImageMatrix(getImageViewMatrix());
    center(true, true);
  }
  
  public float zoomTo(float paramFloat)
  {
    return zoomTo(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }
  
  protected float zoomTo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = this.mMaxZoom;
    if (paramFloat1 > f)
    {
      paramFloat1 = f;
    }
    else
    {
      f = this.mMinZoom;
      if (paramFloat1 < f) {
        paramFloat1 = f;
      }
    }
    f = paramFloat1 / getScale();
    this.mSuppMatrix.postScale(f, f, paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
    center(true, true);
    return paramFloat1;
  }
  
  protected void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = (paramFloat1 - getScale()) / paramFloat4;
    float f = getScale();
    long l = System.currentTimeMillis();
    this.mHandler.post(new ImageViewTouchBase.2(this, paramFloat4, l, f, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void zoomToPoint(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    panBy(f1 - paramFloat2, f2 - paramFloat3);
    zoomTo(paramFloat1, f1, f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageViewTouchBase
 * JD-Core Version:    0.7.0.1
 */