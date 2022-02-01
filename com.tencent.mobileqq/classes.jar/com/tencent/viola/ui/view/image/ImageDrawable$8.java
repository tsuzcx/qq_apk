package com.tencent.viola.ui.view.image;

import android.graphics.drawable.Drawable;

class ImageDrawable$8
  implements Runnable
{
  ImageDrawable$8(ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    ImageDrawable.OnImageDrawableListener localOnImageDrawableListener = this.val$listener;
    if (localOnImageDrawableListener != null) {
      localOnImageDrawableListener.getDrawable(this.val$drawable, this.val$url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.ImageDrawable.8
 * JD-Core Version:    0.7.0.1
 */