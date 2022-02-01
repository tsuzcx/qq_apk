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
    if (this.mBitmap == null) {
      return;
    }
    int i = this.mBitmap.getWidth() / 2;
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
      if (this.mProgress < 10) {
        break label183;
      }
      paramCanvas.drawText(this.mProgressText, (float)(this.centerX - i * 0.6D), (float)(this.centerY + j * 0.25D), this.mPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      invalidateSelf();
      return;
      label183:
      paramCanvas.drawText(this.mProgressText, (float)(this.centerX - i * 0.375D), (float)(this.centerY + j * 0.25D), this.mPaint);
    }
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
    int i = 99;
    int j = paramInt / 85;
    if (j > 99) {}
    for (;;)
    {
      this.mProgress = i;
      this.mProgressText = (this.mProgress + "%");
      return super.onLevelChange(paramInt);
      i = j;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.progress.PhotoProgressDrawable
 * JD-Core Version:    0.7.0.1
 */