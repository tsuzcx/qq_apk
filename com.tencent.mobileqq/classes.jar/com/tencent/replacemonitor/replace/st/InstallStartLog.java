package com.tencent.replacemonitor.replace.st;

import com.tencent.tmassistantbase.util.d;

public class InstallStartLog
  extends ReplaceBaseLog
{
  public long installStartTime;
  
  public String build()
  {
    return super.build() + "|" + this.installStartTime + "|" + d.a(this.externalParams, "&");
  }
  
  public int getType()
  {
    return 5004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.InstallStartLog
 * JD-Core Version:    0.7.0.1
 */