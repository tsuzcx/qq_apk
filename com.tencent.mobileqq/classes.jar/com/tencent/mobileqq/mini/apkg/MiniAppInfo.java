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
import NS_MINI_INTERFACE.INTERFACE.StIdeConfig;
import NS_MINI_INTERFACE.INTERFACE.StMDebugInfo;
import NS_MINI_INTERFACE.INTERFACE.StMainPageExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StMotionPicInfo;
import NS_MINI_INTERFACE.INTERFACE.StOperationInfo;
import NS_MINI_INTERFACE.INTERFACE.StResourcePreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE.StStartExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StSubPkgInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import achn;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import mqq.app.AppRuntime;
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
  public String iconUrl;
  public String ide_extraAppid;
  public String ide_extraData;
  public String ide_scene;
  public boolean isSupportBlueBar;
  public boolean isSupportOffline;
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
    this(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, paramLong, paramList, paramString8, paramStFirstPage, paramStApiRightController, paramStMDebugInfo, null, null, null, "", 0, null, 0, false, false, "", null, 0, null, null, null, null, null, null);
  }
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, long paramLong, List<INTERFACE.StSubPkgInfo> paramList, String paramString8, INTERFACE.StFirstPage paramStFirstPage, INTERFACE.StApiRightController paramStApiRightController, INTERFACE.StMDebugInfo paramStMDebugInfo, INTERFACE.StDomainConfig paramStDomainConfig, INTERFACE.StMainPageExtInfo paramStMainPageExtInfo, INTERFACE.StDeveloperInfo paramStDeveloperInfo, String paramString9, int paramInt4, INTERFACE.StAppMode paramStAppMode, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, String paramString10, String paramString11, int paramInt6, COMM.StCommonExt paramStCommonExt, List<INTERFACE.StExtConfigInfo> paramList1, INTERFACE.StAppBasicInfo paramStAppBasicInfo, INTERFACE.StOperationInfo paramStOperationInfo, INTERFACE.StIdeConfig paramStIdeConfig, String paramString12)
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
      if (QLog.isColorLevel()) {
        QLog.i("[mini] MiniAppInfo", 1, "appid:" + paramString1 + ", usrFileSizeLimit:" + paramStAppBasicInfo.usrFileSizeLimit.get());
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
      if (!paramStAppBasicInfo.pkgType.has()) {
        break label1489;
      }
      if (paramStAppBasicInfo.pkgType.get() != 1) {
        break label1481;
      }
      this.engineType = 1;
      this.noNeedRealRecommend = paramStAppBasicInfo.noNeedRealRecommend.get();
      this.miniGamePluginInfo = MiniGamePluginInfo.fromProtocol(paramStAppBasicInfo.pluginInfo);
      this.renderInfo = RenderInfo.from(paramStAppBasicInfo.renderInfo);
      if (paramStAppBasicInfo.qualificationInfo != null) {
        this.qualifications = new ArrayList(paramStAppBasicInfo.qualificationInfo.get());
      }
      this.shareId = paramStAppBasicInfo.shareId.get();
      this.via = paramStAppBasicInfo.via.get();
      if (paramStAppBasicInfo.splashScreenAd.get() != 1) {
        break label1500;
      }
    }
    label1481:
    label1489:
    label1500:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.enableLoadingAd = paramBoolean1;
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
      return;
      this.engineType = 0;
      break;
      this.engineType = this.reportType;
      break;
    }
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
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    localMiniAppInfo.amsAdInfo = paramMiniAppInfo.amsAdInfo;
    localMiniAppInfo.apngUrl = paramMiniAppInfo.apngUrl;
    localMiniAppInfo.ide_scene = paramMiniAppInfo.ide_scene;
    localMiniAppInfo.ide_extraAppid = paramMiniAppInfo.ide_extraAppid;
    localMiniAppInfo.ide_extraData = paramMiniAppInfo.ide_extraData;
    localMiniAppInfo.tianshuAdId = paramMiniAppInfo.tianshuAdId;
    localMiniAppInfo.enableLoadingAd = paramMiniAppInfo.enableLoadingAd;
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
      paramJSONObject = from((INTERFACE.StApiAppInfo)INTERFACE.StApiAppInfo.class.cast(achn.a(new INTERFACE.StApiAppInfo(), paramJSONObject)));
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
    if (paramStApiAppInfo.supportOffline.get() == 1) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new MiniAppInfo(str1, str2, str3, str4, i, 0, j, str5, str6, str7, 0L, localList, str8, localStFirstPage, localStApiRightController, localStMDebugInfo, localStDomainConfig, localStMainPageExtInfo, localStDeveloperInfo, null, k, localStAppMode, m, bool2, bool1, getRecommendIconUrl(paramStApiAppInfo), paramStApiAppInfo.extendData.get(), paramStApiAppInfo.appNoCacheExt.clearAuths.get(), paramStApiAppInfo.extInfo, paramStApiAppInfo.extConfig.get(), (INTERFACE.StAppBasicInfo)paramStApiAppInfo.basicInfo.get(), (INTERFACE.StOperationInfo)paramStApiAppInfo.operInfo.get(), (INTERFACE.StIdeConfig)paramStApiAppInfo.basicInfo.ideConfig.get(), paramStApiAppInfo.appNoCacheExt.prepayId.get());
    }
  }
  
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
    if ((paramStApiAppInfo.extInfo == null) || (paramStApiAppInfo.extInfo.mapInfo == null)) {
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
    return "";
  }
  
  private static Map<String, String> getReportDataFromAppInfo(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    int i = 0;
    String str1 = null;
    String[] arrayOfString = null;
    Object localObject2 = null;
    localObject1 = arrayOfString;
    if (paramStApiAppInfo.operInfo != null)
    {
      localObject1 = arrayOfString;
      if (paramStApiAppInfo.operInfo.reportData != null)
      {
        paramStApiAppInfo = paramStApiAppInfo.operInfo.reportData.get();
        localObject1 = arrayOfString;
        if (!TextUtils.isEmpty(paramStApiAppInfo))
        {
          localObject1 = str1;
          try
          {
            arrayOfString = paramStApiAppInfo.split("&");
            localObject1 = str1;
            int j = arrayOfString.length;
            for (paramStApiAppInfo = (INTERFACE.StApiAppInfo)localObject2;; paramStApiAppInfo = (INTERFACE.StApiAppInfo)localObject2)
            {
              localObject1 = paramStApiAppInfo;
              if (i >= j) {
                break;
              }
              String str2 = arrayOfString[i];
              localObject1 = paramStApiAppInfo;
              int k = str2.indexOf("=");
              localObject2 = paramStApiAppInfo;
              if (k > 0)
              {
                localObject2 = paramStApiAppInfo;
                localObject1 = paramStApiAppInfo;
                if (k < str2.length() - 1)
                {
                  localObject1 = paramStApiAppInfo;
                  str1 = URLDecoder.decode(str2.substring(0, k), "UTF-8");
                  localObject1 = paramStApiAppInfo;
                  str2 = URLDecoder.decode(str2.substring(k + 1), "UTF-8");
                  localObject2 = paramStApiAppInfo;
                  if (paramStApiAppInfo == null)
                  {
                    localObject1 = paramStApiAppInfo;
                    localObject2 = new HashMap();
                  }
                  localObject1 = localObject2;
                  ((Map)localObject2).put(str1, str2);
                }
              }
              i += 1;
            }
            return localObject1;
          }
          catch (Exception paramStApiAppInfo)
          {
            QLog.e("[mini] MiniAppInfo", 1, " parse reportData error.", paramStApiAppInfo);
          }
        }
      }
    }
  }
  
  public static String getReportDataString(Map<String, String> paramMap)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramMap != null)
    {
      localObject2 = localObject1;
      if (paramMap.size() <= 0) {}
    }
    try
    {
      localObject2 = paramMap.entrySet().iterator();
      paramMap = "";
      Exception localException3;
      for (;;) {}
    }
    catch (Exception localException2)
    {
      try
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          if (TextUtils.isEmpty(paramMap))
          {
            localObject1 = paramMap + URLEncoder.encode((String)((Map.Entry)localObject1).getKey()) + "=" + URLEncoder.encode((String)((Map.Entry)localObject1).getValue(), "UTF-8");
            paramMap = (Map<String, String>)localObject1;
            break label210;
          }
          localObject1 = paramMap + "&" + URLEncoder.encode((String)((Map.Entry)localObject1).getKey()) + "=" + URLEncoder.encode((String)((Map.Entry)localObject1).getValue(), "UTF-8");
          paramMap = (Map<String, String>)localObject1;
          break label210;
        }
        localObject2 = paramMap;
        return localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException3 = localException1;
        }
      }
      localException2 = localException2;
      paramMap = (Map<String, String>)localObject1;
      QLog.e("[mini] MiniAppInfo", 1, " getReportDataString error.", localException2);
      return paramMap;
    }
  }
  
  private static boolean getSupportBlueBar(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if ((paramStApiAppInfo.extInfo == null) || (paramStApiAppInfo.extInfo.mapInfo == null)) {}
    for (;;)
    {
      return false;
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
        localStringBuffer.append(localExtConfigInfo.toString() + ",");
      }
      paramList = localStringBuffer.toString();
    }
    catch (Throwable paramList)
    {
      return "";
    }
    return paramList;
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
        localStringBuffer.append(str.toString() + ",");
      }
      paramList = localStringBuffer.toString();
    }
    catch (Throwable paramList)
    {
      return "";
    }
    return paramList;
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
        localStringBuffer.append(localSubPkgInfo.toString() + ",");
      }
      paramList = localStringBuffer.toString();
    }
    catch (Throwable paramList)
    {
      return "";
    }
    return paramList;
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
        localStringBuffer.append(localSecondApiRightInfo.toString() + ",");
      }
      paramList = localStringBuffer.toString();
    }
    catch (Throwable paramList)
    {
      return "";
    }
    return paramList;
  }
  
  private static ArrayList<String> parseArrayList(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      int j = localJSONArray.length();
      paramString = new ArrayList(j);
      int i = 0;
      for (;;)
      {
        paramJSONObject = paramString;
        if (i >= j) {
          break;
        }
        paramJSONObject = localJSONArray.optString(i);
        if (!TextUtils.isEmpty(paramJSONObject)) {
          paramString.add(paramJSONObject);
        }
        i += 1;
      }
    }
    paramJSONObject = new ArrayList();
    return paramJSONObject;
  }
  
  public static void saveMiniAppByAppInfoLinkEntity(String paramString1, int paramInt, String paramString2, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    MiniAppInfoByLinkEntity localMiniAppInfoByLinkEntity = new MiniAppInfoByLinkEntity();
    localMiniAppInfoByLinkEntity.link = paramString1;
    localMiniAppInfoByLinkEntity.linkType = paramInt;
    localMiniAppInfoByLinkEntity.shareTicket = paramString2;
    localMiniAppInfoByLinkEntity.appInfo = ((INTERFACE.StApiAppInfo)paramStApiAppInfo.get()).toByteArray();
    localMiniAppInfoByLinkEntity.timeStamp = System.currentTimeMillis();
    paramString1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString1 instanceof QQAppInterface)) {}
    for (paramString1 = (MiniAppEntityManager)paramString1.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramString1 = new MiniAppEntityManager(paramString1.getAccount()))
    {
      if (paramString1 != null)
      {
        paramString1.insertOrReplaceEntity(localMiniAppInfoByLinkEntity);
        QLog.d("miniapp-db", 1, "saveMiniAppByAppInfoLinkEntity ok." + localMiniAppInfoByLinkEntity.link + " linkType:" + paramInt);
      }
      return;
    }
  }
  
  public static void saveMiniAppByIdEntity(String paramString, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    MiniAppByIdEntity localMiniAppByIdEntity = new MiniAppByIdEntity();
    localMiniAppByIdEntity.appId = paramStApiAppInfo.appId.get();
    localMiniAppByIdEntity.entryPath = str;
    localMiniAppByIdEntity.shareTicket = null;
    localMiniAppByIdEntity.first = ((INTERFACE.StFirstPage)paramStApiAppInfo.first.get()).toByteArray();
    localMiniAppByIdEntity.mDebug = ((INTERFACE.StMDebugInfo)paramStApiAppInfo.mDebug.get()).toByteArray();
    localMiniAppByIdEntity.extData = paramStApiAppInfo.extData.get();
    localMiniAppByIdEntity.operInfo = ((INTERFACE.StOperationInfo)paramStApiAppInfo.operInfo.get()).toByteArray();
    localMiniAppByIdEntity.extInfo = ((COMM.StCommonExt)paramStApiAppInfo.extInfo.get()).toByteArray();
    localMiniAppByIdEntity.extendData = paramStApiAppInfo.extendData.get();
    localMiniAppByIdEntity.timeStamp = System.currentTimeMillis();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString instanceof QQAppInterface)) {}
    for (paramString = (MiniAppEntityManager)paramString.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramString = new MiniAppEntityManager(paramString.getAccount()))
    {
      if (paramString != null)
      {
        paramString.insertOrReplaceEntity(localMiniAppByIdEntity);
        QLog.d("miniapp-db", 1, "saveMiniAppByIdEntity ok." + localMiniAppByIdEntity.appId);
      }
      return;
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
    paramString1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString1 instanceof QQAppInterface)) {}
    for (paramString1 = (MiniAppEntityManager)paramString1.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramString1 = new MiniAppEntityManager(paramString1.getAccount()))
    {
      if (paramString1 != null)
      {
        paramString1.insertOrReplaceEntity(localMiniAppByLinkEntity);
        QLog.d("miniapp-db", 1, "saveMiniAppByLinkEntity ok." + localMiniAppByLinkEntity.appId);
      }
      return;
    }
  }
  
  public static void saveMiniAppInfoByIdEntity(String paramString, INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    MiniAppInfoByIdEntity localMiniAppInfoByIdEntity = new MiniAppInfoByIdEntity();
    localMiniAppInfoByIdEntity.appId = paramStApiAppInfo.appId.get();
    localMiniAppInfoByIdEntity.entryPath = str;
    localMiniAppInfoByIdEntity.appInfo = ((INTERFACE.StApiAppInfo)paramStApiAppInfo.get()).toByteArray();
    localMiniAppInfoByIdEntity.timeStamp = System.currentTimeMillis();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString instanceof QQAppInterface)) {}
    for (paramString = (MiniAppEntityManager)paramString.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramString = new MiniAppEntityManager(paramString.getAccount()))
    {
      if (paramString != null)
      {
        paramString.insertOrReplaceEntity(localMiniAppInfoByIdEntity);
        QLog.d("miniapp-db", 1, "saveMiniAppInfoByIdEntity ok." + localMiniAppInfoByIdEntity.appId + " entryPath:" + str);
      }
      return;
    }
  }
  
  public static void saveMiniAppInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    MiniAppInfoEntity localMiniAppInfoEntity = new MiniAppInfoEntity();
    localMiniAppInfoEntity.appId = paramStApiAppInfo.appId.get();
    localMiniAppInfoEntity.appInfo = ((INTERFACE.StApiAppInfo)paramStApiAppInfo.get()).toByteArray();
    localMiniAppInfoEntity.timeStamp = System.currentTimeMillis();
    paramStApiAppInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramStApiAppInfo instanceof QQAppInterface)) {}
    for (paramStApiAppInfo = (MiniAppEntityManager)paramStApiAppInfo.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramStApiAppInfo = new MiniAppEntityManager(paramStApiAppInfo.getAccount()))
    {
      if (paramStApiAppInfo != null)
      {
        paramStApiAppInfo.insertOrReplaceEntity(localMiniAppInfoEntity);
        QLog.d("miniapp-db", 1, "saveMiniAppInfoEntity ok." + localMiniAppInfoEntity.appId);
      }
      return;
    }
  }
  
  public static void saveMiniAppShowInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if ((paramStApiAppInfo != null) && (paramStApiAppInfo.appMode != null) && ((paramStApiAppInfo.appMode.isAppStore.get()) || (paramStApiAppInfo.appMode.interMode.get()))) {}
    label262:
    for (;;)
    {
      return;
      if (paramStApiAppInfo != null)
      {
        MiniAppShowInfoEntity localMiniAppShowInfoEntity = new MiniAppShowInfoEntity();
        localMiniAppShowInfoEntity.appId = paramStApiAppInfo.appId.get();
        localMiniAppShowInfoEntity.appName = paramStApiAppInfo.appName.get();
        localMiniAppShowInfoEntity.icon = paramStApiAppInfo.icon.get();
        localMiniAppShowInfoEntity.desc = paramStApiAppInfo.desc.get();
        localMiniAppShowInfoEntity.reportType = paramStApiAppInfo.appType.get();
        if (paramStApiAppInfo.basicInfo.pkgType.has()) {
          if (paramStApiAppInfo.basicInfo.pkgType.get() == 1)
          {
            localMiniAppShowInfoEntity.engineType = 1;
            if (paramStApiAppInfo.appMode != null) {
              localMiniAppShowInfoEntity.interMode = paramStApiAppInfo.appMode.interMode.get();
            }
            localMiniAppShowInfoEntity.timeStamp = System.currentTimeMillis();
            paramStApiAppInfo = BaseApplicationImpl.getApplication().getRuntime();
            if (!(paramStApiAppInfo instanceof QQAppInterface)) {
              break label249;
            }
          }
        }
        label249:
        for (paramStApiAppInfo = (MiniAppEntityManager)paramStApiAppInfo.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramStApiAppInfo = new MiniAppEntityManager(paramStApiAppInfo.getAccount()))
        {
          if (paramStApiAppInfo == null) {
            break label262;
          }
          paramStApiAppInfo.insertOrReplaceEntity(localMiniAppShowInfoEntity);
          QLog.d("miniapp-db", 1, "saveMiniAppShowInfoEntity ok." + localMiniAppShowInfoEntity.appId);
          return;
          localMiniAppShowInfoEntity.engineType = 0;
          break;
          localMiniAppShowInfoEntity.engineType = localMiniAppShowInfoEntity.reportType;
          break;
        }
      }
    }
  }
  
  public static void saveMiniAppShowInfoEntity(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode != null) && ((paramMiniAppInfo.appMode.isAppStore) || (paramMiniAppInfo.appMode.interMode))) {}
    label193:
    label206:
    for (;;)
    {
      return;
      if (paramMiniAppInfo != null)
      {
        MiniAppShowInfoEntity localMiniAppShowInfoEntity = new MiniAppShowInfoEntity();
        localMiniAppShowInfoEntity.appId = paramMiniAppInfo.appId;
        localMiniAppShowInfoEntity.appName = paramMiniAppInfo.name;
        localMiniAppShowInfoEntity.icon = paramMiniAppInfo.iconUrl;
        localMiniAppShowInfoEntity.desc = paramMiniAppInfo.desc;
        localMiniAppShowInfoEntity.reportType = paramMiniAppInfo.reportType;
        localMiniAppShowInfoEntity.engineType = paramMiniAppInfo.engineType;
        boolean bool;
        if ((paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.interMode))
        {
          bool = true;
          localMiniAppShowInfoEntity.interMode = bool;
          localMiniAppShowInfoEntity.timeStamp = System.currentTimeMillis();
          paramMiniAppInfo = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramMiniAppInfo instanceof QQAppInterface)) {
            break label193;
          }
        }
        for (paramMiniAppInfo = (MiniAppEntityManager)paramMiniAppInfo.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);; paramMiniAppInfo = new MiniAppEntityManager(paramMiniAppInfo.getAccount()))
        {
          if (paramMiniAppInfo == null) {
            break label206;
          }
          paramMiniAppInfo.insertOrReplaceEntity(localMiniAppShowInfoEntity);
          QLog.d("miniapp-db", 1, "saveMiniAppShowInfoEntity ok." + localMiniAppShowInfoEntity.appId);
          return;
          bool = false;
          break;
        }
      }
    }
  }
  
  public boolean canUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while ((!TextUtils.equals(paramMiniAppInfo.appId, this.appId)) || (paramMiniAppInfo.verType != this.verType) || (paramMiniAppInfo.engineType != this.engineType) || (paramMiniAppInfo.reportType != this.reportType)) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (!(paramObject instanceof MiniAppInfo));
      paramObject = (MiniAppInfo)paramObject;
    } while ((!TextUtils.equals(paramObject.appId, this.appId)) || (!TextUtils.equals(paramObject.name, this.name)) || (!TextUtils.equals(paramObject.iconUrl, this.iconUrl)) || (!TextUtils.equals(paramObject.downloadUrl, this.downloadUrl)) || (paramObject.verType != this.verType) || (paramObject.engineType != this.engineType) || (paramObject.reportType != this.reportType) || (!TextUtils.equals(paramObject.version, this.version)) || (!FirstPageInfo.equals(this.firstPage, paramObject.firstPage)) || (!DebugInfo.equals(this.debugInfo, paramObject.debugInfo)) || (!domainEquals(this.requestDomainList, paramObject.requestDomainList)) || (!domainEquals(this.socketDomainList, paramObject.socketDomainList)) || (!domainEquals(this.downloadFileDomainList, paramObject.downloadFileDomainList)) || (!domainEquals(this.uploadFileDomainList, paramObject.uploadFileDomainList)) || (!domainEquals(this.businessDomainList, paramObject.businessDomainList)) || (!this.udpIpList.equals(paramObject.udpIpList)) || (!TextUtils.equals(paramObject.extraData, this.extraData)) || (!TextUtils.equals(paramObject.shareId, this.shareId)) || (!TextUtils.equals(paramObject.via, this.via)) || (!TextUtils.equals(paramObject.ide_scene, this.ide_scene)) || (!TextUtils.equals(paramObject.ide_extraAppid, this.ide_extraAppid)) || (!TextUtils.equals(paramObject.ide_extraData, this.ide_extraData)) || (paramObject.enableLoadingAd != this.enableLoadingAd));
    return true;
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
    if ((this.verType == 0) || (this.verType == 4)) {
      return "develop";
    }
    if (this.verType == 1) {
      return "trial";
    }
    return "release";
  }
  
  public boolean isAppStoreMiniApp()
  {
    if (this.appMode == null) {
      return false;
    }
    return this.appMode.isAppStore;
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
  
  public boolean isLandScape()
  {
    return (this.deviceOrientation == 2) || (this.deviceOrientation == 3) || (this.deviceOrientation == 4);
  }
  
  public boolean isLimitedAccessApp()
  {
    return (this.appMode != null) && (this.appMode.isLimitedAccess);
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
    if ((this.miniGamePluginInfo == null) && (paramMiniAppInfo.miniGamePluginInfo != null)) {
      this.miniGamePluginInfo = paramMiniAppInfo.miniGamePluginInfo;
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
    return "[appId=" + this.appId + "][name=" + this.name + "]";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MiniAppInfo{appId='").append(this.appId).append('\'').append(", name='").append(this.name).append('\'').append(", iconUrl='").append(this.iconUrl).append('\'').append(", downloadUrl='").append(this.downloadUrl).append('\'').append(", topType=").append(this.topType).append(", version='").append(this.version).append('\'').append(", desc='").append(this.desc).append('\'').append(", engineType='").append(this.engineType).append('\'').append(", reportType='").append(this.reportType).append('\'').append(", verType=").append(this.verType).append(", timestamp=").append(this.timestamp).append(", baselibMiniVersion='").append(this.baselibMiniVersion).append('\'').append(", filesize=").append(this.fileSize).append(", extraData=").append(this.extraData).append(", developerDesc=").append(this.developerDesc).append(", firstPage=").append(this.firstPage).append(", whiteList=").append(list2string(this.whiteList)).append(", blackList=").append(list2string(this.blackList)).append(", secondApiRightInfoList=").append(list2stringSecond(this.secondApiRightInfoList)).append(", requestDomainList=").append(list2string(this.requestDomainList)).append(", socketDomainList=").append(list2string(this.socketDomainList)).append(", uploadFileDomainList=").append(list2string(this.uploadFileDomainList)).append(", downloadFileDomainList=").append(list2string(this.downloadFileDomainList)).append(", businessDomainList=").append(list2string(this.businessDomainList)).append(", udpIpList=").append(list2string(this.udpIpList)).append(", subpkgs=").append(list2stringO(this.subpkgs)).append(", isSupportOffline=").append(this.isSupportOffline).append(", skipDomainCheck=").append(this.skipDomainCheck).append(", openId=").append(this.openId).append(", tinyId=").append(this.tinyId).append(", isSupportBlueBar=").append(this.isSupportBlueBar).append(", isSupportOffline=").append(this.isSupportOffline).append(", recommendIconUrl=").append(this.recommendAppIconUrl).append(", extendData=").append(this.extendData).append(", extConfigInfo=").append(list2String(this.extConfigInfoList)).append(", clearAuths=").append(this.clearAuths).append(", appStoreAnimPicUrl=").append(this.appStoreAnimPicUrl).append(", usrFileSizeLimit=").append(this.usrFileSizeLimit).append(", versionUpdateTime=").append(this.versionUpdateTime).append(", noNeedRealRecommend=").append(this.noNeedRealRecommend).append(", miniGamePluginInfo=").append(this.miniGamePluginInfo).append(", renderInfo=");
    if (this.renderInfo != null) {}
    for (int i = this.renderInfo.renderMode;; i = 0) {
      return i + ", shareId=" + this.shareId + ", via=" + this.via + ", enableLoadingAd=" + this.enableLoadingAd + ", prepayId=" + this.prepayId + '}';
    }
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
    int i = 1;
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.topType);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.versionId);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.verType);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeString(this.baselibMiniVersion);
    paramParcel.writeTypedList(this.subpkgs);
    paramParcel.writeParcelable(this.firstPage, 0);
    paramParcel.writeInt(this.engineType);
    paramParcel.writeStringList(this.whiteList);
    paramParcel.writeStringList(this.blackList);
    paramParcel.writeTypedList(this.secondApiRightInfoList);
    paramParcel.writeParcelable(this.debugInfo, 0);
    paramParcel.writeInt(this.fileSize);
    paramParcel.writeStringList(this.requestDomainList);
    paramParcel.writeStringList(this.socketDomainList);
    paramParcel.writeStringList(this.downloadFileDomainList);
    paramParcel.writeStringList(this.uploadFileDomainList);
    paramParcel.writeStringList(this.businessDomainList);
    paramParcel.writeStringList(this.udpIpList);
    paramParcel.writeString(this.developerDesc);
    paramParcel.writeString(this.extraData);
    paramParcel.writeInt(this.recommend);
    paramParcel.writeString(this.reportData);
    paramParcel.writeParcelable(this.appMode, 0);
    paramParcel.writeString(this.openId);
    paramParcel.writeLong(this.tinyId);
    paramParcel.writeInt(this.skipDomainCheck);
    paramParcel.writeInt(this.position);
    if (this.isSupportBlueBar)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.isSupportOffline) {
        break label535;
      }
      paramInt = 1;
      label301:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.recommendAppIconUrl);
      paramParcel.writeString(this.extendData);
      paramParcel.writeInt(this.clearAuths);
      paramParcel.writeByteArray(this.commonExt);
      paramParcel.writeTypedList(this.extConfigInfoList);
      paramParcel.writeString(this.appStoreAnimPicUrl);
      paramParcel.writeStringList(this.motionPics);
      paramParcel.writeLong(this.usrFileSizeLimit);
      paramParcel.writeTypedList(this.preCacheList);
      paramParcel.writeInt(this.versionUpdateTime);
      paramParcel.writeInt(this.noNeedRealRecommend);
      paramParcel.writeParcelable(this.miniGamePluginInfo, 0);
      paramParcel.writeInt(this.reportType);
      paramParcel.writeStringList(this.qualifications);
      paramParcel.writeString(this.shareId);
      paramParcel.writeString(this.via);
      paramParcel.writeString(this.amsAdInfo);
      paramParcel.writeString(this.apngUrl);
      paramParcel.writeString(this.ide_scene);
      paramParcel.writeString(this.ide_extraAppid);
      paramParcel.writeString(this.ide_extraData);
      paramParcel.writeInt(this.tianshuAdId);
      paramParcel.writeTypedList(this.resourcePreCacheInfo);
      if (!this.enableLoadingAd) {
        break label540;
      }
    }
    label535:
    label540:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.deviceOrientation);
      paramParcel.writeInt(this.showStatusBar);
      paramParcel.writeString(this.prepayId);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label301;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */