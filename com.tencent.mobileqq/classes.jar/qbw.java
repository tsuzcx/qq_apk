import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfoTitle;

public final class qbw
  implements Parcelable.Creator<RecommendFollowInfoTitle>
{
  public RecommendFollowInfoTitle a(Parcel paramParcel)
  {
    boolean bool = true;
    RecommendFollowInfoTitle localRecommendFollowInfoTitle = new RecommendFollowInfoTitle();
    localRecommendFollowInfoTitle.title = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localRecommendFollowInfoTitle.isAllFollowed = bool;
      return localRecommendFollowInfoTitle;
      bool = false;
    }
  }
  
  public RecommendFollowInfoTitle[] a(int paramInt)
  {
    return new RecommendFollowInfoTitle[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbw
 * JD-Core Version:    0.7.0.1
 */