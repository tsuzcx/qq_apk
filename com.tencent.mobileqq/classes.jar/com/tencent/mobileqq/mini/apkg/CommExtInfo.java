package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.Map;

public class CommExtInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<CommExtInfo> CREATOR = new CommExtInfo.1();
  public String attachInfo;
  public Map<String, String> mapInfo;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommExtInfo{mapInfo='");
    localStringBuilder.append(this.mapInfo);
    localStringBuilder.append(", attachInfo='");
    localStringBuilder.append(this.attachInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.mapInfo);
    paramParcel.writeString(this.attachInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.CommExtInfo
 * JD-Core Version:    0.7.0.1
 */