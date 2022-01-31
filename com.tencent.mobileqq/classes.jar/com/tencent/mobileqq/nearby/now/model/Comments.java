package com.tencent.mobileqq.nearby.now.model;

import aegf;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Comments
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aegf();
  public long a;
  public List a;
  public boolean a;
  public List b = new ArrayList();
  
  public Comments()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public Comments(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, Comments.Comment.CREATOR);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.Comments
 * JD-Core Version:    0.7.0.1
 */