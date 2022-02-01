package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.timi.game.liveroom.impl.view.head.AnchorTopOperationView;
import com.tencent.timi.game.liveroom.impl.view.operation.OperationData;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorTopAreaView$fetchOperationData$1$1
  implements Runnable
{
  AnchorTopAreaView$fetchOperationData$1$1(AnchorTopAreaView.fetchOperationData.1 param1, List paramList) {}
  
  public final void run()
  {
    OperationData localOperationData = (OperationData)CollectionsKt.firstOrNull(this.a);
    if (localOperationData == null)
    {
      Logger.c("AnchorTopAreaView_", 1, "requestOperationAds empty ad");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestOperationAds show ad:");
    localStringBuilder.append(localOperationData);
    Logger.b("AnchorTopAreaView_", 1, localStringBuilder.toString());
    ((AnchorTopOperationView)this.this$0.a.a(2131447708)).setData(localOperationData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.fetchOperationData.1.1
 * JD-Core Version:    0.7.0.1
 */