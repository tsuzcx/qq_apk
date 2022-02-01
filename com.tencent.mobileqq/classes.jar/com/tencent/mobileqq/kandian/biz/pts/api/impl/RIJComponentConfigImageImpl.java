package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.api.IRIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/RIJComponentConfigImageImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IRIJComponentConfigImage;", "()V", "showOrHideFreeNetFlowHint", "", "isShow", "", "parant", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "module", "", "tryToShowFreeNetFlowHint", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJComponentConfigImageImpl
  implements IRIJComponentConfigImage
{
  public void showOrHideFreeNetFlowHint(boolean paramBoolean, @Nullable ViewBase paramViewBase, @Nullable Object paramObject)
  {
    if ((paramObject instanceof FreeNetFlowInfoModule)) {
      RIJComponentConfigImage.a(paramBoolean, paramViewBase, (FreeNetFlowInfoModule)paramObject);
    }
  }
  
  public void tryToShowFreeNetFlowHint(@Nullable ViewBase paramViewBase, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJComponentConfigImage.a(paramViewBase, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.RIJComponentConfigImageImpl
 * JD-Core Version:    0.7.0.1
 */