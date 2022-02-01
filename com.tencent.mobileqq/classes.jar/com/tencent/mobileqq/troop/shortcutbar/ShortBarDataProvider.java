package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ShortBarDataProvider
  extends IShortcutBarDataProvider
{
  public boolean a = false;
  private AIOShortcutBarContext b;
  private TroopAppShortcutBarHelper c;
  private ArrayList<IShortcutBarProcessor> d = new ArrayList();
  private ArrayList<Integer> e = new ArrayList();
  private HashMap<Integer, ArrayList<ShortcutBarInfo>> f = new HashMap();
  private SessionInfo g;
  private AppRuntime h;
  
  public ShortBarDataProvider(AIOShortcutBarContext paramAIOShortcutBarContext, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper)
  {
    this.b = paramAIOShortcutBarContext;
    this.c = paramTroopAppShortcutBarHelper;
    j();
    e();
    this.g = paramAIOShortcutBarContext.d();
    this.h = paramAIOShortcutBarContext.c();
  }
  
  private TroopShortcutBarApp a(ShortcutBarInfo paramShortcutBarInfo)
  {
    if (!(paramShortcutBarInfo instanceof TroopShortcutBarApp)) {
      return null;
    }
    return (TroopShortcutBarApp)paramShortcutBarInfo;
  }
  
  private void b(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    Object localObject2;
    Object localObject1;
    if (paramInt == 0)
    {
      localObject2 = (ArrayList)this.f.get(Integer.valueOf(2));
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<ShortcutBarInfo>)localObject2;
    }
    else
    {
      localObject1 = (ArrayList)this.f.get(Integer.valueOf(0));
    }
    if (localObject1 != null)
    {
      if (paramArrayList == null) {
        return;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ShortcutBarInfo)((Iterator)localObject1).next();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (ShortcutBarInfo)localIterator.next();
          if (((ShortcutBarInfo)localObject2).d() == ((ShortcutBarInfo)localObject3).d())
          {
            localObject3 = a((ShortcutBarInfo)localObject2);
            if (localObject3 != null)
            {
              ((TroopShortcutBarApp)localObject3).b(false);
              ((TroopShortcutBarApp)localObject3).b(0);
            }
          }
        }
      }
    }
  }
  
  private void j()
  {
    f();
    g();
    h();
    i();
  }
  
  private ArrayList<ShortcutBarInfo> k()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.e.iterator();
    ArrayList localArrayList;
    while (((Iterator)localObject2).hasNext())
    {
      int i = ((Integer)((Iterator)localObject2).next()).intValue();
      localArrayList = (ArrayList)this.f.get(Integer.valueOf(i));
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        ((ArrayList)localObject1).add(localArrayList);
      }
    }
    Collections.sort((List)localObject1, new ShortBarDataProvider.1(this));
    localObject2 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localArrayList = (ArrayList)((Iterator)localObject1).next();
      if (localArrayList != null) {
        ((ArrayList)localObject2).addAll(localArrayList);
      }
    }
    return localObject2;
  }
  
  private void l()
  {
    this.d.clear();
  }
  
  public void a()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).a();
    }
    this.e.clear();
    l();
    this.f.clear();
    this.b = null;
    this.c = null;
  }
  
  public void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (this.c == null) {
        return;
      }
      this.f.put(Integer.valueOf(paramInt), paramArrayList);
      b(paramInt, paramArrayList);
      if (this.e.contains(Integer.valueOf(paramInt)))
      {
        this.c.a(1, k(), paramBoolean);
        this.c.a(0, (ArrayList)this.f.get(Integer.valueOf(0)), this.a);
        return;
      }
      this.a = paramBoolean;
      this.c.a(0, paramArrayList, paramBoolean);
      this.c.a(1, k(), false);
    }
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      IShortcutBarProcessor localIShortcutBarProcessor = (IShortcutBarProcessor)localIterator.next();
      if (localIShortcutBarProcessor != null) {
        localIShortcutBarProcessor.a(paramObject);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).b();
    }
  }
  
  public void b(Object paramObject)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      IShortcutBarProcessor localIShortcutBarProcessor = (IShortcutBarProcessor)localIterator.next();
      if (localIShortcutBarProcessor != null) {
        localIShortcutBarProcessor.b(paramObject);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.e.add(Integer.valueOf(2));
    this.e.add(Integer.valueOf(3));
    this.e.add(Integer.valueOf(4));
    this.e.add(Integer.valueOf(5));
  }
  
  protected void f()
  {
    this.d.add(new AppShortcutBarProcessor(this.b, this));
  }
  
  protected void g()
  {
    this.d.add(new QCircleMsgProcessor(this.b, this));
  }
  
  protected void h()
  {
    TroopFansEntryConfig localTroopFansEntryConfig = (TroopFansEntryConfig)QConfigManager.b().b(701);
    if (localTroopFansEntryConfig != null)
    {
      if (!localTroopFansEntryConfig.isGroupEntranceSwitchOn()) {
        return;
      }
      this.d.add(new FansBeatRankProcessor(this.b, this));
    }
  }
  
  protected void i()
  {
    AIOShortcutBarContext localAIOShortcutBarContext = this.b;
    if ((localAIOShortcutBarContext != null) && (localAIOShortcutBarContext.a() == 3)) {
      this.d.add(new EssenceMsgProcessor(this.b, this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider
 * JD-Core Version:    0.7.0.1
 */