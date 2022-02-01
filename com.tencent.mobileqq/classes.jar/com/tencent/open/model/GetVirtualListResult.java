package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class GetVirtualListResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetVirtualListResult> CREATOR = new GetVirtualListResult.1();
  public int a;
  public long a;
  public ArrayList<VirtualInfo> a;
  
  public GetVirtualListResult() {}
  
  protected GetVirtualListResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(VirtualInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("GetVirtualListResult={");
    localStringBuilder1.append("errorCode=").append(this.jdField_a_of_type_Int).append(",");
    localStringBuilder1.append("curVirtualId=").append(this.jdField_a_of_type_Long).append(",");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("list=");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (String str = this.jdField_a_of_type_JavaUtilArrayList.toString();; str = "null")
    {
      localStringBuilder2.append(str).append("}");
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.model.GetVirtualListResult
 * JD-Core Version:    0.7.0.1
 */