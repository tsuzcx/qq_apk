package com.tencent.viola.ui.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

final class ImageDrawable$4
  implements Runnable
{
  ImageDrawable$4(ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    this.val$listener.getDrawable(new BitmapDrawable(this.val$bm), this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.ImageDrawable.4
 * JD-Core Version:    0.7.0.1
 */