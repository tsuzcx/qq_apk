package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bdms;

public class FirstPageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FirstPageInfo> CREATOR = new bdms();
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
      } while (!(paramObject instanceof FirstPageInfo));
      paramObject = (FirstPageInfo)paramObject;
    } while ((!TextUtils.equals(paramObject.a, this.a)) || (!TextUtils.equals(paramObject.b, this.b)));
    return true;
  }
  
  public String toString()
  {
    return "{pagePath='" + this.a + '\'' + ", subPkgName='" + this.b + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.FirstPageInfo
 * JD-Core Version:    0.7.0.1
 */