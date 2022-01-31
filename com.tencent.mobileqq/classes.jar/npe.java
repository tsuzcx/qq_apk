import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.ClassInfo;

public final class npe
  implements Parcelable.Creator<VideoInfo.ClassInfo>
{
  public VideoInfo.ClassInfo a(Parcel paramParcel)
  {
    return new VideoInfo.ClassInfo(paramParcel);
  }
  
  public VideoInfo.ClassInfo[] a(int paramInt)
  {
    return new VideoInfo.ClassInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npe
 * JD-Core Version:    0.7.0.1
 */