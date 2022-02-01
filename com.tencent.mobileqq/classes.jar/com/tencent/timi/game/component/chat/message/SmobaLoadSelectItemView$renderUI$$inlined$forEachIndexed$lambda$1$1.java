package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import kotlin.Metadata;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$renderUI$4$2$1$4", "com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$renderUI$4$2$$special$$inlined$run$lambda$1"}, k=3, mv={1, 1, 16})
final class SmobaLoadSelectItemView$renderUI$$inlined$forEachIndexed$lambda$1$1
  implements Runnable
{
  SmobaLoadSelectItemView$renderUI$$inlined$forEachIndexed$lambda$1$1(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1 param1) {}
  
  public final void run()
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.a.room_id.get()).a(((Number)SmobaLoadSelectItemView.e(this.this$0.c).get(this.this$0.a)).intValue(), (IResultListener)new SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaLoadSelectItemView.renderUI..inlined.forEachIndexed.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */