package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.view.View;

class PTSNodeImage$1$1
  implements Runnable
{
  PTSNodeImage$1$1(PTSNodeImage.1 param1, String paramString) {}
  
  public void run()
  {
    View localView = this.this$1.this$0.getView();
    if (localView != null) {
      ((PTSImageView)localView).setImageSrc(this.val$imageUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeImage.1.1
 * JD-Core Version:    0.7.0.1
 */