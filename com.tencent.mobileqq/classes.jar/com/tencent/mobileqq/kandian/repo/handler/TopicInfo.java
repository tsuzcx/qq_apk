package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TopicInfo> CREATOR = new TopicInfo.1();
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  protected TopicInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.e = paramParcel.readString();
  }
  
  private TopicInfo(TopicInfo.Builder paramBuilder)
  {
    this.jdField_a_of_type_Long = TopicInfo.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangString = TopicInfo.Builder.a(paramBuilder);
    this.jdField_b_of_type_JavaLangString = TopicInfo.Builder.b(paramBuilder);
    this.c = TopicInfo.Builder.c(paramBuilder);
    this.d = TopicInfo.Builder.d(paramBuilder);
    this.jdField_b_of_type_Long = TopicInfo.Builder.b(paramBuilder);
    this.jdField_a_of_type_Boolean = TopicInfo.Builder.a(paramBuilder);
  }
  
  public static TopicInfo.Builder a()
  {
    return new TopicInfo.Builder(null);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TopicInfo{topicId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", topicTitle='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicSummary='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicCoverUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicJumpUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicUin='");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicBannerUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.TopicInfo
 * JD-Core Version:    0.7.0.1
 */