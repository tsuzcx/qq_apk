package com.tencent.mobileqq.qrscan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScannerParams
  implements Parcelable
{
  public static final Parcelable.Creator<ScannerParams> CREATOR = new ScannerParams.1();
  public boolean a;
  public String b;
  public String c;
  public String d;
  public boolean e;
  public boolean f;
  public boolean g;
  public int h;
  public String i;
  public ScannerResult j;
  
  public ScannerParams() {}
  
  protected ScannerParams(Parcel paramParcel)
  {
    int k = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (k != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = ((ScannerResult)paramParcel.readParcelable(ScannerResult.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScannerParams { scanForResult: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("  from: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("  fromPicQRDecode: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("  detectType: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("  preResult: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("  preScanResult: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("  hasCameraSysFeature: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("  toDecodeFilePath: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  qrPhotoPath: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeParcelable(this.j, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ScannerParams
 * JD-Core Version:    0.7.0.1
 */