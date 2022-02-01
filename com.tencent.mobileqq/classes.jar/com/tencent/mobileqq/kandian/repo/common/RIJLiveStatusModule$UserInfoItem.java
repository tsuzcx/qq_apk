package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import org.jetbrains.annotations.NotNull;

public class RIJLiveStatusModule$UserInfoItem
{
  public long a;
  public LiveStatus a;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfoItem{uin='");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", liveStatus='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.UserInfoItem
 * JD-Core Version:    0.7.0.1
 */