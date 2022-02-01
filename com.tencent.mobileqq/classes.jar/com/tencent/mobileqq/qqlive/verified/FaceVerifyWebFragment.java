package com.tencent.mobileqq.qqlive.verified;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;
import com.tencent.mobileqq.qqlive.webview.QQLiveCookieManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.IWebViewFragmentInitor;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;

public class FaceVerifyWebFragment
  extends WebViewFragment
  implements IWebViewFragmentInitor
{
  private static final String[] a = { "android.permission.CAMERA", "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO" };
  private QQCustomDialog b;
  private String c;
  private int d;
  
  public static FaceVerifyWebFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new FaceVerifyWebFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  @TargetApi(24)
  private void a()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    AppActivity localAppActivity = (AppActivity)getActivity();
    if (localAppActivity != null) {
      localAppActivity.requestPermissions(new FaceVerifyWebFragment.1(this), 111, a);
    }
  }
  
  private void b()
  {
    if (this.b == null) {
      this.b = DialogUtil.a(getActivity(), 230, null, "请到应用权限中打开: 相机，存储，录音权限", "取消", "去设置", new FaceVerifyWebFragment.2(this), new FaceVerifyWebFragment.3(this));
    }
    if (!this.b.isShowing()) {
      this.b.show();
    }
  }
  
  public WebViewWrapper createWebViewWrapper(boolean paramBoolean)
  {
    return new FaceVerifyWebViewWrapper(getAppRuntime(), getActivity(), getWebViewKernelCallBack(), this.intent, paramBoolean);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    WBH5FaceVerifySDK.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public WebViewFragment newInstance(int paramInt, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    return a(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = this.intent.getStringExtra("extra_web_verify_app_id");
    this.d = this.intent.getIntExtra("extra_web_verify_callback_key", 0);
    ((IQQLiveDataStore)QRoute.api(IQQLiveDataStore.class)).setAppId(this.c);
    QQLiveCookieManager.a().a(MobileQQ.getContext(), this.c, getUrl());
  }
  
  public void onDestroy()
  {
    try
    {
      Intent localIntent = new Intent("qqlive.faceverify");
      localIntent.putExtra("msg_type", 1000);
      localIntent.putExtra("callback_key", this.d);
      localIntent.putExtra("app_id", this.c);
      MobileQQ.sMobileQQ.sendBroadcast(localIntent);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FaceVerifyWebFragment", 1, localThrowable, new Object[0]);
    }
    ((IQQLiveDataStore)QRoute.api(IQQLiveDataStore.class)).clear();
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    a();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.FaceVerifyWebFragment
 * JD-Core Version:    0.7.0.1
 */