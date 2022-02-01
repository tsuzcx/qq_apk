package com.tencent.mobileqq.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecordParams$RecorderParam
  implements Parcelable
{
  public static final Parcelable.Creator<RecorderParam> CREATOR = new RecordParams.RecorderParam.1();
  public int a;
  public Object a;
  public String a;
  public int[] a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public RecordParams$RecorderParam(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  protected RecordParams$RecorderParam(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RecordParams.RecorderParam
 * JD-Core Version:    0.7.0.1
 */