package com.tencent.mobileqq.kandian.biz.comment.util.api;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentRptDataUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getJsonForWeb", "Lorg/json/JSONArray;", "rptDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "parseCommentContentFromJson", "", "jsonObject", "Lorg/json/JSONObject;", "commentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJCommentRptDataUtil
  extends QRouteApi
{
  @NotNull
  public abstract JSONArray getJsonForWeb(@Nullable Collection<? extends BaseCommentData.CommentRptData> paramCollection);
  
  public abstract void parseCommentContentFromJson(@Nullable JSONObject paramJSONObject, @Nullable BaseCommentData paramBaseCommentData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentRptDataUtil
 * JD-Core Version:    0.7.0.1
 */