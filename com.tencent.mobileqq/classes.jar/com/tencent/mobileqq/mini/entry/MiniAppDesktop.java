package com.tencent.mobileqq.mini.entry;

import akka;
import akou;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apys;
import apyt;
import bjnq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class MiniAppDesktop
  implements akka, bjnq, MiniAppPullInterface, BusinessObserver
{
  private static final int MINI_SEARCH_BAR_HEIGHT = ViewUtils.dip2px(50.0F);
  private static final int MINI_TRANSLATE;
  private static final int MINI_TRIGGER_REFRESH_OFFSET;
  public static final int MODE_IDLE = 1;
  public static final int MODE_REFRESH = 2;
  public static final int MODE_SHOW_NODE = 3;
  private static final int OFFSET_NODE_SCROLL = ViewUtils.dip2px(-120.0F);
  private static final int OVER_FLING_DISTANCE = 70;
  private static final int RELEASE_ENTER_DESKTOP = 2;
  private static final int RELEASE_ENTER_IDLE = 0;
  private static final int RELEASE_ENTER_REFRESH = 1;
  public static final String TAG = "MiniAppDesktop";
  public static final int TYPE_BACK_PRESSED = 0;
  public static final int TYPE_OTHER = -1;
  public static int dittoBannerHeight;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  boolean flag = false;
  private boolean hasOpenDesktop;
  private boolean hasSetStatusBar;
  private boolean hasVibrate;
  private WeakReference<Activity> mActivityReference;
  private QQAppInterface mApp;
  private final akou mCareNotificationBar;
  private PullRefreshHeader mChatTopRefresh;
  private MiniAppDesktopLayout mContentView;
  private DrawerFrame mDrawer;
  private ViewGroup mHeadView;
  private float mLastScrollY;
  private ARMapHongBaoListView mListView;
  private ViewGroup mListViewContainer;
  private ViewGroup mMiniAppListLayout;
  private QQBlurView mQQBlurView;
  private QQTabWidget mQQTabWidget;
  private ViewGroup mRootView;
  private ViewGroup mTitleBarView;
  private int mTriggerFullScreenScrollY;
  private int mTriggerRefreshMinScrollY;
  private Vibrator mVibrator;
  private int mode = 1;
  private int preMode = 1;
  private int refreshHeaderHeight = ViewUtils.dpToPx(50.0F);
  private ProgressBar refreshProgressBar;
  private int refreshState = 0;
  private TextView refreshTextView;
  private View refreshView;
  
  static
  {
    MINI_TRANSLATE = ViewUtils.dip2px(-100.0F);
    MINI_TRIGGER_REFRESH_OFFSET = ViewUtils.dip2px(30.0F);
  }
  
  public MiniAppDesktop(Activity paramActivity, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, ViewGroup paramViewGroup)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mApp = paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.mDrawer = paramDrawerFrame;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mRootView = paramViewGroup;
    this.mChatTopRefresh = paramPullRefreshHeader;
    this.mTitleBarView = ((ViewGroup)paramConversation.a());
    this.mHeadView = ((ViewGroup)paramActivity.findViewById(2131369689));
    this.mQQTabWidget = ((QQTabWidget)paramActivity.findViewById(16908307));
    this.mQQBlurView = ((QQBlurView)paramActivity.findViewById(2131380328));
    this.mListViewContainer = ((ViewGroup)paramConversation.b());
    this.mCareNotificationBar = paramConversation.jdField_a_of_type_Akou;
    this.mTriggerFullScreenScrollY = apyt.a(OFFSET_NODE_SCROLL);
    this.mTriggerRefreshMinScrollY = ViewUtils.dpToPx(apyt.b(0));
    if (this.mTriggerRefreshMinScrollY <= 0) {
      this.mTriggerRefreshMinScrollY = (this.refreshHeaderHeight + MINI_TRIGGER_REFRESH_OFFSET);
    }
  }
  
  private void animateOpen()
  {
    if (getCurrentTab() != MainFragment.b)
    {
      hideMiniAppEntry(-1);
      return;
    }
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "clearDesktopExposureReportData", 0) == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((MiniAppExposureManager)this.mApp.getManager(322)).clear();
      }
      this.hasOpenDesktop = true;
      i = this.refreshHeaderHeight;
      int j = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      float f = ViewUtils.getScreenWidth();
      i = (int)(i + j + 0.1333333F * f);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mTitleBarView, "translationY", new float[] { -i });
      localObjectAnimator1.setInterpolator(new AccelerateInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mHeadView, "translationY", new float[] { -i });
      localObjectAnimator2.setInterpolator(new AccelerateInterpolator());
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mQQTabWidget, "translationY", new float[] { this.mQQTabWidget.getHeight() });
      localObjectAnimator3.setInterpolator(new AccelerateInterpolator());
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.mQQBlurView, "translationY", new float[] { this.mQQBlurView.getHeight() });
      localObjectAnimator4.setInterpolator(new AccelerateInterpolator());
      Object localObject1 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.93F, 1.0F });
      Object localObject2 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.93F, 1.0F });
      localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.mMiniAppListLayout, new PropertyValuesHolder[] { localObject1, localObject2 });
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).addListener(new MiniAppDesktop.3(this));
      ((AnimatorSet)localObject2).playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObject1 });
      ((AnimatorSet)localObject2).setDuration(200L);
      ((AnimatorSet)localObject2).start();
      return;
    }
  }
  
  private void checkIfShowQbossBanner()
  {
    if (this.mTitleBarView != null)
    {
      View localView = this.mTitleBarView.findViewById(2131373809);
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
  }
  
  private void closeDesktopReport(int paramInt)
  {
    if (paramInt == 0) {
      this.mContentView.closeDesktopReport("off_system");
    }
  }
  
  private void doOnScroll(float paramFloat, boolean paramBoolean, int paramInt)
  {
    float f1 = this.mContentView.getHeight();
    float f2 = getTitleBarAndStatusBarHeight();
    this.mContentView.setTranslationY(f1 + paramFloat - f2);
    int i;
    if (paramFloat - this.mLastScrollY > 0.0F)
    {
      i = 1;
      if ((this.mode != 3) || ((paramInt != 1) && (i == 0))) {
        break label129;
      }
      this.mContentView.setTranslationY(0.0F);
      this.mMiniAppListLayout.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (Math.signum(paramFloat) == 0.0F)
      {
        paramBoolean = this.mCareNotificationBar.a();
        this.mCareNotificationBar.a(false);
        if (paramBoolean != this.mCareNotificationBar.a()) {
          this.mCareNotificationBar.b();
        }
      }
      return;
      i = 0;
      break;
      label129:
      if (paramFloat < -this.refreshHeaderHeight)
      {
        f1 = -getDefaultTranslation() - (this.refreshHeaderHeight + paramFloat);
        if ((f1 > 0.0F) || (this.hasOpenDesktop)) {
          f1 = 0.0F;
        }
        this.mMiniAppListLayout.setTranslationY(f1);
      }
    }
  }
  
  private void doVibrate()
  {
    try
    {
      if (this.mVibrator != null) {
        this.mVibrator.vibrate(10L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktop", 1, "exception when doVibrate.", localThrowable);
    }
  }
  
  private int getCurrentTab()
  {
    Fragment localFragment;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localFragment = ((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localFragment == null) {}
    }
    for (int i = ((MainFragment)localFragment).a();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppDesktop", 2, "getCurrentTab, tab: " + i);
      }
      return i;
    }
  }
  
  private int getDefaultTranslation()
  {
    boolean bool = ((DesktopDataManager)this.mApp.getManager(336)).hasPullSearchData();
    int j = getTitleBarAndStatusBarHeight() + this.refreshHeaderHeight;
    int i = j;
    if (bool) {
      i = j + MINI_SEARCH_BAR_HEIGHT;
    }
    return i + dittoBannerHeight;
  }
  
  private int getListViewScrollY()
  {
    return this.mContentView.getHeight() - getTitleBarAndStatusBarHeight();
  }
  
  private int getTitleBarAndStatusBarHeight()
  {
    int j = this.mTitleBarView.getHeight();
    int i = j;
    if (j == 0) {
      i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299076) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
    }
    return i;
  }
  
  private void initNavigationBarConfigChangeListener(Activity paramActivity)
  {
    paramActivity = paramActivity.findViewById(16908290);
    if (paramActivity == null) {
      return;
    }
    paramActivity.addOnLayoutChangeListener(new MiniAppDesktop.2(this));
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.getCurrentThemeId())) || ("2920".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  private boolean needIntercept()
  {
    if ((this.mContentView == null) || (this.mListView == null)) {}
    int i;
    do
    {
      return false;
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.mContentView.getLocationInWindow(arrayOfInt1);
      this.mListView.getLocationInWindow(arrayOfInt2);
      i = (int)(-getListViewScrollY() * 0.5D);
    } while ((this.mListView.getScrollY() > i) || (this.mode != 3));
    return true;
  }
  
  private void pullDownResultReport(float paramFloat)
  {
    if ((this.preMode == 1) && (paramFloat > 0.0F)) {}
    switch (this.mode)
    {
    default: 
      return;
    case 1: 
      MiniProgramLpReportDC04239.reportAsync("pulldown", "none", "length", String.valueOf(ViewUtils.PxToDp(paramFloat)), String.valueOf(paramFloat), null);
      return;
    case 2: 
      MiniProgramLpReportDC04239.reportAsync("pulldown", "refresh", "length", String.valueOf(ViewUtils.PxToDp(paramFloat)), String.valueOf(paramFloat), null);
      return;
    }
    MiniProgramLpReportDC04239.reportAsync("pulldown", "desktop", "length", String.valueOf(ViewUtils.PxToDp(paramFloat)), String.valueOf(paramFloat), null);
  }
  
  private void resetAnimationStatus()
  {
    QLog.d("MiniAppDesktop", 1, "[animation]. resetAnimationStatus");
    if (this.hasOpenDesktop)
    {
      this.mContentView.desktopClosed();
      setOverScrollTouchMode(1);
    }
    this.hasOpenDesktop = false;
    checkIfShowQbossBanner();
    setParentClipChildren(true);
    if (this.mTitleBarView.getTranslationY() != 0.0F) {
      this.mTitleBarView.setTranslationY(0.0F);
    }
    if (this.mHeadView.getTranslationY() != 0.0F) {
      this.mHeadView.setTranslationY(0.0F);
    }
    if (this.mQQTabWidget.getTranslationY() != 0.0F) {
      this.mQQTabWidget.setTranslationY(0.0F);
    }
    if (this.mQQBlurView.getTranslationY() != 0.0F) {
      this.mQQBlurView.setTranslationY(0.0F);
    }
    Object localObject = this.mContentView.getRecyclerView();
    if ((localObject != null) && (((RecyclerView)localObject).computeVerticalScrollOffset() != 0)) {
      ((RecyclerView)localObject).scrollToPosition(0);
    }
    this.mContentView.stopSwitchIconAnimation();
    this.mContentView.reset();
    if (this.hasSetStatusBar)
    {
      localObject = (Activity)this.mActivityReference.get();
      if (localObject != null) {
        DisplayUtil.setStatusBarTextColor((Activity)localObject);
      }
      this.hasSetStatusBar = false;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppDesktop", 2, "resetAnimationStatus, reset status bar text color.");
      }
    }
  }
  
  private void setMicroAppEntryCompleteVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mMiniAppListLayout.getTranslationY() != 0.0F) {
        this.mMiniAppListLayout.setTranslationY(0.0F);
      }
      if (this.mMiniAppListLayout.getAlpha() != 1.0F) {
        setMicroAppEntryPanelAlpha(1.0F);
      }
      return;
    }
    if (this.mMiniAppListLayout.getTranslationY() != -getDefaultTranslation()) {
      this.mMiniAppListLayout.setTranslationY(-getDefaultTranslation());
    }
    this.mMiniAppListLayout.setScaleX(0.93F);
    this.mMiniAppListLayout.setScaleY(0.93F);
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    if (this.mMiniAppListLayout != null) {
      this.mMiniAppListLayout.setAlpha(paramFloat);
    }
  }
  
  private void setNightMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(new ColorDrawable(Color.parseColor("#000000")));
      Object localObject = (Activity)this.mActivityReference.get();
      if (localObject != null)
      {
        int i = ((Activity)localObject).getResources().getColor(2131167096);
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        localObject = (TextView)this.mChatTopRefresh.findViewById(2131376212);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(i);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppDesktop", 1, "setNightMode, e" + Log.getStackTraceString(localException));
    }
  }
  
  private void setNormalMode()
  {
    try
    {
      Object localObject = (Activity)this.mActivityReference.get();
      if (localObject != null)
      {
        this.mListView.setOverscrollHeader(((Activity)localObject).getResources().getDrawable(2130850831));
        int i = ((Activity)localObject).getResources().getColor(2131167096);
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        localObject = (TextView)this.mChatTopRefresh.findViewById(2131376212);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(i);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppDesktop", 1, "setNormalMode, e" + Log.getStackTraceString(localException));
    }
  }
  
  private void setOverScrollTouchMode(int paramInt)
  {
    this.mListView.setOverScrollTouchMode(paramInt);
  }
  
  private void setParentClipChildren(boolean paramBoolean)
  {
    this.mListView.setClipChildren(paramBoolean);
    this.mListViewContainer.setClipChildren(paramBoolean);
    this.mRootView.setClipChildren(paramBoolean);
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mChatTopRefresh.findViewById(2131376207);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void shutdownMiniAppPullDownEntry()
  {
    try
    {
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) >= 0)
      {
        hideMiniAppEntry(-1);
        this.mChatTopRefresh.removeView(this.mContentView);
        setRefreshLayoutVisible(true);
        this.mListView.setMaxOverScrollTopDistance(30);
        this.mListView.setQQStoryListViewListener(null);
        this.mListView.scrollTo(0, 0);
        this.mListView.mEnableStory = false;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null) {
          this.mDrawer.a(MainFragment.b);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppDesktop", 1, "shutdownMiniAppPullDownEntry, " + Log.getStackTraceString(localException));
    }
  }
  
  private void updateRefreshTheme()
  {
    try
    {
      if (this.refreshView != null) {
        this.refreshView.setBackgroundResource(2130838892);
      }
      if (this.refreshProgressBar != null)
      {
        localObject = (Activity)this.mActivityReference.get();
        if (localObject != null)
        {
          localObject = ((Activity)localObject).getResources().getDrawable(2130839449);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          this.refreshProgressBar.setIndeterminateDrawable((Drawable)localObject);
        }
      }
      if (this.mChatTopRefresh != null) {
        this.mChatTopRefresh.setArrowColor(0);
      }
      Object localObject = (Activity)this.mActivityReference.get();
      if (localObject != null)
      {
        int i = ((Activity)localObject).getResources().getColor(2131167096);
        if (this.mChatTopRefresh != null) {
          this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktop", 1, "updateRefreshTheme error.", localThrowable);
    }
  }
  
  private void updateStatusTextColorByHongbao()
  {
    if (this.mApp != null) {
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)this.mApp.getManager(336);
    }
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    int i = 1;
    float f = paramARMapHongBaoListView.getScrollY();
    if (this.mode == 1)
    {
      this.mContentView.stopSwitchIconAnimation();
      this.mCareNotificationBar.b();
      return 0;
    }
    if (this.mode == 3)
    {
      this.mCareNotificationBar.a();
      return -getListViewScrollY();
    }
    int j;
    if (this.mode == 2)
    {
      this.mCareNotificationBar.a();
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniapprefreshshowappicon", 0) == 1)
      {
        j = -this.refreshHeaderHeight;
        if (i == 0) {
          break label114;
        }
      }
    }
    label114:
    for (i = -(this.refreshHeaderHeight * 2);; i = j)
    {
      return i;
      i = 0;
      break;
      return (int)f;
    }
  }
  
  public void handlePullRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppDesktop", 1, "[MiniAppDesktop]. handlePullRefresh");
    }
  }
  
  public boolean hasOpenDesktop()
  {
    return this.hasOpenDesktop;
  }
  
  public void hideMiniAppEntry(int paramInt)
  {
    if ((this.mListView.mEnableStory) && (this.mListView.mForStory))
    {
      this.mListView.springBackOverScrollHeaderView(0);
      this.mListView.mForStory = false;
      this.mode = 1;
      setRefreshLayoutVisible(true);
      MiniAppDesktopLayout.exposureReport(true);
      if (this.hasOpenDesktop)
      {
        resetAnimationStatus();
        closeDesktopReport(paramInt);
      }
    }
  }
  
  public void initLater(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppDesktop", 2, paramDrawerFrame + " initLater " + this.mListView.mEnableStory);
    }
    this.mDrawer = paramDrawerFrame;
    if (this.mDrawer != null) {
      this.mDrawer.setMiniAppTouchEventInterceptor(MainFragment.b, this);
    }
  }
  
  public void initUI(Activity paramActivity)
  {
    QLog.d("MiniAppDesktop", 1, "initUI");
    if (this.mChatTopRefresh != null)
    {
      this.mContentView = new MiniAppDesktopLayout(paramActivity, this.mListView, 0);
      this.mMiniAppListLayout = this.mContentView.getContainerView();
      this.mApp.registObserver(this);
      this.mApp.addObserver(new MiniAppDesktop.RedDotAppletsObserver(this.mContentView));
      this.refreshHeaderHeight = paramActivity.getResources().getDimensionPixelSize(2131298826);
      Object localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.getScreenHeight(paramActivity));
      this.mContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ViewGroup)this.mChatTopRefresh.findViewById(2131371042);
      ((ViewGroup)localObject).addView(this.mContentView);
      this.refreshView = this.mChatTopRefresh.findViewById(2131376207);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.refreshView.getLayoutParams();
      localLayoutParams.addRule(12);
      this.refreshView.setLayoutParams(localLayoutParams);
      ((ViewGroup)localObject).setVisibility(0);
      this.refreshView.setBackgroundResource(2130838892);
      this.mListView.setOverScrollHeight(this.mTriggerRefreshMinScrollY);
      this.refreshProgressBar = ((ProgressBar)this.mChatTopRefresh.findViewById(2131376213));
      this.refreshTextView = ((TextView)this.mChatTopRefresh.findViewById(2131376212));
      this.mListView.setMaxOverScrollTopDistance(70);
      setOverScrollTouchMode(1);
      this.mListView.setQQStoryListViewListener(this);
      this.mListView.mEnableStory = true;
      this.mListView.mForStory = false;
      this.mode = 1;
      if (this.mDrawer != null) {
        this.mDrawer.setMiniAppTouchEventInterceptor(MainFragment.b, this);
      }
      ThreadManager.getUIHandler().post(new MiniAppDesktop.1(this));
      this.mVibrator = ((Vibrator)paramActivity.getSystemService("vibrator"));
      initNavigationBarConfigChangeListener(paramActivity);
      paramActivity = (DesktopDataManager)this.mApp.getManager(336);
      if (paramActivity != null)
      {
        paramActivity.initLocalCacheData();
        paramActivity.sendDropDownAppListRequestAsync();
      }
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (needIntercept()) {
      return this.mContentView.interceptDrawer(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public boolean isMiniAppLauncherOpened()
  {
    return (this.mListView != null) && (this.mListView.getScrollY() <= -getListViewScrollY());
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mApp.unRegistObserver(this);
    this.mApp = paramQQAppInterface;
    boolean bool = false;
    Object localObject = apyt.a();
    if (localObject != null) {
      bool = ((apys)localObject).a();
    }
    QLog.d("MiniAppDesktop", 1, "[MiniAppDesktop].onAccountChanged: " + bool);
    if ((!bool) && (this.mChatTopRefresh != null) && (this.mContentView != null))
    {
      shutdownMiniAppPullDownEntry();
      QLog.d("MiniAppDesktop", 1, "onAccountChanged: shutDown mini app entry");
      return;
    }
    updateRefreshTheme();
    if (this.mContentView != null) {
      this.mContentView.onAccountChanged(paramQQAppInterface);
    }
    paramQQAppInterface.registObserver(this);
    paramQQAppInterface.addObserver(new MiniAppDesktop.RedDotAppletsObserver(this.mContentView));
    localObject = (DesktopDataManager)paramQQAppInterface.getManager(336);
    ((DesktopDataManager)localObject).useLocalDataIfRequestFailed();
    ((DesktopDataManager)localObject).asyncQueryMiniAppPushRedDotData();
    ((DesktopDataManager)localObject).sendDropDownAppListRequestAsync();
    ThreadManager.executeOnSubThread(new MiniAppDesktop.4(this, paramQQAppInterface));
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.mListView.mEnableStory) && (this.mContentView != null))
    {
      if (paramInt2 < 0)
      {
        if ((paramInt2 > MINI_TRANSLATE) && (this.hasOpenDesktop)) {
          resetAnimationStatus();
        }
        doOnScroll(paramInt2, false, paramInt1);
      }
      if ((this.mContentView.getHeight() != 0) && (paramInt2 <= -this.mContentView.getHeight())) {
        setMicroAppEntryCompleteVisible(true);
      }
      if ((paramInt1 == 0) && (paramInt2 > -this.refreshHeaderHeight) && (this.hasOpenDesktop)) {
        resetAnimationStatus();
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    this.mContentView.onPostThemeChanged();
    updateRefreshTheme();
    TextHook.updateFont(this.mContentView);
    TextHook.updateFont(this.refreshTextView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("MiniAppDesktop", 1, "[DesktopDataManager], onReceive, type = " + paramInt + " , mContentView = " + this.mContentView);
    if (paramInt == 100)
    {
      hideMiniAppEntry(-1);
      paramBoolean = this.mCareNotificationBar.a();
      this.mCareNotificationBar.a(false);
      if (paramBoolean != this.mCareNotificationBar.a()) {
        this.mCareNotificationBar.b();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt != 12) {
                  break;
                }
              } while (this.mContentView == null);
              this.mContentView.startSwitchIconAnimation();
              return;
              if (paramInt != 13) {
                break;
              }
            } while (this.mContentView == null);
            this.mContentView.stopSwitchIconAnimation();
            return;
            if (paramInt != 102) {
              break;
            }
          } while (paramBundle == null);
          paramInt = paramBundle.getInt("redDot", -1);
          paramBoolean = paramBundle.getBoolean("refreshUI", false);
        } while (paramInt == -1);
        this.mContentView.onChangeRedDotSwitch(paramInt, paramBoolean);
        return;
        if (paramInt != 103) {
          break;
        }
      } while (this.mContentView == null);
      updateRefreshTheme();
      updateStatusTextColorByHongbao();
      this.mContentView.updateHongBaoRes();
      return;
    } while (this.mContentView == null);
    this.mContentView.notifyMiniAppDataChanged();
  }
  
  public void onResume()
  {
    if ((3 == this.mode) && (this.mContentView != null))
    {
      ThreadManager.getUIHandler().postDelayed(new MiniAppDesktop.5(this), 1000L);
      this.mContentView.desktopResume();
    }
    try
    {
      AbstractGifImage.resumeAll();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktop", 1, "onResume get a throwable:" + localThrowable);
    }
  }
  
  public void onStop()
  {
    if (this.mContentView != null)
    {
      this.mContentView.stopSwitchIconAnimation();
      this.mContentView.reset();
    }
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "desktopExposureReportOnStop", 0) == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((this.hasOpenDesktop) && (i != 0)) {
        MiniAppDesktopLayout.exposureReport(false);
      }
      return;
    }
  }
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    paramBoolean = true;
    float f = paramARMapHongBaoListView.getScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return;
    case 0: 
      if (this.mode == 1)
      {
        this.flag = true;
        setMicroAppEntryCompleteVisible(false);
      }
      this.mLastScrollY = 0.0F;
      this.hasVibrate = false;
      return;
    case 2: 
      if ((!this.flag) && (this.mode == 1))
      {
        this.flag = true;
        setMicroAppEntryCompleteVisible(false);
      }
      if ((this.refreshProgressBar != null) && (this.refreshProgressBar.getVisibility() != 0)) {
        if ((f <= -this.mTriggerRefreshMinScrollY) && (f > this.mTriggerFullScreenScrollY)) {
          if (this.refreshState != 1)
          {
            this.refreshTextView.setText(2131718609);
            this.refreshState = 1;
          }
        }
      }
      for (;;)
      {
        if ((f <= this.mTriggerFullScreenScrollY) && (this.mode == 1) && (!this.hasVibrate))
        {
          this.hasVibrate = true;
          doVibrate();
        }
        this.mLastScrollY = f;
        return;
        if (f <= this.mTriggerFullScreenScrollY)
        {
          if (this.refreshState != 2)
          {
            this.refreshTextView.setText(2131693803);
            this.refreshState = 2;
          }
        }
        else
        {
          this.refreshState = 0;
          continue;
          this.refreshState = 0;
        }
      }
    }
    this.flag = false;
    this.preMode = this.mode;
    if (f >= 0.0F)
    {
      this.mode = 1;
      paramARMapHongBaoListView.mForStory = false;
      if ((this.preMode == 3) || (this.mode != 3)) {
        break label516;
      }
      animateOpen();
      MiniAppUtils.checkMiniAppDesktopSendRequest();
      AppBrandLaunchManager.g().onMiniAppUIOpen();
      label320:
      if (this.mCareNotificationBar.a() != paramARMapHongBaoListView.mForStory)
      {
        this.mCareNotificationBar.a(paramARMapHongBaoListView.mForStory);
        this.mCareNotificationBar.b();
      }
      if (paramARMapHongBaoListView.mForStory) {
        break label553;
      }
    }
    for (;;)
    {
      setRefreshLayoutVisible(paramBoolean);
      QLog.d("MiniAppDesktop", 2, "fight...onTouchMoving.onUp..scrollY = " + f);
      this.hasVibrate = false;
      this.refreshState = 0;
      pullDownResultReport(-f);
      return;
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f > -getListViewScrollY())
        {
          this.mode = 1;
          paramARMapHongBaoListView.mForStory = false;
          break;
        }
        this.mode = 3;
        paramARMapHongBaoListView.mForStory = true;
        break;
      }
      if (f <= this.mTriggerFullScreenScrollY)
      {
        this.mode = 3;
        paramARMapHongBaoListView.mForStory = true;
        break;
      }
      if (f <= -this.mTriggerRefreshMinScrollY)
      {
        this.mode = 2;
        paramARMapHongBaoListView.mForStory = false;
        break;
      }
      this.mode = 1;
      paramARMapHongBaoListView.mForStory = false;
      break;
      label516:
      if (this.mode != 1) {
        break label320;
      }
      resetAnimationStatus();
      if (this.preMode != 3) {
        break label320;
      }
      MiniAppDesktopLayout.exposureReport(true);
      this.mContentView.closeDesktopReport("button_pull_up");
      break label320;
      label553:
      paramBoolean = false;
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppDesktop", 2, "onViewCompleteAfterRefresh, mode:" + this.mode);
    }
    MiniProgramLpReportDC04239.reportAsync("desktop", "refresh", null, null);
    if (this.mode == 2) {
      this.mode = 1;
    }
    while (this.mode != 3) {
      return 0;
    }
    return -getListViewScrollY();
  }
  
  public boolean showMicroAppEntry()
  {
    if ((this.mListView.mEnableStory) && (!this.mListView.mForStory) && (this.mListView.getListViewScrollY() == 0))
    {
      this.mListView.setScrollY(-this.mContentView.getHeight());
      this.mListView.mForStory = true;
      this.mode = 3;
      setMicroAppEntryCompleteVisible(true);
      setRefreshLayoutVisible(true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop
 * JD-Core Version:    0.7.0.1
 */