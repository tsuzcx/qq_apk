package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cepheus
{
  public static int a = -1;
  public Map<Integer, Caelum> b;
  public Map<Integer, Bootes> c;
  public Context d;
  public String e = "";
  
  public Cepheus(Map<Integer, Caelum> paramMap, Map<Integer, Bootes> paramMap1)
  {
    this.b = paramMap;
    this.c = paramMap1;
  }
  
  public final long a(long paramLong)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.c.put(localInteger, new Canesatici(new Canesatici.do(false, paramLong)));
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cepheus
 * JD-Core Version:    0.7.0.1
 */