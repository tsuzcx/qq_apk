package com.tencent.timi.game.profile.impl.dialog;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$speakingListener$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileBaseInfoDialog$speakingListener$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    CustomToastView.a("下麦失败");
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    CustomToastView.a("下麦成功");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog.speakingListener.1
 * JD-Core Version:    0.7.0.1
 */