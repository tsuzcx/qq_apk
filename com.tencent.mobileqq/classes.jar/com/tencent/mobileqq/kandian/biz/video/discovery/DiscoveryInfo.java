package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class DiscoveryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoveryInfo> CREATOR = new DiscoveryInfo.1();
  public long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public boolean g;
  public int h;
  public int i;
  public String j;
  public ArrayList<DiscoveryInfo.TopicVideoCard> k;
  public int[] l = new int[2];
  
  public DiscoveryInfo() {}
  
  protected DiscoveryInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    int m = paramParcel.readInt();
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    this.g = bool;
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.k = paramParcel.createTypedArrayList(DiscoveryInfo.TopicVideoCard.CREATOR);
    this.j = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscoveryInfo{topicId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subtitle='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playCounts=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasRecomment=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", effectiveTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", expiationTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", commonData=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", topicVideoCards=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    if (this.g) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramParcel.writeInt(paramInt);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeTypedList(this.k);
    paramParcel.writeString(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.DiscoveryInfo
 * JD-Core Version:    0.7.0.1
 */