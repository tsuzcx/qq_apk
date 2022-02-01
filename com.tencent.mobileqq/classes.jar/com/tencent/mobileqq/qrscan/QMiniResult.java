package com.tencent.mobileqq.qrscan;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QMiniResult
  implements Parcelable
{
  public static final Parcelable.Creator<QMiniResult> CREATOR = new QMiniResult.1();
  public float a;
  public RectF a;
  public String a;
  
  public QMiniResult() {}
  
  protected QMiniResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QMiniResult{prob=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", data='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRectF);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRectF, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QMiniResult
 * JD-Core Version:    0.7.0.1
 */