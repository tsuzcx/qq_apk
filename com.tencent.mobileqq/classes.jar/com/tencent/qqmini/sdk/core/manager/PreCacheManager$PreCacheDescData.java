package com.tencent.qqmini.sdk.core.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
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
  
  public PreCacheManager$PreCacheDescData(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    this.appid = paramMiniAppInfo.appId;
    this.scene = paramMiniAppInfo.launchParam.scene;
    this.path = paramMiniAppInfo.launchParam.entryPath;
    int i = PreCacheManager.getCacheType(paramString);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.preCacheList != null))
    {
      paramMiniAppInfo = paramMiniAppInfo.preCacheList.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        paramString = (PreCacheInfo)paramMiniAppInfo.next();
        if ((paramString != null) && (paramString.cacheType == i)) {
          this.url = paramString.getDataUrl;
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
    if ("periodic".equals(paramString))
    {
      paramString = this.appid + "_" + this.url;
      return "" + paramString.hashCode();
    }
    if (TextUtils.isEmpty(this.cacheKey))
    {
      paramString = this.appid + "_" + this.url + "_" + this.scene + "_" + this.path;
      this.cacheKey = ("" + paramString.hashCode());
    }
    return this.cacheKey;
  }
  
  public String getQuery()
  {
    if (TextUtils.isEmpty(this.path)) {
      return "";
    }
    if (this.path.contains("?")) {
      return this.path.substring(this.path.indexOf("?") + 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.PreCacheDescData
 * JD-Core Version:    0.7.0.1
 */