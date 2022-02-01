package com.tencent.timi.game.profile.impl.dialog;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/ProfileJumpHelper$joinYoloRoomFromTeamView$2", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileJumpHelper$joinYoloRoomFromTeamView$2
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    String str = ProfileJumpHelper.a(ProfileJumpHelper.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinYoloRoom - onError -");
    localStringBuilder.append(paramInt);
    localStringBuilder.append('-');
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
  }
  
  public void a(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    Logger.a(ProfileJumpHelper.a(ProfileJumpHelper.a), "joinYoloRoom - success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileJumpHelper.joinYoloRoomFromTeamView.2
 * JD-Core Version:    0.7.0.1
 */