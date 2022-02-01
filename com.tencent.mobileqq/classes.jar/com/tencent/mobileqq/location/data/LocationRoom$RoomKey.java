package com.tencent.mobileqq.location.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class LocationRoom$RoomKey
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
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
    if (!(paramObject instanceof RoomKey)) {}
    do
    {
      return false;
      paramObject = (RoomKey)paramObject;
    } while ((this.jdField_a_of_type_Int != paramObject.a()) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.a())));
    return true;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    return "RoomKey{mHashCode='" + hashCode() + ", mSessionType=" + this.jdField_a_of_type_Int + ", mSessionUin=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom.RoomKey
 * JD-Core Version:    0.7.0.1
 */