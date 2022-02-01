package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TranslateResult$Record
  implements Parcelable
{
  public static final Parcelable.Creator<Record> CREATOR = new TranslateResult.Record.1();
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public String g;
  
  public TranslateResult$Record() {}
  
  protected TranslateResult$Record(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Record{srcText='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dstText='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", angle='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.TranslateResult.Record
 * JD-Core Version:    0.7.0.1
 */