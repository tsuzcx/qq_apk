package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyFixPosArticleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/ReadInJoyFixPosArticleManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IReadInJoyFixPosArticleManager;", "()V", "getFixPosArticleInfos", "", "Ljava/lang/Integer;", "channelID", "", "register", "", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "registerReommendADListener", "unRegister", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyFixPosArticleManagerImpl
  implements IReadInJoyFixPosArticleManager
{
  public ReadInJoyFixPosArticleManagerImpl()
  {
    ReadinjoyFixPosArticleManager localReadinjoyFixPosArticleManager = ReadinjoyFixPosArticleManager.getInstant();
    Intrinsics.checkExpressionValueIsNotNull(localReadinjoyFixPosArticleManager, "ReadinjoyFixPosArticleManager.getInstant()");
    this.$$delegate_0 = localReadinjoyFixPosArticleManager;
  }
  
  @Nullable
  public List<Integer> getFixPosArticleInfos(int paramInt)
  {
    return this.$$delegate_0.getFixPosArticleInfos(paramInt);
  }
  
  public void register(int paramInt, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.$$delegate_0.register(paramInt, paramIReadInJoyBaseAdapter);
  }
  
  public void registerReommendADListener(int paramInt)
  {
    this.$$delegate_0.registerReommendADListener(paramInt);
  }
  
  public void unRegister(int paramInt)
  {
    this.$$delegate_0.unRegister(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.ReadInJoyFixPosArticleManagerImpl
 * JD-Core Version:    0.7.0.1
 */