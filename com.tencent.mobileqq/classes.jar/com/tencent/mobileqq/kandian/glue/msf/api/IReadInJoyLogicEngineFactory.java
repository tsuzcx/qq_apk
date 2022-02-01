package com.tencent.mobileqq.kandian.glue.msf.api;

import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngineFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createReadInJoyLogicEngine", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngine;", "getAdvertisementInfo", "", "channelID", "", "pos", "refreshSubscriptionUnReadNum", "", "removeAdvertisementInfo", "removeFixPosArticleAsyncListener", "setFixPosArticleAsyncListener", "listener", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/FixPosArticleInterface$FixPosArticleAsyncListener;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyLogicEngineFactory
  extends QRouteApi
{
  @NotNull
  public abstract IReadInJoyLogicEngine createReadInJoyLogicEngine();
  
  @Nullable
  public abstract Object getAdvertisementInfo(int paramInt1, int paramInt2);
  
  public abstract void refreshSubscriptionUnReadNum();
  
  @Nullable
  public abstract Object removeAdvertisementInfo(int paramInt1, int paramInt2);
  
  public abstract void removeFixPosArticleAsyncListener(int paramInt);
  
  public abstract void setFixPosArticleAsyncListener(int paramInt, @Nullable FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory
 * JD-Core Version:    0.7.0.1
 */