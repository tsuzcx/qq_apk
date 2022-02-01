package com.tencent.mobileqq.phonecontact.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class RecommendedListResp
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendedListResp> CREATOR = new RecommendedListResp.1();
  public int a;
  public long a;
  public List<PhoneInfo> a;
  public int b;
  
  public RecommendedListResp()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected RecommendedListResp(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(PhoneInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.RecommendedListResp
 * JD-Core Version:    0.7.0.1
 */