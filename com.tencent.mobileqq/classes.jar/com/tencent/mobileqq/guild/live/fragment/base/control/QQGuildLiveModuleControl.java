package com.tencent.mobileqq.guild.live.fragment.base.control;

public class QQGuildLiveModuleControl
{
  private IGuildLiveChatBarControl a;
  private IGuildLiveTopBarControl b;
  private IGuildLiveSubVideoBarControl c;
  private IGuildLiveRootControl d;
  
  public IGuildLiveRootControl a()
  {
    return this.d;
  }
  
  public void a(IGuildLiveChatBarControl paramIGuildLiveChatBarControl)
  {
    this.a = paramIGuildLiveChatBarControl;
  }
  
  public void a(IGuildLiveRootControl paramIGuildLiveRootControl)
  {
    this.d = paramIGuildLiveRootControl;
  }
  
  public void a(IGuildLiveSubVideoBarControl paramIGuildLiveSubVideoBarControl)
  {
    this.c = paramIGuildLiveSubVideoBarControl;
  }
  
  public void a(IGuildLiveTopBarControl paramIGuildLiveTopBarControl)
  {
    this.b = paramIGuildLiveTopBarControl;
  }
  
  public IGuildLiveTopBarControl b()
  {
    return this.b;
  }
  
  public IGuildLiveChatBarControl c()
  {
    return this.a;
  }
  
  public IGuildLiveSubVideoBarControl d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl
 * JD-Core Version:    0.7.0.1
 */