package com.tencent.mobileqq.guild.mainframe.container.facade;

import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;

public abstract class GuildFacadeFrameBaseController
{
  protected FacadeArgsData b;
  protected GuildMainViewContext c;
  
  public GuildFacadeFrameBaseController(GuildMainViewContext paramGuildMainViewContext, FacadeArgsData paramFacadeArgsData)
  {
    this.c = paramGuildMainViewContext;
    this.b = paramFacadeArgsData;
  }
  
  public void a() {}
  
  public void a(FacadeArgsData paramFacadeArgsData)
  {
    this.b = paramFacadeArgsData;
  }
  
  public void b() {}
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeFrameBaseController
 * JD-Core Version:    0.7.0.1
 */