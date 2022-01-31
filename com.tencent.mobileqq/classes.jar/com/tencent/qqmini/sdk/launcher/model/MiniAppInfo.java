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
import NS_MINI_INTERFACE.INTERFACE.StMDebugInfo;
import NS_MINI_INTERFACE.INTERFACE.StMainPageExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StOperationInfo;
import NS_MINI_INTERFACE.INTERFACE.StSubPkgInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import berw;
import betc;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
  public static final Parcelable.Creator<MiniAppInfo> CREATOR = new berw();
  public static final String ENV_VERSION_DEVELOP = "develop";
  public static final String ENV_VERSION_RELEASE = "release";
  public static final String ENV_VERSION_TRIAL = "trial";
  public static final int FLAG_NEED_KILL = 2;
  public static final int FLAG_NEED_NEW_PROCESS = 1;
  public static final String TAG = "MiniAppInfo";
  public static final String TAG_DB = "miniapp-db";
  public static final int TYPE_MINI_APP = 0;
  public static final int TYPE_MINI_GAME = 1;
  public String appStoreAnimPicUrl;
  public BaseLibInfo baseLibInfo;
  public int clearAuths;
  public byte[] commonExt;
  public ArrayList<ExtConfigInfo> extConfigInfoList;
  public String extendData;
  public String extraData;
  public int forceReroad;
  public String friendMessageQuery = "";
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
  private int reportType;
  public long tinyId;
  public int topType;
  
  public MiniAppInfo() {}
  
  public MiniAppInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.topType = paramParcel.readInt();
    this.reportType = paramParcel.readInt();
    this.extraData = paramParcel.readString();
    this.recommend = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isSupportOffline = bool1;
      this.openId = paramParcel.readString();
      this.tinyId = paramParcel.readLong();
      this.position = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label258;
      }
    }
    label258:
    for (boolean bool1 = bool2;; bool1 = false)
    {
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
      this.launchParam.a(localLaunchParam);
      this.baseLibInfo = ((BaseLibInfo)paramParcel.readParcelable(BaseLibInfo.class.getClassLoader()));
      this.forceReroad = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  private MiniAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, long paramLong, List<INTERFACE.StSubPkgInfo> paramList, String paramString8, INTERFACE.StFirstPage paramStFirstPage, INTERFACE.StApiRightController paramStApiRightController, INTERFACE.StMDebugInfo paramStMDebugInfo, INTERFACE.StDomainConfig paramStDomainConfig, INTERFACE.StMainPageExtInfo paramStMainPageExtInfo, INTERFACE.StDeveloperInfo paramStDeveloperInfo, String paramString9, int paramInt4, Map<String, String> paramMap, INTERFACE.StAppMode paramStAppMode, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, String paramString10, String paramString11, int paramInt6, COMM.StCommonExt paramStCommonExt, List<INTERFACE.StExtConfigInfo> paramList1, INTERFACE.StAppBasicInfo paramStAppBasicInfo)
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
      this.firstPage.jdField_a_of_type_JavaLangString = paramStFirstPage.pagePath.get();
      this.firstPage.b = paramStFirstPage.subPkgName.get();
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
      this.debugInfo.jdField_a_of_type_JavaLangString = paramStMDebugInfo.roomId.get();
      this.debugInfo.b = paramStMDebugInfo.wsUrl.get();
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
    if (paramMap != null)
    {
      this.reportData = new HashMap();
      this.reportData.putAll(paramMap);
    }
    this.appMode = AppMode.a(paramStAppMode);
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
      paramString2 = paramList1.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = ExtConfigInfo.from((INTERFACE.StExtConfigInfo)paramString2.next());
        this.extConfigInfoList.add(paramString3);
      }
    }
    if (paramStAppBasicInfo != null)
    {
      betc.b("MiniAppInfo", "appid:" + paramString1 + ", usrFileSizeLimit:" + paramStAppBasicInfo.usrFileSizeLimit.get());
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
            this.preCacheList.add(new PreCacheInfo(paramString2.getDataUrl.get(), paramString2.preCacheKey.get(), paramString2.expireTime.get()));
          }
        }
      }
      this.versionUpdateTime = paramStAppBasicInfo.versionUpdateTime.get();
      if (!paramStAppBasicInfo.pkgType.has()) {
        break label1249;
      }
      if (paramStAppBasicInfo.pkgType.get() != 1) {
        break label1241;
      }
      this.engineType = 1;
    }
    for (;;)
    {
      this.noNeedRealRecommend = paramStAppBasicInfo.noNeedRealRecommend.get();
      this.miniGamePluginInfo = MiniGamePluginInfo.a(paramStAppBasicInfo.pluginInfo);
      this.renderInfo = RenderInfo.a(paramStAppBasicInfo.renderInfo);
      if (paramStAppBasicInfo.qualificationInfo != null) {
        this.qualifications = new ArrayList(paramStAppBasicInfo.qualificationInfo.get());
      }
      this.shareId = paramStAppBasicInfo.shareId.get();
      this.via = paramStAppBasicInfo.via.get();
      return;
      label1241:
      this.engineType = 0;
      continue;
      label1249:
      this.engineType = this.reportType;
    }
  }
  
  private static String a(INTERFACE.StApiAppInfo paramStApiAppInfo)
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
  
  private static Map<String, String> a(INTERFACE.StApiAppInfo paramStApiAppInfo)
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
            betc.d("MiniAppInfo", " parse reportData error.", paramStApiAppInfo);
          }
        }
      }
    }
  }
  
  private static boolean a(INTERFACE.StApiAppInfo paramStApiAppInfo)
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
    Object localObject = new FirstPageInfo();
    ((FirstPageInfo)localObject).a("");
    ((FirstPageInfo)localObject).b("");
    localMiniAppInfo.firstPage = ((FirstPageInfo)localObject);
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
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PreCacheInfo localPreCacheInfo = (PreCacheInfo)((Iterator)localObject).next();
        localMiniAppInfo.preCacheList.add(new PreCacheInfo(localPreCacheInfo.jdField_a_of_type_JavaLangString, localPreCacheInfo.b, localPreCacheInfo.jdField_a_of_type_Long));
      }
    }
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.miniGamePluginInfo = paramMiniAppInfo.miniGamePluginInfo;
    localMiniAppInfo.qualifications = paramMiniAppInfo.qualifications;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    return localMiniAppInfo;
  }
  
  public static MiniAppInfo createMiniAppInfo(JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramJSONObject == null) {
      return null;
    }
    MiniAppInfo localMiniAppInfo;
    label1425:
    for (;;)
    {
      try
      {
        localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = paramJSONObject.optString("appId");
        localMiniAppInfo.name = paramJSONObject.optString("appName");
        localMiniAppInfo.iconUrl = paramJSONObject.optString("icon");
        localMiniAppInfo.downloadUrl = paramJSONObject.optString("donwLoadUrl");
        localMiniAppInfo.version = paramJSONObject.optString("version");
        localMiniAppInfo.desc = paramJSONObject.optString("desc");
        localMiniAppInfo.verType = paramJSONObject.optInt("type");
        localMiniAppInfo.baselibMiniVersion = paramJSONObject.optString("baselibMiniVersion");
        localMiniAppInfo.subpkgs = new ArrayList();
        Object localObject1 = paramJSONObject.optJSONArray("subPkgs");
        int i;
        Object localObject2;
        Object localObject3;
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
            localObject3 = new SubPkgInfo();
            ((SubPkgInfo)localObject3).subPkgName = ((JSONObject)localObject2).optString("subPkgName");
            ((SubPkgInfo)localObject3).downloadUrl = ((JSONObject)localObject2).optString("dowLoadUrl");
            ((SubPkgInfo)localObject3).independent = ((JSONObject)localObject2).optInt("independent");
            ((SubPkgInfo)localObject3).fileSize = ((JSONObject)localObject2).optInt("file_size");
            localMiniAppInfo.subpkgs.add(localObject3);
            i += 1;
            continue;
          }
        }
        localMiniAppInfo.firstPage = new FirstPageInfo();
        localObject1 = paramJSONObject.optJSONObject("first");
        if (localObject1 != null)
        {
          localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("pagePath");
          localMiniAppInfo.firstPage.b = ((JSONObject)localObject1).optString("subPkgName");
        }
        if (paramJSONObject.optJSONObject("domain") != null)
        {
          if (paramJSONObject.optJSONObject("domain").optJSONArray("requestDomain") != null)
          {
            localMiniAppInfo.requestDomainList = new ArrayList();
            localObject1 = paramJSONObject.getJSONObject("domain").getJSONArray("requestDomain");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localMiniAppInfo.requestDomainList.add(((JSONArray)localObject1).optString(i));
              i += 1;
              continue;
            }
          }
          if (paramJSONObject.optJSONObject("domain").optJSONArray("socketDomain") != null)
          {
            localMiniAppInfo.socketDomainList = new ArrayList();
            localObject1 = paramJSONObject.optJSONObject("domain").optJSONArray("socketDomain");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localMiniAppInfo.socketDomainList.add(((JSONArray)localObject1).optString(i));
              i += 1;
              continue;
            }
          }
          if (paramJSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain") != null)
          {
            localMiniAppInfo.uploadFileDomainList = new ArrayList();
            localObject1 = paramJSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localMiniAppInfo.uploadFileDomainList.add(((JSONArray)localObject1).optString(i));
              i += 1;
              continue;
            }
          }
          if (paramJSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain") != null)
          {
            localMiniAppInfo.downloadFileDomainList = new ArrayList();
            localObject1 = paramJSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localMiniAppInfo.downloadFileDomainList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
          }
          if (paramJSONObject.optJSONObject("domain").optJSONArray("businessDomain") != null)
          {
            localMiniAppInfo.businessDomainList = new ArrayList();
            localObject1 = paramJSONObject.optJSONObject("domain").optJSONArray("businessDomain");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localMiniAppInfo.businessDomainList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
          }
          if (paramJSONObject.optJSONObject("domain").optJSONArray("udpIpList") != null)
          {
            localMiniAppInfo.udpIpList = new ArrayList();
            localObject1 = paramJSONObject.optJSONObject("domain").optJSONArray("udpIpList");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localMiniAppInfo.udpIpList.add(((JSONArray)localObject1).getString(i));
              i += 1;
              continue;
            }
          }
        }
        localMiniAppInfo.appType = paramJSONObject.optInt("appType");
        localMiniAppInfo.debugInfo = new DebugInfo();
        localObject1 = paramJSONObject.optJSONObject("mDebug");
        if (localObject1 != null)
        {
          localMiniAppInfo.debugInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("roomId");
          localMiniAppInfo.debugInfo.b = ((JSONObject)localObject1).optString("wsUrl");
        }
        localMiniAppInfo.versionId = paramJSONObject.optString("versionId");
        localObject1 = paramJSONObject.optJSONObject("apiRight");
        if (localObject1 != null)
        {
          if (((JSONObject)localObject1).optJSONArray("whiteLst") != null)
          {
            localMiniAppInfo.whiteList = new ArrayList();
            localObject2 = ((JSONObject)localObject1).optJSONArray("whiteLst");
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject3 = (String)((JSONArray)localObject2).get(i);
              localMiniAppInfo.whiteList.add(localObject3);
              i += 1;
              continue;
            }
          }
          if (((JSONObject)localObject1).optJSONArray("blackLst") != null)
          {
            localMiniAppInfo.blackList = new ArrayList();
            localObject2 = ((JSONObject)localObject1).optJSONArray("blackLst");
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject3 = (String)((JSONArray)localObject2).get(i);
              localMiniAppInfo.blackList.add(localObject3);
              i += 1;
              continue;
            }
          }
          if (((JSONObject)localObject1).optJSONArray("secondApiRights") != null)
          {
            localMiniAppInfo.secondApiRightInfoList = new ArrayList();
            localObject1 = ((JSONObject)localObject1).optJSONArray("secondApiRights");
            i = j;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
              localObject3 = new SecondApiRightInfo();
              ((SecondApiRightInfo)localObject3).apiName = ((JSONObject)localObject2).optString("apiName");
              ((SecondApiRightInfo)localObject3).secondName = ((JSONObject)localObject2).optString("secondName");
              ((SecondApiRightInfo)localObject3).right = ((JSONObject)localObject2).optInt("right");
              localMiniAppInfo.secondApiRightInfoList.add(localObject3);
              i += 1;
              continue;
            }
          }
        }
        if (paramJSONObject.optJSONObject("mainExt") != null) {
          localMiniAppInfo.fileSize = paramJSONObject.optJSONObject("mainExt").optInt("file_size");
        }
        if (paramJSONObject.optJSONObject("devInfo") != null) {
          localMiniAppInfo.developerDesc = paramJSONObject.optJSONObject("devInfo").optString("name");
        }
        if (paramJSONObject.optJSONObject("basicInfo") != null)
        {
          localObject1 = paramJSONObject.optJSONObject("basicInfo");
          localMiniAppInfo.usrFileSizeLimit = ((JSONObject)localObject1).optInt("usrFileSizeLimit");
          localMiniAppInfo.versionUpdateTime = ((JSONObject)localObject1).optInt("versionUpdateTime");
          localMiniAppInfo.noNeedRealRecommend = ((JSONObject)localObject1).optInt("noNeedRealRecommend");
          if (!((JSONObject)localObject1).has("pkgType")) {
            break label1425;
          }
          if (((JSONObject)localObject1).optInt("pkgType") == 1) {
            localMiniAppInfo.engineType = 1;
          }
        }
        else
        {
          if (paramJSONObject.optJSONObject("appMode") == null) {
            break;
          }
          localMiniAppInfo.appMode = new AppMode();
          paramJSONObject = paramJSONObject.optJSONObject("appMode");
          localMiniAppInfo.appMode.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("interMode");
          localMiniAppInfo.appMode.b = paramJSONObject.optBoolean("authoritySilent");
          localMiniAppInfo.appMode.c = paramJSONObject.optBoolean("keepOffPullList");
          localMiniAppInfo.appMode.d = paramJSONObject.optBoolean("closeTopRightCapsule");
          localMiniAppInfo.appMode.e = paramJSONObject.optBoolean("openNativeApi");
          localMiniAppInfo.appMode.f = paramJSONObject.optBoolean("hideAppSearch");
          localMiniAppInfo.appMode.g = paramJSONObject.optBoolean("isAppStore");
          localMiniAppInfo.appMode.h = paramJSONObject.optBoolean("isWangKa");
          localMiniAppInfo.appMode.i = paramJSONObject.optBoolean("interLoading");
          break;
        }
        localMiniAppInfo.engineType = 0;
        continue;
        localMiniAppInfo.engineType = localMiniAppInfo.appType;
      }
      catch (Throwable paramJSONObject)
      {
        betc.d("MiniAppInfo", "", paramJSONObject);
        return null;
      }
    }
    return localMiniAppInfo;
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
    Map localMap = a(paramStApiAppInfo);
    INTERFACE.StAppMode localStAppMode = (INTERFACE.StAppMode)paramStApiAppInfo.appMode.get();
    int m = paramStApiAppInfo.skipDomainCheck.get();
    boolean bool2 = a(paramStApiAppInfo);
    if (paramStApiAppInfo.supportOffline.get() == 1) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new MiniAppInfo(str1, str2, str3, str4, i, 0, j, str5, str6, str7, 0L, localList, str8, localStFirstPage, localStApiRightController, localStMDebugInfo, localStDomainConfig, localStMainPageExtInfo, localStDeveloperInfo, null, k, localMap, localStAppMode, m, bool2, bool1, a(paramStApiAppInfo), paramStApiAppInfo.extendData.get(), paramStApiAppInfo.appNoCacheExt.clearAuths.get(), paramStApiAppInfo.extInfo, paramStApiAppInfo.extConfig.get(), (INTERFACE.StAppBasicInfo)paramStApiAppInfo.basicInfo.get());
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
            break label209;
          }
          localObject1 = paramMap + "&" + URLEncoder.encode((String)((Map.Entry)localObject1).getKey()) + "=" + URLEncoder.encode((String)((Map.Entry)localObject1).getValue(), "UTF-8");
          paramMap = (Map<String, String>)localObject1;
          break label209;
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
      betc.d("MiniAppInfo", " getReportDataString error.", localException2);
      return paramMap;
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
  
  public static void saveMiniAppByIdEntity(String paramString, INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppByLinkEntity(String paramString1, int paramInt, String paramString2, INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppShowInfoEntity(INTERFACE.StApiAppInfo paramStApiAppInfo) {}
  
  public static void saveMiniAppShowInfoEntity(MiniAppInfo paramMiniAppInfo) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramMiniAppInfo == null) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if ((paramMiniAppInfo.isShortcutFakeApp()) || (paramMiniAppInfo.isFakeAppInfo())) {
          return equalObj(this.appId, paramMiniAppInfo.appId);
        }
        if (!isEngineTypeMiniGame()) {
          break;
        }
      } while ((equalObj(this.appId, paramMiniAppInfo.appId)) && (equalObj(Integer.valueOf(this.verType), Integer.valueOf(paramMiniAppInfo.verType))) && (equalObj(this.version, paramMiniAppInfo.version)));
      return false;
    } while ((equalObj(this.appId, paramMiniAppInfo.appId)) && (equalObj(Integer.valueOf(this.verType), Integer.valueOf(paramMiniAppInfo.verType))) && (equalObj(this.version, paramMiniAppInfo.version)) && (equalObj(this.firstPage, paramMiniAppInfo.firstPage)));
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
    return this.appMode.g;
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
    return this.launchParam.jdField_a_of_type_Boolean;
  }
  
  public boolean isLimitedAccessApp()
  {
    return (this.appMode != null) && (this.appMode.j);
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
    return (this.launchParam != null) && (this.launchParam.jdField_a_of_type_Int == 1023) && (TextUtils.isEmpty(this.downloadUrl));
  }
  
  public boolean isSpecialMiniApp()
  {
    return isAppStoreMiniApp();
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
    return "MiniAppInfo{appId='" + this.appId + '\'' + ", name='" + this.name + '\'';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.topType);
    paramParcel.writeInt(this.reportType);
    paramParcel.writeString(this.extraData);
    paramParcel.writeInt(this.recommend);
    if (this.isSupportOffline)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.openId);
      paramParcel.writeLong(this.tinyId);
      paramParcel.writeInt(this.position);
      if (!this.isSupportBlueBar) {
        break label199;
      }
    }
    label199:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
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
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */