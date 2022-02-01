package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecommendAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendAppInfo> CREATOR = new RecommendAppInfo.1();
  public String appId;
  public int exposuredNum;
  public long pullTime;
  
  public RecommendAppInfo() {}
  
  public RecommendAppInfo(String paramString, int paramInt, long paramLong)
  {
    this.appId = paramString;
    this.exposuredNum = paramInt;
    this.pullTime = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public int getExposuredNum()
  {
    return this.exposuredNum;
  }
  
  public long getPullTime()
  {
    return this.pullTime;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setExposuredNum(int paramInt)
  {
    this.exposuredNum = paramInt;
  }
  
  public void setPullTime(long paramLong)
  {
    this.pullTime = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecommendAppInfo{appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", exposuredNum=");
    localStringBuilder.append(this.exposuredNum);
    localStringBuilder.append(", pullTime=");
    localStringBuilder.append(this.pullTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.exposuredNum);
    paramParcel.writeLong(this.pullTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.RecommendAppInfo
 * JD-Core Version:    0.7.0.1
 */