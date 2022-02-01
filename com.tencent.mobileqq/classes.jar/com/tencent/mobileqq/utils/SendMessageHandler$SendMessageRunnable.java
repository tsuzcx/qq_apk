package com.tencent.mobileqq.utils;

public class SendMessageHandler$SendMessageRunnable
  implements Runnable
{
  public boolean f = false;
  public long g = -1L;
  public long h = 9223372036854775807L;
  public long i = 9223372036854775807L;
  public long j = -1L;
  public long k = -1L;
  public long l = -1L;
  public int m = -1;
  public String n = "";
  public String[] o = new String[0];
  
  public void run() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("index:");
    localStringBuilder.append(String.valueOf(this.m));
    localStringBuilder.append(",reason:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",startTime:");
    localStringBuilder.append(String.valueOf(this.k - this.j));
    localStringBuilder.append(",timeOut:");
    localStringBuilder.append(String.valueOf(this.k - this.j + this.g));
    if (this.f)
    {
      localStringBuilder.append(",duration:");
      localStringBuilder.append(String.valueOf(this.l - this.k));
      localStringBuilder.append(",error:");
      localStringBuilder.append(String.valueOf(this.h));
      if (this.i != 9223372036854775807L)
      {
        localStringBuilder.append(",serverReply:");
        localStringBuilder.append(String.valueOf(this.i));
      }
    }
    else
    {
      localStringBuilder.append(",status:RUNNING");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable
 * JD-Core Version:    0.7.0.1
 */