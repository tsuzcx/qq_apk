package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.base.ktx.IPbParser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;

final class SocializeFeedsInfoUtils$1
  implements IPbParser<articlesummary.BiuMultiLevel, BiuInfo>
{
  SocializeFeedsInfoUtils$1(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  public BiuInfo a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    return SocializeFeedsInfoUtils.a(this.a, paramBiuMultiLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils.1
 * JD-Core Version:    0.7.0.1
 */