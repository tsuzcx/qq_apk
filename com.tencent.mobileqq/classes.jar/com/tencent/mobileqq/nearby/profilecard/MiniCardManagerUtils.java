package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;

public class MiniCardManagerUtils
{
  public static boolean a(String paramString)
  {
    return ((IMiniCardManagerUtils)QRoute.api(IMiniCardManagerUtils.class)).containsKey(paramString);
  }
  
  public static NowSummaryCard.MiniCard b(String paramString)
  {
    return ((IMiniCardManagerUtils)QRoute.api(IMiniCardManagerUtils.class)).getMiniCard(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.MiniCardManagerUtils
 * JD-Core Version:    0.7.0.1
 */