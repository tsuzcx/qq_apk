package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import mqq.app.AppRuntime;

class DrawRedpacketPannelPreviewFragment$10
  implements OnCompositionLoadedListener
{
  DrawRedpacketPannelPreviewFragment$10(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    if (DrawRedpacketPannelPreviewFragment.r(this.a) != null)
    {
      DrawRedpacketPannelPreviewFragment.r(this.a).setImageDrawable(localLottieDrawable);
      ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putBoolean(this.a.getQBaseActivity().getAppRuntime().getCurrentAccountUin(), "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.10
 * JD-Core Version:    0.7.0.1
 */