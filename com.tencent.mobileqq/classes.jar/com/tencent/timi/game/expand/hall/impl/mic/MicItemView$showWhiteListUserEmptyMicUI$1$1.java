package com.tencent.timi.game.expand.hall.impl.mic;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/mic/MicItemView$showWhiteListUserEmptyMicUI$1$1", "Lcom/tencent/timi/game/expand/hall/impl/mic/OnMicOptCallback;", "onChecked", "", "permissionEnable", "", "onError", "errorCode", "", "errorMessage", "", "onSuccess", "result", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicItemView$showWhiteListUserEmptyMicUI$1$1
  implements OnMicOptCallback
{
  public void a(int paramInt, @Nullable String paramString)
  {
    Object localObject1 = LoadingUtils.a;
    Object localObject2 = this.a.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((LoadingUtils)localObject1).b((Context)localObject2);
    QQToast.makeText(this.a.a.getContext(), (CharSequence)paramString, 0).show();
    Logger.b("MicItemView_", "doOnMic onError");
    localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject1 != null) {
      localObject1 = ((IExpandHall)localObject1).e();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject2 = (Map)((HallReportHelper)localObject1).s();
      if (paramString == null) {
        paramString = "";
      }
      ((Map)localObject2).put("yes_fail_reason", paramString);
      ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_mic_join_fail", (Map)((HallReportHelper)localObject1).s());
    }
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    paramYoloRoomCmdRsp = LoadingUtils.a;
    Context localContext = this.a.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramYoloRoomCmdRsp.b(localContext);
    Logger.b("MicItemView_", "doOnMic onSuccess");
    paramYoloRoomCmdRsp = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (paramYoloRoomCmdRsp != null) {
      paramYoloRoomCmdRsp = paramYoloRoomCmdRsp.e();
    } else {
      paramYoloRoomCmdRsp = null;
    }
    if (paramYoloRoomCmdRsp != null) {
      ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_mic_join_success", (Map)paramYoloRoomCmdRsp.s());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = LoadingUtils.a;
    Context localContext = this.a.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((LoadingUtils)localObject).a(localContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnMic onChecked");
    ((StringBuilder)localObject).append(paramBoolean);
    Logger.b("MicItemView_", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicItemView.showWhiteListUserEmptyMicUI.1.1
 * JD-Core Version:    0.7.0.1
 */