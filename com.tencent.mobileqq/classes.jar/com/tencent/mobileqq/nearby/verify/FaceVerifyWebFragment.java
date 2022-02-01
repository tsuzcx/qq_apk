package com.tencent.mobileqq.nearby.verify;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.IWebViewFragmentInitor;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import mqq.app.AppActivity;

public class FaceVerifyWebFragment
  extends WebViewFragment
  implements IWebViewFragmentInitor
{
  private static final String[] a = { "android.permission.CAMERA", "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO" };
  private QQCustomDialog b;
  
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
      this.b = DialogUtil.a(getActivity(), 230, null, HardCodeUtil.a(1946615847), HardCodeUtil.a(1946615846), HardCodeUtil.a(1946615848), new FaceVerifyWebFragment.2(this), new FaceVerifyWebFragment.3(this));
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
  }
  
  public void onStart()
  {
    super.onStart();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.verify.FaceVerifyWebFragment
 * JD-Core Version:    0.7.0.1
 */