package com.tencent.mobileqq.guild.mainframe.container;

import android.view.ViewGroup;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;

public abstract class GuildBaseContainer
  extends GuildMainViewLifeCycle
{
  public GuildBaseContainer(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public abstract void a(ViewGroup paramViewGroup);
  
  public abstract void a(Object paramObject);
  
  public boolean b(Object paramObject)
  {
    return true;
  }
  
  public abstract int i();
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer
 * JD-Core Version:    0.7.0.1
 */