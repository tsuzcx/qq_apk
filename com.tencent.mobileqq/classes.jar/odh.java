import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;

public final class odh
  implements Parcelable.Creator<VideoInfo.LikeActionDownloadBar>
{
  public VideoInfo.LikeActionDownloadBar a(Parcel paramParcel)
  {
    return new VideoInfo.LikeActionDownloadBar(paramParcel);
  }
  
  public VideoInfo.LikeActionDownloadBar[] a(int paramInt)
  {
    return new VideoInfo.LikeActionDownloadBar[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odh
 * JD-Core Version:    0.7.0.1
 */