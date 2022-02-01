package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.INoticeRedUpdateListener;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.Observer;
import mqq.app.AppRuntime;

public class GuildLeftItemUpdateHelper
  extends GuildMainViewLifeCycle
{
  private GPServiceObserver b = new GuildLeftItemUpdateHelper.1(this);
  private Observer c = new GuildLeftItemUpdateHelper.2(this);
  private IGuildInboxRedService.INoticeRedUpdateListener d = new GuildLeftItemUpdateHelper.3(this);
  
  public GuildLeftItemUpdateHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  private void i()
  {
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).addObserver(this.b);
    ((IGuildUnreadCntService)this.a.a().getRuntimeService(IGuildUnreadCntService.class, "")).addObserver(this.c);
    ((IGuildInboxRedService)this.a.a().getRuntimeService(IGuildInboxRedService.class, "")).addNoticeRedUpdateListener(this.d);
  }
  
  private void j()
  {
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.b);
    ((IGuildUnreadCntService)this.a.a().getRuntimeService(IGuildUnreadCntService.class, "")).deleteObserver(this.c);
    ((IGuildInboxRedService)this.a.a().getRuntimeService(IGuildInboxRedService.class, "")).removeNoticeRedUpdateListener(this.d);
  }
  
  public void b(boolean paramBoolean)
  {
    i();
  }
  
  public void e()
  {
    j();
  }
  
  public void f()
  {
    i();
  }
  
  public void g()
  {
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemUpdateHelper
 * JD-Core Version:    0.7.0.1
 */