package com.tencent.mobileqq.guild.mainframe.helper;

import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HelperProvider
  extends GuildMainViewLifeCycle
{
  private ConcurrentHashMap<Integer, GuildMainViewLifeCycle> b = new ConcurrentHashMap();
  
  public HelperProvider(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
    i();
  }
  
  private void i()
  {
    this.b.put(Integer.valueOf(GuildMainFrameConstants.b), new GuildLeftBarSelHelper(this.a));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.c), new GuildMFJumpHelper(this.a));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.d), new GuildLeftItemViewExtHelper(this.a));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.e), new GuildLeftItemUpdateHelper(this.a));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.f), new ChannelSelectHelper(this.a));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.g), new GuildAnimatorHelper(this.a));
    this.b.put(Integer.valueOf(GuildMainFrameConstants.h), new GuildInboxSelectHelper(this.a));
  }
  
  public Object a(int paramInt)
  {
    return this.b.get(Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).b();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).b(paramBoolean);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((GuildMainViewLifeCycle)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.HelperProvider
 * JD-Core Version:    0.7.0.1
 */