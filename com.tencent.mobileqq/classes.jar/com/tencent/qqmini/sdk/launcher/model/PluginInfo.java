package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdnb;

public class PluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PluginInfo> CREATOR = new bdnb();
  private String a;
  private String b;
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "PluginInfo{plugin_id='" + this.a + '\'' + ", inner_version='" + this.b + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PluginInfo
 * JD-Core Version:    0.7.0.1
 */