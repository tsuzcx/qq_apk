package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TopicInfo> CREATOR = new TopicInfo.1();
  private long a;
  private String b;
  private String c;
  private String d;
  private String e;
  private long f;
  private String g;
  private boolean h;
  private long i;
  private long j;
  
  protected TopicInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readString();
    this.j = paramParcel.readLong();
    this.i = paramParcel.readLong();
  }
  
  private TopicInfo(TopicInfo.Builder paramBuilder)
  {
    this.a = TopicInfo.Builder.a(paramBuilder);
    this.b = TopicInfo.Builder.b(paramBuilder);
    this.c = TopicInfo.Builder.c(paramBuilder);
    this.d = TopicInfo.Builder.d(paramBuilder);
    this.e = TopicInfo.Builder.e(paramBuilder);
    this.f = TopicInfo.Builder.f(paramBuilder);
    this.h = TopicInfo.Builder.g(paramBuilder);
    this.j = TopicInfo.Builder.h(paramBuilder);
    this.i = TopicInfo.Builder.i(paramBuilder);
  }
  
  public static TopicInfo.Builder g()
  {
    return new TopicInfo.Builder(null);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long e()
  {
    return this.i;
  }
  
  public long f()
  {
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TopicInfo{topicId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", topicTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicSummary='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicCoverUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicJumpUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicUin='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicBannerUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicDiscussNum='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicReadingNum='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
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
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.i);
    paramParcel.writeLong(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.TopicInfo
 * JD-Core Version:    0.7.0.1
 */