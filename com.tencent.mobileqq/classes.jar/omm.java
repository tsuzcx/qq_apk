import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;

public final class omm
  implements Parcelable.Creator<VideoInfo.LocationInfo>
{
  public VideoInfo.LocationInfo a(Parcel paramParcel)
  {
    return new VideoInfo.LocationInfo(paramParcel);
  }
  
  public VideoInfo.LocationInfo[] a(int paramInt)
  {
    return new VideoInfo.LocationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omm
 * JD-Core Version:    0.7.0.1
 */