package com.tencent.mobileqq.guild.data.profilecard;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GuildBaseProfileData
  implements Parcelable
{
  public static final Parcelable.Creator<GuildBaseProfileData> CREATOR = new GuildBaseProfileData.1();
  private String a;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private boolean j;
  
  public GuildBaseProfileData() {}
  
  protected GuildBaseProfileData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.j = bool;
  }
  
  public GuildBaseProfileData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public GuildBaseProfileData a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public GuildBaseProfileData b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.i;
  }
  
  public boolean j()
  {
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildBaseProfileData{mGuildId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTroopUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSelfTinyId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDstTinyId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mProfileType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mSceneType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mSelfUserType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mDstUserType=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mChannelId='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
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
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeByte((byte)this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData
 * JD-Core Version:    0.7.0.1
 */