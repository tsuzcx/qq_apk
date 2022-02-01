package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AnchorData$1
  implements Parcelable.Creator<AnchorData>
{
  public AnchorData a(Parcel paramParcel)
  {
    AnchorData localAnchorData = new AnchorData();
    localAnchorData.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localAnchorData.jdField_b_of_type_JavaLangString = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localAnchorData.jdField_a_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localAnchorData.jdField_b_of_type_Boolean = bool1;
    return localAnchorData;
  }
  
  public AnchorData[] a(int paramInt)
  {
    return new AnchorData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData.1
 * JD-Core Version:    0.7.0.1
 */