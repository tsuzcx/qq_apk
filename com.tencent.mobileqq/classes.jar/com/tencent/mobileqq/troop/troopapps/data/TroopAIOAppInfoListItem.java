package com.tencent.mobileqq.troop.troopapps.data;

import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

public class TroopAIOAppInfoListItem
{
  public int a = 0;
  public String b = "";
  public int c = 0;
  public ConcurrentHashMap<Integer, TroopAIOAppInfo> d = new ConcurrentHashMap();
  private List<TroopAIOAppInfo> e = new ArrayList();
  
  public ArrayList<TroopAIOAppInfo> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.e);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.d.get(Integer.valueOf(paramInt));
    if (localTroopAIOAppInfo != null)
    {
      localTroopAIOAppInfo.copyFrom(paramTroopAIOAppInfo);
      return;
    }
    this.d.put(Integer.valueOf(paramInt), paramTroopAIOAppInfo);
    try
    {
      this.e.add(paramTroopAIOAppInfo);
      return;
    }
    finally {}
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    try
    {
      this.e.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.d.get(Integer.valueOf(i));
        AssertUtils.a(localTroopAIOAppInfo);
        if (localTroopAIOAppInfo != null)
        {
          this.e.add(localTroopAIOAppInfo);
        }
        else
        {
          localTroopAIOAppInfo = new TroopAIOAppInfo();
          localTroopAIOAppInfo.appid = i;
          localTroopAIOAppInfo.groupType = paramInt;
          a(i, localTroopAIOAppInfo);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public boolean a(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    try
    {
      boolean bool = this.e.remove(paramTroopAIOAppInfo);
      return bool;
    }
    finally
    {
      paramTroopAIOAppInfo = finally;
      throw paramTroopAIOAppInfo;
    }
  }
  
  public boolean a(List<Integer> paramList)
  {
    try
    {
      int i = this.e.size();
      int j = paramList.size();
      if (i != j) {
        return true;
      }
      ListIterator localListIterator = this.e.listIterator();
      paramList = paramList.listIterator();
      while (localListIterator.hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localListIterator.next();
        Integer localInteger = (Integer)paramList.next();
        if (localTroopAIOAppInfo.appid != localInteger.intValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "makeAppidsInOrder() app order changed!");
          }
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    try
    {
      this.e.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.data.TroopAIOAppInfoListItem
 * JD-Core Version:    0.7.0.1
 */