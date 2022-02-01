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
  private ConcurrentHashMap<Integer, RedPointItem> a = new ConcurrentHashMap();
  public String b;
  
  public RedPointItem a(int paramInt)
  {
    if (this.a != null) {
      return (RedPointItem)this.a.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean a()
  {
    return (this.a == null) || (this.a.size() == 0);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfo", 2, "updateRedPointInfo : redId = " + paramInt1 + ", uinReadNum = " + paramInt2);
    }
    if (this.a == null) {
      return false;
    }
    RedPointItem localRedPointItem = (RedPointItem)this.a.get(Integer.valueOf(paramInt1));
    boolean bool;
    if (localRedPointItem == null)
    {
      if (paramInt2 == 0) {
        break label189;
      }
      localRedPointItem = new RedPointItem(paramInt1, paramInt2);
      this.a.put(Integer.valueOf(paramInt1), localRedPointItem);
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfo", 2, "updateRedPointInfo isChanged = " + bool);
      }
      return bool;
      if (localRedPointItem.unReadNum != paramInt2)
      {
        if (paramInt2 == 0)
        {
          this.a.remove(Integer.valueOf(paramInt1));
          bool = true;
        }
        else
        {
          localRedPointItem.unReadNum = paramInt2;
          this.a.put(Integer.valueOf(paramInt1), localRedPointItem);
          bool = true;
        }
      }
      else {
        label189:
        bool = false;
      }
    }
  }
  
  public boolean a(HashMap<Integer, Integer> paramHashMap)
  {
    boolean bool2;
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      bool2 = false;
    }
    boolean bool1;
    do
    {
      return bool2;
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfo", 2, "updateRedPointInfo : redPointInfoMap " + paramHashMap.toString());
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      bool1 = false;
      bool2 = bool1;
    } while (!paramHashMap.hasNext());
    Object localObject = (Map.Entry)paramHashMap.next();
    Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
    localObject = (Integer)((Map.Entry)localObject).getValue();
    if (bool1) {
      a(localInteger.intValue(), ((Integer)localObject).intValue());
    }
    for (;;)
    {
      break;
      bool1 = a(localInteger.intValue(), ((Integer)localObject).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */