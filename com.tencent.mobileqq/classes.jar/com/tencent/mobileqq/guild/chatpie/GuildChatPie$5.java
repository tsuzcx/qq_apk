package com.tencent.mobileqq.guild.chatpie;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.multimsg.MultiMsgManager;

class GuildChatPie$5
  implements View.OnClickListener
{
  GuildChatPie$5(GuildChatPie paramGuildChatPie) {}
  
  public void onClick(View paramView)
  {
    MultiMsgManager.a().e = 0;
    GuildChatPie.g(this.a).a(this.a.aX(), this.a.aX().getIntent());
    this.a.f(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatPie.5
 * JD-Core Version:    0.7.0.1
 */