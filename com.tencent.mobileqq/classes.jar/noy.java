import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoAdInfo;

public final class noy
  implements Parcelable.Creator<VideoAdInfo>
{
  public VideoAdInfo a(Parcel paramParcel)
  {
    return new VideoAdInfo(paramParcel);
  }
  
  public VideoAdInfo[] a(int paramInt)
  {
    return new VideoAdInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noy
 * JD-Core Version:    0.7.0.1
 */