package com.tencent.timi.game.component.chat.message;

import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TeamMessageItemView$renderUI$4$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamMessageItemView$renderUI$4$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    if ((paramInt == 920012) || (paramInt == 920003))
    {
      this.a.e.a(1);
      this.a.a.b(this.a.e);
    }
    IReportService.DefaultImpls.a((IReportService)ServiceCenter.a(IReportService.class), "ev_smoba_team_join_fail", null, 2, null);
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    IReportService.DefaultImpls.a((IReportService)ServiceCenter.a(IReportService.class), "ev_smoba_team_join_success", null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamMessageItemView.renderUI.4.1
 * JD-Core Version:    0.7.0.1
 */