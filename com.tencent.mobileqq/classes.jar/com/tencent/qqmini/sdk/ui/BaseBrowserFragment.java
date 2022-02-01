package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.browser.BrowserPluginEngine;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

@MiniKeep
public class BaseBrowserFragment
  extends MiniBaseFragment
  implements View.OnClickListener
{
  private final String TAG = "BaseBrowserFragment";
  BrowserPluginEngine mBrowerEngin;
  ArrayMap<String, Object> mCoreDumpData;
  TextView mLeftBtnView;
  View mTitleBar;
  TextView mTitleView;
  private WebView mWebView;
  
  private void initCookie(Intent paramIntent, String paramString)
  {
    paramIntent = paramIntent.getStringExtra("cookie");
    if (!TextUtils.isEmpty(paramIntent))
    {
      Object localObject = paramIntent.replace(" ", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((Build.VERSION.SDK_INT < 21) && (getActivity() != null)) {
          CookieSyncManager.createInstance(getActivity());
        }
        paramIntent = CookieManager.getInstance();
        paramIntent.setAcceptCookie(true);
        localObject = ((String)localObject).split(";");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          paramIntent.setCookie(Uri.parse(paramString).getHost(), str);
          i += 1;
        }
      }
    }
    try
    {
      CookieSyncManager.getInstance().sync();
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  private void initLeftView(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("hide_left_button", false))
    {
      this.mLeftBtnView.setVisibility(4);
      return;
    }
    String str = paramIntent.getStringExtra("left_button_text");
    TextView localTextView = this.mLeftBtnView;
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = "返回";
    }
    localTextView.setText(paramIntent);
    this.mLeftBtnView.setOnClickListener(this);
  }
  
  private void initTitle(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("hide_title", false))
    {
      this.mTitleView.setVisibility(4);
      return;
    }
    String str = paramIntent.getStringExtra("title_text");
    TextView localTextView = this.mTitleView;
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = "";
    }
    localTextView.setText(paramIntent);
  }
  
  private void initView(Intent paramIntent, View paramView)
  {
    this.mTitleBar = paramView.findViewById(R.id.title_bar);
    this.mLeftBtnView = ((TextView)paramView.findViewById(R.id.ivTitleBtnLeft));
    this.mTitleView = ((TextView)paramView.findViewById(R.id.ivTitleName));
    this.mWebView = ((WebView)paramView.findViewById(R.id.web_view));
    initWebview();
    if (paramIntent.getBooleanExtra("hide_title_bar", false))
    {
      this.mTitleBar.setVisibility(8);
      return;
    }
    initLeftView(paramIntent);
    initTitle(paramIntent);
  }
  
  private void initWebview()
  {
    if (needWebViewTranslucent()) {
      this.mWebView.setBackgroundColor(0);
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      WebView localWebView = this.mWebView;
      WebView.setWebContentsDebuggingEnabled(true);
    }
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.setWebViewClient(new BaseBrowserFragment.1(this));
    this.mBrowerEngin = new BrowserPluginEngine(getActivity(), this.mWebView);
    this.mBrowerEngin.bindFragment(this);
  }
  
  private boolean isSchemeUrl(String paramString)
  {
    return (paramString.startsWith("mqqapi://")) || (paramString.startsWith("weixin://")) || (paramString.startsWith("sms://"));
  }
  
  private boolean isUrlBlank(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString));
  }
  
  private void processCoreDumpData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (this.mCoreDumpData == null) {
      this.mCoreDumpData = new ArrayMap(4);
    }
    this.mCoreDumpData.put("errorCode", Integer.valueOf(paramInt));
    this.mCoreDumpData.put("errorMsg", paramString1);
    this.mCoreDumpData.put("requestUrl", paramString2);
    paramString1 = this.mBrowerEngin;
    if ((paramString1 != null) && (paramInt >= 400)) {
      paramString1.handleEvent(paramString3, 1L, this.mCoreDumpData);
    }
  }
  
  protected boolean needWebViewTranslucent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ivTitleBtnLeft) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.mini_sdk_fragment_browser, paramViewGroup, false);
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    if (DisplayUtil.isImmersiveSupported) {
      paramLayoutInflater.setFitsSystemWindows(true);
    }
    paramViewGroup = getActivity().getIntent();
    if (paramViewGroup == null)
    {
      getActivity().finish();
      return null;
    }
    paramBundle = paramViewGroup.getStringExtra("url");
    if (StringUtil.isEmpty(paramBundle))
    {
      getActivity().finish();
      return null;
    }
    initView(paramViewGroup, paramLayoutInflater);
    initCookie(paramViewGroup, paramBundle);
    this.mWebView.loadUrl(paramBundle);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BrowserPluginEngine localBrowserPluginEngine = this.mBrowerEngin;
    if (localBrowserPluginEngine != null)
    {
      localBrowserPluginEngine.onDestroy();
      this.mBrowerEngin = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.BaseBrowserFragment
 * JD-Core Version:    0.7.0.1
 */