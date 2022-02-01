package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DiscoveryInfo$TopicVideoCard
  implements Parcelable
{
  public static final Parcelable.Creator<TopicVideoCard> CREATOR = new DiscoveryInfo.TopicVideoCard.1();
  public String a;
  public String b;
  public long c;
  public long d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public long w;
  public long x;
  public long y;
  public boolean z;
  
  public DiscoveryInfo$TopicVideoCard() {}
  
  protected DiscoveryInfo$TopicVideoCard(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readInt();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readLong();
    this.x = paramParcel.readLong();
    this.y = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.z = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TopicVideoCard{cornerIconUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", topicId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rowKey='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountName='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountUin='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdAction='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdIconUrl='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdUinName='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleTitle='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleSummary='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", firstPagePicUrl='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleContentUrl='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", busiType=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", feedsType=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", feedsId=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", xgFileSize=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", isUgc=");
    localStringBuilder.append(this.z);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeLong(this.w);
    paramParcel.writeLong(this.x);
    paramParcel.writeLong(this.y);
    paramParcel.writeByte((byte)this.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.DiscoveryInfo.TopicVideoCard
 * JD-Core Version:    0.7.0.1
 */