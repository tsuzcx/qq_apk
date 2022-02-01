package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.base.ktx.IPbParser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;

final class SocializeFeedsInfoUtils$3
  implements IPbParser<articlesummary.UGCFeedsInfo, UGCFeedsInfo>
{
  SocializeFeedsInfoUtils$3(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  public UGCFeedsInfo a(articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    return SocializeFeedsInfoUtils.a(this.a, paramUGCFeedsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils.3
 * JD-Core Version:    0.7.0.1
 */