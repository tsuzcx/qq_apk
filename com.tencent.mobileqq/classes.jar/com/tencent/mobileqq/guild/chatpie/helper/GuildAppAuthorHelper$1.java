package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.guild.api.IQQGuildClientAuthApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatPieFoldStatusListener;
import com.tencent.mobileqq.qroute.QRoute;

class GuildAppAuthorHelper$1
  implements GuildChatPieFoldStatusListener
{
  GuildAppAuthorHelper$1(GuildAppAuthorHelper paramGuildAppAuthorHelper) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      ((IQQGuildClientAuthApi)QRoute.api(IQQGuildClientAuthApi.class)).showClientGuideAuthDialog(GuildAppAuthorHelper.a(this.a).b(), GuildAppAuthorHelper.a(this.a).S(), GuildAppAuthorHelper.a(this.a).T());
    }
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildAppAuthorHelper.1
 * JD-Core Version:    0.7.0.1
 */