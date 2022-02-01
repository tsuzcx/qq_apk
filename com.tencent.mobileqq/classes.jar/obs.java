import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;

public final class obs
  implements Parcelable.Creator<VideoInfo.ECommerceEntranceInfo>
{
  public VideoInfo.ECommerceEntranceInfo a(Parcel paramParcel)
  {
    return new VideoInfo.ECommerceEntranceInfo(paramParcel);
  }
  
  public VideoInfo.ECommerceEntranceInfo[] a(int paramInt)
  {
    return new VideoInfo.ECommerceEntranceInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */