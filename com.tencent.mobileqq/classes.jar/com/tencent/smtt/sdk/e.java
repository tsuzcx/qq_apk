package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class e
{
  private static String a = "SDKEcService";
  private static e b;
  private Map<Integer, e.a> c = new LinkedHashMap();
  private Map<Integer, String> d = new LinkedHashMap();
  private int e = -1;
  
  public static e a()
  {
    if (b == null) {
      b = new e();
    }
    return b;
  }
  
  public void a(int paramInt, e.a parama)
  {
    Object localObject2;
    if (this.d.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = (String)this.d.get(Integer.valueOf(paramInt));
      this.d.remove(Integer.valueOf(paramInt));
      parama.a((String)localObject1);
      parama = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Executed command: ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", extra: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", emergency configuration has requested");
    }
    for (Object localObject1 = ((StringBuilder)localObject2).toString();; localObject1 = ((StringBuilder)localObject1).toString())
    {
      TbsLog.i(parama, (String)localObject1);
      return;
      if (this.e == -1)
      {
        this.c.put(Integer.valueOf(paramInt), parama);
        parama = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Emergency configuration has not yet dispatched. Command query: ");
        ((StringBuilder)localObject1).append(paramInt);
        localObject2 = " has been suspended";
      }
      else
      {
        parama = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Emergency configuration has been dispatched, status: ");
        ((StringBuilder)localObject1).append(this.e);
        ((StringBuilder)localObject1).append(". Command query: ");
        ((StringBuilder)localObject1).append(paramInt);
        localObject2 = " ignored";
      }
      ((StringBuilder)localObject1).append((String)localObject2);
    }
  }
  
  public void a(int paramInt, Map<Integer, String> paramMap)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Handle emergency commands in sdk, status: ");
    ((StringBuilder)localObject2).append(paramInt);
    TbsLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new LinkedHashMap();
    if (paramInt == 0)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (this.c.containsKey(localInteger))
        {
          localObject1 = (e.a)this.c.get(localInteger);
          if (localObject1 != null) {
            ((e.a)localObject1).a((String)paramMap.get(localInteger));
          }
        }
        else
        {
          localObject1 = (String)paramMap.get(localInteger);
          if (localObject1 == null) {
            localObject1 = "";
          }
          ((Map)localObject2).put(localInteger, localObject1);
        }
      }
    }
    this.c.clear();
    paramMap = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Handle emergency commands failed, ignore all unhandled emergencies, status: ");
    ((StringBuilder)localObject1).append(paramInt);
    TbsLog.i(paramMap, ((StringBuilder)localObject1).toString());
    this.d = ((Map)localObject2);
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.e
 * JD-Core Version:    0.7.0.1
 */