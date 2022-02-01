package com.tencent.timi.game.profile.impl.dialog;

import com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView;
import com.tencent.timi.game.userinfo.api.NetRspUserData;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$initUserData$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/NetRspUserData;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileBaseInfoDialog$initUserData$1
  implements IResultListener<NetRspUserData>
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@Nullable NetRspUserData paramNetRspUserData)
  {
    if ((!ProfileBaseInfoDialog.a(this.a)) && (this.a.r()))
    {
      ProfileItemInTeamView localProfileItemInTeamView = ProfileBaseInfoDialog.b(this.a);
      if (localProfileItemInTeamView != null) {
        localProfileItemInTeamView.setData(paramNetRspUserData, this.a.n(), this.a.m(), this.a.p());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog.initUserData.1
 * JD-Core Version:    0.7.0.1
 */