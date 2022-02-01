package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentRptDataUtil;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentRptDataUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentRptDataUtil;", "()V", "getJsonForWeb", "Lorg/json/JSONArray;", "rptDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "parseCommentContentFromJson", "", "jsonObject", "Lorg/json/JSONObject;", "commentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentRptDataUtilImpl
  implements IRIJCommentRptDataUtil
{
  @NotNull
  public JSONArray getJsonForWeb(@Nullable Collection<? extends BaseCommentData.CommentRptData> paramCollection)
  {
    paramCollection = RIJCommentRptDataUtil.a(paramCollection);
    Intrinsics.checkExpressionValueIsNotNull(paramCollection, "RIJCommentRptDataUtil.getJsonForWeb(rptDataList)");
    return paramCollection;
  }
  
  public void parseCommentContentFromJson(@Nullable JSONObject paramJSONObject, @Nullable BaseCommentData paramBaseCommentData)
  {
    RIJCommentRptDataUtil.a(paramJSONObject, paramBaseCommentData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentRptDataUtilImpl
 * JD-Core Version:    0.7.0.1
 */