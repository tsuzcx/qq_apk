package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avzx;
import avzy;
import java.util.ArrayList;
import java.util.List;

public class FriendGroupListInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendGroupListInfo> CREATOR = new avzy();
  public int a;
  public List<avzx> a;
  
  public FriendGroupListInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendGroupListInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      avzx localavzx = new avzx();
      localavzx.b(paramParcel);
      this.jdField_a_of_type_JavaUtilList.add(localavzx);
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_a_of_type_JavaUtilList.size());
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((avzx)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramParcel);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo
 * JD-Core Version:    0.7.0.1
 */