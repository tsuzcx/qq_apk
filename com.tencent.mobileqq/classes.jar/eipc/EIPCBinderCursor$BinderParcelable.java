package eipc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EIPCBinderCursor$BinderParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<BinderParcelable> CREATOR = new EIPCBinderCursor.BinderParcelable.1();
  public IBinder mBinder;
  
  EIPCBinderCursor$BinderParcelable(IBinder paramIBinder)
  {
    this.mBinder = paramIBinder;
  }
  
  EIPCBinderCursor$BinderParcelable(Parcel paramParcel)
  {
    this.mBinder = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.mBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCBinderCursor.BinderParcelable
 * JD-Core Version:    0.7.0.1
 */