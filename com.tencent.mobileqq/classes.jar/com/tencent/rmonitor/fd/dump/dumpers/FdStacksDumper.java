package com.tencent.rmonitor.fd.dump.dumpers;

import com.tencent.rmonitor.fd.FdLeakConfigHelper;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.hook.FdOpenStackManager;

public class FdStacksDumper
  extends BaseFdDumper
{
  public int a()
  {
    return 4;
  }
  
  protected FdLeakDumpResult b(String paramString)
  {
    if (FdOpenStackManager.a(paramString)) {
      return a(paramString, null);
    }
    return a(1);
  }
  
  public boolean b()
  {
    return FdLeakConfigHelper.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.dumpers.FdStacksDumper
 * JD-Core Version:    0.7.0.1
 */