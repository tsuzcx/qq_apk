package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.base.ktx.IPbParser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PrivacyShowInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;

final class SocializeFeedsInfoUtils$8
  implements IPbParser<feeds_info.VisibleShowInfo, PrivacyShowInfo>
{
  public PrivacyShowInfo a(feeds_info.VisibleShowInfo paramVisibleShowInfo)
  {
    return PrivacyShowInfo.a(paramVisibleShowInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils.8
 * JD-Core Version:    0.7.0.1
 */