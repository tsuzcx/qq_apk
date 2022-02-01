package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import org.jetbrains.annotations.NotNull;

public class RIJLiveStatusModule$UserInfoItem
{
  public long a;
  public LiveStatus b;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfoItem{uin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", liveStatus='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.UserInfoItem
 * JD-Core Version:    0.7.0.1
 */