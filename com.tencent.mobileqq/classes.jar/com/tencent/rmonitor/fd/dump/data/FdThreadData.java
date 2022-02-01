package com.tencent.rmonitor.fd.dump.data;

import java.util.List;

public class FdThreadData
{
  private final String a;
  private final String b;
  private final long c;
  private final List<String> d;
  
  public FdThreadData(String paramString1, String paramString2, long paramLong, List<String> paramList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
    this.d = paramList;
  }
  
  public FdThreadData(Thread paramThread, List<String> paramList)
  {
    this(paramThread.getClass().getName(), paramThread.getName(), paramThread.getId(), paramList);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d != null)
    {
      int i = 0;
      while (i < this.d.size())
      {
        localStringBuilder.append((String)this.d.get(i));
        if (i < this.d.size() - 1) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    return String.format("%s,%s,%d\n%s", new Object[] { this.a, this.b, Long.valueOf(this.c), localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.data.FdThreadData
 * JD-Core Version:    0.7.0.1
 */