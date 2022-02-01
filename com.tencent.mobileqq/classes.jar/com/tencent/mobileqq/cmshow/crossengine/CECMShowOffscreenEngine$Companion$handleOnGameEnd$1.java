package com.tencent.mobileqq.cmshow.crossengine;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CECMShowOffscreenEngine$Companion$handleOnGameEnd$1
  implements Runnable
{
  CECMShowOffscreenEngine$Companion$handleOnGameEnd$1(View paramView) {}
  
  public final void run()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((View)localObject).getParent();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeView(this.a);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.handleOnGameEnd.1
 * JD-Core Version:    0.7.0.1
 */