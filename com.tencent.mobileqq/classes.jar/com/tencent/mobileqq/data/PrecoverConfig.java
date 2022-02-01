package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PrecoverConfig
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<PrecoverConfig> CREATOR = new PrecoverConfig.1();
  @unique
  public String businessId;
  public int taskId;
  public String xmlContent;
  
  public PrecoverConfig() {}
  
  protected PrecoverConfig(Parcel paramParcel)
  {
    this.businessId = paramParcel.readString();
    this.xmlContent = paramParcel.readString();
    this.taskId = paramParcel.readInt();
  }
  
  public PrecoverConfig(String paramString1, String paramString2, int paramInt)
  {
    this.businessId = paramString1;
    this.xmlContent = paramString2;
    this.taskId = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PrecoverConfig)) || (this.businessId == null)) {
      return false;
    }
    return this.businessId.equals(((PrecoverConfig)paramObject).businessId);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrecoverConfig:businessId=").append(this.businessId);
    localStringBuilder.append(",taskId=").append(this.taskId);
    localStringBuilder.append(",xmlContent=").append(this.xmlContent);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.businessId);
    paramParcel.writeString(this.xmlContent);
    paramParcel.writeInt(this.taskId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PrecoverConfig
 * JD-Core Version:    0.7.0.1
 */