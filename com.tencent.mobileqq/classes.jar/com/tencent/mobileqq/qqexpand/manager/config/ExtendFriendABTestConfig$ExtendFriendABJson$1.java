package com.tencent.mobileqq.qqexpand.manager.config;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExtendFriendABTestConfig.ExtendFriendABJson.1
 * JD-Core Version:    0.7.0.1
 */