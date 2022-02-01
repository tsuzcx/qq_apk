package com.tencent.timi.game.teamlist.model;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.smoba.impl.config.SmobaConfigManager;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaConfigItem;

public class TeamListFilterModel
{
  private final ArrayList<Boolean> a = new ArrayList();
  private final ArrayList<Boolean> b = new ArrayList();
  private final ArrayList<Boolean> c = new ArrayList();
  private final ArrayList<String> d = new ArrayList();
  private final ArrayList<String> e = new ArrayList();
  private final ArrayList<String> f = new ArrayList();
  private final ArrayList<List<Integer>> g = new ArrayList();
  private final ArrayList<List<Integer>> h = new ArrayList();
  private final ArrayList<List<Integer>> i = new ArrayList();
  
  public TeamListFilterModel()
  {
    k();
  }
  
  private void k()
  {
    try
    {
      Iterator localIterator = SmobaConfigManager.a().b().game_mode_list.get().iterator();
      GameDataServerOuterClass.SmobaConfigItem localSmobaConfigItem;
      while (localIterator.hasNext())
      {
        localSmobaConfigItem = (GameDataServerOuterClass.SmobaConfigItem)localIterator.next();
        this.d.add(localSmobaConfigItem.key.get());
        this.g.add(localSmobaConfigItem.value.get());
        this.a.add(Boolean.valueOf(false));
      }
      localIterator = SmobaConfigManager.a().b().grade_list.get().iterator();
      while (localIterator.hasNext())
      {
        localSmobaConfigItem = (GameDataServerOuterClass.SmobaConfigItem)localIterator.next();
        this.e.add(localSmobaConfigItem.key.get());
        this.h.add(localSmobaConfigItem.value.get());
        this.b.add(Boolean.valueOf(false));
      }
      localIterator = SmobaConfigManager.a().b().lane_type_list.get().iterator();
      while (localIterator.hasNext())
      {
        localSmobaConfigItem = (GameDataServerOuterClass.SmobaConfigItem)localIterator.next();
        this.f.add(localSmobaConfigItem.key.get());
        this.i.add(localSmobaConfigItem.value.get());
        this.c.add(Boolean.valueOf(false));
      }
    }
    catch (Exception localException)
    {
      label246:
      break label246;
    }
    Logger.c("TeamListFilterModel", "SmobaConfigItem 初始化异常");
  }
  
  public void a()
  {
    int m = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    int j = 0;
    while (j < this.a.size())
    {
      this.a.set(j, localBoolean);
      j += 1;
    }
    j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.b.size()) {
        break;
      }
      this.b.set(j, localBoolean);
      j += 1;
    }
    while (k < this.c.size())
    {
      this.c.set(k, localBoolean);
      k += 1;
    }
  }
  
  public ArrayList<Boolean> b()
  {
    return this.a;
  }
  
  public ArrayList<Boolean> c()
  {
    return this.b;
  }
  
  public ArrayList<Boolean> d()
  {
    return this.c;
  }
  
  public ArrayList<String> e()
  {
    return this.d;
  }
  
  public ArrayList<String> f()
  {
    return this.e;
  }
  
  public ArrayList<String> g()
  {
    return this.f;
  }
  
  public ArrayList<Integer> h()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.a.size())
    {
      if (((Boolean)this.a.get(j)).booleanValue() == true) {
        localArrayList.addAll((Collection)this.g.get(j));
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<Integer> i()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.b.size())
    {
      if (((Boolean)this.b.get(j)).booleanValue() == true) {
        localArrayList.addAll((Collection)this.h.get(j));
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<Integer> j()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.c.size())
    {
      if (((Boolean)this.c.get(j)).booleanValue() == true) {
        localArrayList.addAll((Collection)this.i.get(j));
      }
      j += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.TeamListFilterModel
 * JD-Core Version:    0.7.0.1
 */