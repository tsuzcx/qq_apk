package com.tencent.viola.ui.component.image;

import android.view.View;
import com.tencent.viola.utils.ViolaLogUtils;

class VImage2$1
  implements Runnable
{
  VImage2$1(VImage2 paramVImage2, View paramView, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    VImage2.access$000(this.this$0, this.val$v.getWidth(), this.val$v.getHeight(), this.val$isPlaceHolder, this.val$url);
    ViolaLogUtils.d("VImage2", "deferred request, url: " + this.val$url + ", w: " + this.val$v.getWidth() + ", h: " + this.val$v.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2.1
 * JD-Core Version:    0.7.0.1
 */