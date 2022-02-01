package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TuringSecurityService
{
  public static void a(Map<Integer, IteApkInfoReq> paramMap, IteApkInfoRespCallback paramIteApkInfoRespCallback)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localHashMap.put(localInteger, (Caelum)paramMap.get(localInteger));
    }
    paramMap = new TuringSecurityService.do(paramIteApkInfoRespCallback);
    int i = while.a();
    if (i != 0)
    {
      paramMap.a(i, new HashMap());
      return;
    }
    new throw(localHashMap, paramMap).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringSecurityService
 * JD-Core Version:    0.7.0.1
 */