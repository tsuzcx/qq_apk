package com.tencent.thumbplayer.api;

public class TPProgramInfo
{
  public boolean actived;
  public long bandwidth;
  public int programId;
  public String resolution;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPProgramInfo{bandwidth=");
    localStringBuilder.append(this.bandwidth);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resolution='");
    localStringBuilder.append(this.resolution);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPProgramInfo
 * JD-Core Version:    0.7.0.1
 */