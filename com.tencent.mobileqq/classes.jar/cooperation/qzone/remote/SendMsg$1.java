package cooperation.qzone.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SendMsg$1
  implements Parcelable.Creator<SendMsg>
{
  public SendMsg createFromParcel(Parcel paramParcel)
  {
    return new SendMsg(paramParcel);
  }
  
  public SendMsg[] newArray(int paramInt)
  {
    return new SendMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.remote.SendMsg.1
 * JD-Core Version:    0.7.0.1
 */