package com.tencent.mobileqq.nearby.profilecard.api.impl;

import com.tencent.mobileqq.nearby.profilecard.MiniCardManager;
import com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;

public class MiniCardManagerUtilsImpl
  implements IMiniCardManagerUtils
{
  public boolean containsKey(String paramString)
  {
    return MiniCardManager.a(paramString);
  }
  
  public NowSummaryCard.MiniCard getMiniCard(String paramString)
  {
    return MiniCardManager.a(paramString);
  }
  
  public void putMiniCard(String paramString, NowSummaryCard.MiniCard paramMiniCard)
  {
    MiniCardManager.a(paramString, paramMiniCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.impl.MiniCardManagerUtilsImpl
 * JD-Core Version:    0.7.0.1
 */