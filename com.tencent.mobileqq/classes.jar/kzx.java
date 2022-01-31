import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoAdInfo;

public final class kzx
  implements Parcelable.Creator
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
 * Qualified Name:     kzx
 * JD-Core Version:    0.7.0.1
 */