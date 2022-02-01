package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/ReadInJoyProteusBindUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusBindUtil;", "()V", "addProteusDynamicData", "", "articleData", "Lorg/json/JSONObject;", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "bindADBanner", "outData", "bindADPositionInfo", "bindAdPositionInfoNew", "bindAwesomeCommentInfo", "bindColumnEntrances", "bindCommentInfoData", "bindCommentNumText", "bindDislikeButton", "bindPartnerInfo", "bindSearchWord", "bindSeparator", "bindSourceText", "bindSubscribeName", "bindSubscriptText", "bindTitle", "supportActivatedStyle", "", "lineSpace", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyProteusBindUtilImpl
  implements IReadInJoyProteusBindUtil
{
  public void addProteusDynamicData(@Nullable JSONObject paramJSONObject, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.a(paramJSONObject, paramAbsBaseArticleInfo);
  }
  
  public void bindADBanner(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.f(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindADPositionInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.e(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindAdPositionInfoNew(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.ae(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindAwesomeCommentInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.ac(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindColumnEntrances(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.ao(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindCommentInfoData(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.h(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindCommentNumText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.j(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindDislikeButton(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.g(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindPartnerInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.af(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindSearchWord(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.ag(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindSeparator(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.o(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindSourceText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.d(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindSubscribeName(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.t(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindSubscriptText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    Util.a(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindTitle(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject, boolean paramBoolean)
  {
    Util.a(paramAbsBaseArticleInfo, paramJSONObject, paramBoolean);
  }
  
  public void bindTitle(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable JSONObject paramJSONObject, boolean paramBoolean, @Nullable String paramString)
  {
    Util.a(paramAbsBaseArticleInfo, paramJSONObject, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.ReadInJoyProteusBindUtilImpl
 * JD-Core Version:    0.7.0.1
 */