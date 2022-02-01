package com.tencent.mobileqq.kandian.glue.pts.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyBiuButton;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLikeButton;
import com.tencent.mobileqq.kandian.glue.pts.api.IViewBaseUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/pts/api/impl/ViewBaseUtilImpl;", "Lcom/tencent/mobileqq/kandian/glue/pts/api/IViewBaseUtil;", "()V", "isReadInJoyBiuButton", "", "v", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "isReadInJoyLikeButton", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViewBaseUtilImpl
  implements IViewBaseUtil
{
  public boolean isReadInJoyBiuButton(@NotNull ViewBase paramViewBase)
  {
    Intrinsics.checkParameterIsNotNull(paramViewBase, "v");
    return paramViewBase instanceof ReadInJoyBiuButton;
  }
  
  public boolean isReadInJoyLikeButton(@NotNull ViewBase paramViewBase)
  {
    Intrinsics.checkParameterIsNotNull(paramViewBase, "v");
    return paramViewBase instanceof ReadInJoyLikeButton;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.api.impl.ViewBaseUtilImpl
 * JD-Core Version:    0.7.0.1
 */