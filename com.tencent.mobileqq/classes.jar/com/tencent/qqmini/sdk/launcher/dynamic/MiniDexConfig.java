package com.tencent.qqmini.sdk.launcher.dynamic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.launcher.utils.SharedPreferencesUtil;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.File;
import org.json.JSONObject;

public class MiniDexConfig
  implements Parcelable
{
  public static final Parcelable.Creator<MiniDexConfig> CREATOR = new MiniDexConfig.1();
  private static String DEX_FOLDER;
  private static final String TAG = "minisdk-MiniAppDexLoader_DexConfig";
  public String currPlatformVersion;
  public String dexUrl;
  public String md5;
  public String minBaselibVersion;
  public String platformVersion;
  
  public MiniDexConfig() {}
  
  protected MiniDexConfig(Parcel paramParcel)
  {
    this.platformVersion = paramParcel.readString();
    this.minBaselibVersion = paramParcel.readString();
    this.dexUrl = paramParcel.readString();
    this.md5 = paramParcel.readString();
  }
  
  public static MiniDexConfig convertFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject;
    String str1;
    String str2;
    String str3;
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("app_version");
      str1 = ((JSONObject)localObject).optString("ver");
      str2 = ((JSONObject)localObject).optString("minjs");
      str3 = ((JSONObject)localObject).optString("url");
      localObject = ((JSONObject)localObject).optString("md5");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3)))
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex config is invalid because of platformVersion or url is empty.");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", paramString);
      return null;
    }
    MiniDexConfig localMiniDexConfig = new MiniDexConfig();
    localMiniDexConfig.currPlatformVersion = paramString;
    localMiniDexConfig.platformVersion = str1;
    localMiniDexConfig.minBaselibVersion = str2;
    localMiniDexConfig.dexUrl = str3;
    localMiniDexConfig.md5 = ((String)localObject);
    return localMiniDexConfig;
  }
  
  public static String getDexFolder()
  {
    if (TextUtils.isEmpty(DEX_FOLDER)) {
      DEX_FOLDER = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/dex/";
    }
    return DEX_FOLDER;
  }
  
  public static MiniDexConfig getValidDexConfig(String paramString)
  {
    QMLog.i("minisdk-MiniAppDexLoader_DexConfig", "dex config: " + paramString);
    paramString = convertFrom(paramString);
    if ((paramString != null) && (paramString.verifyDex())) {
      return paramString;
    }
    return null;
  }
  
  public void addCrashInfo()
  {
    try
    {
      if (TextUtils.isEmpty(this.dexUrl)) {
        return;
      }
      Object localObject = SharedPreferencesUtil.getPreference().getString("dexcrash", "");
      QMLog.i("minisdk-MiniAppDexLoader_DexConfig", "add crash info. dexUrl:" + this.dexUrl + " dexCrashInfo:" + (String)localObject);
      localObject = ((String)localObject).split(";");
      if ((localObject.length == 3) && (this.dexUrl.equals(localObject[0])))
      {
        int i = Integer.parseInt(localObject[1]);
        long l = Long.parseLong(localObject[2]);
        if (System.currentTimeMillis() - l > 7200000L) {
          return;
        }
        i += 1;
        QMLog.i("minisdk-MiniAppDexLoader_DexConfig", "add crash count " + i);
        localObject = this.dexUrl + ";" + i + ";" + System.currentTimeMillis();
        SharedPreferencesUtil.getPreference().edit().putString("dexcrash", (String)localObject).commit();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", localThrowable);
      return;
    }
    String str = this.dexUrl + ";" + 1 + ";" + System.currentTimeMillis();
    SharedPreferencesUtil.getPreference().edit().putString("dexcrash", str).commit();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDexCrashCount()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(this.dexUrl)) {
          return 0;
        }
        String[] arrayOfString = SharedPreferencesUtil.getPreference().getString("dexcrash", "").split(";");
        if ((arrayOfString.length == 3) && (this.dexUrl.equals(arrayOfString[0])))
        {
          i = Integer.parseInt(arrayOfString[1]);
          QMLog.i("minisdk-MiniAppDexLoader_DexConfig", "get crash count=" + i + " dexUrl:" + this.dexUrl);
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", localThrowable);
        return 0;
      }
      int i = 0;
    }
  }
  
  public String getDexPath()
  {
    if (TextUtils.isEmpty(this.dexUrl))
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex url is null.");
      return null;
    }
    return getDexFolder() + this.dexUrl.hashCode() + ".jar";
  }
  
  public boolean isDexDownloaded()
  {
    String str = getDexPath();
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex file is not exist.");
      return false;
    }
    if (!TextUtils.isEmpty(this.md5))
    {
      str = MD5Utils.encodeFileHexStr(str);
      if ((TextUtils.isEmpty(str)) || (!this.md5.toLowerCase().equals(str.toLowerCase())))
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "md5 is wrong! configMD5=" + this.md5 + " fileMD5=" + str);
        return false;
      }
    }
    return true;
  }
  
  public boolean verifyDex()
  {
    if (TextUtils.isEmpty(this.currPlatformVersion)) {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex is invalid because of currPlatformVersion is empty.");
    }
    do
    {
      return false;
      if (TextUtils.isEmpty(this.platformVersion))
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex is invalid because of platformVersion is empty.");
        return false;
      }
      try
      {
        String str1 = this.currPlatformVersion;
        if (!this.platformVersion.equals(str1))
        {
          QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "platformVersion is not match. platformVersion=" + this.platformVersion + " currQUA=" + str1);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", localThrowable);
        if (TextUtils.isEmpty(this.minBaselibVersion))
        {
          String str2 = StorageUtil.getPreference().getString("version", "1.18.0.00132");
          if (BaseLibInfo.needUpdateVersion(this.minBaselibVersion, str2))
          {
            QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "baselib version is not match. minBaselibVersion=" + this.platformVersion + " currBaselibVersion=" + str2);
            return false;
          }
        }
        if (TextUtils.isEmpty(this.dexUrl))
        {
          QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex url is empty.");
          return true;
        }
      }
    } while (!isDexDownloaded());
    if (getDexCrashCount() >= 3)
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex is invalid because of too many crashes!");
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.platformVersion);
    paramParcel.writeString(this.minBaselibVersion);
    paramParcel.writeString(this.dexUrl);
    paramParcel.writeString(this.md5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDexConfig
 * JD-Core Version:    0.7.0.1
 */