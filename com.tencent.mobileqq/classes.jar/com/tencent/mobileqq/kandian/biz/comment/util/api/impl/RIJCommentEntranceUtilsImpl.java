package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEntranceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentEntranceUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentEntranceUtils;", "()V", "startForResult", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentEntranceUtilsImpl
  implements IRIJCommentEntranceUtils
{
  public void startForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    ReadInJoyCommentEntrance.a(paramActivity, paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentEntranceUtilsImpl
 * JD-Core Version:    0.7.0.1
 */