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
  public String b;
  public RectF c;
  public String d;
  
  public QMiniResult() {}
  
  protected QMiniResult(Parcel paramParcel)
  {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readString();
    this.c = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QMiniResult{type");
    localStringBuilder.append(this.d);
    localStringBuilder.append("prob=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", data='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QMiniResult
 * JD-Core Version:    0.7.0.1
 */