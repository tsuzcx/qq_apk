package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.GuildGuestObserver;
import com.tencent.mobileqq.guild.message.guest.IGuildGuestHandler;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class GuildGuestHelper
  implements ILifeCycleHelper
{
  private GuildChatContext a;
  private View b;
  private GuildGuestObserver c = new GuildGuestHelper.1(this);
  private GPServiceObserver d = new GuildGuestHelper.2(this);
  
  public GuildGuestHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
  }
  
  private void a()
  {
    f();
    c();
  }
  
  private void b()
  {
    this.a.a().addObserver(this.c);
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).addObserver(this.d);
  }
  
  private void c()
  {
    this.a.a().removeObserver(this.c);
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.d);
  }
  
  private void d()
  {
    boolean bool = this.a.Y();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isGuest: ");
    localStringBuilder.append(bool);
    QLog.d("GuildGuestHelper", 1, localStringBuilder.toString());
    if (bool)
    {
      QLog.d("GuildGuestHelper", 1, "pullMsg for guest.");
      b();
      ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade(this.a.a()).a(10014).a(10014).a(10014, this.a.O().b);
      ((IGuildGuestHandler)this.a.a().getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildGuestHandlerName())).a(this.a.O().c, this.a.O().b);
    }
  }
  
  private void e()
  {
    if (this.b == null)
    {
      this.b = LayoutInflater.from(this.a.b()).inflate(2131624147, null);
      this.b.setOnClickListener(new GuildGuestHelper.3(this));
      this.a.ae().addHeaderView(this.b, 1, null, false);
    }
  }
  
  private void f()
  {
    if (this.b != null)
    {
      this.a.ae().removeHeaderView(this.b);
      this.b = null;
    }
  }
  
  public String getTag()
  {
    return "GuildGuestHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      a();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGuestHelper
 * JD-Core Version:    0.7.0.1
 */