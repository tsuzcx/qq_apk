package com.tencent.mobileqq.kandian.biz.comment.util.api;

import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createFirstComment", "", "requestData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "callback", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "", "feedsType", "", "isFeeds", "", "needBiuAfterComment", "createSubComment", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "Companion", "RIJCreateCommentObserver", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJCommentNetworkHelper
  extends QRouteApi
{
  @NotNull
  public static final String BUNDLE_KEY_CREATE_COMMENT_DATA = "BUNDLE_KEY_CREATE_COMMENT_DATA";
  @NotNull
  public static final String BUNDLE_KEY_JS_OBJ = "BUNDLE_KEY_JS_OBJ";
  public static final IRIJCommentNetworkHelper.Companion Companion = IRIJCommentNetworkHelper.Companion.a;
  
  public abstract long createFirstComment(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract long createSubComment(@NotNull SubCommentCreateData paramSubCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper
 * JD-Core Version:    0.7.0.1
 */