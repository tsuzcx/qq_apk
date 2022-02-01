package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClientRedPacketModule;
import com.tencent.mobileqq.kandian.biz.reward.utils.Utils;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskArticleTimer$Companion;", "", "()V", "TAG", "", "isNowInKanDianTab", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskArticleTimer$Companion
{
  @JvmStatic
  public final boolean a()
  {
    if (Utils.a()) {
      return RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
    }
    return RIJAidlClientRedPacketModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskArticleTimer.Companion
 * JD-Core Version:    0.7.0.1
 */