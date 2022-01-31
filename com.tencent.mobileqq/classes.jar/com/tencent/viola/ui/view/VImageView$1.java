package com.tencent.viola.ui.view;

import com.tencent.viola.ui.component.VImage;

class VImageView$1
  implements Runnable
{
  VImageView$1(VImageView paramVImageView) {}
  
  public void run()
  {
    if ((this.this$0.enableBitmapAutoManage) && (!this.this$0.isBitmapReleased))
    {
      this.this$0.isBitmapReleased = true;
      VImage localVImage = this.this$0.getComponent();
      if (localVImage != null) {
        localVImage.autoReleaseImage();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView.1
 * JD-Core Version:    0.7.0.1
 */