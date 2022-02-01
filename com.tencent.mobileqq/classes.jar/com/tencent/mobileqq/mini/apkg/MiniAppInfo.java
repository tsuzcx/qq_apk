package com.tencent.mobileqq.mini.apkg;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiRightController;
import NS_MINI_INTERFACE.INTERFACE.StApiRightItem;
import NS_MINI_INTERFACE.INTERFACE.StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE.StAppFixInfoExt;
import NS_MINI_INTERFACE.INTERFACE.StAppMode;
import NS_MINI_INTERFACE.INTERFACE.StAppPreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE.StDeveloperInfo;
import NS_MINI_INTERFACE.INTERFACE.StDomainConfig;
import NS_MINI_INTERFACE.INTERFACE.StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE.StFirstPage;
import NS_MINI_INTERFACE.INTERFACE.StGamePublicationInfo;
import NS_MINI_INTERFACE.INTERFACE.StIdeConfig;
import NS_MINI_INTERFACE.INTERFACE.StMDebugInfo;
import NS_MINI_INTERFACE.INTERFACE.StMainPageExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StMotionPicInfo;
import NS_MINI_INTERFACE.INTERFACE.StOperationInfo;
import NS_MINI_INTERFACE.INTERFACE.StResourcePreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE.StStartExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StSubPkgInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_MINI_INTERFACE.INTERFACE.UseUserInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniAppInfo
  implements Parcelable, Serializable
{
  public static final String APP_STORE_MINI_APP_ID = "1108291530";
  public static final Parcelable.Creator<MiniAppInfo> CREATOR = new MiniAppInfo.1();
  public static final String ENV_VERSION_DEVELOP = "develop";
  public static final String ENV_VERSION_RELEASE = "release";
  public static final String ENV_VERSION_TRIAL = "trial";
  public static final String NATIVE_MINI_APP_ID_CHECKIN = "1108164955";
  public static final String TAG = "[mini] MiniAppInfo";
  public static final String TAG_DB = "miniapp-db";
  public String amsAdInfo;
  public String apngUrl;
  public String appId;
  public AppMode appMode = new AppMode();
  public String appStoreAnimPicUrl;
  public String baselibMiniVersion;
  public List<String> blackList;
  public List<String> businessDomainList;
  public int clearAuths;
  public byte[] commonExt;
  public DebugInfo debugInfo;
  public String desc;
  public String developerDesc;
  public int deviceOrientation;
  public List<String> downloadFileDomainList;
  public String downloadUrl;
  public boolean enableLoadingAd;
  public int engineType;
  public ArrayList<ExtConfigInfo> extConfigInfoList;
  public String extendData;
  public String extraData;
  public int fileSize;
  public FirstPageInfo firstPage;
  public String friendMessageQuery = "";
  public int friendNum;
  public String gameApprovalNumber;
  public String gameCopyrightInfo;
  public String gameOperatingCompany;
  public String gamePublicationCompany;
  public String gamePublicationNumber;
  public String iconUrl;
  public String ide_extraAppid;
  public String ide_extraData;
  public String ide_scene;
  public boolean isSupportBlueBar;
  public boolean isSupportOffline;
  public int miniAppType;
  public MiniGamePluginInfo miniGamePluginInfo;
  public ArrayList<String> motionPics;
  public String name;
  public int noNeedRealRecommend;
  public String openId;
  public int position;
  public ArrayList<PreCacheInfo> preCacheList;
  public String prepayId;
  public ArrayList<String> qualifications;
  public int recommend;
  public String recommendAppIconUrl;
  public RenderInfo renderInfo;
  public String reportData;
  private int reportType;
  public List<String> requestDomainList;
  public ArrayList<ResourcePreCacheInfo> resourcePreCacheInfo;
  public List<SecondApiRightInfo> secondApiRightInfoList;
  public String shareId;
  public int showStatusBar;
  public int skipDomainCheck;
  public List<String> socketDomainList;
  public List<SubPkgInfo> subpkgs;
  public int tianshuAdId;
  public long timestamp;
  public long tinyId;
  public int topType;
  public final List<String> udpIpList = new ArrayList();
  public List<String> uploadFileDomainList;
  public int userNum;
  public List<UseUserInfo> users;
  public long usrFileSizeLimit;
  public int verType;
  public String version;
  public String versionId;
  public int versionUpdateTime;
  public String via;
  public List<String> whiteList;
  
  public MiniAppInfo() {}
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
  {
    this(paramString5, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString7, paramString6, paramLong, null, "", null, null);
  }
  
  public MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    this(paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString1, paramString7, 0L, paramString6);
  }
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, long paramLong, List<INTERFACE.StSubPkgInfo> paramList, String paramString8, INTERFACE.StFirstPage paramStFirstPage, INTERFACE.StApiRightController paramStApiRightController)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, paramLong, paramList, paramString8, paramStFirstPage, paramStApiRightController, null);
  }
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, long paramLong, List<INTERFACE.StSubPkgInfo> paramList, String paramString8, INTERFACE.StFirstPage paramStFirstPage, INTERFACE.StApiRightController paramStApiRightController, INTERFACE.StMDebugInfo paramStMDebugInfo)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, paramLong, paramList, paramString8, paramStFirstPage, paramStApiRightController, paramStMDebugInfo, null, null, null, "", 0, null, 0, false, false, "", null, 0, null, null, null, null, null, null, 0);
  }
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, long paramLong, List<INTERFACE.StSubPkgInfo> paramList, String paramString8, INTERFACE.StFirstPage paramStFirstPage, INTERFACE.StApiRightController paramStApiRightController, INTERFACE.StMDebugInfo paramStMDebugInfo, INTERFACE.StDomainConfig paramStDomainConfig, INTERFACE.StMainPageExtInfo paramStMainPageExtInfo, INTERFACE.StDeveloperInfo paramStDeveloperInfo, String paramString9, int paramInt4, INTERFACE.StAppMode paramStAppMode, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, String paramString10, String paramString11, int paramInt6, COMM.StCommonExt paramStCommonExt, List<INTERFACE.StExtConfigInfo> paramList1, INTERFACE.StAppBasicInfo paramStAppBasicInfo, INTERFACE.StOperationInfo paramStOperationInfo, INTERFACE.StIdeConfig paramStIdeConfig, String paramString12, int paramInt7)
  {
    this.appId = paramString1;
    this.name = paramString2;
    this.iconUrl = paramString3;
    this.downloadUrl = paramString4;
    this.reportType = paramInt1;
    this.topType = paramInt2;
    this.verType = paramInt3;
    this.version = paramString5;
    this.versionId = paramString6;
    this.baselibMiniVersion = paramString7;
    this.desc = paramString8;
    this.timestamp = paramLong;
    if (paramList != null)
    {
      this.subpkgs = new ArrayList();
      paramString2 = paramList.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (INTERFACE.StSubPkgInfo)paramString2.next();
        if (paramString3 != null)
        {
          paramString4 = new SubPkgInfo();
          paramString4.subPkgName = paramString3.subPkgName.get();
          paramString4.downloadUrl = paramString3.dowLoadUrl.get();
          paramString4.independent = paramString3.independent.get();
          paramString4.fileSize = paramString3.file_size.get();
          this.subpkgs.add(paramString4);
        }
      }
    }
    if (paramStFirstPage != null)
    {
      this.firstPage = new FirstPageInfo();
      this.firstPage.pagePath = paramStFirstPage.pagePath.get();
      this.firstPage.subPkgName = paramStFirstPage.subPkgName.get();
    }
    if (paramStApiRightController != null)
    {
      if (paramStApiRightController.whiteLst.get() != null)
      {
        this.whiteList = new ArrayList();
        this.whiteList.addAll(paramStApiRightController.whiteLst.get());
      }
      if (paramStApiRightController.blackLst.get() != null)
      {
        this.blackList = new ArrayList();
        this.blackList.addAll(paramStApiRightController.blackLst.get());
      }
      if (paramStApiRightController.secondApiRights.get() != null)
      {
        this.secondApiRightInfoList = new ArrayList();
        paramString2 = paramStApiRightController.secondApiRights.get().iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (INTERFACE.StApiRightItem)paramString2.next();
          if (paramString3 != null)
          {
            paramString4 = new SecondApiRightInfo();
            paramString4.apiName = paramString3.apiName.get();
            paramString4.secondName = paramString3.secondName.get();
            paramString4.right = paramString3.right.get();
            this.secondApiRightInfoList.add(paramString4);
          }
        }
      }
    }
    if ((paramStMDebugInfo != null) && (!TextUtils.isEmpty(paramStMDebugInfo.roomId.get())) && (!TextUtils.isEmpty(paramStMDebugInfo.wsUrl.get())))
    {
      this.debugInfo = new DebugInfo();
      this.debugInfo.roomId = paramStMDebugInfo.roomId.get();
      this.debugInfo.wsUrl = paramStMDebugInfo.wsUrl.get();
    }
    if (paramStDomainConfig != null)
    {
      if (paramStDomainConfig.requestDomain.get() != null)
      {
        this.requestDomainList = new ArrayList();
        this.requestDomainList.addAll(paramStDomainConfig.requestDomain.get());
      }
      if (paramStDomainConfig.socketDomain.get() != null)
      {
        this.socketDomainList = new ArrayList();
        this.socketDomainList.addAll(paramStDomainConfig.socketDomain.get());
      }
      if (paramStDomainConfig.uploadFileDomain.get() != null)
      {
        this.uploadFileDomainList = new ArrayList();
        this.uploadFileDomainList.addAll(paramStDomainConfig.uploadFileDomain.get());
      }
      if (paramStDomainConfig.downloadFileDomain.get() != null)
      {
        this.downloadFileDomainList = new ArrayList();
        this.downloadFileDomainList.addAll(paramStDomainConfig.downloadFileDomain.get());
      }
      if (paramStDomainConfig.businessDomain.get() != null)
      {
        this.businessDomainList = new ArrayList();
        this.businessDomainList.addAll(paramStDomainConfig.businessDomain.get());
      }
      if (paramStDomainConfig.udpIpList.get() != null) {
        this.udpIpList.addAll(paramStDomainConfig.udpIpList.get());
      }
    }
    if (paramStMainPageExtInfo != null) {
      this.fileSize = paramStMainPageExtInfo.file_size.get();
    }
    if (paramStDeveloperInfo != null) {
      this.developerDesc = paramStDeveloperInfo.name.get();
    }
    this.extraData = paramString9;
    this.recommend = paramInt4;
    this.appMode = AppMode.from(paramStAppMode);
    this.skipDomainCheck = paramInt5;
    this.isSupportBlueBar = paramBoolean1;
    this.isSupportOffline = paramBoolean2;
    this.recommendAppIconUrl = paramString10;
    this.extendData = paramString11;
    this.clearAuths = paramInt6;
    this.prepayId = paramString12;
    this.commonExt = paramStCommonExt.toByteArray();
    if (paramList1 != null)
    {
      this.extConfigInfoList = new ArrayList();
      paramString2 = paramList1.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = ExtConfigInfo.from((INTERFACE.StExtConfigInfo)paramString2.next());
        this.extConfigInfoList.add(paramString3);
      }
    }
    if (paramStAppBasicInfo != null)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("appid:");
        paramString2.append(paramString1);
        paramString2.append(", usrFileSizeLimit:");
        paramString2.append(paramStAppBasicInfo.usrFileSizeLimit.get());
        QLog.i("[mini] MiniAppInfo", 1, paramString2.toString());
      }
      this.usrFileSizeLimit = paramStAppBasicInfo.usrFileSizeLimit.get();
      if (paramStAppBasicInfo.preCacheList != null)
      {
        paramString1 = paramStAppBasicInfo.preCacheList.get();
        if (paramString1.size() > 0)
        {
          this.preCacheList = new ArrayList();
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (INTERFACE.StAppPreCacheInfo)paramString1.next();
            this.preCacheList.add(new PreCacheInfo(paramString2.getDataUrl.get(), paramString2.preCacheKey.get(), paramString2.expireTime.get(), paramString2.cacheType.get(), paramString2.useProxy.get()));
          }
        }
      }
      if (paramStAppBasicInfo.resourcePreCacheList != null)
      {
        paramString1 = paramStAppBasicInfo.resourcePreCacheList.get();
        if (paramString1.size() > 0)
        {
          this.resourcePreCacheInfo = new ArrayList();
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (INTERFACE.StResourcePreCacheInfo)paramString1.next();
            this.resourcePreCacheInfo.add(new ResourcePreCacheInfo(paramString2.getDataUrl.get()));
          }
        }
      }
      this.versionUpdateTime = paramStAppBasicInfo.versionUpdateTime.get();
      paramBoolean2 = paramStAppBasicInfo.pkgType.has();
      paramBoolean1 = false;
      if (paramBoolean2)
      {
        if (paramStAppBasicInfo.pkgType.get() == 1) {
          this.engineType = 1;
        } else {
          this.engineType = 0;
        }
      }
      else {
        this.engineType = this.reportType;
      }
      this.noNeedRealRecommend = paramStAppBasicInfo.noNeedRealRecommend.get();
      this.miniGamePluginInfo = MiniGamePluginInfo.fromProtocol(paramStAppBasicInfo.pluginInfo);
      this.renderInfo = RenderInfo.from(paramStAppBasicInfo.renderInfo);
      if (paramStAppBasicInfo.qualificationInfo != null) {
        this.qualifications = new ArrayList(paramStAppBasicInfo.qualificationInfo.get());
      }
      if (paramStAppBasicInfo.gameCopyrightInfo != null) {
        this.gameCopyrightInfo = paramStAppBasicInfo.gameCopyrightInfo.get();
      }
      if (paramStAppBasicInfo.gamePublicationInfo != null)
      {
        if (paramStAppBasicInfo.gamePublicationInfo.gamePublicationNumber != null) {
          this.gamePublicationNumber = paramStAppBasicInfo.gamePublicationInfo.gamePublicationNumber.get();
        }
        if (paramStAppBasicInfo.gamePublicationInfo.gamePublicationCommpany != null) {
          this.gamePublicationCompany = paramStAppBasicInfo.gamePublicationInfo.gamePublicationCommpany.get();
        }
        if (paramStAppBasicInfo.gamePublicationInfo.gameApprovalNumber != null) {
          this.gameApprovalNumber = paramStAppBasicInfo.gamePublicationInfo.gameApprovalNumber.get();
        }
        if (paramStAppBasicInfo.gamePublicationInfo.gameOperatingCompany != null) {
          this.gameOperatingCompany = paramStAppBasicInfo.gamePublicationInfo.gameOperatingCompany.get();
        }
      }
      this.shareId = paramStAppBasicInfo.shareId.get();
      this.via = paramStAppBasicInfo.via.get();
      if (paramStAppBasicInfo.splashScreenAd.get() == 1) {
        paramBoolean1 = true;
      }
      this.enableLoadingAd = paramBoolean1;
    }
    if (paramStOperationInfo != null)
    {
      this.amsAdInfo = paramStOperationInfo.amsAdInfo.get();
      this.tianshuAdId = paramStOperationInfo.tianshuAdId.get();
      this.reportData = paramStOperationInfo.reportData.get();
    }
    if (paramStIdeConfig != null)
    {
      this.ide_scene = paramStIdeConfig.scene.get();
      this.ide_extraAppid = paramStIdeConfig.extraAppid.get();
      this.ide_extraData = paramStIdeConfig.extraData.get();
      if (paramStIdeConfig.startExtInfo != null)
      {
        this.deviceOrientation = paramStIdeConfig.startExtInfo.deviceOrientation.get();
        this.showStatusBar = paramStIdeConfig.startExtInfo.showStatusBar.get();
      }
    }
    this.miniAppType = paramInt7;
  }
  
  public static MiniAppInfo copy(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.topType = paramMiniAppInfo.topType;
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    localMiniAppInfo.subpkgs = paramMiniAppInfo.subpkgs;
    Object localObject1 = new FirstPageInfo();
    ((FirstPageInfo)localObject1).setPagePath("");
    ((FirstPageInfo)localObject1).setSubPkgName("");
    localMiniAppInfo.firstPage = ((FirstPageInfo)localObject1);
    localMiniAppInfo.reportType = paramMiniAppInfo.reportType;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    localMiniAppInfo.whiteList = paramMiniAppInfo.whiteList;
    localMiniAppInfo.blackList = paramMiniAppInfo.blackList;
    localMiniAppInfo.secondApiRightInfoList = paramMiniAppInfo.secondApiRightInfoList;
    localMiniAppInfo.debugInfo = paramMiniAppInfo.debugInfo;
    localMiniAppInfo.requestDomainList = paramMiniAppInfo.requestDomainList;
    localMiniAppInfo.socketDomainList = paramMiniAppInfo.socketDomainList;
    localMiniAppInfo.uploadFileDomainList = paramMiniAppInfo.uploadFileDomainList;
    localMiniAppInfo.downloadFileDomainList = paramMiniAppInfo.downloadFileDomainList;
    localMiniAppInfo.businessDomainList = paramMiniAppInfo.businessDomainList;
    localMiniAppInfo.udpIpList.clear();
    localMiniAppInfo.udpIpList.addAll(paramMiniAppInfo.udpIpList);
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.extraData = paramMiniAppInfo.extraData;
    localMiniAppInfo.recommend = paramMiniAppInfo.recommend;
    localMiniAppInfo.isSupportOffline = paramMiniAppInfo.isSupportOffline;
    localMiniAppInfo.reportData = paramMiniAppInfo.reportData;
    localMiniAppInfo.appMode = paramMiniAppInfo.appMode;
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.position = paramMiniAppInfo.position;
    localMiniAppInfo.isSupportBlueBar = paramMiniAppInfo.isSupportBlueBar;
    localMiniAppInfo.recommendAppIconUrl = paramMiniAppInfo.recommendAppIconUrl;
    localMiniAppInfo.extendData = null;
    localMiniAppInfo.commonExt = paramMiniAppInfo.commonExt;
    localMiniAppInfo.extConfigInfoList = paramMiniAppInfo.extConfigInfoList;
    localMiniAppInfo.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    localMiniAppInfo.motionPics = paramMiniAppInfo.motionPics;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    Object localObject2;
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject1 = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PreCacheInfo)((Iterator)localObject1).next();
        localMiniAppInfo.preCacheList.add(new PreCacheInfo(((PreCacheInfo)localObject2).getDataUrl, ((PreCacheInfo)localObject2).preCacheKey, ((PreCacheInfo)localObject2).expireTime, ((PreCacheInfo)localObject2).cacheType, ((PreCacheInfo)localObject2).useProxy));
      }
    }
    if (paramMiniAppInfo.resourcePreCacheInfo != null)
    {
      localMiniAppInfo.resourcePreCacheInfo = new ArrayList();
      localObject1 = paramMiniAppInfo.resourcePreCacheInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResourcePreCacheInfo)((Iterator)localObject1).next();
        localMiniAppInfo.resourcePreCacheInfo.add(new ResourcePreCacheInfo(((ResourcePreCacheInfo)localObject2).getDataUrl));
      }
    }
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.miniGamePluginInfo = paramMiniAppInfo.miniGamePluginInfo;
    localMiniAppInfo.qualifications = paramMiniAppInfo.qualifications;
    localMiniAppInfo.gameCopyrightInfo = paramMiniAppInfo.gameCopyrightInfo;
    localMiniAppInfo.gamePublicationNumber = paramMiniAppInfo.gamePublicationNumber;
    localMiniAppInfo.gamePublicationCompany = paramMiniAppInfo.gamePublicationCompany;
    localMiniAppInfo.gameApprovalNumber = paramMiniAppInfo.gameApprovalNumber;
    localMiniAppInfo.gameOperatingCompany = paramMiniAppInfo.gameOperatingCompany;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    localMiniAppInfo.amsAdInfo = paramMiniAppInfo.amsAdInfo;
    localMiniAppInfo.apngUrl = paramMiniAppInfo.apngUrl;
    localMiniAppInfo.ide_scene = paramMiniAppInfo.ide_scene;
    localMiniAppInfo.ide_extraAppid = paramMiniAppInfo.ide_extraAppid;
    localMiniAppInfo.ide_extraData = paramMiniAppInfo.ide_extraData;
    localMiniAppInfo.tianshuAdId = paramMiniAppInfo.tianshuAdId;
    localMiniAppInfo.enableLoadingAd = paramMiniAppInfo.enableLoadingAd;
    localMiniAppInfo.userNum = paramMiniAppInfo.userNum;
    localMiniAppInfo.friendNum = paramMiniAppInfo.friendNum;
    localMiniAppInfo.users = paramMiniAppInfo.users;
    localMiniAppInfo.miniAppType = paramMiniAppInfo.miniAppType;
    return localMiniAppInfo;
  }
  
  public static MiniAppInfo createMiniAppInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("appInfo");
    if (paramJSONObject == null)
    {
      QLog.e("[mini] MiniAppInfo", 1, "createMiniAppInfo, appInfo is null");
      return null;
    }
    try
    {
      paramJSONObject = from((INTERFACE.StApiAppInfo)INTERFACE.StApiAppInfo.class.cast(GdtJsonPbUtil.a(new INTERFACE.StApiAppInfo(), paramJSONObject)));
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("[mini] MiniAppInfo", 1, "createMiniAppInfo, appInfo exception:", paramJSONObject);
    }
    return null;
  }
  
  private static boolean domainEquals(List<String> paramList1, List<String> paramList2)
  {
    if (paramList1 == paramList2) {
      return true;
    }
    if (paramList1 != null) {
      return paramList1.equals(paramList2);
    }
    return false;
  }
  
  public static MiniAppInfo from(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if (paramStApiAppInfo == null) {
      return new MiniAppInfo();
    }
    String str1 = paramStApiAppInfo.appId.get();
    String str2 = paramStApiAppInfo.appName.get();
    String str3 = paramStApiAppInfo.icon.get();
    String str4 = paramStApiAppInfo.donwLoadUrl.get();
    int i = paramStApiAppInfo.appType.get();
    int j = paramStApiAppInfo.type.get();
    String str5 = paramStApiAppInfo.version.get();
    String str6 = paramStApiAppInfo.versionId.get();
    String str7 = paramStApiAppInfo.baselibMiniVersion.get();
    List localList = paramStApiAppInfo.subPkgs.get();
    String str8 = paramStApiAppInfo.desc.get();
    INTERFACE.StFirstPage localStFirstPage = (INTERFACE.StFirstPage)paramStApiAppInfo.first.get();
    INTERFACE.StApiRightController localStApiRightController = (INTERFACE.StApiRightController)paramStApiAppInfo.apiRight.get();
    INTERFACE.StMDebugInfo localStMDebugInfo = paramStApiAppInfo.mDebug;
    INTERFACE.StDomainConfig localStDomainConfig = (INTERFACE.StDomainConfig)paramStApiAppInfo.domain.get();
    INTERFACE.StMainPageExtInfo localStMainPageExtInfo = paramStApiAppInfo.mainExt;
    INTERFACE.StDeveloperInfo localStDeveloperInfo = paramStApiAppInfo.devInfo;
    int k = paramStApiAppInfo.isRecommend.get();
    INTERFACE.StAppMode localStAppMode = (INTERFACE.StAppMode)paramStApiAppInfo.appMode.get();
    int m = paramStApiAppInfo.skipDomainCheck.get();
    boolean bool2 = getSupportBlueBar(paramStApiAppInfo);
    boolean bool1;
    if (paramStApiAppInfo.supportOffline.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    return new MiniAppInfo(str1, str2, str3, str4, i, 0, j, str5, str6, str7, 0L, localList, str8, localStFirstPage, localStApiRightController, localStMDebugInfo, localStDomainConfig, localStMainPageExtInfo, localStDeveloperInfo, null, k, localStAppMode, m, bool2, bool1, getRecommendIconUrl(paramStApiAppInfo), paramStApiAppInfo.extendData.get(), paramStApiAppInfo.appNoCacheExt.clearAuths.get(), paramStApiAppInfo.extInfo, paramStApiAppInfo.extConfig.get(), (INTERFACE.StAppBasicInfo)paramStApiAppInfo.basicInfo.get(), (INTERFACE.StOperationInfo)paramStApiAppInfo.operInfo.get(), (INTERFACE.StIdeConfig)paramStApiAppInfo.basicInfo.ideConfig.get(), paramStApiAppInfo.appNoCacheExt.prepayId.get(), paramStApiAppInfo.miniAppType.get());
  }
  
  @NonNull
  public static MiniAppInfo from(INTERFACE.StUserAppInfo paramStUserAppInfo)
  {
    if (paramStUserAppInfo == null) {
      return new MiniAppInfo();
    }
    MiniAppInfo localMiniAppInfo = from((INTERFACE.StApiAppInfo)paramStUserAppInfo.appInfo.get());
    localMiniAppInfo.topType = paramStUserAppInfo.putTop.get();
    localMiniAppInfo.timestamp = paramStUserAppInfo.useTime.get();
    localMiniAppInfo.openId = paramStUserAppInfo.openid.get();
    localMiniAppInfo.tinyId = paramStUserAppInfo.tinyid.get();
    localMiniAppInfo.appStoreAnimPicUrl = paramStUserAppInfo.bgPic.get();
    localMiniAppInfo.motionPics = getMotionPics(paramStUserAppInfo.motionPics.get());
    localMiniAppInfo.apngUrl = paramStUserAppInfo.apngUrl.get();
    localMiniAppInfo.userNum = paramStUserAppInfo.userNum.get();
    localMiniAppInfo.friendNum = paramStUserAppInfo.friendNum.get();
    if (localMiniAppInfo.friendNum > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramStUserAppInfo = paramStUserAppInfo.users.get().iterator();
      while (paramStUserAppInfo.hasNext())
      {
        INTERFACE.UseUserInfo localUseUserInfo = (INTERFACE.UseUserInfo)paramStUserAppInfo.next();
        if (localUseUserInfo != null)
        {
          UseUserInfo localUseUserInfo1 = new UseUserInfo();
          localUseUserInfo1.uin = localUseUserInfo.uin.get();
          localUseUserInfo1.avatar = localUseUserInfo.avatar.get();
          localUseUserInfo1.nick = localUseUserInfo.nick.get();
          localArrayList.add(localUseUserInfo1);
        }
      }
      localMiniAppInfo.users = localArrayList;
    }
    return localMiniAppInfo;
  }
  
  public static MiniAppInfo getMiniAppInfoByIdFromDB(MiniAppByIdEntity paramMiniAppByIdEntity, MiniAppInfoEntity paramMiniAppInfoEntity)
  {
    try
    {
      INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
      localStApiAppInfo.mergeFrom(paramMiniAppInfoEntity.appInfo);
      localStApiAppInfo.first.mergeFrom(paramMiniAppByIdEntity.first);
      localStApiAppInfo.mDebug.mergeFrom(paramMiniAppByIdEntity.mDebug);
      localStApiAppInfo.extData.set(paramMiniAppByIdEntity.extData);
      localStApiAppInfo.operInfo.mergeFrom(paramMiniAppByIdEntity.operInfo);
      localStApiAppInfo.extInfo.mergeFrom(paramMiniAppByIdEntity.extInfo);
      localStApiAppInfo.extendData.set(paramMiniAppByIdEntity.extendData);
      paramMiniAppByIdEntity = new INTERFACE.StAppFixInfoExt();
      localStApiAppInfo.appNoCacheExt.mergeFrom(paramMiniAppByIdEntity.toByteArray());
      paramMiniAppByIdEntity = from(localStApiAppInfo);
      return paramMiniAppByIdEntity;
    }
    catch (Throwable paramMiniAppByIdEntity)
    {
      QLog.e("miniapp-db", 1, "getMiniAppInfoByIdFromDB error,", paramMiniAppByIdEntity);
    }
    return null;
  }
  
  public static MiniAppInfo getMiniAppInfoByIdFromDB(MiniAppInfoByIdEntity paramMiniAppInfoByIdEntity)
  {
    try
    {
      INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
      localStApiAppInfo.mergeFrom(paramMiniAppInfoByIdEntity.appInfo);
      paramMiniAppInfoByIdEntity = from(localStApiAppInfo);
      return paramMiniAppInfoByIdEntity;
    }
    catch (Throwable paramMiniAppInfoByIdEntity)
    {
      QLog.e("miniapp-db", 1, "getMiniAppInfoByIdFromDB 2 error,", paramMiniAppInfoByIdEntity);
    }
    return null;
  }
  
  @Deprecated
  public static MiniAppInfo getMiniAppInfoByLinkFromDB(MiniAppByLinkEntity paramMiniAppByLinkEntity, MiniAppInfoEntity paramMiniAppInfoEntity)
  {
    try
    {
      INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
      localStApiAppInfo.mergeFrom(paramMiniAppInfoEntity.appInfo);
      localStApiAppInfo.first.mergeFrom(paramMiniAppByLinkEntity.first);
      localStApiAppInfo.mDebug.mergeFrom(paramMiniAppByLinkEntity.mDebug);
      localStApiAppInfo.extData.set(paramMiniAppByLinkEntity.extData);
      localStApiAppInfo.operInfo.mergeFrom(paramMiniAppByLinkEntity.operInfo);
      localStApiAppInfo.extInfo.mergeFrom(paramMiniAppByLinkEntity.extInfo);
      localStApiAppInfo.extendData.set(paramMiniAppByLinkEntity.extendData);
      paramMiniAppInfoEntity = new INTERFACE.StAppFixInfoExt();
      paramMiniAppInfoEntity.prepayId.set(paramMiniAppByLinkEntity.prepayId);
      localStApiAppInfo.appNoCacheExt.mergeFrom(paramMiniAppInfoEntity.toByteArray());
      paramMiniAppByLinkEntity = from(localStApiAppInfo);
      return paramMiniAppByLinkEntity;
    }
    catch (Throwable paramMiniAppByLinkEntity)
    {
      QLog.e("miniapp-db", 1, "getMiniAppInfoByLinkFromDB error,", paramMiniAppByLinkEntity);
    }
    return null;
  }
  
  public static MiniAppInfo getMiniAppInfoByLinkFromDB(MiniAppInfoByLinkEntity paramMiniAppInfoByLinkEntity)
  {
    try
    {
      INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
      localStApiAppInfo.mergeFrom(paramMiniAppInfoByLinkEntity.appInfo);
      paramMiniAppInfoByLinkEntity = from(localStApiAppInfo);
      return paramMiniAppInfoByLinkEntity;
    }
    catch (Throwable paramMiniAppInfoByLinkEntity)
    {
      QLog.e("miniapp-db", 1, "getMiniAppInfoByLinkFromDB 2 error,", paramMiniAppInfoByLinkEntity);
    }
    return null;
  }
  
  private static ArrayList<String> getMotionPics(List<INTERFACE.StMotionPicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        INTERFACE.StMotionPicInfo localStMotionPicInfo = (INTERFACE.StMotionPicInfo)paramList.next();
        if ((localStMotionPicInfo != null) && (localStMotionPicInfo.get() != null)) {
          localArrayList.add(localStMotionPicInfo.pic.get());
        }
      }
    }
    return localArrayList;
  }
  
  private static String getRecommendIconUrl(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if (paramStApiAppInfo.extInfo != null)
    {
      if (paramStApiAppInfo.extInfo.mapInfo == null) {
        return "";
      }
      int i = 0;
      while (i < paramStApiAppInfo.extInfo.mapInfo.size())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStApiAppInfo.extInfo.mapInfo.get(i);
        if ("recommIcon".equals(localEntry.key.get())) {
          return localEntry.value.get();
        }
        i += 1;
      }
    }
    return "";
  }
  
  private static Map<String, String> getReportDataFromAppInfo(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    Object localObject3 = paramStApiAppInfo.operInfo;
    String[] arrayOfString = null;
    Object localObject2 = null;
    Object localObject1 = arrayOfString;
    label218:
    INTERFACE.StApiAppInfo localStApiAppInfo;
    if (localObject3 != null)
    {
      localObject1 = arrayOfString;
      if (paramStApiAppInfo.operInfo.reportData != null)
      {
        paramStApiAppInfo = paramStApiAppInfo.operInfo.reportData.get();
        localObject1 = arrayOfString;
        if (!TextUtils.isEmpty(paramStApiAppInfo)) {
          try
          {
            arrayOfString = paramStApiAppInfo.split("&");
            int j = arrayOfString.length;
            paramStApiAppInfo = null;
            int i = 0;
            for (;;)
            {
              if (i < j)
              {
                String str = arrayOfString[i];
                localObject2 = paramStApiAppInfo;
                try
                {
                  int k = str.indexOf("=");
                  localObject1 = paramStApiAppInfo;
                  if (k > 0)
                  {
                    localObject1 = paramStApiAppInfo;
                    localObject2 = paramStApiAppInfo;
                    if (k < str.length() - 1)
                    {
                      localObject2 = paramStApiAppInfo;
                      localObject3 = URLDecoder.decode(str.substring(0, k), "UTF-8");
                      localObject2 = paramStApiAppInfo;
                      str = URLDecoder.decode(str.substring(k + 1), "UTF-8");
                      localObject1 = paramStApiAppInfo;
                      if (paramStApiAppInfo == null)
                      {
                        localObject2 = paramStApiAppInfo;
                        localObject1 = new HashMap();
                      }
                      localObject2 = localObject1;
                      ((Map)localObject1).put(localObject3, str);
                    }
                  }
                  i += 1;
                  paramStApiAppInfo = (INTERFACE.StApiAppInfo)localObject1;
                }
                catch (Exception localException1)
                {
                  paramStApiAppInfo = (INTERFACE.StApiAppInfo)localObject2;
                  break label218;
                }
              }
            }
            return paramStApiAppInfo;
          }
          catch (Exception localException2)
          {
            paramStApiAppInfo = (INTERFACE.StApiAppInfo)localObject2;
            QLog.e("[mini] MiniAppInfo", 1, " parse reportData error.", localException2);
            localStApiAppInfo = paramStApiAppInfo;
          }
        }
      }
    }
    return localStApiAppInfo;
  }
  
  public static String getReportDataString(Map<String, String> paramMap)
  {
    Object localObject3 = "";
    localObject2 = localObject3;
    if (paramMap != null)
    {
      localObject2 = localObject3;
      if (paramMap.size() > 0)
      {
        Object localObject1 = localObject3;
        try
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          paramMap = (Map<String, String>)localObject3;
          for (;;)
          {
            localObject1 = paramMap;
            localObject2 = paramMap;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = paramMap;
            localObject2 = (Map.Entry)localIterator.next();
            localObject1 = paramMap;
            boolean bool = TextUtils.isEmpty(paramMap);
            if (bool)
            {
              localObject1 = paramMap;
              localObject3 = new StringBuilder();
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append(paramMap);
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append(URLEncoder.encode((String)((Map.Entry)localObject2).getKey()));
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append("=");
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append(URLEncoder.encode((String)((Map.Entry)localObject2).getValue(), "UTF-8"));
              localObject1 = paramMap;
              paramMap = ((StringBuilder)localObject3).toString();
            }
            else
            {
              localObject1 = paramMap;
              localObject3 = new StringBuilder();
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append(paramMap);
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append("&");
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append(URLEncoder.encode((String)((Map.Entry)localObject2).getKey()));
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append("=");
              localObject1 = paramMap;
              ((StringBuilder)localObject3).append(URLEncoder.encode((String)((Map.Entry)localObject2).getValue(), "UTF-8"));
              localObject1 = paramMap;
              paramMap = ((StringBuilder)localObject3).toString();
            }
          }
          return localObject2;
        }
        catch (Exception paramMap)
        {
          QLog.e("[mini] MiniAppInfo", 1, " getReportDataString error.", paramMap);
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private static boolean getSupportBlueBar(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if (paramStApiAppInfo.extInfo != null)
    {
      if (paramStApiAppInfo.extInfo.mapInfo == null) {
        return false;
      }
      int i = 0;
      while (i < paramStApiAppInfo.extInfo.mapInfo.size())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStApiAppInfo.extInfo.mapInfo.get(i);
        if ("support_blue_bar".equals(localEntry.key.get())) {
          return "1".equals(localEntry.value.get());
        }
        i += 1;
      }
    }
    return false;
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
  
  private static String list2String(List<ExtConfigInfo> paramList)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramList == null) {
        return "";
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ExtConfigInfo localExtConfigInfo = (ExtConfigInfo)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localExtConfigInfo.toString());
        localStringBuilder.append(",");
        localStringBuffer.append(localStringBuilder.toString());
      }
      paramList = localStringBuffer.toString();
      return paramList;
    }
    catch (Throwable paramList) {}
    return "";
  }
  
  public static String list2string(List<String> paramList)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramList == null) {
        return "";
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str.toString());
        localStringBuilder.append(",");
        localStringBuffer.append(localStringBuilder.toString());
      }
      paramList = localStringBuffer.toString();
      return paramList;
    }
    catch (Throwable paramList) {}
    return "";
  }
  
  public static String list2stringO(List<SubPkgInfo> paramList)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramList == null) {
        return "";
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localSubPkgInfo.toString());
        localStringBuilder.append(",");
        localStringBuffer.append(localStringBuilder.toString());
      }
      paramList = localStringBuffer.toString();
      return paramList;
    }
    catch (Throwable paramList) {}
    return "";
  }
  
  public static String list2stringSecond(List<SecondApiRightInfo> paramList)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramList == null) {
        return "";
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SecondApiRightInfo localSecondApiRightInfo = (SecondApiRightInfo)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localSecondApiRightInfo.toString());
        localStringBuilder.append(",");
        localStringBuffer.append(localStringBuilder.toString());
      }
      paramList = localStringBuffer.toString();
      return paramList;
    }
    catch (Throwable paramList) {}
    return "";
  }
  
  private static ArrayList<String> parseArrayList(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      paramString = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        String str = paramJSONObject.optString(i);
        if (!TextUtils.isEmpty(str)) {
          paramString.add(str);
        }
        i += 1;
      }
      return paramString;
    }
    return new ArrayList();
  }
  
  public static void saveMiniAppByAppInfoLinkEntity(String paramString1, int paramInt, String paramString2, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    MiniAppInfoByLinkEntity localMiniAppInfoByLinkEntity = new MiniAppInfoByLinkEntity();
    localMiniAppInfoByLinkEntity.link = paramString1;
    localMiniAppInfoByLinkEntity.linkType = paramInt;
    localMiniAppInfoByLinkEntity.shareTicket = paramString2;
    localMiniAppInfoByLinkEntity.appInfo = ((INTERFACE.StApiAppInfo)paramStApiAppInfo.get()).toByteArray();
    localMiniAppInfoByLinkEntity.timeStamp = System.currentTimeMillis();
    paramString1 = MiniAppEntityManager.get();
    if (paramString1 != null)
    {
      paramString1.insertOrReplaceEntity(localMiniAppInfoByLinkEntity);
      paramString1 = new StringBuilder();
      paramString1.append("saveMiniAppByAppInfoLinkEntity ok.");
      paramString1.append(localMiniAppInfoByLinkEntity.link);
      paramString1.append(" linkType:");
      paramString1.append(paramInt);
      QLog.d("miniapp-db", 1, paramString1.toString());
    }
  }
  
  public static void saveMiniAppByIdEntity(String paramString, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new MiniAppByIdEntity();
    paramString.appId = paramStApiAppInfo.appId.get();
    paramString.entryPath = str;
    paramString.shareTicket = null;
    paramString.first = ((INTERFACE.StFirstPage)paramStApiAppInfo.first.get()).toByteArray();
    paramString.mDebug = ((INTERFACE.StMDebugInfo)paramStApiAppInfo.mDebug.get()).toByteArray();
    paramString.extData = paramStApiAppInfo.extData.get();
    paramString.operInfo = ((INTERFACE.StOperationInfo)paramStApiAppInfo.operInfo.get()).toByteArray();
    paramString.extInfo = ((COMM.StCommonExt)paramStApiAppInfo.extInfo.get()).toByteArray();
    paramString.extendData = paramStApiAppInfo.extendData.get();
    paramString.timeStamp = System.currentTimeMillis();
    paramStApiAppInfo = MiniAppEntityManager.get();
    if (paramStApiAppInfo != null)
    {
      paramStApiAppInfo.insertOrReplaceEntity(paramString);
      paramStApiAppInfo = new StringBuilder();
      paramStApiAppInfo.append("saveMiniAppByIdEntity ok.");
      paramStApiAppInfo.append(paramString.appId);
      QLog.d("miniapp-db", 1, paramStApiAppInfo.toString());
    }
  }
  
  public static void saveMiniAppByLinkEntity(String paramString1, int paramInt, String paramString2, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    MiniAppByLinkEntity localMiniAppByLinkEntity = new MiniAppByLinkEntity();
    localMiniAppByLinkEntity.appId = paramStApiAppInfo.appId.get();
    localMiniAppByLinkEntity.link = paramString1;
    localMiniAppByLinkEntity.linkType = paramInt;
    localMiniAppByLinkEntity.shareTicket = paramString2;
    localMiniAppByLinkEntity.first = ((INTERFACE.StFirstPage)paramStApiAppInfo.first.get()).toByteArray();
    localMiniAppByLinkEntity.mDebug = ((INTERFACE.StMDebugInfo)paramStApiAppInfo.mDebug.get()).toByteArray();
    localMiniAppByLinkEntity.extData = paramStApiAppInfo.extData.get();
    localMiniAppByLinkEntity.operInfo = ((INTERFACE.StOperationInfo)paramStApiAppInfo.operInfo.get()).toByteArray();
    localMiniAppByLinkEntity.extInfo = ((COMM.StCommonExt)paramStApiAppInfo.extInfo.get()).toByteArray();
    localMiniAppByLinkEntity.extendData = paramStApiAppInfo.extendData.get();
    localMiniAppByLinkEntity.timeStamp = System.currentTimeMillis();
    localMiniAppByLinkEntity.prepayId = paramStApiAppInfo.appNoCacheExt.prepayId.get();
    paramString1 = MiniAppEntityManager.get();
    if (paramString1 != null)
    {
      paramString1.insertOrReplaceEntity(localMiniAppByLinkEntity);
      paramString1 = new StringBuilder();
      paramString1.append("saveMiniAppByLinkEntity ok.");
      paramString1.append(localMiniAppByLinkEntity.appId);
      QLog.d("miniapp-db", 1, paramString1.toString());
    }
  }
  
  public static void saveMiniAppInfoByIdEntity(String paramString, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new MiniAppInfoByIdEntity();
    paramString.appId = paramStApiAppInfo.appId.get();
    paramString.entryPath = str;
    paramString.appInfo = ((INTERFACE.StApiAppInfo)paramStApiAppInfo.get()).toByteArray();
    paramString.timeStamp = System.currentTimeMillis();
    paramStApiAppInfo = MiniAppEntityManager.get();
    if (paramStApiAppInfo != null)
    {
      paramStApiAppInfo.insertOrReplaceEntity(paramString);
      paramStApiAppInfo = new StringBuilder();
      paramStApiAppInfo.append("saveMiniAppInfoByIdEntity ok.");
      paramStApiAppInfo.append(paramString.appId);
      paramStApiAppInfo.append(" entryPath:");
      paramStApiAppInfo.append(str);
      QLog.d("miniapp-db", 1, paramStApiAppInfo.toString());
    }
  }
  
  public static void saveMiniAppInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    MiniAppInfoEntity localMiniAppInfoEntity = new MiniAppInfoEntity();
    localMiniAppInfoEntity.appId = paramStApiAppInfo.appId.get();
    localMiniAppInfoEntity.appInfo = ((INTERFACE.StApiAppInfo)paramStApiAppInfo.get()).toByteArray();
    localMiniAppInfoEntity.timeStamp = System.currentTimeMillis();
    paramStApiAppInfo = MiniAppEntityManager.get();
    if (paramStApiAppInfo != null)
    {
      paramStApiAppInfo.insertOrReplaceEntity(localMiniAppInfoEntity);
      paramStApiAppInfo = new StringBuilder();
      paramStApiAppInfo.append("saveMiniAppInfoEntity ok.");
      paramStApiAppInfo.append(localMiniAppInfoEntity.appId);
      QLog.d("miniapp-db", 1, paramStApiAppInfo.toString());
    }
  }
  
  public static void saveMiniAppShowInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if ((paramStApiAppInfo != null) && (paramStApiAppInfo.appMode != null) && ((paramStApiAppInfo.appMode.isAppStore.get()) || (paramStApiAppInfo.appMode.interMode.get()))) {
      return;
    }
    if (paramStApiAppInfo == null) {
      return;
    }
    MiniAppShowInfoEntity localMiniAppShowInfoEntity = new MiniAppShowInfoEntity();
    localMiniAppShowInfoEntity.appId = paramStApiAppInfo.appId.get();
    localMiniAppShowInfoEntity.appName = paramStApiAppInfo.appName.get();
    localMiniAppShowInfoEntity.icon = paramStApiAppInfo.icon.get();
    localMiniAppShowInfoEntity.desc = paramStApiAppInfo.desc.get();
    if (paramStApiAppInfo.basicInfo != null) {
      localMiniAppShowInfoEntity.gameCopyrightInfo = paramStApiAppInfo.basicInfo.gameCopyrightInfo.get();
    }
    if ((paramStApiAppInfo.basicInfo != null) && (paramStApiAppInfo.basicInfo.gamePublicationInfo != null))
    {
      localMiniAppShowInfoEntity.gamePublicationNumber = paramStApiAppInfo.basicInfo.gamePublicationInfo.gamePublicationNumber.get();
      localMiniAppShowInfoEntity.gamePublicationCompany = paramStApiAppInfo.basicInfo.gamePublicationInfo.gamePublicationCommpany.get();
      localMiniAppShowInfoEntity.gameApprovalNumber = paramStApiAppInfo.basicInfo.gamePublicationInfo.gameApprovalNumber.get();
      localMiniAppShowInfoEntity.gameOperatingCompany = paramStApiAppInfo.basicInfo.gamePublicationInfo.gameOperatingCompany.get();
    }
    localMiniAppShowInfoEntity.reportType = paramStApiAppInfo.appType.get();
    if (paramStApiAppInfo.basicInfo.pkgType.has())
    {
      if (paramStApiAppInfo.basicInfo.pkgType.get() == 1) {
        localMiniAppShowInfoEntity.engineType = 1;
      } else {
        localMiniAppShowInfoEntity.engineType = 0;
      }
    }
    else {
      localMiniAppShowInfoEntity.engineType = localMiniAppShowInfoEntity.reportType;
    }
    if (paramStApiAppInfo.appMode != null) {
      localMiniAppShowInfoEntity.interMode = paramStApiAppInfo.appMode.interMode.get();
    }
    localMiniAppShowInfoEntity.timeStamp = System.currentTimeMillis();
    localMiniAppShowInfoEntity.miniAppType = paramStApiAppInfo.miniAppType.get();
    paramStApiAppInfo = MiniAppEntityManager.get();
    if (paramStApiAppInfo != null)
    {
      paramStApiAppInfo.insertOrReplaceEntity(localMiniAppShowInfoEntity);
      paramStApiAppInfo = new StringBuilder();
      paramStApiAppInfo.append("saveMiniAppShowInfoEntity ok.");
      paramStApiAppInfo.append(localMiniAppShowInfoEntity.appId);
      QLog.d("miniapp-db", 1, paramStApiAppInfo.toString());
    }
  }
  
  public static void saveMiniAppShowInfoEntity(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      localObject = paramMiniAppInfo.appMode;
      if ((localObject != null) && ((((AppMode)localObject).isAppStore) || (paramMiniAppInfo.appMode.interMode))) {
        return;
      }
    }
    if (paramMiniAppInfo == null) {
      return;
    }
    Object localObject = new MiniAppShowInfoEntity();
    ((MiniAppShowInfoEntity)localObject).appId = paramMiniAppInfo.appId;
    ((MiniAppShowInfoEntity)localObject).appName = paramMiniAppInfo.name;
    ((MiniAppShowInfoEntity)localObject).icon = paramMiniAppInfo.iconUrl;
    ((MiniAppShowInfoEntity)localObject).desc = paramMiniAppInfo.desc;
    ((MiniAppShowInfoEntity)localObject).gameCopyrightInfo = paramMiniAppInfo.gameCopyrightInfo;
    ((MiniAppShowInfoEntity)localObject).gamePublicationNumber = paramMiniAppInfo.gamePublicationNumber;
    ((MiniAppShowInfoEntity)localObject).gamePublicationCompany = paramMiniAppInfo.gamePublicationCompany;
    ((MiniAppShowInfoEntity)localObject).gameApprovalNumber = paramMiniAppInfo.gameApprovalNumber;
    ((MiniAppShowInfoEntity)localObject).gameOperatingCompany = paramMiniAppInfo.gameOperatingCompany;
    ((MiniAppShowInfoEntity)localObject).reportType = paramMiniAppInfo.reportType;
    ((MiniAppShowInfoEntity)localObject).engineType = paramMiniAppInfo.engineType;
    AppMode localAppMode = paramMiniAppInfo.appMode;
    boolean bool;
    if ((localAppMode != null) && (localAppMode.interMode)) {
      bool = true;
    } else {
      bool = false;
    }
    ((MiniAppShowInfoEntity)localObject).interMode = bool;
    ((MiniAppShowInfoEntity)localObject).timeStamp = System.currentTimeMillis();
    ((MiniAppShowInfoEntity)localObject).miniAppType = paramMiniAppInfo.miniAppType;
    paramMiniAppInfo = MiniAppEntityManager.get();
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo.insertOrReplaceEntity((Entity)localObject);
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("saveMiniAppShowInfoEntity ok.");
      paramMiniAppInfo.append(((MiniAppShowInfoEntity)localObject).appId);
      QLog.d("miniapp-db", 1, paramMiniAppInfo.toString());
    }
  }
  
  public boolean canUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    if (!TextUtils.equals(paramMiniAppInfo.appId, this.appId)) {
      return false;
    }
    if (paramMiniAppInfo.verType != this.verType) {
      return false;
    }
    if (paramMiniAppInfo.engineType != this.engineType) {
      return false;
    }
    return paramMiniAppInfo.reportType == this.reportType;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof MiniAppInfo))
    {
      paramObject = (MiniAppInfo)paramObject;
      if (!TextUtils.equals(paramObject.appId, this.appId)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.name, this.name)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.iconUrl, this.iconUrl)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.downloadUrl, this.downloadUrl)) {
        return false;
      }
      if (paramObject.verType != this.verType) {
        return false;
      }
      if (paramObject.engineType != this.engineType) {
        return false;
      }
      if (paramObject.reportType != this.reportType) {
        return false;
      }
      if (!TextUtils.equals(paramObject.version, this.version)) {
        return false;
      }
      if (!FirstPageInfo.equals(this.firstPage, paramObject.firstPage)) {
        return false;
      }
      if (!DebugInfo.equals(this.debugInfo, paramObject.debugInfo)) {
        return false;
      }
      if (!domainEquals(this.requestDomainList, paramObject.requestDomainList)) {
        return false;
      }
      if (!domainEquals(this.socketDomainList, paramObject.socketDomainList)) {
        return false;
      }
      if (!domainEquals(this.downloadFileDomainList, paramObject.downloadFileDomainList)) {
        return false;
      }
      if (!domainEquals(this.uploadFileDomainList, paramObject.uploadFileDomainList)) {
        return false;
      }
      if (!domainEquals(this.businessDomainList, paramObject.businessDomainList)) {
        return false;
      }
      if (!this.udpIpList.equals(paramObject.udpIpList)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.extraData, this.extraData)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.shareId, this.shareId)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.via, this.via)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.ide_scene, this.ide_scene)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.ide_extraAppid, this.ide_extraAppid)) {
        return false;
      }
      if (!TextUtils.equals(paramObject.ide_extraData, this.ide_extraData)) {
        return false;
      }
      if (paramObject.enableLoadingAd != this.enableLoadingAd) {
        return false;
      }
      return paramObject.miniAppType == this.miniAppType;
    }
    return false;
  }
  
  public int getEngineType()
  {
    return this.engineType;
  }
  
  public int getReportType()
  {
    return this.reportType;
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
  
  public boolean isAppStoreMiniApp()
  {
    AppMode localAppMode = this.appMode;
    if (localAppMode == null) {
      return false;
    }
    return localAppMode.isAppStore;
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
    AppMode localAppMode = this.appMode;
    return (localAppMode != null) && (localAppMode.interMode);
  }
  
  public boolean isLandScape()
  {
    int i = this.deviceOrientation;
    return (i == 2) || (i == 3) || (i == 4);
  }
  
  public boolean isLimitedAccessApp()
  {
    AppMode localAppMode = this.appMode;
    return (localAppMode != null) && (localAppMode.isLimitedAccess);
  }
  
  public boolean isQQMiniApp()
  {
    return this.miniAppType == 0;
  }
  
  public boolean isReportTypeMiniApp()
  {
    return this.reportType == 0;
  }
  
  public boolean isReportTypeMiniGame()
  {
    return this.reportType == 1;
  }
  
  public boolean isShowStatusBar()
  {
    return this.showStatusBar == 1;
  }
  
  public boolean isSpecialMiniApp()
  {
    return isAppStoreMiniApp();
  }
  
  public boolean isWxMiniApp()
  {
    return this.miniAppType == 1;
  }
  
  public MiniAppInfo mergeData(MiniAppInfo paramMiniAppInfo)
  {
    this.topType = paramMiniAppInfo.topType;
    this.timestamp = paramMiniAppInfo.timestamp;
    this.openId = paramMiniAppInfo.openId;
    this.tinyId = paramMiniAppInfo.tinyId;
    this.firstPage = paramMiniAppInfo.firstPage;
    this.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    this.motionPics = paramMiniAppInfo.motionPics;
    this.apngUrl = paramMiniAppInfo.apngUrl;
    this.gameCopyrightInfo = paramMiniAppInfo.gameCopyrightInfo;
    this.gamePublicationNumber = paramMiniAppInfo.gamePublicationNumber;
    this.gamePublicationCompany = paramMiniAppInfo.gamePublicationCompany;
    this.gameApprovalNumber = paramMiniAppInfo.gameApprovalNumber;
    this.gameOperatingCompany = paramMiniAppInfo.gameOperatingCompany;
    if (this.miniGamePluginInfo == null)
    {
      paramMiniAppInfo = paramMiniAppInfo.miniGamePluginInfo;
      if (paramMiniAppInfo != null) {
        this.miniGamePluginInfo = paramMiniAppInfo;
      }
    }
    return this;
  }
  
  public void setEngineType(int paramInt)
  {
    this.engineType = paramInt;
  }
  
  public void setReportType(int paramInt)
  {
    this.reportType = paramInt;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppInfo{appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadUrl='");
    localStringBuilder.append(this.downloadUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topType=");
    localStringBuilder.append(this.topType);
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", engineType='");
    localStringBuilder.append(this.engineType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportType='");
    localStringBuilder.append(this.reportType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", verType=");
    localStringBuilder.append(this.verType);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(", baselibMiniVersion='");
    localStringBuilder.append(this.baselibMiniVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filesize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(", extraData=");
    localStringBuilder.append(this.extraData);
    localStringBuilder.append(", developerDesc=");
    localStringBuilder.append(this.developerDesc);
    localStringBuilder.append(", firstPage=");
    localStringBuilder.append(this.firstPage);
    localStringBuilder.append(", whiteList=");
    localStringBuilder.append(list2string(this.whiteList));
    localStringBuilder.append(", blackList=");
    localStringBuilder.append(list2string(this.blackList));
    localStringBuilder.append(", secondApiRightInfoList=");
    localStringBuilder.append(list2stringSecond(this.secondApiRightInfoList));
    localStringBuilder.append(", requestDomainList=");
    localStringBuilder.append(list2string(this.requestDomainList));
    localStringBuilder.append(", socketDomainList=");
    localStringBuilder.append(list2string(this.socketDomainList));
    localStringBuilder.append(", uploadFileDomainList=");
    localStringBuilder.append(list2string(this.uploadFileDomainList));
    localStringBuilder.append(", downloadFileDomainList=");
    localStringBuilder.append(list2string(this.downloadFileDomainList));
    localStringBuilder.append(", businessDomainList=");
    localStringBuilder.append(list2string(this.businessDomainList));
    localStringBuilder.append(", udpIpList=");
    localStringBuilder.append(list2string(this.udpIpList));
    localStringBuilder.append(", subpkgs=");
    localStringBuilder.append(list2stringO(this.subpkgs));
    localStringBuilder.append(", isSupportOffline=");
    localStringBuilder.append(this.isSupportOffline);
    localStringBuilder.append(", skipDomainCheck=");
    localStringBuilder.append(this.skipDomainCheck);
    localStringBuilder.append(", openId=");
    localStringBuilder.append(this.openId);
    localStringBuilder.append(", tinyId=");
    localStringBuilder.append(this.tinyId);
    localStringBuilder.append(", isSupportBlueBar=");
    localStringBuilder.append(this.isSupportBlueBar);
    localStringBuilder.append(", isSupportOffline=");
    localStringBuilder.append(this.isSupportOffline);
    localStringBuilder.append(", recommendIconUrl=");
    localStringBuilder.append(this.recommendAppIconUrl);
    localStringBuilder.append(", extendData=");
    localStringBuilder.append(this.extendData);
    localStringBuilder.append(", extConfigInfo=");
    localStringBuilder.append(list2String(this.extConfigInfoList));
    localStringBuilder.append(", clearAuths=");
    localStringBuilder.append(this.clearAuths);
    localStringBuilder.append(", appStoreAnimPicUrl=");
    localStringBuilder.append(this.appStoreAnimPicUrl);
    localStringBuilder.append(", usrFileSizeLimit=");
    localStringBuilder.append(this.usrFileSizeLimit);
    localStringBuilder.append(", versionUpdateTime=");
    localStringBuilder.append(this.versionUpdateTime);
    localStringBuilder.append(", noNeedRealRecommend=");
    localStringBuilder.append(this.noNeedRealRecommend);
    localStringBuilder.append(", miniGamePluginInfo=");
    localStringBuilder.append(this.miniGamePluginInfo);
    localStringBuilder.append(", renderInfo=");
    RenderInfo localRenderInfo = this.renderInfo;
    int i;
    if (localRenderInfo != null) {
      i = localRenderInfo.renderMode;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", shareId=");
    localStringBuilder.append(this.shareId);
    localStringBuilder.append(", via=");
    localStringBuilder.append(this.via);
    localStringBuilder.append(", enableLoadingAd=");
    localStringBuilder.append(this.enableLoadingAd);
    localStringBuilder.append(", prepayId=");
    localStringBuilder.append(this.prepayId);
    localStringBuilder.append(", userNum=");
    localStringBuilder.append(this.userNum);
    localStringBuilder.append(", friendNum=");
    localStringBuilder.append(this.friendNum);
    localStringBuilder.append(", miniAppType=");
    localStringBuilder.append(this.miniAppType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void updateTimeStamp()
  {
    this.timestamp = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean versionIdEquals(MiniAppInfo paramMiniAppInfo)
  {
    return (!TextUtils.isEmpty(this.versionId)) && (paramMiniAppInfo != null) && (this.versionId.equals(paramMiniAppInfo.versionId));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */