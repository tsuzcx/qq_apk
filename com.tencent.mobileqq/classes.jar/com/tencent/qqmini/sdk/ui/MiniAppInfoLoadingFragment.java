package com.tencent.qqmini.sdk.ui;

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
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;

@MiniKeep
public class MiniAppInfoLoadingFragment
  extends MiniBaseFragment
{
  private static final String TAG = "MiniAppInfoLoadingFragment";
  private static final boolean mEnableDBCache = WnsConfig.getConfig("qqminiapp", "mini_app_enable_db_cache", true);
  private LinearLayout mLoadingView;
  private ResultReceiver mResultReceiver;
  private View mRootView;
  
  private void doRequestByAppId(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam, String paramString4)
  {
    showLoading();
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramString1, str, paramString2, new MiniAppInfoLoadingFragment.1(this, paramLaunchParam, paramString4));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam, String paramString3)
  {
    showLoading();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(paramString1, paramInt, new MiniAppInfoLoadingFragment.2(this, paramLaunchParam, paramString3));
  }
  
  private void doStartMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (!isMiniAppInfoValid(paramMiniAppInfo))
      {
        ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.3(this));
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
  
  private void setEntryPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo.firstPage != null) && (paramMiniAppInfo.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppInfo.firstPage.pagePath)))
    {
      if (paramMiniAppInfo.firstPage.pagePath.startsWith("/")) {
        paramMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.pagePath.substring(1);
      }
      if (paramMiniAppInfo.firstPage.pagePath.contains(".html")) {
        paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath;
      }
    }
    else
    {
      return;
    }
    if (paramMiniAppInfo.firstPage.pagePath.contains("?"))
    {
      paramMiniAppInfo.launchParam.entryPath = paramMiniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
      return;
    }
    paramMiniAppInfo.launchParam.entryPath = (paramMiniAppInfo.firstPage.pagePath + ".html");
  }
  
  private void showErrorToast(String paramString, long paramLong)
  {
    try
    {
      if (getActivity() != null)
      {
        if (DebugUtil.isDebugVersion())
        {
          MiniToast.makeText(getActivity(), 1, "" + paramString + paramLong, 1).show();
          return;
        }
        MiniToast.makeText(getActivity(), 1, "" + paramString, 1).show();
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
      getActivity().runOnUiThread(new MiniAppInfoLoadingFragment.4(this));
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
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
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
      doRequestByLink(str3, i, str2, localLaunchParam, (String)localObject);
      return;
    }
    quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */