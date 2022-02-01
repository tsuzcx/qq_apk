package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.IPublishVideoCallback;
import com.tencent.mobileqq.kandian.biz.publisher.observer.PublisherObserverController;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/DataTransferImpl$publishArticle$publishCallback$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/net/PublishVideoHelper$IPublishVideoCallback;", "onResult", "", "errorCode", "", "rowKeys", "", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataTransferImpl$publishArticle$publishCallback$1
  implements PublishVideoHelper.IPublishVideoCallback
{
  DataTransferImpl$publishArticle$publishCallback$1(Function4 paramFunction4) {}
  
  public void a(int paramInt, @NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rowKeys");
    Object localObject = this.a;
    Collection localCollection = (Collection)paramList;
    boolean bool = localCollection.isEmpty();
    String str2 = "";
    if ((bool ^ true)) {
      str1 = (String)paramList.get(0);
    } else {
      str1 = "";
    }
    ((Function4)localObject).invoke(Integer.valueOf(paramInt), "", str1, "");
    localObject = PublisherObserverController.a;
    String str1 = str2;
    if ((localCollection.isEmpty() ^ true)) {
      str1 = (String)paramList.get(0);
    }
    ((PublisherObserverController)localObject).c(paramInt, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl.publishArticle.publishCallback.1
 * JD-Core Version:    0.7.0.1
 */