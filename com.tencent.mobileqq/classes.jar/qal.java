import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public final class qal
  implements Parcelable.Creator<AdvertisementInfo>
{
  public AdvertisementInfo a(Parcel paramParcel)
  {
    return new AdvertisementInfo(paramParcel);
  }
  
  public AdvertisementInfo[] a(int paramInt)
  {
    return new AdvertisementInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qal
 * JD-Core Version:    0.7.0.1
 */