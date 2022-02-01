package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.qphone.base.util.BaseApplication;

public class CompressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CompressInfo> CREATOR = new CompressInfo.1();
  public String a;
  public int b = -1;
  public boolean c;
  public boolean d;
  public boolean e;
  public String f;
  public boolean g = true;
  public String h;
  public int i;
  public int j;
  public String k;
  public String l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q = 2;
  public int r;
  public String s;
  public boolean t;
  public boolean u = false;
  public int v = -1;
  public boolean w = false;
  public ThumbWidthHeightDP x;
  
  public CompressInfo() {}
  
  private CompressInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public CompressInfo(String paramString, int paramInt)
  {
    this.h = paramString;
    this.p = paramInt;
  }
  
  public CompressInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.h = paramString;
    this.p = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean[] arrayOfBoolean = new boolean[7];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.c = arrayOfBoolean[0];
    this.d = arrayOfBoolean[1];
    this.c = arrayOfBoolean[0];
    this.d = arrayOfBoolean[1];
    this.e = arrayOfBoolean[2];
    this.g = arrayOfBoolean[3];
    this.t = arrayOfBoolean[4];
    this.u = arrayOfBoolean[5];
    this.w = arrayOfBoolean[6];
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readInt();
    this.s = paramParcel.readString();
    this.v = paramParcel.readInt();
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i1;
    if (paramBoolean) {
      i1 = 2131887984;
    } else {
      i1 = 2131887980;
    }
    this.f = localBaseApplication.getString(i1);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nCompressInfo");
    localStringBuilder.append("\n|-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isSuccess:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isOOM:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isOOS:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("oomMsg:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("srcPath:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("specPath:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("destPath:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("picType:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("picQuality:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("networkType:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("sampleCompressCnt:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("compressMsg:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isResultOriginal:");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("uinType:");
    localStringBuilder.append(this.v);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mCheckJpgQualityAndSize:");
    localStringBuilder.append(this.w);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isOverride:");
    localStringBuilder.append(this.u);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { this.c, this.d, this.e, this.g, this.t, this.u, this.w });
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.CompressInfo
 * JD-Core Version:    0.7.0.1
 */