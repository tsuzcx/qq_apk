package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniAppDesktopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int MINI_APP_MOVE_UP_CLOSE_DISTANCE = ViewUtils.b(150.0F);
  public static final int MINI_APP_TRIGGER_CLOSE_DISTANCE = ViewUtils.b(65.0F);
  private static final int SCROLL_MODE_HORIZONTAL = 1;
  private static final int SCROLL_MODE_UNDEFINED = 0;
  private static final int SCROLL_MODE_VERTICAL = 2;
  public static final String TAG = "MicroAppEntryLayout";
  private List<DesktopChangeListener> desktopChangeListenerList = new ArrayList();
  private volatile Drawable hbDrawable;
  private WeakReference<BaseActivity> mActivityRef;
  private MiniAppDesktopAdapter mAdapter;
  private ImageView mCapsuleLeftButton;
  private View mCapsuleLeftButtonContainer;
  private TextView mCapsuleLeftButtonRedDotView;
  private ImageView mCloseDesktopView;
  private QQBlurView mCollapseDesktopBlurView;
  private ImageView mCollapseDesktopImage;
  private View mCollapseDesktopView;
  private BaseActivity mContext;
  private ViewGroup mDeleteLayout;
  private TextView mDeleteText;
  private RelativeLayout mDesktopNavbarLayout;
  private DragRecyclerView.DragDeleteListener mDragDeleteListener;
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
    int i = 0;
    this.result = false;
    this.mIsDragging = false;
    this.mDragDeleteListener = new MiniAppDesktopLayout.1(this);
    paramARMapHongBaoListView = (BaseActivity)paramContext;
    this.mContext = paramARMapHongBaoListView;
    this.mActivityRef = new WeakReference(paramARMapHongBaoListView);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext.getApplicationContext(), 2131562377, this);
    this.mRecyclerView = ((DragRecyclerView)findViewById(2131370834));
    this.mDeleteLayout = ((ViewGroup)findViewById(2131365504));
    this.mDeleteText = ((TextView)findViewById(2131365497));
    this.mAdapter = new MiniAppDesktopAdapter((Activity)paramContext, paramInt, this.mRecyclerView);
    this.mDragMirrorView = findViewById(2131371096);
    this.mAdapter.setDragMirrorView(this.mDragMirrorView);
    this.mRecyclerView.setAdapter(this.mAdapter);
    ((DesktopDataManager)paramARMapHongBaoListView.app.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).setDataChangeListener(this.mAdapter);
    addDesktopChangeListener(this.mAdapter);
    this.mRecyclerView.setDragChangeListener(this.mAdapter);
    this.mRecyclerView.addOnScrollListener(new MiniAppDesktopLayout.2(this));
    this.mRecyclerView.setDragDeleteListener(this.mDragDeleteListener);
    this.mThemeBackgroudView = ((ImageView)findViewById(2131371100));
    this.mNormalStateView = ((ViewGroup)findViewById(2131371141));
    this.mCloseDesktopView = ((ImageView)findViewById(2131371078));
    this.mCloseDesktopView.setOnClickListener(this);
    this.mCollapseDesktopView = findViewById(2131371138);
    this.mCollapseDesktopView.setOnClickListener(this);
    this.mCollapseDesktopImage = ((ImageView)findViewById(2131371139));
    this.mCollapseDesktopBlurView = ((QQBlurView)findViewById(2131371137));
    this.mGridLayoutManager = new MiniAppDesktopLayout.MiniAppGridLayoutManager(paramContext, 4);
    this.mGridLayoutManager.setAutoMeasureEnabled(false);
    this.mRecyclerView.setLayoutManager(this.mGridLayoutManager);
    this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, getResources().getDimensionPixelSize(2131296925), true));
    this.mRecyclerView.setHasFixedSize(true);
    this.mGridLayoutManager.setSpanSizeLookup(this.mAdapter.getSpanSizeLookup());
    this.mCapsuleLeftButtonContainer = findViewById(2131371082);
    this.mCapsuleLeftButtonContainer.setOnClickListener(this);
    this.mCapsuleLeftButton = ((ImageView)findViewById(2131371081));
    this.mCapsuleLeftButtonRedDotView = ((TextView)findViewById(2131371083));
    this.mDesktopNavbarLayout = ((RelativeLayout)findViewById(2131370833));
    paramInt = Math.round(ImmersiveUtils.getStatusBarHeight(paramContext));
    paramContext = new LinearLayout.LayoutParams(-1, ViewUtils.b(46.0F));
    paramContext.setMargins(0, paramInt, 0, 0);
    this.mDesktopNavbarLayout.setLayoutParams(paramContext);
    this.mShowCapsuleLeftButtonAsNotificationButton = MiniAppConfProcessor.f();
    boolean bool = MiniAppConfProcessor.i();
    if (!this.mShowCapsuleLeftButtonAsNotificationButton)
    {
      paramInt = i;
      if (!bool) {}
    }
    else
    {
      paramInt = 1;
    }
    if (paramInt == 0)
    {
      paramContext = findViewById(2131371047);
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
    paramContext = MiniAppConfProcessor.d();
    this.mTitleView = ((TextView)findViewById(2131371094));
    this.mTitleView.setText(paramContext);
    ThreadManager.getUIHandler().post(new MiniAppDesktopLayout.3(this, paramARMapHongBaoListView));
    initCollapseDesktopBlurView();
  }
  
  public static void exposureReport(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null) {
      localObject = (MiniAppExposureManager)((AppInterface)localObject).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localArrayList.addAll(((MiniAppExposureManager)localObject).getDuplicateItemMap().values());
      MiniProgramLpReportDC04239.exposureReport(localArrayList);
      if (paramBoolean) {
        ((MiniAppExposureManager)localObject).clear();
      }
    }
  }
  
  private void handleJumpToNotificationClick(BaseActivity paramBaseActivity)
  {
    String str = null;
    StartupTracker.a(null, "Recent_clk_enterchat");
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramBaseActivity, SplashActivity.class.getName());
    localObject = AIOUtils.a((Intent)localObject, new int[] { 1 });
    ((Intent)localObject).putExtra("uin", MiniAppConfProcessor.b());
    ((Intent)localObject).putExtra("uintype", 1038);
    ((Intent)localObject).putExtra("uinname", MiniAppConfProcessor.c());
    ((Intent)localObject).putExtra("entrance", 22);
    RecentUtil.a((Intent)localObject);
    paramBaseActivity.startActivity((Intent)localObject);
    StartupTracker.a("Recent_clk_enterchat", null);
    paramBaseActivity = str;
    if (this.mCapsuleLeftButtonRedDotView.getVisibility() == 0)
    {
      localObject = this.mCapsuleLeftButtonRedDotView.getText();
      paramBaseActivity = str;
      if (localObject != null) {
        paramBaseActivity = ((CharSequence)localObject).toString();
      }
    }
    if (TextUtils.isEmpty(paramBaseActivity)) {
      str = "0";
    } else {
      str = "1";
    }
    MiniProgramLpReportDC04239.reportAsync("desktop", "notification", "click", str, paramBaseActivity, null);
    this.mCapsuleLeftButtonRedDotView.setVisibility(8);
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
      Object localObject = this.mCollapseDesktopBlurView;
      ((QQBlurView)localObject).b((View)localObject);
      localObject = getResources().getDrawable(2130850361);
      ((Drawable)localObject).setAlpha(200);
      this.mCollapseDesktopBlurView.a((Drawable)localObject);
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
      if ((!ThemeUtil.isDefaultTheme()) && (!MiniAppUtils.isNightMode()) && (!ThemeUtil.isGoldenTheme()) && (!DisplayUtil.isWhiteModeTheme()) && (!QQTheme.d(ThemeUtil.getCurrentThemeId())))
      {
        this.mThemeBackgroudView.setVisibility(0);
        this.mThemeBackgroudView.setImageResource(2130838740);
      }
      else
      {
        this.mThemeBackgroudView.setImageResource(2130850581);
      }
      Object localObject;
      if (!ThemeUtil.isDefaultTheme())
      {
        localObject = this.mCollapseDesktopView;
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(2130838740);
        }
      }
      if (this.hbDrawable != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setContentViewThemeBackground, w:");
          ((StringBuilder)localObject).append(this.hbDrawable.getIntrinsicWidth());
          ((StringBuilder)localObject).append(", h:");
          ((StringBuilder)localObject).append(this.hbDrawable.getIntrinsicHeight());
          QLog.d("MicroAppEntryLayout", 2, ((StringBuilder)localObject).toString());
        }
        this.mThemeBackgroudView.setImageDrawable(this.hbDrawable);
        this.mThemeBackgroudView.setVisibility(0);
      }
    }
  }
  
  private void updateCapsuleLeftButtonDrawable()
  {
    ImageView localImageView = this.mCapsuleLeftButton;
    if (localImageView != null)
    {
      if (this.mShowCapsuleLeftButtonAsNotificationButton)
      {
        localImageView.setImageResource(2130841020);
        return;
      }
      if (MiniAppUtils.isNightMode())
      {
        this.mCapsuleLeftButton.setImageResource(2130850597);
        return;
      }
      if (ThemeUtil.isDefaultTheme()) {
        this.mCapsuleLeftButton.setImageResource(2130848654);
      }
    }
  }
  
  public void addDesktopChangeListener(DesktopChangeListener paramDesktopChangeListener)
  {
    if ((paramDesktopChangeListener != null) && (!this.desktopChangeListenerList.contains(paramDesktopChangeListener))) {
      this.desktopChangeListenerList.add(paramDesktopChangeListener);
    }
  }
  
  public void checkContentViewLayoutChanged(int paramInt)
  {
    Activity localActivity = (Activity)this.mActivityRef.get();
    if (localActivity != null)
    {
      if (paramInt <= 0) {
        paramInt = DisplayUtil.getScreenHeight(localActivity);
      }
      setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      requestLayout();
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
    Iterator localIterator = this.desktopChangeListenerList.iterator();
    while (localIterator.hasNext()) {
      ((DesktopChangeListener)localIterator.next()).onDesktopClosed();
    }
    this.mCollapseDesktopBlurView.b();
    ThreadManager.getUIHandler().postDelayed(new MiniAppDesktopLayout.6(this), 50L);
  }
  
  public void desktopOpened()
  {
    updatePullDownTime();
    Iterator localIterator = this.desktopChangeListenerList.iterator();
    while (localIterator.hasNext()) {
      ((DesktopChangeListener)localIterator.next()).onDesktopOpened();
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
    Iterator localIterator = this.desktopChangeListenerList.iterator();
    while (localIterator.hasNext()) {
      ((DesktopChangeListener)localIterator.next()).onDesktopResume();
    }
  }
  
  public void destroy()
  {
    MiniAppDesktopAdapter localMiniAppDesktopAdapter = this.mAdapter;
    if (localMiniAppDesktopAdapter != null) {
      localMiniAppDesktopAdapter.onDesktopDestroy();
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
    int i = paramMotionEvent.getAction() & 0xFF;
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    boolean bool1;
    if (i != 0)
    {
      if (i == 2)
      {
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
        if ((this.mScrollMode == 2) && (f1 - this.mLastY < 0.0F)) {
          i = 1;
        } else {
          i = 0;
        }
        if (this.mPressY >= ViewUtils.b() - MINI_APP_TRIGGER_CLOSE_DISTANCE) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((i != 0) && (bool1)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((this.mScrollMode == 2) && (this.result) && (!this.mIsDragging) && (i != 0))
        {
          this.result = false;
          paramMotionEvent.setAction(3);
          dispatchTouchEvent(paramMotionEvent);
          paramView = new StringBuilder();
          paramView.append("interceptDrawer, isSlideToBottom=");
          paramView.append(bool2);
          paramView.append(", fromScreenBottom=");
          paramView.append(bool1);
          QLog.d("MicroAppEntryLayout", 1, paramView.toString());
        }
        this.mLastY = f1;
      }
    }
    else
    {
      getLocationInWindow(this.mMiniAppLauncherLocation);
      paramView.getLocationInWindow(this.mParentLocation);
      paramView = this.mMiniAppLauncherLocation;
      if ((f1 >= paramView[1]) && (f1 < paramView[1] + getHeight())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.result = bool1;
      this.mPressX = f2;
      this.mLastY = f1;
      this.mPressY = f1;
      this.mLimitY = -1000;
      this.mScrollMode = 0;
    }
    if (this.result)
    {
      paramMotionEvent.offsetLocation(0.0F, this.mParentLocation[1] - this.mMiniAppLauncherLocation[1]);
      dispatchTouchEvent(paramMotionEvent);
    }
    return this.result;
  }
  
  protected boolean isSlideToBottom(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {
      return false;
    }
    return paramRecyclerView.computeVerticalScrollExtent() + paramRecyclerView.computeVerticalScrollOffset() >= paramRecyclerView.computeVerticalScrollRange();
  }
  
  public void notificationButtonExposureReport()
  {
    if (this.mShowCapsuleLeftButtonAsNotificationButton)
    {
      Object localObject = this.mCapsuleLeftButtonRedDotView;
      if (localObject != null)
      {
        String str2 = null;
        String str1 = str2;
        if (((TextView)localObject).getVisibility() == 0)
        {
          localObject = this.mCapsuleLeftButtonRedDotView.getText();
          str1 = str2;
          if (localObject != null) {
            str1 = ((CharSequence)localObject).toString();
          }
        }
        if (TextUtils.isEmpty(str1)) {
          str2 = "0";
        } else {
          str2 = "1";
        }
        localObject = MiniAppUtils.getAppInterface();
        if (localObject != null) {
          ((MiniAppExposureManager)((AppInterface)localObject).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).putReportDataToMap("notification", new MiniAppExposureManager.CommonExposureData("desktop", "notification", "expo", str2, str1));
        }
      }
    }
  }
  
  public void notifyDesktopOpenAnimationStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MicroAppEntryLayout", 2, "notifyDesktopOpenAnimationStart");
    }
    Iterator localIterator = this.desktopChangeListenerList.iterator();
    while (localIterator.hasNext()) {
      ((DesktopChangeListener)localIterator.next()).onStartDesktopOpenAnimation();
    }
  }
  
  public void notifyMiniAppDataChanged()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null)
    {
      QLog.e("MicroAppEntryLayout", 1, "notifyMiniAppDataChanged, app is null.");
      return;
    }
    Object localObject2 = (DesktopDataManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    localObject1 = ((DesktopDataManager)localObject2).getData();
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject2 = ((DesktopDataManager)localObject2).getRedDotData();
      MiniAppDesktopAdapter localMiniAppDesktopAdapter = this.mAdapter;
      if ((localMiniAppDesktopAdapter != null) && (localObject1 != null))
      {
        localMiniAppDesktopAdapter.setData((List)localObject1, (Map)localObject2);
        this.mAdapter.notifyDataSetChanged();
      }
      int i = 0;
      MiniAppDesktop.dittoBannerHeight = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (DesktopItemInfo)((List)localObject1).get(i);
        if (((localObject2 instanceof DesktopAppModuleInfo)) && (((DesktopItemInfo)localObject2).getModuleType() == 2)) {
          return;
        }
        if (((localObject2 instanceof DesktopDittoInfo)) && (((DesktopItemInfo)localObject2).getModuleType() == 7))
        {
          localObject2 = getRecyclerView().getChildAt(i);
          if (localObject2 != null) {
            MiniAppDesktop.dittoBannerHeight += ((View)localObject2).getMeasuredHeight();
          }
        }
        i += 1;
      }
      return;
    }
    if (((DesktopDataManager)localObject2).getPullDownEntryExtInfo() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MicroAppEntryLayout", 1, "[DesktopDataManager]. updateMicroAppItemData");
      }
      MiniAppUtils.checkMiniAppDesktopSendRequest();
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    MiniAppDesktopAdapter localMiniAppDesktopAdapter = this.mAdapter;
    if (localMiniAppDesktopAdapter != null) {
      localMiniAppDesktopAdapter.onDesktopAccountChanged();
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
    MiniAppDesktopAdapter localMiniAppDesktopAdapter = this.mAdapter;
    if (localMiniAppDesktopAdapter != null)
    {
      localMiniAppDesktopAdapter.setRedDotSwitchState(paramInt);
      if (paramBoolean) {
        this.mAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivityRef.get();
    if (localBaseActivity == null) {
      return;
    }
    if (paramView.getId() == 2131371082)
    {
      if (this.mShowCapsuleLeftButtonAsNotificationButton)
      {
        handleJumpToNotificationClick(localBaseActivity);
        return;
      }
      handleJumpToSettingClick(localBaseActivity);
      return;
    }
    if (paramView.getId() == 2131371078)
    {
      MiniAppUtils.updateMiniAppList(100);
      closeDesktopReport("off_right");
      return;
    }
    if (paramView.getId() == 2131371138)
    {
      MiniAppUtils.updateMiniAppList(100);
      closeDesktopReport("off_bottom");
      return;
    }
    MiniAppUtils.handleMiniAppMoreClick(localBaseActivity);
  }
  
  public void onPostThemeChanged()
  {
    QLog.i("MicroAppEntryLayout", 2, "onPostThemeChanged");
    try
    {
      this.mRecyclerView.setBackgroundDrawable(null);
      this.mRecyclerView.getRecycledViewPool().clear();
    }
    catch (Exception localException)
    {
      QLog.e("MicroAppEntryLayout", 1, "onPostThemeChanged:", localException);
    }
    updateHongBaoRes();
    initCollapseDesktopBlurView();
  }
  
  public void removeDesktopChangeListener(DesktopChangeListener paramDesktopChangeListener)
  {
    if ((paramDesktopChangeListener != null) && (this.desktopChangeListenerList.contains(paramDesktopChangeListener))) {
      this.desktopChangeListenerList.remove(paramDesktopChangeListener);
    }
  }
  
  public void reset()
  {
    Object localObject = this.mDragMirrorView;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.mAdapter;
    if (localObject != null) {
      ((MiniAppDesktopAdapter)localObject).reset();
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
    MiniAppDesktopAdapter localMiniAppDesktopAdapter = this.mAdapter;
    if (localMiniAppDesktopAdapter != null) {
      localMiniAppDesktopAdapter.startAnimation();
    }
  }
  
  public void stopSwitchIconAnimation()
  {
    MiniAppDesktopAdapter localMiniAppDesktopAdapter = this.mAdapter;
    if (localMiniAppDesktopAdapter != null) {
      localMiniAppDesktopAdapter.stopAnimation();
    }
  }
  
  public void updateHongBaoRes()
  {
    QLog.i("MicroAppEntryLayout", 2, "---updateHongBaoRes---");
    try
    {
      if (this.mTitleView != null) {
        this.mTitleView.setTextColor(getContext().getResources().getColor(2131167063));
      }
      if (this.mCloseDesktopView != null) {
        this.mCloseDesktopView.setImageResource(2130841006);
      }
      if (this.mCollapseDesktopImage != null) {
        this.mCollapseDesktopImage.setImageResource(2130841007);
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
      boolean bool1 = MiniAppConfProcessor.g();
      boolean bool2 = ((AppletsFolderManager)((AppInterface)localObject).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a();
      localObject = (BaseActivity)this.mActivityRef.get();
      if ((bool1) && (bool2) && (localObject != null))
      {
        String str = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
        int i = ((BaseActivity)localObject).app.getConversationFacade().a(str, 1038);
        if (i > 0)
        {
          CustomWidgetUtil.a(this.mCapsuleLeftButtonRedDotView, 7, i, 0);
          this.mCapsuleLeftButtonRedDotView.setVisibility(0);
          return;
        }
        this.mCapsuleLeftButtonRedDotView.setVisibility(8);
        return;
      }
      this.mCapsuleLeftButtonRedDotView.setVisibility(8);
    }
  }
  
  public void updateMiniDesktopBackground(@Nullable Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MicroAppEntryLayout", 2, "updateMiniDesktopBackground");
    }
    this.hbDrawable = paramDrawable;
    setContentViewThemeBackground();
  }
  
  public void updatePullDownTime()
  {
    this.mPullDownTime = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout
 * JD-Core Version:    0.7.0.1
 */