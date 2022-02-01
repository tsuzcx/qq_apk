package com.tencent.timi.game.liveroom.impl.view.head;

import android.widget.TextView;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$refreshInitOnlineNum$1", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/GetRoomInfoCallback;", "onFailed", "", "code", "", "msg", "", "onSuccess", "info", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/LiveRealTimeInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$refreshInitOnlineNum$1
  implements GetRoomInfoCallback
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@Nullable LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    if (paramLiveRealTimeInfo != null)
    {
      paramLiveRealTimeInfo = paramLiveRealTimeInfo.items;
      if (paramLiveRealTimeInfo != null)
      {
        Object localObject = ((Iterable)paramLiveRealTimeInfo).iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramLiveRealTimeInfo = ((Iterator)localObject).next();
          int i;
          if (((RealTimeData)paramLiveRealTimeInfo).type == MetricsType.CUR_UV) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            break label68;
          }
        }
        paramLiveRealTimeInfo = null;
        label68:
        paramLiveRealTimeInfo = (RealTimeData)paramLiveRealTimeInfo;
        if (paramLiveRealTimeInfo != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRoomRealTimeInfo#onSuccess value=");
          ((StringBuilder)localObject).append(paramLiveRealTimeInfo.value);
          Logger.b("AnchorTopHeadView_", ((StringBuilder)localObject).toString());
          localObject = (TextView)this.a.a(2131428831);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "audienceNumTxv");
          ((TextView)localObject).setText((CharSequence)String.valueOf(paramLiveRealTimeInfo.value));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.refreshInitOnlineNum.1
 * JD-Core Version:    0.7.0.1
 */