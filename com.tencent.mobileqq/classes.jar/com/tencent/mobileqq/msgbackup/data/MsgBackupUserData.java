package com.tencent.mobileqq.msgbackup.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class MsgBackupUserData
  implements Parcelable
{
  public static final Parcelable.Creator<MsgBackupUserData> CREATOR = new MsgBackupUserData.1();
  private String a;
  private List<Integer> b;
  private String c;
  private String d;
  private int e;
  
  protected MsgBackupUserData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    paramParcel.readList(this.b, getClass().getClassLoader());
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
  }
  
  private MsgBackupUserData(String paramString1, List<Integer> paramList, String paramString2, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.b = paramList;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List<Integer> b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--UserData--");
    localStringBuilder.append(", ip: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",ports: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",bssid: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ssid: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", platfrom: ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupUserData
 * JD-Core Version:    0.7.0.1
 */