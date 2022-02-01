package com.tencent.rmonitor.natmem;

import com.tencent.rmonitor.sla.AttaParam;
import com.tencent.rmonitor.sla.AttaReporter;

public class NatMemAttaReporter
{
  public static boolean a()
  {
    return a("NatMemSuccEvent", new String[0]);
  }
  
  public static boolean a(String paramString)
  {
    return a("NatMemFailEvent", new String[] { paramString });
  }
  
  private static boolean a(String paramString, String... paramVarArgs)
  {
    paramString = new AttaParam(paramString);
    int j = Math.min(paramVarArgs.length, 10);
    int i = 0;
    while (i < j)
    {
      paramString.a(i, paramVarArgs[i]);
      i += 1;
    }
    return AttaReporter.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.natmem.NatMemAttaReporter
 * JD-Core Version:    0.7.0.1
 */