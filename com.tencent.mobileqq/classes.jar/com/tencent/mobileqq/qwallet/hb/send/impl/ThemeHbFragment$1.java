package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.widget.RelativeLayout;

class ThemeHbFragment$1
  implements Runnable
{
  ThemeHbFragment$1(ThemeHbFragment paramThemeHbFragment) {}
  
  public void run()
  {
    ThemeHbFragment.d(this.this$0).startAnimation(ThemeHbFragment.c(this.this$0));
    ThemeHbFragment.d(this.this$0).setVisibility(0);
    this.this$0.f.addHbUploadData("theme.pack.show");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment.1
 * JD-Core Version:    0.7.0.1
 */