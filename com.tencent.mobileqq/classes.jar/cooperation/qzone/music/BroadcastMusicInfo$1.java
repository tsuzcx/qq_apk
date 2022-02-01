package cooperation.qzone.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BroadcastMusicInfo$1
  implements Parcelable.Creator<BroadcastMusicInfo>
{
  public BroadcastMusicInfo createFromParcel(Parcel paramParcel)
  {
    return new BroadcastMusicInfo(paramParcel);
  }
  
  public BroadcastMusicInfo[] newArray(int paramInt)
  {
    return new BroadcastMusicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.BroadcastMusicInfo.1
 * JD-Core Version:    0.7.0.1
 */