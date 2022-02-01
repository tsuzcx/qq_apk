package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import artx;

public class IPSiteModel$GameRich
  implements Parcelable
{
  public static final Parcelable.Creator<GameRich> CREATOR = new artx();
  public String anchorFaceUrl;
  public String anchorId;
  public String anchorName;
  public String coverUrl;
  public String online;
  public String richJumpUrl;
  public String title;
  
  public IPSiteModel$GameRich() {}
  
  public IPSiteModel$GameRich(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.anchorFaceUrl = paramString1;
    this.anchorId = paramString2;
    this.anchorName = paramString3;
    this.coverUrl = paramString4;
    this.online = paramString5;
    this.title = paramString6;
    this.richJumpUrl = paramString7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "GameRich{anchorFaceUrl='" + this.anchorFaceUrl + '\'' + ", anchorId='" + this.anchorId + '\'' + ", anchorName='" + this.anchorName + '\'' + ", coverUrl='" + this.coverUrl + '\'' + ", online='" + this.online + '\'' + ", title='" + this.title + '\'' + ", richJumpUrl='" + this.richJumpUrl + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.anchorFaceUrl);
    paramParcel.writeString(this.anchorId);
    paramParcel.writeString(this.anchorName);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.online);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.richJumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.GameRich
 * JD-Core Version:    0.7.0.1
 */