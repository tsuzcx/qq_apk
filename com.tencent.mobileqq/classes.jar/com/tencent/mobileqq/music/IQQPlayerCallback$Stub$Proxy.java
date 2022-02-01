package com.tencent.mobileqq.music;

import android.os.IBinder;
import android.os.Parcel;

class IQQPlayerCallback$Stub$Proxy
  implements IQQPlayerCallback
{
  private IBinder a;
  
  IQQPlayerCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerCallback");
      localParcel.writeInt(paramInt);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerCallback");
      if (paramSongInfo != null)
      {
        localParcel.writeInt(1);
        paramSongInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.IQQPlayerCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */