package com.tencent.mobileqq.tianshu.api.impl;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.ApngImage;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class RedTouchTempApiImpl$2
  implements Runnable
{
  RedTouchTempApiImpl$2(RedTouchTempApiImpl paramRedTouchTempApiImpl, AtomicBoolean paramAtomicBoolean, ImageView paramImageView1, ImageView paramImageView2, Animation paramAnimation1, Animation paramAnimation2, Animation paramAnimation3, Animation paramAnimation4, boolean paramBoolean, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, long paramLong1, long paramLong2, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    if (this.a.get())
    {
      this.b.setVisibility(0);
      this.c.startAnimation(this.d);
      this.b.startAnimation(this.e);
    }
    else
    {
      ApngImage.pauseByTag(39);
      this.c.setVisibility(0);
      this.c.startAnimation(this.f);
      this.b.startAnimation(this.g);
    }
    if (this.h) {
      RedTouchTempApiImpl.access$000(this.this$0, this.i, this.j, this.k, this.a);
    }
    AtomicBoolean localAtomicBoolean = this.a;
    localAtomicBoolean.set(localAtomicBoolean.get() ^ true);
    long l1;
    if (!this.a.get()) {
      l1 = this.l;
    } else {
      l1 = this.m;
    }
    this.n.postDelayed(this, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchTempApiImpl.2
 * JD-Core Version:    0.7.0.1
 */