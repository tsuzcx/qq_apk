package com.tencent.mobileqq.mini.entry;

import ahfx;
import ahml;
import ahqy;
import amta;
import amtb;
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
import bbll;
import bfol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class MiniAppDesktop
  implements ahml, bfol, MiniAppPullInterface, BusinessObserver
{
  private static final int MINI_TRANSLATE = bbll.a(-100.0F);
  private static final int MINI_TRIGGER_REFRESH_OFFSET = bbll.a(30.0F);
  public static final int MODE_IDLE = 1;
  public static final int MODE_REFRESH = 2;
  public static final int MODE_SHOW_NODE = 3;
  private static final int OFFSET_NODE_SCROLL = bbll.a(-120.0F);
  private static final int OVER_FLING_DISTANCE = 70;
  private static final int RELEASE_ENTER_DESKTOP = 2;
  private static final int RELEASE_ENTER_IDLE = 0;
  private static final int RELEASE_ENTER_REFRESH = 1;
  public static final String TAG = "MiniAppDesktop";
  public static int dittoBannerHeight;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  boolean flag = false;
  private boolean hasOpenDesktop;
  private boolean hasSetStatusBar;
  private boolean hasVibrate;
  private WeakReference<Activity> mActivityReference;
  private QQAppInterface mApp;
  private final ahqy mCareNotificationBar;
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
  private Vibrator mVibrator;
  private int mode = 1;
  private int preMode = 1;
  private int refreshHeaderHeight = bbll.a(50.0F);
  private ProgressBar refreshProgressBar;
  private int refreshState = 0;
  private TextView refreshTextView;
  private View refreshView;
  
  public MiniAppDesktop(Activity paramActivity, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, ViewGroup paramViewGroup)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mApp = paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.mDrawer = paramDrawerFrame;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mRootView = paramViewGroup;
    this.mChatTopRefresh = paramPullRefreshHeader;
    this.mTitleBarView = ((ViewGroup)paramConversation.a());
    this.mHeadView = ((ViewGroup)paramActivity.findViewById(2131368967));
    this.mQQTabWidget = ((QQTabWidget)paramActivity.findViewById(16908307));
    this.mQQBlurView = ((QQBlurView)paramActivity.findViewById(2131378810));
    this.mListViewContainer = ((ViewGroup)paramConversation.b());
    this.mCareNotificationBar = paramConversation.jdField_a_of_type_Ahqy;
    this.mTriggerFullScreenScrollY = amtb.a(OFFSET_NODE_SCROLL);
  }
  
  private void animateOpen()
  {
    if (getCurrentTab() != MainFragment.b)
    {
      hideMiniAppEntry();
      return;
    }
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "clearDesktopExposureReportData", 0) == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((MiniAppExposureManager)this.mApp.getManager(322)).clear();
      }
      this.hasOpenDesktop = true;
      i = bbll.b(50.0F);
      int j = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      float f = bbll.a();
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
      View localView = this.mTitleBarView.findViewById(2131372760);
      if (localView != null) {
        localView.setVisibility(0);
      }
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
        f2 = -getDefaultTranslation() - (this.refreshHeaderHeight + paramFloat);
        f1 = f2;
        if (f2 > 0.0F) {
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
    boolean bool1 = ((DesktopDataManager)this.mApp.getManager(336)).hasPullSearchData();
    ahfx localahfx = (ahfx)this.mApp.getManager(342);
    boolean bool2 = localahfx.h();
    int j = getTitleBarAndStatusBarHeight() + this.refreshHeaderHeight;
    int i = j;
    if (bool1) {
      i = j + bbll.b(50.0F);
    }
    if (bool2) {
      i = localahfx.a() + i;
    }
    for (;;)
    {
      return i + dittoBannerHeight;
    }
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
      i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865) + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
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
  
  private void resetAnimationStatus()
  {
    QLog.d("MiniAppDesktop", 1, "[animation]. resetAnimationStatus");
    if (this.hasOpenDesktop) {
      this.mContentView.desktopClosed();
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
        int i = ((Activity)localObject).getResources().getColor(2131166931);
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        localObject = (TextView)this.mChatTopRefresh.findViewById(2131375055);
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
        this.mListView.setOverscrollHeader(((Activity)localObject).getResources().getDrawable(2130849717));
        int i = ((Activity)localObject).getResources().getColor(2131166931);
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        localObject = (TextView)this.mChatTopRefresh.findViewById(2131375055);
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
  
  private void setParentClipChildren(boolean paramBoolean)
  {
    this.mListView.setClipChildren(paramBoolean);
    this.mListViewContainer.setClipChildren(paramBoolean);
    this.mRootView.setClipChildren(paramBoolean);
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mChatTopRefresh.findViewById(2131375051);
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
        hideMiniAppEntry();
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
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (this.mApp != null) {
          localObject1 = (ahfx)this.mApp.getManager(342);
        }
        int i;
        if ((localObject1 != null) && (((ahfx)localObject1).h()))
        {
          localObject1 = ((ahfx)localObject1).a();
          Object localObject2 = (DesktopDataManager)this.mApp.getManager(336);
          if (((DesktopDataManager)localObject2).getHongBaoResBuilder() != null)
          {
            localObject1 = ((DesktopDataManager)localObject2).getHongBaoResBuilder();
            if (localObject1 == null) {
              break;
            }
            if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getFullScreenRefreshBgColor() != 2147483647) && (this.refreshView != null)) {
              this.refreshView.setBackgroundColor(((DesktopDataManager.HongBaoResBuilder)localObject1).getFullScreenRefreshBgColor());
            }
            if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getRefreshProgressResId() != -1) && (this.refreshProgressBar != null))
            {
              localObject2 = (Activity)this.mActivityReference.get();
              if (localObject2 != null)
              {
                localObject2 = ((Activity)localObject2).getResources().getDrawable(((DesktopDataManager.HongBaoResBuilder)localObject1).getRefreshProgressResId());
                ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
                this.refreshProgressBar.setIndeterminateDrawable((Drawable)localObject2);
              }
            }
            if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getRefreshTextColor() != 2147483647) && (this.mChatTopRefresh != null))
            {
              i = ((DesktopDataManager.HongBaoResBuilder)localObject1).getRefreshTextColor();
              this.mChatTopRefresh.setTextColor(i, i, i, i, i);
              localObject2 = (TextView)this.mChatTopRefresh.findViewById(2131375055);
              if (localObject2 != null) {
                ((TextView)localObject2).setTextColor(i);
              }
            }
            if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getRefreshArrowColor() == -1) || (this.mChatTopRefresh == null)) {
              break;
            }
            this.mChatTopRefresh.setArrowColor(((DesktopDataManager.HongBaoResBuilder)localObject1).getRefreshArrowColor());
          }
        }
        else
        {
          if (this.refreshView != null) {
            this.refreshView.setBackgroundResource(2130838515);
          }
          if (this.refreshProgressBar != null)
          {
            localObject1 = (Activity)this.mActivityReference.get();
            if (localObject1 != null)
            {
              localObject1 = ((Activity)localObject1).getResources().getDrawable(2130839144);
              ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
              this.refreshProgressBar.setIndeterminateDrawable((Drawable)localObject1);
            }
          }
          if (this.mChatTopRefresh != null) {
            this.mChatTopRefresh.setArrowColor(0);
          }
          localObject1 = (Activity)this.mActivityReference.get();
          if (localObject1 == null) {
            break;
          }
          i = ((Activity)localObject1).getResources().getColor(2131166931);
          this.mChatTopRefresh.setTextColor(i, i, i, i, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppDesktop", 1, "updateRefreshTheme error.", localThrowable);
        return;
      }
    }
  }
  
  private void updateStatusTextColorByHongbao()
  {
    Object localObject;
    if (this.mApp != null)
    {
      localObject = (ahfx)this.mApp.getManager(342);
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)this.mApp.getManager(336);
      if ((localObject != null) && (((ahfx)localObject).h()))
      {
        if (localDesktopDataManager.getHongBaoResBuilder() == null) {
          break label92;
        }
        QLog.d("MiniAppDesktop", 2, "updateStatusTextColorByHongbao - set dart false");
        localObject = (Activity)this.mActivityReference.get();
        if (localObject != null)
        {
          ImmersiveUtils.a(false, ((Activity)localObject).getWindow());
          this.hasSetStatusBar = true;
        }
      }
    }
    label91:
    label92:
    do
    {
      do
      {
        do
        {
          break label91;
          do
          {
            return;
          } while ((!this.hasSetStatusBar) || (!this.hasOpenDesktop));
          QLog.d("MiniAppDesktop", 2, "updateStatusTextColorByHongbao - reser color.");
        } while ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isGoldenTheme()) && (!DisplayUtil.isWhiteModeTheme()) && (!DisplayUtil.isSimpleThemeAndStatusBarOfWhite(ThemeUtil.getCurrentThemeId())));
        localObject = (Activity)this.mActivityReference.get();
      } while (localObject == null);
      ImmersiveUtils.a(true, ((Activity)localObject).getWindow());
      this.hasSetStatusBar = true;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppDesktop", 2, "animateOpen, set status bar text color.");
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
          break label113;
        }
      }
    }
    label113:
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
  
  public void hideMiniAppEntry()
  {
    if ((this.mListView.mEnableStory) && (this.mListView.mForStory))
    {
      this.mListView.springBackOverScrollHeaderView(0);
      this.mListView.mForStory = false;
      this.mode = 1;
      setRefreshLayoutVisible(true);
      MiniAppDesktopLayout.exposureReport(true);
      if (this.hasOpenDesktop) {
        resetAnimationStatus();
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
      this.refreshHeaderHeight = paramActivity.getResources().getDimensionPixelSize(2131298637);
      Object localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.getScreenHeight(paramActivity));
      this.mContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ViewGroup)this.mChatTopRefresh.findViewById(2131370214);
      ((ViewGroup)localObject).addView(this.mContentView);
      this.refreshView = this.mChatTopRefresh.findViewById(2131375051);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.refreshView.getLayoutParams();
      localLayoutParams.addRule(12);
      this.refreshView.setLayoutParams(localLayoutParams);
      ((ViewGroup)localObject).setVisibility(0);
      this.refreshView.setBackgroundResource(2130838515);
      this.mListView.setOverScrollHeight(this.refreshHeaderHeight + MINI_TRIGGER_REFRESH_OFFSET);
      this.refreshProgressBar = ((ProgressBar)this.mChatTopRefresh.findViewById(2131375056));
      this.refreshTextView = ((TextView)this.mChatTopRefresh.findViewById(2131375055));
      this.mListView.setMaxOverScrollTopDistance(70);
      this.mListView.setOverScrollTouchMode(1);
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
    Object localObject = amtb.a();
    if (localObject != null) {
      bool = ((amta)localObject).a();
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
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("MiniAppDesktop", 1, "[DesktopDataManager], onReceive, type = " + paramInt + " , mContentView = " + this.mContentView);
    if (paramInt == 100)
    {
      hideMiniAppEntry();
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
    AbstractGifImage.resumeAll();
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
        if ((f <= -(this.refreshHeaderHeight + MINI_TRIGGER_REFRESH_OFFSET)) && (f > this.mTriggerFullScreenScrollY)) {
          if (this.refreshState != 1)
          {
            this.refreshTextView.setText(2131719804);
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
            this.refreshTextView.setText(2131694280);
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
      label291:
      if ((this.preMode == 1) && (this.mode == 3) && (this.mApp != null)) {
        ((ahfx)this.mApp.getManager(342)).d();
      }
      if ((this.preMode == 3) || (this.mode != 3)) {
        break label578;
      }
      animateOpen();
      MiniAppUtils.checkMiniAppDesktopSendRequest();
      label353:
      if (this.mCareNotificationBar.a() != paramARMapHongBaoListView.mForStory)
      {
        this.mCareNotificationBar.a(paramARMapHongBaoListView.mForStory);
        this.mCareNotificationBar.b();
      }
      if (paramARMapHongBaoListView.mForStory) {
        break label605;
      }
    }
    label578:
    label605:
    for (paramBoolean = true;; paramBoolean = false)
    {
      setRefreshLayoutVisible(paramBoolean);
      QLog.d("MiniAppDesktop", 2, "fight...onTouchMoving.onUp..scrollY = " + f);
      this.hasVibrate = false;
      this.refreshState = 0;
      if ((f >= 0.0F) || (this.mApp == null)) {
        break;
      }
      ((ahfx)this.mApp.getManager(342)).c();
      return;
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f > -getListViewScrollY())
        {
          this.mode = 1;
          paramARMapHongBaoListView.mForStory = false;
          break label291;
        }
        this.mode = 3;
        paramARMapHongBaoListView.mForStory = true;
        break label291;
      }
      if (f <= this.mTriggerFullScreenScrollY)
      {
        this.mode = 3;
        paramARMapHongBaoListView.mForStory = true;
        break label291;
      }
      if (f <= -(this.refreshHeaderHeight + MINI_TRIGGER_REFRESH_OFFSET))
      {
        this.mode = 2;
        paramARMapHongBaoListView.mForStory = false;
        break label291;
      }
      this.mode = 1;
      paramARMapHongBaoListView.mForStory = false;
      break label291;
      if (this.mode != 1) {
        break label353;
      }
      resetAnimationStatus();
      if (this.preMode != 3) {
        break label353;
      }
      MiniAppDesktopLayout.exposureReport(true);
      break label353;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop
 * JD-Core Version:    0.7.0.1
 */