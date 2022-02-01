package com.tencent.util;

import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.widget.UpSideDownDrawable;

final class DrawerCoverUtil$4
  implements Runnable
{
  DrawerCoverUtil$4(RandomCoverView paramRandomCoverView, UpSideDownDrawable paramUpSideDownDrawable, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.getCoverView().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.a.getCoverView().setImageDrawable(this.b);
    if (this.c)
    {
      this.b.resume();
      return;
    }
    this.b.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.4
 * JD-Core Version:    0.7.0.1
 */