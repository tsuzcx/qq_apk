package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.mobileqq.kandian.ad.api.IRIJLiujinAdJumpService;

public class RIJLiujinAdJumpServiceImpl
  implements IRIJLiujinAdJumpService
{
  public Integer doJumpAction(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    return LiujinAdJump.doJumpAction(paramAdvertisementInfo, paramContext);
  }
  
  public boolean isFromLiuJin(AdvertisementInfo paramAdvertisementInfo)
  {
    return LiujinAdJump.isFromLiuJin(paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJLiujinAdJumpServiceImpl
 * JD-Core Version:    0.7.0.1
 */