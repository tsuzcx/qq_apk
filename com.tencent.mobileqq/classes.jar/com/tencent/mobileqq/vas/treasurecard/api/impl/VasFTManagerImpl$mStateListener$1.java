package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.api.ITcSdkContext.OnCardStateChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "info", "onChanged"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$mStateListener$1
  implements ITcSdkContext.OnCardStateChangeListener
{
  public static final 1 a = new 1();
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 == -1) {
      return;
    }
    int i = 1;
    if (paramInt2 != 1) {
      i = 0;
    }
    TreasureUtil.a.a(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request-callBack ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramInt2);
    QLog.d("treasureCard", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mStateListener.1
 * JD-Core Version:    0.7.0.1
 */