package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class FileMsg$StepTransInfo
  extends FileMsg.StepBaseInfo
{
  public HashMap a = new HashMap();
  public String b;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public long f;
  
  public String a()
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("elapsed:" + a());
      localStringBuilder.append(",tryCount:" + this.b);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepTransInfo
 * JD-Core Version:    0.7.0.1
 */