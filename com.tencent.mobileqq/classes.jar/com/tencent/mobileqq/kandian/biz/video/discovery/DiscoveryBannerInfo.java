package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DiscoveryBannerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoveryBannerInfo> CREATOR = new DiscoveryBannerInfo.1();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  
  public DiscoveryBannerInfo() {}
  
  protected DiscoveryBannerInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscoveryBannerInfo{bannerId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", jumpDataJson='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.DiscoveryBannerInfo
 * JD-Core Version:    0.7.0.1
 */