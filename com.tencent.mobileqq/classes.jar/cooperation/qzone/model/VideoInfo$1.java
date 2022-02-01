package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoInfo$1
  implements Parcelable.Creator<VideoInfo>
{
  public VideoInfo createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.videoId = paramParcel.readString();
    localVideoInfo.videoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.originUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.bigUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.currentUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.coverUrl = ((PictureUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.actionType = paramParcel.readInt();
    localVideoInfo.actionUrl = paramParcel.readString();
    localVideoInfo.highBrUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.lowBrUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.originVideoUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.h265NormalUrl = ((VideoUrl)paramParcel.readParcelable(getClass().getClassLoader()));
    localVideoInfo.videoRateList = paramParcel.readArrayList(getClass().getClassLoader());
    localVideoInfo.currentVideoRate = paramParcel.readInt();
    localVideoInfo.originVideoSize = paramParcel.readLong();
    localVideoInfo.fileType = paramParcel.readInt();
    localVideoInfo.videoType = paramParcel.readInt();
    localVideoInfo.videoTime = paramParcel.readLong();
    localVideoInfo.showVideoTime = paramParcel.readString();
    localVideoInfo.playType = paramParcel.readByte();
    localVideoInfo.videoShowType = paramParcel.readInt();
    localVideoInfo.videoStatus = paramParcel.readInt();
    localVideoInfo.lastUseTime = paramParcel.readLong();
    localVideoInfo.width = paramParcel.readInt();
    localVideoInfo.height = paramParcel.readInt();
    localVideoInfo.toast = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localVideoInfo.isFakeFeed = bool1;
      localVideoInfo.videoRemark = ((VideoInfo.VideoRemark)paramParcel.readParcelable(getClass().getClassLoader()));
      localVideoInfo.validVideoTime = paramParcel.readLong();
      localVideoInfo.validVideoTimeDesc = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label602;
      }
      bool1 = true;
      label405:
      localVideoInfo.isCircle = bool1;
      if (paramParcel.readInt() != 1) {
        break label607;
      }
      bool1 = true;
      label421:
      localVideoInfo.isAutoPlay = bool1;
      localVideoInfo.writeFrom = paramParcel.readInt();
      localVideoInfo.desc = paramParcel.readString();
      localVideoInfo.videoSource = paramParcel.readInt();
      localVideoInfo.advDelayTime = paramParcel.readInt();
      localVideoInfo.isGetRecommAfterPlay = paramParcel.readInt();
      localVideoInfo.shootTime = paramParcel.readLong();
      localVideoInfo.videoplaycnt = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label612;
      }
      bool1 = true;
      label500:
      localVideoInfo.allowShowPasterVideoAdv = bool1;
      if (paramParcel.readInt() != 1) {
        break label617;
      }
    }
    label602:
    label607:
    label612:
    label617:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoInfo.needDeleteLocal = bool1;
      localVideoInfo.seekPosition = paramParcel.readLong();
      localVideoInfo.lloc = paramParcel.readString();
      localVideoInfo.albumid = paramParcel.readString();
      localVideoInfo.pull_weishi_mask = paramParcel.readInt();
      localVideoInfo.weishi_download_url = paramParcel.readString();
      localVideoInfo.weishi_pull_schema = paramParcel.readString();
      localVideoInfo.weishi_clipbrd = paramParcel.readString();
      localVideoInfo.pull_weishi_alg_id = paramParcel.readString();
      return localVideoInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label405;
      bool1 = false;
      break label421;
      bool1 = false;
      break label500;
    }
  }
  
  public VideoInfo[] newArray(int paramInt)
  {
    return new VideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo.1
 * JD-Core Version:    0.7.0.1
 */