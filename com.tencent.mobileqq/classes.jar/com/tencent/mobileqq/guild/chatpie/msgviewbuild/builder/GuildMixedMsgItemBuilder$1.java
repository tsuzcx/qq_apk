package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

class GuildMixedMsgItemBuilder$1
  implements AnimationTextView.OnDoubleClick
{
  GuildMixedMsgItemBuilder$1(GuildMixedMsgItemBuilder paramGuildMixedMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    Object localObject = (BaseActivity)paramView.getContext();
    if (localObject != null) {
      localObject = ((BaseActivity)localObject).getChatFragment();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      ChatActivityUtils.a(this.a.g, paramView, (BaseActivity)this.a.b);
      return;
    }
    ChatActivityUtils.a(this.a.g, paramView, (BaseActivity)this.a.b, this.a.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMixedMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */