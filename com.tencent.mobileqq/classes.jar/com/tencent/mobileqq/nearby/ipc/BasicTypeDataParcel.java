package com.tencent.mobileqq.nearby.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BasicTypeDataParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BasicTypeDataParcel> CREATOR = new BasicTypeDataParcel.1();
  public int a;
  public Object[] b;
  
  public BasicTypeDataParcel(int paramInt, Object... paramVarArgs)
  {
    this.a = paramInt;
    this.b = paramVarArgs;
  }
  
  protected BasicTypeDataParcel(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readArray(Object.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--------------------start-------------------");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    if (this.b != null)
    {
      int i = 0;
      for (;;)
      {
        Object[] arrayOfObject = this.b;
        if (i >= arrayOfObject.length) {
          break;
        }
        localStringBuilder.append(arrayOfObject[i]);
        localStringBuilder.append("\n");
        i += 1;
      }
    }
    localStringBuilder.append("--------------------end-------------------");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeArray(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel
 * JD-Core Version:    0.7.0.1
 */