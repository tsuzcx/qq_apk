package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AnchorData
  implements Parcelable
{
  public static final Parcelable.Creator<AnchorData> CREATOR = new AnchorData.1();
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public AnchorData()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData
 * JD-Core Version:    0.7.0.1
 */