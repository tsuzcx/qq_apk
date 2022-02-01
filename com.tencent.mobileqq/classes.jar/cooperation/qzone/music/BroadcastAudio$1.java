package cooperation.qzone.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BroadcastAudio$1
  implements Parcelable.Creator<BroadcastAudio>
{
  public BroadcastAudio createFromParcel(Parcel paramParcel)
  {
    return new BroadcastAudio(paramParcel);
  }
  
  public BroadcastAudio[] newArray(int paramInt)
  {
    return new BroadcastAudio[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.BroadcastAudio.1
 * JD-Core Version:    0.7.0.1
 */