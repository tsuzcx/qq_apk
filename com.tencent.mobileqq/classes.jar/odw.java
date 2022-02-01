import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;

public final class odw
  implements Parcelable.Creator<RecentShopParcel>
{
  public RecentShopParcel a(Parcel paramParcel)
  {
    return new RecentShopParcel(paramParcel);
  }
  
  public RecentShopParcel[] a(int paramInt)
  {
    return new RecentShopParcel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odw
 * JD-Core Version:    0.7.0.1
 */