package com.tencent.mobileqq.kandian.biz.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class LikeAnimationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LikeAnimationInfo> CREATOR = new LikeAnimationInfo.1();
  public String[] a;
  public int b;
  
  public LikeAnimationInfo() {}
  
  protected LikeAnimationInfo(Parcel paramParcel)
  {
    this.a = paramParcel.createStringArray();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LikeAnimationInfo{icons=");
    localStringBuilder.append(Arrays.toString(this.a));
    localStringBuilder.append(", nextReqInterval=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.LikeAnimationInfo
 * JD-Core Version:    0.7.0.1
 */