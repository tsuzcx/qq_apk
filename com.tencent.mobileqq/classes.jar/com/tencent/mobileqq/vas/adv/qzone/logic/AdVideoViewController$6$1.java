package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.qzone.util.QZLog;

class AdVideoViewController$6$1
  implements Runnable
{
  AdVideoViewController$6$1(AdVideoViewController.6 param6, Drawable paramDrawable) {}
  
  public void run()
  {
    this.b.a.setImageDrawable(this.a);
    if (this.b.b.booleanValue()) {
      this.b.d.a(1, this.b.c.recCookie);
    }
    QZLog.i("AdVideoView", "@getGdtInfo setDataChanged onImageLoaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.6.1
 * JD-Core Version:    0.7.0.1
 */