package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import athn;
import java.util.ArrayList;
import java.util.List;

public class MedalInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MedalInfo> CREATOR = new athn();
  public int a;
  public List<MedalItem> a;
  public int b;
  public int c;
  
  public MedalInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public MedalInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, MedalItem.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MedalInfo)) {}
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.MedalInfo
 * JD-Core Version:    0.7.0.1
 */