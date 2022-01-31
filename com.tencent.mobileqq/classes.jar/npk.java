import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;

public final class npk
  implements Parcelable.Creator<VideoInfo.EntranceDownloadInfo>
{
  public VideoInfo.EntranceDownloadInfo a(Parcel paramParcel)
  {
    return new VideoInfo.EntranceDownloadInfo(paramParcel);
  }
  
  public VideoInfo.EntranceDownloadInfo[] a(int paramInt)
  {
    return new VideoInfo.EntranceDownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npk
 * JD-Core Version:    0.7.0.1
 */