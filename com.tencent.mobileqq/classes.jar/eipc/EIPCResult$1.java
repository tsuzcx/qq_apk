package eipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class EIPCResult$1
  implements Parcelable.Creator
{
  public EIPCResult createFromParcel(Parcel paramParcel)
  {
    return new EIPCResult(paramParcel, null);
  }
  
  public EIPCResult[] newArray(int paramInt)
  {
    return new EIPCResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCResult.1
 * JD-Core Version:    0.7.0.1
 */