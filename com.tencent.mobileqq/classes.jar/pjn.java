import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.common.IPInfo;

public final class pjn
  implements Parcelable.Creator
{
  public IPInfo a(Parcel paramParcel)
  {
    return new IPInfo(paramParcel);
  }
  
  public IPInfo[] a(int paramInt)
  {
    return new IPInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjn
 * JD-Core Version:    0.7.0.1
 */