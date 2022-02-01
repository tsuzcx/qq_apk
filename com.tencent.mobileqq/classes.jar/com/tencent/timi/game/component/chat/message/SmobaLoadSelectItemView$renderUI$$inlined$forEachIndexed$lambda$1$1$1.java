package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$renderUI$4$2$1$4$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release", "com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$renderUI$4$2$$special$$inlined$run$lambda$1$1"}, k=1, mv={1, 1, 16})
public final class SmobaLoadSelectItemView$renderUI$$inlined$forEachIndexed$lambda$1$1$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  SmobaLoadSelectItemView$renderUI$$inlined$forEachIndexed$lambda$1$1$1(SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1.1 param1) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.a.this$0.c.b(this.a.this$0.d);
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    this.a.this$0.d.a(this.a.this$0.a + 1);
    paramYoloRoomCmdRsp = this.a.this$0.c.getSelfQQUserId();
    if (paramYoloRoomCmdRsp != null)
    {
      IMsgManager localIMsgManager = ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.a.a.tim_group_id.get());
      String str = TeamLaneHelper.b(((Number)SmobaLoadSelectItemView.e(this.a.this$0.c).get(this.a.this$0.a)).intValue());
      Intrinsics.checkExpressionValueIsNotNull(str, "TeamLaneHelper.buildText(roadIDs[index])");
      paramYoloRoomCmdRsp = localIMsgManager.a(paramYoloRoomCmdRsp, str);
      if (paramYoloRoomCmdRsp != null) {
        paramYoloRoomCmdRsp.a("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1.1.1
 * JD-Core Version:    0.7.0.1
 */