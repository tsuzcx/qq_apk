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
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public BaseLibInfo baseLibInfo;
  public MiniAppInfo config;
  public String entryPath;
  @Deprecated
  private int forceReroad = 0;
  public int gameAdsTotalTime = 0;
  public boolean isFromShowInfo;
  public boolean isSdkMode = false;
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
    if (paramMiniAppConfig != null)
    {
      paramMiniAppConfig = paramMiniAppConfig.config;
      if ((paramMiniAppConfig != null) && (!TextUtils.isEmpty(paramMiniAppConfig.appId))) {
        return true;
      }
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramMiniAppConfig == null) {
      return false;
    }
    if (paramMiniAppConfig.config == null)
    {
      if (this.config == null) {
        bool1 = true;
      }
      return bool1;
    }
    if (isEngineTypeMiniGame())
    {
      bool1 = bool2;
      if (equalObj(this.config.appId, paramMiniAppConfig.config.appId))
      {
        bool1 = bool2;
        if (equalObj(Integer.valueOf(this.config.verType), Integer.valueOf(paramMiniAppConfig.config.verType)))
        {
          bool1 = bool2;
          if (equalObj(this.config.version, paramMiniAppConfig.config.version)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    bool1 = bool3;
    if (equalObj(this.config.appId, paramMiniAppConfig.config.appId))
    {
      bool1 = bool3;
      if (equalObj(Integer.valueOf(this.config.verType), Integer.valueOf(paramMiniAppConfig.config.verType)))
      {
        bool1 = bool3;
        if (equalObj(this.config.version, paramMiniAppConfig.config.version))
        {
          bool1 = bool3;
          if (equalObj(this.config.firstPage, paramMiniAppConfig.config.firstPage)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getConfigInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config =");
    localStringBuilder.append(this.config);
    return localStringBuilder.toString();
  }
  
  public boolean isBackToMiniApp()
  {
    LaunchParam localLaunchParam = this.launchParam;
    return (localLaunchParam != null) && (localLaunchParam.fromBackToMiniApp == 1);
  }
  
  public boolean isEngineTypeMiniGame()
  {
    MiniAppInfo localMiniAppInfo = this.config;
    return (localMiniAppInfo != null) && (localMiniAppInfo.isEngineTypeMiniGame());
  }
  
  public boolean isFromShowInfo()
  {
    return this.isFromShowInfo;
  }
  
  public boolean isInternalApp()
  {
    MiniAppInfo localMiniAppInfo = this.config;
    return (localMiniAppInfo != null) && (localMiniAppInfo.isInternalApp());
  }
  
  public boolean isLimitedAccessApp()
  {
    MiniAppInfo localMiniAppInfo = this.config;
    return (localMiniAppInfo != null) && (localMiniAppInfo.isLimitedAccessApp());
  }
  
  public boolean isReportTypeMiniGame()
  {
    MiniAppInfo localMiniAppInfo = this.config;
    return (localMiniAppInfo != null) && (localMiniAppInfo.isReportTypeMiniGame());
  }
  
  public boolean isShortcutFakeApp()
  {
    Object localObject = this.launchParam;
    if ((localObject != null) && (((LaunchParam)localObject).scene == 1023))
    {
      localObject = this.config;
      if ((localObject != null) && (TextUtils.isEmpty(((MiniAppInfo)localObject).downloadUrl))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppConfig{config=");
    localStringBuilder.append(this.config);
    localStringBuilder.append(", launchParam=");
    localStringBuilder.append(this.launchParam);
    localStringBuilder.append(", baseLibInfo=");
    localStringBuilder.append(this.baseLibInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppConfig
 * JD-Core Version:    0.7.0.1
 */