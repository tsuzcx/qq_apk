import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;

public final class pqc
  implements Parcelable.Creator<RecommendFollowInfo>
{
  public RecommendFollowInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
    localRecommendFollowInfo.uin = paramParcel.readLong();
    localRecommendFollowInfo.type = paramParcel.readInt();
    localRecommendFollowInfo.recommendReason = paramParcel.readString();
    localRecommendFollowInfo.nickName = paramParcel.readString();
    localRecommendFollowInfo.headUrl = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localRecommendFollowInfo.isVip = bool1;
      if (paramParcel.readInt() != 1) {
        break label139;
      }
      bool1 = true;
      label82:
      localRecommendFollowInfo.isStar = bool1;
      localRecommendFollowInfo.algorithmId = paramParcel.readLong();
      localRecommendFollowInfo.strategyId = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label144;
      }
    }
    label139:
    label144:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localRecommendFollowInfo.isFollowed = bool1;
      localRecommendFollowInfo.className = paramParcel.readString();
      return localRecommendFollowInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label82;
    }
  }
  
  public RecommendFollowInfo[] a(int paramInt)
  {
    return new RecommendFollowInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqc
 * JD-Core Version:    0.7.0.1
 */