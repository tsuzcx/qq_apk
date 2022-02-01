package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

public class CMTimeMapping
{
  @NonNull
  private CMTimeRange source;
  @NonNull
  private CMTimeRange target;
  
  public CMTimeMapping(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    this.source = paramCMTimeRange1.clone();
    this.target = paramCMTimeRange2.clone();
  }
  
  @NonNull
  public CMTimeRange getSource()
  {
    return this.source;
  }
  
  @NonNull
  public CMTimeRange getTarget()
  {
    return this.target;
  }
  
  public void setSource(@NonNull CMTimeRange paramCMTimeRange)
  {
    Utils.checkNotNull(paramCMTimeRange);
    this.source = paramCMTimeRange.clone();
  }
  
  public void setTarget(@NonNull CMTimeRange paramCMTimeRange)
  {
    Utils.checkNotNull(paramCMTimeRange);
    this.target = paramCMTimeRange.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CMTimeMapping{source=");
    localStringBuilder.append(this.source.toSimpleString());
    localStringBuilder.append(", target=");
    localStringBuilder.append(this.target.toSimpleString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTimeMapping
 * JD-Core Version:    0.7.0.1
 */