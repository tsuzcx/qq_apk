package com.tencent.viola.ui.component;

import android.os.Handler;
import com.tencent.viola.utils.ViolaLogUtils;

class VImage$1
  implements Runnable
{
  VImage$1(VImage paramVImage) {}
  
  public void run()
  {
    VImage.access$008(this.this$0);
    if (VImage.access$100(this.this$0))
    {
      this.this$0.setImageSrc(VImage.access$200(this.this$0), false);
      return;
    }
    if (VImage.access$000(this.this$0) <= 150)
    {
      VImage.access$300(this.this$0).postDelayed(this, 100L);
      return;
    }
    ViolaLogUtils.d("VComponent", "initHandler setSrc load image url fail:" + VImage.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VImage.1
 * JD-Core Version:    0.7.0.1
 */