package com.tencent.qbar;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjuo;

public class QBarResult
  implements Parcelable
{
  public static final Parcelable.Creator<QBarResult> CREATOR = new bjuo();
  public float a;
  public RectF a;
  public String a;
  public String b;
  
  public QBarResult() {}
  
  public QBarResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "QbarScanResult{prob=" + this.jdField_a_of_type_Float + ", typeName='" + this.jdField_a_of_type_JavaLangString + '\'' + ", data='" + this.b + '\'' + ", location=" + this.jdField_a_of_type_AndroidGraphicsRectF + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRectF, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qbar.QBarResult
 * JD-Core Version:    0.7.0.1
 */