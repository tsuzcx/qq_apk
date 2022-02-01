package com.tencent.mobileqq.qwallet.hb.send.impl;

import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.GetRandomWordsListener;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspRecommendInfo;
import java.util.Map;

class WordChainHbFragment$1
  implements GetRecommendWordUtils.GetRandomWordsListener
{
  WordChainHbFragment$1(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, GetRecommendWordUtils.RspRecommendInfo paramRspRecommendInfo)
  {
    if ((paramBoolean) && (paramInt == WordChainHbFragment.a(this.a).currSelectedSubChannel)) {
      WordChainHbFragment.a().put(Integer.valueOf(paramInt), paramRspRecommendInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment.1
 * JD-Core Version:    0.7.0.1
 */