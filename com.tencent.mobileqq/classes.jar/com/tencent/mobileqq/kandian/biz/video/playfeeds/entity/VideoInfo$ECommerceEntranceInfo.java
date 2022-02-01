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
  public int a;
  public UrlJumpInfo a;
  public String a;
  public int[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  
  public VideoInfo$ECommerceEntranceInfo()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  protected VideoInfo$ECommerceEntranceInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfInt = paramParcel.createIntArray();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commerceEntranceInfo{title='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbnailUrl='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkIconUrl='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", showPosition=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfInt));
    localStringBuilder.append(", showPercent=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", playTime=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", commonData=");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(", displayCountsVersion=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", sessionDisplayCounts=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", oneDayMaxDisplayCounts=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", videoSource=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", style=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(", appInfo=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((UrlJumpInfo)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", downloadBtnText=");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append(", openBtnText=");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo
 * JD-Core Version:    0.7.0.1
 */