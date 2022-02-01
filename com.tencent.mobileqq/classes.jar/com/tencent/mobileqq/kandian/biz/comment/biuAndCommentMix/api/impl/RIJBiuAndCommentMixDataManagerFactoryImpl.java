package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl;

import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManagerFactory;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="biu和评论融合已经干掉了")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/impl/RIJBiuAndCommentMixDataManagerFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManagerFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBiuAndCommentMixDataManagerFactoryImpl
  implements IRIJBiuAndCommentMixDataManagerFactory
{
  @NotNull
  public IRIJBiuAndCommentMixDataManager create()
  {
    return (IRIJBiuAndCommentMixDataManager)new RIJBiuAndCommentMixDataManager();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl.RIJBiuAndCommentMixDataManagerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */