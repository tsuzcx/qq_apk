package com.tencent.mobileqq.extendfriend.config;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

final class ExtendFriendABTestConfig$ExtendFriendABJson$1
  implements ExclusionStrategy
{
  public boolean shouldSkipClass(Class<?> paramClass)
  {
    return false;
  }
  
  public boolean shouldSkipField(FieldAttributes paramFieldAttributes)
  {
    return "reqTimestamp".equals(paramFieldAttributes.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.config.ExtendFriendABTestConfig.ExtendFriendABJson.1
 * JD-Core Version:    0.7.0.1
 */