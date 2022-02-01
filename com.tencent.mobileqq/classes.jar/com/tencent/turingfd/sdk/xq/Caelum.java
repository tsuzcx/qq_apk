package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Caelum
{
  public static String DEFAULT_CHARSET = "UTF-8";
  public static int dh = -1;
  public Map<Integer, instanceof> eh;
  public Map<Integer, protected> fh;
  public String gh = "";
  public Context mContext;
  
  public Caelum(Map<Integer, instanceof> paramMap, Map<Integer, protected> paramMap1)
  {
    this.eh = paramMap;
    this.fh = paramMap1;
  }
  
  public final long b(long paramLong)
  {
    Iterator localIterator = this.eh.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.fh.put(localInteger, Andromeda.a(paramLong).a());
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Caelum
 * JD-Core Version:    0.7.0.1
 */