package com.tencent.timi.game.team.impl.chat;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/timi/game/team/impl/chat/TeamAtListView$AtMember;", "Lcom/tencent/timi/game/team/impl/chat/TeamAtListView;", "kotlin.jvm.PlatformType", "", "onMemberConfirm"}, k=3, mv={1, 1, 16})
final class TeamInputView$layoutInflated$1$onTextChanged$1
  implements TeamAtListView.AtStateChangeListener
{
  TeamInputView$layoutInflated$1$onTextChanged$1(TeamInputView.layoutInflated.1 param1) {}
  
  public final void a(List<TeamAtListView.AtMember> paramList)
  {
    Object localObject1;
    if (paramList.size() != 0)
    {
      localObject1 = TeamInputView.a(this.a.a);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      int i = ((EditText)localObject1).getSelectionStart();
      localObject1 = TeamInputView.a(this.a.a);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (!((EditText)localObject1).getText().toString().equals(""))
      {
        localObject1 = TeamInputView.a(this.a.a);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((EditText)localObject1).getText().delete(i - 1, i);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (TeamAtListView.AtMember)paramList.next();
      Object localObject2 = this.a.a;
      CommonOuterClass.QQUserId localQQUserId = ((TeamAtListView.AtMember)localObject1).b;
      Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "atMember.qqUserId");
      ((TeamInputView)localObject2).a(localQQUserId, ((TeamAtListView.AtMember)localObject1).a, "");
      localObject2 = SpecialMsgUtil.a;
      localQQUserId = ((TeamAtListView.AtMember)localObject1).b;
      Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "atMember.qqUserId");
      ((SpecialMsgUtil)localObject2).a(localQQUserId, ((TeamAtListView.AtMember)localObject1).a, TeamInputView.a(this.a.a), (TimiBaseInputView)this.a.a);
    }
    this.a.a.postDelayed((Runnable)new TeamInputView.layoutInflated.1.onTextChanged.1.1(this), 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputView.layoutInflated.1.onTextChanged.1
 * JD-Core Version:    0.7.0.1
 */