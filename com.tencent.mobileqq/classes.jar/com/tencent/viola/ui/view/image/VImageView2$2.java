package com.tencent.viola.ui.view.image;

class VImageView2$2
  implements Runnable
{
  VImageView2$2(VImageView2 paramVImageView2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    VImageView2 localVImageView2 = this.this$0;
    float f;
    if (!Float.isNaN(this.val$paddingLeft)) {
      f = this.val$paddingLeft + this.val$actualBorderWidth;
    } else {
      f = this.val$actualBorderWidth;
    }
    int i = Math.round(f);
    if (!Float.isNaN(this.val$paddingTop)) {
      f = this.val$paddingTop + this.val$actualBorderWidth;
    } else {
      f = this.val$actualBorderWidth;
    }
    int j = Math.round(f);
    if (!Float.isNaN(this.val$paddingRight)) {
      f = this.val$paddingRight + this.val$actualBorderWidth;
    } else {
      f = this.val$actualBorderWidth;
    }
    int k = Math.round(f);
    if (!Float.isNaN(this.val$paddingBottom)) {
      f = this.val$paddingBottom + this.val$actualBorderWidth;
    } else {
      f = this.val$actualBorderWidth;
    }
    localVImageView2.setPadding(i, j, k, Math.round(f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.VImageView2.2
 * JD-Core Version:    0.7.0.1
 */