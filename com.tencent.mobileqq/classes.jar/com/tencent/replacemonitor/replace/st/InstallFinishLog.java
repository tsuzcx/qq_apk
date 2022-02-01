package com.tencent.replacemonitor.replace.st;

import com.tencent.tmassistantbase.util.d;

public class InstallFinishLog
  extends ReplaceBaseLog
{
  public long installEndTime;
  
  public String build()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.build());
    localStringBuilder.append("|");
    localStringBuilder.append(this.installEndTime);
    localStringBuilder.append("|");
    localStringBuilder.append(d.a(this.externalParams, "&"));
    return localStringBuilder.toString();
  }
  
  protected int getType()
  {
    return 5005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.InstallFinishLog
 * JD-Core Version:    0.7.0.1
 */