package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJCoinAnimationUtils$addApngListener$1$1
  implements Runnable
{
  RIJCoinAnimationUtils$addApngListener$1$1(int paramInt) {}
  
  public final void run()
  {
    if ((this.a == RIJCoinAnimationUtils.a.c()) && (RIJCoinAnimationUtils.a.b() != 1))
    {
      View localView = RIJCoinAnimationUtils.a.a();
      if (localView != null) {
        localView.setVisibility(4);
      }
    }
    RIJCoinAnimationUtils.a(RIJCoinAnimationUtils.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils.addApngListener.1.1
 * JD-Core Version:    0.7.0.1
 */