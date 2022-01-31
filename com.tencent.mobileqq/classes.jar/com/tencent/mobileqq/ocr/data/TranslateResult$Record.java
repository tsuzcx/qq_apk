package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import auck;

public class TranslateResult$Record
  implements Parcelable
{
  public static final Parcelable.Creator<Record> CREATOR = new auck();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public TranslateResult$Record() {}
  
  public TranslateResult$Record(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "Record{srcText='" + this.jdField_a_of_type_JavaLangString + '\'' + ", dstText='" + this.jdField_b_of_type_JavaLangString + '\'' + ", x=" + this.jdField_a_of_type_Int + ", y=" + this.jdField_b_of_type_Int + ", width=" + this.jdField_c_of_type_Int + ", height=" + this.d + ", angle='" + this.jdField_c_of_type_JavaLangString + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.TranslateResult.Record
 * JD-Core Version:    0.7.0.1
 */