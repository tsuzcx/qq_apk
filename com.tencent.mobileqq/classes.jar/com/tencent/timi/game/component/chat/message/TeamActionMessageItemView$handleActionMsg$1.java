package com.tencent.timi.game.component.chat.message;

import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TeamActionMessageItemView$handleActionMsg$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "from", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamActionMessageItemView$handleActionMsg$1
  implements IResultListener<IUserInfo>
{
  TeamActionMessageItemView$handleActionMsg$1(CommonOuterClass.QQUserId paramQQUserId1, CommonOuterClass.QQUserId paramQQUserId2) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    TeamActionMessageItemView.a(this.a).setText((CharSequence)"队长 -- 已离开队伍，已转移给 --");
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    TeamActionMessageItemView localTeamActionMessageItemView = this.a;
    if (paramIUserInfo != null)
    {
      paramIUserInfo = paramIUserInfo.c(this.b);
      if (paramIUserInfo != null) {}
    }
    else
    {
      paramIUserInfo = "--";
    }
    paramIUserInfo = TeamActionMessageItemView.a(localTeamActionMessageItemView, paramIUserInfo);
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(this.c.uid.get(), (IResultListener)new TeamActionMessageItemView.handleActionMsg.1.onSuccess.1(this, paramIUserInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamActionMessageItemView.handleActionMsg.1
 * JD-Core Version:    0.7.0.1
 */