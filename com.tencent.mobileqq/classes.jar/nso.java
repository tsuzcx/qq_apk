import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;

public final class nso
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nso
 * JD-Core Version:    0.7.0.1
 */