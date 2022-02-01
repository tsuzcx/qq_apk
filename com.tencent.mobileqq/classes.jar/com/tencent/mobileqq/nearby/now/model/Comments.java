package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Comments
  implements Parcelable
{
  public static final Parcelable.Creator<Comments> CREATOR = new Comments.1();
  public long a;
  public Comments.LastDeleteInfo a;
  public List<Comments.Comment> a;
  public boolean a;
  public List<Comments.Comment> b = new ArrayList();
  
  public Comments()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$LastDeleteInfo = null;
  }
  
  public Comments(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$LastDeleteInfo = null;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, Comments.Comment.CREATOR);
  }
  
  public boolean a(Comments.Comment paramComment)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramComment);
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
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.Comments
 * JD-Core Version:    0.7.0.1
 */