package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/data/PTSLiteDataFactory$IPTSLiteDataJson;", "", "addR5ReportJson", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "r5", "Lorg/json/JSONObject;", "updateDataJson", "jsonData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface PTSLiteDataFactory$IPTSLiteDataJson
{
  public abstract void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull JSONObject paramJSONObject);
  
  public abstract void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory.IPTSLiteDataJson
 * JD-Core Version:    0.7.0.1
 */