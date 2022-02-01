package com.tencent.mobileqq.guild.client;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GuildClientParams
  implements Parcelable
{
  public static final Parcelable.Creator<GuildClientParams> CREATOR = new GuildClientParams.1();
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private int e = 0;
  private String f = "";
  private String g = "";
  private String h = "";
  private int i = 0;
  private Bundle j = new Bundle();
  private boolean k;
  
  public GuildClientParams()
  {
    this.k = true;
  }
  
  protected GuildClientParams(Parcel paramParcel)
  {
    boolean bool = true;
    this.k = true;
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readBundle();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.k = bool;
  }
  
  public GuildClientParams a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public GuildClientParams a(Bundle paramBundle)
  {
    this.j = paramBundle;
    return this;
  }
  
  public GuildClientParams a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public GuildClientParams b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public GuildClientParams d(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GuildClientParams e()
  {
    return this;
  }
  
  public GuildClientParams e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public GuildClientParams f(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public String f()
  {
    return this.a;
  }
  
  public GuildClientParams g(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public GuildClientParams h(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public GuildClientParams i(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String i()
  {
    return this.c;
  }
  
  public int j()
  {
    return this.e;
  }
  
  public GuildClientParams j(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String k()
  {
    return this.f;
  }
  
  public String l()
  {
    return this.d;
  }
  
  public String m()
  {
    return this.h;
  }
  
  public int n()
  {
    return this.i;
  }
  
  public Bundle o()
  {
    return this.j;
  }
  
  public boolean p()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildClientParams{guildId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkAppName='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sceneType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelId='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelName='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", guildExtra=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", reusable=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeBundle(this.j);
    paramParcel.writeByte((byte)this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientParams
 * JD-Core Version:    0.7.0.1
 */