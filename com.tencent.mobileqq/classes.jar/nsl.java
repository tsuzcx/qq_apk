import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;

public final class nsl
  implements Parcelable.Creator<VideoInfo.ChannelInfo>
{
  public VideoInfo.ChannelInfo a(Parcel paramParcel)
  {
    return new VideoInfo.ChannelInfo(paramParcel);
  }
  
  public VideoInfo.ChannelInfo[] a(int paramInt)
  {
    return new VideoInfo.ChannelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nsl
 * JD-Core Version:    0.7.0.1
 */