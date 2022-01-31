import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.GameAdDownloadInfo;

public final class npm
  implements Parcelable.Creator<VideoInfo.GameAdDownloadInfo>
{
  public VideoInfo.GameAdDownloadInfo a(Parcel paramParcel)
  {
    return new VideoInfo.GameAdDownloadInfo(paramParcel);
  }
  
  public VideoInfo.GameAdDownloadInfo[] a(int paramInt)
  {
    return new VideoInfo.GameAdDownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npm
 * JD-Core Version:    0.7.0.1
 */