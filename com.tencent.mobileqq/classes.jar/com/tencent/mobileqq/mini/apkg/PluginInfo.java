package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PluginInfo> CREATOR = new PluginInfo.1();
  private String inner_version;
  private String plugin_id;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getInnerVersion()
  {
    return this.inner_version;
  }
  
  public String getPluginId()
  {
    return this.plugin_id;
  }
  
  public void setInnerVersion(String paramString)
  {
    this.inner_version = paramString;
  }
  
  public void setPluginId(String paramString)
  {
    this.plugin_id = paramString;
  }
  
  public String toString()
  {
    return "PluginInfo{plugin_id='" + this.plugin_id + '\'' + ", inner_version='" + this.inner_version + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.plugin_id);
    paramParcel.writeString(this.inner_version);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.PluginInfo
 * JD-Core Version:    0.7.0.1
 */