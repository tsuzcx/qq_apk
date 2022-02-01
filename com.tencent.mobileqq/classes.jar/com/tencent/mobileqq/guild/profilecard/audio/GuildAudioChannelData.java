package com.tencent.mobileqq.guild.profilecard.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GuildAudioChannelData
  implements Parcelable
{
  public static final Parcelable.Creator<GuildAudioChannelData> CREATOR = new GuildAudioChannelData.1();
  private String a;
  private int b;
  private String c;
  private int d;
  private String e;
  private int f;
  private boolean g;
  private boolean h;
  private int i;
  
  public GuildAudioChannelData() {}
  
  protected GuildAudioChannelData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    int j = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (j != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    this.i = paramParcel.readInt();
  }
  
  public GuildAudioChannelData(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramString2;
    this.d = paramInt2;
    this.e = paramString3;
    this.f = paramInt3;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeInt(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildAudioChannelData
 * JD-Core Version:    0.7.0.1
 */