package com.tencent.mobileqq.qrscan;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QBarResult
  implements Parcelable
{
  public static final Parcelable.Creator<QBarResult> CREATOR = new QBarResult.1();
  public float a;
  public String b;
  public String c;
  public RectF d;
  
  public QBarResult() {}
  
  protected QBarResult(Parcel paramParcel)
  {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QbarScanResult{prob=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", typeName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", data='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.d, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QBarResult
 * JD-Core Version:    0.7.0.1
 */