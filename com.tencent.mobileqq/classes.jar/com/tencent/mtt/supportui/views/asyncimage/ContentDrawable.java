package com.tencent.mtt.supportui.views.asyncimage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.mtt.supportui.utils.CommonTool;

public class ContentDrawable
  extends Drawable
{
  protected int mAlpha = 255;
  private Path mBorderPath;
  private float[] mBorderRadiusArray;
  private float[] mBorderWidthArray;
  protected Bitmap mContentBitmap;
  private int mImagePositionX;
  private int mImagePositionY;
  private boolean mNeedUpdateBorderPath = true;
  protected Paint mPaint;
  protected AsyncImageView.ScaleType mScaleType = AsyncImageView.ScaleType.FIT_XY;
  public Path mSelfClipPath = null;
  private RectF mTempRectForBorderRadius;
  protected int mTintColor;
  
  private void updatePath()
  {
    int i;
    int j;
    int k;
    int m;
    float f2;
    Object localObject;
    if ((this.mNeedUpdateBorderPath) && (this.mContentBitmap != null))
    {
      if (this.mBorderPath == null) {
        this.mBorderPath = new Path();
      }
      this.mNeedUpdateBorderPath = false;
      if (this.mTempRectForBorderRadius == null) {
        this.mTempRectForBorderRadius = new RectF();
      }
      this.mTempRectForBorderRadius.set(getBounds());
      i = this.mContentBitmap.getWidth();
      j = this.mContentBitmap.getHeight();
      k = getBounds().width();
      m = getBounds().height();
      f1 = k / i;
      f2 = m / j;
      switch (ContentDrawable.1.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[this.mScaleType.ordinal()])
      {
      case 1: 
      case 2: 
      default: 
        localObject = this.mTempRectForBorderRadius;
        ((RectF)localObject).top += this.mImagePositionY;
        localObject = this.mTempRectForBorderRadius;
        ((RectF)localObject).bottom += this.mImagePositionY;
        localObject = this.mTempRectForBorderRadius;
        ((RectF)localObject).left += this.mImagePositionX;
        localObject = this.mTempRectForBorderRadius;
        ((RectF)localObject).right += this.mImagePositionX;
        if (this.mBorderWidthArray != null) {
          break;
        }
      }
    }
    for (float f1 = 0.0F;; f1 = this.mBorderWidthArray[0])
    {
      if (f1 > 1.0F) {
        this.mTempRectForBorderRadius.inset(f1 * 0.5F, f1 * 0.5F);
      }
      if (!CommonTool.hasPositiveItem(this.mBorderRadiusArray)) {
        break label762;
      }
      f2 = this.mBorderRadiusArray[1];
      f1 = f2;
      if (f2 == 0.0F)
      {
        f1 = f2;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f1 = this.mBorderRadiusArray[0];
        }
      }
      float f3 = this.mBorderRadiusArray[2];
      f2 = f3;
      if (f3 == 0.0F)
      {
        f2 = f3;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f2 = this.mBorderRadiusArray[0];
        }
      }
      float f4 = this.mBorderRadiusArray[3];
      f3 = f4;
      if (f4 == 0.0F)
      {
        f3 = f4;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f3 = this.mBorderRadiusArray[0];
        }
      }
      float f5 = this.mBorderRadiusArray[4];
      f4 = f5;
      if (f5 == 0.0F)
      {
        f4 = f5;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f4 = this.mBorderRadiusArray[0];
        }
      }
      localObject = this.mBorderPath;
      RectF localRectF = this.mTempRectForBorderRadius;
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject).addRoundRect(localRectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, localDirection);
      return;
      this.mTempRectForBorderRadius.top = 0.0F;
      this.mTempRectForBorderRadius.bottom = j;
      this.mTempRectForBorderRadius.left = 0.0F;
      this.mTempRectForBorderRadius.right = i;
      break;
      this.mTempRectForBorderRadius.top = ((m - j) / 2);
      this.mTempRectForBorderRadius.bottom = ((j + m) / 2);
      this.mTempRectForBorderRadius.left = ((k - i) / 2);
      this.mTempRectForBorderRadius.right = ((i + k) / 2);
      break;
      if (f1 > f2)
      {
        this.mTempRectForBorderRadius.top = 0.0F;
        this.mTempRectForBorderRadius.bottom = m;
        this.mTempRectForBorderRadius.left = ((int)((k - i * f2) / 2.0F));
        localObject = this.mTempRectForBorderRadius;
        f1 = k;
        ((RectF)localObject).right = ((int)((i * f2 + f1) / 2.0F));
        break;
      }
      this.mTempRectForBorderRadius.top = ((int)((m - j * f1) / 2.0F));
      localObject = this.mTempRectForBorderRadius;
      f2 = m;
      ((RectF)localObject).bottom = ((int)((j * f1 + f2) / 2.0F));
      this.mTempRectForBorderRadius.left = 0.0F;
      this.mTempRectForBorderRadius.right = k;
      break;
    }
    label762:
    this.mBorderPath.addRect(this.mTempRectForBorderRadius, Path.Direction.CW);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mContentBitmap == null) || (this.mContentBitmap.isRecycled())) {}
    do
    {
      return;
      if (this.mPaint == null) {
        this.mPaint = new Paint(1);
      }
      updatePath();
    } while (this.mContentBitmap == null);
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    RectF localRectF = new RectF(0.0F, 0.0F, getBounds().width(), getBounds().height());
    float f1;
    int i;
    int j;
    int k;
    int m;
    float f2;
    if (this.mBorderWidthArray == null)
    {
      f1 = 0.0F;
      if (f1 > 1.0F) {
        localRectF.inset(f1 * 0.5F, f1 * 0.5F);
      }
      i = this.mContentBitmap.getWidth();
      j = this.mContentBitmap.getHeight();
      k = getBounds().width();
      m = getBounds().height();
      f1 = k / i;
      f2 = m / j;
    }
    switch (ContentDrawable.1.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[this.mScaleType.ordinal()])
    {
    case 1: 
    case 2: 
    default: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        localRectF.top += this.mImagePositionY;
        localRectF.bottom += this.mImagePositionY;
        localRectF.left += this.mImagePositionX;
        localRectF.right += this.mImagePositionX;
        localMatrix.setRectToRect(new RectF(0.0F, 0.0F, this.mContentBitmap.getWidth(), this.mContentBitmap.getHeight()), localRectF, Matrix.ScaleToFit.FILL);
        this.mPaint.reset();
        this.mPaint.setAlpha(this.mAlpha);
        if (this.mTintColor != 0) {
          this.mPaint.setColorFilter(new PorterDuffColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP));
        }
        drawBitmap(paramCanvas, localMatrix);
        return;
        f1 = this.mBorderWidthArray[0];
        break;
        localRectF.top = 0.0F;
        localRectF.bottom = j;
        localRectF.left = 0.0F;
        localRectF.right = i;
        continue;
        localRectF.top = ((m - j) / 2);
        localRectF.bottom = ((m + j) / 2);
        localRectF.left = ((k - i) / 2);
        localRectF.right = ((k + i) / 2);
        continue;
        if (f1 > f2)
        {
          localRectF.top = 0.0F;
          localRectF.bottom = m;
          localRectF.left = ((int)((k - i * f2) / 2.0F));
          localRectF.right = ((int)((k + f2 * i) / 2.0F));
        }
        else
        {
          localRectF.top = ((int)((m - j * f1) / 2.0F));
          f2 = m;
          localRectF.bottom = ((int)((f1 * j + f2) / 2.0F));
          localRectF.left = 0.0F;
          localRectF.right = k;
        }
      }
    }
    if (f1 > f2) {}
    for (;;)
    {
      localRectF.top = ((int)((m - j * f1) / 2.0F));
      localRectF.bottom = ((int)((m + j * f1) / 2.0F));
      localRectF.left = ((int)((k - i * f1) / 2.0F));
      f2 = k;
      localRectF.right = ((int)((f1 * i + f2) / 2.0F));
      break;
      f1 = f2;
    }
  }
  
  protected void drawBitmap(Canvas paramCanvas, Matrix paramMatrix)
  {
    if (this.mSelfClipPath != null) {}
    try
    {
      paramCanvas.clipPath(this.mSelfClipPath);
      label16:
      if (this.mScaleType == AsyncImageView.ScaleType.REPEAT)
      {
        paramMatrix = new BitmapShader(this.mContentBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.mPaint.setShader(paramMatrix);
        if (this.mBorderPath != null)
        {
          this.mPaint.setAntiAlias(true);
          paramCanvas.drawPath(this.mBorderPath, this.mPaint);
        }
      }
      do
      {
        return;
        if ((!CommonTool.hasPositiveItem(this.mBorderRadiusArray)) && (Build.VERSION.SDK_INT >= 23)) {
          break;
        }
        BitmapShader localBitmapShader = new BitmapShader(this.mContentBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        localBitmapShader.setLocalMatrix(paramMatrix);
        this.mPaint.setShader(localBitmapShader);
      } while (this.mBorderPath == null);
      this.mPaint.setAntiAlias(true);
      paramCanvas.drawPath(this.mBorderPath, this.mPaint);
      return;
      this.mPaint.setFilterBitmap(true);
      paramCanvas.drawBitmap(this.mContentBitmap, paramMatrix, this.mPaint);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label16;
    }
  }
  
  public int getAlphaValue()
  {
    return this.mAlpha;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mNeedUpdateBorderPath = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    invalidateSelf();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mContentBitmap = paramBitmap;
  }
  
  public void setBorder(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.mBorderWidthArray = paramArrayOfFloat2;
    this.mBorderRadiusArray = paramArrayOfFloat1;
    this.mNeedUpdateBorderPath = true;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setImagePositionX(int paramInt)
  {
    this.mImagePositionX = paramInt;
  }
  
  public void setImagePositionY(int paramInt)
  {
    this.mImagePositionY = paramInt;
  }
  
  public void setScaleType(AsyncImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != null) {
      this.mScaleType = paramScaleType;
    }
  }
  
  public void setTintColor(int paramInt)
  {
    this.mTintColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.ContentDrawable
 * JD-Core Version:    0.7.0.1
 */