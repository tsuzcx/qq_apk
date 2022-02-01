package com.tencent.mobileqq.transfile.filebrowser;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class FastBitmapDrawable
  extends Drawable
{
  private Bitmap mBitmap;
  
  public FastBitmapDrawable(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.FastBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */