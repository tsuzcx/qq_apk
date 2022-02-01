package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdSmallImgCell;
import com.tencent.mobileqq.kandian.ad.api.IReadInJoyAdSmallImgCell;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/ad/api/impl/ReadInJoyAdSmallImgCellImpl;", "Lcom/tencent/mobileqq/kandian/ad/api/IReadInJoyAdSmallImgCell;", "()V", "getDataJson", "Lorg/json/JSONObject;", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyAdSmallImgCellImpl
  implements IReadInJoyAdSmallImgCell
{
  @Nullable
  public JSONObject getDataJson(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdSmallImgCell.a(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.ReadInJoyAdSmallImgCellImpl
 * JD-Core Version:    0.7.0.1
 */