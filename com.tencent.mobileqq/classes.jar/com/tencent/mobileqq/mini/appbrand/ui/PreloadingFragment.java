package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class PreloadingFragment
  extends PublicBaseFragment
{
  public static final String KEY_APPID = "mini_appid";
  public static final String KEY_ENTRY_PATH = "mini_entryPath";
  public static final String KEY_ENV_VERSION = "mini_envVersion";
  public static final String KEY_LAUNCH_PARAM = "mini_launch_param";
  public static final String KEY_LINK = "mini_link";
  public static final String KEY_LINK_TYPE = "mini_link_type";
  public static final String KEY_RESULT_RECEIVER = "mini_receiver";
  private static final String TAG = "PreloadingFragment";
  private static final boolean mEnableDBCache;
  private static LruCache<String, PreloadingFragment.MiniAppConfigCache> sMiniAppConfigCache = new LruCache(10);
  private Bundle mBundle;
  private LinearLayout mLoadingView = (LinearLayout)this.mRootView.findViewById(2131437648);
  private ResultReceiver mResultReceiver;
  private View mRootView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131625349, null);
  private Handler mUIHandler;
  
  static
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqminiapp", "mini_app_enable_db_cache", 0) == 1) {
      bool = true;
    }
    mEnableDBCache = bool;
  }
  
  public static void addAppConfigCache(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      if (TextUtils.isEmpty(paramMiniAppConfig.config.appId)) {
        return;
      }
      PreloadingFragment.MiniAppConfigCache localMiniAppConfigCache = new PreloadingFragment.MiniAppConfigCache();
      localMiniAppConfigCache.miniAppConfig = paramMiniAppConfig;
      localMiniAppConfigCache.timestamp = System.currentTimeMillis();
      sMiniAppConfigCache.put(paramMiniAppConfig.config.appId, localMiniAppConfigCache);
    }
  }
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_enable_db_appinfo_cache", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (mEnableDBCache) {
      i = 0;
    }
    if ((mEnableDBCache) && (startMiniAppFromIdDB(paramString1, paramString2, paramString3, paramLaunchParam)))
    {
      quit();
      return;
    }
    if ((i != 0) && (startMiniAppFromAppInfoIdDB(paramString1, paramString2, paramString3, paramLaunchParam)))
    {
      quit();
      return;
    }
    if ((mEnableDBCache) || (i != 0))
    {
      localObject1 = getShowInfoFromDB(paramString1, null, 0, paramString2, paramLaunchParam);
      if (localObject1 != null)
      {
        paramString2 = new StringBuilder();
        paramString2.append("start by showinfo ");
        paramString2.append(paramString1);
        QLog.d("miniapp-db", 1, paramString2.toString());
        MiniAppController.startApp(getBaseActivity(), (MiniAppConfig)localObject1, this.mResultReceiver);
        MiniReportManager.reportEventType((MiniAppConfig)localObject1, 1028, "show_cache", MiniReportManager.getAppType((MiniAppConfig)localObject1));
        quit();
        return;
      }
    }
    ThreadManagerV2.getUIHandlerV2().post(new PreloadingFragment.2(this));
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    if (paramLaunchParam != null)
    {
      localObject1 = localObject3;
      if (paramLaunchParam.privateExtraData != null) {
        try
        {
          localObject1 = new JSONObject(paramLaunchParam.privateExtraData).optJSONObject("functionalPage").optJSONObject("originAccountInfo").optString("appId");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
        }
      }
    }
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, localObject2, new PreloadingFragment.3(this, paramLaunchParam));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_enable_db_appinfo_cache", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_enable_fake_appinfo", 0) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (mEnableDBCache) {
      i = 0;
    }
    if (mEnableDBCache)
    {
      if (startMiniAppFromLinkDB(paramString1, paramInt, paramString2, paramLaunchParam))
      {
        quit();
        return;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (MiniAppEntityManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
        if (localObject1 != null)
        {
          localObject1 = ((MiniAppEntityManager)localObject1).queryEntity(MiniAppByLinkEntity.class, false, "link=? and linkType=? ", new String[] { paramString1, String.valueOf(paramInt) }, null, null, null, null);
          if ((localObject1 != null) && (((List)localObject1).size() == 1))
          {
            localObject1 = (MiniAppByLinkEntity)((List)localObject1).get(0);
            if (localObject1 != null)
            {
              localObject1 = ((MiniAppByLinkEntity)localObject1).appId;
              localObject2 = getShowInfoFromDB((String)localObject1, paramString1, paramInt, null, paramLaunchParam);
              if (localObject2 != null)
              {
                paramString1 = new StringBuilder();
                paramString1.append("start by showinfo ");
                paramString1.append((String)localObject1);
                QLog.d("miniapp-db", 1, paramString1.toString());
                MiniAppController.startApp(getBaseActivity(), (MiniAppConfig)localObject2, this.mResultReceiver);
                MiniReportManager.reportEventType((MiniAppConfig)localObject2, 1028, "show_cache", MiniReportManager.getAppType((MiniAppConfig)localObject2));
                quit();
                return;
              }
            }
          }
        }
      }
      if ((j == 0) || (!MiniAppLauncher.isMiniAppSchemeV2(paramString1))) {}
    }
    try
    {
      localObject2 = (String)URLUtil.a(paramString1).get("_mappid");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("scheme: appid:  ");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception localException1)
    {
      Object localObject3;
      label453:
      label456:
      break label456;
    }
    try
    {
      QLog.d("PreloadingFragment", 4, (String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "PreloadingFragment";
      }
    }
    catch (Exception localException2)
    {
      break label453;
    }
    try
    {
      localObject3 = getShowInfoFromDB((String)localObject2, paramString1, paramInt, "", paramLaunchParam);
      if (localObject3 == null) {
        break label510;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start by showinfo ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("miniapp-db", 1, ((StringBuilder)localObject1).toString());
      MiniAppController.startApp(getBaseActivity(), (MiniAppConfig)localObject3, this.mResultReceiver);
      MiniReportManager.reportEventType((MiniAppConfig)localObject3, 1028, "show_cache", MiniReportManager.getAppType((MiniAppConfig)localObject3));
      quit();
      return;
    }
    catch (Exception localException3)
    {
      break label456;
    }
    Object localObject1 = "PreloadingFragment";
    break label510;
    localObject1 = "PreloadingFragment";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start without appinfo fail, link: ");
    ((StringBuilder)localObject2).append(paramString1);
    QLog.e((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    break label510;
    localObject1 = "PreloadingFragment";
    break label510;
    localObject1 = "PreloadingFragment";
    label510:
    if (i != 0)
    {
      if (startMiniAppFromAppInfoLinkDB(paramString1, paramInt, paramString2, paramLaunchParam))
      {
        quit();
        return;
      }
      if ((j == 0) || (!MiniAppLauncher.isMiniAppSchemeV2(paramString1))) {}
    }
    try
    {
      paramString2 = (String)URLUtil.a(paramString1).get("_mappid");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("scheme: appid:  ");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty(paramString2)) {
        break label722;
      }
      localObject2 = getShowInfoFromDB(paramString2, paramString1, paramInt, "", paramLaunchParam);
      if (localObject2 == null) {
        break label722;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start by showinfo ");
      ((StringBuilder)localObject3).append(paramString2);
      QLog.d("miniapp-db", 1, ((StringBuilder)localObject3).toString());
      MiniAppController.startApp(getBaseActivity(), (MiniAppConfig)localObject2, this.mResultReceiver);
      MiniReportManager.reportEventType((MiniAppConfig)localObject2, 1028, "show_cache", MiniReportManager.getAppType((MiniAppConfig)localObject2));
      quit();
      return;
    }
    catch (Exception paramString2)
    {
      label690:
      label722:
      break label690;
    }
    paramString2 = new StringBuilder();
    paramString2.append("start without appinfo fail, link: ");
    paramString2.append(paramString1);
    QLog.e((String)localObject1, 4, paramString2.toString());
    ThreadManagerV2.getUIHandlerV2().post(new PreloadingFragment.6(this));
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new PreloadingFragment.7(this, paramLaunchParam));
  }
  
  private void doStartMiniApp(MiniAppConfig paramMiniAppConfig)
  {
    try
    {
      if (!isMiniAppInfoValid(paramMiniAppConfig))
      {
        ThreadManager.getUIHandler().post(new PreloadingFragment.11(this));
        return;
      }
      MiniAppController.startApp(getBaseActivity(), paramMiniAppConfig, null);
      return;
    }
    catch (Throwable paramMiniAppConfig)
    {
      QLog.e("miniapp", 1, "startAppByAppid exception! ", paramMiniAppConfig);
    }
  }
  
  private void doTask()
  {
    QLog.i("miniapp-start", 1, "LoadingFragment doTask");
    Object localObject = getArguments();
    if (localObject == null)
    {
      quit();
      return;
    }
    ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
    this.mResultReceiver = ((ResultReceiver)((Bundle)localObject).getParcelable("mini_receiver"));
    String str1 = ((Bundle)localObject).getString("mini_appid");
    LaunchParam localLaunchParam = (LaunchParam)((Bundle)localObject).getParcelable("mini_launch_param");
    String str2 = ((Bundle)localObject).getString("mini_envVersion");
    String str3 = ((Bundle)localObject).getString("mini_link");
    int i = ((Bundle)localObject).getInt("mini_link_type");
    localObject = ((Bundle)localObject).getString("mini_entryPath");
    if (!TextUtils.isEmpty(str1))
    {
      doRequestByAppid(str1, (String)localObject, str2, localLaunchParam);
      return;
    }
    if (!TextUtils.isEmpty(str3))
    {
      doRequestByLink(str3, i, str2, localLaunchParam);
      return;
    }
    quit();
  }
  
  public static MiniAppConfig findAppConfigFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PreloadingFragment.MiniAppConfigCache localMiniAppConfigCache = (PreloadingFragment.MiniAppConfigCache)sMiniAppConfigCache.get(paramString);
    if ((localMiniAppConfigCache != null) && (localMiniAppConfigCache.miniAppConfig != null))
    {
      long l = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_appconfig_cache_time", 1);
      if (System.currentTimeMillis() - localMiniAppConfigCache.timestamp > l)
      {
        sMiniAppConfigCache.remove(paramString);
        return null;
      }
      return localMiniAppConfigCache.miniAppConfig;
    }
    sMiniAppConfigCache.remove(paramString);
    return null;
  }
  
  private MiniAppConfig getShowInfoFromDB(String paramString1, String paramString2, int paramInt, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppInfo localMiniAppInfo = null;
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (MiniAppEntityManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
        if (localObject != null)
        {
          paramString1 = ((MiniAppEntityManager)localObject).queryEntity(MiniAppShowInfoEntity.class, false, "appId=? ", new String[] { paramString1 }, null, null, null, null);
          if ((paramString1 != null) && (paramString1.size() == 1))
          {
            paramString1 = (MiniAppShowInfoEntity)paramString1.get(0);
            localObject = paramString1.appId;
            String str1 = paramString1.appName;
            String str2 = paramString1.icon;
            String str3 = paramString1.desc;
            String str4 = paramString1.gameCopyrightInfo;
            String str5 = paramString1.gamePublicationNumber;
            String str6 = paramString1.gamePublicationCompany;
            String str7 = paramString1.gameApprovalNumber;
            String str8 = paramString1.gameOperatingCompany;
            int i = paramString1.reportType;
            int j = paramString1.engineType;
            paramString1 = localMiniAppInfo;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramString1 = localMiniAppInfo;
              if (!TextUtils.isEmpty(str1))
              {
                paramString1 = localMiniAppInfo;
                if (!TextUtils.isEmpty(str2))
                {
                  localMiniAppInfo = new MiniAppInfo();
                  localMiniAppInfo.appId = ((String)localObject);
                  localMiniAppInfo.name = str1;
                  localMiniAppInfo.iconUrl = str2;
                  localMiniAppInfo.setReportType(i);
                  localMiniAppInfo.setEngineType(j);
                  localMiniAppInfo.developerDesc = str3;
                  localMiniAppInfo.gameCopyrightInfo = str4;
                  localMiniAppInfo.gamePublicationNumber = str5;
                  localMiniAppInfo.gamePublicationCompany = str6;
                  localMiniAppInfo.gameApprovalNumber = str7;
                  localMiniAppInfo.gameOperatingCompany = str8;
                  paramString1 = new MiniAppConfig(localMiniAppInfo);
                  paramString1.launchParam = paramLaunchParam;
                  paramString1.isFromShowInfo = true;
                  paramString1.link = paramString2;
                  paramString1.linkType = paramInt;
                  paramString1.entryPath = paramString3;
                  localMiniAppInfo.verType = MiniAppInfo.getVerType(paramLaunchParam.envVersion);
                }
              }
            }
            return paramString1;
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("miniapp-db", 1, "getShowInfoFromDB error, ", paramString1);
    }
    return null;
  }
  
  private boolean isMiniAppInfoValid(MiniAppConfig paramMiniAppConfig)
  {
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (!TextUtils.isEmpty(paramMiniAppConfig.config.downloadUrl));
  }
  
  private void launchMiniAppByAppInfoCache(MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam)
  {
    if (paramMiniAppInfo != null)
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
      if (paramLaunchParam == null)
      {
        localMiniAppConfig.launchParam = new LaunchParam();
      }
      else
      {
        localMiniAppConfig.launchParam = paramLaunchParam;
        localMiniAppConfig.launchParam.miniAppId = paramMiniAppInfo.appId;
      }
      localMiniAppConfig.launchParam.navigateExtData = paramMiniAppInfo.extraData;
      if (TextUtils.isEmpty(localMiniAppConfig.launchParam.reportData))
      {
        localMiniAppConfig.launchParam.reportData = paramMiniAppInfo.reportData;
      }
      else if (!TextUtils.isEmpty(paramMiniAppInfo.reportData))
      {
        paramLaunchParam = localMiniAppConfig.launchParam;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMiniAppConfig.launchParam.reportData);
        localStringBuilder.append("&");
        localStringBuilder.append(paramMiniAppInfo.reportData);
        paramLaunchParam.reportData = localStringBuilder.toString();
      }
      addAppConfigCache(localMiniAppConfig);
      if ((paramMiniAppInfo.verType != 3) && (paramMiniAppInfo.verType != 1)) {
        localMiniAppConfig.launchParam.forceReload = 3;
      }
      doStartMiniApp(localMiniAppConfig);
      paramMiniAppInfo = this.mResultReceiver;
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.send(0, new Bundle());
      }
    }
    quit();
  }
  
  private void quit()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localBaseActivity.finish();
    }
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new PreloadingFragment.10(this, paramString));
  }
  
  private boolean startMiniAppFromAppInfoIdDB(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    if (!TextUtils.isEmpty(paramString3)) {
      if (!"release".equals(paramString3)) {
        break label329;
      }
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        boolean bool = localObject instanceof QQAppInterface;
        if (bool)
        {
          localObject = (MiniAppEntityManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
          if (localObject != null)
          {
            QLog.d("miniapp-db", 1, "query appInfo startAppByAppid start.");
            if (paramString2 == null) {
              paramString2 = "";
            }
            localObject = ((MiniAppEntityManager)localObject).queryEntity(MiniAppInfoByIdEntity.class, false, "appId=? and entryPath=? ", new String[] { paramString1, paramString2 }, null, null, null, null);
            if ((localObject != null) && (((List)localObject).size() == 1))
            {
              localObject = (MiniAppInfoByIdEntity)((List)localObject).get(0);
              if (localObject != null)
              {
                MiniAppInfo localMiniAppInfo = MiniAppInfo.getMiniAppInfoByIdFromDB((MiniAppInfoByIdEntity)localObject);
                if (localMiniAppInfo != null)
                {
                  if (paramLaunchParam != null) {
                    break label331;
                  }
                  localObject = new LaunchParam();
                  if ((paramLaunchParam != null) && (!TextUtils.isEmpty(paramLaunchParam.extendData))) {
                    localMiniAppInfo.extendData = paramLaunchParam.extendData;
                  }
                  QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Id DB.");
                  MiniAppController.launchMiniAppByAppInfo(getBaseActivity(), localMiniAppInfo, (LaunchParam)localObject);
                  if (this.mResultReceiver != null)
                  {
                    paramLaunchParam = new Bundle();
                    paramLaunchParam.putLong("retCode", 0L);
                    paramLaunchParam.putString("errMsg", "");
                    this.mResultReceiver.send(0, paramLaunchParam);
                  }
                  MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new PreloadingFragment.5(this));
                  paramString1 = new MiniAppConfig(localMiniAppInfo);
                  MiniReportManager.reportEventType(paramString1, 1028, "idinfo_cache", MiniReportManager.getAppType(paramString1));
                  return true;
                }
              }
            }
          }
        }
        else
        {
          QLog.e("miniapp-db", 1, "not QQAppInterface");
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("PreloadingFragment", 1, "startMiniAppFromAppInfoIdDB getLinkInfo from db error,", paramString1);
      }
      label329:
      return false;
      label331:
      Object localObject = paramLaunchParam;
    }
  }
  
  private boolean startMiniAppFromAppInfoLinkDB(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    for (;;)
    {
      try
      {
        paramString2 = BaseApplicationImpl.getApplication().getRuntime();
        boolean bool = paramString2 instanceof QQAppInterface;
        if (bool)
        {
          paramString2 = (MiniAppEntityManager)paramString2.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
          if (paramString2 != null)
          {
            QLog.d("miniapp-db", 1, "query linkEntityList start.");
            paramString2 = paramString2.queryEntity(MiniAppInfoByLinkEntity.class, false, "link=? and linkType=? ", new String[] { paramString1, String.valueOf(paramInt) }, null, null, null, null);
            if ((paramString2 != null) && (paramString2.size() == 1))
            {
              MiniAppInfoByLinkEntity localMiniAppInfoByLinkEntity = (MiniAppInfoByLinkEntity)paramString2.get(0);
              if (localMiniAppInfoByLinkEntity != null)
              {
                MiniAppInfo localMiniAppInfo = MiniAppInfo.getMiniAppInfoByLinkFromDB(localMiniAppInfoByLinkEntity);
                if (localMiniAppInfo != null)
                {
                  if (paramLaunchParam != null) {
                    break label294;
                  }
                  paramString2 = new LaunchParam();
                  paramString2.shareTicket = localMiniAppInfoByLinkEntity.shareTicket;
                  paramString2.navigateExtData = localMiniAppInfo.extraData;
                  if (!TextUtils.isEmpty(paramString2.shareTicket)) {
                    paramString2.scene = 1044;
                  }
                  QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Link DB.");
                  MiniAppController.launchMiniAppByAppInfo(getBaseActivity(), localMiniAppInfo, paramString2);
                  if (this.mResultReceiver != null)
                  {
                    paramString2 = new Bundle();
                    paramString2.putLong("retCode", 0L);
                    paramString2.putString("errMsg", "");
                    this.mResultReceiver.send(0, paramString2);
                  }
                  MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new PreloadingFragment.9(this));
                  paramString1 = new MiniAppConfig(localMiniAppInfo);
                  MiniReportManager.reportEventType(paramString1, 1028, "linkinfo_cache", MiniReportManager.getAppType(paramString1));
                  return true;
                }
              }
            }
          }
        }
        else
        {
          QLog.e("miniapp-db", 1, "not QQAppInterface");
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("PreloadingFragment", 1, "getLinkInfo from db error,", paramString1);
      }
      return false;
      label294:
      paramString2 = paramLaunchParam;
    }
  }
  
  private boolean startMiniAppFromIdDB(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    if (!TextUtils.isEmpty(paramString3)) {
      if (!"release".equals(paramString3)) {
        break label386;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        boolean bool = localObject1 instanceof QQAppInterface;
        if (bool)
        {
          localObject1 = (MiniAppEntityManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
          if (localObject1 != null)
          {
            QLog.d("miniapp-db", 1, "query startAppByAppid start.");
            if (paramString2 == null) {
              paramString2 = "";
            }
            Object localObject2 = ((MiniAppEntityManager)localObject1).queryEntity(MiniAppByIdEntity.class, false, "appId=? and entryPath=? ", new String[] { paramString1, paramString2 }, null, null, null, null);
            localObject1 = ((MiniAppEntityManager)localObject1).queryEntity(MiniAppInfoEntity.class, false, "appId=? ", new String[] { paramString1 }, null, null, null, null);
            if ((localObject2 != null) && (((List)localObject2).size() == 1) && (localObject1 != null) && (((List)localObject1).size() == 1))
            {
              localObject2 = (MiniAppByIdEntity)((List)localObject2).get(0);
              localObject1 = (MiniAppInfoEntity)((List)localObject1).get(0);
              if (localObject2 != null)
              {
                localObject2 = MiniAppInfo.getMiniAppInfoByIdFromDB((MiniAppByIdEntity)localObject2, (MiniAppInfoEntity)localObject1);
                if (localObject2 != null)
                {
                  if (paramLaunchParam != null) {
                    break label388;
                  }
                  localObject1 = new LaunchParam();
                  if ((paramLaunchParam != null) && (!TextUtils.isEmpty(paramLaunchParam.extendData))) {
                    ((MiniAppInfo)localObject2).extendData = paramLaunchParam.extendData;
                  }
                  QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Id DB.");
                  MiniAppController.launchMiniAppByAppInfo(getBaseActivity(), (MiniAppInfo)localObject2, (LaunchParam)localObject1);
                  if (this.mResultReceiver != null)
                  {
                    paramLaunchParam = new Bundle();
                    paramLaunchParam.putLong("retCode", 0L);
                    paramLaunchParam.putString("errMsg", "");
                    this.mResultReceiver.send(0, paramLaunchParam);
                  }
                  MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new PreloadingFragment.4(this));
                  paramString1 = new MiniAppConfig((MiniAppInfo)localObject2);
                  MiniReportManager.reportEventType(paramString1, 1028, "id_cache", MiniReportManager.getAppType(paramString1));
                  return true;
                }
              }
            }
          }
        }
        else
        {
          QLog.e("miniapp-db", 1, "not QQAppInterface");
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("PreloadingFragment", 1, "getLinkInfo from db error,", paramString1);
      }
      label386:
      return false;
      label388:
      Object localObject1 = paramLaunchParam;
    }
  }
  
  @Deprecated
  private boolean startMiniAppFromLinkDB(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    for (;;)
    {
      try
      {
        paramString2 = BaseApplicationImpl.getApplication().getRuntime();
        boolean bool = paramString2 instanceof QQAppInterface;
        if (bool)
        {
          paramString2 = (MiniAppEntityManager)paramString2.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
          if (paramString2 != null)
          {
            QLog.d("miniapp-db", 1, "query linkEntityList start.");
            Object localObject = paramString2.queryEntity(MiniAppByLinkEntity.class, false, "link=? and linkType=? ", new String[] { paramString1, String.valueOf(paramInt) }, null, null, null, null);
            if ((localObject != null) && (((List)localObject).size() == 1))
            {
              localObject = (MiniAppByLinkEntity)((List)localObject).get(0);
              if (localObject != null)
              {
                paramString2 = paramString2.queryEntity(MiniAppInfoEntity.class, false, "appId=? ", new String[] { ((MiniAppByLinkEntity)localObject).appId }, null, null, null, null);
                if ((paramString2 != null) && (paramString2.size() == 1))
                {
                  MiniAppInfo localMiniAppInfo = MiniAppInfo.getMiniAppInfoByLinkFromDB((MiniAppByLinkEntity)localObject, (MiniAppInfoEntity)paramString2.get(0));
                  if (localMiniAppInfo != null)
                  {
                    if (paramLaunchParam != null) {
                      break label350;
                    }
                    paramString2 = new LaunchParam();
                    paramString2.shareTicket = ((MiniAppByLinkEntity)localObject).shareTicket;
                    paramString2.navigateExtData = localMiniAppInfo.extraData;
                    if (!TextUtils.isEmpty(paramString2.shareTicket)) {
                      paramString2.scene = 1044;
                    }
                    QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Link DB.");
                    MiniAppController.launchMiniAppByAppInfo(getBaseActivity(), localMiniAppInfo, paramString2);
                    if (this.mResultReceiver != null)
                    {
                      paramString2 = new Bundle();
                      paramString2.putLong("retCode", 0L);
                      paramString2.putString("errMsg", "");
                      this.mResultReceiver.send(0, paramString2);
                    }
                    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new PreloadingFragment.8(this));
                    paramString1 = new MiniAppConfig(localMiniAppInfo);
                    MiniReportManager.reportEventType(paramString1, 1028, "link_cache", MiniReportManager.getAppType(paramString1));
                    return true;
                  }
                }
              }
            }
          }
        }
        else
        {
          QLog.e("miniapp-db", 1, "not QQAppInterface");
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("PreloadingFragment", 1, "getLinkInfo from db error,", paramString1);
      }
      return false;
      label350:
      paramString2 = paramLaunchParam;
    }
  }
  
  public Bundle getArgumentBundle()
  {
    return this.mBundle;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("miniapp-start", 1, "LoadingFragment onCreate");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("miniapp-start", 1, "LoadingFragment onCreateView");
    if (this.mRootView == null)
    {
      this.mRootView = LayoutInflater.from(getBaseActivity()).inflate(2131625349, null);
      this.mLoadingView = ((LinearLayout)this.mRootView.findViewById(2131437648));
    }
    return this.mRootView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("miniapp-start", 1, "LoadingFragment onDestroy...");
  }
  
  public void onResume()
  {
    super.onResume();
    ThreadManagerV2.excute(new PreloadingFragment.1(this), 16, null, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QLog.i("miniapp-start", 1, "LoadingFragment onViewCreated");
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public void setArgumentBundle(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment
 * JD-Core Version:    0.7.0.1
 */