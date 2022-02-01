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
  public int a;
  public String a;
  private List<TroopAIOAppInfo> a;
  public ConcurrentHashMap<Integer, TroopAIOAppInfo> a;
  public int b = 0;
  
  public TroopAIOAppInfoListItem()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ArrayList<TroopAIOAppInfo> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localTroopAIOAppInfo != null)
    {
      localTroopAIOAppInfo.copyFrom(paramTroopAIOAppInfo);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramTroopAIOAppInfo);
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramTroopAIOAppInfo);
      return;
    }
    finally {}
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        AssertUtils.a(localTroopAIOAppInfo);
        if (localTroopAIOAppInfo != null)
        {
          this.jdField_a_of_type_JavaUtilList.add(localTroopAIOAppInfo);
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
      boolean bool = this.jdField_a_of_type_JavaUtilList.remove(paramTroopAIOAppInfo);
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
      int i = this.jdField_a_of_type_JavaUtilList.size();
      int j = paramList.size();
      if (i != j) {
        return true;
      }
      ListIterator localListIterator = this.jdField_a_of_type_JavaUtilList.listIterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.data.TroopAIOAppInfoListItem
 * JD-Core Version:    0.7.0.1
 */