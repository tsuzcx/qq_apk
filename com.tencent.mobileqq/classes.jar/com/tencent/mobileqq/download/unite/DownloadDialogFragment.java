package com.tencent.mobileqq.download.unite;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.download.unite.config.DownloadConfigBean;
import com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor;
import com.tencent.mobileqq.download.unite.util.UniteDownloadUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQDeviceInfo;

public class DownloadDialogFragment
  extends PublicBaseFragment
{
  private void a(int paramInt)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    Handler localHandler = UniteDownloadUtil.a();
    if (localHandler != null)
    {
      Message localMessage = localHandler.obtainMessage(1);
      localMessage.obj = Long.valueOf(localBaseActivity.getIntent().getLongExtra("listener_flag", -1L));
      localMessage.arg1 = paramInt;
      localHandler.sendMessage(localMessage);
    }
    localBaseActivity.finish();
    if (paramInt != 1)
    {
      localBaseActivity.overridePendingTransition(2130772011, 2130772012);
      return;
    }
    localBaseActivity.overridePendingTransition(0, 2130772010);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("listener_flag", paramLong);
    localIntent.setFlags(268435456);
    localIntent.putExtra("big_brother_source_key", paramDownloadInfo.r);
    localIntent.putExtra("key_url", paramDownloadInfo.d);
    localIntent.putExtra("key_appid", paramDownloadInfo.c);
    PublicFragmentActivity.Launcher.a(BaseApplicationImpl.sApplication, localIntent, PublicTransFragmentActivity.class, DownloadDialogFragment.class);
  }
  
  private static void b(Activity paramActivity)
  {
    Object localObject1 = AppSetting.h();
    Object localObject2 = AppSetting.h();
    int i = Build.VERSION.SDK_INT;
    int j = NetworkUtil.getNetworkType(paramActivity);
    String str1 = QQDeviceInfo.getIMEI("0");
    Object localObject3 = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    String str3 = paramActivity.getIntent().getStringExtra("key_url");
    String str2 = paramActivity.getIntent().getStringExtra("key_appid");
    str3 = StringUtil.substring(str3, 0, 50);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("source=");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(",url=");
    localStringBuilder.append(str3);
    localStringBuilder.append(",appid=");
    localStringBuilder.append(str2);
    str2 = localStringBuilder.toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("clientInfo=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("&clientVersion=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("&osVersion=");
    ((StringBuilder)localObject3).append(String.valueOf(i));
    ((StringBuilder)localObject3).append("&os=");
    ((StringBuilder)localObject3).append("android");
    ((StringBuilder)localObject3).append("&netType=");
    ((StringBuilder)localObject3).append(String.valueOf(j));
    ((StringBuilder)localObject3).append("&imei=");
    ((StringBuilder)localObject3).append(str1);
    ((StringBuilder)localObject3).append("&customInfo=");
    ((StringBuilder)localObject3).append(str2);
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadDialogFragment", 1, new Object[] { "url argument: ", ((StringBuilder)localObject3).toString() });
    }
    localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://support.qq.com/product/275620?");
    ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
    paramActivity.startActivity(((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString()));
  }
  
  public void a()
  {
    Object localObject = DownloadConfigProcessor.a();
    localObject = DialogUtil.a(getBaseActivity(), 0, ((DownloadConfigBean)localObject).c, ((DownloadConfigBean)localObject).d, ((DownloadConfigBean)localObject).f, ((DownloadConfigBean)localObject).e, ((DownloadConfigBean)localObject).g, new DownloadDialogFragment.1(this), new DownloadDialogFragment.2(this), new DownloadDialogFragment.3(this));
    ((QQCustomDialog)localObject).setOnCancelListener(new DownloadDialogFragment.4(this));
    try
    {
      ((QQCustomDialog)localObject).show();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[UniteDownload] DownloadDialogFragment", 1, "show dialog error: ", localThrowable);
    }
    ReportHelperKt.a("0X800B53B");
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131625234, null);
    paramLayoutInflater.setAlpha(0.5F);
    getBaseActivity().overridePendingTransition(2130772011, 2130772012);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.DownloadDialogFragment
 * JD-Core Version:    0.7.0.1
 */