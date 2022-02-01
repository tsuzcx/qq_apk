package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentAtUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentAtUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentAtUtil;", "()V", "onAtClick", "", "vTarget", "Landroid/view/View;", "url", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentAtUtilImpl
  implements IRIJCommentAtUtil
{
  public void onAtClick(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "vTarget");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    RIJCommentAtUtil.a(paramView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentAtUtilImpl
 * JD-Core Version:    0.7.0.1
 */