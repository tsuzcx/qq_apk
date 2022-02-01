package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api;

import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager;", "", "clear", "", "requestCreateBiuAndCommentMix", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "biuAndCommentRequestData", "Lcom/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData;", "setBiuAndCommentListener", "listener", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager$BiuAndCommentListener;", "BiuAndCommentListener", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJBiuAndCommentMixDataManager
{
  public static final IRIJBiuAndCommentMixDataManager.Companion a = IRIJBiuAndCommentMixDataManager.Companion.a;
  
  public abstract void a();
  
  public abstract void a(@Nullable IRIJBiuAndCommentMixDataManager.BiuAndCommentListener paramBiuAndCommentListener);
  
  public abstract void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager
 * JD-Core Version:    0.7.0.1
 */