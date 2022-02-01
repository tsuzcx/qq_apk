package cooperation.qzone.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ExoticEvent$1
  implements Parcelable.Creator<ExoticEvent>
{
  public ExoticEvent createFromParcel(Parcel paramParcel)
  {
    return new ExoticEvent(paramParcel, null);
  }
  
  public ExoticEvent[] newArray(int paramInt)
  {
    return new ExoticEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEvent.1
 * JD-Core Version:    0.7.0.1
 */