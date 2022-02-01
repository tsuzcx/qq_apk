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
    if (this.d.containsKey(Integer.valueOf(paramInt)))
    {
      String str = (String)this.d.get(Integer.valueOf(paramInt));
      this.d.remove(Integer.valueOf(paramInt));
      parama.a(str);
      TbsLog.e(a, "Executed command: " + paramInt + ", extra: " + str + ", emergency configuration has requested");
      return;
    }
    if (this.e == -1)
    {
      this.c.put(Integer.valueOf(paramInt), parama);
      TbsLog.e(a, "Emergency configuration has not yet dispatched. Command query: " + paramInt + " has been suspended");
      return;
    }
    TbsLog.e(a, "Emergency configuration has been dispatched, status: " + this.e + ". Command query: " + paramInt + " ignored");
  }
  
  public void a(int paramInt, Map<Integer, String> paramMap)
  {
    TbsLog.e(a, "Handle emergency commands in sdk, status: " + paramInt);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramInt == 0)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      Integer localInteger;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label196;
        }
        localInteger = (Integer)localIterator.next();
        if (!this.c.containsKey(localInteger)) {
          break;
        }
        localObject = (e.a)this.c.get(localInteger);
        if (localObject != null) {
          ((e.a)localObject).a((String)paramMap.get(localInteger));
        }
      }
      Object localObject = (String)paramMap.get(localInteger);
      if (localObject != null) {}
      for (;;)
      {
        localLinkedHashMap.put(localInteger, localObject);
        break;
        localObject = "";
      }
    }
    this.c.clear();
    TbsLog.e(a, "Handle emergency commands failed, ignore all unhandled emergencies, status: " + paramInt);
    label196:
    this.d = localLinkedHashMap;
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.e
 * JD-Core Version:    0.7.0.1
 */