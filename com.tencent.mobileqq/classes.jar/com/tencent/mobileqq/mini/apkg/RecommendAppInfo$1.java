package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RecommendAppInfo$1
  implements Parcelable.Creator<RecommendAppInfo>
{
  public RecommendAppInfo createFromParcel(Parcel paramParcel)
  {
    RecommendAppInfo localRecommendAppInfo = new RecommendAppInfo();
    localRecommendAppInfo.appId = paramParcel.readString();
    localRecommendAppInfo.exposuredNum = paramParcel.readInt();
    localRecommendAppInfo.pullTime = paramParcel.readLong();
    return localRecommendAppInfo;
  }
  
  public RecommendAppInfo[] newArray(int paramInt)
  {
    return new RecommendAppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.RecommendAppInfo.1
 * JD-Core Version:    0.7.0.1
 */