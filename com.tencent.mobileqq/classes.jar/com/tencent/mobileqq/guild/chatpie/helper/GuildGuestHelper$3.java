package com.tencent.mobileqq.guild.chatpie.helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;

class GuildGuestHelper$3
  implements View.OnClickListener
{
  GuildGuestHelper$3(GuildGuestHelper paramGuildGuestHelper) {}
  
  public void onClick(View paramView)
  {
    paramView = (IQQGuildService)GuildGuestHelper.a(this.a).a().getRuntimeService(IQQGuildService.class, "");
    if (GuildGuestHelper.a(this.a).b().getIntent().getExtras() != null)
    {
      Bundle localBundle = GuildGuestHelper.a(this.a).b().getIntent().getExtras().getBundle("guild_extra");
      if (localBundle != null) {
        paramView.addGuild(GuildGuestHelper.a(this.a).b(), GuildGuestHelper.a(this.a).O().c, localBundle.getString("guild_extra_join_sig"), localBundle.getInt("guild_extra_join_from"), new GuildGuestHelper.3.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGuestHelper.3
 * JD-Core Version:    0.7.0.1
 */