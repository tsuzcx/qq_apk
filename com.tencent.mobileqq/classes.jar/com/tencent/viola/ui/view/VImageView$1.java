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
      Object localObject = this.this$0;
      ((VImageView)localObject).isBitmapReleased = true;
      localObject = ((VImageView)localObject).getComponent();
      if (localObject != null) {
        ((VImage)localObject).autoReleaseImage();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView.1
 * JD-Core Version:    0.7.0.1
 */