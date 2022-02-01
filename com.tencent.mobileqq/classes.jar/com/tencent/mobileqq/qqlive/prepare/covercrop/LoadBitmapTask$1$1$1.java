package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.widget.ImageView;
import com.tencent.mobileqq.qqlive.widget.PortraitImageView;
import com.tencent.mobileqq.qqlive.widget.RegionView;

class LoadBitmapTask$1$1$1
  implements Runnable
{
  LoadBitmapTask$1$1$1(LoadBitmapTask.1.1 param1) {}
  
  public void run()
  {
    this.a.b.h.setImageBitmap(LoadBitmapTask.b(this.a.b.this$0).getBitmap());
    if (this.a.b.e != this.a.b.f) {
      LoadBitmapTask.a(this.a.b.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.LoadBitmapTask.1.1.1
 * JD-Core Version:    0.7.0.1
 */