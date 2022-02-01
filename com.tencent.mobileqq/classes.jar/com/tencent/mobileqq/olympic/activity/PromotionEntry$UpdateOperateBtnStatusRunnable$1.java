package com.tencent.mobileqq.olympic.activity;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.lang.ref.WeakReference;

class PromotionEntry$UpdateOperateBtnStatusRunnable$1
  implements OnCompositionLoadedListener
{
  PromotionEntry$UpdateOperateBtnStatusRunnable$1(PromotionEntry.UpdateOperateBtnStatusRunnable paramUpdateOperateBtnStatusRunnable, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {
      return;
    }
    this.b.c = new LottieDrawable();
    this.b.c.setComposition(paramLottieComposition);
    this.b.c.setImageAssetDelegate(new PromotionEntry.UpdateOperateBtnStatusRunnable.1.1(this));
    this.b.c.loop(true);
    paramLottieComposition = (ImageView)PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.b).get();
    if ((paramLottieComposition != null) && (paramLottieComposition.getVisibility() == 0) && (this.b.b != null) && (!this.b.b.isRunning()))
    {
      paramLottieComposition.setImageDrawable(this.b.c);
      this.b.c.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable.1
 * JD-Core Version:    0.7.0.1
 */