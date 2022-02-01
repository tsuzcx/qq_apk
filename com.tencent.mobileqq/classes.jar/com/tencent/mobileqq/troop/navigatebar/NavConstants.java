package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NavConstants
{
  private static final Map<Integer, Integer> a = new HashMap(32);
  
  static
  {
    a(5, 6);
    a(12, 13);
    a(13, 14);
    a(17, 17);
    a(10, 11);
    a(18, 18);
    a(19, 19);
    a(21, 21);
    a(22, 22);
    a(24, 23);
    a(26, 26);
    a(4, 5);
    a(3, 4);
    a(2, 3);
    a(9, 10);
    a(6, 7);
    a(20, 20);
    a(16, 100);
    a(30, 102);
    a(11, 102);
    a(23, 101);
  }
  
  public static int a(int paramInt)
  {
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return ((Integer)localEntry.getKey()).intValue();
      }
    }
    return 0;
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if ((a.containsKey(Integer.valueOf(paramInt1))) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NavConstants.put the repeat key!, key = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", val = ");
      localStringBuilder.append(paramInt2);
      QLog.d("Navigate.Constants", 2, localStringBuilder.toString());
    }
    a.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public static int b(int paramInt)
  {
    Integer localInteger = (Integer)a.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.NavConstants
 * JD-Core Version:    0.7.0.1
 */