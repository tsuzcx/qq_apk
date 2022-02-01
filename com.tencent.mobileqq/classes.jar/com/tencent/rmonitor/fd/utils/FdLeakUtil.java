package com.tencent.rmonitor.fd.utils;

import com.tencent.rmonitor.fd.data.FdCountable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class FdLeakUtil
{
  public static List<FdCountable> a(Map<String, Integer> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new FdCountable(str, ((Integer)paramMap.get(str)).intValue()));
      }
      Collections.sort(localArrayList, new FdLeakUtil.1());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.FdLeakUtil
 * JD-Core Version:    0.7.0.1
 */