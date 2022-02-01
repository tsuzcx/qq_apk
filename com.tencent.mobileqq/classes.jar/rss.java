import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;

public final class rss
  implements Parcelable.Creator<LikeAnimationInfo>
{
  public LikeAnimationInfo a(Parcel paramParcel)
  {
    return new LikeAnimationInfo(paramParcel);
  }
  
  public LikeAnimationInfo[] a(int paramInt)
  {
    return new LikeAnimationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rss
 * JD-Core Version:    0.7.0.1
 */