import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;

public final class oca
  implements Parcelable.Creator<VideoInfo.TopBarInfo>
{
  public VideoInfo.TopBarInfo a(Parcel paramParcel)
  {
    return new VideoInfo.TopBarInfo(paramParcel);
  }
  
  public VideoInfo.TopBarInfo[] a(int paramInt)
  {
    return new VideoInfo.TopBarInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oca
 * JD-Core Version:    0.7.0.1
 */