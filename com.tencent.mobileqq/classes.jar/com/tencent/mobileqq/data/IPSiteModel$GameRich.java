package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPSiteModel$GameRich
  implements Parcelable
{
  public static final Parcelable.Creator<GameRich> CREATOR = new IPSiteModel.GameRich.1();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameRich{anchorFaceUrl='");
    localStringBuilder.append(this.anchorFaceUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", anchorId='");
    localStringBuilder.append(this.anchorId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", anchorName='");
    localStringBuilder.append(this.anchorName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", online='");
    localStringBuilder.append(this.online);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", richJumpUrl='");
    localStringBuilder.append(this.richJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.GameRich
 * JD-Core Version:    0.7.0.1
 */