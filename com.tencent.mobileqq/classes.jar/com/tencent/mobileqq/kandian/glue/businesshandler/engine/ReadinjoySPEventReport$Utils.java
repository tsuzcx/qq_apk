package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

class ReadinjoySPEventReport$Utils
{
  public static <T, S> String a(List<Pair<T, S>> paramList, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(paramList);
      int i = 0;
      while (i < localArrayList.size())
      {
        Pair localPair = (Pair)localArrayList.get(i);
        if (i != 0) {
          localStringBuilder.append(paramString2);
        }
        localStringBuilder.append(localPair.first);
        if (i != 0)
        {
          localStringBuilder.append(paramString1);
          localStringBuilder.append(localPair.second);
        }
        i += 1;
      }
      paramList.removeAll(localArrayList);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static <T> boolean a(T paramT1, T paramT2)
  {
    return paramT1 == paramT2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.Utils
 * JD-Core Version:    0.7.0.1
 */