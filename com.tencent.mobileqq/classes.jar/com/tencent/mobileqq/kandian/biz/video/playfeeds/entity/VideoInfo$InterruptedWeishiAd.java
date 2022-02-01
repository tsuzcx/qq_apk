package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import java.util.Arrays;

public class VideoInfo$InterruptedWeishiAd
  implements Parcelable
{
  public static final Parcelable.Creator<InterruptedWeishiAd> CREATOR = new VideoInfo.InterruptedWeishiAd.1();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public boolean a;
  public int[] a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  
  public VideoInfo$InterruptedWeishiAd()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
  }
  
  protected VideoInfo$InterruptedWeishiAd(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = paramParcel.createIntArray();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      localObject = "弹出式web页面";
    } else if (i == 1) {
      localObject = HardCodeUtil.a(2131716034);
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InterruptedWeishiAd{showPositon=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfInt));
    localStringBuilder.append(", isShowInSwitch=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isShowInPlayEnd=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", showAfterPlayTime=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", adUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", downloadBtnText=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", openBtnText=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", appInfo=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((UrlJumpInfo)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd
 * JD-Core Version:    0.7.0.1
 */