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
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.RecordJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.WebCookieManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.OnRefreshTokenListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.litelivesdk.utils.network.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseWebDialogFragment
  extends DialogFragment
{
  protected Dialog a;
  protected FrameLayout b;
  protected FrameLayout c;
  protected String d;
  protected WebView e;
  protected boolean f;
  protected LiteLiveJsProvider g = new LiteLiveJsProvider();
  protected UserEngine h;
  protected ModuleEvent i;
  protected JsBizAdapter j = new BaseWebDialogFragment.3(this);
  private boolean k = false;
  private DialogInterface.OnDismissListener l;
  private LiteAppJs.OnRefreshTokenListener m = new BaseWebDialogFragment.1(this);
  private UserInitStateCallback n = new BaseWebDialogFragment.2(this);
  
  private boolean a(String paramString)
  {
    Object localObject1 = Uri.parse(paramString);
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((Uri)localObject1).getQueryParameterNames().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      paramString = ((Uri)localObject1).getQueryParameter(str);
      if (paramString == null) {
        paramString = "";
      }
      localHashMap.put(str, paramString);
    }
    localObject2 = ((Uri)localObject1).getAuthority();
    localObject1 = ((Uri)localObject1).getPath();
    paramString = (String)localObject1;
    if (localObject1 != null) {
      paramString = ((String)localObject1).substring(1);
    }
    return this.g.callFunction((String)localObject2, paramString, localHashMap);
  }
  
  private void b()
  {
    UserEngine localUserEngine = this.h;
    if (localUserEngine == null) {
      return;
    }
    if (localUserEngine.loginSuccess())
    {
      QLog.i("BaseWebDialogFragment", 1, "initLogin has loginSuccess");
      c();
      return;
    }
    QLog.i("BaseWebDialogFragment", 1, "initLogin wait login complete");
    this.h.addUserInitCallback(this.n);
  }
  
  private void c()
  {
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), this.d);
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://yutang.qq.com/");
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://ilive.qq.com/");
    if ((BusinessManager.a.b() != null) && (BusinessManager.a.b().n != null))
    {
      Iterator localIterator = BusinessManager.a.b().n.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        WebCookieManager.a().a(BaseApplicationImpl.getContext(), str);
      }
    }
    this.j.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  private void d()
  {
    WebSettings localWebSettings = this.e.getSettings();
    if (localWebSettings == null) {
      return;
    }
    localWebSettings.setAppCacheEnabled(false);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    String str1 = localWebSettings.getUserAgentString();
    if (!str1.contains("NowSDK/"))
    {
      int i1 = DeviceUtils.b();
      String str2 = Build.VERSION.RELEASE;
      int i2 = NetworkUtil.a(BaseApplicationImpl.getContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" NowLive/");
      localStringBuilder.append(i1);
      localStringBuilder.append("_");
      localStringBuilder.append(str2);
      localStringBuilder.append(" NetType/");
      localStringBuilder.append(i2);
      localStringBuilder.append(" NowSDK/18_10.20");
      localWebSettings.setUserAgentString(localStringBuilder.toString());
    }
  }
  
  public abstract int a();
  
  public abstract FrameLayout a(View paramView);
  
  public abstract void a(Dialog paramDialog);
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.l = paramOnDismissListener;
  }
  
  public void a(ModuleEvent paramModuleEvent)
  {
    this.i = paramModuleEvent;
  }
  
  public abstract FrameLayout b(View paramView);
  
  public abstract void c(View paramView);
  
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
      this.d = paramBundle.getString("url");
      this.k = paramBundle.getBoolean("mPreload");
    }
    setStyle(1, 2131953177);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.i("BaseWebDialogFragment", "into onCreateView");
    int i1 = a();
    paramViewGroup = null;
    if (i1 == 0)
    {
      Log.e("BaseWebDialogFragment", "layout id is cannot 0");
      paramLayoutInflater = paramViewGroup;
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.inflate(i1, null);
      this.b = a(paramLayoutInflater);
      this.c = b(paramLayoutInflater);
      c(paramLayoutInflater);
      if (this.b == null) {
        break label362;
      }
      this.e = new DtX5WebView(getContext());
      this.b.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
      d();
      this.e.loadUrl(this.d);
      this.e.setWebViewClient(new BaseWebDialogFragment.4(this));
      this.a = getDialog();
      this.a.setCanceledOnTouchOutside(true);
      paramViewGroup = new AppJavascriptInterface(getActivity(), paramLayoutInflater, this.j);
      paramBundle = new RecordJavascriptInterface(getActivity(), this.j);
      UIJavascriptInterface localUIJavascriptInterface = new UIJavascriptInterface(getActivity(), this.j);
      MiscJavascriptInterface localMiscJavascriptInterface = new MiscJavascriptInterface(getActivity(), this.j);
      this.g.registerJsModule(paramViewGroup);
      this.g.registerJsModule(paramBundle);
      this.g.registerJsModule(localUIJavascriptInterface);
      this.g.registerJsModule(localMiscJavascriptInterface);
      this.g.registerJsModule(new LiteAppJs(getActivity(), paramLayoutInflater, this.j).setOnRefreshTokenListener(this.m));
      this.g.registerJsModule(new LiteUIJs(getActivity(), this.j));
      if (getArguments() != null) {
        this.d = getArguments().getString("url", "");
      }
      this.h = BizEngineMgr.getInstance().getUserEngine();
      b();
      Log.i("InfoWebViewDialog", "onCreateView end");
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
    label362:
    throw new IllegalArgumentException("web container is cannot null");
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
    this.e.stopLoading();
    this.e.setWebViewClient(null);
    this.e.setWebChromeClient(null);
    this.e.clearCache(true);
    this.e.clearHistory();
    Object localObject = this.l;
    if (localObject != null) {
      ((DialogInterface.OnDismissListener)localObject).onDismiss(this.a);
    }
    localObject = this.h;
    if (localObject != null) {
      ((UserEngine)localObject).removeUserInitCallback(this.n);
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
    a(this.a);
    if ((this.f) && (!TextUtils.isEmpty(this.d))) {
      WebCookieManager.a().a(BaseApplicationImpl.getContext(), this.d);
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
      int i1 = super.show(paramFragmentTransaction, paramString);
      return i1;
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