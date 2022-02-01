package com.tencent.mobileqq.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.ui.WebViewTitlerBar;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.AppRuntime;

public class WebViewBaseBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public static final String TAG = "WebViewBaseBuilder";
  protected boolean bFitSystemWindow = true;
  protected boolean bNeedStatusTrans = true;
  public FrameLayout bottomContainer;
  public LinearLayout contentContainer;
  public String leftName;
  protected AppRuntime mAppInterface;
  protected Context mContext;
  protected Activity mInActivity;
  protected Intent mIntent;
  protected SystemBarCompact mSystemBarComp;
  public WebViewTitlerBar mTitleBar;
  public View mViewRoot;
  public View maskView;
  public FrameLayout titleContainer;
  public String titleText;
  public RelativeLayout webviewContainer;
  
  public WebViewBaseBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppRuntime paramAppRuntime)
  {
    super(paramContext, paramActivity, paramAppRuntime);
    this.mContext = paramContext;
    this.mInActivity = paramActivity;
    this.mIntent = paramIntent;
    this.mAppInterface = paramAppRuntime;
  }
  
  @TargetApi(14)
  private void initLayout()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "initLayout");
    }
    Object localObject = LayoutInflater.from(this.mContext).inflate(2131563048, null);
    this.mInActivity.setContentView((View)localObject);
    this.mViewRoot = ((View)localObject).findViewById(2131381061);
    if ((this.bNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.mViewRoot.setFitsSystemWindows(this.bFitSystemWindow);
    }
    this.titleContainer = ((FrameLayout)this.mViewRoot.findViewById(2131378823));
    this.bottomContainer = ((FrameLayout)this.mViewRoot.findViewById(2131363733));
    this.webviewContainer = ((RelativeLayout)this.mViewRoot.findViewById(2131381078));
    this.mLoadProgress = ((ProgressBar)this.mViewRoot.findViewById(2131376345));
    this.maskView = this.mViewRoot.findViewById(2131381081);
    this.contentContainer = ((LinearLayout)this.mViewRoot.findViewById(2131365179));
    localObject = this.mIntent;
    if ((localObject != null) && (!((Intent)localObject).getBooleanExtra("webview_hide_progress", false)))
    {
      this.mLoadingProgressBar = ((WebViewProgressBar)this.mViewRoot.findViewById(2131373133));
      this.mProgressBarController = new WebViewProgressBarController();
      this.mLoadingProgressBar.setController(this.mProgressBarController);
      if ((isIsFirstOnPageStart()) && (this.mProgressBarController != null) && (this.mProgressBarController.b() != 0)) {
        this.mProgressBarController.a((byte)0);
      }
    }
  }
  
  public void addBottomView(View paramView)
  {
    try
    {
      this.bottomContainer.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      this.bottomContainer.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void addContentView(View paramView)
  {
    try
    {
      this.contentContainer.addView(paramView);
      this.contentContainer.setVisibility(0);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void addTitleView(View paramView)
  {
    try
    {
      this.titleContainer.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      this.titleContainer.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  protected void adjustLayout(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "adjustLayout");
    }
    int i = ImmersiveUtils.getStatusBarHeight(this.mContext);
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.b.getLayoutParams();
      localLayoutParams.topMargin = i;
      paramImmersiveParam.b.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.a.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localLayoutParams.addRule(3, 0);
      paramImmersiveParam.a.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.b.getLayoutParams();
    localLayoutParams.topMargin = i;
    paramImmersiveParam.b.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.a.getLayoutParams();
    localLayoutParams.topMargin = (DisplayUtil.a(this.mContext, 50.0F) + i);
    paramImmersiveParam.a.setLayoutParams(localLayoutParams);
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildLayout");
    }
    initLayout();
    this.mWebview = new TouchWebView(this.mContext);
    this.mWebview.setId(2131381075);
    this.webviewContainer.addView(this.mWebview);
  }
  
  @TargetApi(14)
  public void buildLayout(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildLayout...context");
    }
    initLayout();
    this.mWebview = new TouchWebView(paramContext);
    this.mWebview.setId(2131381075);
    this.webviewContainer.addView(this.mWebview, 0, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void buildTitleBar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildTitleBar");
    }
    this.mTitleBar = new WebViewTitlerBar(this.mInActivity, this.mWebview, this.titleContainer);
    this.titleContainer.setBackgroundResource(2130850433);
    Intent localIntent = this.mIntent;
    if (localIntent != null)
    {
      this.titleText = localIntent.getStringExtra("webview_title");
      this.leftName = this.mIntent.getStringExtra("webview_left_name");
      if (!TextUtils.isEmpty(this.titleText)) {
        this.mTitleBar.b(this.titleText);
      }
      if (!TextUtils.isEmpty(this.leftName)) {
        this.mTitleBar.a(this.leftName);
      }
    }
    this.mTitleBar.a(new WebViewBaseBuilder.1(this));
  }
  
  public final void buildWebView(AppRuntime paramAppRuntime)
  {
    super.buildBaseWebView(paramAppRuntime);
    onWebViewReady();
  }
  
  public void finish() {}
  
  public boolean handleMessageImp(Message paramMessage)
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    super.doOnBackPressed(this.mAppInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onCreate");
    }
    paramBundle = this.mIntent;
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("window_no_title", true))) {
      this.mInActivity.requestWindowFeature(1);
    }
    if ((this.bNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.mInActivity.getWindow().addFlags(67108864);
      int i = this.mInActivity.getResources().getColor(2131167114);
      this.mSystemBarComp = new SystemBarCompact(this.mInActivity, true, i);
      this.mSystemBarComp.init();
    }
    super.doOnCreate(this.mIntent);
  }
  
  public void onDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void onImmersive(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onImmersive");
    }
    if (paramBoolean)
    {
      localSystemBarCompact = this.mSystemBarComp;
      if (localSystemBarCompact != null) {
        localSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
      paramImmersiveParam.b.getBackground().setAlpha(0);
      return;
    }
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(true, 0);
    }
    paramImmersiveParam.b.setBackgroundResource(2130850433);
    this.mTitleBar.a(255, 0);
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  @TargetApi(14)
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onResume");
    }
    super.doOnResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStop() {}
  
  public void onWebViewReady()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onWebViewReady");
    }
    Object localObject = this.mIntent;
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("url");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mWebview.loadUrl((String)localObject);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public void setContentViewShow(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.contentContainer;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
  }
  
  protected final void setTittlebarImmersive(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "setTittlebarImmersive");
    }
    adjustLayout(paramBoolean, paramImmersiveParam);
    onImmersive(paramBoolean, paramImmersiveParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewBaseBuilder
 * JD-Core Version:    0.7.0.1
 */