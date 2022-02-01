package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoUrl$1
  implements Parcelable.Creator<VideoUrl>
{
  public VideoUrl createFromParcel(Parcel paramParcel)
  {
    VideoUrl localVideoUrl = new VideoUrl();
    localVideoUrl.url = paramParcel.readString();
    localVideoUrl.decoderType = paramParcel.readInt();
    localVideoUrl.videoRate = paramParcel.readInt();
    return localVideoUrl;
  }
  
  public VideoUrl[] newArray(int paramInt)
  {
    return new VideoUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.VideoUrl.1
 * JD-Core Version:    0.7.0.1
 */