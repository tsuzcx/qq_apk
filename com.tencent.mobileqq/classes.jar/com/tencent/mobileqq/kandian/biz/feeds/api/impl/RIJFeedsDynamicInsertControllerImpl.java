package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJFeedsDynamicInsertControllerImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJFeedsDynamicInsertController;", "()V", "deleteArticle", "", "exposureArticle", "Lcom/tencent/mobileqq/kandian/biz/feeds/entity/ExposureArticle;", "deleteArticleByRowkey", "rowKey", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertControllerImpl
  implements IRIJFeedsDynamicInsertController
{
  public void deleteArticle(@Nullable ExposureArticle paramExposureArticle)
  {
    this.$$delegate_0.deleteArticle(paramExposureArticle);
  }
  
  public void deleteArticleByRowkey(@Nullable String paramString)
  {
    this.$$delegate_0.deleteArticleByRowkey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJFeedsDynamicInsertControllerImpl
 * JD-Core Version:    0.7.0.1
 */