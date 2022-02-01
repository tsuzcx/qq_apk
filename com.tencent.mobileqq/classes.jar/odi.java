import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;

public final class odi
  implements Parcelable.Creator<VideoInfo.RichTitleInfo>
{
  public VideoInfo.RichTitleInfo a(Parcel paramParcel)
  {
    return new VideoInfo.RichTitleInfo(paramParcel);
  }
  
  public VideoInfo.RichTitleInfo[] a(int paramInt)
  {
    return new VideoInfo.RichTitleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odi
 * JD-Core Version:    0.7.0.1
 */