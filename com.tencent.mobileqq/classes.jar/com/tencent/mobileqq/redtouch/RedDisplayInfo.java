package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axlu;
import java.util.ArrayList;
import java.util.List;

public class RedDisplayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedDisplayInfo> CREATOR = new axlu();
  private RedTypeInfo a;
  public ArrayList<RedTypeInfo> a;
  
  public RedTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo;
  }
  
  public List<RedTypeInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(RedTypeInfo paramRedTypeInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo = paramRedTypeInfo;
  }
  
  public void a(ArrayList<RedTypeInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeSerializable(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */