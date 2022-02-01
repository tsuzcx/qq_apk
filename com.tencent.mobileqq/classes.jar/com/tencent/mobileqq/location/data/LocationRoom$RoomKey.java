package com.tencent.mobileqq.location.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class LocationRoom$RoomKey
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  
  public LocationRoom$RoomKey(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_JavaLangString.equals(paramString));
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
    if (this.jdField_a_of_type_Int == paramObject.a())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaLangString.equals(paramObject.a())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoomKey{mHashCode='");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", mSessionType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mSessionUin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom.RoomKey
 * JD-Core Version:    0.7.0.1
 */