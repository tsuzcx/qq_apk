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
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import com.tencent.mtt.supportui.utils.CommonTool;

public class ContentDrawable
  extends BaseDrawable
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
    if ((this.mNeedUpdateBorderPath) && (this.mContentBitmap != null))
    {
      if (this.mBorderPath == null) {
        this.mBorderPath = new Path();
      }
      this.mNeedUpdateBorderPath = false;
      if (this.mTempRectForBorderRadius == null) {
        this.mTempRectForBorderRadius = new RectF();
      }
      this.mTempRectForBorderRadius.set(this.mRect);
      int i = this.mContentBitmap.getWidth();
      int j = this.mContentBitmap.getHeight();
      float f1 = this.mRect.width();
      float f2 = this.mRect.height();
      float f3 = i;
      float f4 = f1 / f3;
      float f5 = j;
      float f6 = f2 / f5;
      i = ContentDrawable.1.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[this.mScaleType.ordinal()];
      if ((i != 1) && (i != 2)) {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              if (f4 > f6)
              {
                localObject = this.mTempRectForBorderRadius;
                ((RectF)localObject).top = 0.0F;
                ((RectF)localObject).bottom = f2;
                f2 = f3 * f6;
                ((RectF)localObject).left = ((int)((f1 - f2) / 2.0F));
                ((RectF)localObject).right = ((int)((f1 + f2) / 2.0F));
              }
              else
              {
                localObject = this.mTempRectForBorderRadius;
                f3 = f5 * f4;
                ((RectF)localObject).top = ((int)((f2 - f3) / 2.0F));
                ((RectF)localObject).bottom = ((int)((f2 + f3) / 2.0F));
                ((RectF)localObject).left = 0.0F;
                ((RectF)localObject).right = f1;
              }
            }
          }
          else
          {
            localObject = this.mTempRectForBorderRadius;
            ((RectF)localObject).top = ((f2 - f5) / 2.0F);
            ((RectF)localObject).bottom = ((f2 + f5) / 2.0F);
            ((RectF)localObject).left = ((f1 - f3) / 2.0F);
            ((RectF)localObject).right = ((f1 + f3) / 2.0F);
          }
        }
        else
        {
          localObject = this.mTempRectForBorderRadius;
          ((RectF)localObject).top = 0.0F;
          ((RectF)localObject).bottom = f5;
          ((RectF)localObject).left = 0.0F;
          ((RectF)localObject).right = f3;
        }
      }
      Object localObject = this.mTempRectForBorderRadius;
      ((RectF)localObject).top += this.mImagePositionY;
      localObject = this.mTempRectForBorderRadius;
      ((RectF)localObject).bottom += this.mImagePositionY;
      localObject = this.mTempRectForBorderRadius;
      ((RectF)localObject).left += this.mImagePositionX;
      localObject = this.mTempRectForBorderRadius;
      ((RectF)localObject).right += this.mImagePositionX;
      localObject = this.mBorderWidthArray;
      if (localObject == null) {
        f1 = 0.0F;
      } else {
        f1 = localObject[0];
      }
      if (f1 > 1.0F)
      {
        localObject = this.mTempRectForBorderRadius;
        f1 *= 0.5F;
        ((RectF)localObject).inset(f1, f1);
      }
      if (CommonTool.hasPositiveItem(this.mBorderRadiusArray))
      {
        localObject = this.mBorderRadiusArray;
        f2 = localObject[1];
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (localObject[0] > 0.0F) {
            f1 = localObject[0];
          }
        }
        localObject = this.mBorderRadiusArray;
        f3 = localObject[2];
        f2 = f3;
        if (f3 == 0.0F)
        {
          f2 = f3;
          if (localObject[0] > 0.0F) {
            f2 = localObject[0];
          }
        }
        localObject = this.mBorderRadiusArray;
        f4 = localObject[3];
        f3 = f4;
        if (f4 == 0.0F)
        {
          f3 = f4;
          if (localObject[0] > 0.0F) {
            f3 = localObject[0];
          }
        }
        localObject = this.mBorderRadiusArray;
        f5 = localObject[4];
        f4 = f5;
        if (f5 == 0.0F)
        {
          f4 = f5;
          if (localObject[0] > 0.0F) {
            f4 = localObject[0];
          }
        }
        localObject = this.mBorderPath;
        RectF localRectF = this.mTempRectForBorderRadius;
        Path.Direction localDirection = Path.Direction.CW;
        ((Path)localObject).addRoundRect(localRectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, localDirection);
        return;
      }
      this.mBorderPath.addRect(this.mTempRectForBorderRadius, Path.Direction.CW);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.mContentBitmap;
    if (localObject != null)
    {
      if (((Bitmap)localObject).isRecycled()) {
        return;
      }
      if (this.mPaint == null) {
        this.mPaint = new Paint(1);
      }
      updateContentRegion();
      updatePath();
      if (this.mContentBitmap != null)
      {
        localObject = new Matrix();
        ((Matrix)localObject).reset();
        RectF localRectF = new RectF(this.mRect);
        float[] arrayOfFloat = this.mBorderWidthArray;
        if (arrayOfFloat == null) {
          f1 = 0.0F;
        } else {
          f1 = arrayOfFloat[0];
        }
        if (f1 > 1.0F)
        {
          f1 *= 0.5F;
          localRectF.inset(f1, f1);
        }
        int i = this.mContentBitmap.getWidth();
        int j = this.mContentBitmap.getHeight();
        float f2 = this.mRect.width();
        float f5 = this.mRect.height();
        float f3 = i;
        float f1 = f2 / f3;
        float f6 = j;
        float f4 = f5 / f6;
        switch (ContentDrawable.1.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[this.mScaleType.ordinal()])
        {
        default: 
          break;
        case 6: 
          if (f1 <= f4) {
            f1 = f4;
          }
          f4 = f6 * f1;
          localRectF.top = ((int)((f5 - f4) / 2.0F));
          localRectF.bottom = ((int)((f5 + f4) / 2.0F));
          f1 = f3 * f1;
          break;
        case 5: 
          if (f1 > f4)
          {
            localRectF.top = 0.0F;
            localRectF.bottom = f5;
            f1 = f3 * f4;
            localRectF.left = ((int)((f2 - f1) / 2.0F));
            f1 = (int)((f2 + f1) / 2.0F);
          }
          else
          {
            f1 = f6 * f1;
            localRectF.top = ((int)((f5 - f1) / 2.0F));
            localRectF.bottom = ((int)((f5 + f1) / 2.0F));
            localRectF.left = 0.0F;
            f1 = f2;
          }
          break;
        case 4: 
          localRectF.top = ((f5 - f6) / 2.0F);
          localRectF.bottom = ((f5 + f6) / 2.0F);
          localRectF.left = ((f2 - f3) / 2.0F);
          f1 = (f2 + f3) / 2.0F;
          localRectF.right = f1;
          break;
        case 3: 
          localRectF.top = 0.0F;
          localRectF.bottom = f6;
          localRectF.left = 0.0F;
          f1 = f3;
          localRectF.right = f1;
        }
        localRectF.top += this.mImagePositionY;
        localRectF.bottom += this.mImagePositionY;
        localRectF.left += this.mImagePositionX;
        localRectF.right += this.mImagePositionX;
        ((Matrix)localObject).setRectToRect(new RectF(0.0F, 0.0F, this.mContentBitmap.getWidth(), this.mContentBitmap.getHeight()), localRectF, Matrix.ScaleToFit.FILL);
        this.mPaint.reset();
        this.mPaint.setAlpha(this.mAlpha);
        i = this.mTintColor;
        if (i != 0) {
          this.mPaint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        }
        drawBitmap(paramCanvas, (Matrix)localObject);
      }
    }
  }
  
  protected void drawBitmap(Canvas paramCanvas, Matrix paramMatrix)
  {
    Object localObject = this.mSelfClipPath;
    if (localObject != null) {}
    try
    {
      paramCanvas.clipPath((Path)localObject);
    }
    catch (Throwable localThrowable)
    {
      label18:
      break label18;
    }
    if (this.mScaleType == AsyncImageView.ScaleType.REPEAT)
    {
      paramMatrix = new BitmapShader(this.mContentBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      this.mPaint.setShader(paramMatrix);
      if (this.mBorderPath != null)
      {
        this.mPaint.setAntiAlias(true);
        paramCanvas.drawPath(this.mBorderPath, this.mPaint);
      }
      return;
    }
    if ((!CommonTool.hasPositiveItem(this.mBorderRadiusArray)) && (Build.VERSION.SDK_INT >= 23))
    {
      this.mPaint.setFilterBitmap(true);
      paramCanvas.drawBitmap(this.mContentBitmap, paramMatrix, this.mPaint);
      return;
    }
    localObject = new BitmapShader(this.mContentBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    ((BitmapShader)localObject).setLocalMatrix(paramMatrix);
    this.mPaint.setShader((Shader)localObject);
    if (this.mBorderPath != null)
    {
      this.mPaint.setAntiAlias(true);
      paramCanvas.drawPath(this.mBorderPath, this.mPaint);
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
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    updateContentRegion();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.ContentDrawable
 * JD-Core Version:    0.7.0.1
 */