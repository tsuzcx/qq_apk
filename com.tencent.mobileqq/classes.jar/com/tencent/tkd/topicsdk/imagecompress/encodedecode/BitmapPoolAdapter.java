package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.jetbrains.annotations.NotNull;

public class BitmapPoolAdapter
  implements BitmapPool
{
  @NotNull
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return b(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
  
  @NotNull
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.BitmapPoolAdapter
 * JD-Core Version:    0.7.0.1
 */