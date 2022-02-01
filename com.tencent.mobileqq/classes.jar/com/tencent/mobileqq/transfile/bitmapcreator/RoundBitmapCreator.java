package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import bheg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;

public class RoundBitmapCreator
  implements BitmapCreator
{
  boolean isMixed;
  
  public RoundBitmapCreator(boolean paramBoolean)
  {
    this.isMixed = paramBoolean;
  }
  
  public Bitmap creatBitmap(Bitmap paramBitmap)
  {
    int i = Math.max(0, Math.max(paramBitmap.getHeight(), paramBitmap.getWidth()));
    if (this.isMixed) {}
    for (float f = 0.0F;; f = AbstractImageDownloader.getRoundRadius(BaseApplicationImpl.getApplication(), i))
    {
      Bitmap localBitmap = bheg.a(paramBitmap, f);
      paramBitmap.recycle();
      return localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.RoundBitmapCreator
 * JD-Core Version:    0.7.0.1
 */