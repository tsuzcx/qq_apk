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
    Function4 localFunction4 = this.a;
    int i;
    Object localObject;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label107;
      }
      localObject = (String)paramList.get(0);
      label42:
      localFunction4.invoke(Integer.valueOf(paramInt), "", localObject, "");
      localObject = PublisherObserverController.a;
      if (((Collection)paramList).isEmpty()) {
        break label114;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label119;
      }
    }
    label107:
    label114:
    label119:
    for (paramList = (String)paramList.get(0);; paramList = "")
    {
      ((PublisherObserverController)localObject).c(paramInt, paramList);
      return;
      i = 0;
      break;
      localObject = "";
      break label42;
      i = 0;
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl.publishArticle.publishCallback.1
 * JD-Core Version:    0.7.0.1
 */