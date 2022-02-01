package com.tencent.mobileqq.guild.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildClientRoleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GuildClientRoleInfo> CREATOR = new GuildClientRoleInfo.1();
  private ArrayList<GuildClientRoleInfo.RoleInfo> a = new ArrayList();
  private String b = "";
  
  protected GuildClientRoleInfo(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.a = paramParcel.readArrayList(GuildClientRoleInfo.RoleInfo.class.getClassLoader());
  }
  
  public GuildClientRoleInfo(List<IGProRoleInfo> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProRoleInfo localIGProRoleInfo = (IGProRoleInfo)paramList.next();
      this.a.add(new GuildClientRoleInfo.RoleInfo(localIGProRoleInfo));
    }
    this.b = paramString;
  }
  
  public List<GuildClientRoleInfo.RoleInfo> a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildClientRoleInfo{roleList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeList(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientRoleInfo
 * JD-Core Version:    0.7.0.1
 */