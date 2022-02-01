package com.tencent.mobileqq.guild.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;

public class IpcArguments
  implements Parcelable
{
  public static final Parcelable.Creator<IpcArguments> CREATOR = new IpcArguments.1();
  private final ArrayList<Object> a = new ArrayList();
  
  public IpcArguments() {}
  
  protected IpcArguments(Parcel paramParcel)
  {
    paramParcel.readList(this.a, Object.class.getClassLoader());
  }
  
  public IpcArguments(Object... paramVarArgs)
  {
    Collections.addAll(this.a, paramVarArgs);
  }
  
  public Object[] a()
  {
    return this.a.toArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.IpcArguments
 * JD-Core Version:    0.7.0.1
 */