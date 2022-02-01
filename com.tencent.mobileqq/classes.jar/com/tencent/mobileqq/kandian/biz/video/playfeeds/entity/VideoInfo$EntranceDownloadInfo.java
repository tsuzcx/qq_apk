package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class VideoInfo$EntranceDownloadInfo
  implements Parcelable, IEntranceButtonDataSource
{
  public static final Parcelable.Creator<EntranceDownloadInfo> CREATOR = new VideoInfo.EntranceDownloadInfo.1();
  public UrlJumpInfo a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public VideoInfo$EntranceDownloadInfo() {}
  
  protected VideoInfo$EntranceDownloadInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.b) ^ true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntranceDownloadInfo{iconUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", smallIconUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isUseGif='");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commonData='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpInfo='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo
 * JD-Core Version:    0.7.0.1
 */