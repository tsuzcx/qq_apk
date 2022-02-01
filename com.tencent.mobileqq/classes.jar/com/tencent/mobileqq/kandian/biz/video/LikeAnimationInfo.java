package com.tencent.mobileqq.kandian.biz.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class LikeAnimationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LikeAnimationInfo> CREATOR = new LikeAnimationInfo.1();
  public int a;
  public String[] a;
  
  public LikeAnimationInfo() {}
  
  protected LikeAnimationInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramParcel.createStringArray();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LikeAnimationInfo{icons=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    localStringBuilder.append(", nextReqInterval=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.LikeAnimationInfo
 * JD-Core Version:    0.7.0.1
 */