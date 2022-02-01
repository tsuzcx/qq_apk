package com.tencent.mobileqq.forward;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardShortVideoOption$1$1
  implements Runnable
{
  ForwardShortVideoOption$1$1(ForwardShortVideoOption.1 param1) {}
  
  public void run()
  {
    this.a.a.setBounds(0, 0, this.a.a.getIntrinsicWidth(), this.a.a.getIntrinsicHeight());
    this.a.b.setPreviewImage(this.a.a, true, 0, true);
    if (this.a.c)
    {
      if ((this.a.d != 0) && (this.a.e != 0))
      {
        this.a.b.setVideoFormat(true, false, ShortVideoUtils.stringForFileSize(this.a.this$0.I, this.a.d), ShortVideoUtils.stringForTime(this.a.e * 1000));
        return;
      }
      this.a.b.setVideoFormat(true, false, null, null);
      return;
    }
    this.a.b.setVideoFormat(true, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.1.1
 * JD-Core Version:    0.7.0.1
 */