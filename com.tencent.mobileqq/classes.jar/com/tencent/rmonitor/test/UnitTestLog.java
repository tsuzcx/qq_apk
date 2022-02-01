package com.tencent.rmonitor.test;

import com.tencent.rmonitor.common.logger.ILogProxy;
import com.tencent.rmonitor.common.logger.LogState;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.PrintStream;
import org.jetbrains.annotations.NotNull;

public class UnitTestLog
  implements ILogProxy
{
  private static UnitTestLog a;
  private static boolean b = false;
  private String c = "";
  
  public static void a()
  {
    if (b) {
      return;
    }
    b = true;
    Logger.b.a(b());
  }
  
  public static UnitTestLog b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new UnitTestLog();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(@NotNull LogState paramLogState, @NotNull String... paramVarArgs)
  {
    paramLogState = new StringBuilder(300);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      paramLogState.append(" ");
      paramLogState.append(str);
      i += 1;
    }
    this.c = paramLogState.toString();
    System.out.println(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.test.UnitTestLog
 * JD-Core Version:    0.7.0.1
 */