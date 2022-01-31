package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MiniAppBaseInfo
  implements Parcelable, Serializable
{
  public static final int Audit = 2;
  public static final int AuditPass = 6;
  public static final int AuditReject = 7;
  public static final Parcelable.Creator<MiniAppBaseInfo> CREATOR = new MiniAppBaseInfo.1();
  public static final int Deleted = 5;
  public static final int Develop = 0;
  public static final String ENV_VERSION_DEVELOP = "develop";
  public static final String ENV_VERSION_RELEASE = "release";
  public static final String ENV_VERSION_TRIAL = "trial";
  public static final int Experience = 1;
  public static final int GrayRelease = 8;
  public static final int Offline = 9;
  public static final int Online = 3;
  public static final int Preview = 4;
  public static final String TAG = "MiniAppInfo";
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public ApkgBaseInfo apkgInfo;
  public String appId;
  public AppMode appMode;
  public int appType;
  public String baselibMiniVersion;
  public List<String> blackList;
  public List<String> businessDomainList;
  public DebugInfo debugInfo;
  public String desc;
  public String developerDesc;
  public List<String> downloadFileDomainList;
  public String downloadUrl;
  public int engineType;
  public int fileSize;
  public FirstPageInfo firstPage;
  public String firstPath;
  public String iconUrl;
  public String link;
  public int linkType;
  public String name;
  public int noNeedRealRecommend;
  public ArrayList<String> qualifications;
  public RenderInfo renderInfo;
  public String reportData;
  public List<String> requestDomainList;
  public List<SecondApiRightInfo> secondApiRightInfoList;
  public String shareId;
  public int skipDomainCheck;
  public List<String> socketDomainList;
  public int startMode;
  public List<SubPkgInfo> subpkgs;
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {}
    while ((!equalObj(this.appId, paramMiniAppBaseInfo.appId)) || (!equalObj(Integer.valueOf(this.verType), Integer.valueOf(paramMiniAppBaseInfo.verType))) || (!equalObj(this.version, paramMiniAppBaseInfo.version)) || (!equalObj(Integer.valueOf(this.engineType), Integer.valueOf(paramMiniAppBaseInfo.engineType))) || (!equalObj(this.renderInfo, paramMiniAppBaseInfo.renderInfo))) {
      return false;
    }
    return true;
  }
  
  public int getEngineType()
  {
    return this.engineType;
  }
  
  public String getVerTypeStr()
  {
    if ((this.verType == 0) || (this.verType == 4)) {
      return "develop";
    }
    if (this.verType == 1) {
      return "trial";
    }
    return "release";
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
    return (this.appMode != null) && (this.appMode.interMode);
  }
  
  public String simpleInfo()
  {
    return "[appId=" + this.appId + "][name=" + this.name + "]";
  }
  
  public boolean supportNativeRenderMode()
  {
    return (this.renderInfo != null) && (this.renderInfo.renderMode == 1) && (!TextUtils.isEmpty((CharSequence)this.renderInfo.renderMaterialMap.get(Integer.valueOf(1))));
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{appId=").append(this.appId).append(", name=").append(this.name).append(", version=").append(this.version).append(", verType=").append(this.verType).append(", engineType=").append(this.engineType).append(", renderInfo=");
    if (this.renderInfo != null) {}
    for (int i = this.renderInfo.renderMode;; i = -1) {
      return i + ", firstPage=" + this.firstPage;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MiniAppInfo{appId=").append(this.appId).append(", name=").append(this.name).append(", version=").append(this.version).append(", verType=").append(this.verType).append(", engineType=").append(this.engineType).append(", renderInfo=");
    if (this.renderInfo != null) {}
    for (int i = this.renderInfo.renderMode;; i = -1) {
      return i + ", firstPage=" + this.firstPage;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.appType);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.versionId);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.verType);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeString(this.baselibMiniVersion);
    paramParcel.writeTypedList(this.subpkgs);
    paramParcel.writeParcelable(this.firstPage, paramInt);
    paramParcel.writeStringList(this.whiteList);
    paramParcel.writeStringList(this.blackList);
    paramParcel.writeTypedList(this.secondApiRightInfoList);
    paramParcel.writeParcelable(this.debugInfo, paramInt);
    paramParcel.writeStringList(this.requestDomainList);
    paramParcel.writeStringList(this.socketDomainList);
    paramParcel.writeStringList(this.uploadFileDomainList);
    paramParcel.writeStringList(this.downloadFileDomainList);
    paramParcel.writeStringList(this.businessDomainList);
    paramParcel.writeStringList(this.udpIpList);
    paramParcel.writeInt(this.fileSize);
    paramParcel.writeString(this.developerDesc);
    paramParcel.writeInt(this.skipDomainCheck);
    paramParcel.writeLong(this.usrFileSizeLimit);
    paramParcel.writeInt(this.noNeedRealRecommend);
    paramParcel.writeInt(this.versionUpdateTime);
    paramParcel.writeInt(this.engineType);
    paramParcel.writeParcelable(this.renderInfo, paramInt);
    paramParcel.writeParcelable(this.appMode, paramInt);
    paramParcel.writeStringList(this.qualifications);
    paramParcel.writeString(this.shareId);
    paramParcel.writeString(this.via);
    paramParcel.writeString(this.firstPath);
    paramParcel.writeString(this.link);
    paramParcel.writeInt(this.linkType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo
 * JD-Core Version:    0.7.0.1
 */