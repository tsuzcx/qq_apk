package com.tencent.mobileqq.kandian.repo.biu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import java.util.ArrayList;

public class MultiBiuSameContent
  implements Parcelable
{
  public static final Parcelable.Creator<MultiBiuSameContent> CREATOR = new MultiBiuSameContent.1();
  public int a;
  public long a;
  public String a;
  public ArrayList<BiuCommentInfo> a;
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  
  public MultiBiuSameContent()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected MultiBiuSameContent(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(BiuCommentInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent
 * JD-Core Version:    0.7.0.1
 */