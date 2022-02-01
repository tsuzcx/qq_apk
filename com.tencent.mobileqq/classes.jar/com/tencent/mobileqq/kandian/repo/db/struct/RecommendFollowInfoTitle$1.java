package com.tencent.mobileqq.kandian.repo.db.struct;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RecommendFollowInfoTitle$1
  implements Parcelable.Creator<RecommendFollowInfoTitle>
{
  public RecommendFollowInfoTitle a(Parcel paramParcel)
  {
    RecommendFollowInfoTitle localRecommendFollowInfoTitle = new RecommendFollowInfoTitle();
    localRecommendFollowInfoTitle.title = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localRecommendFollowInfoTitle.isAllFollowed = bool;
    return localRecommendFollowInfoTitle;
  }
  
  public RecommendFollowInfoTitle[] a(int paramInt)
  {
    return new RecommendFollowInfoTitle[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.RecommendFollowInfoTitle.1
 * JD-Core Version:    0.7.0.1
 */