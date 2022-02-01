package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Durian
  implements instanceof
{
  public Durian(IteApkInfoRespCallback paramIteApkInfoRespCallback) {}
  
  public void onResult(long paramLong, Map<Integer, continue> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localHashMap.put(localInteger, new Fig((continue)paramMap.get(localInteger)));
    }
    this.Mh.onResult(paramLong, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Durian
 * JD-Core Version:    0.7.0.1
 */