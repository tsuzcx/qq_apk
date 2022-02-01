package com.tencent.mobileqq.config.business;

import java.util.concurrent.ConcurrentHashMap;

public class EmoticonTabSortConfMapping
{
  private static ConcurrentHashMap<Integer, String> a;
  
  public static String a(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15)
      {
        if (paramInt != 7)
        {
          if (paramInt != 8)
          {
            if (paramInt != 11)
            {
              if (paramInt != 12)
              {
                ConcurrentHashMap localConcurrentHashMap = a;
                if (localConcurrentHashMap != null) {
                  return (String)localConcurrentHashMap.get(Integer.valueOf(paramInt));
                }
                return null;
              }
              return "hotpic";
            }
            return "camera";
          }
          return "recommend";
        }
        return "sysface";
      }
      return "cmshow";
    }
    return "favorite";
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (a == null) {
      a = new ConcurrentHashMap();
    }
    a.put(Integer.valueOf(paramInt), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonTabSortConfMapping
 * JD-Core Version:    0.7.0.1
 */