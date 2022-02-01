package com.tencent.mobileqq.troop.redpoint;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RedPointInfo
{
  public String a;
  public String b;
  private ConcurrentHashMap<Integer, RedPointItem> c = new ConcurrentHashMap();
  
  public RedPointItem a(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      return (RedPointItem)localConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean a()
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    boolean bool = true;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.size() == 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRedPointInfo : redId = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", uinReadNum = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("RedPointInfo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject == null) {
      return false;
    }
    localObject = (RedPointItem)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt1));
    boolean bool = true;
    if (localObject == null)
    {
      if (paramInt2 != 0)
      {
        localObject = new RedPointItem(paramInt1, paramInt2);
        this.c.put(Integer.valueOf(paramInt1), localObject);
        break label175;
      }
    }
    else if (((RedPointItem)localObject).unReadNum != paramInt2)
    {
      if (paramInt2 == 0)
      {
        this.c.remove(Integer.valueOf(paramInt1));
        break label175;
      }
      ((RedPointItem)localObject).unReadNum = paramInt2;
      this.c.put(Integer.valueOf(paramInt1), localObject);
      break label175;
    }
    bool = false;
    label175:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRedPointInfo isChanged = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("RedPointInfo", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean a(HashMap<Integer, Integer> paramHashMap)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramHashMap != null)
    {
      if (paramHashMap.isEmpty()) {
        return false;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateRedPointInfo : redPointInfoMap ");
        ((StringBuilder)localObject1).append(paramHashMap.toString());
        QLog.d("RedPointInfo", 2, ((StringBuilder)localObject1).toString());
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramHashMap.hasNext()) {
          break;
        }
        Object localObject2 = (Map.Entry)paramHashMap.next();
        localObject1 = (Integer)((Map.Entry)localObject2).getKey();
        localObject2 = (Integer)((Map.Entry)localObject2).getValue();
        if (bool1) {
          a(((Integer)localObject1).intValue(), ((Integer)localObject2).intValue());
        } else {
          bool1 = a(((Integer)localObject1).intValue(), ((Integer)localObject2).intValue());
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */