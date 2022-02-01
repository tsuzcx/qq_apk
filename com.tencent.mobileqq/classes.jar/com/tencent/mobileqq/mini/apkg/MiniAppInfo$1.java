package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import java.util.ArrayList;

final class MiniAppInfo$1
  implements Parcelable.Creator<MiniAppInfo>
{
  public MiniAppInfo createFromParcel(Parcel paramParcel)
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    for (;;)
    {
      try
      {
        localMiniAppInfo.appId = paramParcel.readString();
        localMiniAppInfo.name = paramParcel.readString();
        localMiniAppInfo.iconUrl = paramParcel.readString();
        localMiniAppInfo.downloadUrl = paramParcel.readString();
        localMiniAppInfo.topType = paramParcel.readInt();
        localMiniAppInfo.version = paramParcel.readString();
        localMiniAppInfo.versionId = paramParcel.readString();
        localMiniAppInfo.desc = paramParcel.readString();
        localMiniAppInfo.verType = paramParcel.readInt();
        localMiniAppInfo.timestamp = paramParcel.readLong();
        localMiniAppInfo.baselibMiniVersion = paramParcel.readString();
        localMiniAppInfo.subpkgs = paramParcel.createTypedArrayList(SubPkgInfo.CREATOR);
        localMiniAppInfo.firstPage = ((FirstPageInfo)paramParcel.readParcelable(FirstPageInfo.class.getClassLoader()));
        localMiniAppInfo.engineType = paramParcel.readInt();
        localMiniAppInfo.whiteList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.whiteList);
        localMiniAppInfo.blackList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.blackList);
        localMiniAppInfo.secondApiRightInfoList = paramParcel.createTypedArrayList(SecondApiRightInfo.CREATOR);
        localMiniAppInfo.debugInfo = ((DebugInfo)paramParcel.readParcelable(DebugInfo.class.getClassLoader()));
        localMiniAppInfo.fileSize = paramParcel.readInt();
        localMiniAppInfo.requestDomainList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.requestDomainList);
        localMiniAppInfo.socketDomainList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.socketDomainList);
        localMiniAppInfo.downloadFileDomainList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.downloadFileDomainList);
        localMiniAppInfo.uploadFileDomainList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.uploadFileDomainList);
        localMiniAppInfo.businessDomainList = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.businessDomainList);
        paramParcel.readStringList(localMiniAppInfo.udpIpList);
        localMiniAppInfo.developerDesc = paramParcel.readString();
        localMiniAppInfo.extraData = paramParcel.readString();
        localMiniAppInfo.recommend = paramParcel.readInt();
        localMiniAppInfo.reportData = paramParcel.readString();
        localMiniAppInfo.appMode = ((AppMode)paramParcel.readParcelable(AppMode.class.getClassLoader()));
        localMiniAppInfo.openId = paramParcel.readString();
        localMiniAppInfo.tinyId = paramParcel.readLong();
        localMiniAppInfo.skipDomainCheck = paramParcel.readInt();
        localMiniAppInfo.position = paramParcel.readInt();
        int i = paramParcel.readByte();
        boolean bool2 = false;
        if (i != 0)
        {
          bool1 = true;
          localMiniAppInfo.isSupportBlueBar = bool1;
          if (paramParcel.readInt() != 1) {
            break label864;
          }
          bool1 = true;
          localMiniAppInfo.isSupportOffline = bool1;
          localMiniAppInfo.recommendAppIconUrl = paramParcel.readString();
          localMiniAppInfo.extendData = paramParcel.readString();
          localMiniAppInfo.clearAuths = paramParcel.readInt();
          localMiniAppInfo.commonExt = paramParcel.createByteArray();
          localMiniAppInfo.extConfigInfoList = paramParcel.createTypedArrayList(ExtConfigInfo.CREATOR);
          localMiniAppInfo.appStoreAnimPicUrl = paramParcel.readString();
          localMiniAppInfo.motionPics = new ArrayList();
          paramParcel.readStringList(localMiniAppInfo.motionPics);
          localMiniAppInfo.usrFileSizeLimit = paramParcel.readLong();
          localMiniAppInfo.preCacheList = paramParcel.createTypedArrayList(PreCacheInfo.CREATOR);
          localMiniAppInfo.versionUpdateTime = paramParcel.readInt();
          localMiniAppInfo.noNeedRealRecommend = paramParcel.readInt();
          localMiniAppInfo.miniGamePluginInfo = ((MiniGamePluginInfo)paramParcel.readParcelable(MiniGamePluginInfo.class.getClassLoader()));
          MiniAppInfo.access$002(localMiniAppInfo, paramParcel.readInt());
          localMiniAppInfo.qualifications = new ArrayList();
          paramParcel.readStringList(localMiniAppInfo.qualifications);
          localMiniAppInfo.shareId = paramParcel.readString();
          localMiniAppInfo.via = paramParcel.readString();
          localMiniAppInfo.amsAdInfo = paramParcel.readString();
          localMiniAppInfo.apngUrl = paramParcel.readString();
          localMiniAppInfo.ide_scene = paramParcel.readString();
          localMiniAppInfo.ide_extraAppid = paramParcel.readString();
          localMiniAppInfo.ide_extraData = paramParcel.readString();
          localMiniAppInfo.tianshuAdId = paramParcel.readInt();
          localMiniAppInfo.resourcePreCacheInfo = paramParcel.createTypedArrayList(ResourcePreCacheInfo.CREATOR);
          bool1 = bool2;
          if (paramParcel.readInt() == 1) {
            bool1 = true;
          }
          localMiniAppInfo.enableLoadingAd = bool1;
          localMiniAppInfo.deviceOrientation = paramParcel.readInt();
          localMiniAppInfo.showStatusBar = paramParcel.readInt();
          localMiniAppInfo.prepayId = paramParcel.readString();
          localMiniAppInfo.userNum = paramParcel.readInt();
          localMiniAppInfo.friendNum = paramParcel.readInt();
          localMiniAppInfo.users = paramParcel.createTypedArrayList(UseUserInfo.CREATOR);
          localMiniAppInfo.gameCopyrightInfo = paramParcel.readString();
          localMiniAppInfo.gamePublicationNumber = paramParcel.readString();
          localMiniAppInfo.gamePublicationCompany = paramParcel.readString();
          localMiniAppInfo.gameApprovalNumber = paramParcel.readString();
          localMiniAppInfo.gameOperatingCompany = paramParcel.readString();
          return localMiniAppInfo;
        }
      }
      catch (Throwable paramParcel)
      {
        QLog.e("[mini] MiniAppInfo", 1, "createFromParcel exception!", paramParcel);
        return localMiniAppInfo;
      }
      boolean bool1 = false;
      continue;
      label864:
      bool1 = false;
    }
  }
  
  public MiniAppInfo[] newArray(int paramInt)
  {
    return new MiniAppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppInfo.1
 * JD-Core Version:    0.7.0.1
 */