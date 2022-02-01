package com.tencent.qqmini.sdk.launcher.model;

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
import NS_MINI_INTERFACE.INTERFACE.StOperationInfo;
import NS_MINI_INTERFACE.INTERFACE.StResourcePreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE.StStartExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StSubPkgInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
  extends MiniAppBaseInfo
  implements Parcelable
{
  public static final String APP_STORE_MINI_APP_ID = "1108291530";
  public static final Parcelable.Creator<MiniAppInfo> CREATOR = new MiniAppInfo.1();
  public static final String ENV_VERSION_DEVELOP = "develop";
  public static final String ENV_VERSION_RELEASE = "release";
  public static final String ENV_VERSION_TRIAL = "trial";
  public static final int FLAG_NEED_KILL = 2;
  public static final int FLAG_NEED_NEW_PROCESS = 1;
  public static final String NATIVE_MINI_APP_ID_CHECKIN = "1108164955";
  public static final String TAG = "MiniAppInfo";
  public static final String TAG_DB = "miniapp-db";
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public String appStoreAnimPicUrl;
  public BaseLibInfo baseLibInfo;
  public int clearAuths;
  public byte[] commonExt;
  public String customInfo;
  public ArrayList<ExtConfigInfo> extConfigInfoList;
  public String extendData;
  public String extraData;
  public int forceReroad;
  public String friendMessageQuery = "";
  public int gameAdsTotalTime;
  public String gameApprovalNumber;
  public String gameCopyrightInfo;
  public String gameOperatingCompany;
  public String gamePublicationCompany;
  public String gamePublicationNumber;
  public boolean isSupportBlueBar;
  public boolean isSupportOffline;
  @NonNull
  public final LaunchParam launchParam = new LaunchParam();
  public MiniGamePluginInfo miniGamePluginInfo;
  public ArrayList<String> motionPics;
  public String openId;
  public int position;
  public ArrayList<PreCacheInfo> preCacheList;
  public int recommend;
  public String recommendAppIconUrl;
  public int renderMode;
  private int reportType;
  public ArrayList<ResourcePreCacheInfo> resourcePreCacheInfo;
  public long tinyId;
  public int topType;
  
  public MiniAppInfo()
  {
    this.forceReroad = 0;
    this.renderMode = -1;
  }
  
  protected MiniAppInfo(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool2 = false;
    this.forceReroad = 0;
    this.renderMode = -1;
    this.topType = paramParcel.readInt();
    this.reportType = paramParcel.readInt();
    this.extraData = paramParcel.readString();
    this.recommend = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isSupportOffline = bool1;
    this.openId = paramParcel.readString();
    this.tinyId = paramParcel.readLong();
    this.position = paramParcel.readInt();
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.isSupportBlueBar = bool1;
    this.recommendAppIconUrl = paramParcel.readString();
    this.extendData = paramParcel.readString();
    this.clearAuths = paramParcel.readInt();
    this.commonExt = paramParcel.createByteArray();
    this.extConfigInfoList = paramParcel.createTypedArrayList(ExtConfigInfo.CREATOR);
    this.appStoreAnimPicUrl = paramParcel.readString();
    this.motionPics = new ArrayList();
    paramParcel.readStringList(this.motionPics);
    this.preCacheList = paramParcel.createTypedArrayList(PreCacheInfo.CREATOR);
    this.miniGamePluginInfo = ((MiniGamePluginInfo)paramParcel.readParcelable(MiniGamePluginInfo.class.getClassLoader()));
    LaunchParam localLaunchParam = (LaunchParam)paramParcel.readParcelable(LaunchParam.class.getClassLoader());
    this.launchParam.clone(localLaunchParam);
    this.baseLibInfo = ((BaseLibInfo)paramParcel.readParcelable(BaseLibInfo.class.getClassLoader()));
    this.forceReroad = paramParcel.readInt();
    this.customInfo = paramParcel.readString();
    this.resourcePreCacheInfo = paramParcel.createTypedArrayList(ResourcePreCacheInfo.CREATOR);
    this.gameCopyrightInfo = paramParcel.readString();
    this.gamePublicationNumber = paramParcel.readString();
    this.gamePublicationCompany = paramParcel.readString();
    this.gameApprovalNumber = paramParcel.readString();
    this.gameOperatingCompany = paramParcel.readString();
  }
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, long paramLong, List<INTERFACE.StSubPkgInfo> paramList, String paramString8, INTERFACE.StFirstPage paramStFirstPage, INTERFACE.StApiRightController paramStApiRightController, INTERFACE.StMDebugInfo paramStMDebugInfo, INTERFACE.StDomainConfig paramStDomainConfig, INTERFACE.StMainPageExtInfo paramStMainPageExtInfo, INTERFACE.StDeveloperInfo paramStDeveloperInfo, String paramString9, int paramInt4, INTERFACE.StAppMode paramStAppMode, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, String paramString10, String paramString11, int paramInt6, COMM.StCommonExt paramStCommonExt, List<INTERFACE.StExtConfigInfo> paramList1, INTERFACE.StAppBasicInfo paramStAppBasicInfo, INTERFACE.StOperationInfo paramStOperationInfo, INTERFACE.StIdeConfig paramStIdeConfig)
  {
    this.forceReroad = 0;
    this.renderMode = -1;
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
    parseSubPkgInfo(paramList);
    if (paramStFirstPage != null)
    {
      this.firstPage = new FirstPageInfo();
      this.firstPage.pagePath = paramStFirstPage.pagePath.get();
      this.firstPage.subPkgName = paramStFirstPage.subPkgName.get();
    }
    parseApiRightController(paramStApiRightController);
    parseDebugInfo(paramStMDebugInfo);
    parseDomainConfig(paramStDomainConfig);
    if (paramStMainPageExtInfo != null) {
      this.fileSize = paramStMainPageExtInfo.file_size.get();
    }
    if (paramStDeveloperInfo != null) {
      this.developerDesc = paramStDeveloperInfo.name.get();
    }
    this.extraData = paramString9;
    this.recommend = paramInt4;
    this.reportData = this.reportData;
    this.appMode = AppMode.from(paramStAppMode);
    this.skipDomainCheck = paramInt5;
    this.isSupportBlueBar = paramBoolean1;
    this.isSupportOffline = paramBoolean2;
    this.recommendAppIconUrl = paramString10;
    this.extendData = paramString11;
    this.clearAuths = paramInt6;
    this.commonExt = paramStCommonExt.toByteArray();
    if (paramList1 != null)
    {
      this.extConfigInfoList = new ArrayList();
      paramString1 = paramList1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = ExtConfigInfo.from((INTERFACE.StExtConfigInfo)paramString1.next());
        this.extConfigInfoList.add(paramString2);
      }
    }
    parseBasicInfo(paramStAppBasicInfo);
    if (paramStOperationInfo != null) {
      this.reportData = paramStOperationInfo.reportData.get();
    }
    if ((paramStIdeConfig != null) && (paramStIdeConfig.startExtInfo != null))
    {
      this.deviceOrientation = paramStIdeConfig.startExtInfo.deviceOrientation.get();
      this.showStatusBar = paramStIdeConfig.startExtInfo.showStatusBar.get();
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
        localMiniAppInfo.preCacheList.add(new PreCacheInfo(((PreCacheInfo)localObject2).getDataUrl, ((PreCacheInfo)localObject2).preCacheKey, ((PreCacheInfo)localObject2).expireTime));
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
    localMiniAppInfo.enableLoadingAd = paramMiniAppInfo.enableLoadingAd;
    return localMiniAppInfo;
  }
  
  public static MiniAppInfo createMiniAppInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        MiniAppInfo localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = paramJSONObject.optString("appId");
        localMiniAppInfo.name = paramJSONObject.optString("appName");
        localMiniAppInfo.iconUrl = paramJSONObject.optString("icon");
        localMiniAppInfo.downloadUrl = paramJSONObject.optString("donwLoadUrl");
        localMiniAppInfo.version = paramJSONObject.optString("version");
        localMiniAppInfo.desc = paramJSONObject.optString("desc");
        localMiniAppInfo.verType = paramJSONObject.optInt("type");
        localMiniAppInfo.baselibMiniVersion = paramJSONObject.optString("baselibMiniVersion");
        localMiniAppInfo.subpkgs = parseSubpkgs(paramJSONObject);
        localMiniAppInfo.firstPage = new FirstPageInfo();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("first");
        if (localJSONObject != null)
        {
          localMiniAppInfo.firstPage.pagePath = localJSONObject.optString("pagePath");
          localMiniAppInfo.firstPage.subPkgName = localJSONObject.optString("subPkgName");
        }
        parseDomainInfo(localMiniAppInfo, paramJSONObject);
        localMiniAppInfo.appType = paramJSONObject.optInt("appType");
        localMiniAppInfo.debugInfo = new DebugInfo();
        localJSONObject = paramJSONObject.optJSONObject("mDebug");
        if (localJSONObject != null)
        {
          localMiniAppInfo.debugInfo.roomId = localJSONObject.optString("roomId");
          localMiniAppInfo.debugInfo.wsUrl = localJSONObject.optString("wsUrl");
        }
        localMiniAppInfo.versionId = paramJSONObject.optString("versionId");
        parseApiRights(localMiniAppInfo, paramJSONObject);
        if (paramJSONObject.optJSONObject("mainExt") != null) {
          localMiniAppInfo.fileSize = paramJSONObject.optJSONObject("mainExt").optInt("file_size");
        }
        if (paramJSONObject.optJSONObject("devInfo") != null) {
          localMiniAppInfo.developerDesc = paramJSONObject.optJSONObject("devInfo").optString("name");
        }
        if (paramJSONObject.optJSONObject("basicInfo") != null)
        {
          localJSONObject = paramJSONObject.optJSONObject("basicInfo");
          localMiniAppInfo.usrFileSizeLimit = localJSONObject.optInt("usrFileSizeLimit");
          localMiniAppInfo.versionUpdateTime = localJSONObject.optInt("versionUpdateTime");
          localMiniAppInfo.noNeedRealRecommend = localJSONObject.optInt("noNeedRealRecommend");
          if (localJSONObject.optInt("splashScreenAd") == 1)
          {
            bool = true;
            localMiniAppInfo.enableLoadingAd = bool;
            localMiniAppInfo.gameCopyrightInfo = localJSONObject.optString("gameCopyrightInfo");
            localMiniAppInfo.gamePublicationNumber = localJSONObject.optString("gamePublicationNumber");
            localMiniAppInfo.gamePublicationCompany = localJSONObject.optString("gamePublicationCompany");
            localMiniAppInfo.gameApprovalNumber = localJSONObject.optString("gameApprovalNumber");
            localMiniAppInfo.gameOperatingCompany = localJSONObject.optString("gameOperatingCompany");
            if (localJSONObject.has("pkgType"))
            {
              if (localJSONObject.optInt("pkgType") == 1) {
                localMiniAppInfo.engineType = 1;
              } else {
                localMiniAppInfo.engineType = 0;
              }
            }
            else {
              localMiniAppInfo.engineType = localMiniAppInfo.appType;
            }
            localMiniAppInfo.miniGamePluginInfo = parseMiniGamePluginInfo(localJSONObject.optJSONObject("pluginInfo"));
          }
        }
        else
        {
          if (paramJSONObject.optJSONObject("appMode") != null)
          {
            localMiniAppInfo.appMode = new AppMode();
            paramJSONObject = paramJSONObject.optJSONObject("appMode");
            localMiniAppInfo.appMode.interMode = paramJSONObject.optBoolean("interMode");
            localMiniAppInfo.appMode.authoritySilent = paramJSONObject.optBoolean("authoritySilent");
            localMiniAppInfo.appMode.keepOffPullList = paramJSONObject.optBoolean("keepOffPullList");
            localMiniAppInfo.appMode.closeTopRightCapsule = paramJSONObject.optBoolean("closeTopRightCapsule");
            localMiniAppInfo.appMode.openNativeApi = paramJSONObject.optBoolean("openNativeApi");
            localMiniAppInfo.appMode.hideAppSearch = paramJSONObject.optBoolean("hideAppSearch");
            localMiniAppInfo.appMode.isAppStore = paramJSONObject.optBoolean("isAppStore");
            localMiniAppInfo.appMode.isWangKa = paramJSONObject.optBoolean("isWangKa");
            localMiniAppInfo.appMode.interLoading = paramJSONObject.optBoolean("interLoading");
            localMiniAppInfo.appMode.isLimitedAccess = paramJSONObject.optBoolean("isLimitedAccess");
            localMiniAppInfo.appMode.isPayForFriend = paramJSONObject.optBoolean("isPayForFriend");
            localMiniAppInfo.appMode.useAppInfoWhenNavigate = paramJSONObject.optBoolean("useAppInfoWhenNavigate");
            localMiniAppInfo.appMode.disableAddToMyApp = paramJSONObject.optBoolean("disableAddToMyApp");
            localMiniAppInfo.appMode.disableAddToMyFavor = paramJSONObject.optBoolean("disableAddToMyFavor");
            localMiniAppInfo.appMode.reloadWithFirstPageChange = paramJSONObject.optBoolean("reloadWithFirstPageChange");
            localMiniAppInfo.appMode.unlimitedApiRight = paramJSONObject.optBoolean("unlimitedApiRight");
            localMiniAppInfo.appMode.disableShareToAIO = paramJSONObject.optBoolean("disableShareToAIO");
            localMiniAppInfo.appMode.disableShareToQZone = paramJSONObject.optBoolean("disableShareToQZone");
            localMiniAppInfo.appMode.disableShareToWeChat = paramJSONObject.optBoolean("disableShareToWeChat");
          }
          return localMiniAppInfo;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("MiniAppInfo", "", paramJSONObject);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static boolean equalObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
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
    return new MiniAppInfo(str1, str2, str3, str4, i, 0, j, str5, str6, str7, 0L, localList, str8, localStFirstPage, localStApiRightController, localStMDebugInfo, localStDomainConfig, localStMainPageExtInfo, localStDeveloperInfo, null, k, localStAppMode, m, bool2, bool1, getRecommendIconUrl(paramStApiAppInfo), paramStApiAppInfo.extendData.get(), paramStApiAppInfo.appNoCacheExt.clearAuths.get(), paramStApiAppInfo.extInfo, paramStApiAppInfo.extConfig.get(), (INTERFACE.StAppBasicInfo)paramStApiAppInfo.basicInfo.get(), (INTERFACE.StOperationInfo)paramStApiAppInfo.operInfo.get(), (INTERFACE.StIdeConfig)paramStApiAppInfo.basicInfo.ideConfig.get());
  }
  
  public static INTERFACE.StApiRightController getApiRight(JSONObject paramJSONObject)
  {
    INTERFACE.StApiRightController localStApiRightController = new INTERFACE.StApiRightController();
    paramJSONObject = paramJSONObject.optJSONObject("apiRight");
    if (paramJSONObject != null)
    {
      Object localObject1 = paramJSONObject.optJSONArray("whiteLst");
      int j = 0;
      Object localObject2;
      int i;
      if (localObject1 != null)
      {
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray("whiteLst");
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ((ArrayList)localObject1).add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
        localStApiRightController.whiteLst.set((List)localObject1);
      }
      if (paramJSONObject.optJSONArray("blackLst") != null)
      {
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray("blackLst");
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ((ArrayList)localObject1).add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
        localStApiRightController.whiteLst.set((List)localObject1);
      }
      if (paramJSONObject.optJSONArray("secondApiRights") != null)
      {
        localObject1 = new ArrayList();
        paramJSONObject = paramJSONObject.optJSONArray("secondApiRights");
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject2 = paramJSONObject.optJSONObject(i);
          if (localObject2 != null)
          {
            INTERFACE.StApiRightItem localStApiRightItem = new INTERFACE.StApiRightItem();
            localStApiRightItem.apiName.set(((JSONObject)localObject2).optString("apiName"));
            localStApiRightItem.right.set(((JSONObject)localObject2).optInt("right"));
            localStApiRightItem.secondName.set(((JSONObject)localObject2).optString("secondName"));
            ((ArrayList)localObject1).add(localStApiRightItem);
          }
          i += 1;
        }
        localStApiRightController.secondApiRights.set((List)localObject1);
      }
    }
    return localStApiRightController;
  }
  
  public static INTERFACE.StMDebugInfo getDebugPb(JSONObject paramJSONObject)
  {
    INTERFACE.StMDebugInfo localStMDebugInfo = new INTERFACE.StMDebugInfo();
    paramJSONObject = paramJSONObject.optJSONObject("mDebug");
    if (paramJSONObject != null)
    {
      localStMDebugInfo.wsUrl.set(paramJSONObject.optString("wsUrl"));
      localStMDebugInfo.roomId.set(paramJSONObject.optString("roomId"));
    }
    return localStMDebugInfo;
  }
  
  public static INTERFACE.StDomainConfig getDomain(JSONObject paramJSONObject)
  {
    INTERFACE.StDomainConfig localStDomainConfig = new INTERFACE.StDomainConfig();
    if (paramJSONObject.optJSONObject("domain") != null)
    {
      setRequestDomain(paramJSONObject, localStDomainConfig);
      setSocketDomain(paramJSONObject, localStDomainConfig);
      setUploadFileDomain(paramJSONObject, localStDomainConfig);
      setDownloadFileDomain(paramJSONObject, localStDomainConfig);
      setBusinessDomain(paramJSONObject, localStDomainConfig);
      setUdpIpList(paramJSONObject, localStDomainConfig);
    }
    return localStDomainConfig;
  }
  
  public static INTERFACE.StFirstPage getFirstPb(JSONObject paramJSONObject)
  {
    INTERFACE.StFirstPage localStFirstPage = new INTERFACE.StFirstPage();
    paramJSONObject = paramJSONObject.optJSONObject("first");
    if (paramJSONObject != null)
    {
      localStFirstPage.pagePath.set(paramJSONObject.optString("pagePath"));
      localStFirstPage.subPkgName.set(paramJSONObject.optString("subPkgName"));
    }
    return localStFirstPage;
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
            QMLog.e("MiniAppInfo", " parse reportData error.", localException2);
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
          QMLog.e("MiniAppInfo", " getReportDataString error.", paramMap);
          localObject2 = localObject1;
        }
      }
    }
  }
  
  public static ArrayList<INTERFACE.StSubPkgInfo> getSubPkgsPb(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("subPkgs");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          INTERFACE.StSubPkgInfo localStSubPkgInfo = new INTERFACE.StSubPkgInfo();
          localStSubPkgInfo.subPkgName.set(localJSONObject.optString("subPkgName"));
          localStSubPkgInfo.dowLoadUrl.set(localJSONObject.optString("dowLoadUrl"));
          localStSubPkgInfo.independent.set(localJSONObject.optInt("independent"));
          localStSubPkgInfo.file_size.set(localJSONObject.optInt("file_size"));
          localArrayList.add(localStSubPkgInfo);
        }
        i += 1;
      }
    }
    return localArrayList;
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
  
  private void parseApiRightController(INTERFACE.StApiRightController paramStApiRightController)
  {
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
        paramStApiRightController = paramStApiRightController.secondApiRights.get().iterator();
        while (paramStApiRightController.hasNext())
        {
          INTERFACE.StApiRightItem localStApiRightItem = (INTERFACE.StApiRightItem)paramStApiRightController.next();
          if (localStApiRightItem != null)
          {
            SecondApiRightInfo localSecondApiRightInfo = new SecondApiRightInfo();
            localSecondApiRightInfo.apiName = localStApiRightItem.apiName.get();
            localSecondApiRightInfo.secondName = localStApiRightItem.secondName.get();
            localSecondApiRightInfo.right = localStApiRightItem.right.get();
            this.secondApiRightInfoList.add(localSecondApiRightInfo);
          }
        }
      }
    }
  }
  
  private static void parseApiRights(MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("apiRight");
    if (paramJSONObject != null)
    {
      Object localObject1 = paramJSONObject.optJSONArray("whiteLst");
      int j = 0;
      int i;
      Object localObject2;
      if (localObject1 != null)
      {
        paramMiniAppInfo.whiteList = new ArrayList();
        localObject1 = paramJSONObject.optJSONArray("whiteLst");
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = (String)((JSONArray)localObject1).get(i);
          paramMiniAppInfo.whiteList.add(localObject2);
          i += 1;
        }
      }
      if (paramJSONObject.optJSONArray("blackLst") != null)
      {
        paramMiniAppInfo.blackList = new ArrayList();
        localObject1 = paramJSONObject.optJSONArray("blackLst");
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = (String)((JSONArray)localObject1).get(i);
          paramMiniAppInfo.blackList.add(localObject2);
          i += 1;
        }
      }
      if (paramJSONObject.optJSONArray("secondApiRights") != null)
      {
        paramMiniAppInfo.secondApiRightInfoList = new ArrayList();
        paramJSONObject = paramJSONObject.optJSONArray("secondApiRights");
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject1 = (JSONObject)paramJSONObject.get(i);
          localObject2 = new SecondApiRightInfo();
          ((SecondApiRightInfo)localObject2).apiName = ((JSONObject)localObject1).optString("apiName");
          ((SecondApiRightInfo)localObject2).secondName = ((JSONObject)localObject1).optString("secondName");
          ((SecondApiRightInfo)localObject2).right = ((JSONObject)localObject1).optInt("right");
          paramMiniAppInfo.secondApiRightInfoList.add(localObject2);
          i += 1;
        }
      }
    }
  }
  
  private void parseBasicInfo(INTERFACE.StAppBasicInfo paramStAppBasicInfo)
  {
    if (paramStAppBasicInfo != null)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("appid:");
      ((StringBuilder)localObject1).append(this.appId);
      ((StringBuilder)localObject1).append(", usrFileSizeLimit:");
      ((StringBuilder)localObject1).append(paramStAppBasicInfo.usrFileSizeLimit.get());
      QMLog.i("MiniAppInfo", ((StringBuilder)localObject1).toString());
      this.usrFileSizeLimit = paramStAppBasicInfo.usrFileSizeLimit.get();
      Object localObject2;
      if (paramStAppBasicInfo.preCacheList != null)
      {
        localObject1 = paramStAppBasicInfo.preCacheList.get();
        if (((List)localObject1).size() > 0)
        {
          this.preCacheList = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INTERFACE.StAppPreCacheInfo)((Iterator)localObject1).next();
            this.preCacheList.add(new PreCacheInfo(((INTERFACE.StAppPreCacheInfo)localObject2).getDataUrl.get(), ((INTERFACE.StAppPreCacheInfo)localObject2).preCacheKey.get(), ((INTERFACE.StAppPreCacheInfo)localObject2).expireTime.get()));
          }
        }
      }
      if (paramStAppBasicInfo.resourcePreCacheList != null)
      {
        localObject1 = paramStAppBasicInfo.resourcePreCacheList.get();
        if (((List)localObject1).size() > 0)
        {
          this.resourcePreCacheInfo = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INTERFACE.StResourcePreCacheInfo)((Iterator)localObject1).next();
            this.resourcePreCacheInfo.add(new ResourcePreCacheInfo(((INTERFACE.StResourcePreCacheInfo)localObject2).getDataUrl.get()));
          }
        }
      }
      this.versionUpdateTime = paramStAppBasicInfo.versionUpdateTime.get();
      boolean bool2 = paramStAppBasicInfo.pkgType.has();
      boolean bool1 = false;
      if (bool2)
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
        bool1 = true;
      }
      this.enableLoadingAd = bool1;
    }
  }
  
  private void parseDebugInfo(INTERFACE.StMDebugInfo paramStMDebugInfo)
  {
    if ((paramStMDebugInfo != null) && (!TextUtils.isEmpty(paramStMDebugInfo.roomId.get())) && (!TextUtils.isEmpty(paramStMDebugInfo.wsUrl.get())))
    {
      this.debugInfo = new DebugInfo();
      this.debugInfo.roomId = paramStMDebugInfo.roomId.get();
      this.debugInfo.wsUrl = paramStMDebugInfo.wsUrl.get();
    }
  }
  
  private void parseDomainConfig(INTERFACE.StDomainConfig paramStDomainConfig)
  {
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
  }
  
  private static void parseDomainInfo(MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optJSONObject("domain") != null)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONObject("domain").optJSONArray("requestDomain");
      int j = 0;
      int i;
      if (localJSONArray != null)
      {
        paramMiniAppInfo.requestDomainList = new ArrayList();
        localJSONArray = paramJSONObject.getJSONObject("domain").getJSONArray("requestDomain");
        i = 0;
        while (i < localJSONArray.length())
        {
          paramMiniAppInfo.requestDomainList.add(localJSONArray.optString(i));
          i += 1;
        }
      }
      if (paramJSONObject.optJSONObject("domain").optJSONArray("socketDomain") != null)
      {
        paramMiniAppInfo.socketDomainList = new ArrayList();
        localJSONArray = paramJSONObject.optJSONObject("domain").optJSONArray("socketDomain");
        i = 0;
        while (i < localJSONArray.length())
        {
          paramMiniAppInfo.socketDomainList.add(localJSONArray.optString(i));
          i += 1;
        }
      }
      if (paramJSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain") != null)
      {
        paramMiniAppInfo.uploadFileDomainList = new ArrayList();
        localJSONArray = paramJSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain");
        i = 0;
        while (i < localJSONArray.length())
        {
          paramMiniAppInfo.uploadFileDomainList.add(localJSONArray.optString(i));
          i += 1;
        }
      }
      if (paramJSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain") != null)
      {
        paramMiniAppInfo.downloadFileDomainList = new ArrayList();
        localJSONArray = paramJSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain");
        i = 0;
        while (i < localJSONArray.length())
        {
          paramMiniAppInfo.downloadFileDomainList.add(localJSONArray.getString(i));
          i += 1;
        }
      }
      if (paramJSONObject.optJSONObject("domain").optJSONArray("businessDomain") != null)
      {
        paramMiniAppInfo.businessDomainList = new ArrayList();
        localJSONArray = paramJSONObject.optJSONObject("domain").optJSONArray("businessDomain");
        i = 0;
        while (i < localJSONArray.length())
        {
          paramMiniAppInfo.businessDomainList.add(localJSONArray.getString(i));
          i += 1;
        }
      }
      if (paramJSONObject.optJSONObject("domain").optJSONArray("udpIpList") != null)
      {
        paramMiniAppInfo.udpIpList = new ArrayList();
        paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("udpIpList");
        i = j;
        while (i < paramJSONObject.length())
        {
          paramMiniAppInfo.udpIpList.add(paramJSONObject.getString(i));
          i += 1;
        }
      }
    }
  }
  
  private static MiniGamePluginInfo parseMiniGamePluginInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QMLog.i("MiniAppInfo", "No MiniGamePluginInfo");
      return null;
    }
    return new MiniGamePluginInfo(paramJSONObject.optString("pluginName"), paramJSONObject.optString("pluginId"), paramJSONObject.optString("version"), paramJSONObject.optString("url"), paramJSONObject.optInt("fileSize"));
  }
  
  private void parseSubPkgInfo(List<INTERFACE.StSubPkgInfo> paramList)
  {
    if (paramList != null)
    {
      this.subpkgs = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        INTERFACE.StSubPkgInfo localStSubPkgInfo = (INTERFACE.StSubPkgInfo)paramList.next();
        if (localStSubPkgInfo != null)
        {
          SubPkgInfo localSubPkgInfo = new SubPkgInfo();
          localSubPkgInfo.subPkgName = localStSubPkgInfo.subPkgName.get();
          localSubPkgInfo.downloadUrl = localStSubPkgInfo.dowLoadUrl.get();
          localSubPkgInfo.independent = localStSubPkgInfo.independent.get();
          localSubPkgInfo.fileSize = localStSubPkgInfo.file_size.get();
          this.subpkgs.add(localSubPkgInfo);
        }
      }
    }
  }
  
  private static List<SubPkgInfo> parseSubpkgs(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("subPkgs");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
        SubPkgInfo localSubPkgInfo = new SubPkgInfo();
        localSubPkgInfo.subPkgName = localJSONObject.optString("subPkgName");
        localSubPkgInfo.downloadUrl = localJSONObject.optString("dowLoadUrl");
        localSubPkgInfo.independent = localJSONObject.optInt("independent");
        localSubPkgInfo.fileSize = localJSONObject.optInt("file_size");
        localArrayList.add(localSubPkgInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static INTERFACE.StApiAppInfo pbFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
    localStApiAppInfo.appId.set(paramJSONObject.optString("appId"));
    localStApiAppInfo.appName.set(paramJSONObject.optString("appName"));
    localStApiAppInfo.icon.set(paramJSONObject.optString("icon"));
    localStApiAppInfo.donwLoadUrl.set(paramJSONObject.optString("donwLoadUrl"));
    localStApiAppInfo.version.set(paramJSONObject.optString("version"));
    localStApiAppInfo.desc.set(paramJSONObject.optString("desc"));
    localStApiAppInfo.type.set(paramJSONObject.optInt("type"));
    localStApiAppInfo.baselibMiniVersion.set(paramJSONObject.optString("baselibMiniVersion"));
    localStApiAppInfo.subPkgs.set(getSubPkgsPb(paramJSONObject));
    localStApiAppInfo.first.set(getFirstPb(paramJSONObject));
    localStApiAppInfo.domain.set(getDomain(paramJSONObject));
    localStApiAppInfo.appType.set(paramJSONObject.optInt("appType"));
    localStApiAppInfo.mDebug.set(getDebugPb(paramJSONObject));
    localStApiAppInfo.versionId.set(paramJSONObject.optString("versionId"));
    localStApiAppInfo.apiRight.set(getApiRight(paramJSONObject));
    Object localObject;
    if (paramJSONObject.optJSONObject("mainExt") != null)
    {
      localObject = new INTERFACE.StMainPageExtInfo();
      ((INTERFACE.StMainPageExtInfo)localObject).file_size.set(paramJSONObject.optJSONObject("mainExt").optInt("file_size"));
      localStApiAppInfo.mainExt.set((MessageMicro)localObject);
    }
    if (paramJSONObject.optJSONObject("devInfo") != null)
    {
      localObject = new INTERFACE.StDeveloperInfo();
      ((INTERFACE.StDeveloperInfo)localObject).name.set(paramJSONObject.optJSONObject("devInfo").optString("name"));
      localStApiAppInfo.devInfo.set((MessageMicro)localObject);
    }
    if (paramJSONObject.optJSONObject("basicInfo") != null)
    {
      localObject = paramJSONObject.optJSONObject("basicInfo");
      if (localObject != null)
      {
        INTERFACE.StAppBasicInfo localStAppBasicInfo = new INTERFACE.StAppBasicInfo();
        localStAppBasicInfo.usrFileSizeLimit.set(((JSONObject)localObject).optInt("usrFileSizeLimit"));
        localStAppBasicInfo.versionUpdateTime.set(((JSONObject)localObject).optInt("versionUpdateTime"));
        localStAppBasicInfo.noNeedRealRecommend.set(((JSONObject)localObject).optInt("noNeedRealRecommend"));
        localStAppBasicInfo.splashScreenAd.set(((JSONObject)localObject).optInt("splashScreenAd"));
        if (((JSONObject)localObject).has("pkgType")) {
          localStAppBasicInfo.pkgType.set(((JSONObject)localObject).optInt("pkgType"));
        }
        localStAppBasicInfo.gameCopyrightInfo.set(((JSONObject)localObject).optString("gameCopyrightInfo"));
        if (((JSONObject)localObject).has("gamePublicationInfo"))
        {
          localStAppBasicInfo.gamePublicationInfo.gamePublicationNumber.set(((JSONObject)localObject).optString("gamePublicationNumber"));
          localStAppBasicInfo.gamePublicationInfo.gamePublicationCommpany.set(((JSONObject)localObject).optString("gamePublicationCompany"));
          localStAppBasicInfo.gamePublicationInfo.gameApprovalNumber.set(((JSONObject)localObject).optString("gameApprovalNumber"));
          localStAppBasicInfo.gamePublicationInfo.gameOperatingCompany.set(((JSONObject)localObject).optString("gameOperatingCompany"));
        }
        localStApiAppInfo.basicInfo.set(localStAppBasicInfo);
      }
    }
    if (paramJSONObject.optJSONObject("appMode") != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("appMode");
      if (paramJSONObject != null)
      {
        localObject = new INTERFACE.StAppMode();
        ((INTERFACE.StAppMode)localObject).interMode.set(paramJSONObject.optBoolean("interMode"));
        ((INTERFACE.StAppMode)localObject).authoritySilent.set(paramJSONObject.optBoolean("authoritySilent"));
        ((INTERFACE.StAppMode)localObject).keepOffPullList.set(paramJSONObject.optBoolean("keepOffPullList"));
        ((INTERFACE.StAppMode)localObject).closeTopRightCapsule.set(paramJSONObject.optBoolean("closeTopRightCapsule"));
        ((INTERFACE.StAppMode)localObject).openNativeApi.set(paramJSONObject.optBoolean("openNativeApi"));
        ((INTERFACE.StAppMode)localObject).hideAppSearch.set(paramJSONObject.optBoolean("hideAppSearch"));
        ((INTERFACE.StAppMode)localObject).isAppStore.set(paramJSONObject.optBoolean("isAppStore"));
        ((INTERFACE.StAppMode)localObject).isWangKa.set(paramJSONObject.optBoolean("isWangKa"));
        ((INTERFACE.StAppMode)localObject).interLoading.set(paramJSONObject.optBoolean("interLoading"));
        ((INTERFACE.StAppMode)localObject).isLimitedAccess.set(paramJSONObject.optBoolean("isLimitedAccess"));
        ((INTERFACE.StAppMode)localObject).isPayForFriend.set(paramJSONObject.optBoolean("isPayForFriend"));
        ((INTERFACE.StAppMode)localObject).useAppInfoWhenNavigate.set(paramJSONObject.optBoolean("useAppInfoWhenNavigate"));
        ((INTERFACE.StAppMode)localObject).disableAddToMyApp.set(paramJSONObject.optBoolean("disableAddToMyApp"));
        ((INTERFACE.StAppMode)localObject).disableAddToMyFavor.set(paramJSONObject.optBoolean("disableAddToMyFavor"));
        ((INTERFACE.StAppMode)localObject).reloadWithFirstPageChange.set(paramJSONObject.optBoolean("reloadWithFirstPageChange"));
        ((INTERFACE.StAppMode)localObject).unlimitedApiRight.set(paramJSONObject.optBoolean("unlimitedApiRight"));
        ((INTERFACE.StAppMode)localObject).disableShareToAIO.set(paramJSONObject.optBoolean("disableShareToAIO"));
        ((INTERFACE.StAppMode)localObject).disableShareToQZone.set(paramJSONObject.optBoolean("disableShareToQZone"));
        ((INTERFACE.StAppMode)localObject).disableShareToWeChat.set(paramJSONObject.optBoolean("disableShareToWeChat"));
        localStApiAppInfo.appMode.set((MessageMicro)localObject);
      }
    }
    return localStApiAppInfo;
  }
  
  public static void saveMiniAppByIdEntity(String paramString, INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppByLinkEntity(String paramString1, int paramInt, String paramString2, INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppShowInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppShowInfoEntity(MiniAppInfo paramMiniAppInfo) {}
  
  private static void setBusinessDomain(JSONObject paramJSONObject, INTERFACE.StDomainConfig paramStDomainConfig)
  {
    if (paramJSONObject.optJSONObject("domain").optJSONArray("businessDomain") != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("businessDomain");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramStDomainConfig.businessDomain.set(localArrayList);
    }
  }
  
  private static void setDownloadFileDomain(JSONObject paramJSONObject, INTERFACE.StDomainConfig paramStDomainConfig)
  {
    if (paramJSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain") != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramStDomainConfig.downloadFileDomain.set(localArrayList);
    }
  }
  
  private static void setRequestDomain(JSONObject paramJSONObject, INTERFACE.StDomainConfig paramStDomainConfig)
  {
    if (paramJSONObject.optJSONObject("domain").optJSONArray("requestDomain") != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("requestDomain");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramStDomainConfig.requestDomain.set(localArrayList);
    }
  }
  
  private static void setSocketDomain(JSONObject paramJSONObject, INTERFACE.StDomainConfig paramStDomainConfig)
  {
    if (paramJSONObject.optJSONObject("domain").optJSONArray("socketDomain") != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("socketDomain");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramStDomainConfig.socketDomain.set(localArrayList);
    }
  }
  
  private static void setUdpIpList(JSONObject paramJSONObject, INTERFACE.StDomainConfig paramStDomainConfig)
  {
    if (paramJSONObject.optJSONObject("domain").optJSONArray("udpIpList") != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("udpIpList");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramStDomainConfig.udpIpList.set(localArrayList);
    }
  }
  
  private static void setUploadFileDomain(JSONObject paramJSONObject, INTERFACE.StDomainConfig paramStDomainConfig)
  {
    if (paramJSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain") != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramStDomainConfig.uploadFileDomain.set(localArrayList);
    }
  }
  
  public boolean canDebug()
  {
    return (this.debugInfo != null) && (!TextUtils.isEmpty(this.debugInfo.roomId)) && (!TextUtils.isEmpty(this.debugInfo.wsUrl));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramMiniAppInfo == null) {
      return false;
    }
    if ((!paramMiniAppInfo.isShortcutFakeApp()) && (!paramMiniAppInfo.isFakeAppInfo()))
    {
      if (isEngineTypeMiniGame())
      {
        bool1 = bool2;
        if (equalObj(this.appId, paramMiniAppInfo.appId))
        {
          bool1 = bool2;
          if (equalObj(Integer.valueOf(this.verType), Integer.valueOf(paramMiniAppInfo.verType))) {
            bool1 = true;
          }
        }
        return bool1;
      }
      boolean bool1 = bool3;
      if (equalObj(this.appId, paramMiniAppInfo.appId))
      {
        bool1 = bool3;
        if (equalObj(Integer.valueOf(this.verType), Integer.valueOf(paramMiniAppInfo.verType)))
        {
          bool1 = bool3;
          if (equalObj(this.version, paramMiniAppInfo.version)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    return equalObj(this.appId, paramMiniAppInfo.appId);
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
    if ((this.verType != 0) && (this.verType != 4))
    {
      if (this.verType == 1) {
        return "trial";
      }
      return "release";
    }
    return "develop";
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
  
  public boolean isFakeAppInfo()
  {
    return this.launchParam.isFakeAppInfo;
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
  
  public boolean isShortcutFakeApp()
  {
    LaunchParam localLaunchParam = this.launchParam;
    return (localLaunchParam != null) && (localLaunchParam.scene == 1023) && (TextUtils.isEmpty(this.downloadUrl));
  }
  
  public boolean isSpecialMiniApp()
  {
    return isAppStoreMiniApp();
  }
  
  public boolean isStartFromAppId()
  {
    return (this.launchParam.isFakeAppInfo) && (TextUtils.isEmpty(this.link)) && (!TextUtils.isEmpty(this.appId));
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
  
  public String toDetailString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppInfo {\n");
    localStringBuilder.append("\tappId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tname=");
    localStringBuilder.append(this.name);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tversionId=");
    localStringBuilder.append(this.versionId);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tverType=");
    localStringBuilder.append(this.verType);
    localStringBuilder.append("\n");
    localStringBuilder.append("\ticonUrl=");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tdownloadUrl=");
    localStringBuilder.append(this.downloadUrl);
    localStringBuilder.append("\n");
    localStringBuilder.append("\twhiteList=");
    localStringBuilder.append(this.whiteList);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tblackList=");
    localStringBuilder.append(this.blackList);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tbaselibMiniVersion=");
    localStringBuilder.append(this.baselibMiniVersion);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tfirstPage=");
    localStringBuilder.append(this.firstPage);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tlaunchParam=");
    localStringBuilder.append(this.launchParam);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tvia=");
    localStringBuilder.append(this.via);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tenableLoadingAd=");
    localStringBuilder.append(this.enableLoadingAd);
    localStringBuilder.append("\n");
    localStringBuilder.append("\tprepayId=");
    localStringBuilder.append(this.prepayId);
    localStringBuilder.append("\n");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return simpleInfo();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.topType);
    paramParcel.writeInt(this.reportType);
    paramParcel.writeString(this.extraData);
    paramParcel.writeInt(this.recommend);
    paramParcel.writeByte((byte)this.isSupportOffline);
    paramParcel.writeString(this.openId);
    paramParcel.writeLong(this.tinyId);
    paramParcel.writeInt(this.position);
    paramParcel.writeByte((byte)this.isSupportBlueBar);
    paramParcel.writeString(this.recommendAppIconUrl);
    paramParcel.writeString(this.extendData);
    paramParcel.writeInt(this.clearAuths);
    paramParcel.writeByteArray(this.commonExt);
    paramParcel.writeTypedList(this.extConfigInfoList);
    paramParcel.writeString(this.appStoreAnimPicUrl);
    paramParcel.writeStringList(this.motionPics);
    paramParcel.writeTypedList(this.preCacheList);
    paramParcel.writeParcelable(this.miniGamePluginInfo, 0);
    paramParcel.writeParcelable(this.launchParam, 0);
    paramParcel.writeParcelable(this.baseLibInfo, 0);
    paramParcel.writeInt(this.forceReroad);
    paramParcel.writeString(this.customInfo);
    paramParcel.writeTypedList(this.resourcePreCacheInfo);
    paramParcel.writeString(this.gameCopyrightInfo);
    paramParcel.writeString(this.gamePublicationNumber);
    paramParcel.writeString(this.gamePublicationCompany);
    paramParcel.writeString(this.gameApprovalNumber);
    paramParcel.writeString(this.gameOperatingCompany);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */