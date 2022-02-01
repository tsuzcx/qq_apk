package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.RecordJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.WebCookieManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.OnRefreshTokenListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.litelivesdk.utils.network.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class BaseWebDialogFragment
  extends DialogFragment
{
  protected Dialog a;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  protected FrameLayout a;
  protected JsBizAdapter a;
  protected UserEngine a;
  private UserInitStateCallback jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback = new BaseWebDialogFragment.2(this);
  protected LiteLiveJsProvider a;
  private LiteAppJs.OnRefreshTokenListener jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener = new BaseWebDialogFragment.1(this);
  protected WebView a;
  protected String a;
  protected boolean a;
  protected FrameLayout b;
  private boolean b;
  
  public BaseWebDialogFragment()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = new LiteLiveJsProvider();
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = new BaseWebDialogFragment.3(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.loginSuccess())
    {
      QLog.i("BaseWebDialogFragment", 1, "initLogin has loginSuccess");
      b();
      return;
    }
    QLog.i("BaseWebDialogFragment", 1, "initLogin wait login complete");
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.addUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
  }
  
  private boolean a(String paramString)
  {
    Object localObject1 = Uri.parse(paramString);
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((Uri)localObject1).getQueryParameterNames().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      paramString = ((Uri)localObject1).getQueryParameter(str);
      if (paramString != null) {}
      for (;;)
      {
        localHashMap.put(str, paramString);
        break;
        paramString = "";
      }
    }
    localObject2 = ((Uri)localObject1).getAuthority();
    localObject1 = ((Uri)localObject1).getPath();
    paramString = (String)localObject1;
    if (localObject1 != null) {
      paramString = ((String)localObject1).substring(1);
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a((String)localObject2, paramString, localHashMap);
  }
  
  private void b()
  {
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString);
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://yutang.qq.com/");
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://ilive.qq.com/");
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  private void c()
  {
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    if (localWebSettings == null) {}
    String str1;
    do
    {
      return;
      localWebSettings.setAppCacheEnabled(false);
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setDomStorageEnabled(true);
      str1 = localWebSettings.getUserAgentString();
    } while (str1.contains("NowSDK/"));
    int i = DeviceUtils.a();
    String str2 = Build.VERSION.RELEASE;
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    localWebSettings.setUserAgentString(str1 + " NowLive/" + i + "_" + str2 + " NetType/" + j + " NowSDK/18_10.20");
  }
  
  public abstract int a();
  
  public abstract FrameLayout a(View paramView);
  
  public abstract void a(Dialog paramDialog);
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public abstract void a(View paramView);
  
  public abstract FrameLayout b(View paramView);
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      Log.e("BaseWebDialogFragment", localException.getMessage());
    }
  }
  
  public void dismissAllowingStateLoss()
  {
    try
    {
      super.dismissAllowingStateLoss();
      return;
    }
    catch (Exception localException)
    {
      Log.e("BaseWebDialogFragment", localException.getMessage());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("BaseWebDialogFragment", "onCreate");
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("url");
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("mPreload");
    }
    setStyle(1, 2131755690);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = null;
    Log.i("BaseWebDialogFragment", "into onCreateView");
    int i = a();
    if (i == 0)
    {
      Log.e("BaseWebDialogFragment", "layout id is cannot 0");
      paramLayoutInflater = paramViewGroup;
    }
    for (;;)
    {
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = paramLayoutInflater.inflate(i, null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = a(paramLayoutInflater);
      this.jdField_b_of_type_AndroidWidgetFrameLayout = b(paramLayoutInflater);
      a(paramLayoutInflater);
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        throw new IllegalArgumentException("web container is cannot null");
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentSmttSdkWebView, new FrameLayout.LayoutParams(-1, -1));
      c();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new BaseWebDialogFragment.4(this));
      this.jdField_a_of_type_AndroidAppDialog = getDialog();
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      paramViewGroup = new AppJavascriptInterface(getActivity(), paramLayoutInflater, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
      paramBundle = new RecordJavascriptInterface(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
      UIJavascriptInterface localUIJavascriptInterface = new UIJavascriptInterface(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
      MiscJavascriptInterface localMiscJavascriptInterface = new MiscJavascriptInterface(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(localUIJavascriptInterface);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(localMiscJavascriptInterface);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteAppJs(getActivity(), paramLayoutInflater, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter).setOnRefreshTokenListener(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener));
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteUIJs(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
      if (getArguments() != null) {
        this.jdField_a_of_type_JavaLangString = getArguments().getString("url", "");
      }
      this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
      a();
      Log.i("InfoWebViewDialog", "onCreateView end");
    }
  }
  
  public void onDestroy()
  {
    Log.i("BaseWebDialogFragment", "into onDestroy");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    Log.i("BaseWebDialogFragment", "into onDestroyView");
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(null);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(null);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.clearCache(true);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.clearHistory();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener.onDismiss(this.jdField_a_of_type_AndroidAppDialog);
    }
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine != null) {
      this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.removeUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    }
  }
  
  public void onPause()
  {
    Log.i("BaseWebDialogFragment", "into onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    Log.i("BaseWebDialogFragment", "into onResume");
    super.onResume();
    a(this.jdField_a_of_type_AndroidAppDialog);
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      WebCookieManager.a().a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onStart()
  {
    Log.i("BaseWebDialogFragment", "into onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    Log.i("BaseWebDialogFragment", "into onStop");
    super.onStop();
  }
  
  public int show(FragmentTransaction paramFragmentTransaction, String paramString)
  {
    try
    {
      int i = super.show(paramFragmentTransaction, paramString);
      return i;
    }
    catch (Exception paramFragmentTransaction)
    {
      paramFragmentTransaction.printStackTrace();
    }
    return 0;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    try
    {
      super.show(paramFragmentManager, paramString);
      return;
    }
    catch (Exception paramFragmentManager)
    {
      paramFragmentManager.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.BaseWebDialogFragment
 * JD-Core Version:    0.7.0.1
 */