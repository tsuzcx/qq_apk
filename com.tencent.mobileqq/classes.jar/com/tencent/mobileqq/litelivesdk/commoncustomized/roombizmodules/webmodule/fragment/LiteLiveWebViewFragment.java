package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.NetworkUtil;
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
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LiteLiveWebViewFragment
  extends WebViewFragment
{
  protected LiteLiveJsProvider a = new LiteLiveJsProvider();
  protected JsBizAdapter b = new LiteLiveWebViewFragment.3(this);
  private String c;
  private UserEngine d;
  private LiteAppJs.OnRefreshTokenListener e = new LiteLiveWebViewFragment.1(this);
  private UserInitStateCallback f = new LiteLiveWebViewFragment.2(this);
  
  private void a()
  {
    UserEngine localUserEngine = this.d;
    if (localUserEngine == null) {
      return;
    }
    if (localUserEngine.loginSuccess())
    {
      QLog.i("LiteLiveWebViewFragment", 1, "initLogin has loginSuccess");
      b();
      return;
    }
    QLog.i("LiteLiveWebViewFragment", 1, "initLogin wait login complete");
    this.d.addUserInitCallback(this.f);
  }
  
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
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString = (String)localObject1;
      if (((String)localObject1).length() > 0) {
        paramString = ((String)localObject1).substring(1);
      }
    }
    return this.a.callFunction((String)localObject2, paramString, localHashMap);
  }
  
  private void b()
  {
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), this.c);
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
    this.b.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new AppJavascriptInterface(getQBaseActivity(), this.contentView, this.b);
    RecordJavascriptInterface localRecordJavascriptInterface = new RecordJavascriptInterface(getQBaseActivity(), this.b);
    UIJavascriptInterface localUIJavascriptInterface = new UIJavascriptInterface(getQBaseActivity(), this.b);
    MiscJavascriptInterface localMiscJavascriptInterface = new MiscJavascriptInterface(getQBaseActivity(), this.b);
    this.a.registerJsModule(paramBundle);
    this.a.registerJsModule(localRecordJavascriptInterface);
    this.a.registerJsModule(localUIJavascriptInterface);
    this.a.registerJsModule(localMiscJavascriptInterface);
    this.a.registerJsModule(new LiteAppJs(getQBaseActivity(), this.contentView, this.b).setOnRefreshTokenListener(this.e));
    this.a.registerJsModule(new LiteUIJs(getQBaseActivity(), this.b));
    if ((this.intent != null) && (this.intent.getExtras() != null))
    {
      this.c = this.intent.getExtras().getString("url", "");
      paramBundle = Uri.parse(this.c);
      try
      {
        paramBundle = paramBundle.getQueryParameter("_wv");
        if ((!TextUtils.isEmpty(paramBundle)) && ((Long.parseLong(paramBundle, 10) & 0x1000000) != 0L)) {
          getSwiftTitleUI().o.setVisibility(8);
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    this.d = BizEngineMgr.getInstance().getUserEngine();
    a();
    return bool;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new LiteLiveWebViewFragment.4(this, this.webViewSurface);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((this.webView != null) && (this.webView.getSettings() != null))
    {
      String str2 = Build.VERSION.RELEASE;
      int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
      String str1 = this.webView.getSettings().getUserAgentString();
      if (!StringUtil.isEmpty(str1))
      {
        paramBundle = str1;
        if (str1.contains("NowSDK/")) {}
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append(str1);
        paramBundle.append(" NowLive/");
        paramBundle.append(10800);
        paramBundle.append("_");
        paramBundle.append(str2);
        paramBundle.append(" NetType/");
        paramBundle.append(i);
        paramBundle.append(" NowSDK/18_10.20");
        paramBundle = paramBundle.toString();
      }
      this.webView.getSettings().setUserAgentString(paramBundle);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    UserEngine localUserEngine = this.d;
    if (localUserEngine != null) {
      localUserEngine.removeUserInitCallback(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment
 * JD-Core Version:    0.7.0.1
 */