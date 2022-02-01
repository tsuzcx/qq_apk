package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;

public class BitmapCreatorGetter
{
  IBitmapCreator nextBitmapCreator;
  
  protected Bitmap getBitmap(Bitmap paramBitmap)
  {
    IBitmapCreator localIBitmapCreator = this.nextBitmapCreator;
    if (localIBitmapCreator == null) {
      return paramBitmap;
    }
    return localIBitmapCreator.creatBitmap(paramBitmap);
  }
  
  public IBitmapCreator getNextBitmapCreator()
  {
    return this.nextBitmapCreator;
  }
  
  public void setNextBitmapCreator(IBitmapCreator paramIBitmapCreator)
  {
    this.nextBitmapCreator = paramIBitmapCreator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.BitmapCreatorGetter
 * JD-Core Version:    0.7.0.1
 */