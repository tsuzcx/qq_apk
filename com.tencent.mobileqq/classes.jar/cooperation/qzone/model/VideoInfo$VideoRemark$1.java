package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoInfo$VideoRemark$1
  implements Parcelable.Creator<VideoInfo.VideoRemark>
{
  public VideoInfo.VideoRemark createFromParcel(Parcel paramParcel)
  {
    VideoInfo.VideoRemark localVideoRemark = new VideoInfo.VideoRemark();
    localVideoRemark.iconurl = paramParcel.readString();
    localVideoRemark.icondesc = paramParcel.readString();
    localVideoRemark.remark = paramParcel.readString();
    localVideoRemark.actiontype = paramParcel.readInt();
    localVideoRemark.actionurl = paramParcel.readString();
    localVideoRemark.orgwebsite = paramParcel.readInt();
    return localVideoRemark;
  }
  
  public VideoInfo.VideoRemark[] newArray(int paramInt)
  {
    return new VideoInfo.VideoRemark[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo.VideoRemark.1
 * JD-Core Version:    0.7.0.1
 */