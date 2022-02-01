package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class GuildMsgItemLayoutViewFactory
{
  protected GuildMsgItemLayout a;
  protected Context b;
  protected AppRuntime c;
  private Map<Class<? extends IGuildMsgItemLayoutProcessor>, IGuildMsgItemLayoutProcessor> d;
  
  public GuildMsgItemLayoutViewFactory(AppRuntime paramAppRuntime, GuildMsgItemLayout paramGuildMsgItemLayout, Context paramContext)
  {
    this.c = paramAppRuntime;
    this.a = paramGuildMsgItemLayout;
    this.b = paramContext;
  }
  
  private void b()
  {
    if (this.d == null)
    {
      this.d = new ConcurrentHashMap();
      this.d.put(IGuildNickLayoutProcessor.class, a());
      this.d.put(IGuildTailProcessor.class, new GuildTailProcessor(this.c, this.a, this.b));
    }
  }
  
  protected IGuildMsgItemLayoutProcessor a()
  {
    return new GuildNickLayoutProcessor(this.c, this.a, this.b);
  }
  
  @Nullable
  public <T extends IGuildMsgItemLayoutProcessor> T a(Class<T> paramClass)
  {
    b();
    paramClass = (IGuildMsgItemLayoutProcessor)this.d.get(paramClass);
    if (paramClass == null) {
      QLog.e("GuildMsgItemLayoutViewFactory", 1, "processor check failed");
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayoutViewFactory
 * JD-Core Version:    0.7.0.1
 */