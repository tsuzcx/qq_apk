package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PluginInfo> CREATOR = new PluginInfo.1();
  private String innerVersion;
  private String pluginId;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getInnerVersion()
  {
    return this.innerVersion;
  }
  
  public String getPluginId()
  {
    return this.pluginId;
  }
  
  public void setInnerVersion(String paramString)
  {
    this.innerVersion = paramString;
  }
  
  public void setPluginId(String paramString)
  {
    this.pluginId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PluginInfo{plugin_id='");
    localStringBuilder.append(this.pluginId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", inner_version='");
    localStringBuilder.append(this.innerVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pluginId);
    paramParcel.writeString(this.innerVersion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PluginInfo
 * JD-Core Version:    0.7.0.1
 */