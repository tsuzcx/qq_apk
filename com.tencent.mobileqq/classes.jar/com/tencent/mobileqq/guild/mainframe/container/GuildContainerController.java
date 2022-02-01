package com.tencent.mobileqq.guild.mainframe.container;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverController;
import com.tencent.mobileqq.guild.mainframe.container.empty.GuildEmptyController;
import com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxController;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildContainerController
  extends GuildMainViewLifeCycle
{
  private ArrayList<GuildBaseContainer> b = new ArrayList();
  private ViewGroup c;
  private int d = 0;
  
  public GuildContainerController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
    k();
  }
  
  private GuildBaseContainer b(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      GuildBaseContainer localGuildBaseContainer = (GuildBaseContainer)localIterator.next();
      if (localGuildBaseContainer.i() == paramInt) {
        return localGuildBaseContainer;
      }
    }
    return null;
  }
  
  private void k()
  {
    this.b.add(new GuildFacadeFrameController(this.a));
    this.b.add(new GuildDiscoverController(this.a));
    this.b.add(new GuildInboxController(this.a));
    this.b.add(new GuildEmptyController(this.a));
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ViewGroup)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == this.d)
    {
      localObject = b(paramInt);
      if ((localObject != null) && (!((GuildBaseContainer)localObject).b(paramObject))) {
        return;
      }
    }
    this.d = paramInt;
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      GuildBaseContainer localGuildBaseContainer = (GuildBaseContainer)((Iterator)localObject).next();
      if (localGuildBaseContainer.i() == paramInt) {
        localGuildBaseContainer.a(paramObject);
      } else {
        localGuildBaseContainer.j();
      }
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      this.c = paramView;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((GuildBaseContainer)localIterator.next()).a(paramView);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).b(paramBoolean);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).c();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GuildBaseContainer)localIterator.next()).g();
    }
  }
  
  public boolean h()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((GuildBaseContainer)localIterator.next()).h()) {
        return true;
      }
    }
    return false;
  }
  
  public GuildFacadeFrameController i()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      GuildBaseContainer localGuildBaseContainer = (GuildBaseContainer)localIterator.next();
      if ((localGuildBaseContainer instanceof GuildFacadeFrameController)) {
        return (GuildFacadeFrameController)localGuildBaseContainer;
      }
    }
    return null;
  }
  
  public int j()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.GuildContainerController
 * JD-Core Version:    0.7.0.1
 */