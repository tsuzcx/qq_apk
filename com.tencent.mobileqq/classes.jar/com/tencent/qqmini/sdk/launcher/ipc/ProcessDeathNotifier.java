package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.NonNull;

public class ProcessDeathNotifier
  implements Parcelable
{
  public static final Parcelable.Creator<ProcessDeathNotifier> CREATOR = new ProcessDeathNotifier.2();
  private static volatile ProcessDeathNotifier sInstance;
  private final IBinder mBinder;
  
  private ProcessDeathNotifier()
  {
    this.mBinder = new Binder();
  }
  
  private ProcessDeathNotifier(Parcel paramParcel)
  {
    this.mBinder = paramParcel.readStrongBinder();
  }
  
  public static ProcessDeathNotifier getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ProcessDeathNotifier();
      }
      return sInstance;
    }
    finally {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void observeDeath(@NonNull Runnable paramRunnable)
  {
    try
    {
      this.mBinder.linkToDeath(new ProcessDeathNotifier.1(this, paramRunnable), 0);
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      paramRunnable.run();
      return;
    }
    catch (RemoteException paramRunnable) {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.mBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier
 * JD-Core Version:    0.7.0.1
 */