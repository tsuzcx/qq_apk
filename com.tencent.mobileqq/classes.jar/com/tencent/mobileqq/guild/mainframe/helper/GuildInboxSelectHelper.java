package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;

public class GuildInboxSelectHelper
  extends GuildMainViewLifeCycle
{
  public static int b;
  public static int c;
  private int d = 0;
  
  static
  {
    int i = b + 1;
    b = i;
    c = i;
  }
  
  public GuildInboxSelectHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int i()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildInboxSelectHelper
 * JD-Core Version:    0.7.0.1
 */