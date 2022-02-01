import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.DownloadBarInfo;

public final class ome
  implements Parcelable.Creator<VideoInfo.DownloadBarInfo>
{
  public VideoInfo.DownloadBarInfo a(Parcel paramParcel)
  {
    return new VideoInfo.DownloadBarInfo(paramParcel);
  }
  
  public VideoInfo.DownloadBarInfo[] a(int paramInt)
  {
    return new VideoInfo.DownloadBarInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ome
 * JD-Core Version:    0.7.0.1
 */