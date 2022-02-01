package com.tencent.viola.ui.view.image;

class VImageView2$2
  implements Runnable
{
  VImageView2$2(VImageView2 paramVImageView2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    VImageView2 localVImageView2 = this.this$0;
    int i;
    label51:
    int j;
    label76:
    int k;
    if (!Float.isNaN(this.val$paddingLeft))
    {
      f = this.val$paddingLeft + this.val$actualBorderWidth;
      i = Math.round(f);
      if (Float.isNaN(this.val$paddingTop)) {
        break label124;
      }
      f = this.val$paddingTop + this.val$actualBorderWidth;
      j = Math.round(f);
      if (Float.isNaN(this.val$paddingRight)) {
        break label132;
      }
      f = this.val$paddingRight + this.val$actualBorderWidth;
      k = Math.round(f);
      if (Float.isNaN(this.val$paddingBottom)) {
        break label140;
      }
    }
    label132:
    label140:
    for (float f = this.val$paddingBottom + this.val$actualBorderWidth;; f = this.val$actualBorderWidth)
    {
      localVImageView2.setPadding(i, j, k, Math.round(f));
      return;
      f = this.val$actualBorderWidth;
      break;
      label124:
      f = this.val$actualBorderWidth;
      break label51;
      f = this.val$actualBorderWidth;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.VImageView2.2
 * JD-Core Version:    0.7.0.1
 */