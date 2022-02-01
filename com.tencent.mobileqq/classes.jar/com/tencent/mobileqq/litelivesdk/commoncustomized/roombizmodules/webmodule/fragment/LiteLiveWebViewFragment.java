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
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.WebCookieManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.OnRefreshTokenListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LiteLiveWebViewFragment
  extends WebViewFragment
{
  protected JsBizAdapter a;
  private UserEngine jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine;
  private UserInitStateCallback jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback = new LiteLiveWebViewFragment.2(this);
  protected LiteLiveJsProvider a;
  private LiteAppJs.OnRefreshTokenListener jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener = new LiteLiveWebViewFragment.1(this);
  private String jdField_a_of_type_JavaLangString;
  
  public LiteLiveWebViewFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = new LiteLiveJsProvider();
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = new LiteLiveWebViewFragment.3(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.loginSuccess())
    {
      QLog.i("LiteLiveWebViewFragment", 1, "initLogin has loginSuccess");
      b();
      return;
    }
    QLog.i("LiteLiveWebViewFragment", 1, "initLogin wait login complete");
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
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    QLog.d("LiteLiveWebViewFragment", 1, "shouldOverrideUrlLoading: url = " + paramString);
    if (a(paramString)) {
      return true;
    }
    return super.beforeWebViewEngineHandleOverrideUrl(this.webView, paramString);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new AppJavascriptInterface(getActivity(), this.contentView, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    RecordJavascriptInterface localRecordJavascriptInterface = new RecordJavascriptInterface(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    UIJavascriptInterface localUIJavascriptInterface = new UIJavascriptInterface(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    MiscJavascriptInterface localMiscJavascriptInterface = new MiscJavascriptInterface(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(localRecordJavascriptInterface);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(localUIJavascriptInterface);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(localMiscJavascriptInterface);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteAppJs(getActivity(), this.contentView, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter).setOnRefreshTokenListener(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteUIJs(getActivity(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    if ((this.intent != null) && (this.intent.getExtras() != null))
    {
      this.jdField_a_of_type_JavaLangString = this.intent.getExtras().getString("url", "");
      paramBundle = Uri.parse(this.jdField_a_of_type_JavaLangString);
    }
    try
    {
      paramBundle = paramBundle.getQueryParameter("_wv");
      if ((!TextUtils.isEmpty(paramBundle)) && ((Long.parseLong(paramBundle, 10) & 0x1000000) != 0L)) {
        this.mSwiftTitleUI.a.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
      a();
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((this.webView != null) && (this.webView.getSettings() != null))
    {
      String str2 = Build.VERSION.RELEASE;
      int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
      String str1 = this.webView.getSettings().getUserAgentString();
      if (!StringUtil.a(str1))
      {
        paramBundle = str1;
        if (str1.contains("NowSDK/")) {}
      }
      else
      {
        paramBundle = str1 + " NowLive/" + 10305 + "_" + str2 + " NetType/" + i + " NowSDK/18_10.20";
      }
      this.webView.getSettings().setUserAgentString(paramBundle);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine != null) {
      this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.removeUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment
 * JD-Core Version:    0.7.0.1
 */