package com.tencent.mobileqq.msf.core.d;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  MsfCore a;
  private final String b = "StanbyModeStat";
  private ConcurrentHashMap c = new ConcurrentHashMap();
  private ConcurrentHashMap d = new ConcurrentHashMap();
  
  public d(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  private String a(ConcurrentHashMap paramConcurrentHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
      while (paramConcurrentHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
        boolean bool = paramConcurrentHashMap.hasNext();
        if (bool)
        {
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append(":");
          localStringBuilder.append(localEntry.getValue());
          localStringBuilder.append("|");
        }
        else
        {
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append(":");
          localStringBuilder.append(localEntry.getValue());
        }
      }
    }
    catch (Exception paramConcurrentHashMap)
    {
      label130:
      break label130;
    }
    QLog.d("StanbyModeStat", 1, "constructReport error");
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    if (this.a.statReporter != null)
    {
      String str1 = a(this.c);
      String str2 = a(this.d);
      HashMap localHashMap = new HashMap();
      localHashMap.put("refusedCmd", str1);
      localHashMap.put("permitCmd", str2);
      localHashMap.put("account", this.a.getStandyModeManager().h());
      this.a.statReporter.a("dim.Msf.RecordStanbyModeCMD1", true, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public void a()
  {
    b();
    this.c.clear();
    this.d.clear();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = this.c.containsKey(paramToServiceMsg.getServiceCmd());
    int i = 1;
    if (bool) {
      i = 1 + ((Integer)this.c.get(paramToServiceMsg.getServiceCmd())).intValue();
    }
    this.c.put(paramToServiceMsg.getServiceCmd(), Integer.valueOf(i));
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = this.d.containsKey(paramToServiceMsg.getServiceCmd());
    int i = 1;
    if (bool) {
      i = 1 + ((Integer)this.d.get(paramToServiceMsg.getServiceCmd())).intValue();
    }
    this.d.put(paramToServiceMsg.getServiceCmd(), Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.d
 * JD-Core Version:    0.7.0.1
 */