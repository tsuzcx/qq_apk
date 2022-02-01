package com.tencent.timi.game.component.chat.message;

import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TeamActionMessageItemView$handleActionMsg$1$onSuccess$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "to", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamActionMessageItemView$handleActionMsg$1$onSuccess$1
  implements IResultListener<IUserInfo>
{
  TeamActionMessageItemView$handleActionMsg$1$onSuccess$1(String paramString) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    paramString = TeamActionMessageItemView.a(this.a.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" 已离开队伍，已转移给 --");
    paramString.setText((CharSequence)localStringBuilder.toString());
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    Object localObject1 = this.a.a;
    if (paramIUserInfo != null)
    {
      paramIUserInfo = paramIUserInfo.c(this.a.c);
      if (paramIUserInfo != null) {}
    }
    else
    {
      paramIUserInfo = "--";
    }
    paramIUserInfo = TeamActionMessageItemView.a((TeamActionMessageItemView)localObject1, paramIUserInfo);
    localObject1 = TeamActionMessageItemView.a(this.a.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("队长 ");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(" 已离开队伍，已转移给 ");
    ((StringBuilder)localObject2).append(paramIUserInfo);
    localObject2 = new SpannableString((CharSequence)((StringBuilder)localObject2).toString());
    ((SpannableString)localObject2).setSpan(TeamActionMessageItemView.b(this.a.a), ((SpannableString)localObject2).length() - paramIUserInfo.length(), ((SpannableString)localObject2).length(), 18);
    ((TextView)localObject1).setText((CharSequence)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamActionMessageItemView.handleActionMsg.1.onSuccess.1
 * JD-Core Version:    0.7.0.1
 */