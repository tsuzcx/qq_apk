package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StPluginInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class MiniGamePluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MiniGamePluginInfo> CREATOR = new MiniGamePluginInfo.1();
  public final String id;
  public final String name;
  public final int packageSize;
  public final String url;
  public final String version;
  
  protected MiniGamePluginInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.id = paramParcel.readString();
    this.version = paramParcel.readString();
    this.url = paramParcel.readString();
    this.packageSize = paramParcel.readInt();
  }
  
  public MiniGamePluginInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.name = paramString1;
    this.id = paramString2;
    this.version = paramString3;
    this.url = paramString4;
    this.packageSize = paramInt;
  }
  
  public static MiniGamePluginInfo fromProtocol(INTERFACE.StPluginInfo paramStPluginInfo)
  {
    if ((paramStPluginInfo != null) && (!TextUtils.isEmpty(paramStPluginInfo.pluginName.get())) && (!TextUtils.isEmpty(paramStPluginInfo.pluginId.get())) && (!TextUtils.isEmpty(paramStPluginInfo.version.get())) && (!TextUtils.isEmpty(paramStPluginInfo.url.get()))) {
      return new MiniGamePluginInfo(paramStPluginInfo.pluginName.get(), paramStPluginInfo.pluginId.get(), paramStPluginInfo.version.get(), paramStPluginInfo.url.get(), paramStPluginInfo.fileSize.get());
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MiniGamePluginInfo)) {
      return false;
    }
    paramObject = (MiniGamePluginInfo)paramObject;
    if (this.packageSize != paramObject.packageSize) {
      return false;
    }
    if (!this.name.equals(paramObject.name)) {
      return false;
    }
    if (!this.id.equals(paramObject.id)) {
      return false;
    }
    if (!this.version.equals(paramObject.version)) {
      return false;
    }
    return this.url.equals(paramObject.url);
  }
  
  public int hashCode()
  {
    return (((this.name.hashCode() * 31 + this.id.hashCode()) * 31 + this.version.hashCode()) * 31 + this.url.hashCode()) * 31 + this.packageSize;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniGamePluginInfo{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packageSize=");
    localStringBuilder.append(this.packageSize);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.packageSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo
 * JD-Core Version:    0.7.0.1
 */