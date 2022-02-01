package com.tencent.mobileqq.olympic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axpz;
import java.io.Serializable;
import java.util.ArrayList;

public class OlyimpicConfig
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<OlyimpicConfig> CREATOR = new axpz();
  public long grabInterval = -1L;
  public int id;
  public long reportActiveInterval = -1L;
  public long reportNormalInterval = -1L;
  public ArrayList<ShuayishuaConfig> shuayishuaConfigs = new ArrayList();
  public int version;
  
  public OlyimpicConfig() {}
  
  public OlyimpicConfig(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.grabInterval = paramParcel.readLong();
    this.reportActiveInterval = paramParcel.readLong();
    this.reportNormalInterval = paramParcel.readLong();
    paramParcel.readList(this.shuayishuaConfigs, OlyimpicConfig.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("{");
    localStringBuilder.append("id=").append(this.id).append(",");
    localStringBuilder.append("version=").append(this.version).append(",");
    localStringBuilder.append("grabInterval=").append(this.grabInterval).append(",");
    localStringBuilder.append("reportActiveInterval=").append(this.reportActiveInterval).append(",");
    localStringBuilder.append("reportNormalInterval=").append(this.reportNormalInterval).append(",[");
    localStringBuilder.append("shuayishuaConfigs=").append(this.shuayishuaConfigs).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.version);
    paramParcel.writeLong(this.grabInterval);
    paramParcel.writeLong(this.reportActiveInterval);
    paramParcel.writeLong(this.reportNormalInterval);
    paramParcel.writeList(this.shuayishuaConfigs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlyimpicConfig
 * JD-Core Version:    0.7.0.1
 */