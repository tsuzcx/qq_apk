package com.tencent.qqmini.sdk.launcher;

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
import bgpx;
import bgrm;
import bguw;
import bgux;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.utils.DebugUtil;

public class MiniAppInfoLoadingFragment
  extends MiniBaseFragment
{
  private static final boolean jdField_a_of_type_Boolean = bgpx.a("qqminiapp", "mini_app_enable_db_cache", true);
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  private void a()
  {
    if (getActivity() != null) {
      getActivity().runOnUiThread(new MiniAppInfoLoadingFragment.4(this));
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo)
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
  
  private void a(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    a();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(paramString1, paramInt, new bgux(this, paramLaunchParam));
  }
  
  private void a(String paramString, long paramLong)
  {
    try
    {
      if (getActivity() != null)
      {
        if (DebugUtil.isDebugVersion())
        {
          bgrm.a(getActivity(), 1, "" + paramString + paramLong, 1).a();
          return;
        }
        bgrm.a(getActivity(), 1, "" + paramString, 1).a();
        return;
      }
    }
    catch (Exception paramString)
    {
      QMLog.e("MiniAppInfoLoadingFragment", paramString.getMessage(), paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    a();
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramString1, str, paramString2, new bguw(this, paramLaunchParam));
  }
  
  private static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (!TextUtils.isEmpty(paramMiniAppInfo.downloadUrl));
  }
  
  private void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localFragmentActivity.finish();
    }
  }
  
  private void b(MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (!a(paramMiniAppInfo))
      {
        ThreadManager.c().post(new MiniAppInfoLoadingFragment.3(this));
        return;
      }
      MiniSDK.startMiniApp(getActivity(), paramMiniAppInfo, null, this.jdField_a_of_type_AndroidOsResultReceiver);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("MiniAppInfoLoadingFragment", "startAppByAppid exception! ", paramMiniAppInfo);
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QMLog.i("MiniAppInfoLoadingFragment", "LoadingFragment onCreateView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559338, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369781));
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onResume()
  {
    super.onResume();
    QMLog.i("MiniAppInfoLoadingFragment", "LoadingFragment doTask");
    Object localObject = getArguments();
    if (localObject == null)
    {
      b();
      return;
    }
    ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)((Bundle)localObject).getParcelable("mini_receiver"));
    String str1 = ((Bundle)localObject).getString("mini_appid");
    LaunchParam localLaunchParam = (LaunchParam)((Bundle)localObject).getParcelable("mini_launch_param");
    String str2 = ((Bundle)localObject).getString("mini_envVersion");
    String str3 = ((Bundle)localObject).getString("mini_link");
    int i = ((Bundle)localObject).getInt("mini_link_type");
    localObject = ((Bundle)localObject).getString("mini_entryPath");
    if (!TextUtils.isEmpty(str1))
    {
      a(str1, (String)localObject, str2, localLaunchParam);
      return;
    }
    if (!TextUtils.isEmpty(str3))
    {
      a(str3, i, str2, localLaunchParam);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */