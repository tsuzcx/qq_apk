package com.tencent.mobileqq.guild.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GuildClientAuthDialogParams
  extends GuildClientParams
{
  public static final Parcelable.Creator<GuildClientAuthDialogParams> CREATOR = new GuildClientAuthDialogParams.1();
  private String a = "";
  private String b = "";
  private String c = "";
  
  public GuildClientAuthDialogParams() {}
  
  protected GuildClientAuthDialogParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public GuildClientAuthDialogParams(GuildClientParams paramGuildClientParams)
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
  
  public GuildClientAuthDialogParams a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public GuildClientAuthDialogParams b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public GuildClientAuthDialogParams c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public GuildClientAuthDialogParams d()
  {
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildClientAuthDialogParams{guildId='");
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
    localStringBuilder.append(", authAgreement=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", authTips=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", picUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthDialogParams
 * JD-Core Version:    0.7.0.1
 */