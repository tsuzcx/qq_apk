package com.tencent.mobileqq.leba.entity;

import androidx.annotation.Nullable;

public class LebaPluginSettingItem
{
  public long a;
  public int b;
  
  public LebaPluginSettingItem(long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.b = paramInt;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (LebaPluginSettingItem)paramObject;
      return (this.a == paramObject.a) && (this.b == paramObject.b);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaPluginSettingItem
 * JD-Core Version:    0.7.0.1
 */