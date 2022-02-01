package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class DrawRedpacketPannelPreviewFragment$6
  implements OnCompositionLoadedListener
{
  DrawRedpacketPannelPreviewFragment$6(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    if (DrawRedpacketPannelPreviewFragment.p(this.a) != null) {
      DrawRedpacketPannelPreviewFragment.p(this.a).setImageDrawable(localLottieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */