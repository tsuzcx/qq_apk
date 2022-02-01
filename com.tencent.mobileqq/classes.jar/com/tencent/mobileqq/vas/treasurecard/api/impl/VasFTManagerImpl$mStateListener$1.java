package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.treasurecard.api.ITcSdkContext.OnCardStateChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "info", "onChanged"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$mStateListener$1
  implements ITcSdkContext.OnCardStateChangeListener
{
  public static final 1 a = new 1();
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 1;
      if (paramInt2 != 1) {
        paramInt1 = 0;
      }
      TreasureUtil.a.a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mStateListener.1
 * JD-Core Version:    0.7.0.1
 */