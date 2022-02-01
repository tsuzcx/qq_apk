import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryBannerInfo;

public final class sht
  implements Parcelable.Creator<DiscoveryBannerInfo>
{
  public DiscoveryBannerInfo a(Parcel paramParcel)
  {
    return new DiscoveryBannerInfo(paramParcel);
  }
  
  public DiscoveryBannerInfo[] a(int paramInt)
  {
    return new DiscoveryBannerInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sht
 * JD-Core Version:    0.7.0.1
 */