package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;

class RedBagVideoManager$12
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  RedBagVideoManager$12(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void a()
  {
    if (RedBagVideoManager.a(this.a) == null) {
      RedBagVideoManager.a(this.a, new Handler());
    }
    RedBagVideoManager.a(this.a).postDelayed(new RedBagVideoManager.12.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.12
 * JD-Core Version:    0.7.0.1
 */