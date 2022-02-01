package com.tencent.mobileqq.location.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class LocationRoom$RoomKey
{
  private final int a;
  private final String b;
  
  public LocationRoom$RoomKey(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return (this.a == paramInt) && (this.b.equals(paramString));
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof RoomKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (RoomKey)paramObject;
    bool1 = bool2;
    if (this.a == paramObject.a())
    {
      bool1 = bool2;
      if (this.b.equals(paramObject.b())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.a + this.b.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoomKey{mHashCode='");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", mSessionType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mSessionUin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom.RoomKey
 * JD-Core Version:    0.7.0.1
 */