package com.tencent.timi.game.component.chat.message;

import android.widget.TextView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TeamActionMessageItemView$showNickActionDesc$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamActionMessageItemView$showNickActionDesc$1
  implements IResultListener<IUserInfo>
{
  TeamActionMessageItemView$showNickActionDesc$1(CommonOuterClass.QQUserId paramQQUserId, String paramString) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    paramString = TeamActionMessageItemView.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-- ");
    localStringBuilder.append(this.c);
    paramString.setText((CharSequence)localStringBuilder.toString());
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    Object localObject = this.a;
    if (paramIUserInfo != null)
    {
      paramIUserInfo = paramIUserInfo.c(this.b);
      if (paramIUserInfo != null) {}
    }
    else
    {
      paramIUserInfo = "--";
    }
    paramIUserInfo = TeamActionMessageItemView.a((TeamActionMessageItemView)localObject, paramIUserInfo);
    localObject = TeamActionMessageItemView.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIUserInfo);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.c);
    ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamActionMessageItemView.showNickActionDesc.1
 * JD-Core Version:    0.7.0.1
 */