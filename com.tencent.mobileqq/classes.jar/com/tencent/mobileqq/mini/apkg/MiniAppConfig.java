package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;

public class MiniAppConfig
  implements Parcelable
{
  public static final Parcelable.Creator<MiniAppConfig> CREATOR = new MiniAppConfig.1();
  public static final int FLAG_NEED_KILL = 2;
  public static final int FLAG_NEED_NEW_PROCESS = 1;
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public BaseLibInfo baseLibInfo;
  public MiniAppInfo config;
  public String entryPath;
  public int forceReroad;
  public int gameAdsTotalTime;
  public boolean isFromShowInfo;
  public boolean isSdkMode;
  public LaunchParam launchParam;
  public String link;
  public int linkType;
  
  public MiniAppConfig(MiniAppInfo paramMiniAppInfo)
  {
    this(paramMiniAppInfo, getBaseLibInfoByType(paramMiniAppInfo));
  }
  
  private MiniAppConfig(MiniAppInfo paramMiniAppInfo, BaseLibInfo paramBaseLibInfo)
  {
    this.config = paramMiniAppInfo;
    this.baseLibInfo = paramBaseLibInfo;
    this.launchParam = new LaunchParam();
  }
  
  public static boolean equalObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static BaseLibInfo getBaseLibInfoByType(MiniAppInfo paramMiniAppInfo)
  {
    return BaseLibManager.g().getBaseLibInfo();
  }
  
  public static boolean isValid(MiniAppConfig paramMiniAppConfig)
  {
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if (paramMiniAppConfig == null) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (paramMiniAppConfig.config != null) {
            break;
          }
        } while (this.config == null);
        return false;
        if (!isEngineTypeMiniGame()) {
          break;
        }
      } while ((equalObj(this.config.appId, paramMiniAppConfig.config.appId)) && (equalObj(Integer.valueOf(this.config.verType), Integer.valueOf(paramMiniAppConfig.config.verType))) && (equalObj(this.config.version, paramMiniAppConfig.config.version)));
      return false;
    } while ((equalObj(this.config.appId, paramMiniAppConfig.config.appId)) && (equalObj(Integer.valueOf(this.config.verType), Integer.valueOf(paramMiniAppConfig.config.verType))) && (equalObj(this.config.version, paramMiniAppConfig.config.version)) && (equalObj(this.config.firstPage, paramMiniAppConfig.config.firstPage)));
    return false;
  }
  
  public String getConfigInfo()
  {
    return "config =" + this.config;
  }
  
  public boolean isBackToMiniApp()
  {
    return (this.launchParam != null) && (this.launchParam.fromBackToMiniApp == 1);
  }
  
  public boolean isEngineTypeMiniGame()
  {
    return (this.config != null) && (this.config.isEngineTypeMiniGame());
  }
  
  public boolean isFromShowInfo()
  {
    return this.isFromShowInfo;
  }
  
  public boolean isInternalApp()
  {
    return (this.config != null) && (this.config.isInternalApp());
  }
  
  public boolean isLimitedAccessApp()
  {
    return (this.config != null) && (this.config.isLimitedAccessApp());
  }
  
  public boolean isReportTypeMiniGame()
  {
    return (this.config != null) && (this.config.isReportTypeMiniGame());
  }
  
  public boolean isShortcutFakeApp()
  {
    return (this.launchParam != null) && (this.launchParam.scene == 1023) && (this.config != null) && (TextUtils.isEmpty(this.config.downloadUrl));
  }
  
  public String toString()
  {
    return "MiniAppConfig{config=" + this.config + ", launchParam=" + this.launchParam + ", baseLibInfo=" + this.baseLibInfo + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeParcelable(this.config, 0);
    paramParcel.writeParcelable(this.launchParam, 0);
    paramParcel.writeParcelable(this.baseLibInfo, 0);
    paramParcel.writeInt(this.forceReroad);
    if (this.isFromShowInfo)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.link);
      paramParcel.writeInt(this.linkType);
      paramParcel.writeString(this.entryPath);
      if (!this.isSdkMode) {
        break label95;
      }
    }
    label95:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppConfig
 * JD-Core Version:    0.7.0.1
 */