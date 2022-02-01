package com.tencent.qqmini.sdk.launcher.model;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SecondApiRightInfo{apiName='");
    localStringBuilder.append(this.apiName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", secondName='");
    localStringBuilder.append(this.secondName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", right=");
    localStringBuilder.append(this.right);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.apiName);
    paramParcel.writeString(this.secondName);
    paramParcel.writeInt(this.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo
 * JD-Core Version:    0.7.0.1
 */