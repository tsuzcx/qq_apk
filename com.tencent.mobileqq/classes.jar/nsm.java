import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.ClassInfo;

public final class nsm
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nsm
 * JD-Core Version:    0.7.0.1
 */