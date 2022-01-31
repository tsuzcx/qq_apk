package com.tencent.replacemonitor.replace.st;

import com.tencent.tmassistantbase.util.d;

public class InstallFinishLog
  extends ReplaceBaseLog
{
  public long installEndTime;
  
  public String build()
  {
    return super.build() + "|" + this.installEndTime + "|" + d.a(this.externalParams, "&");
  }
  
  public int getType()
  {
    return 5005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.InstallFinishLog
 * JD-Core Version:    0.7.0.1
 */