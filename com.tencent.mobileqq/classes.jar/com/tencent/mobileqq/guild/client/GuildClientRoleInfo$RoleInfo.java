package com.tencent.mobileqq.guild.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;

public class GuildClientRoleInfo$RoleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RoleInfo> CREATOR = new GuildClientRoleInfo.RoleInfo.1();
  private final String a;
  private final String b;
  private final String c;
  private final boolean d;
  
  protected GuildClientRoleInfo$RoleInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public GuildClientRoleInfo$RoleInfo(IGProRoleInfo paramIGProRoleInfo)
  {
    this.a = paramIGProRoleInfo.getRoleId();
    this.b = paramIGProRoleInfo.getRoleName();
    this.c = paramIGProRoleInfo.getRoleDescribe();
    this.d = paramIGProRoleInfo.getIsBind();
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoleInfo{roleId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roleName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roleDescribe='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isBind=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientRoleInfo.RoleInfo
 * JD-Core Version:    0.7.0.1
 */