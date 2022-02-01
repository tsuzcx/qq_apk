package com.tencent.mobileqq.minigame.publicaccount;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.MiniGamePubViewpager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGamePublicAccountWebFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static final String EMPTY_IMG_URL = "https://sola.gtimg.cn/aoi/sola/20200717141546_FIOiVDF9l3.png";
  private static final int GAME_STORE_HEIGHT = 0;
  private static final int MORE_MSG_MARGIN = 20;
  public static final String TAG = "MiniGamePublicAccountWebFragment";
  public URLImageView emptyImage;
  public LinearLayout emptyLayout;
  public long enterQQGamePubTime;
  private List<Boolean> exposeReported = new ArrayList();
  private EIPCResultCallback getMsgCallback = new MiniGamePublicAccountWebFragment.1(this);
  public MiniGamePublicAccountHeadLayout headLayout;
  public View headerLayoutBg;
  public long initUiTime;
  public long initWebViewTime;
  public View layoutTitleBar;
  public LinearLayout loadLayout;
  public long loadUrlEndTime;
  private GestureDetector mGestureDetector;
  public MiniGamePublicAccountViewPagerIndicator mIndicator;
  private List<QQGameMsgInfo> mMsgInfoList;
  private MiniGamePublicAccountUIController mUiController = new MiniGamePublicAccountUIController(this);
  public TextView moreMsgBtn;
  public RelativeLayout moreMsgLayout;
  public TextView moreMsgText;
  public TextView navTitle;
  public BaseHeaderAdapter pagerAdapter;
  public LinearLayout pagerContainer;
  public long parsePageEndTime;
  public View rootView;
  public long startTime = 0L;
  public MiniGamePublicAccountNavBar titleBar;
  public MiniGamePubViewpager viewPager;
  public MiniGamePublicAccountWebView webView;
  private MiniGamePublicAccountWebViewBuilder webViewBuilder;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  private boolean checkTianshuData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        JSONObject localJSONObject2 = new JSONObject(paramString);
        JSONObject localJSONObject1 = localJSONObject2.optJSONObject("xmodal");
        paramString = localJSONObject1;
        if (localJSONObject1 == null)
        {
          paramString = localJSONObject2.optJSONObject("notification");
          if (paramString == null) {}
        }
        else if (paramString.optBoolean("isFromPublicLandingPage", false))
        {
          paramString = paramString.optJSONObject("tianshuAdData");
          if ((paramString != null) && (!TextUtils.isEmpty(paramString.optString("adId"))))
          {
            boolean bool = TextUtils.isEmpty(paramString.optString("appid"));
            if (!bool) {
              return true;
            }
          }
        }
      }
      catch (JSONException paramString) {}
    }
    return false;
  }
  
  private void getGameMsgList()
  {
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_get_mini_game_public_account_msg", null, this.getMsgCallback);
  }
  
  private int getWebHeaderHeight()
  {
    if ((getActivity() != null) && (isAdded()))
    {
      if (this.pagerContainer.getVisibility() == 0) {}
      for (int i = this.pagerContainer.getMeasuredHeight();; i = this.emptyLayout.getMeasuredHeight())
      {
        float f = 0;
        return (int)(AIOUtils.a(i + this.moreMsgLayout.getMeasuredHeight(), getResources()) + 20.0F + f);
      }
    }
    return 0;
  }
  
  private void gotoAccountDetail()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(getActivity(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
    localActivityURIRequest.extra().putBoolean("fromMiniGamePub", true);
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  private void handleDefaultLoading()
  {
    if (this.loadLayout == null) {
      return;
    }
    this.loadLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.a(7.0F, getActivity().getResources());
    localTextView.setText(HardCodeUtil.a(2131710270));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130847540);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130847540);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(AIOUtils.a(15.0F, getActivity().getResources()), AIOUtils.a(15.0F, getActivity().getResources()));
    this.loadLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.loadLayout.addView(localTextView, localLayoutParams);
  }
  
  private void initHead(View paramView)
  {
    this.headLayout = ((MiniGamePublicAccountHeadLayout)paramView.findViewById(2063794194));
    this.webView = ((MiniGamePublicAccountWebView)paramView.findViewById(2063794195));
    this.headLayout.attachToRootView();
    this.webView.attachHeaderView(this.headLayout);
    this.pagerContainer = ((LinearLayout)this.headLayout.findViewById(2063794185));
    this.viewPager = ((MiniGamePubViewpager)this.headLayout.findViewById(2063794178));
    this.mIndicator = ((MiniGamePublicAccountViewPagerIndicator)this.headLayout.findViewById(2063794191));
    this.moreMsgText = ((TextView)this.headLayout.findViewById(2063794190));
    this.moreMsgBtn = ((TextView)this.headLayout.findViewById(2063794188));
    this.moreMsgLayout = ((RelativeLayout)this.headLayout.findViewById(2063794189));
    this.emptyLayout = ((LinearLayout)this.headLayout.findViewById(2063794176));
    this.emptyImage = ((URLImageView)this.headLayout.findViewById(2063794177));
    this.headerLayoutBg = this.headLayout.findViewById(2063794182);
    this.moreMsgBtn.setOnClickListener(this);
    this.emptyImage.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200717141546_FIOiVDF9l3.png");
    this.pagerAdapter = this.mUiController.createAdapter(getActivity());
    this.viewPager.setAdapter(this.pagerAdapter);
    this.viewPager.setOffscreenPageLimit(3);
    this.mIndicator.setViewPager(this.viewPager);
    this.mIndicator.setIndicatorViewConfig(this.mUiController.getIndicatorViewConfig());
    this.mIndicator.refreshIndicator();
    this.mIndicator.setOnPageSelectedListener(new MiniGamePublicAccountWebFragment.2(this));
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_minigame", "expo", null, null, null);
  }
  
  private void initLoad(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    try
    {
      this.loadLayout = ((LinearLayout)paramView.findViewById(2063794187));
      int j = AIOUtils.a(418.0F, getActivity().getResources());
      localObject = this.loadLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = AIOUtils.a(i - j, getActivity().getResources());
      this.loadLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (IPreloadServiceProxy)BaseApplicationImpl.getApplication().peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, "multi");
      if (TextUtils.isEmpty(PreloadStaticApi.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
      {
        handleDefaultLoading();
        ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.3(this));
        return;
      }
    }
    catch (Exception paramView)
    {
      this.loadLayout = null;
      return;
    }
    ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.4(this, paramView));
  }
  
  private void refreshHead(int paramInt)
  {
    if (this.pagerAdapter != null)
    {
      this.pagerAdapter.setData(this.mMsgInfoList);
      this.mIndicator.refreshIndicator();
      if (paramInt != -1) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new MiniGamePublicAccountWebFragment.9(this, paramInt), 200L);
      }
    }
  }
  
  private void reportBrowsetTime()
  {
    if (this.startTime < 0L) {}
    long l;
    do
    {
      return;
      l = SystemClock.elapsedRealtime() - this.startTime;
    } while (l <= 0L);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_ark_test", "period", String.valueOf(l), null, null);
  }
  
  private void reportMsgExpose(int paramInt, boolean paramBoolean)
  {
    if (paramInt < this.mMsgInfoList.size()) {}
    for (QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.mMsgInfoList.get(paramInt);; localQQGameMsgInfo = null)
    {
      if (localQQGameMsgInfo == null) {}
      while (((Boolean)this.exposeReported.get(paramInt)).booleanValue()) {
        return;
      }
      this.exposeReported.set(paramInt, Boolean.valueOf(true));
      if (paramBoolean) {
        ark.arkNotify(localQQGameMsgInfo.arkAppName, "msg_expose", localQQGameMsgInfo.arkMetaList, "json");
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_ark_test", "expo", localQQGameMsgInfo.advId, null, null);
      return;
    }
  }
  
  public void enterAIO(boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131694214));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_more", "click", null, null, null);
      if (paramBoolean) {
        getActivity().finish();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePublicAccountWebFragment", 1, "enterAIO error", localThrowable);
    }
  }
  
  public void initTitle(View paramView)
  {
    this.layoutTitleBar = paramView.findViewById(2063794186);
    this.titleBar = ((MiniGamePublicAccountNavBar)paramView.findViewById(2063794196));
    this.titleBar.setTitleBarTransparent();
    this.navTitle = this.titleBar.getTitleTextView();
    this.navTitle.setText(2131694214);
    this.navTitle.setTextColor(-1);
    this.titleBar.setOnItemSelectListener(new MiniGamePublicAccountWebFragment.6(this));
    initTitleEvent();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void initTitleEvent()
  {
    this.mGestureDetector = new GestureDetector(getActivity(), new MiniGamePublicAccountWebFragment.7(this));
    this.navTitle.setOnTouchListener(new MiniGamePublicAccountWebFragment.8(this));
  }
  
  public long initWebView()
  {
    long l = SystemClock.elapsedRealtime();
    if (this.webView == null) {
      this.webView = new MiniGamePublicAccountWebView(getActivity());
    }
    this.webViewBuilder = new MiniGamePublicAccountWebFragment.5(this, getActivity(), getActivity(), CmGameUtil.a(), this.webView);
    this.webViewBuilder.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.webViewBuilder).a(null, CmGameUtil.a(), null);
    this.webView = ((MiniGamePublicAccountWebView)this.webViewBuilder.getWebView());
    this.webView.setWillNotCacheDrawing(false);
    this.webView.setDrawingCacheEnabled(true);
    if ((getActivity() != null) && (getActivity().getIntent() != null)) {
      getActivity().getIntent().putExtra("ignoreLoginWeb", true);
    }
    return SystemClock.elapsedRealtime() - l;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void notifyWebHeaderHeight(int paramInt)
  {
    try
    {
      if (this.webView != null)
      {
        WebViewPluginEngine localWebViewPluginEngine = this.webView.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          HashMap localHashMap = new HashMap();
          if (paramInt != -1) {
            localHashMap.put("height", Integer.valueOf(paramInt));
          }
          localWebViewPluginEngine.a(this.webView.getUrl(), 8589934624L, localHashMap);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePublicAccountWebFragment", 1, "notify web error", localThrowable);
    }
  }
  
  public boolean onBackEvent()
  {
    reportBrowsetTime();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    enterAIO(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.startTime = SystemClock.elapsedRealtime();
    getGameMsgList();
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("startTime")))
    {
      long l = getActivity().getIntent().getLongExtra("startTime", 0L);
      if (l > 0L) {
        this.enterQQGamePubTime = (SystemClock.elapsedRealtime() - l);
      }
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2063859714, paramViewGroup, false);
    this.rootView = paramLayoutInflater.findViewById(2063794198);
    initHead(paramLayoutInflater);
    this.initUiTime = (SystemClock.elapsedRealtime() - this.startTime);
    this.initWebViewTime = initWebView();
    initTitle(paramLayoutInflater);
    initLoad(paramLayoutInflater);
    this.mUiController.setupStrategy();
    this.mUiController.initGameCenter(getActivity(), this.rootView, this.webView);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.pagerAdapter != null) {
      this.pagerAdapter.onDestroy();
    }
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onDestroy();
    }
  }
  
  public void onDestroyView()
  {
    if (this.pagerAdapter != null) {
      this.pagerAdapter.onDestroyView();
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onPause();
    }
    if (this.pagerAdapter != null) {
      this.pagerAdapter.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onResume();
    }
    if (this.pagerAdapter != null) {
      this.pagerAdapter.onResume();
    }
    try
    {
      int i = this.mMsgInfoList.size();
      if ((this.viewPager != null) && (i > 0) && (this.viewPager.getCurrentItem() == i)) {
        this.viewPager.setCurrentItem(i - 1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("MiniGamePublicAccountWebFragment", 1, "onResume catch: ", localThrowable);
      }
    }
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_do_on_resume", null, null);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment
 * JD-Core Version:    0.7.0.1
 */