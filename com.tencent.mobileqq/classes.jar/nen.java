import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.KdTagItem;

public final class nen
  implements Parcelable.Creator<VideoInfo.KdTagItem>
{
  public VideoInfo.KdTagItem a(Parcel paramParcel)
  {
    return new VideoInfo.KdTagItem(paramParcel);
  }
  
  public VideoInfo.KdTagItem[] a(int paramInt)
  {
    return new VideoInfo.KdTagItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nen
 * JD-Core Version:    0.7.0.1
 */