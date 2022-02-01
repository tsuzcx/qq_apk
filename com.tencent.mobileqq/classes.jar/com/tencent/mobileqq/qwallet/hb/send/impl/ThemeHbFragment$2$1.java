package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class ThemeHbFragment$2$1
  implements Runnable
{
  ThemeHbFragment$2$1(ThemeHbFragment.2 param2, Object paramObject) {}
  
  public void run()
  {
    if (ThemeHbFragment.e(this.b.a) != null) {
      ThemeHbFragment.e(this.b.a).setBackgroundDrawable(null);
    }
    ThemeHbFragment.e(this.b.a).setScaleType(ImageView.ScaleType.FIT_XY);
    ThemeHbFragment.e(this.b.a).setImageDrawable(ThemeHbFragment.a(this.b.a, (Drawable)this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment.2.1
 * JD-Core Version:    0.7.0.1
 */