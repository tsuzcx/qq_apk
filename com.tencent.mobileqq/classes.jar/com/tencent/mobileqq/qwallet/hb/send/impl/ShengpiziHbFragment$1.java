package com.tencent.mobileqq.qwallet.hb.send.impl;

import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.GetGroupWordsListener;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspGroupWordsListInfo;
import java.util.List;

class ShengpiziHbFragment$1
  implements GetRecommendWordUtils.GetGroupWordsListener
{
  ShengpiziHbFragment$1(ShengpiziHbFragment paramShengpiziHbFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, List<GetRecommendWordUtils.RspGroupWordsListInfo> paramList)
  {
    if (paramBoolean)
    {
      ShengpiziHbFragment localShengpiziHbFragment = this.a;
      localShengpiziHbFragment.a = paramList;
      ShengpiziHbFragment.a(localShengpiziHbFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.1
 * JD-Core Version:    0.7.0.1
 */