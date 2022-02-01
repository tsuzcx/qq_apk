package com.tencent.mobileqq.download.unite;

import aeow;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import asao;
import asap;
import asaq;
import asar;
import asas;
import asat;
import asbb;
import azcl;
import bhdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.QQDeviceInfo;

public class DownloadDialogFragment
  extends PublicBaseFragment
{
  private void a(int paramInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    Handler localHandler = asbb.a();
    if (localHandler != null)
    {
      Message localMessage = localHandler.obtainMessage(1);
      localMessage.obj = Long.valueOf(localFragmentActivity.getIntent().getLongExtra("listener_flag", -1L));
      localMessage.arg1 = paramInt;
      localHandler.sendMessage(localMessage);
    }
    localFragmentActivity.finish();
    if (paramInt != 1)
    {
      localFragmentActivity.overridePendingTransition(2130771994, 2130771995);
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 2130771993);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("listener_flag", paramLong);
    localIntent.setFlags(268435456);
    localIntent.putExtra("big_brother_source_key", paramDownloadInfo.m);
    localIntent.putExtra("key_url", paramDownloadInfo.d);
    localIntent.putExtra("key_appid", paramDownloadInfo.c);
    aeow.a(BaseApplicationImpl.sApplication, localIntent, PublicTransFragmentActivity.class, DownloadDialogFragment.class);
  }
  
  private static void b(Activity paramActivity)
  {
    String str1 = AppSetting.f();
    String str2 = AppSetting.f();
    int i = Build.VERSION.SDK_INT;
    int j = NetworkUtil.getNetworkType(paramActivity);
    String str3 = QQDeviceInfo.getIMEI("0");
    String str4 = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    String str5 = paramActivity.getIntent().getStringExtra("key_url");
    Object localObject = paramActivity.getIntent().getStringExtra("key_appid");
    str5 = StringUtil.substring(str5, 0, 50);
    str4 = "source=" + str4 + ",url=" + str5 + ",appid=" + (String)localObject;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientInfo=").append(str1).append("&clientVersion=").append(str2).append("&osVersion=").append(String.valueOf(i)).append("&os=").append("android").append("&netType=").append(String.valueOf(j)).append("&imei=").append(str3).append("&customInfo=").append(str4);
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadDialogFragment", 1, new Object[] { "url argument: ", ((StringBuilder)localObject).toString() });
    }
    paramActivity.startActivity(new Intent(paramActivity, QQBrowserActivity.class).putExtra("url", "https://support.qq.com/product/275620?" + ((StringBuilder)localObject).toString()));
  }
  
  public void a()
  {
    Object localObject = asat.a();
    localObject = bhdj.a(getActivity(), 0, ((asas)localObject).a, ((asas)localObject).b, ((asas)localObject).d, ((asas)localObject).c, ((asas)localObject).e, new asao(this), new asap(this), new asaq(this));
    ((QQCustomDialog)localObject).setOnCancelListener(new asar(this));
    try
    {
      ((QQCustomDialog)localObject).show();
      azcl.a("0X800B53B");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("[UniteDownload] DownloadDialogFragment", 1, "show dialog error: ", localThrowable);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(3);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559357, null);
    paramLayoutInflater.setAlpha(0.5F);
    getActivity().overridePendingTransition(2130771994, 2130771995);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.DownloadDialogFragment
 * JD-Core Version:    0.7.0.1
 */