package com.tencent.mobileqq.guild.chatpie;

import android.view.View;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnLayoutListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class GuildListUI$1
  implements ChatXListView.OnLayoutListener
{
  GuildListUI$1(GuildListUI paramGuildListUI) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GuildListUI.a(this.a);
    paramInt4 = 0;
    Object localObject1 = null;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < this.a.k())
    {
      View localView = this.a.a(paramInt1);
      Object localObject3 = localView.getTag(2131430591);
      Object localObject2 = localObject1;
      if ((localObject3 instanceof ChatMessage))
      {
        GuildListUI localGuildListUI = this.a;
        localObject3 = (ChatMessage)localObject3;
        localObject2 = localObject1;
        if (GuildListUI.a(localGuildListUI, (ChatMessage)localObject3))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
        }
      }
      if (localView == GuildListUI.b(this.a)) {
        paramInt2 = 1;
      }
      paramInt1 += 1;
      localObject1 = localObject2;
    }
    if (paramInt2 == 0) {
      return;
    }
    if (!GuildListUI.a(this.a, (ChatMessage)localObject1))
    {
      if ((GuildListUI.c(this.a) != null) && (GuildListUI.d(this.a).getHeight() != GuildListUI.e(this.a)))
      {
        localObject1 = this.a;
        GuildListUI.a((GuildListUI)localObject1, GuildListUI.e((GuildListUI)localObject1));
      }
      return;
    }
    int j = this.a.o();
    int k = this.a.n();
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = paramInt4;
    while (paramInt2 < this.a.k())
    {
      localObject1 = this.a.a(paramInt2);
      int i;
      if (((((View)localObject1).getTag(2131430591) instanceof ChatMessage)) && (((View)localObject1).getVisibility() == 0))
      {
        paramInt4 = paramInt3 + ((View)localObject1).getHeight();
        i = paramInt1;
      }
      else
      {
        paramInt4 = paramInt3;
        i = paramInt1;
        if (GuildListUI.f(this.a).findHeaderViewPosition((View)localObject1) != -1)
        {
          i = paramInt1 + ((View)localObject1).getHeight();
          paramInt4 = paramInt3;
        }
      }
      paramInt2 += 1;
      paramInt3 = paramInt4;
      paramInt1 = i;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onLayout paddingTop:");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(" paddingBottom:");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(" totolChildHeight:");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append(" listview heght:");
    ((StringBuilder)localObject1).append(this.a.l());
    ((StringBuilder)localObject1).append(" totolHeadHeight:");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.i("GuildListUI", 1, ((StringBuilder)localObject1).toString());
    paramInt1 = paramInt3 + paramInt1 + j + k;
    if (paramInt1 < this.a.l())
    {
      paramInt1 = this.a.l() - paramInt1;
      localObject1 = this.a;
      GuildListUI.a((GuildListUI)localObject1, GuildListUI.g((GuildListUI)localObject1).getHeight() + paramInt1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLayout allItemHight small setHeaderViewHeight:");
      ((StringBuilder)localObject1).append(GuildListUI.h(this.a).getHeight() + paramInt1);
      QLog.i("GuildListUI", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    paramInt1 -= this.a.l();
    if (GuildListUI.i(this.a).getHeight() > GuildListUI.e(this.a))
    {
      if (GuildListUI.j(this.a).getHeight() - paramInt1 > GuildListUI.e(this.a)) {
        paramInt1 = GuildListUI.k(this.a).getHeight() - paramInt1;
      } else {
        paramInt1 = GuildListUI.e(this.a);
      }
      GuildListUI.a(this.a, paramInt1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLayout allItemHight more setHeaderViewHeight:");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.i("GuildListUI", 1, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildListUI.1
 * JD-Core Version:    0.7.0.1
 */