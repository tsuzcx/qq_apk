package com.tencent.mobileqq.kandian.biz.publisher.impls.component;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/component/UIDataTransferImpl$observer$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onTopicInfoListFetched", "", "keywordList", "", "", "topicInfoList", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UIDataTransferImpl$observer$1
  extends ReadInJoyObserver
{
  public void b(@NotNull List<String> paramList, @Nullable List<TopicInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "keywordList");
    if (paramList.size() == 0)
    {
      paramList = this.a;
      UIDataTransferImpl.a(paramList, UIDataTransferImpl.a(paramList), paramList1);
      return;
    }
    paramList = this.a;
    UIDataTransferImpl.a(paramList, UIDataTransferImpl.b(paramList), paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.component.UIDataTransferImpl.observer.1
 * JD-Core Version:    0.7.0.1
 */