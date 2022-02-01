package com.tencent.weseevideo.model.data;

import java.io.Serializable;

public class MusicData
  implements Serializable
{
  private String path = "";
  private int segDuration = 0;
  private int startTime = 0;
  private int totalTime = 0;
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getSegDuration()
  {
    return this.segDuration;
  }
  
  public int getStartTime()
  {
    return this.startTime;
  }
  
  public int getTotalTime()
  {
    return this.totalTime;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSegDuration(int paramInt)
  {
    this.segDuration = paramInt;
  }
  
  public void setStartTime(int paramInt)
  {
    this.startTime = paramInt;
  }
  
  public void setTotalTime(int paramInt)
  {
    this.totalTime = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.data.MusicData
 * JD-Core Version:    0.7.0.1
 */