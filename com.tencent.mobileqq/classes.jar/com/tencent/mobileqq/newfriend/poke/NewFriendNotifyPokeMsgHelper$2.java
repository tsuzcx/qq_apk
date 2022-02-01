package com.tencent.mobileqq.newfriend.poke;

import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dinifly.LottieDrawable;

final class NewFriendNotifyPokeMsgHelper$2
  implements NewFriendNotifyPokeMsgHelper.LottieDrawableLoadedListener
{
  NewFriendNotifyPokeMsgHelper$2(ImageView paramImageView1, Object paramObject, AppInterface paramAppInterface, ImageView paramImageView2) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable != null)
    {
      paramLottieDrawable.addAnimatorListener(new NewFriendNotifyPokeMsgHelper.2.1(this));
      if (!paramLottieDrawable.isAnimating())
      {
        this.d.setImageDrawable(paramLottieDrawable);
        paramLottieDrawable.playAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */