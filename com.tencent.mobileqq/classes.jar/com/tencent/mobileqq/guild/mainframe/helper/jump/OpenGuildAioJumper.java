package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;

public class OpenGuildAioJumper
  implements IGuildBaseJumper
{
  private GuildMainViewContext a;
  
  public OpenGuildAioJumper(GuildMainViewContext paramGuildMainViewContext)
  {
    this.a = paramGuildMainViewContext;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = this.a;
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.e();
    if (paramBundle != null) {
      paramBundle.a(GuildAttachContainerController.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.OpenGuildAioJumper
 * JD-Core Version:    0.7.0.1
 */