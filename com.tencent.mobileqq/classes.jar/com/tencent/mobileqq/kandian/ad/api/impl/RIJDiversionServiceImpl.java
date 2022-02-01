package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.DiversionUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJDiversionService;

public class RIJDiversionServiceImpl
  implements IRIJDiversionService
{
  public void jump(Context paramContext, int paramInt)
  {
    DiversionUtil.a(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJDiversionServiceImpl
 * JD-Core Version:    0.7.0.1
 */