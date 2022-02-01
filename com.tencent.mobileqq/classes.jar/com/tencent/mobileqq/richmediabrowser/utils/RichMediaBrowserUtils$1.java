package com.tencent.mobileqq.richmediabrowser.utils;

import android.view.View;
import com.tencent.image.URLDrawable;

final class RichMediaBrowserUtils$1
  implements Runnable
{
  RichMediaBrowserUtils$1(URLDrawable paramURLDrawable, View paramView) {}
  
  public void run()
  {
    if ((this.a.getStatus() == 0) || (this.a.getStatus() == 4)) {
      this.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils.1
 * JD-Core Version:    0.7.0.1
 */