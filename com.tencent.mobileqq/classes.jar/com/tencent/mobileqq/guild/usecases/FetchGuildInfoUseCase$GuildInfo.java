package com.tencent.mobileqq.guild.usecases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

public class FetchGuildInfoUseCase$GuildInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GuildInfo> CREATOR = new FetchGuildInfoUseCase.GuildInfo.1();
  public final String a;
  public final String b;
  public final String c;
  
  public FetchGuildInfoUseCase$GuildInfo()
  {
    this("", "", "");
  }
  
  protected FetchGuildInfoUseCase$GuildInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public FetchGuildInfoUseCase$GuildInfo(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildInfo{guildId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", guildName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinSignature='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase.GuildInfo
 * JD-Core Version:    0.7.0.1
 */