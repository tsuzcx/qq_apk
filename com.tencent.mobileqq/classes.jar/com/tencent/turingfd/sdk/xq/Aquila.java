package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Aquila
{
  public static String DEFAULT_CHARSET = "UTF-8";
  public static int Kg = -1;
  public Map<Integer, interface> Lg;
  public Map<Integer, continue> Mg;
  public String Ng = "";
  public Context mContext;
  
  public Aquila(Map<Integer, interface> paramMap, Map<Integer, continue> paramMap1)
  {
    this.Lg = paramMap;
    this.Mg = paramMap1;
  }
  
  public final long b(long paramLong)
  {
    Iterator localIterator = this.Lg.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.Mg.put(localInteger, transient.a(paramLong).build());
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Aquila
 * JD-Core Version:    0.7.0.1
 */