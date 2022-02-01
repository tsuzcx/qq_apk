package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TuringSecurityService$do
  implements CanisMajor
{
  public TuringSecurityService$do(IteApkInfoRespCallback paramIteApkInfoRespCallback) {}
  
  public void a(long paramLong, Map<Integer, Bootes> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localHashMap.put(localInteger, new Peanut((Bootes)paramMap.get(localInteger)));
    }
    this.a.onResult(paramLong, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringSecurityService.do
 * JD-Core Version:    0.7.0.1
 */