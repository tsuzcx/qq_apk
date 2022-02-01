package com.tencent.mobileqq.mini.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import java.util.ArrayList;
import java.util.Iterator;

public class PreCacheManager$PreCacheDescData
  implements Parcelable
{
  public static final Parcelable.Creator<PreCacheDescData> CREATOR = new PreCacheManager.PreCacheDescData.1();
  public String appid;
  public String cacheKey;
  public byte[] data;
  public String filePath;
  public String path;
  public int scene;
  public long timeStamp;
  public String url;
  
  public PreCacheManager$PreCacheDescData() {}
  
  protected PreCacheManager$PreCacheDescData(Parcel paramParcel)
  {
    this.appid = paramParcel.readString();
    this.url = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.timeStamp = paramParcel.readLong();
    this.filePath = paramParcel.readString();
  }
  
  public PreCacheManager$PreCacheDescData(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if (paramMiniAppConfig != null)
    {
      this.appid = paramMiniAppConfig.config.appId;
      this.scene = paramMiniAppConfig.launchParam.scene;
      this.path = paramMiniAppConfig.launchParam.entryPath;
      int i = PreCacheManager.getCacheType(paramString);
      if (paramMiniAppConfig.config.preCacheList != null)
      {
        paramMiniAppConfig = paramMiniAppConfig.config.preCacheList.iterator();
        while (paramMiniAppConfig.hasNext())
        {
          paramString = (PreCacheInfo)paramMiniAppConfig.next();
          if ((paramString != null) && (paramString.cacheType == i)) {
            this.url = paramString.getDataUrl;
          }
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCacheKey(String paramString)
  {
    StringBuilder localStringBuilder;
    if ("periodic".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(this.appid);
      paramString.append("_");
      paramString.append(this.url);
      paramString = paramString.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString.hashCode());
      return localStringBuilder.toString();
    }
    if (TextUtils.isEmpty(this.cacheKey))
    {
      paramString = new StringBuilder();
      paramString.append(this.appid);
      paramString.append("_");
      paramString.append(this.url);
      paramString.append("_");
      paramString.append(this.scene);
      paramString.append("_");
      paramString.append(this.path);
      paramString = paramString.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString.hashCode());
      this.cacheKey = localStringBuilder.toString();
    }
    return this.cacheKey;
  }
  
  public String getQuery()
  {
    if (TextUtils.isEmpty(this.path)) {
      return "";
    }
    if (this.path.contains("?"))
    {
      String str = this.path;
      return str.substring(str.indexOf("?") + 1);
    }
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appid);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.timeStamp);
    paramParcel.writeString(this.filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.PreCacheDescData
 * JD-Core Version:    0.7.0.1
 */