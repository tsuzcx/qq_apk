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
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("app_version");
      String str1 = ((JSONObject)localObject).optString("ver");
      String str2 = ((JSONObject)localObject).optString("minjs");
      String str3 = ((JSONObject)localObject).optString("url");
      localObject = ((JSONObject)localObject).optString("md5");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
      {
        MiniDexConfig localMiniDexConfig = new MiniDexConfig();
        localMiniDexConfig.currPlatformVersion = paramString;
        localMiniDexConfig.platformVersion = str1;
        localMiniDexConfig.minBaselibVersion = str2;
        localMiniDexConfig.dexUrl = str3;
        localMiniDexConfig.md5 = ((String)localObject);
        return localMiniDexConfig;
      }
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex config is invalid because of platformVersion or url is empty.");
      return null;
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", paramString);
    }
    return null;
  }
  
  public static String getDexFolder()
  {
    if (TextUtils.isEmpty(DEX_FOLDER))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
      localStringBuilder.append("/mini/dex/");
      DEX_FOLDER = localStringBuilder.toString();
    }
    return DEX_FOLDER;
  }
  
  public static MiniDexConfig getValidDexConfig(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dex config: ");
    localStringBuilder.append(paramString);
    QMLog.i("minisdk-MiniAppDexLoader_DexConfig", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add crash info. dexUrl:");
      localStringBuilder.append(this.dexUrl);
      localStringBuilder.append(" dexCrashInfo:");
      localStringBuilder.append((String)localObject);
      QMLog.i("minisdk-MiniAppDexLoader_DexConfig", localStringBuilder.toString());
      localObject = ((String)localObject).split(";");
      if ((localObject.length == 3) && (this.dexUrl.equals(localObject[0])))
      {
        int i = Integer.parseInt(localObject[1]);
        long l = Long.parseLong(localObject[2]);
        if (System.currentTimeMillis() - l <= 7200000L)
        {
          i += 1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("add crash count ");
          ((StringBuilder)localObject).append(i);
          QMLog.i("minisdk-MiniAppDexLoader_DexConfig", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.dexUrl);
          ((StringBuilder)localObject).append(";");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(";");
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          localObject = ((StringBuilder)localObject).toString();
          SharedPreferencesUtil.getPreference().edit().putString("dexcrash", (String)localObject).commit();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.dexUrl);
        ((StringBuilder)localObject).append(";");
        ((StringBuilder)localObject).append(1);
        ((StringBuilder)localObject).append(";");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        localObject = ((StringBuilder)localObject).toString();
        SharedPreferencesUtil.getPreference().edit().putString("dexcrash", (String)localObject).commit();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", localThrowable);
    }
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
        Object localObject = SharedPreferencesUtil.getPreference().getString("dexcrash", "").split(";");
        if ((localObject.length == 3) && (this.dexUrl.equals(localObject[0])))
        {
          i = Integer.parseInt(localObject[1]);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get crash count=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" dexUrl:");
          ((StringBuilder)localObject).append(this.dexUrl);
          QMLog.i("minisdk-MiniAppDexLoader_DexConfig", ((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getDexFolder());
    localStringBuilder.append(this.dexUrl.hashCode());
    localStringBuilder.append(".jar");
    return localStringBuilder.toString();
  }
  
  public boolean isDexDownloaded()
  {
    String str = getDexPath();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      if (!TextUtils.isEmpty(this.md5))
      {
        str = MD5Utils.encodeFileHexStr(str);
        if ((TextUtils.isEmpty(str)) || (!this.md5.toLowerCase().equals(str.toLowerCase())))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("md5 is wrong! configMD5=");
          localStringBuilder.append(this.md5);
          localStringBuilder.append(" fileMD5=");
          localStringBuilder.append(str);
          QMLog.e("minisdk-MiniAppDexLoader_DexConfig", localStringBuilder.toString());
          return false;
        }
      }
      return true;
    }
    QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex file is not exist.");
    return false;
  }
  
  public boolean verifyDex()
  {
    if (TextUtils.isEmpty(this.currPlatformVersion))
    {
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex is invalid because of currPlatformVersion is empty.");
      return false;
    }
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("platformVersion is not match. platformVersion=");
        localStringBuilder.append(this.platformVersion);
        localStringBuilder.append(" currQUA=");
        localStringBuilder.append(str1);
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", localStringBuilder.toString());
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "", localThrowable);
      if (TextUtils.isEmpty(this.minBaselibVersion))
      {
        String str2 = StorageUtil.getPreference().getString("version", "1.22.0.00008");
        if (BaseLibInfo.needUpdateVersion(this.minBaselibVersion, str2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("baselib version is not match. minBaselibVersion=");
          localStringBuilder.append(this.platformVersion);
          localStringBuilder.append(" currBaselibVersion=");
          localStringBuilder.append(str2);
          QMLog.e("minisdk-MiniAppDexLoader_DexConfig", localStringBuilder.toString());
          return false;
        }
      }
      if (TextUtils.isEmpty(this.dexUrl))
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex url is empty.");
        return true;
      }
      if (!isDexDownloaded()) {
        return false;
      }
      if (getDexCrashCount() >= 3)
      {
        QMLog.e("minisdk-MiniAppDexLoader_DexConfig", "dex is invalid because of too many crashes!");
        return false;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDexConfig
 * JD-Core Version:    0.7.0.1
 */