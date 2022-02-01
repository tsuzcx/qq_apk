package com.tencent.replacemonitor.replace.st;

import com.tencent.tmassistantbase.util.d;

public class DownloadStartLog
  extends ReplaceBaseLog
{
  public long downloadStartTime;
  
  public String build()
  {
    return super.build() + "|" + this.downloadStartTime + "|" + d.a(this.externalParams, "&");
  }
  
  public int getType()
  {
    return 5002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.DownloadStartLog
 * JD-Core Version:    0.7.0.1
 */