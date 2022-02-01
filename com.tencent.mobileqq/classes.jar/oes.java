import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;

public final class oes
  implements Parcelable.Creator<VideoInfo.InterruptedWeishiAd>
{
  public VideoInfo.InterruptedWeishiAd a(Parcel paramParcel)
  {
    return new VideoInfo.InterruptedWeishiAd(paramParcel);
  }
  
  public VideoInfo.InterruptedWeishiAd[] a(int paramInt)
  {
    return new VideoInfo.InterruptedWeishiAd[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oes
 * JD-Core Version:    0.7.0.1
 */