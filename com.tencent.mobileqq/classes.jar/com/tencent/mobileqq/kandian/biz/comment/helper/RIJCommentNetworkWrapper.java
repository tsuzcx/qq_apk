package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper;", "()V", "TAG", "", "createFirstComment", "", "requestData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "callback", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "feedsType", "", "isFeeds", "", "needBiuAfterComment", "createFirstCommentForHippy", "", "Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "extraParam", "createSubComment", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "createSubCommentForHippy", "wrapCallback", "com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$wrapCallback$1", "listener", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CustomDialogClickListener;", "(Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper$RIJCreateCommentObserver;Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CustomDialogClickListener;)Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$wrapCallback$1;", "wrapHippyCallback", "com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$wrapHippyCallback$1", "(Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CustomDialogClickListener;)Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$wrapHippyCallback$1;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper
  implements IRIJCommentNetworkHelper
{
  public static final RIJCommentNetworkWrapper INSTANCE = new RIJCommentNetworkWrapper();
  private static final String TAG = "RIJCommentNetworkWrapper";
  
  private final RIJCommentNetworkWrapper.wrapCallback.1 wrapCallback(IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    return new RIJCommentNetworkWrapper.wrapCallback.1(paramCustomDialogClickListener, paramRIJCreateCommentObserver);
  }
  
  private final RIJCommentNetworkWrapper.wrapHippyCallback.1 wrapHippyCallback(RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    return new RIJCommentNetworkWrapper.wrapHippyCallback.1(paramCustomDialogClickListener, paramRIJCreateCommentForHippyObserver);
  }
  
  public final long createFirstComment(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return createFirstComment(paramFirstCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean, false);
  }
  
  public long createFirstComment(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    paramRIJCreateCommentObserver = wrapCallback(paramRIJCreateCommentObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createFirstComment.mCallback.1(paramFirstCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2));
    return RIJCommentNetworkHelper.a.a(paramFirstCommentCreateData, (IRIJCommentNetworkHelper.RIJCreateCommentObserver)paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public final void createFirstCommentForHippy(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    paramRIJCreateCommentForHippyObserver = wrapHippyCallback(paramRIJCreateCommentForHippyObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createFirstCommentForHippy.mCallback.1(paramFirstCommentCreateData, paramRIJCreateCommentForHippyObserver, paramBoolean, paramString));
    RIJCommentNetworkHelper.a.a(paramFirstCommentCreateData, (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)paramRIJCreateCommentForHippyObserver, paramBoolean, paramString);
  }
  
  public final long createSubComment(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return createSubComment(paramSubCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean, false);
  }
  
  public long createSubComment(@NotNull SubCommentCreateData paramSubCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    paramRIJCreateCommentObserver = wrapCallback(paramRIJCreateCommentObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createSubComment.mCallback.1(paramSubCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2));
    return RIJCommentNetworkHelper.a.a(paramSubCommentCreateData, (IRIJCommentNetworkHelper.RIJCreateCommentObserver)paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public final void createSubCommentForHippy(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    paramRIJCreateCommentForHippyObserver = wrapHippyCallback(paramRIJCreateCommentForHippyObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createSubCommentForHippy.mCallback.1(paramSubCommentCreateData, paramRIJCreateCommentForHippyObserver, paramBoolean, paramString));
    RIJCommentNetworkHelper.a.a(paramSubCommentCreateData, (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)paramRIJCreateCommentForHippyObserver, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper
 * JD-Core Version:    0.7.0.1
 */