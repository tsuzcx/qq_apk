package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy.LinkData;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

@MiniKeep
public class MiniAppInfoLoadingFragment
  extends MiniBaseFragment
{
  private static final String TAG = "MiniAppInfoLoadingFragment";
  private static final boolean mEnableDBCache = WnsConfig.getConfig("qqminiapp", "mini_app_enable_db_cache", true);
  private LinearLayout mLoadingView;
  private ResultReceiver mResultReceiver;
  private View mRootView;
  
  private boolean checkEnvVersionForCache(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || ("release".equals(paramString));
  }
  
  private void doRequestByAppId(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam, String paramString4)
  {
    showLoading();
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    MiniAppCacheProxy localMiniAppCacheProxy = (MiniAppCacheProxy)ProxyManager.get(MiniAppCacheProxy.class);
    if ((localMiniAppCacheProxy != null) && (localMiniAppCacheProxy.enableMiniAppCache()) && (checkEnvVersionForCache(paramString3)))
    {
      byte[] arrayOfByte = localMiniAppCacheProxy.getIdInfo(paramString1, paramString2);
      if (arrayOfByte != null)
      {
        Object localObject = new INTERFACE.StApiAppInfo();
        try
        {
          ((INTERFACE.StApiAppInfo)localObject).mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QMLog.e("MiniAppInfoLoadingFragment", "StApiAppInfo error,", localInvalidProtocolBufferMicroException);
        }
        localObject = MiniAppInfo.from((INTERFACE.StApiAppInfo)localObject);
        QMLog.d("MiniAppInfoLoadingFragment", "start by Id cache.");
        startByIdMiniAppInfo(0L, "", (MiniAppInfo)localObject, paramLaunchParam, paramString4);
        MiniReportManager.reportEventType((MiniAppInfo)localObject, 1028, "id_cache", MiniReportManager.getAppType((MiniAppInfo)localObject));
        getAppInfoById(paramString1, paramString2, paramString3, new MiniAppInfoLoadingFragment.1(this, paramString3, localMiniAppCacheProxy, paramString1, paramString2));
        quit();
        return;
      }
    }
    getAppInfoById(paramString1, paramString2, paramString3, new MiniAppInfoLoadingFragment.2(this, paramLaunchParam, paramString4, paramString3, localMiniAppCacheProxy, paramString1, paramString2));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, LaunchParam paramLaunchParam, String paramString2)
  {
    showLoading();
    MiniAppCacheProxy localMiniAppCacheProxy = (MiniAppCacheProxy)ProxyManager.get(MiniAppCacheProxy.class);
    if ((localMiniAppCacheProxy != null) && (localMiniAppCacheProxy.enableMiniAppCache()))
    {
      Object localObject1 = localMiniAppCacheProxy.getLinkInfo(paramString1, paramInt);
      if (localObject1 != null)
      {
        Object localObject2 = new INTERFACE.StApiAppInfo();
        try
        {
          ((INTERFACE.StApiAppInfo)localObject2).mergeFrom(((MiniAppCacheProxy.LinkData)localObject1).appInfo);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QMLog.e("MiniAppInfoLoadingFragment", "StApiAppInfo error,", localInvalidProtocolBufferMicroException);
        }
        localObject2 = MiniAppInfo.from((INTERFACE.StApiAppInfo)localObject2);
        localObject1 = ((MiniAppCacheProxy.LinkData)localObject1).shareTicket;
        QMLog.d("MiniAppInfoLoadingFragment", "start by Link cache.");
        startByLinkMiniInfo(0L, "", (MiniAppInfo)localObject2, (String)localObject1, paramLaunchParam, paramString2);
        MiniReportManager.reportEventType((MiniAppInfo)localObject2, 1028, "link_cache", MiniReportManager.getAppType((MiniAppInfo)localObject2));
        getAppInfoByLink(paramString1, paramInt, new MiniAppInfoLoadingFragment.6(this, localMiniAppCacheProxy, paramString1, paramInt));
        quit();
        return;
      }
    }
    getAppInfoByLink(paramString1, paramInt, new MiniAppInfoLoadingFragment.7(this, paramLaunchParam, paramString2, localMiniAppCacheProxy, paramString1, paramInt));
  }
  
  private void doStartMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (!isMiniAppInfoValid(paramMiniAppInfo))
      {
        ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.9(this));
        return;
      }
      MiniSDK.startMiniApp(getActivity(), paramMiniAppInfo, null, this.mResultReceiver);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("MiniAppInfoLoadingFragment", "startAppByAppid exception! ", paramMiniAppInfo);
    }
  }
  
  private void getAppInfoById(String paramString1, String paramString2, String paramString3, MiniAppInfoLoadingFragment.onGetMiniAppInfoListener paramonGetMiniAppInfoListener)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramString1, paramString2, paramString3, new MiniAppInfoLoadingFragment.4(this, paramonGetMiniAppInfoListener));
  }
  
  private void getAppInfoByLink(String paramString, int paramInt, MiniAppInfoLoadingFragment.onGetMiniAppInfoListener paramonGetMiniAppInfoListener)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(paramString, paramInt, new MiniAppInfoLoadingFragment.5(this, paramonGetMiniAppInfoListener));
  }
  
  private static boolean isMiniAppInfoValid(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (!TextUtils.isEmpty(paramMiniAppInfo.downloadUrl));
  }
  
  private void quit()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localFragmentActivity.finish();
    }
  }
  
  private void saveIdInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2, String paramString3)
  {
    if (checkEnvVersionForCache(paramString1)) {
      if (paramJSONObject != null)
      {
        paramJSONObject = MiniAppInfo.pbFromJSON(paramJSONObject);
        if (paramJSONObject != null)
        {
          QMLog.d("MiniAppInfoLoadingFragment", "saveIdInfo cache.");
          if (paramMiniAppCacheProxy.saveIdInfo(paramString2, paramString3, ((INTERFACE.StApiAppInfo)paramJSONObject.get()).toByteArray(), System.currentTimeMillis())) {
            QMLog.d("MiniAppInfoLoadingFragment", "saveIdInfo cache success.");
          }
        }
      }
      else if (paramArrayOfByte != null)
      {
        QMLog.d("MiniAppInfoLoadingFragment", "saveIdInfo cache.");
        if (paramMiniAppCacheProxy.saveIdInfo(paramString2, paramString3, paramArrayOfByte, System.currentTimeMillis())) {
          QMLog.d("MiniAppInfoLoadingFragment", "saveIdInfo cache success.");
        }
      }
    }
  }
  
  private void saveLinkInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2, int paramInt)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = MiniAppInfo.pbFromJSON(paramJSONObject);
      if (paramJSONObject != null)
      {
        QMLog.d("MiniAppInfoLoadingFragment", "saveLinkInfo cache.");
        if (paramMiniAppCacheProxy.saveLinkInfo(paramString2, paramInt, paramString1, ((INTERFACE.StApiAppInfo)paramJSONObject.get()).toByteArray(), System.currentTimeMillis())) {
          QMLog.d("MiniAppInfoLoadingFragment", "saveLinkInfo cache success.");
        }
      }
    }
    else if (paramArrayOfByte != null)
    {
      QMLog.d("MiniAppInfoLoadingFragment", "saveLinkInfo cache.");
      if (paramMiniAppCacheProxy.saveLinkInfo(paramString2, paramInt, paramString1, paramArrayOfByte, System.currentTimeMillis())) {
        QMLog.d("MiniAppInfoLoadingFragment", "saveLinkInfo cache success.");
      }
    }
  }
  
  private void setEntryPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo.firstPage != null) && (paramMiniAppInfo.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppInfo.firstPage.pagePath)))
    {
      if (paramMiniAppInfo.firstPage.pagePath.startsWith("/")) {
        paramMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.pagePath.substring(1);
      }
      if (paramMiniAppInfo.firstPage.pagePath.contains(".html"))
      {
        paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath;
        return;
      }
      if (paramMiniAppInfo.firstPage.pagePath.contains("?"))
      {
        paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
        return;
      }
      LaunchParam localLaunchParam = paramMiniAppInfo.launchParam;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppInfo.firstPage.pagePath);
      localStringBuilder.append(".html");
      localLaunchParam.entryPath = localStringBuilder.toString();
    }
  }
  
  private void showErrorToast(String paramString, long paramLong)
  {
    try
    {
      if (getActivity() != null)
      {
        boolean bool = DebugUtil.isDebugVersion();
        if (bool)
        {
          localFragmentActivity = getActivity();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramLong);
          MiniToast.makeText(localFragmentActivity, 1, localStringBuilder.toString(), 1).show();
          return;
        }
        FragmentActivity localFragmentActivity = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramString);
        MiniToast.makeText(localFragmentActivity, 1, localStringBuilder.toString(), 1).show();
        return;
      }
    }
    catch (Exception paramString)
    {
      QMLog.e("MiniAppInfoLoadingFragment", paramString.getMessage(), paramString);
    }
  }
  
  private void showLoading()
  {
    if (getActivity() != null) {
      getActivity().runOnUiThread(new MiniAppInfoLoadingFragment.10(this));
    }
  }
  
  private void startByIdMiniAppInfo(long paramLong, String paramString1, MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam, String paramString2)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramLaunchParam != null)
      {
        paramMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
        if (!TextUtils.isEmpty(paramLaunchParam.extendData)) {
          paramMiniAppInfo.extendData = paramLaunchParam.extendData;
        }
        paramMiniAppInfo.launchParam.scene = paramLaunchParam.scene;
      }
      if (paramMiniAppInfo.verType != 3) {
        paramMiniAppInfo.forceReroad = 3;
      }
      setEntryPath(paramMiniAppInfo);
      if (paramString2 != null) {
        paramMiniAppInfo.customInfo = paramString2;
      }
      doStartMiniApp(paramMiniAppInfo);
      if (this.mResultReceiver != null)
      {
        paramMiniAppInfo = new Bundle();
        paramMiniAppInfo.putLong("retCode", paramLong);
        paramMiniAppInfo.putString("errMsg", paramString1);
        this.mResultReceiver.send(0, paramMiniAppInfo);
      }
    }
    else
    {
      ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.3(this, paramLong, paramString1));
      if (this.mResultReceiver != null)
      {
        paramMiniAppInfo = new Bundle();
        paramMiniAppInfo.putLong("retCode", paramLong);
        paramMiniAppInfo.putString("errMsg", paramString1);
        this.mResultReceiver.send(1, paramMiniAppInfo);
      }
    }
  }
  
  private void startByLinkMiniInfo(long paramLong, String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2, LaunchParam paramLaunchParam, String paramString3)
  {
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
      paramMiniAppInfo.launchParam.shareTicket = paramString2;
      paramMiniAppInfo.launchParam.navigateExtData = paramMiniAppInfo.extraData;
      updateLaunchParam(paramMiniAppInfo, paramLaunchParam);
      if (paramMiniAppInfo.verType != 3) {
        paramMiniAppInfo.forceReroad = 3;
      }
      setEntryPath(paramMiniAppInfo);
      if (paramMiniAppInfo.clearAuths == 1) {
        paramString2 = LoginManager.getInstance().getAccount();
      }
    }
    try
    {
      if (Long.valueOf(Long.parseLong(paramString2)).longValue() > 0L)
      {
        MiniAppEnv.g().getAuthSate(paramMiniAppInfo.appId).clearAll();
        paramMiniAppInfo.clearAuths = 0;
      }
    }
    catch (Exception paramString2)
    {
      label126:
      break label126;
    }
    if (paramString3 != null) {
      paramMiniAppInfo.customInfo = paramString3;
    }
    doStartMiniApp(paramMiniAppInfo);
    if (this.mResultReceiver != null)
    {
      paramMiniAppInfo = new Bundle();
      paramMiniAppInfo.putLong("retCode", paramLong);
      paramMiniAppInfo.putString("errMsg", paramString1);
      this.mResultReceiver.send(0, paramMiniAppInfo);
      return;
      ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.8(this, paramLong, paramString1));
      if (this.mResultReceiver != null)
      {
        paramMiniAppInfo = new Bundle();
        paramMiniAppInfo.putLong("retCode", paramLong);
        paramMiniAppInfo.putString("errMsg", paramString1);
        this.mResultReceiver.send(1, paramMiniAppInfo);
      }
    }
  }
  
  private void updateLaunchParam(MiniAppInfo paramMiniAppInfo, LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam != null) {
      paramMiniAppInfo.launchParam.scene = paramLaunchParam.scene;
    }
    if (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.shareTicket)) {
      paramMiniAppInfo.launchParam.scene = 1044;
    }
    if (TextUtils.isEmpty(paramMiniAppInfo.launchParam.reportData))
    {
      paramMiniAppInfo.launchParam.reportData = paramMiniAppInfo.reportData;
      return;
    }
    if (!TextUtils.isEmpty(paramMiniAppInfo.reportData))
    {
      paramLaunchParam = paramMiniAppInfo.launchParam;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppInfo.launchParam.reportData);
      localStringBuilder.append("&");
      localStringBuilder.append(paramMiniAppInfo.reportData);
      paramLaunchParam.reportData = localStringBuilder.toString();
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QMLog.i("MiniAppInfoLoadingFragment", "LoadingFragment onCreateView");
    if (this.mRootView == null)
    {
      this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_appinfo_loading_layout, null);
      this.mLoadingView = ((LinearLayout)this.mRootView.findViewById(R.id.loading_layout));
    }
    return this.mRootView;
  }
  
  public void onResume()
  {
    super.onResume();
    QMLog.i("MiniAppInfoLoadingFragment", "LoadingFragment doTask");
    Object localObject = getArguments();
    if (localObject == null)
    {
      quit();
      return;
    }
    ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
    this.mResultReceiver = ((ResultReceiver)((Bundle)localObject).getParcelable("mini_receiver"));
    String str1 = ((Bundle)localObject).getString("key_appid");
    LaunchParam localLaunchParam = (LaunchParam)((Bundle)localObject).getParcelable("mini_launch_param");
    String str2 = ((Bundle)localObject).getString("mini_envVersion");
    String str3 = ((Bundle)localObject).getString("mini_link");
    int i = ((Bundle)localObject).getInt("mini_link_type");
    String str4 = ((Bundle)localObject).getString("mini_entryPath");
    localObject = ((Bundle)localObject).getString("mini_customInfo");
    if (!TextUtils.isEmpty(str1))
    {
      doRequestByAppId(str1, str4, str2, localLaunchParam, (String)localObject);
      return;
    }
    if (!TextUtils.isEmpty(str3))
    {
      doRequestByLink(str3, i, localLaunchParam, (String)localObject);
      return;
    }
    quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */