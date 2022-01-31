package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TransReqContext$1
  implements Parcelable.Creator<TransReqContext>
{
  public TransReqContext createFromParcel(Parcel paramParcel)
  {
    return new TransReqContext(paramParcel, null);
  }
  
  public TransReqContext[] newArray(int paramInt)
  {
    return new TransReqContext[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.TransReqContext.1
 * JD-Core Version:    0.7.0.1
 */