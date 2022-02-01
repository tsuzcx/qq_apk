package com.tencent.qqperf.monitor.logcathook;

class LogcatHookThread$SysLogFile
  implements Comparable<SysLogFile>
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  long b;
  
  public LogcatHookThread$SysLogFile(long paramLong1, long paramLong2, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(SysLogFile paramSysLogFile)
  {
    long l = this.jdField_a_of_type_Long - paramSysLogFile.a();
    if (0L == l) {
      return -(int)(this.b - paramSysLogFile.b());
    }
    return (int)l;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.logcathook.LogcatHookThread.SysLogFile
 * JD-Core Version:    0.7.0.1
 */