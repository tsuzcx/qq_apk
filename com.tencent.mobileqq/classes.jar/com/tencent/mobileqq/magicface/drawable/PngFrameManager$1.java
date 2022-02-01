package com.tencent.mobileqq.magicface.drawable;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;

class PngFrameManager$1
  implements Runnable
{
  PngFrameManager$1(PngFrameManager paramPngFrameManager, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if ((this.a.c.v.getVisibility() != 0) && (this.a.c.c.getVisibility() == 0)) {
      this.a.c.u.setOnClickListener(new PngFrameManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.1
 * JD-Core Version:    0.7.0.1
 */