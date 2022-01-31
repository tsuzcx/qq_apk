import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult;

public final class pjg
  implements Parcelable.Creator
{
  public DownloadResult a(Parcel paramParcel)
  {
    return new DownloadResult(paramParcel);
  }
  
  public DownloadResult[] a(int paramInt)
  {
    return new DownloadResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjg
 * JD-Core Version:    0.7.0.1
 */