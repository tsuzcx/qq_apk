package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import bfng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

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
  private static LruCache<String, PreloadingFragment.MiniAppConfigCache> sMiniAppConfigCache;
  private Bundle mBundle;
  private LinearLayout mLoadingView = (LinearLayout)this.mRootView.findViewById(2131369501);
  private ResultReceiver mResultReceiver;
  private View mRootView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559265, null);
  private Handler mUIHandler;
  
  static
  {
    boolean bool = true;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_enable_db_cache", 1) == 1) {}
    for (;;)
    {
      mEnableDBCache = bool;
      sMiniAppConfigCache = new LruCache(10);
      return;
      bool = false;
    }
  }
  
  public static void addAppConfigCache(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId))) {
      return;
    }
    PreloadingFragment.MiniAppConfigCache localMiniAppConfigCache = new PreloadingFragment.MiniAppConfigCache();
    localMiniAppConfigCache.miniAppConfig = paramMiniAppConfig;
    localMiniAppConfigCache.timestamp = System.currentTimeMillis();
    sMiniAppConfigCache.put(paramMiniAppConfig.config.appId, localMiniAppConfigCache);
  }
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    if (mEnableDBCache)
    {
      if (startMiniAppFromIdDB(paramString1, paramString2, paramString3, paramLaunchParam))
      {
        quit();
        return;
      }
      MiniAppConfig localMiniAppConfig = getShowInfoFromDB(paramString1, null, 0, paramString2, paramLaunchParam);
      if (localMiniAppConfig != null)
      {
        QLog.d("miniapp-db", 1, "start by showinfo " + paramString1);
        MiniAppController.startApp(getActivity(), localMiniAppConfig, this.mResultReceiver);
        MiniReportManager.reportEventType(localMiniAppConfig, 1028, "show_cache", MiniReportManager.getAppType(localMiniAppConfig));
        quit();
        return;
      }
    }
    getActivity().runOnUiThread(new PreloadingFragment.2(this));
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new PreloadingFragment.3(this, paramLaunchParam));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    if (mEnableDBCache)
    {
      if (startMiniAppFromLinkDB(paramString1, paramInt, paramString2, paramLaunchParam))
      {
        quit();
        return;
      }
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString2 instanceof QQAppInterface))
      {
        paramString2 = (MiniAppEntityManager)paramString2.getManager(330);
        if (paramString2 != null)
        {
          paramString2 = paramString2.queryEntity(MiniAppByLinkEntity.class, false, "link=? and linkType=? ", new String[] { paramString1, String.valueOf(paramInt) }, null, null, null, null);
          if ((paramString2 != null) && (paramString2.size() == 1))
          {
            paramString2 = (MiniAppByLinkEntity)paramString2.get(0);
            if (paramString2 != null)
            {
              paramString2 = paramString2.appId;
              MiniAppConfig localMiniAppConfig = getShowInfoFromDB(paramString2, paramString1, paramInt, null, paramLaunchParam);
              if (localMiniAppConfig != null)
              {
                QLog.d("miniapp-db", 1, "start by showinfo " + paramString2);
                MiniAppController.startApp(getActivity(), localMiniAppConfig, this.mResultReceiver);
                MiniReportManager.reportEventType(localMiniAppConfig, 1028, "show_cache", MiniReportManager.getAppType(localMiniAppConfig));
                quit();
                return;
              }
            }
          }
        }
      }
      if (MiniAppLauncher.isMiniAppSchemeV2(paramString1)) {
        try
        {
          paramString2 = (String)bfng.a(paramString1).get("_mappid");
          QLog.d("PreloadingFragment", 4, "scheme: appid:  " + paramString2);
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString2 = getShowInfoFromDB(paramString2, paramString1, paramInt, "", paramLaunchParam);
            if (paramString2 != null)
            {
              MiniAppController.startApp(getActivity(), paramString2, this.mResultReceiver);
              MiniReportManager.reportEventType(paramString2, 1028, "show_cache", MiniReportManager.getAppType(paramString2));
              quit();
              return;
            }
          }
        }
        catch (Exception paramString2)
        {
          QLog.e("PreloadingFragment", 4, "start without appinfo fail, link: " + paramString1);
        }
      }
    }
    ThreadManagerV2.getUIHandlerV2().post(new PreloadingFragment.5(this));
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new PreloadingFragment.6(this, paramLaunchParam));
  }
  
  private void doStartMiniApp(MiniAppConfig paramMiniAppConfig)
  {
    try
    {
      if (!isMiniAppInfoValid(paramMiniAppConfig))
      {
        ThreadManager.getUIHandler().post(new PreloadingFragment.9(this));
        return;
      }
      MiniAppController.startApp(getActivity(), paramMiniAppConfig, null);
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
    if ((localMiniAppConfigCache == null) || (localMiniAppConfigCache.miniAppConfig == null))
    {
      sMiniAppConfigCache.remove(paramString);
      return null;
    }
    long l = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_appconfig_cache_time", 1);
    if (System.currentTimeMillis() - localMiniAppConfigCache.timestamp > l)
    {
      sMiniAppConfigCache.remove(paramString);
      return null;
    }
    return localMiniAppConfigCache.miniAppConfig;
  }
  
  private MiniAppConfig getShowInfoFromDB(String paramString1, String paramString2, int paramInt, String paramString3, LaunchParam paramLaunchParam)
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (MiniAppEntityManager)((AppRuntime)localObject1).getManager(330);
        if (localObject1 != null)
        {
          paramString1 = ((MiniAppEntityManager)localObject1).queryEntity(MiniAppShowInfoEntity.class, false, "appId=? ", new String[] { paramString1 }, null, null, null, null);
          if ((paramString1 != null) && (paramString1.size() == 1))
          {
            Object localObject2 = (MiniAppShowInfoEntity)paramString1.get(0);
            paramString1 = ((MiniAppShowInfoEntity)localObject2).appId;
            localObject1 = ((MiniAppShowInfoEntity)localObject2).appName;
            String str1 = ((MiniAppShowInfoEntity)localObject2).icon;
            String str2 = ((MiniAppShowInfoEntity)localObject2).desc;
            int i = ((MiniAppShowInfoEntity)localObject2).reportType;
            int j = ((MiniAppShowInfoEntity)localObject2).engineType;
            if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {
              break label264;
            }
            localObject2 = new MiniAppInfo();
            ((MiniAppInfo)localObject2).appId = paramString1;
            ((MiniAppInfo)localObject2).name = ((String)localObject1);
            ((MiniAppInfo)localObject2).iconUrl = str1;
            ((MiniAppInfo)localObject2).setReportType(i);
            ((MiniAppInfo)localObject2).setEngineType(j);
            ((MiniAppInfo)localObject2).developerDesc = str2;
            paramString1 = new MiniAppConfig((MiniAppInfo)localObject2);
            paramString1.launchParam = paramLaunchParam;
            paramString1.isFromShowInfo = true;
            paramString1.link = paramString2;
            paramString1.linkType = paramInt;
            paramString1.entryPath = paramString3;
            ((MiniAppInfo)localObject2).verType = MiniAppInfo.getVerType(paramLaunchParam.envVersion);
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
    label264:
    return null;
  }
  
  private boolean isMiniAppInfoValid(MiniAppConfig paramMiniAppConfig)
  {
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (!TextUtils.isEmpty(paramMiniAppConfig.config.downloadUrl));
  }
  
  private void launchMiniAppByAppInfoCache(MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam)
  {
    MiniAppConfig localMiniAppConfig;
    if (paramMiniAppInfo != null)
    {
      localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
      if (paramLaunchParam != null) {
        break label143;
      }
      localMiniAppConfig.launchParam = new LaunchParam();
    }
    for (;;)
    {
      localMiniAppConfig.launchParam.navigateExtData = paramMiniAppInfo.extraData;
      if (localMiniAppConfig.launchParam.reportData == null) {
        localMiniAppConfig.launchParam.reportData = new HashMap();
      }
      if (paramMiniAppInfo.reportData != null) {
        localMiniAppConfig.launchParam.reportData.putAll(paramMiniAppInfo.reportData);
      }
      addAppConfigCache(localMiniAppConfig);
      if ((paramMiniAppInfo.verType != 3) && (paramMiniAppInfo.verType != 1)) {
        localMiniAppConfig.forceReroad = 3;
      }
      doStartMiniApp(localMiniAppConfig);
      if (this.mResultReceiver != null) {
        this.mResultReceiver.send(0, new Bundle());
      }
      quit();
      return;
      label143:
      localMiniAppConfig.launchParam = paramLaunchParam;
      localMiniAppConfig.launchParam.miniAppId = paramMiniAppInfo.appId;
    }
  }
  
  private void quit()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localFragmentActivity.finish();
    }
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new PreloadingFragment.8(this, paramString));
  }
  
  private boolean startMiniAppFromIdDB(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    if ((TextUtils.isEmpty(paramString3)) || ("release".equals(paramString3))) {}
    try
    {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject1 instanceof QQAppInterface)) {
        break label348;
      }
      localObject2 = (MiniAppEntityManager)((AppRuntime)localObject1).getManager(330);
      if (localObject2 == null) {
        break label357;
      }
      QLog.d("miniapp-db", 1, "query startAppByAppid start.");
      localObject1 = ((MiniAppEntityManager)localObject2).queryEntity(MiniAppByIdEntity.class, false, "appId=? and entryPath=? ", new String[] { paramString1, paramString2 }, null, null, null, null);
      localObject2 = ((MiniAppEntityManager)localObject2).queryEntity(MiniAppInfoEntity.class, false, "appId=? ", new String[] { paramString1 }, null, null, null, null);
      if ((localObject1 == null) || (((List)localObject1).size() != 1) || (localObject2 == null) || (((List)localObject2).size() != 1)) {
        break label357;
      }
      localObject1 = (MiniAppByIdEntity)((List)localObject1).get(0);
      localObject2 = (MiniAppInfoEntity)((List)localObject2).get(0);
      if ((localObject1 == null) || (localObject1 == null)) {
        break label357;
      }
      localObject2 = MiniAppInfo.getMiniAppInfoByIdFromDB((MiniAppByIdEntity)localObject1, (MiniAppInfoEntity)localObject2);
      if (localObject2 == null) {
        break label357;
      }
      if (paramLaunchParam != null) {
        break label373;
      }
      localObject1 = new LaunchParam();
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("PreloadingFragment", 1, "getLinkInfo from db error,", paramString1);
        continue;
        Object localObject1 = paramLaunchParam;
      }
    }
    if ((paramLaunchParam != null) && (!TextUtils.isEmpty(paramLaunchParam.extendData))) {
      ((MiniAppInfo)localObject2).extendData = paramLaunchParam.extendData;
    }
    QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Id DB.");
    MiniAppController.launchMiniAppByAppInfo(getActivity(), (MiniAppInfo)localObject2, (LaunchParam)localObject1);
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
    label348:
    QLog.e("miniapp-db", 1, "not QQAppInterface");
    label357:
    return false;
  }
  
  private boolean startMiniAppFromLinkDB(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    try
    {
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString2 instanceof QQAppInterface))
      {
        paramString2 = (MiniAppEntityManager)paramString2.getManager(330);
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
                  paramString2 = paramLaunchParam;
                  if (paramLaunchParam == null) {
                    paramString2 = new LaunchParam();
                  }
                  paramString2.shareTicket = ((MiniAppByLinkEntity)localObject).shareTicket;
                  paramString2.navigateExtData = localMiniAppInfo.extraData;
                  if (!TextUtils.isEmpty(paramString2.shareTicket)) {
                    paramString2.scene = 1044;
                  }
                  QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Link DB.");
                  MiniAppController.launchMiniAppByAppInfo(getActivity(), localMiniAppInfo, paramString2);
                  if (this.mResultReceiver != null)
                  {
                    paramString2 = new Bundle();
                    paramString2.putLong("retCode", 0L);
                    paramString2.putString("errMsg", "");
                    this.mResultReceiver.send(0, paramString2);
                  }
                  MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new PreloadingFragment.7(this));
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
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QLog.e("PreloadingFragment", 1, "getLinkInfo from db error,", paramString1);
      }
    }
    return false;
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
      this.mRootView = LayoutInflater.from(getActivity()).inflate(2131559265, null);
      this.mLoadingView = ((LinearLayout)this.mRootView.findViewById(2131369501));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment
 * JD-Core Version:    0.7.0.1
 */