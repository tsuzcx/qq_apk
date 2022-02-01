package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/ad/api/IReadInJoyAdSmallImgCell;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDataJson", "Lorg/json/JSONObject;", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyAdSmallImgCell
  extends QRouteApi
{
  @Nullable
  public abstract JSONObject getDataJson(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IReadInJoyAdSmallImgCell
 * JD-Core Version:    0.7.0.1
 */