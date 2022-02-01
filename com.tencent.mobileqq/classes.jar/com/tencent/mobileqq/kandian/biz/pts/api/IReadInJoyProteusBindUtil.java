package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusBindUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addProteusDynamicData", "", "articleData", "Lorg/json/JSONObject;", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "bindADBanner", "outData", "bindADPositionInfo", "bindAdPositionInfoNew", "bindAwesomeCommentInfo", "bindColumnEntrances", "bindCommentInfoData", "bindCommentNumText", "bindDislikeButton", "bindPartnerInfo", "bindSearchWord", "bindSeparator", "bindSourceText", "bindSubscribeName", "bindSubscriptText", "bindTitle", "supportActivatedStyle", "", "lineSpace", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyProteusBindUtil
  extends QRouteApi
{
  public abstract void addProteusDynamicData(@Nullable JSONObject paramJSONObject, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void bindADBanner(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindADPositionInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindAdPositionInfoNew(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindAwesomeCommentInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindColumnEntrances(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindCommentInfoData(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindCommentNumText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindDislikeButton(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindPartnerInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindSearchWord(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindSeparator(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindSourceText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindSubscribeName(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindSubscriptText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject);
  
  public abstract void bindTitle(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject, boolean paramBoolean);
  
  public abstract void bindTitle(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject, boolean paramBoolean, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil
 * JD-Core Version:    0.7.0.1
 */