package com.tencent.mobileqq.kandian.glue.msf.api.impl;

import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/impl/ReadInJoyLogicEngineFactoryImpl;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngineFactory;", "()V", "createReadInJoyLogicEngine", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngine;", "getAdvertisementInfo", "", "channelID", "", "pos", "refreshSubscriptionUnReadNum", "", "removeAdvertisementInfo", "removeFixPosArticleAsyncListener", "setFixPosArticleAsyncListener", "listener", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/FixPosArticleInterface$FixPosArticleAsyncListener;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyLogicEngineFactoryImpl
  implements IReadInJoyLogicEngineFactory
{
  @NotNull
  public IReadInJoyLogicEngine createReadInJoyLogicEngine()
  {
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyLogicEngine, "ReadInJoyLogicEngine.getInstance()");
    return (IReadInJoyLogicEngine)localReadInJoyLogicEngine;
  }
  
  @Nullable
  public Object getAdvertisementInfo(int paramInt1, int paramInt2)
  {
    return ReadInJoyLogicEngine.a().d(paramInt1, paramInt2);
  }
  
  public void refreshSubscriptionUnReadNum()
  {
    ReadInJoyLogicEngine.a().A();
  }
  
  @Nullable
  public Object removeAdvertisementInfo(int paramInt1, int paramInt2)
  {
    return ReadInJoyLogicEngine.a().e(paramInt1, paramInt2);
  }
  
  public void removeFixPosArticleAsyncListener(int paramInt)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = ReadInJoyLogicEngine.a().M();
    if (localIRIJAdvertisementInfoModule != null) {
      localIRIJAdvertisementInfoModule.c(paramInt);
    }
  }
  
  public void setFixPosArticleAsyncListener(int paramInt, @Nullable FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener)
  {
    IRIJAdvertisementInfoModule localIRIJAdvertisementInfoModule = ReadInJoyLogicEngine.a().M();
    if (localIRIJAdvertisementInfoModule != null) {
      localIRIJAdvertisementInfoModule.a(paramInt, paramFixPosArticleAsyncListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.impl.ReadInJoyLogicEngineFactoryImpl
 * JD-Core Version:    0.7.0.1
 */