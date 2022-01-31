package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE.StPluginInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class MiniGamePluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MiniGamePluginInfo> CREATOR = new MiniGamePluginInfo.1();
  @NonNull
  public final String id;
  @NonNull
  public final String name;
  public final int packageSize;
  @NonNull
  public final String url;
  @NonNull
  public final String version;
  
  protected MiniGamePluginInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.id = paramParcel.readString();
    this.version = paramParcel.readString();
    this.url = paramParcel.readString();
    this.packageSize = paramParcel.readInt();
  }
  
  public MiniGamePluginInfo(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt)
  {
    this.name = paramString1;
    this.id = paramString2;
    this.version = paramString3;
    this.url = paramString4;
    this.packageSize = paramInt;
  }
  
  @Nullable
  public static MiniGamePluginInfo fromProtocol(@Nullable INTERFACE.StPluginInfo paramStPluginInfo)
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
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof MiniGamePluginInfo));
            paramObject = (MiniGamePluginInfo)paramObject;
            bool1 = bool2;
          } while (this.packageSize != paramObject.packageSize);
          bool1 = bool2;
        } while (!this.name.equals(paramObject.name));
        bool1 = bool2;
      } while (!this.id.equals(paramObject.id));
      bool1 = bool2;
    } while (!this.version.equals(paramObject.version));
    return this.url.equals(paramObject.url);
  }
  
  public int hashCode()
  {
    return (((this.name.hashCode() * 31 + this.id.hashCode()) * 31 + this.version.hashCode()) * 31 + this.url.hashCode()) * 31 + this.packageSize;
  }
  
  public String toString()
  {
    return "MiniGamePluginInfo{name='" + this.name + '\'' + ", id='" + this.id + '\'' + ", version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", packageSize=" + this.packageSize + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo
 * JD-Core Version:    0.7.0.1
 */