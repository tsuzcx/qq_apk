package com.tencent.timi.game.ui;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.LottieListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SafeLottieAnimationView$3
  implements LottieListener<LottieComposition>
{
  SafeLottieAnimationView$3(SafeLottieAnimationView paramSafeLottieAnimationView) {}
  
  public void a(LottieComposition paramLottieComposition)
  {
    if ((SafeLottieAnimationView.a(this.a)) && (paramLottieComposition.hasImages()))
    {
      Iterator localIterator = paramLottieComposition.getImages().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((LottieImageAsset)localEntry.getValue()).setBitmap(null);
        }
      }
    }
    this.a.setComposition(paramLottieComposition);
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.SafeLottieAnimationView.3
 * JD-Core Version:    0.7.0.1
 */