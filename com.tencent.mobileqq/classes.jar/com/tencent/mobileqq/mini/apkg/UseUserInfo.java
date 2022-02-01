package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class UseUserInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<UseUserInfo> CREATOR = new UseUserInfo.1();
  public String avatar;
  public String nick;
  public String uin;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UseUserInfo{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", avatar='");
    localStringBuilder.append(this.avatar);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nick=");
    localStringBuilder.append(this.nick);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.avatar);
    paramParcel.writeString(this.nick);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.UseUserInfo
 * JD-Core Version:    0.7.0.1
 */