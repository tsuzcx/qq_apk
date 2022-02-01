package com.tencent.mobileqq.guild.data.profilecard;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;

public class GuildProfileData
  implements Parcelable
{
  public static final Parcelable.Creator<GuildProfileData> CREATOR = new GuildProfileData.1();
  public static final String KEY_CHANNEL_DATA = "key_channel_data";
  public static final String KEY_HEAD_DATA = "key_header_data";
  public static final int TYPE_AUDIO = 1;
  public static final int TYPE_LIVE = 2;
  public static final int TYPE_OTHER = 3;
  public static final int TYPE_TEXT = 0;
  private Bundle mExtras = new Bundle();
  private GuildBaseProfileData mGuildBaseProfileData = new GuildBaseProfileData();
  
  private GuildProfileData() {}
  
  protected GuildProfileData(Parcel paramParcel)
  {
    this.mGuildBaseProfileData = ((GuildBaseProfileData)paramParcel.readParcelable(GuildBaseProfileData.class.getClassLoader()));
    this.mExtras = paramParcel.readBundle();
  }
  
  public GuildProfileData(String paramString1, @Nullable String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.mGuildBaseProfileData = new GuildBaseProfileData(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public GuildBaseProfileData getGuildBaseProfileData()
  {
    return this.mGuildBaseProfileData;
  }
  
  public void setGuildBaseProfileData(GuildBaseProfileData paramGuildBaseProfileData)
  {
    this.mGuildBaseProfileData = paramGuildBaseProfileData;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildProfileData{mGuildBaseProfileData=");
    localStringBuilder.append(this.mGuildBaseProfileData);
    localStringBuilder.append(", mExtras=");
    localStringBuilder.append(this.mExtras);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mGuildBaseProfileData, paramInt);
    paramParcel.writeBundle(this.mExtras);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.data.profilecard.GuildProfileData
 * JD-Core Version:    0.7.0.1
 */