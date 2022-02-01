package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxHandler;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.group_pro_proto.synclogic.synclogic.GuildNode;

public class GuildRegisterProxy
  extends AsyncStep
{
  private static String a = "GuildRegisterProxy";
  private ArrayList<synclogic.GuildNode> b = new ArrayList();
  private boolean c = false;
  private GuildRegisterProxyObserver d = new GuildRegisterProxy.1(this);
  
  protected int doStep()
  {
    ((TabDataHandler)this.mAutomator.k.getBusinessHandler(TabDataHandler.class.getName())).a();
    if (!((IGuildRegisterProxyMsgHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName())).e())
    {
      QLog.i(a, 1, "doStep sendRegisterProxy false");
      this.c = false;
      return 6;
    }
    this.c = true;
    return 2;
  }
  
  public void onCreate()
  {
    this.mAutomator.k.addObserver(this.d);
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.mAutomator.k.removeObserver(this.d);
    }
    QLog.i(a, 1, "开始处理其它chanel消息的补拉逻辑");
    if (this.b.size() > 0) {
      ((IGuildRegisterProxyMsgHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName())).a(this.b);
    }
    IGuildMessageBoxHandler localIGuildMessageBoxHandler = (IGuildMessageBoxHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildMsgBoxHandlerName());
    if ((localIGuildMessageBoxHandler != null) && (this.c)) {
      localIGuildMessageBoxHandler.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildRegisterProxy
 * JD-Core Version:    0.7.0.1
 */