package com.tencent.mobileqq.mini.entry.desktop;

import acmw;
import alcz;
import alik;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arbw;
import bdfk;
import bhhy;
import blas;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CommonExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniAppDesktopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int MINI_APP_MOVE_UP_CLOSE_DISTANCE = ViewUtils.dpToPx(150.0F);
  public static final int MINI_APP_TRIGGER_CLOSE_DISTANCE = ViewUtils.dpToPx(65.0F);
  private static final int SCROLL_MODE_HORIZONTAL = 1;
  private static final int SCROLL_MODE_UNDEFINED = 0;
  private static final int SCROLL_MODE_VERTICAL = 2;
  public static final String TAG = "MicroAppEntryLayout";
  private WeakReference<BaseActivity> mActivityRef;
  private MiniAppDesktopAdapter mAdapter;
  private ImageView mCapsuleLeftButton;
  private View mCapsuleLeftButtonContainer;
  private TextView mCapsuleLeftButtonRedDotView;
  private ImageView mCloseDesktopView;
  private QQBlurView mCollapseDesktopBlurView;
  private ImageView mCollapseDesktopImage;
  private View mCollapseDesktopView;
  private ViewGroup mDeleteLayout;
  private TextView mDeleteText;
  private MiniAppDesktopLayout.DesktopChangeListener mDesktopChangeListener;
  private RelativeLayout mDesktopNavbarLayout;
  private DragRecyclerView.DragDeleteListener mDragDeleteListener = new MiniAppDesktopLayout.1(this);
  private View mDragMirrorView;
  private MiniAppDesktopLayout.MiniAppGridLayoutManager mGridLayoutManager;
  private boolean mIsDragging;
  private float mLastY;
  private int mLimitY;
  private int[] mMiniAppLauncherLocation = new int[2];
  private ViewGroup mNormalStateView;
  private int[] mParentLocation = new int[2];
  private float mPressX;
  private float mPressY;
  private long mPullDownTime;
  private DragRecyclerView mRecyclerView;
  private int mScrollMode;
  private boolean mShowCapsuleLeftButtonAsNotificationButton;
  private ImageView mThemeBackgroudView;
  private TextView mTitleView;
  private int mTouchSlop;
  private boolean result;
  
  public MiniAppDesktopLayout(@NonNull Context paramContext, ARMapHongBaoListView paramARMapHongBaoListView, int paramInt)
  {
    super(paramContext.getApplicationContext());
    paramARMapHongBaoListView = (BaseActivity)paramContext;
    this.mActivityRef = new WeakReference(paramARMapHongBaoListView);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext.getApplicationContext(), 2131562403, this);
    this.mRecyclerView = ((DragRecyclerView)findViewById(2131370931));
    this.mDeleteLayout = ((ViewGroup)findViewById(2131365499));
    this.mDeleteText = ((TextView)findViewById(2131365492));
    this.mAdapter = new MiniAppDesktopAdapter((Activity)paramContext, paramInt, this.mRecyclerView);
    this.mDragMirrorView = findViewById(2131371197);
    this.mAdapter.setDragMirrorView(this.mDragMirrorView);
    this.mRecyclerView.setAdapter(this.mAdapter);
    ((DesktopDataManager)paramARMapHongBaoListView.app.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).setDataChangeListener(this.mAdapter);
    this.mDesktopChangeListener = this.mAdapter;
    this.mRecyclerView.setDragChangeListener(this.mAdapter);
    this.mRecyclerView.addOnScrollListener(new MiniAppDesktopLayout.2(this));
    this.mRecyclerView.setDragDeleteListener(this.mDragDeleteListener);
    this.mThemeBackgroudView = ((ImageView)findViewById(2131371201));
    this.mNormalStateView = ((ViewGroup)findViewById(2131371242));
    this.mCloseDesktopView = ((ImageView)findViewById(2131371179));
    this.mCloseDesktopView.setOnClickListener(this);
    this.mCollapseDesktopView = findViewById(2131371239);
    this.mCollapseDesktopView.setOnClickListener(this);
    this.mCollapseDesktopImage = ((ImageView)findViewById(2131371240));
    this.mCollapseDesktopBlurView = ((QQBlurView)findViewById(2131371238));
    this.mGridLayoutManager = new MiniAppDesktopLayout.MiniAppGridLayoutManager(paramContext, 4);
    this.mGridLayoutManager.setAutoMeasureEnabled(false);
    this.mRecyclerView.setLayoutManager(this.mGridLayoutManager);
    this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, getResources().getDimensionPixelSize(2131296922), true));
    this.mRecyclerView.setHasFixedSize(true);
    this.mGridLayoutManager.setSpanSizeLookup(this.mAdapter.getSpanSizeLookup());
    this.mCapsuleLeftButtonContainer = findViewById(2131371183);
    this.mCapsuleLeftButtonContainer.setOnClickListener(this);
    this.mCapsuleLeftButton = ((ImageView)findViewById(2131371182));
    this.mCapsuleLeftButtonRedDotView = ((TextView)findViewById(2131371184));
    this.mDesktopNavbarLayout = ((RelativeLayout)findViewById(2131370930));
    paramInt = Math.round(ImmersiveUtils.getStatusBarHeight(paramContext));
    paramContext = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0F));
    paramContext.setMargins(0, paramInt, 0, 0);
    this.mDesktopNavbarLayout.setLayoutParams(paramContext);
    this.mShowCapsuleLeftButtonAsNotificationButton = arbw.f();
    boolean bool = arbw.i();
    if ((this.mShowCapsuleLeftButtonAsNotificationButton) || (bool)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        paramContext = findViewById(2131371148);
        if (Build.VERSION.SDK_INT >= 16) {
          paramContext.setBackground(null);
        }
        this.mCapsuleLeftButtonContainer.setVisibility(8);
        paramContext = this.mCloseDesktopView.getLayoutParams();
        if ((paramContext instanceof RelativeLayout.LayoutParams))
        {
          paramContext = (RelativeLayout.LayoutParams)paramContext;
          paramContext.addRule(11);
          this.mCloseDesktopView.setLayoutParams(paramContext);
        }
      }
      updateCapsuleLeftButtonDrawable();
      paramContext = arbw.d();
      this.mTitleView = ((TextView)findViewById(2131371195));
      this.mTitleView.setText(paramContext);
      ThreadManager.getUIHandler().post(new MiniAppDesktopLayout.3(this, paramARMapHongBaoListView));
      initCollapseDesktopBlurView();
      return;
    }
  }
  
  public static void exposureReport(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    MiniAppExposureManager localMiniAppExposureManager = null;
    if (localAppInterface != null) {
      localMiniAppExposureManager = (MiniAppExposureManager)localAppInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    }
    if (localMiniAppExposureManager != null)
    {
      localArrayList.addAll(localMiniAppExposureManager.getDuplicateItemMap().values());
      MiniProgramLpReportDC04239.exposureReport(localArrayList);
      if (paramBoolean) {
        localMiniAppExposureManager.clear();
      }
    }
  }
  
  private void handleJumpToNotificationClick(BaseActivity paramBaseActivity)
  {
    bhhy.a(null, "Recent_clk_enterchat");
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramBaseActivity, SplashActivity.class.getName());
    localObject = AIOUtils.setOpenAIOIntent((Intent)localObject, new int[] { 1 });
    ((Intent)localObject).putExtra("uin", arbw.b());
    ((Intent)localObject).putExtra("uintype", 1038);
    ((Intent)localObject).putExtra("uinname", arbw.c());
    ((Intent)localObject).putExtra("entrance", 22);
    alik.a((Intent)localObject);
    paramBaseActivity.startActivity((Intent)localObject);
    bhhy.a("Recent_clk_enterchat", null);
    if (this.mCapsuleLeftButtonRedDotView.getVisibility() == 0)
    {
      paramBaseActivity = this.mCapsuleLeftButtonRedDotView.getText();
      if (paramBaseActivity == null) {}
    }
    for (paramBaseActivity = paramBaseActivity.toString();; paramBaseActivity = null)
    {
      if (TextUtils.isEmpty(paramBaseActivity)) {}
      for (localObject = "0";; localObject = "1")
      {
        MiniProgramLpReportDC04239.reportAsync("desktop", "notification", "click", (String)localObject, paramBaseActivity, null);
        this.mCapsuleLeftButtonRedDotView.setVisibility(8);
        return;
      }
    }
  }
  
  private void handleJumpToSettingClick(BaseActivity paramBaseActivity)
  {
    PublicFragmentActivity.a(paramBaseActivity, MiniAppEntrySettingFragment.class);
  }
  
  private void initCollapseDesktopBlurView()
  {
    if (ThemeUtil.isDefaultTheme())
    {
      this.mCollapseDesktopView.setBackgroundDrawable(null);
      this.mCollapseDesktopBlurView.a(this);
      this.mCollapseDesktopBlurView.b(this.mCollapseDesktopBlurView);
      Drawable localDrawable = getResources().getDrawable(2130850036);
      localDrawable.setAlpha(200);
      this.mCollapseDesktopBlurView.a(localDrawable);
      this.mCollapseDesktopBlurView.a(12);
      this.mCollapseDesktopBlurView.a(5.0F);
      this.mCollapseDesktopBlurView.b(0);
      this.mCollapseDesktopBlurView.setDirtyListener(new MiniAppDesktopLayout.4(this));
      this.mCollapseDesktopBlurView.d();
    }
  }
  
  private void setContentViewThemeBackground()
  {
    if (this.mThemeBackgroudView != null)
    {
      if ((!ThemeUtil.isDefaultTheme()) && (!MiniAppUtils.isNightMode()) && (!ThemeUtil.isGoldenTheme()) && (!DisplayUtil.isWhiteModeTheme()) && (!bdfk.b(ThemeUtil.getCurrentThemeId()))) {
        break label74;
      }
      this.mThemeBackgroudView.setImageResource(2130850257);
    }
    for (;;)
    {
      if ((!ThemeUtil.isDefaultTheme()) && (this.mCollapseDesktopView != null)) {
        this.mCollapseDesktopView.setBackgroundResource(2130838912);
      }
      return;
      label74:
      this.mThemeBackgroudView.setVisibility(0);
      this.mThemeBackgroudView.setImageResource(2130838912);
    }
  }
  
  private void updateCapsuleLeftButtonDrawable()
  {
    if (this.mCapsuleLeftButton != null)
    {
      if (!this.mShowCapsuleLeftButtonAsNotificationButton) {
        break label25;
      }
      this.mCapsuleLeftButton.setImageResource(2130841013);
    }
    label25:
    do
    {
      return;
      if (MiniAppUtils.isNightMode())
      {
        this.mCapsuleLeftButton.setImageResource(2130850273);
        return;
      }
    } while (!ThemeUtil.isDefaultTheme());
    this.mCapsuleLeftButton.setImageResource(2130848417);
  }
  
  public void checkContentViewLayoutChanged(int paramInt)
  {
    Activity localActivity = (Activity)this.mActivityRef.get();
    if (localActivity != null) {
      if (paramInt <= 0) {
        break label37;
      }
    }
    for (;;)
    {
      setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      requestLayout();
      return;
      label37:
      paramInt = DisplayUtil.getScreenHeight(localActivity);
    }
  }
  
  public void clearPullDownTime()
  {
    this.mPullDownTime = 0L;
  }
  
  public void closeDesktopReport(String paramString)
  {
    int i = MiniAppDesktopAdapter.getMiniAppOpenedCount();
    MiniProgramLpReportDC04239.reportAsync("desktop", "off", paramString, String.format("%.2f", new Object[] { Float.valueOf((float)(SystemClock.uptimeMillis() - this.mPullDownTime) / 1000.0F) }), String.valueOf(i), null);
  }
  
  public void desktopClosed()
  {
    if (this.mDesktopChangeListener != null) {
      this.mDesktopChangeListener.onDesktopClosed();
    }
    this.mCollapseDesktopBlurView.b();
    ThreadManager.getUIHandler().postDelayed(new MiniAppDesktopLayout.6(this), 50L);
  }
  
  public void desktopOpened()
  {
    updatePullDownTime();
    if (this.mDesktopChangeListener != null) {
      this.mDesktopChangeListener.onDesktopOpened();
    }
    updateHongBaoRes();
    notificationButtonExposureReport();
    updateLeftButtonRedDot();
    ThreadManager.getUIHandler().postDelayed(new MiniAppDesktopLayout.5(this), 500L);
    MiniProgramLpReportDC04239.reportAsync("desktop", "pulldown", null, null);
    this.mCollapseDesktopBlurView.a();
  }
  
  public void desktopResume()
  {
    if (this.mDesktopChangeListener != null) {
      this.mDesktopChangeListener.onDesktopResume();
    }
  }
  
  public ViewGroup getContainerView()
  {
    return this.mNormalStateView;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    boolean bool1;
    switch (i & 0xFF)
    {
    case 1: 
    default: 
      if (this.result)
      {
        paramMotionEvent.offsetLocation(0.0F, this.mParentLocation[1] - this.mMiniAppLauncherLocation[1]);
        dispatchTouchEvent(paramMotionEvent);
      }
      return this.result;
    case 0: 
      getLocationInWindow(this.mMiniAppLauncherLocation);
      paramView.getLocationInWindow(this.mParentLocation);
      if ((f1 >= this.mMiniAppLauncherLocation[1]) && (f1 < this.mMiniAppLauncherLocation[1] + getHeight())) {}
      for (bool1 = true;; bool1 = false)
      {
        this.result = bool1;
        this.mPressX = f2;
        this.mLastY = f1;
        this.mPressY = f1;
        this.mLimitY = -1000;
        this.mScrollMode = 0;
        break;
      }
    }
    f2 = Math.abs(this.mPressX - f2);
    float f3 = Math.abs(this.mPressY - f1);
    if ((this.mScrollMode == 0) && (f2 > this.mTouchSlop)) {
      this.mScrollMode = 1;
    }
    if ((this.mScrollMode == 0) && (f3 > this.mTouchSlop)) {
      this.mScrollMode = 2;
    }
    boolean bool2 = isSlideToBottom(this.mRecyclerView);
    if ((bool2) && (this.mLimitY == -1000)) {
      this.mLimitY = ((int)f1);
    }
    if ((this.mScrollMode == 2) && (f1 - this.mLastY < 0.0F))
    {
      i = 1;
      label298:
      if (this.mPressY < ViewUtils.getScreenHeight() - MINI_APP_TRIGGER_CLOSE_DISTANCE) {
        break label425;
      }
      bool1 = true;
      label317:
      if ((i == 0) || (!bool1)) {
        break label431;
      }
    }
    label425:
    label431:
    for (i = 1;; i = 0)
    {
      if ((this.mScrollMode == 2) && (this.result) && (!this.mIsDragging) && (i != 0))
      {
        this.result = false;
        paramMotionEvent.setAction(3);
        dispatchTouchEvent(paramMotionEvent);
        QLog.d("MicroAppEntryLayout", 1, "interceptDrawer, isSlideToBottom=" + bool2 + ", fromScreenBottom=" + bool1);
      }
      this.mLastY = f1;
      break;
      i = 0;
      break label298;
      bool1 = false;
      break label317;
    }
  }
  
  protected boolean isSlideToBottom(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {}
    while (paramRecyclerView.computeVerticalScrollExtent() + paramRecyclerView.computeVerticalScrollOffset() < paramRecyclerView.computeVerticalScrollRange()) {
      return false;
    }
    return true;
  }
  
  public void notificationButtonExposureReport()
  {
    String str1;
    Object localObject;
    if ((this.mShowCapsuleLeftButtonAsNotificationButton) && (this.mCapsuleLeftButtonRedDotView != null))
    {
      str2 = null;
      str1 = str2;
      if (this.mCapsuleLeftButtonRedDotView.getVisibility() == 0)
      {
        localObject = this.mCapsuleLeftButtonRedDotView.getText();
        str1 = str2;
        if (localObject != null) {
          str1 = ((CharSequence)localObject).toString();
        }
      }
      if (!TextUtils.isEmpty(str1)) {
        break label103;
      }
    }
    label103:
    for (String str2 = "0";; str2 = "1")
    {
      localObject = MiniAppUtils.getAppInterface();
      if (localObject != null) {
        ((MiniAppExposureManager)((AppInterface)localObject).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).putReportDataToMap("notification", new MiniAppExposureManager.CommonExposureData("desktop", "notification", "expo", str2, str1));
      }
      return;
    }
  }
  
  public void notifyMiniAppDataChanged()
  {
    int i = 0;
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MicroAppEntryLayout", 1, "notifyMiniAppDataChanged, app is null.");
    }
    label208:
    for (;;)
    {
      return;
      Object localObject2 = (DesktopDataManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
      localObject1 = ((DesktopDataManager)localObject2).getData();
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        if (((DesktopDataManager)localObject2).getPullDownEntryExtInfo() == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MicroAppEntryLayout", 1, "[DesktopDataManager]. updateMicroAppItemData");
          }
          MiniAppUtils.checkMiniAppDesktopSendRequest();
        }
      }
      else
      {
        localObject2 = ((DesktopDataManager)localObject2).getRedDotData();
        if ((this.mAdapter != null) && (localObject1 != null))
        {
          this.mAdapter.setData((List)localObject1, (Map)localObject2);
          this.mAdapter.notifyDataSetChanged();
        }
        MiniAppDesktop.dittoBannerHeight = 0;
        for (;;)
        {
          if (i >= ((List)localObject1).size()) {
            break label208;
          }
          localObject2 = (DesktopItemInfo)((List)localObject1).get(i);
          if (((localObject2 instanceof DesktopAppModuleInfo)) && (((DesktopItemInfo)localObject2).getModuleType() == 2)) {
            break;
          }
          if (((localObject2 instanceof DesktopDittoInfo)) && (((DesktopItemInfo)localObject2).getModuleType() == 7))
          {
            localObject2 = getRecyclerView().getChildAt(i);
            if (localObject2 != null)
            {
              int j = MiniAppDesktop.dittoBannerHeight;
              MiniAppDesktop.dittoBannerHeight = ((View)localObject2).getMeasuredHeight() + j;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((DesktopDataManager)paramQQAppInterface.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).setDataChangeListener(this.mAdapter);
    updateHongBaoRes();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.i("MicroAppEntryLayout", 2, "onAttachedToWindow");
  }
  
  public void onChangeRedDotSwitch(int paramInt, boolean paramBoolean)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.setRedDotSwitchState(paramInt);
      if (paramBoolean) {
        this.mAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivityRef.get();
    if (localBaseActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131371183)
      {
        if (this.mShowCapsuleLeftButtonAsNotificationButton) {
          handleJumpToNotificationClick(localBaseActivity);
        } else {
          handleJumpToSettingClick(localBaseActivity);
        }
      }
      else if (paramView.getId() == 2131371179)
      {
        MiniAppUtils.updateMiniAppList(100);
        closeDesktopReport("off_right");
      }
      else if (paramView.getId() == 2131371239)
      {
        MiniAppUtils.updateMiniAppList(100);
        closeDesktopReport("off_bottom");
      }
      else
      {
        MiniAppUtils.handleMiniAppMoreClick(localBaseActivity);
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    QLog.i("MicroAppEntryLayout", 2, "onPostThemeChanged");
    try
    {
      this.mRecyclerView.setBackgroundDrawable(null);
      this.mRecyclerView.getRecycledViewPool().clear();
      updateHongBaoRes();
      initCollapseDesktopBlurView();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MicroAppEntryLayout", 1, "onPostThemeChanged:", localException);
      }
    }
  }
  
  public void reset()
  {
    if (this.mDragMirrorView != null) {
      this.mDragMirrorView.setVisibility(4);
    }
    if (this.mAdapter != null) {
      this.mAdapter.reset();
    }
  }
  
  public void setThemeBackgroundDrawable()
  {
    QLog.i("MicroAppEntryLayout", 2, "setThemeBackgroundDrawable");
    try
    {
      setContentViewThemeBackground();
      updateCapsuleLeftButtonDrawable();
      this.mAdapter.notifyDataSetChanged();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MicroAppEntryLayout", 1, "setThemeBackgroundDrawable error.", localThrowable);
    }
  }
  
  public void startSwitchIconAnimation()
  {
    if (this.mAdapter != null) {
      this.mAdapter.startAnimation();
    }
  }
  
  public void stopSwitchIconAnimation()
  {
    if (this.mAdapter != null) {
      this.mAdapter.stopAnimation();
    }
  }
  
  public void updateHongBaoRes()
  {
    QLog.i("MicroAppEntryLayout", 2, "---updateHongBaoRes---");
    try
    {
      if (this.mTitleView != null) {
        this.mTitleView.setTextColor(getContext().getResources().getColor(2131167033));
      }
      if (this.mCloseDesktopView != null) {
        this.mCloseDesktopView.setImageResource(2130840999);
      }
      if (this.mCollapseDesktopImage != null) {
        this.mCollapseDesktopImage.setImageResource(2130841000);
      }
      setThemeBackgroundDrawable();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MicroAppEntryLayout", 1, "updateHongBaoRes error.", localThrowable);
    }
  }
  
  public void updateLeftButtonRedDot()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if ((this.mCapsuleLeftButtonRedDotView != null) && (localObject != null))
    {
      boolean bool1 = arbw.g();
      boolean bool2 = ((alcz)((AppInterface)localObject).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a();
      localObject = (BaseActivity)this.mActivityRef.get();
      if ((!bool1) || (!bool2) || (localObject == null)) {
        break label129;
      }
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
      int i = ((BaseActivity)localObject).app.getConversationFacade().a(str, 1038);
      if (i > 0)
      {
        blas.a(this.mCapsuleLeftButtonRedDotView, 7, i, 0);
        this.mCapsuleLeftButtonRedDotView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.mCapsuleLeftButtonRedDotView.setVisibility(8);
    return;
    label129:
    this.mCapsuleLeftButtonRedDotView.setVisibility(8);
  }
  
  public void updatePullDownTime()
  {
    this.mPullDownTime = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout
 * JD-Core Version:    0.7.0.1
 */