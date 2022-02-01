package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.utils.BaseImageUtil;

public class ExifBitmapCreator
  extends BitmapCreatorGetter
  implements IBitmapCreator
{
  String path;
  
  public ExifBitmapCreator(String paramString)
  {
    this.path = paramString;
  }
  
  public Bitmap creatBitmap(Bitmap paramBitmap)
  {
    int i = BaseImageUtil.h(this.path);
    if (i == 0) {
      return getBitmap(paramBitmap);
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(i, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if ((localObject != null) && (localObject != paramBitmap))
    {
      paramBitmap.recycle();
      return getBitmap((Bitmap)localObject);
    }
    throw new OutOfMemoryError("OOM");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator
 * JD-Core Version:    0.7.0.1
 */