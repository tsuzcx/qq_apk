package com.tencent.viola.ui.view.image;

import android.graphics.drawable.Drawable;

class VImageView2$5
  implements ImageDrawable.OnImageDrawableListener
{
  VImageView2$5(VImageView2 paramVImageView2) {}
  
  public void getDrawable(Drawable paramDrawable, String paramString)
  {
    if (VImageView2.access$300(this.this$0, paramDrawable, paramString)) {
      return;
    }
    VImageView2.access$400(this.this$0, paramDrawable);
    VImageView2.access$000(this.this$0, paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.VImageView2.5
 * JD-Core Version:    0.7.0.1
 */