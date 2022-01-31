package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import beqx;

public class DebugInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DebugInfo> CREATOR = new beqx();
  public String a;
  public String b;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (!(paramObject instanceof DebugInfo));
      paramObject = (DebugInfo)paramObject;
    } while ((!TextUtils.equals(this.a, paramObject.a)) || (!TextUtils.equals(this.b, paramObject.b)));
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.DebugInfo
 * JD-Core Version:    0.7.0.1
 */