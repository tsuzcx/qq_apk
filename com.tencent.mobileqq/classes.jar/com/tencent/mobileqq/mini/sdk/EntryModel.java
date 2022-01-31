package com.tencent.mobileqq.mini.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EntryModel
  implements Parcelable
{
  public static final Parcelable.Creator<EntryModel> CREATOR = new EntryModel.1();
  public static final int TYPE_C2C = 1;
  public static final int TYPE_GROUP = 2;
  private String entryDataHash;
  public boolean isAdmin;
  public String name;
  public Map<String, String> reportData;
  public int type;
  public long uin;
  
  public EntryModel(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    this.type = paramInt;
    this.uin = paramLong;
    this.name = paramString;
    this.isAdmin = paramBoolean;
    this.entryDataHash = UUID.randomUUID().toString();
  }
  
  private EntryModel(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.uin = paramParcel.readLong();
    this.name = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isAdmin = bool;
      this.entryDataHash = paramParcel.readString();
      if (this.reportData == null) {
        this.reportData = new HashMap();
      }
      paramParcel.readMap(this.reportData, Map.class.getClassLoader());
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getEntryHash()
  {
    return this.entryDataHash;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.name);
    if (this.isAdmin) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.entryDataHash);
      paramParcel.writeMap(this.reportData);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.EntryModel
 * JD-Core Version:    0.7.0.1
 */