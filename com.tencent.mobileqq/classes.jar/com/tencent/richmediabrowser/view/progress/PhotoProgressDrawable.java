package com.tencent.richmediabrowser.view.progress;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class PhotoProgressDrawable
  extends Drawable
{
  private int centerX;
  private int centerY;
  boolean inited = false;
  boolean isDrawText = true;
  Bitmap mBitmap;
  Matrix mMatrix = new Matrix();
  Paint mPaint = new Paint();
  private int mProgress;
  String mProgressText = "0%";
  
  public PhotoProgressDrawable(Bitmap paramBitmap, int paramInt)
  {
    this(paramBitmap, paramInt, true);
  }
  
  public PhotoProgressDrawable(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    this.mBitmap = paramBitmap;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-1);
    this.mPaint.setTextSize(paramInt);
    this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.isDrawText = paramBoolean;
  }
  
  public void disableDrawText()
  {
    this.isDrawText = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    Object localObject = this.mBitmap;
    if (localObject == null) {
      return;
    }
    int i = ((Bitmap)localObject).getWidth() / 2;
    int j = this.mBitmap.getHeight() / 2;
    if (!this.inited)
    {
      this.mMatrix.reset();
      this.mMatrix.postTranslate(this.centerX - i, this.centerY - j);
      this.inited = true;
    }
    this.mMatrix.postRotate(5.0F, this.centerX, this.centerY);
    paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
    if (this.isDrawText)
    {
      double d1;
      double d2;
      float f;
      if (this.mProgress >= 10)
      {
        localObject = this.mProgressText;
        d1 = this.centerX;
        d2 = i;
        Double.isNaN(d2);
        Double.isNaN(d1);
        f = (float)(d1 - d2 * 0.6D);
        d1 = this.centerY;
        d2 = j;
        Double.isNaN(d2);
        Double.isNaN(d1);
        paramCanvas.drawText((String)localObject, f, (float)(d1 + d2 * 0.25D), this.mPaint);
      }
      else
      {
        localObject = this.mProgressText;
        d1 = this.centerX;
        d2 = i;
        Double.isNaN(d2);
        Double.isNaN(d1);
        f = (float)(d1 - d2 * 0.375D);
        d1 = this.centerY;
        d2 = j;
        Double.isNaN(d2);
        Double.isNaN(d1);
        paramCanvas.drawText((String)localObject, f, (float)(d1 + d2 * 0.25D), this.mPaint);
      }
    }
    paramCanvas.restore();
    invalidateSelf();
  }
  
  public void enableDrawText()
  {
    this.isDrawText = true;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    int j = paramInt / 85;
    int i = j;
    if (j > 99) {
      i = 99;
    }
    this.mProgress = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mProgress);
    localStringBuilder.append("%");
    this.mProgressText = localStringBuilder.toString();
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(Rect paramRect)
  {
    this.centerX = paramRect.centerX();
    this.centerY = paramRect.centerY();
    this.inited = false;
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.progress.PhotoProgressDrawable
 * JD-Core Version:    0.7.0.1
 */