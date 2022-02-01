package com.tencent.mobileqq.minigame.publicaccount;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
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
import mqq.app.MobileQQ;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("xmodal");
      paramString = localJSONObject1;
      if (localJSONObject1 == null)
      {
        localJSONObject1 = localJSONObject2.optJSONObject("notification");
        paramString = localJSONObject1;
        if (localJSONObject1 == null) {
          return false;
        }
      }
      if (!paramString.optBoolean("isFromPublicLandingPage", false)) {
        return false;
      }
      paramString = paramString.optJSONObject("tianshuAdData");
      if (paramString == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramString.optString("adId"))) {
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramString.optString("appid"));
      return !bool;
    }
    catch (JSONException paramString) {}
    return false;
  }
  
  private void getGameMsgList()
  {
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_get_mini_game_public_account_msg", null, this.getMsgCallback);
  }
  
  private AppInterface getToolAppRuntime()
  {
    return (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
  }
  
  private int getWebHeaderHeight()
  {
    Object localObject = getActivity();
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (isAdded())
      {
        if (this.pagerContainer.getVisibility() == 0) {
          localObject = this.pagerContainer;
        } else {
          localObject = this.emptyLayout;
        }
        i = ((LinearLayout)localObject).getMeasuredHeight();
        i = (int)(0 + (AIOUtils.a(i + this.moreMsgLayout.getMeasuredHeight(), getResources()) + 20.0F));
      }
    }
    return i;
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
    Object localObject1 = this.loadLayout;
    if (localObject1 == null) {
      return;
    }
    ((LinearLayout)localObject1).removeAllViews();
    localObject1 = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.b(7.0F, getActivity().getResources());
    ((TextView)localObject1).setText(HardCodeUtil.a(2131907946));
    ((TextView)localObject1).setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = getActivity().getResources().getDrawable(2130849062);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getActivity().getResources().getDrawable(2130849062);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject2));
    localImageView.setVisibility(0);
    localObject2 = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject2).setRepeatCount(-1);
    ((Animation)localObject2).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject2);
    localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(15.0F, getActivity().getResources()), AIOUtils.b(15.0F, getActivity().getResources()));
    this.loadLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
    this.loadLayout.addView((View)localObject1, localLayoutParams);
  }
  
  private void initHead(View paramView)
  {
    this.headLayout = ((MiniGamePublicAccountHeadLayout)paramView.findViewById(2030305322));
    this.webView = ((MiniGamePublicAccountWebView)paramView.findViewById(2030305323));
    this.headLayout.attachToRootView();
    this.webView.attachHeaderView(this.headLayout);
    this.pagerContainer = ((LinearLayout)this.headLayout.findViewById(2030305311));
    this.viewPager = ((MiniGamePubViewpager)this.headLayout.findViewById(2030305301));
    this.mIndicator = ((MiniGamePublicAccountViewPagerIndicator)this.headLayout.findViewById(2030305318));
    this.moreMsgText = ((TextView)this.headLayout.findViewById(2030305317));
    this.moreMsgBtn = ((TextView)this.headLayout.findViewById(2030305315));
    this.moreMsgLayout = ((RelativeLayout)this.headLayout.findViewById(2030305316));
    this.emptyLayout = ((LinearLayout)this.headLayout.findViewById(2030305298));
    this.emptyImage = ((URLImageView)this.headLayout.findViewById(2030305299));
    this.headerLayoutBg = this.headLayout.findViewById(2030305305);
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
      this.loadLayout = ((LinearLayout)paramView.findViewById(2030305313));
      int j = AIOUtils.b(418.0F, getActivity().getResources());
      localObject = this.loadLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = AIOUtils.b(i - j, getActivity().getResources());
      this.loadLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (IPreloadServiceProxy)BaseApplicationImpl.getApplication().peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, "multi");
      if (TextUtils.isEmpty(PreloadStaticApi.b("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
      {
        handleDefaultLoading();
        ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.3(this));
        return;
      }
      ((IPreloadServiceProxy)localObject).getResPath("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.4(this, paramView));
      return;
    }
    catch (Exception paramView)
    {
      label177:
      break label177;
    }
    this.loadLayout = null;
  }
  
  private void refreshHead(int paramInt)
  {
    BaseHeaderAdapter localBaseHeaderAdapter = this.pagerAdapter;
    if (localBaseHeaderAdapter != null)
    {
      localBaseHeaderAdapter.setData(this.mMsgInfoList);
      this.mIndicator.refreshIndicator();
      if (paramInt != -1) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new MiniGamePublicAccountWebFragment.9(this, paramInt), 200L);
      }
    }
  }
  
  private void reportBrowsetTime()
  {
    if (this.startTime < 0L) {
      return;
    }
    long l = SystemClock.elapsedRealtime() - this.startTime;
    if (l > 0L) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_ark_test", "period", String.valueOf(l), null, null);
    }
  }
  
  private void reportMsgExpose(int paramInt, boolean paramBoolean)
  {
    QQGameMsgInfo localQQGameMsgInfo;
    if (paramInt < this.mMsgInfoList.size()) {
      localQQGameMsgInfo = (QQGameMsgInfo)this.mMsgInfoList.get(paramInt);
    } else {
      localQQGameMsgInfo = null;
    }
    if (localQQGameMsgInfo == null) {
      return;
    }
    if (((Boolean)this.exposeReported.get(paramInt)).booleanValue()) {
      return;
    }
    this.exposeReported.set(paramInt, Boolean.valueOf(true));
    if (paramBoolean) {
      ((IArkAPIService)QRoute.api(IArkAPIService.class)).postArkNotify(localQQGameMsgInfo.arkAppName, "msg_expose", localQQGameMsgInfo.arkMetaList);
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_ark_test", "expo", localQQGameMsgInfo.advId, null, null);
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
      localIntent.putExtra("uinname", getString(2131891810));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_more", "click", null, null, null);
      if (paramBoolean)
      {
        getActivity().finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePublicAccountWebFragment", 1, "enterAIO error", localThrowable);
    }
  }
  
  public void initTitle(View paramView)
  {
    this.layoutTitleBar = paramView.findViewById(2030305312);
    this.titleBar = ((MiniGamePublicAccountNavBar)paramView.findViewById(2030305324));
    this.titleBar.setTitleBarTransparent();
    this.navTitle = this.titleBar.getTitleTextView();
    this.navTitle.setText(2131891810);
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
    this.webViewBuilder = new MiniGamePublicAccountWebFragment.5(this, getActivity(), getActivity(), getToolAppRuntime(), this.webView);
    this.webViewBuilder.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.webViewBuilder).a(null, getToolAppRuntime(), null);
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
          return;
        }
      }
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
    if (paramView.getId() != 2030305315) {
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
    paramLayoutInflater = paramLayoutInflater.inflate(2030370824, paramViewGroup, false);
    this.rootView = paramLayoutInflater.findViewById(2030305326);
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
    Object localObject = this.pagerAdapter;
    if (localObject != null) {
      ((BaseHeaderAdapter)localObject).onDestroy();
    }
    localObject = this.webViewBuilder;
    if (localObject != null) {
      ((MiniGamePublicAccountWebViewBuilder)localObject).onDestroy();
    }
  }
  
  public void onDestroyView()
  {
    BaseHeaderAdapter localBaseHeaderAdapter = this.pagerAdapter;
    if (localBaseHeaderAdapter != null) {
      localBaseHeaderAdapter.onDestroyView();
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.webViewBuilder;
    if (localObject != null) {
      ((MiniGamePublicAccountWebViewBuilder)localObject).onPause();
    }
    localObject = this.pagerAdapter;
    if (localObject != null) {
      ((BaseHeaderAdapter)localObject).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.webViewBuilder;
    if (localObject != null) {
      ((MiniGamePublicAccountWebViewBuilder)localObject).onResume();
    }
    localObject = this.pagerAdapter;
    if (localObject != null) {
      ((BaseHeaderAdapter)localObject).onResume();
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
      QLog.w("MiniGamePublicAccountWebFragment", 1, "onResume catch: ", localThrowable);
    }
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_do_on_resume", null, null);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment
 * JD-Core Version:    0.7.0.1
 */