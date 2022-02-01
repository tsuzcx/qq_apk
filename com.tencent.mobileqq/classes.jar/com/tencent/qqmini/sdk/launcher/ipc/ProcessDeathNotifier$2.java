package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ProcessDeathNotifier$2
  implements Parcelable.Creator<ProcessDeathNotifier>
{
  public ProcessDeathNotifier createFromParcel(Parcel paramParcel)
  {
    return new ProcessDeathNotifier(paramParcel, null);
  }
  
  public ProcessDeathNotifier[] newArray(int paramInt)
  {
    return new ProcessDeathNotifier[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier.2
 * JD-Core Version:    0.7.0.1
 */