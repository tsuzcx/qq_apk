package com.tencent.mobileqq.minigame.ui;

import abkz;
import abla;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GameActivity$38
  implements abla
{
  GameActivity$38(GameActivity paramGameActivity) {}
  
  public void onAdClicked(GdtAd paramGdtAd)
  {
    QLog.i("[minigame] GameActivity", 1, "bannerad onAdClicked");
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null) && (AdUtils.isHitReport50ViewAndOneSecond(paramGdtAd.getAd())))
    {
      AdExposureChecker.onClick(this.this$0, paramGdtAd.getAd(), new WeakReference(this.this$0.mAdExposureCheckerCallback));
      return;
    }
    QLog.i("[minigame] GameActivity", 1, "ad null");
  }
  
  public void onAdClosed(GdtAd paramGdtAd)
  {
    QLog.i("[minigame] GameActivity", 1, "bannerad onAdClosed");
  }
  
  public void onAdFailedToLoad(GdtAd paramGdtAd, abkz paramabkz)
  {
    int i;
    if (paramabkz != null)
    {
      i = paramabkz.a();
      if (paramabkz == null) {
        break label58;
      }
    }
    label58:
    for (paramGdtAd = paramabkz.a();; paramGdtAd = "")
    {
      QLog.i("[minigame] GameActivity", 1, "bannerad onAdFailedToLoad code=" + i + ", msg=" + paramGdtAd);
      return;
      i = -1;
      break;
    }
  }
  
  public void onAdImpression(GdtAd paramGdtAd)
  {
    QLog.i("[minigame] GameActivity", 1, "bannerad onAdImpression");
  }
  
  public void onAdLoaded(GdtAd paramGdtAd)
  {
    QLog.i("[minigame] GameActivity", 1, "bannerad onAdLoaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.38
 * JD-Core Version:    0.7.0.1
 */