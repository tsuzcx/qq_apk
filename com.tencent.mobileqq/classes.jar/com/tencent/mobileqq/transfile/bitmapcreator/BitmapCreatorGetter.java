package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;

public class BitmapCreatorGetter
{
  BitmapCreator nextBitmapCreator;
  
  protected Bitmap getBitmap(Bitmap paramBitmap)
  {
    if (this.nextBitmapCreator == null) {
      return paramBitmap;
    }
    return this.nextBitmapCreator.creatBitmap(paramBitmap);
  }
  
  public BitmapCreator getNextBitmapCreator()
  {
    return this.nextBitmapCreator;
  }
  
  public void setNextBitmapCreator(BitmapCreator paramBitmapCreator)
  {
    this.nextBitmapCreator = paramBitmapCreator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.BitmapCreatorGetter
 * JD-Core Version:    0.7.0.1
 */