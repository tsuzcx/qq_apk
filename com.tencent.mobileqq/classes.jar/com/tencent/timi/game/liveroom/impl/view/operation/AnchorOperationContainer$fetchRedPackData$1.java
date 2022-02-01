package com.tencent.timi.game.liveroom.impl.view.operation;

import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import com.tencent.mobileqq.qqlive.data.lottery.QQLiveLotteryData;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.ad.TimiTianshuAdManager;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationContainer$fetchRedPackData$1", "Lcom/tencent/mobileqq/qqlive/callback/lottery/IQQLiveLotteryCallback;", "onError", "", "errCode", "", "errMsg", "", "onReceive", "lotteryList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/lottery/QQLiveLotteryData;", "Lkotlin/collections/ArrayList;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOperationContainer$fetchRedPackData$1
  implements IQQLiveLotteryCallback
{
  AnchorOperationContainer$fetchRedPackData$1(LiveRoomExtraInfo paramLiveRoomExtraInfo) {}
  
  public void a(long paramLong, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLotteryPendant failed : errorCode == ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", errorMessage == ");
    localStringBuilder.append(paramString);
    Logger.c("AnchorOperationContainer_", localStringBuilder.toString());
  }
  
  public void a(@Nullable ArrayList<QQLiveLotteryData> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = TimiTianshuAdManager.a.a(paramArrayList, this.b);
      this.a.a(9999);
      this.a.a(paramArrayList);
      return;
    }
    Logger.a("AnchorOperationContainer_", "fetchRedPackData success : lotteryList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationContainer.fetchRedPackData.1
 * JD-Core Version:    0.7.0.1
 */