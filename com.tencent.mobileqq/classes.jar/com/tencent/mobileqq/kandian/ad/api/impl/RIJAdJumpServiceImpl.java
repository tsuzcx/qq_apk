package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdJumpService;

public class RIJAdJumpServiceImpl
  implements IRIJAdJumpService
{
  public boolean isFromLiuJin(AdvertisementInfo paramAdvertisementInfo)
  {
    return LiujinAdJump.isFromLiuJin(paramAdvertisementInfo);
  }
  
  public Integer jumpToLiujin(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    return LiujinAdJump.doJumpAction(paramAdvertisementInfo, paramContext, false);
  }
  
  public Integer jumpToLiujin(AdvertisementInfo paramAdvertisementInfo, Context paramContext, boolean paramBoolean)
  {
    return LiujinAdJump.doJumpAction(paramAdvertisementInfo, paramContext, paramBoolean);
  }
  
  public Integer openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return ReadinJoyActionUtil.e(paramContext, paramAdvertisementInfo, null, paramInt, paramBoolean, paramAdJumpParams);
  }
  
  public boolean openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, boolean paramBoolean)
  {
    return ReadinJoyActionUtil.b(paramContext, paramAdvertisementInfo, null, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdJumpServiceImpl
 * JD-Core Version:    0.7.0.1
 */