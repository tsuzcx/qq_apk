package com.tencent.timi.game.expand.hall.impl.gm;

import android.view.View;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo;
import com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo.Companion;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass.GetTopKuolieRoomListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager$showGMChangeRoomFromFlag$listener$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$GetTopKuolieRoomListRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallGMManager$showGMChangeRoomFromFlag$listener$1
  implements IResultListener<RecommendProxyOuterClass.GetTopKuolieRoomListRsp>
{
  ExpandHallGMManager$showGMChangeRoomFromFlag$listener$1(WeakReference paramWeakReference, ExpandHallLaunchParam paramExpandHallLaunchParam) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Logger.c(ExpandHallGMManager.a(this.a), "showGMChangeRoomFromFlag error");
  }
  
  public void a(@Nullable RecommendProxyOuterClass.GetTopKuolieRoomListRsp paramGetTopKuolieRoomListRsp)
  {
    Logger.c(ExpandHallGMManager.a(this.a), "showGMChangeRoomFromFlag success");
    View localView = (View)this.b.get();
    if (localView != null)
    {
      if (paramGetTopKuolieRoomListRsp != null)
      {
        paramGetTopKuolieRoomListRsp = paramGetTopKuolieRoomListRsp.room_list;
        if (paramGetTopKuolieRoomListRsp != null)
        {
          paramGetTopKuolieRoomListRsp = paramGetTopKuolieRoomListRsp.get();
          break label50;
        }
      }
      paramGetTopKuolieRoomListRsp = null;
      label50:
      if (paramGetTopKuolieRoomListRsp != null) {
        this.a.a(localView, this.c, new GMChangeRoomInfo(GMChangeRoomInfo.a.a(), paramGetTopKuolieRoomListRsp));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager.showGMChangeRoomFromFlag.listener.1
 * JD-Core Version:    0.7.0.1
 */