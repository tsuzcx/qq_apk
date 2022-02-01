package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;

public class MiniServiceFetcher
  implements Parcelable
{
  public static final Parcelable.Creator<MiniServiceFetcher> CREATOR = new MiniServiceFetcher.1();
  private static final String TAG = "MiniServiceManager";
  private IMiniServiceManager mServiceManager;
  
  public MiniServiceFetcher(IMiniServiceManager paramIMiniServiceManager)
  {
    this.mServiceManager = paramIMiniServiceManager;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IMiniServiceManager getMiniServiceManager()
  {
    return this.mServiceManager;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.mServiceManager.asBinder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniServiceFetcher
 * JD-Core Version:    0.7.0.1
 */