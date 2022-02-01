package com.tencent.mobileqq.guild.chatpie.net;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;

public class GuildMessageObserverHandler
  extends GuildChatPieNetHandler
{
  private static volatile boolean e;
  private Handler c;
  private GuildMessageObserverHandler.RefreshTask d;
  private GuildMessageObserver f = new GuildMessageObserverHandler.1(this);
  private GuildEventFlowObserver g = new GuildMessageObserverHandler.2(this);
  
  public GuildMessageObserverHandler(GuildChatContext paramGuildChatContext, QQAppInterface paramQQAppInterface)
  {
    super(paramGuildChatContext, paramQQAppInterface);
    e = false;
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a.O() != null))
    {
      if (TextUtils.isEmpty(this.a.O().b)) {
        return;
      }
      if ((!e) && (paramString.equals(this.a.O().b)))
      {
        e = true;
        c().post(this.d);
      }
    }
  }
  
  private Handler c()
  {
    if (this.c == null) {
      this.c = new Handler(Looper.getMainLooper());
    }
    return this.c;
  }
  
  public void a()
  {
    this.d = new GuildMessageObserverHandler.RefreshTask(this.a);
    this.b.addObserver(this.f);
    this.b.addObserver(this.g);
  }
  
  public void b()
  {
    this.b.removeObserver(this.f);
    this.b.removeObserver(this.g);
    c().removeCallbacks(this.d);
    e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GuildMessageObserverHandler
 * JD-Core Version:    0.7.0.1
 */