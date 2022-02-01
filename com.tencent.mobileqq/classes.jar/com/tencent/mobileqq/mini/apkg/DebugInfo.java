package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class DebugInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DebugInfo> CREATOR = new DebugInfo.1();
  public String roomId;
  public String wsUrl;
  
  public static boolean equals(DebugInfo paramDebugInfo1, DebugInfo paramDebugInfo2)
  {
    if (paramDebugInfo1 == paramDebugInfo2) {
      return true;
    }
    if (paramDebugInfo1 != null) {
      return paramDebugInfo1.equals(paramDebugInfo2);
    }
    return false;
  }
  
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
    } while ((!TextUtils.equals(this.roomId, paramObject.roomId)) || (!TextUtils.equals(this.wsUrl, paramObject.wsUrl)));
    return true;
  }
  
  public String getRoomId()
  {
    return this.roomId;
  }
  
  public String getWsUrl()
  {
    return this.wsUrl;
  }
  
  public void setRoomId(String paramString)
  {
    this.roomId = paramString;
  }
  
  public void setWsUrl(String paramString)
  {
    this.wsUrl = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.roomId);
    paramParcel.writeString(this.wsUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.DebugInfo
 * JD-Core Version:    0.7.0.1
 */