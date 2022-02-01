package com.tencent.mobileqq.kandian.repo.follow;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RecommendFollowInfo$1
  implements Parcelable.Creator<RecommendFollowInfo>
{
  public RecommendFollowInfo a(Parcel paramParcel)
  {
    RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
    localRecommendFollowInfo.uin = paramParcel.readLong();
    localRecommendFollowInfo.type = paramParcel.readInt();
    localRecommendFollowInfo.recommendReason = paramParcel.readString();
    localRecommendFollowInfo.nickName = paramParcel.readString();
    localRecommendFollowInfo.headUrl = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localRecommendFollowInfo.isVip = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localRecommendFollowInfo.isStar = bool1;
    localRecommendFollowInfo.algorithmId = paramParcel.readLong();
    localRecommendFollowInfo.strategyId = paramParcel.readInt();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localRecommendFollowInfo.isFollowed = bool1;
    localRecommendFollowInfo.className = paramParcel.readString();
    return localRecommendFollowInfo;
  }
  
  public RecommendFollowInfo[] a(int paramInt)
  {
    return new RecommendFollowInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo.1
 * JD-Core Version:    0.7.0.1
 */