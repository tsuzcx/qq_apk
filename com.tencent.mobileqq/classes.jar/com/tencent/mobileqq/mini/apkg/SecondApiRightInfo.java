package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class SecondApiRightInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<SecondApiRightInfo> CREATOR = new SecondApiRightInfo.1();
  public String apiName;
  public int right;
  public String secondName;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SecondApiRightInfo{apiName='" + this.apiName + '\'' + ", secondName='" + this.secondName + '\'' + ", right=" + this.right + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.apiName);
    paramParcel.writeString(this.secondName);
    paramParcel.writeInt(this.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.SecondApiRightInfo
 * JD-Core Version:    0.7.0.1
 */