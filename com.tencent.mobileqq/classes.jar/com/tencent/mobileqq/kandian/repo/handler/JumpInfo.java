package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class JumpInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<JumpInfo> CREATOR = new JumpInfo.1();
  private final long id;
  private final String jumpUrl;
  private final String wording;
  
  public JumpInfo(long paramLong, String paramString1, String paramString2)
  {
    this.id = paramLong;
    this.wording = paramString1;
    this.jumpUrl = paramString2;
  }
  
  protected JumpInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.wording = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getJumpUrl()
  {
    String str = this.jumpUrl;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public String getWording()
  {
    String str = this.wording;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JumpInfo{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.wording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.wording);
    paramParcel.writeString(this.jumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.JumpInfo
 * JD-Core Version:    0.7.0.1
 */