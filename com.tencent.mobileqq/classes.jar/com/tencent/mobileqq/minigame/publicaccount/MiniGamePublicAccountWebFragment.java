package com.tencent.mobileqq.minigame.publicaccount;

import afur;
import aksh;
import akwh;
import ampj;
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
import anhk;
import anni;
import aprd;
import auuq;
import bcnj;
import bhmg;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGamePublicAccountWebFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final int GAME_STORE_HEIGHT = 55;
  private static final int MORE_MSG_MARGIN = 20;
  public static final String TAG = "MiniGamePublicAccountWebFragment";
  private List<String> arkAppNameList = new ArrayList();
  private View contentView;
  private auuq currIHeaderView;
  public long enterQQGamePubTime;
  private List<Boolean> exposeReported = new ArrayList();
  private EIPCResultCallback getMsgCallback = new MiniGamePublicAccountWebFragment.1(this);
  public long initUiTime;
  public long initWebViewTime;
  private LinearLayout loadLayout;
  public long loadUrlEndTime;
  private GestureDetector mGestureDetector;
  List<auuq> mHeaderRecords = new ArrayList();
  private MiniGamePublicAccountViewPagerIndicator mIndicator;
  private RelativeLayout moreMsgLayout;
  private List<QQGameMsgInfo> msgInfoList;
  private TextView navTitle;
  private MiniGamePublicAccountWebFragment.HeadPageAdapter pagerAdapter;
  private LinearLayout pagerContainer;
  public long parsePageEndTime;
  public long startTime;
  public MiniGamePublicAccountNavBar titleBar;
  private QQGamePubViewpager viewPager;
  private MiniGamePublicAccountWebView webView;
  private MiniGamePublicAccountWebViewBuilder webViewBuilder;
  
  static
  {
    aprd.a(true);
    aprd.a();
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
  
  private void enterAIO()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getActivity(), SplashActivity.class.getName());
      localIntent = afur.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(getActivity(), ChatActivity.class);
      localIntent.putExtra("uin", anhk.aW);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", getString(2131693707));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      getActivity().startActivity(localIntent);
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_more", "click", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGamePublicAccountWebFragment", 1, "enterAIO error", localThrowable);
    }
  }
  
  private void getGameMsgList()
  {
    QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", "action_get_mini_game_public_account_msg", null, this.getMsgCallback);
  }
  
  private int getWebHeaderHeight()
  {
    int j = 55;
    int i = j;
    if (getActivity() != null)
    {
      i = j;
      if (isAdded())
      {
        i = j;
        if (this.pagerContainer.getVisibility() == 0) {
          i = (int)(55 + (afur.a(this.pagerContainer.getMeasuredHeight() + this.moreMsgLayout.getMeasuredHeight(), getResources()) + 20.0F));
        }
      }
    }
    return i;
  }
  
  private void gotoAccountDetail()
  {
    Intent localIntent = new Intent(getActivity(), AccountDetailActivity.class);
    localIntent.putExtra("uin", anhk.aW);
    localIntent.putExtra("fromMiniGamePub", true);
    startActivity(localIntent);
  }
  
  private void handleDefaultLoading()
  {
    this.loadLayout.removeAllViews();
    TextView localTextView = new TextView(getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = afur.a(7.0F, getActivity().getResources());
    localTextView.setText(anni.a(2131709066));
    localTextView.setTextColor(2130706432);
    ImageView localImageView = new ImageView(getActivity());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getActivity().getResources().getDrawable(2130847160);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2130847160);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    localImageView.startAnimation((Animation)localObject);
    localObject = new LinearLayout.LayoutParams(afur.a(15.0F, getActivity().getResources()), afur.a(15.0F, getActivity().getResources()));
    this.loadLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.loadLayout.addView(localTextView, localLayoutParams);
  }
  
  private void initHead(View paramView)
  {
    MiniGamePublicAccountHeadLayout localMiniGamePublicAccountHeadLayout = (MiniGamePublicAccountHeadLayout)paramView.findViewById(2131374372);
    this.webView = ((MiniGamePublicAccountWebView)paramView.findViewById(2131374373));
    localMiniGamePublicAccountHeadLayout.attachToRootView();
    this.webView.attachHeaderView(localMiniGamePublicAccountHeadLayout);
    this.pagerContainer = ((LinearLayout)localMiniGamePublicAccountHeadLayout.findViewById(2131369619));
    this.viewPager = ((QQGamePubViewpager)localMiniGamePublicAccountHeadLayout.findViewById(2131366534));
    this.mIndicator = ((MiniGamePublicAccountViewPagerIndicator)localMiniGamePublicAccountHeadLayout.findViewById(2131372127));
    paramView = (ImageView)localMiniGamePublicAccountHeadLayout.findViewById(2131367308);
    TextView localTextView = (TextView)localMiniGamePublicAccountHeadLayout.findViewById(2131371306);
    this.moreMsgLayout = ((RelativeLayout)localMiniGamePublicAccountHeadLayout.findViewById(2131371307));
    paramView.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    this.pagerAdapter = new MiniGamePublicAccountWebFragment.HeadPageAdapter(this, null);
    this.viewPager.setAdapter(this.pagerAdapter);
    this.viewPager.setOffscreenPageLimit(3);
    this.mIndicator.setViewPager(this.viewPager);
    this.mIndicator.refreshIndicator();
    this.mIndicator.setOnPageSelectedListener(new MiniGamePublicAccountWebFragment.2(this));
    MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_minigame", "expo", null);
  }
  
  private void initLoad(View paramView)
  {
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    this.loadLayout = ((LinearLayout)paramView.findViewById(2131370188));
    int j = afur.a(418.0F, getActivity().getResources());
    localObject = this.loadLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = afur.a(i - j, getActivity().getResources());
    this.loadLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = aksh.a();
    if (TextUtils.isEmpty(PreloadManager.a("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0).filePath))
    {
      handleDefaultLoading();
      ((aksh)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.3(this));
      return;
    }
    ((aksh)localObject).c("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", new MiniGamePublicAccountWebFragment.4(this, paramView));
  }
  
  private void refreshHead(int paramInt)
  {
    if (this.pagerAdapter != null)
    {
      this.pagerAdapter.notifyDataSetChanged();
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
    MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_ark_test", "period", String.valueOf(l));
  }
  
  private void reportMsgExpose(int paramInt)
  {
    if (paramInt < this.msgInfoList.size()) {}
    for (QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.msgInfoList.get(paramInt);; localQQGameMsgInfo = null)
    {
      if (localQQGameMsgInfo == null) {}
      do
      {
        do
        {
          return;
        } while (((Boolean)this.exposeReported.get(paramInt)).booleanValue());
        this.exposeReported.set(paramInt, Boolean.valueOf(true));
        ark.arkNotify(localQQGameMsgInfo.arkAppName, "msg_expose", localQQGameMsgInfo.arkMetaList, "json");
        MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_ark_test", "expo", localQQGameMsgInfo.advId);
      } while (checkTianshuData(localQQGameMsgInfo.arkMetaList));
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_news_ark_test", "expo_invalid", localQQGameMsgInfo.advId);
      return;
    }
  }
  
  public View createEmptyView()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559201, null, false);
    ((ImageView)localView.findViewById(2131365984)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void initTitle(View paramView)
  {
    this.titleBar = ((MiniGamePublicAccountNavBar)paramView.findViewById(2131376599));
    this.titleBar.setRightImage(getResources().getDrawable(2130848303));
    this.titleBar.changeBg(true);
    this.navTitle = this.titleBar.getTitleTextView();
    this.navTitle.setText(2131693707);
    this.navTitle.setTextColor(-16777216);
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
    this.webViewBuilder = new MiniGamePublicAccountWebFragment.5(this, getActivity(), getActivity(), ampj.a(), this.webView);
    this.webViewBuilder.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new bhmg(this.webViewBuilder).a(null, ampj.a(), null);
    this.webView = ((MiniGamePublicAccountWebView)this.webViewBuilder.getWebView());
    this.webView.setWillNotCacheDrawing(false);
    this.webView.setDrawingCacheEnabled(true);
    String str = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountWebUrl", "https://h5.qzone.qq.com/miniapp/act/gamePublic");
    this.webView.loadUrl(str);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      enterAIO();
      continue;
      String str = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountGameStoreUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list%3Fmode%3Dchengzaiye&_vt=3&via=2015_5_11&_sig=1248527088");
      MiniAppLauncher.startMiniApp(getActivity(), str, 4011, null);
      MiniProgramLpReportDC04239.reportAsync("minigamechengzaiye", "top_minigame", "click", null);
    }
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
    this.contentView = paramLayoutInflater.inflate(2131559424, paramViewGroup, false);
    if (!bcnj.b())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
    initHead(this.contentView);
    this.initUiTime = (SystemClock.elapsedRealtime() - this.startTime);
    this.initWebViewTime = initWebView();
    initTitle(this.contentView);
    initLoad(this.contentView);
    paramLayoutInflater = this.contentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i;
    if (this.mHeaderRecords != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mHeaderRecords.size())
        {
          if (!(this.mHeaderRecords.get(i) instanceof GameArkView)) {
            break label199;
          }
          ((GameArkView)this.mHeaderRecords.get(i)).c();
          if (!QLog.isColorLevel()) {
            break label199;
          }
          QLog.d("MiniGamePublicAccountWebFragment", 2, "header destroy i=" + i);
          break label199;
        }
        this.mHeaderRecords.clear();
      }
      catch (Throwable localThrowable)
      {
        Iterator localIterator;
        String str;
        QLog.e("MiniGamePublicAccountWebFragment", 1, "header destroy error=" + localThrowable.toString());
        continue;
        akwh.a().a(new String[0]);
        return;
      }
      if (this.webViewBuilder != null) {
        this.webViewBuilder.onDestroy();
      }
      localIterator = this.arkAppNameList.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        akwh.a().b(str);
      }
      else
      {
        label199:
        i += 1;
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.arkAppNameList != null) {
      akwh.a().b(this.arkAppNameList);
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onPause();
    }
    if (this.currIHeaderView != null) {
      this.currIHeaderView.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.webViewBuilder != null) {
      this.webViewBuilder.onResume();
    }
    if (this.currIHeaderView != null) {
      this.currIHeaderView.a();
    }
    try
    {
      int i = this.msgInfoList.size();
      if ((this.viewPager != null) && (i > 0) && (this.viewPager.getCurrentItem() == i)) {
        this.viewPager.setCurrentItem(i - 1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
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