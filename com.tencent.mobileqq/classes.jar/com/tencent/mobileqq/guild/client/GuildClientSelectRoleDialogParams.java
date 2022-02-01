package com.tencent.mobileqq.guild.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GuildClientSelectRoleDialogParams
  extends GuildClientParams
{
  public static final Parcelable.Creator<GuildClientSelectRoleDialogParams> CREATOR = new GuildClientSelectRoleDialogParams.1();
  private GuildClientRoleInfo a;
  
  public GuildClientSelectRoleDialogParams() {}
  
  protected GuildClientSelectRoleDialogParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((GuildClientRoleInfo)paramParcel.readParcelable(GuildClientRoleInfo.class.getClassLoader()));
  }
  
  public GuildClientSelectRoleDialogParams(GuildClientParams paramGuildClientParams)
  {
    d(paramGuildClientParams.f());
    g(paramGuildClientParams.h());
    h(paramGuildClientParams.i());
    i(paramGuildClientParams.l());
    a(paramGuildClientParams.j());
    j(paramGuildClientParams.k());
    e(paramGuildClientParams.g());
    f(paramGuildClientParams.m());
    b(paramGuildClientParams.n());
    a(paramGuildClientParams.o());
  }
  
  public GuildClientSelectRoleDialogParams a()
  {
    return this;
  }
  
  public GuildClientSelectRoleDialogParams a(GuildClientRoleInfo paramGuildClientRoleInfo)
  {
    this.a = paramGuildClientRoleInfo;
    return this;
  }
  
  public GuildClientRoleInfo b()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildClientSelectRoleDialogParams{guildId='");
    localStringBuilder.append(f());
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientId='");
    localStringBuilder.append(h());
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkAppName='");
    localStringBuilder.append(i());
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkId='");
    localStringBuilder.append(l());
    localStringBuilder.append('\'');
    localStringBuilder.append(", sceneType=");
    localStringBuilder.append(j());
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(k());
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelId='");
    localStringBuilder.append(g());
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelName='");
    localStringBuilder.append(m());
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId=");
    localStringBuilder.append(n());
    localStringBuilder.append(", guildExtra=");
    localStringBuilder.append(o());
    localStringBuilder.append(", reusable=");
    localStringBuilder.append(p());
    localStringBuilder.append(", roleInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleDialogParams
 * JD-Core Version:    0.7.0.1
 */