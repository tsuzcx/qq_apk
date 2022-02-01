package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class VideoData
  implements Parcelable
{
  public static final Parcelable.Creator<VideoData> CREATOR = new VideoData.1();
  public static final int a = ((IModelUtil)QRoute.api(IModelUtil.class)).getFeedsProtocolMediaInfoTextFeeds();
  public String A;
  public String B;
  public long C;
  public long D;
  public int E;
  public int F;
  public int G;
  public int H;
  public int I;
  public LocationInfo J;
  public boolean K;
  public boolean L;
  public ArrayList<ImageData> M;
  public TopicInfo N;
  public int O;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public long i;
  public long j;
  public long k;
  public int l;
  public String m;
  public boolean n;
  public boolean o;
  public int p;
  public int q;
  public int r;
  public String s;
  public String t;
  public long u;
  public long v;
  public int w;
  public String x;
  public long y;
  public long z;
  
  public VideoData()
  {
    this.K = false;
    this.L = false;
    this.M = new ArrayList();
  }
  
  public VideoData(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.K = false;
    this.L = false;
    this.M = new ArrayList();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readLong();
    this.m = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.n = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.o = bool1;
    this.p = paramParcel.readInt();
    this.s = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readLong();
    this.y = paramParcel.readLong();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readLong();
    this.F = paramParcel.readInt();
    this.G = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readInt();
  }
  
  public boolean a()
  {
    String str = this.c;
    return (str == null) || (str.equals(""));
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoData{id='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodleUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headerUrl='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", anchorNickName='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeString(this.m);
    paramParcel.writeByte((byte)this.n);
    paramParcel.writeByte((byte)this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeLong(this.u);
    paramParcel.writeLong(this.y);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeLong(this.C);
    paramParcel.writeInt(this.F);
    paramParcel.writeInt(this.G);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.VideoData
 * JD-Core Version:    0.7.0.1
 */