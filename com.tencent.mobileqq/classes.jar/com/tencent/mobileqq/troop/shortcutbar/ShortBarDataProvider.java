package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
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

public class ShortBarDataProvider
  extends IShortcutBarDataProvider
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ShortcutBarAIOHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper;
  private ArrayList<IShortcutBarProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ArrayList<ShortcutBarInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private ArrayList<Integer> b = new ArrayList();
  
  public ShortBarDataProvider(BaseChatPie paramBaseChatPie, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper = ((ShortcutBarAIOHelper)paramILifeCycleHelper);
    j();
    e();
  }
  
  private TroopShortcutBarApp a(ShortcutBarInfo paramShortcutBarInfo)
  {
    if (!(paramShortcutBarInfo instanceof TroopShortcutBarApp)) {
      return null;
    }
    return (TroopShortcutBarApp)paramShortcutBarInfo;
  }
  
  private ArrayList<ShortcutBarInfo> a()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.b.iterator();
    ArrayList localArrayList;
    while (((Iterator)localObject2).hasNext())
    {
      int i = ((Integer)((Iterator)localObject2).next()).intValue();
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
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
  
  private void b(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<ShortcutBarInfo>)localObject2;
    }
    while ((localObject1 == null) || (paramArrayList == null))
    {
      return;
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ShortcutBarInfo)((Iterator)localObject1).next();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (ShortcutBarInfo)localIterator.next();
        if (((ShortcutBarInfo)localObject2).b() == ((ShortcutBarInfo)localObject3).b())
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
  
  private void j()
  {
    f();
    g();
    h();
    i();
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).a();
    }
    this.b.clear();
    k();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper = null;
  }
  
  public void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramArrayList);
    b(paramInt, paramArrayList);
    if (this.b.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.a(1, a(), paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.a(0, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)), this.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.a(0, paramArrayList, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.a(1, a(), false);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).b();
    }
  }
  
  public void b(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IShortcutBarProcessor)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b.add(Integer.valueOf(2));
    this.b.add(Integer.valueOf(3));
    this.b.add(Integer.valueOf(4));
    this.b.add(Integer.valueOf(5));
  }
  
  protected void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new AppShortcutBarProcessor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
  
  protected void g()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new QCircleMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
  
  protected void h()
  {
    TroopFansEntryConfig localTroopFansEntryConfig = (TroopFansEntryConfig)QConfigManager.a().a(701);
    if ((localTroopFansEntryConfig == null) || (!localTroopFansEntryConfig.isGroupEntranceSwitchOn())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new FansBeatRankProcessor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
  
  protected void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.a == 1)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new EssenceMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider
 * JD-Core Version:    0.7.0.1
 */