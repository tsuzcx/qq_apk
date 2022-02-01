package com.tencent.mobileqq.guild.chatpie.quickAt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.ArrayList;
import java.util.List;

public class GuildAtAllCountCache
{
  private final QQAppInterface a;
  private final String b;
  private int c = 0;
  private final List<GuildAtAllCountCache.AtAllCountCallback> d = new ArrayList();
  private int e;
  private int f;
  
  public GuildAtAllCountCache(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext.a();
    this.b = paramGuildChatContext.S();
  }
  
  private void d()
  {
    if (this.c != 0) {
      return;
    }
    this.c = 1;
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).fetchRemainAtAllCount(this.b, new -..Lambda.GuildAtAllCountCache.0lgtWLON2KkH6T2DbvyQ0f4WGyU(this));
  }
  
  public void a()
  {
    d();
  }
  
  public void a(GuildAtAllCountCache.AtAllCountCallback paramAtAllCountCallback)
  {
    if (this.c == 2)
    {
      paramAtAllCountCallback.onResult(this.e, this.f);
      return;
    }
    this.d.add(paramAtAllCountCallback);
    d();
  }
  
  public void b()
  {
    if (this.c == 2) {
      this.c = 0;
    }
  }
  
  public void c()
  {
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtAllCountCache
 * JD-Core Version:    0.7.0.1
 */