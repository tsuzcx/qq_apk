package com.tencent.mobileqq.guild.mainframe.helper;

import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.helper.jump.IGuildBaseJumper;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildByOpenDataJumper;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildJumper;
import com.tencent.mobileqq.guild.mainframe.helper.jump.LocateGuildJumper;
import com.tencent.mobileqq.guild.mainframe.helper.jump.OpenGuildAioJumper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class GuildMFJumpHelper
  extends GuildMainViewLifeCycle
{
  private ConcurrentHashMap<Integer, IGuildBaseJumper> b = new ConcurrentHashMap();
  
  public GuildMFJumpHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
    a(paramGuildMainViewContext);
  }
  
  private void a(GuildMainViewContext paramGuildMainViewContext)
  {
    this.b.put(Integer.valueOf(GuildMainFrameConstants.q), new JoinGuildJumper(paramGuildMainViewContext));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.r), new JoinGuildByOpenDataJumper(paramGuildMainViewContext));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.p), new LocateGuildJumper(paramGuildMainViewContext));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.s), new OpenGuildAioJumper(paramGuildMainViewContext));
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("GuildMFJumpHelper", 2, "handleJumpAction");
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("goto_guildtab_actiontype", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRealJumpAction actionType:");
    localStringBuilder.append(i);
    QLog.i("GuildMFJumpHelper", 1, localStringBuilder.toString());
    paramBundle = paramBundle.getBundle("goto_guildtab_actionextra");
    if ((i != 0) && (this.b.get(Integer.valueOf(i)) != null)) {
      ((IGuildBaseJumper)this.b.get(Integer.valueOf(i))).a(paramBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildMFJumpHelper
 * JD-Core Version:    0.7.0.1
 */