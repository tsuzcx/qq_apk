package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

public class ExifBitmapCreator
  extends BitmapCreatorGetter
  implements BitmapCreator
{
  String path;
  
  public ExifBitmapCreator(String paramString)
  {
    this.path = paramString;
  }
  
  public Bitmap creatBitmap(Bitmap paramBitmap)
  {
    int i = URLDrawableHelper.getExifRotation(this.path);
    if (i == 0) {
      return getBitmap(paramBitmap);
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(i, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if ((localObject == null) || (localObject == paramBitmap)) {
      throw new OutOfMemoryError("OOM");
    }
    paramBitmap.recycle();
    return getBitmap((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator
 * JD-Core Version:    0.7.0.1
 */