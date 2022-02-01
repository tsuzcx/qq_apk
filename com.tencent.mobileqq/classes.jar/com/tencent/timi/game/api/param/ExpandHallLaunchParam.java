package com.tencent.timi.game.api.param;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ExpandHallLaunchParam
  implements Parcelable
{
  public static final Parcelable.Creator<ExpandHallLaunchParam> CREATOR = new ExpandHallLaunchParam.1();
  public int a;
  public int b;
  public long c;
  public String d;
  public String e;
  public String f;
  public long g;
  public boolean h;
  public long i;
  public boolean j;
  
  public ExpandHallLaunchParam()
  {
    this.a = 1;
    this.b = 1;
    this.d = "";
    this.e = "";
    this.f = "";
    this.h = false;
    this.j = false;
  }
  
  protected ExpandHallLaunchParam(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.a = 1;
    this.b = 1;
    this.d = "";
    this.e = "";
    this.f = "";
    this.h = false;
    this.j = false;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readLong();
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    this.i = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.j = bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExpandHallLaunchParam{sourceId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", guildId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", channelName='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelIcon='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", teamId=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", autoShowTeamList=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeByte((byte)this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.param.ExpandHallLaunchParam
 * JD-Core Version:    0.7.0.1
 */