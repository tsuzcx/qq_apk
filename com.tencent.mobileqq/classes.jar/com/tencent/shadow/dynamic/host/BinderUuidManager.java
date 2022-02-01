package com.tencent.shadow.dynamic.host;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.shadow.core.common.InstalledApk;

class BinderUuidManager
  implements UuidManager
{
  private IBinder mRemote;
  
  BinderUuidManager(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  private void checkException(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 0) {
          return;
        }
        paramParcel = new StringBuilder();
        paramParcel.append("不认识的Code==");
        paramParcel.append(i);
        throw new RuntimeException(paramParcel.toString());
      }
      throw new NotFoundException(paramParcel);
    }
    throw new FailedException(paramParcel);
  }
  
  public InstalledApk getPlugin(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(UuidManager.DESCRIPTOR);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      checkException(localParcel2);
      if (localParcel2.readInt() != 0) {
        paramString1 = (InstalledApk)InstalledApk.CREATOR.createFromParcel(localParcel2);
      } else {
        paramString1 = null;
      }
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public InstalledApk getPluginLoader(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(UuidManager.DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      checkException(localParcel2);
      if (localParcel2.readInt() != 0) {
        paramString = (InstalledApk)InstalledApk.CREATOR.createFromParcel(localParcel2);
      } else {
        paramString = null;
      }
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public InstalledApk getRuntime(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(UuidManager.DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      checkException(localParcel2);
      if (localParcel2.readInt() != 0) {
        paramString = (InstalledApk)InstalledApk.CREATOR.createFromParcel(localParcel2);
      } else {
        paramString = null;
      }
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.BinderUuidManager
 * JD-Core Version:    0.7.0.1
 */