package com.tencent.mobileqq.guild.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IpcArguments$1
  implements Parcelable.Creator<IpcArguments>
{
  public IpcArguments a(Parcel paramParcel)
  {
    return new IpcArguments(paramParcel);
  }
  
  public IpcArguments[] a(int paramInt)
  {
    return new IpcArguments[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.IpcArguments.1
 * JD-Core Version:    0.7.0.1
 */