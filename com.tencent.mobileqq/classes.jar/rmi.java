import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryInfo;

public final class rmi
  implements Parcelable.Creator<DiscoveryInfo>
{
  public DiscoveryInfo a(Parcel paramParcel)
  {
    return new DiscoveryInfo(paramParcel);
  }
  
  public DiscoveryInfo[] a(int paramInt)
  {
    return new DiscoveryInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmi
 * JD-Core Version:    0.7.0.1
 */