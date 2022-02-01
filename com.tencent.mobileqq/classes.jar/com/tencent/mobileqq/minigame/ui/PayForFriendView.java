package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.sdk.WebSettings;

public class PayForFriendView
  extends TouchWebView
{
  public static final String TAG = "[minigame] PayForFriendView";
  private BaseActivity mActivity;
  private String mAppIconUrl;
  private String mAppId;
  private String mAppName;
  private int mAppVerType;
  private String mAppVersionId;
  private TouchWebView mWebView;
  
  public PayForFriendView(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((BaseActivity)paramContext);
    initUI();
  }
  
  public PayForFriendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  private void initUI()
  {
    this.mWebView = this;
    this.mWebView.setBackgroundColor(0);
    this.mWebView.getBackground().setAlpha(0);
    this.mWebView.getSettings().setCacheMode(2);
    IQzoneWebViewPluginHelper localIQzoneWebViewPluginHelper = (IQzoneWebViewPluginHelper)QRoute.api(IQzoneWebViewPluginHelper.class);
    Context localContext = getContext();
    BaseActivity localBaseActivity = this.mActivity;
    new WebViewDirector((IWebViewBuilder)localIQzoneWebViewPluginHelper.getQzoneWebViewBaseBuilder(localContext, localBaseActivity, null, localBaseActivity.getAppInterface(), false, this.mWebView)).a(null, MiniAppUtils.getAppInterface(), null);
  }
  
  public String getAppIconUrl()
  {
    return this.mAppIconUrl;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public int getAppVerType()
  {
    return this.mAppVerType;
  }
  
  public String getAppVersionId()
  {
    return this.mAppVersionId;
  }
  
  public boolean setUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      this.mAppId = paramString2;
      this.mAppName = paramString3;
      this.mAppIconUrl = paramString4;
      this.mAppVersionId = paramString5;
      this.mAppVerType = paramInt;
      paramString1 = GameWnsUtils.getPayForFriendUrl().replace("{appid}", paramString2).replace("{prepayId}", paramString1);
      WebSoService.a().a();
      if (this.mWebView != null)
      {
        paramString2 = new StringBuilder();
        paramString2.append("setUrl url:");
        paramString2.append(paramString1);
        QLog.d("[minigame] PayForFriendView", 1, paramString2.toString());
        this.mWebView.loadUrl(paramString1);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.PayForFriendView
 * JD-Core Version:    0.7.0.1
 */