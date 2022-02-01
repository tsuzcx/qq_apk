package com.tencent.timi.game.expand.hall.impl.mic;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/mic/MicItemView$autoOpenMic$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicItemView$autoOpenMic$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("YOLO_ROOM_VOICE_ON failed errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMessage:");
    localStringBuilder.append(paramString);
    Logger.d("MicItemView_", localStringBuilder.toString());
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    Logger.b("MicItemView_", "YOLO_ROOM_VOICE_ON succeed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicItemView.autoOpenMic.1
 * JD-Core Version:    0.7.0.1
 */