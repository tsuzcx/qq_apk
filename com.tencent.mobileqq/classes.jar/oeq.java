import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;

public final class oeq
  implements Parcelable.Creator<VideoInfo.GameAdComData>
{
  public VideoInfo.GameAdComData a(Parcel paramParcel)
  {
    return new VideoInfo.GameAdComData(paramParcel);
  }
  
  public VideoInfo.GameAdComData[] a(int paramInt)
  {
    return new VideoInfo.GameAdComData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oeq
 * JD-Core Version:    0.7.0.1
 */