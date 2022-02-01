package com.tencent.mobileqq.forward;

import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

class ForwardShortVideoOption$3
  implements Runnable
{
  ForwardShortVideoOption$3(ForwardShortVideoOption paramForwardShortVideoOption, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    URLDrawableHelper.decodeLocalImage(this.a, null, false);
    this.this$0.s.runOnUiThread(new ForwardShortVideoOption.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.3
 * JD-Core Version:    0.7.0.1
 */