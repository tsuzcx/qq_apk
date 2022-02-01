package cooperation.qzone.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RecvMsg$1
  implements Parcelable.Creator<RecvMsg>
{
  public RecvMsg createFromParcel(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] newArray(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.remote.RecvMsg.1
 * JD-Core Version:    0.7.0.1
 */