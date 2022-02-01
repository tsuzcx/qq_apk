package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class VideoInfo$DownloadBarInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadBarInfo> CREATOR = new VideoInfo.DownloadBarInfo.1();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public VideoInfo$DownloadBarInfo() {}
  
  protected VideoInfo$DownloadBarInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadBarInfo{appearTime=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", logoUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadBtnText='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", openBtnText='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", buttonBgColor=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", jumpInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append(", commonData='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.DownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */