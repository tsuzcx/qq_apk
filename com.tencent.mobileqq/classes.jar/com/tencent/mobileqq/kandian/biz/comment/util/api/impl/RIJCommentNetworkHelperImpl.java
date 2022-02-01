package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentNetworkHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper;", "()V", "createFirstComment", "", "requestData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "callback", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "", "feedsType", "", "isFeeds", "", "needBiuAfterComment", "createSubComment", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkHelperImpl
  implements IRIJCommentNetworkHelper
{
  public long createFirstComment(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    return this.$$delegate_0.createFirstComment(paramFirstCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public long createSubComment(@NotNull SubCommentCreateData paramSubCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    return this.$$delegate_0.createSubComment(paramSubCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentNetworkHelperImpl
 * JD-Core Version:    0.7.0.1
 */