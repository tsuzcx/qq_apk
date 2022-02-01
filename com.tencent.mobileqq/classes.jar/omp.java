import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.SubscriptInfo;

public final class omp
  implements Parcelable.Creator<VideoInfo.SubscriptInfo>
{
  public VideoInfo.SubscriptInfo a(Parcel paramParcel)
  {
    return new VideoInfo.SubscriptInfo(paramParcel);
  }
  
  public VideoInfo.SubscriptInfo[] a(int paramInt)
  {
    return new VideoInfo.SubscriptInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omp
 * JD-Core Version:    0.7.0.1
 */