package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import java.util.Arrays;

public class VideoInfo$ECommerceEntranceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECommerceEntranceInfo> CREATOR = new VideoInfo.ECommerceEntranceInfo.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public String f;
  public int[] g;
  public int h = -1;
  public int i = -1;
  public String j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public UrlJumpInfo p;
  public String q;
  public String r;
  
  public VideoInfo$ECommerceEntranceInfo() {}
  
  protected VideoInfo$ECommerceEntranceInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.createIntArray();
    this.i = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commerceEntranceInfo{title='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbnailUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkIconUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", showPosition=");
    localStringBuilder.append(Arrays.toString(this.g));
    localStringBuilder.append(", showPercent=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", playTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", commonData=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", displayCountsVersion=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", sessionDisplayCounts=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", oneDayMaxDisplayCounts=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", videoSource=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", style=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", appInfo=");
    Object localObject = this.p;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((UrlJumpInfo)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", downloadBtnText=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", openBtnText=");
    localStringBuilder.append(this.r);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeIntArray(this.g);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeParcelable(this.p, paramInt);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo
 * JD-Core Version:    0.7.0.1
 */