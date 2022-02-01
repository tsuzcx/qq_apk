package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper;

public class LocateGuildJumper
  implements IGuildBaseJumper
{
  private GuildMainViewContext a;
  
  public LocateGuildJumper(GuildMainViewContext paramGuildMainViewContext)
  {
    this.a = paramGuildMainViewContext;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.a == null) {
        return;
      }
      if (paramBundle.getBoolean("jumpToTheGuild", false))
      {
        String str = paramBundle.getString("guildId", "");
        paramBundle = paramBundle.getString("channelId", "");
        ChannelSelectHelper localChannelSelectHelper = (ChannelSelectHelper)this.a.a(GuildMainFrameConstants.f);
        if (localChannelSelectHelper != null) {
          localChannelSelectHelper.a(str, paramBundle);
        }
        this.a.b(1, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.LocateGuildJumper
 * JD-Core Version:    0.7.0.1
 */