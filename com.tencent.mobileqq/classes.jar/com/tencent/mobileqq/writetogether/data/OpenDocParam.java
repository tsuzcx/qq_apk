package com.tencent.mobileqq.writetogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.List;

public class OpenDocParam
  implements Parcelable
{
  public static final Parcelable.Creator<OpenDocParam> CREATOR = new OpenDocParam.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public String h;
  public String i;
  public int j;
  public int k;
  public String l;
  public int m;
  public String n;
  public long o;
  public long p;
  public List<EditUserHistory> q;
  public long r;
  public int s;
  public int t;
  public String u;
  public int v = 1;
  public int w;
  
  public OpenDocParam() {}
  
  protected OpenDocParam(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.o = paramParcel.readLong();
    this.p = paramParcel.readLong();
    this.r = paramParcel.readLong();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readString();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes_global_padid");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_doc_type");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_title");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextName");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextSubId");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextText");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextAttr");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("aTextAPool");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_subid");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_baseRev");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_baseLen");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_meta");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint32_sheetPosLen");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n");
    localStringBuilder.append("bytes_owner_appid");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint64_baseLen");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint64_sheetPosLen");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n");
    localStringBuilder.append("ownerUin");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n");
    localStringBuilder.append("maxLen");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n");
    localStringBuilder.append("uint64_group_code");
    localStringBuilder.append(this.u);
    localStringBuilder.append("\n");
    localStringBuilder.append("launchType");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\n");
    localStringBuilder.append("showSoftInput");
    localStringBuilder.append(this.v);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeLong(this.o);
    paramParcel.writeLong(this.p);
    paramParcel.writeLong(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.OpenDocParam
 * JD-Core Version:    0.7.0.1
 */