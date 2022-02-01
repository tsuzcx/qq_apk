package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjqb;

public class ExpandableListConnector$GroupMetadata
  implements Parcelable, Comparable<GroupMetadata>
{
  public static final Parcelable.Creator<GroupMetadata> CREATOR = new bjqb();
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int b;
  int c;
  
  public static GroupMetadata a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    GroupMetadata localGroupMetadata = new GroupMetadata();
    localGroupMetadata.jdField_a_of_type_Int = paramInt1;
    localGroupMetadata.b = paramInt2;
    localGroupMetadata.c = paramInt3;
    localGroupMetadata.jdField_a_of_type_Long = paramLong;
    return localGroupMetadata;
  }
  
  public int a(GroupMetadata paramGroupMetadata)
  {
    if (paramGroupMetadata == null) {
      throw new IllegalArgumentException();
    }
    return this.c - paramGroupMetadata.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.GroupMetadata
 * JD-Core Version:    0.7.0.1
 */