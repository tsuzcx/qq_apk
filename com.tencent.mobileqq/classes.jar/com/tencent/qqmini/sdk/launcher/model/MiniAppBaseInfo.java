package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MiniAppBaseInfo
  implements Parcelable
{
  public static final int AUDIT = 2;
  public static final int AUDIT_PASS = 6;
  public static final int AUDIT_REJECT = 7;
  public static final Parcelable.Creator<MiniAppBaseInfo> CREATOR = new MiniAppBaseInfo.1();
  public static final int DELETED = 5;
  public static final int DEVELOP = 0;
  public static final int DEVICE_UNKOWN = 0;
  public static final String ENV_VERSION_DEVELOP = "develop";
  public static final String ENV_VERSION_RELEASE = "release";
  public static final String ENV_VERSION_TRIAL = "trial";
  public static final int EXPERIENCE = 1;
  public static final int GRAY_RELEASE = 8;
  public static final int LANDSCAPE = 2;
  public static final int LANDSCAPELEFT = 3;
  public static final int LANDSCAPERIGHT = 4;
  public static final int NO_SHOW = 2;
  public static final int OFFLINE = 9;
  public static final int ONLINE = 3;
  public static final int PORTRAIT = 1;
  public static final int PREVIEW = 4;
  public static final int SHOW_STATUS = 1;
  public static final int SHOW_UNKOWN = 0;
  public static final String TAG = "MiniAppInfo";
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public String amsAdInfo;
  public ApkgBaseInfo apkgInfo;
  public String apngUrl;
  public String appId;
  public AppMode appMode;
  @Deprecated
  public int appType;
  public String baselibMiniVersion;
  public List<String> blackList;
  public List<String> businessDomainList;
  public DebugInfo debugInfo;
  public String desc;
  public String developerDesc;
  public int deviceOrientation;
  public List<String> downloadFileDomainList;
  public String downloadUrl;
  public boolean enableLoadingAd;
  public int engineType;
  public int fileSize;
  public FirstPageInfo firstPage;
  public String firstPath;
  public String gameApprovalNumber;
  public String gameCopyrightInfo;
  public String gameOperatingCompany;
  public String gamePublicationCompany;
  public String gamePublicationNumber;
  public String iconUrl;
  public String ideExtraAppid;
  public String ideExtraData;
  public String ideScene;
  public String link;
  public int linkType;
  public String name;
  public int noNeedRealRecommend;
  public String prepayId;
  public ArrayList<String> qualifications;
  public RenderInfo renderInfo;
  public String reportData;
  public List<String> requestDomainList;
  public List<SecondApiRightInfo> secondApiRightInfoList;
  public String shareId;
  public int showStatusBar;
  public int skipDomainCheck;
  public List<String> socketDomainList;
  public int startMode;
  public List<SubPkgInfo> subpkgs;
  public int tianshuAdId;
  public long timestamp;
  public List<String> udpIpList = new ArrayList();
  public List<String> uploadFileDomainList;
  public long usrFileSizeLimit;
  public int verType;
  public String version;
  public String versionId;
  public int versionUpdateTime;
  public String via;
  public List<String> whiteList;
  
  public MiniAppBaseInfo() {}
  
  protected MiniAppBaseInfo(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.name = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.appType = paramParcel.readInt();
    this.version = paramParcel.readString();
    this.versionId = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.verType = paramParcel.readInt();
    this.timestamp = paramParcel.readLong();
    this.baselibMiniVersion = paramParcel.readString();
    this.subpkgs = paramParcel.createTypedArrayList(SubPkgInfo.CREATOR);
    this.firstPage = ((FirstPageInfo)paramParcel.readParcelable(FirstPageInfo.class.getClassLoader()));
    this.whiteList = paramParcel.createStringArrayList();
    this.blackList = paramParcel.createStringArrayList();
    this.secondApiRightInfoList = paramParcel.createTypedArrayList(SecondApiRightInfo.CREATOR);
    this.debugInfo = ((DebugInfo)paramParcel.readParcelable(DebugInfo.class.getClassLoader()));
    this.requestDomainList = paramParcel.createStringArrayList();
    this.socketDomainList = paramParcel.createStringArrayList();
    this.uploadFileDomainList = paramParcel.createStringArrayList();
    this.downloadFileDomainList = paramParcel.createStringArrayList();
    this.businessDomainList = paramParcel.createStringArrayList();
    this.udpIpList = paramParcel.createStringArrayList();
    this.fileSize = paramParcel.readInt();
    this.developerDesc = paramParcel.readString();
    this.skipDomainCheck = paramParcel.readInt();
    this.usrFileSizeLimit = paramParcel.readLong();
    this.noNeedRealRecommend = paramParcel.readInt();
    this.versionUpdateTime = paramParcel.readInt();
    this.engineType = paramParcel.readInt();
    this.renderInfo = ((RenderInfo)paramParcel.readParcelable(RenderInfo.class.getClassLoader()));
    this.appMode = ((AppMode)paramParcel.readParcelable(AppMode.class.getClassLoader()));
    this.qualifications = paramParcel.createStringArrayList();
    this.shareId = paramParcel.readString();
    this.via = paramParcel.readString();
    this.firstPath = paramParcel.readString();
    this.link = paramParcel.readString();
    this.linkType = paramParcel.readInt();
    this.deviceOrientation = paramParcel.readInt();
    this.showStatusBar = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.enableLoadingAd = bool;
    this.prepayId = paramParcel.readString();
    this.amsAdInfo = paramParcel.readString();
    this.apngUrl = paramParcel.readString();
    this.ideScene = paramParcel.readString();
    this.ideExtraAppid = paramParcel.readString();
    this.ideExtraData = paramParcel.readString();
    this.tianshuAdId = paramParcel.readInt();
    this.gameCopyrightInfo = paramParcel.readString();
    this.gamePublicationNumber = paramParcel.readString();
    this.gamePublicationCompany = paramParcel.readString();
    this.gameApprovalNumber = paramParcel.readString();
    this.gameOperatingCompany = paramParcel.readString();
  }
  
  public static boolean equalObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static int getVerType(String paramString)
  {
    if ("develop".equalsIgnoreCase(paramString)) {
      return 0;
    }
    if ("trial".equalsIgnoreCase(paramString)) {
      return 1;
    }
    return 3;
  }
  
  public static boolean isSameVersion(MiniAppBaseInfo paramMiniAppBaseInfo1, MiniAppBaseInfo paramMiniAppBaseInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMiniAppBaseInfo1 != null)
    {
      if (paramMiniAppBaseInfo2 == null) {
        return false;
      }
      bool1 = bool2;
      if (equalObj(paramMiniAppBaseInfo1.appId, paramMiniAppBaseInfo2.appId))
      {
        bool1 = bool2;
        if (equalObj(Integer.valueOf(paramMiniAppBaseInfo1.verType), Integer.valueOf(paramMiniAppBaseInfo2.verType)))
        {
          bool1 = bool2;
          if (equalObj(paramMiniAppBaseInfo1.version, paramMiniAppBaseInfo2.version))
          {
            bool1 = bool2;
            if (equalObj(paramMiniAppBaseInfo1.versionId, paramMiniAppBaseInfo2.versionId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    boolean bool2 = false;
    if (paramMiniAppBaseInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (equalObj(this.appId, paramMiniAppBaseInfo.appId))
    {
      bool1 = bool2;
      if (equalObj(Integer.valueOf(this.verType), Integer.valueOf(paramMiniAppBaseInfo.verType)))
      {
        bool1 = bool2;
        if (equalObj(this.version, paramMiniAppBaseInfo.version))
        {
          bool1 = bool2;
          if (equalObj(Integer.valueOf(this.engineType), Integer.valueOf(paramMiniAppBaseInfo.engineType)))
          {
            bool1 = bool2;
            if (equalObj(this.renderInfo, paramMiniAppBaseInfo.renderInfo)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int getEngineType()
  {
    return this.engineType;
  }
  
  public String getVerTypeStr()
  {
    int i = this.verType;
    if ((i != 0) && (i != 4))
    {
      if (i == 1) {
        return "trial";
      }
      return "release";
    }
    return "develop";
  }
  
  public boolean isEngineTypeMiniApp()
  {
    return this.engineType == 0;
  }
  
  public boolean isEngineTypeMiniGame()
  {
    return this.engineType == 1;
  }
  
  public boolean isInternalApp()
  {
    if (this.appId.equals("1109907872")) {
      return true;
    }
    AppMode localAppMode = this.appMode;
    return (localAppMode != null) && (localAppMode.interMode);
  }
  
  public boolean isLandScape()
  {
    int i = this.deviceOrientation;
    return (i == 2) || (i == 3) || (i == 4);
  }
  
  public boolean isShowStatusBar()
  {
    return this.showStatusBar == 1;
  }
  
  public String simpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("][name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public boolean supportNativeRenderMode()
  {
    RenderInfo localRenderInfo = this.renderInfo;
    return (localRenderInfo != null) && (localRenderInfo.renderMode == 1) && (!TextUtils.isEmpty((CharSequence)this.renderInfo.renderMaterialMap.get(Integer.valueOf(1))));
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", verType=");
    localStringBuilder.append(this.verType);
    localStringBuilder.append(", engineType=");
    localStringBuilder.append(this.engineType);
    localStringBuilder.append(", renderInfo=");
    RenderInfo localRenderInfo = this.renderInfo;
    int i;
    if (localRenderInfo != null) {
      i = localRenderInfo.renderMode;
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", firstPage=");
    localStringBuilder.append(this.firstPage);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppInfo{appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", verType=");
    localStringBuilder.append(this.verType);
    localStringBuilder.append(", engineType=");
    localStringBuilder.append(this.engineType);
    localStringBuilder.append(", renderInfo=");
    RenderInfo localRenderInfo = this.renderInfo;
    int i;
    if (localRenderInfo != null) {
      i = localRenderInfo.renderMode;
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", firstPage=");
    localStringBuilder.append(this.firstPage);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo
 * JD-Core Version:    0.7.0.1
 */