package cooperation.qappcenter.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RecvMsg$1
  implements Parcelable.Creator<RecvMsg>
{
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qappcenter.remote.RecvMsg.1
 * JD-Core Version:    0.7.0.1
 */