package com.tencent.qqperf.monitor.logcathook;

class LogcatHookThread$SysLogFile
  implements Comparable<SysLogFile>
{
  long a;
  long b;
  String c;
  
  public LogcatHookThread$SysLogFile(long paramLong1, long paramLong2, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramString;
  }
  
  public int a(SysLogFile paramSysLogFile)
  {
    long l = this.a - paramSysLogFile.a();
    if (0L == l) {
      return -(int)(this.b - paramSysLogFile.b());
    }
    return (int)l;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.logcathook.LogcatHookThread.SysLogFile
 * JD-Core Version:    0.7.0.1
 */