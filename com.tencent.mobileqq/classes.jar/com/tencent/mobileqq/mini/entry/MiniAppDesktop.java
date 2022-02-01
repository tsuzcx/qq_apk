package com.tencent.mobileqq.mini.entry;

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
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.StoryTouchEventInterceptor;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.QQStoryListViewListener;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class MiniAppDesktop
  implements DrawerFrame.StoryTouchEventInterceptor, MiniAppPullInterface, ARMapHongBaoListView.QQStoryListViewListener, BusinessObserver
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
  public static int dittoBannerHeight = 0;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  boolean flag = false;
  private boolean hasOpenDesktop = false;
  private boolean hasSetStatusBar = false;
  private boolean hasVibrate;
  private WeakReference<Activity> mActivityReference;
  private QQAppInterface mApp;
  private final CareNotificationBar mCareNotificationBar;
  private IPullRefreshHeaderControl mChatTopRefresh;
  private MiniAppDesktopLayout mContentView;
  private DrawerFrame mDrawer;
  private ViewGroup mHeadView;
  private float mLastScrollY = 0.0F;
  private ARMapHongBaoListView mListView;
  private ViewGroup mListViewContainer;
  private ViewGroup mMiniAppListLayout;
  private QQBlurView mQQBlurView;
  private QQTabWidget mQQTabWidget;
  private ViewGroup mRootView;
  private ViewGroup mTitleBarView;
  private int mTriggerFullScreenScrollY;
  private int mTriggerMinAppShowScrollY;
  private int mTriggerRefreshMinScrollY;
  private int mTriggerStartLottieScrollY = ViewUtils.dpToPx(26.0F);
  private Vibrator mVibrator;
  private int mode = 1;
  private int preMode = 1;
  private int refreshHeaderHeight = ViewUtils.dpToPx(50.0F);
  private int refreshState = 0;
  
  static
  {
    MINI_TRANSLATE = ViewUtils.dip2px(-100.0F);
    MINI_TRIGGER_REFRESH_OFFSET = ViewUtils.dip2px(30.0F);
  }
  
  public MiniAppDesktop(Activity paramActivity, Conversation paramConversation, ListView paramListView, IPullRefreshHeaderControl paramIPullRefreshHeaderControl, DrawerFrame paramDrawerFrame, ViewGroup paramViewGroup)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mApp = paramConversation.s();
    this.mDrawer = paramDrawerFrame;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mRootView = paramViewGroup;
    this.mChatTopRefresh = paramIPullRefreshHeaderControl;
    this.mTitleBarView = ((ViewGroup)paramConversation.B());
    this.mHeadView = ((ViewGroup)paramActivity.findViewById(2131436932));
    this.mQQTabWidget = ((QQTabWidget)paramActivity.findViewById(16908307));
    this.mQQBlurView = ((QQBlurView)paramActivity.findViewById(2131449311));
    this.mListViewContainer = ((ViewGroup)paramConversation.C());
    this.mCareNotificationBar = paramConversation.al;
    initTriggerScrollY();
  }
  
  private void animateOpen()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppDesktop", 2, "animateOpen");
    }
    if (getCurrentTab() != FrameControllerUtil.a)
    {
      hideMiniAppEntry(-1);
      return;
    }
    this.mChatTopRefresh.a(22, Integer.valueOf(ViewUtils.dpToPx(0.0F)));
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "clearDesktopExposureReportData", 0) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      ((MiniAppExposureManager)this.mApp.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).clear();
    }
    this.hasOpenDesktop = true;
    this.mContentView.notifyDesktopOpenAnimationStart();
    int i = this.refreshHeaderHeight;
    int j = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
    float f = ViewUtils.getScreenWidth();
    i = (int)(i + j + f * 0.1333333F);
    Object localObject1 = this.mTitleBarView;
    f = -i;
    localObject1 = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { f });
    ((ObjectAnimator)localObject1).setInterpolator(new AccelerateInterpolator());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mHeadView, "translationY", new float[] { f });
    localObjectAnimator.setInterpolator(new AccelerateInterpolator());
    Object localObject2 = this.mQQTabWidget;
    localObject2 = ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { ((QQTabWidget)localObject2).getHeight() });
    ((ObjectAnimator)localObject2).setInterpolator(new AccelerateInterpolator());
    if ((this.mDrawer != null) && (QQTheme.isNowSimpleUI()) && (!QQTheme.isNowThemeSimpleNight()))
    {
      localObject3 = this.mDrawer.findViewById(2131446748);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
    }
    Object localObject3 = this.mQQBlurView;
    localObject3 = ObjectAnimator.ofFloat(localObject3, "translationY", new float[] { ((QQBlurView)localObject3).getHeight() });
    ((ObjectAnimator)localObject3).setInterpolator(new AccelerateInterpolator());
    Object localObject4 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.93F, 1.0F });
    Object localObject5 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.93F, 1.0F });
    localObject4 = ObjectAnimator.ofPropertyValuesHolder(this.mMiniAppListLayout, new PropertyValuesHolder[] { localObject4, localObject5 });
    localObject5 = new AnimatorSet();
    ((AnimatorSet)localObject5).addListener(new MiniAppDesktop.3(this));
    ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject1, localObjectAnimator, localObject2, localObject3, localObject4 });
    ((AnimatorSet)localObject5).setDuration(200L);
    ((AnimatorSet)localObject5).start();
  }
  
  private void checkIfShowQbossBanner()
  {
    Object localObject = this.mTitleBarView;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).findViewById(2131449329);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
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
    if (paramFloat - this.mLastScrollY > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.mode == 3) && ((paramInt == 1) || (i != 0)))
    {
      this.mContentView.setTranslationY(0.0F);
      this.mMiniAppListLayout.setTranslationY(0.0F);
    }
    else if (paramFloat < -this.refreshHeaderHeight)
    {
      f1 = -getDefaultTranslation() - (this.refreshHeaderHeight + paramFloat);
      if ((f1 > 0.0F) || (this.hasOpenDesktop)) {
        f1 = 0.0F;
      }
      this.mMiniAppListLayout.setTranslationY(f1);
    }
    if (Math.signum(paramFloat) == 0.0F)
    {
      paramBoolean = this.mCareNotificationBar.b();
      this.mCareNotificationBar.a(false);
      if (paramBoolean != this.mCareNotificationBar.b()) {
        this.mCareNotificationBar.d();
      }
    }
  }
  
  private void doVibrate()
  {
    try
    {
      if (this.mVibrator != null)
      {
        this.mVibrator.vibrate(10L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktop", 1, "exception when doVibrate.", localThrowable);
    }
  }
  
  private int getCurrentTab()
  {
    Object localObject;
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      localObject = (QBaseFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        i = ((MainFragment)localObject).w();
        break label45;
      }
    }
    int i = -1;
    label45:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCurrentTab, tab: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("MiniAppDesktop", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private int getDefaultTranslation()
  {
    boolean bool = ((DesktopDataManager)this.mApp.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).hasPullSearchData();
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
      i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
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
    MiniAppDesktopLayout localMiniAppDesktopLayout = this.mContentView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMiniAppDesktopLayout != null)
    {
      if (this.mListView == null) {
        return false;
      }
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      localMiniAppDesktopLayout.getLocationInWindow(arrayOfInt1);
      this.mListView.getLocationInWindow(arrayOfInt2);
      double d = -getListViewScrollY();
      Double.isNaN(d);
      int i = (int)(d * 0.5D);
      bool1 = bool2;
      if (this.mListView.getScrollY() <= i)
      {
        bool1 = bool2;
        if (this.mode == 3) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void pullDownResultReport(float paramFloat)
  {
    if ((this.preMode == 1) && (paramFloat > 0.0F))
    {
      int i = this.mode;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          MiniProgramLpReportDC04239.reportAsync("pulldown", "desktop", "length", String.valueOf(ViewUtils.pxToDp(paramFloat)), String.valueOf(paramFloat), null);
          return;
        }
        MiniProgramLpReportDC04239.reportAsync("pulldown", "refresh", "length", String.valueOf(ViewUtils.pxToDp(paramFloat)), String.valueOf(paramFloat), null);
        return;
      }
      MiniProgramLpReportDC04239.reportAsync("pulldown", "none", "length", String.valueOf(ViewUtils.pxToDp(paramFloat)), String.valueOf(paramFloat), null);
    }
  }
  
  private void resetAnimationStatus()
  {
    QLog.d("MiniAppDesktop", 1, "[animation]. resetAnimationStatus");
    if (this.hasOpenDesktop)
    {
      this.mContentView.desktopClosed();
      this.mChatTopRefresh.a(22, Integer.valueOf(ViewUtils.dpToPx(24.0F)));
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
    if ((this.mDrawer != null) && (QQTheme.isNowSimpleUI()) && (!QQTheme.isNowThemeSimpleNight()))
    {
      localObject = this.mDrawer.findViewById(2131446748);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
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
    }
    else
    {
      if (this.mMiniAppListLayout.getTranslationY() != -getDefaultTranslation()) {
        this.mMiniAppListLayout.setTranslationY(-getDefaultTranslation());
      }
      this.mMiniAppListLayout.setScaleX(0.93F);
      this.mMiniAppListLayout.setScaleY(0.93F);
    }
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    ViewGroup localViewGroup = this.mMiniAppListLayout;
    if (localViewGroup != null) {
      localViewGroup.setAlpha(paramFloat);
    }
  }
  
  private void setNightMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(new ColorDrawable(Color.parseColor("#000000")));
      Activity localActivity = (Activity)this.mActivityReference.get();
      if (localActivity != null)
      {
        int i = localActivity.getResources().getColor(2131168122);
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        this.mChatTopRefresh.a(12, Integer.valueOf(i));
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNightMode, e");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("MiniAppDesktop", 1, localStringBuilder.toString());
    }
  }
  
  private void setNormalMode()
  {
    try
    {
      Activity localActivity = (Activity)this.mActivityReference.get();
      if (localActivity != null)
      {
        this.mListView.setOverscrollHeader(localActivity.getResources().getDrawable(2130853592));
        int i = localActivity.getResources().getColor(2131168122);
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        this.mChatTopRefresh.a(12, Integer.valueOf(i));
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNormalMode, e");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("MiniAppDesktop", 1, localStringBuilder.toString());
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
    IPullRefreshHeaderControl localIPullRefreshHeaderControl = this.mChatTopRefresh;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localIPullRefreshHeaderControl.a(4, Integer.valueOf(i));
  }
  
  private void shutdownMiniAppPullDownEntry()
  {
    try
    {
      if (((Integer)this.mChatTopRefresh.b(8, this.mContentView)).intValue() >= 0)
      {
        hideMiniAppEntry(-1);
        this.mChatTopRefresh.a(10, this.mContentView);
        setRefreshLayoutVisible(true);
        this.mListView.setMaxOverScrollTopDistance(30);
        this.mListView.setQQStoryListViewListener(null);
        this.mListView.scrollTo(0, 0);
        this.mListView.mEnableStory = false;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null)
        {
          this.mDrawer.a(FrameControllerUtil.a);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shutdownMiniAppPullDownEntry, ");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("MiniAppDesktop", 1, localStringBuilder.toString());
    }
  }
  
  private void updateRefreshTheme()
  {
    try
    {
      this.mChatTopRefresh.a(16, Integer.valueOf(2130838959));
      Activity localActivity = (Activity)this.mActivityReference.get();
      if (localActivity != null)
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130839590);
        localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
        this.mChatTopRefresh.a(15, localDrawable);
      }
      if (this.mChatTopRefresh != null) {
        this.mChatTopRefresh.a(17, Integer.valueOf(0));
      }
      if (localActivity != null)
      {
        int i = localActivity.getResources().getColor(2131168122);
        if (this.mChatTopRefresh != null)
        {
          this.mChatTopRefresh.setTextColor(i, i, i, i, i);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktop", 1, "updateRefreshTheme error.", localThrowable);
    }
  }
  
  private void updateStatusTextColorByHongbao()
  {
    Object localObject = this.mApp;
    if (localObject != null) {
      localObject = (DesktopDataManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    }
  }
  
  public MiniAppDesktopLayout getMiniAppDesktopLayout()
  {
    return this.mContentView;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f = paramARMapHongBaoListView.getScrollY();
    int j = this.mode;
    int i = 0;
    if (j == 1)
    {
      this.mContentView.stopSwitchIconAnimation();
      this.mCareNotificationBar.d();
      return 0;
    }
    if (j == 3)
    {
      this.mCareNotificationBar.a();
      return -getListViewScrollY();
    }
    if (j == 2)
    {
      this.mCareNotificationBar.a();
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniapprefreshshowappicon", 0) == 1) {
        i = 1;
      }
      int k = this.refreshHeaderHeight;
      j = -k;
      if (i != 0) {
        j = -(k * 2);
      }
      return j;
    }
    return (int)f;
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
  
  public void initLater(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof DrawerFrame)) {
      initLaterDrawerFrame((DrawerFrame)paramViewGroup);
    }
  }
  
  public void initLaterDrawerFrame(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDrawerFrame);
      localStringBuilder.append(" initLater ");
      localStringBuilder.append(this.mListView.mEnableStory);
      QLog.i("MiniAppDesktop", 2, localStringBuilder.toString());
    }
    this.mDrawer = paramDrawerFrame;
    paramDrawerFrame = this.mDrawer;
    if (paramDrawerFrame != null) {
      paramDrawerFrame.setMiniAppTouchEventInterceptor(FrameControllerUtil.a, this);
    }
  }
  
  protected void initTriggerScrollY()
  {
    if (QQTheme.isNowSimpleUI())
    {
      this.mTriggerStartLottieScrollY = ViewUtils.dpToPx(26.0F);
      this.mTriggerFullScreenScrollY = (-ViewUtils.dpToPx(145.0F));
      this.mTriggerRefreshMinScrollY = ViewUtils.dpToPx(60.0F);
      this.mTriggerMinAppShowScrollY = ViewUtils.dpToPx(72.0F);
      return;
    }
    this.mTriggerFullScreenScrollY = MiniAppConfProcessor.b(OFFSET_NODE_SCROLL);
    this.mTriggerRefreshMinScrollY = ViewUtils.dpToPx(MiniAppConfProcessor.c(0));
    if (this.mTriggerRefreshMinScrollY <= 0) {
      this.mTriggerRefreshMinScrollY = (this.refreshHeaderHeight + MINI_TRIGGER_REFRESH_OFFSET);
    }
    this.mTriggerMinAppShowScrollY = ViewUtils.dpToPx(72.0F);
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
      this.refreshHeaderHeight = paramActivity.getResources().getDimensionPixelSize(2131299643);
      Object localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.getScreenHeight(paramActivity));
      this.mContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mChatTopRefresh.a(2, this.mContentView);
      this.mChatTopRefresh.a(1, null);
      this.mListView.setOverScrollHeight(this.mTriggerRefreshMinScrollY);
      this.mListView.setMaxOverScrollTopDistance(70);
      setOverScrollTouchMode(1);
      this.mListView.setQQStoryListViewListener(this);
      localObject = this.mListView;
      ((ARMapHongBaoListView)localObject).mEnableStory = true;
      ((ARMapHongBaoListView)localObject).mForStory = false;
      this.mode = 1;
      localObject = this.mDrawer;
      if (localObject != null) {
        ((DrawerFrame)localObject).setMiniAppTouchEventInterceptor(FrameControllerUtil.a, this);
      }
      ThreadManager.getUIHandler().post(new MiniAppDesktop.1(this));
      this.mVibrator = ((Vibrator)paramActivity.getSystemService("vibrator"));
      initNavigationBarConfigChangeListener(paramActivity);
      paramActivity = (DesktopDataManager)this.mApp.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
      if (paramActivity != null)
      {
        paramActivity.initLocalCacheData();
        paramActivity.sendDropDownAppListRequestAsync(GetAppListV2Scene.START_UP);
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
    ARMapHongBaoListView localARMapHongBaoListView = this.mListView;
    return (localARMapHongBaoListView != null) && (localARMapHongBaoListView.getScrollY() <= -getListViewScrollY());
  }
  
  public void onAccountChanged(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      onAccountChangedInternal((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onAccountChangedInternal(QQAppInterface paramQQAppInterface)
  {
    this.mApp.unRegistObserver(this);
    this.mApp = paramQQAppInterface;
    Object localObject = MiniAppConfProcessor.a();
    boolean bool;
    if (localObject != null) {
      bool = ((MiniAppConfBean)localObject).a();
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniAppDesktop].onAccountChanged: ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("MiniAppDesktop", 1, ((StringBuilder)localObject).toString());
    if ((!bool) && (this.mChatTopRefresh != null) && (this.mContentView != null))
    {
      shutdownMiniAppPullDownEntry();
      QLog.d("MiniAppDesktop", 1, "onAccountChanged: shutDown mini app entry");
      return;
    }
    updateRefreshTheme();
    localObject = this.mContentView;
    if (localObject != null) {
      ((MiniAppDesktopLayout)localObject).onAccountChanged(paramQQAppInterface);
    }
    paramQQAppInterface.registObserver(this);
    paramQQAppInterface.addObserver(new MiniAppDesktop.RedDotAppletsObserver(this.mContentView));
    localObject = (DesktopDataManager)paramQQAppInterface.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    ((DesktopDataManager)localObject).useLocalDataIfRequestFailed();
    ((DesktopDataManager)localObject).asyncQueryMiniAppPushRedDotData();
    ((DesktopDataManager)localObject).sendDropDownAppListRequestAsync(GetAppListV2Scene.ACCOUNT_CHANGE);
    ThreadManager.executeOnSubThread(new MiniAppDesktop.4(this, paramQQAppInterface));
  }
  
  public void onDestroy()
  {
    MiniAppDesktopLayout localMiniAppDesktopLayout = this.mContentView;
    if (localMiniAppDesktopLayout != null) {
      localMiniAppDesktopLayout.destroy();
    }
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
    this.mChatTopRefresh.a(13, null);
    initTriggerScrollY();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DesktopDataManager], onReceive, type = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mContentView = ");
    localStringBuilder.append(this.mContentView);
    QLog.d("MiniAppDesktop", 1, localStringBuilder.toString());
    if (paramInt == 100)
    {
      hideMiniAppEntry(-1);
      paramBoolean = this.mCareNotificationBar.b();
      this.mCareNotificationBar.a(false);
      if (paramBoolean != this.mCareNotificationBar.b()) {
        this.mCareNotificationBar.d();
      }
      return;
    }
    if (paramInt == 12)
    {
      paramBundle = this.mContentView;
      if (paramBundle != null) {
        paramBundle.startSwitchIconAnimation();
      }
      return;
    }
    if (paramInt == 13)
    {
      paramBundle = this.mContentView;
      if (paramBundle != null) {
        paramBundle.stopSwitchIconAnimation();
      }
      return;
    }
    if (paramInt == 102)
    {
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt("redDot", -1);
        paramBoolean = paramBundle.getBoolean("refreshUI", false);
        if (paramInt != -1) {
          this.mContentView.onChangeRedDotSwitch(paramInt, paramBoolean);
        }
      }
      return;
    }
    if (paramInt == 103)
    {
      if (this.mContentView != null)
      {
        updateRefreshTheme();
        updateStatusTextColorByHongbao();
        this.mContentView.updateHongBaoRes();
      }
      return;
    }
    paramBundle = this.mContentView;
    if (paramBundle != null) {
      paramBundle.notifyMiniAppDataChanged();
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume get a throwable:");
      localStringBuilder.append(localThrowable);
      QLog.e("MiniAppDesktop", 1, localStringBuilder.toString());
    }
  }
  
  public void onStop()
  {
    MiniAppDesktopLayout localMiniAppDesktopLayout = this.mContentView;
    if (localMiniAppDesktopLayout != null)
    {
      localMiniAppDesktopLayout.stopSwitchIconAnimation();
      this.mContentView.reset();
    }
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "desktopExposureReportOnStop", 0) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.hasOpenDesktop) && (i != 0)) {
      MiniAppDesktopLayout.exposureReport(false);
    }
  }
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    float f1 = paramARMapHongBaoListView.getScrollY();
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3) {}
        }
        else
        {
          if ((!this.flag) && (this.mode == 1))
          {
            this.flag = true;
            setMicroAppEntryCompleteVisible(false);
          }
          if (((Boolean)this.mChatTopRefresh.b(6, null)).booleanValue())
          {
            if (this.refreshState != 2)
            {
              i = this.mTriggerRefreshMinScrollY;
              float f2 = (1.0F - (i - -f1) / (i - this.mTriggerStartLottieScrollY)) / 2.0F;
              this.mChatTopRefresh.a(3, Float.valueOf(f2));
            }
            if ((f1 <= -this.mTriggerRefreshMinScrollY) && (f1 > this.mTriggerFullScreenScrollY))
            {
              if (this.refreshState != 1)
              {
                this.mChatTopRefresh.a(5, Integer.valueOf(2131916804));
                this.refreshState = 1;
              }
            }
            else if (f1 <= this.mTriggerFullScreenScrollY)
            {
              if (this.refreshState != 2)
              {
                this.mChatTopRefresh.a(5, Integer.valueOf(2131891787));
                this.mChatTopRefresh.a(21, null);
                this.refreshState = 2;
              }
            }
            else {
              this.refreshState = 0;
            }
          }
          else
          {
            this.refreshState = 0;
          }
          if ((f1 <= this.mTriggerFullScreenScrollY) && (this.mode == 1) && (!this.hasVibrate))
          {
            this.hasVibrate = true;
            doVibrate();
          }
          this.mLastScrollY = f1;
          return;
        }
      }
      this.flag = false;
      this.preMode = this.mode;
      if (f1 >= 0.0F)
      {
        this.mode = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      else if (paramARMapHongBaoListView.mForStory)
      {
        if (f1 > -getListViewScrollY())
        {
          this.mode = 1;
          paramARMapHongBaoListView.mForStory = false;
        }
        else
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
      }
      else if (f1 <= this.mTriggerFullScreenScrollY)
      {
        this.mode = 3;
        paramARMapHongBaoListView.mForStory = true;
      }
      else if (f1 <= -this.mTriggerRefreshMinScrollY)
      {
        this.mode = 2;
        paramARMapHongBaoListView.mForStory = false;
      }
      else
      {
        this.mode = 1;
        paramARMapHongBaoListView.mForStory = false;
        this.mChatTopRefresh.a(21, null);
      }
      if ((this.preMode != 3) && (this.mode == 3))
      {
        animateOpen();
        MiniAppUtils.checkMiniAppDesktopSendRequest();
        AppBrandLaunchManager.g().onMiniAppUIOpen();
      }
      else if (this.mode == 1)
      {
        resetAnimationStatus();
        if (this.preMode == 3)
        {
          MiniAppDesktopLayout.exposureReport(true);
          this.mContentView.closeDesktopReport("button_pull_up");
        }
      }
      if (this.mCareNotificationBar.b() != paramARMapHongBaoListView.mForStory)
      {
        this.mCareNotificationBar.a(paramARMapHongBaoListView.mForStory);
        this.mCareNotificationBar.d();
      }
      setRefreshLayoutVisible(paramARMapHongBaoListView.mForStory ^ true);
      paramARMapHongBaoListView = new StringBuilder();
      paramARMapHongBaoListView.append("fight...onTouchMoving.onUp..scrollY = ");
      paramARMapHongBaoListView.append(f1);
      QLog.d("MiniAppDesktop", 2, paramARMapHongBaoListView.toString());
      this.hasVibrate = false;
      this.refreshState = 0;
      pullDownResultReport(-f1);
      return;
    }
    if (this.mode == 1)
    {
      this.flag = true;
      setMicroAppEntryCompleteVisible(false);
    }
    this.mLastScrollY = 0.0F;
    this.hasVibrate = false;
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      paramARMapHongBaoListView = new StringBuilder();
      paramARMapHongBaoListView.append("onViewCompleteAfterRefresh, mode:");
      paramARMapHongBaoListView.append(this.mode);
      QLog.d("MiniAppDesktop", 2, paramARMapHongBaoListView.toString());
    }
    MiniProgramLpReportDC04239.reportAsync("desktop", "refresh", null, null);
    int i = this.mode;
    if (i == 2)
    {
      this.mode = 1;
      return 0;
    }
    if (i == 3) {
      return -getListViewScrollY();
    }
    return 0;
  }
  
  public void replaceTopRefresh(Object paramObject)
  {
    this.mChatTopRefresh = ((IPullRefreshHeaderControl)paramObject);
    paramObject = this.mContentView;
    if (paramObject != null)
    {
      if ((paramObject.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      }
      this.mChatTopRefresh.a(2, this.mContentView);
      this.mChatTopRefresh.a(1, null);
      return;
    }
    initUI((Activity)this.mActivityReference.get());
  }
  
  public boolean showMicroAppEntry()
  {
    if ((this.mListView.mEnableStory) && (!this.mListView.mForStory) && (this.mListView.getListViewScrollY() == 0))
    {
      this.mListView.setScrollY(-this.mContentView.getHeight());
      this.mListView.mForStory = true;
      this.mode = 3;
      animateOpen();
      setMicroAppEntryCompleteVisible(true);
      setRefreshLayoutVisible(false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop
 * JD-Core Version:    0.7.0.1
 */