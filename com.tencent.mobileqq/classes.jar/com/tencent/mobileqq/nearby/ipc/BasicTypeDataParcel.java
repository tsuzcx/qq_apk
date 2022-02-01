package com.tencent.mobileqq.nearby.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awom;

public class BasicTypeDataParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BasicTypeDataParcel> CREATOR = new awom();
  public int a;
  public Object[] a;
  
  public BasicTypeDataParcel(int paramInt, Object... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
  }
  
  public BasicTypeDataParcel(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramParcel.readArray(Object.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--------------------start-------------------");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    if (this.jdField_a_of_type_ArrayOfJavaLangObject != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangObject.length)
      {
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangObject[i]);
        localStringBuilder.append("\n");
        i += 1;
      }
    }
    localStringBuilder.append("--------------------end-------------------");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeArray(this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel
 * JD-Core Version:    0.7.0.1
 */