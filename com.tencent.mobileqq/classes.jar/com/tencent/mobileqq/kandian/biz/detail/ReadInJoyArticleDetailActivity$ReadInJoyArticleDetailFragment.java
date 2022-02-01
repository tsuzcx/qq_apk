package com.tencent.mobileqq.kandian.biz.detail;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.Companion;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticleOptimizeUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.DoShareClick;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJPageGenerator;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment
  extends WebViewFragment
{
  public static final String a = "ReadInJoyArticleDetailFragment";
  public long a;
  public ImageView a;
  ReadInJoyFastWebBottomSocialViewNew.DoShareClick a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  private String c;
  public long d;
  private String d;
  public long e = 0L;
  
  public ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$DoShareClick = new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.5(this);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = RIJWebArticleUtil.a.i();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[loadCacheHtml] webLoadUrlOptimize = ");
    localStringBuilder.append(bool);
    QLog.i(str, 1, localStringBuilder.toString());
    if (!bool) {
      return false;
    }
    str = RIJPageGenerator.INSTANCE.getPageHtmlStringFromUrl(paramString);
    if (!TextUtils.isEmpty(str))
    {
      this.webView.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", paramString);
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadCacheHtml] hit cache, url = ");
      localStringBuilder.append(paramString);
      QLog.i(str, 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private void b()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = (AppInterface)((AppRuntime)localObject1).getAppRuntime("modular_web");
      if (localObject1 != null)
      {
        Object localObject2 = BaseApplicationImpl.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_public_account_with_cuin_");
        localStringBuilder.append(((AppInterface)localObject1).getCurrentAccountUin());
        localObject1 = ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("readInJoy_loading_img", false);
          if (QLog.isColorLevel())
          {
            localObject1 = jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("showGif");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
            QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
  }
  
  private void c()
  {
    long l1 = this.intent.getLongExtra("click_time", -1L);
    long l2 = this.intent.getLongExtra("available_memory", -1L);
    boolean bool = this.intent.getBooleanExtra("preload_tool_white_list", false);
    int i;
    if (getStatistics().t) {
      i = 2;
    } else if (SwiftBrowserStatistics.p) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 1;
    } else if (SwiftBrowserStatistics.o) {
      i = 2;
    } else {
      i = 0;
    }
    if (l1 > 0L) {
      ThreadManager.post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.4(this, l2, l1, i, bool), 8, null, true);
    }
  }
  
  private void d()
  {
    if (this.intent != null)
    {
      if (this.intent.getExtras() == null) {
        return;
      }
      Object localObject1 = this.intent.getExtras();
      this.jdField_c_of_type_JavaLangString = ((Bundle)localObject1).getString("row_key", "");
      Object localObject2 = ((Bundle)localObject1).getString("url");
      localObject2 = ((IRIJWebArticleOptimizeUtil)QRoute.api(IRIJWebArticleOptimizeUtil.class)).getWebUrlWithOptimization((String)localObject2);
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl((String)localObject2))
      {
        localObject2 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).addSkinParams((String)localObject2);
        ((Bundle)localObject1).putString("url", (String)localObject2);
        this.intent.putExtra("url", (String)localObject2);
      }
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[initData] url = ");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (RIJPageGenerator.INSTANCE.isPageHtmlExist(this.jdField_c_of_type_JavaLangString)) && (getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null)) {
      getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  @TargetApi(14)
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.3(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if ((getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView != null) && (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView != null) && (getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if ((!getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!getUIStyle().m))
      {
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849807);
        getSwiftTitleUI().c(-16777216);
      }
      else
      {
        paramBundle = ImageUtil.a(getResources().getDrawable(2130849807), -1);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
        getSwiftTitleUI().c(-1);
      }
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(Bundle paramBundle, TouchWebView paramTouchWebView, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    paramWebViewKernelCallBack.onWebViewInit(paramBundle, paramTouchWebView);
    if (paramTouchWebView != null) {
      paramTouchWebView.setMask(false);
    }
    boolean bool = this.intent.getExtras().getBoolean("ip_connect", false);
    if ((paramTouchWebView != null) && (bool))
    {
      paramBundle = paramTouchWebView.getSettingsExtension();
      int i = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel())
      {
        paramTouchWebView = jdField_a_of_type_JavaLangString;
        paramWebViewKernelCallBack = new StringBuilder();
        paramWebViewKernelCallBack.append("tbsCoreVersion: ");
        paramWebViewKernelCallBack.append(i);
        QLog.d(paramTouchWebView, 2, paramWebViewKernelCallBack.toString());
      }
      if ((paramBundle != null) && (i >= 36855))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "rij webview use ip connect");
        }
        paramTouchWebView = new ArrayList();
        paramTouchWebView.add("post.mp.qq.com");
        paramTouchWebView.add("*.qpic.cn");
        paramBundle.setHttpDnsDomains(paramTouchWebView);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramBundle = jdField_a_of_type_JavaLangString;
      paramTouchWebView = new StringBuilder();
      paramTouchWebView.append("ipConnect: ");
      paramTouchWebView.append(bool);
      QLog.d(paramBundle, 2, paramTouchWebView.toString());
    }
  }
  
  public void a(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    if (getUIStyleHandler().c) {
      return;
    }
    paramWebViewKernelCallBack.onShowPreview(paramBundle);
    if ((getSwiftTitleUI() != null) && (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView != null) && (getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView != null) && (getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup != null))
    {
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849814);
      getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849807);
      if ((!getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!getUIStyle().m))
      {
        getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
        getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
        if (getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
          getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setCustomColor(-1);
        }
        if (getWebTitleBarInterface().a() != null)
        {
          getWebTitleBarInterface().a().setBackgroundColor(-1);
          getUIStyle().i = true;
        }
        getSwiftTitleUI().d(-16777216);
        getSwiftTitleUI().f(-16777216);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849814);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849807);
        getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if (this.mNightMode)
    {
      paramBundle = new View(getQBaseActivity());
      paramBundle.setBackgroundColor(1996488704);
      getQBaseActivity().addContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    }
    RIJSocialBottomUtils.a.a(this.intent.getExtras(), getActivity(), getContentView(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$DoShareClick);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    boolean bool = getStatistics().i;
    paramWebViewKernelCallBack.onPageStarted(paramWebView, paramString, paramBitmap);
    if (bool) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    e();
    RIJSocialBottomUtils.a.a(false, this.jdField_d_of_type_JavaLangString, paramString);
  }
  
  public void a(WebView paramWebView, String paramString, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    boolean bool = getStatistics().j;
    paramWebViewKernelCallBack.onPageFinished(paramWebView, paramString);
    if (bool)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = true;
      paramWebView = BaseApplicationImpl.getApplication().getRuntime();
      if (paramWebView != null)
      {
        if (FeedsSPUtils.a(paramWebView)) {
          paramWebView = "1";
        } else {
          paramWebView = "0";
        }
        this.jdField_b_of_type_JavaLangString = paramWebView;
      }
      c();
    }
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 511, new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.1(this));
  }
  
  @TargetApi(12)
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    d();
    Object localObject = this.intent.getExtras();
    boolean bool;
    try
    {
      bool = super.doOnCreate(paramBundle);
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      bool = false;
    }
    paramBundle = ((Bundle)localObject).getString("preload_iamge_url");
    if ((this.webView != null) && (this.webView.getPluginEngine() != null))
    {
      localObject = (PubAccountPreloadPlugin)this.webView.getPluginEngine().a("pubAccountPreload");
      if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
        ((PubAccountPreloadPlugin)localObject).a(paramBundle, true);
      }
    }
    b();
    return bool;
  }
  
  public WebUiUtils.WebTitleBarInterface getWebTitleBarInterface()
  {
    return new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2(this, this.webViewSurface);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.6(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    if (!this.jdField_b_of_type_Boolean) {
      c();
    }
    RIJSocialBottomUtils.a.a();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment
 * JD-Core Version:    0.7.0.1
 */