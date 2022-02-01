package com.tencent.viola.ui.dom;

import android.graphics.drawable.Drawable;
import com.tencent.viola.ui.view.image.ImageDrawable;
import com.tencent.viola.ui.view.image.ImageDrawable.OnImageDrawableListener;

class VImgSpan$1
  implements ImageDrawable.OnImageDrawableListener
{
  VImgSpan$1(VImgSpan paramVImgSpan) {}
  
  public void getDrawable(Drawable paramDrawable, String paramString)
  {
    paramDrawable = (ImageDrawable)paramDrawable;
    if (!VImgSpan.access$000(this.this$0)) {
      paramDrawable.setCornerRadii(VImgSpan.access$100(this.this$0));
    } else if (VImgSpan.access$200(this.this$0) != 0.0F) {
      paramDrawable.setCornerRadius(VImgSpan.access$200(this.this$0));
    }
    VImgSpan.access$300(this.this$0, paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VImgSpan.1
 * JD-Core Version:    0.7.0.1
 */