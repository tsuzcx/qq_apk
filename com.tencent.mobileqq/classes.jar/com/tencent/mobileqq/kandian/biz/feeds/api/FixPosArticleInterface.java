package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/FixPosArticleInterface;", "", "getFixPosArticleListSync", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelID", "", "getFixPositionSync", "", "removeFixPosArticleAsyncListener", "", "setFixPosArticleAsyncListener", "listener", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/FixPosArticleInterface$FixPosArticleAsyncListener;", "FixPosArticleAsyncListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface FixPosArticleInterface
{
  @Nullable
  public abstract ArrayList<? extends AbsBaseArticleInfo> a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, @Nullable FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener);
  
  @Nullable
  public abstract int[] a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface
 * JD-Core Version:    0.7.0.1
 */