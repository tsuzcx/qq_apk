package com.tencent.replacemonitor.replace.st;

import com.tencent.tmassistantbase.util.d;

public class DownloadFinishLog
  extends ReplaceBaseLog
{
  public long downloadFinishTime;
  
  public String build()
  {
    return super.build() + "|" + this.downloadFinishTime + "|" + d.a(this.externalParams, "&");
  }
  
  public int getType()
  {
    return 5003;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.DownloadFinishLog
 * JD-Core Version:    0.7.0.1
 */