package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class RedPacketKuaKuaFragment$5
  implements OnCompositionLoadedListener
{
  RedPacketKuaKuaFragment$5(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment, ImageView paramImageView) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    this.a.setImageDrawable(localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.5
 * JD-Core Version:    0.7.0.1
 */