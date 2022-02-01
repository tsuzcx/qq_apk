package com.tencent.mobileqq.qwallet.hb.send.impl;

import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.GetRandomWordsListener;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspRecommendInfo;

class ShengpiziHbFragment$6
  implements GetRecommendWordUtils.GetRandomWordsListener
{
  ShengpiziHbFragment$6(ShengpiziHbFragment paramShengpiziHbFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, GetRecommendWordUtils.RspRecommendInfo paramRspRecommendInfo)
  {
    if ((paramBoolean) && (paramInt == 4)) {
      ShengpiziHbFragment.a(this.a, paramRspRecommendInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.6
 * JD-Core Version:    0.7.0.1
 */