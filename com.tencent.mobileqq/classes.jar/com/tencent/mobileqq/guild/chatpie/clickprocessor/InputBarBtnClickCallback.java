package com.tencent.mobileqq.guild.chatpie.clickprocessor;

import android.view.View;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAtHelper;
import com.tencent.mobileqq.guild.vas.GuildGiftManager;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;

public class InputBarBtnClickCallback
  implements GuildPieClickProcessor.IGuildPieOnClickCallBack
{
  private void a(GuildChatContext paramGuildChatContext)
  {
    if (paramGuildChatContext.k() == 3)
    {
      paramGuildChatContext.a(1, true);
      return;
    }
    ((GuildAtHelper)paramGuildChatContext.a(144)).a();
    paramGuildChatContext.a(3, true);
  }
  
  public void a(View paramView, GuildChatContext paramGuildChatContext)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427968: 
      b(paramView, paramGuildChatContext);
      return;
    }
    a(paramGuildChatContext);
  }
  
  protected void b(View paramView, GuildChatContext paramGuildChatContext)
  {
    paramGuildChatContext.L();
    GuildGiftManager.a().a(paramGuildChatContext.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.clickprocessor.InputBarBtnClickCallback
 * JD-Core Version:    0.7.0.1
 */