import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryInfo.TopicVideoCard;

public final class rmj
  implements Parcelable.Creator<DiscoveryInfo.TopicVideoCard>
{
  public DiscoveryInfo.TopicVideoCard a(Parcel paramParcel)
  {
    return new DiscoveryInfo.TopicVideoCard(paramParcel);
  }
  
  public DiscoveryInfo.TopicVideoCard[] a(int paramInt)
  {
    return new DiscoveryInfo.TopicVideoCard[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmj
 * JD-Core Version:    0.7.0.1
 */