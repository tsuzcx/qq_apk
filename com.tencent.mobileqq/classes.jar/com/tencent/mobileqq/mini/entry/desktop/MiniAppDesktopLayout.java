package com.tencent.mobileqq.mini.entry.desktop;

import actn;
import ahfz;
import ahjz;
import ahpf;
import akpc;
import amtc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
import axmt;
import bbjv;
import bbkx;
import bfqb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CommonExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniAppDesktopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int MINI_APP_MOVE_UP_CLOSE_DISTANCE = bbkx.b(150.0F);
  public static final int MINI_APP_TRIGGER_CLOSE_DISTANCE = bbkx.b(65.0F);
  private static final int SCROLL_MODE_HORIZONTAL = 1;
  private static final int SCROLL_MODE_UNDEFINED = 0;
  private static final int SCROLL_MODE_VERTICAL = 2;
  public static final String TAG = "MicroAppEntryLayout";
  private MiniAppDesktopAdapter mAdapter;
  private ImageView mCapsuleLeftButton;
  private View mCapsuleLeftButtonContainer;
  private TextView mCapsuleLeftButtonRedDotView;
  private ImageView mCloseDesktopView;
  private ImageView mCollapseDesktopImage;
  private View mCollapseDesktopView;
  private BaseActivity mContext;
  private ViewGroup mDeleteLayout;
  private TextView mDeleteText;
  private MiniAppDesktopLayout.DesktopChangeListener mDesktopChangeListener;
  private RelativeLayout mDesktopNavbarLayout;
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
  private DragRecyclerView mRecyclerView;
  private int mScrollMode;
  private boolean mShowCapsuleLeftButtonAsNotificationButton;
  private ImageView mThemeBackgroudView;
  private TextView mTitleView;
  private int mTouchSlop;
  private boolean result;
  
  public MiniAppDesktopLayout(@NonNull Context paramContext, ARMapHongBaoListView paramARMapHongBaoListView, int paramInt)
  {
    super(paramContext);
    this.mContext = ((BaseActivity)paramContext);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext, 2131561974, this);
    this.mRecyclerView = ((DragRecyclerView)findViewById(2131369946));
    this.mDeleteLayout = ((ViewGroup)findViewById(2131365006));
    this.mDeleteText = ((TextView)findViewById(2131364999));
    this.mAdapter = new MiniAppDesktopAdapter((Activity)paramContext, paramInt, this.mRecyclerView);
    this.mDragMirrorView = findViewById(2131370179);
    this.mAdapter.setDragMirrorView(this.mDragMirrorView);
    this.mRecyclerView.setAdapter(this.mAdapter);
    ((DesktopDataManager)this.mContext.app.getManager(336)).setDataChangeListener(this.mAdapter);
    this.mDesktopChangeListener = this.mAdapter;
    this.mRecyclerView.setDragChangeListener(this.mAdapter);
    this.mRecyclerView.addOnScrollListener(new MiniAppDesktopLayout.1(this));
    this.mRecyclerView.setDragDeleteListener(new MiniAppDesktopLayout.2(this));
    this.mThemeBackgroudView = ((ImageView)findViewById(2131370183));
    this.mNormalStateView = ((ViewGroup)findViewById(2131370221));
    this.mCloseDesktopView = ((ImageView)findViewById(2131370169));
    this.mCloseDesktopView.setOnClickListener(this);
    this.mCollapseDesktopView = findViewById(2131370218);
    this.mCollapseDesktopView.setOnClickListener(this);
    this.mCollapseDesktopImage = ((ImageView)findViewById(2131370219));
    this.mGridLayoutManager = new MiniAppDesktopLayout.MiniAppGridLayoutManager(paramContext, 4);
    this.mGridLayoutManager.setAutoMeasureEnabled(false);
    this.mRecyclerView.setLayoutManager(this.mGridLayoutManager);
    this.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, getResources().getDimensionPixelSize(2131296788), true));
    this.mRecyclerView.setHasFixedSize(true);
    this.mGridLayoutManager.setSpanSizeLookup(this.mAdapter.getSpanSizeLookup());
    this.mCapsuleLeftButtonContainer = findViewById(2131370173);
    this.mCapsuleLeftButtonContainer.setOnClickListener(this);
    this.mCapsuleLeftButton = ((ImageView)findViewById(2131370172));
    this.mCapsuleLeftButtonRedDotView = ((TextView)findViewById(2131370174));
    this.mDesktopNavbarLayout = ((RelativeLayout)findViewById(2131369945));
    paramInt = Math.round(ImmersiveUtils.getStatusBarHeight(paramContext));
    paramContext = new LinearLayout.LayoutParams(-1, bbkx.b(46.0F));
    paramContext.setMargins(0, paramInt, 0, 0);
    this.mDesktopNavbarLayout.setLayoutParams(paramContext);
    this.mShowCapsuleLeftButtonAsNotificationButton = amtc.j();
    boolean bool = amtc.m();
    if ((this.mShowCapsuleLeftButtonAsNotificationButton) || (bool)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        paramContext = findViewById(2131370168);
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
      paramContext = amtc.d();
      this.mTitleView = ((TextView)findViewById(2131370177));
      this.mTitleView.setText(paramContext);
      ThreadManager.getUIHandler().post(new MiniAppDesktopLayout.3(this));
      return;
    }
  }
  
  public static void exposureReport(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    MiniAppExposureManager localMiniAppExposureManager = null;
    if (localAppInterface != null) {
      localMiniAppExposureManager = (MiniAppExposureManager)localAppInterface.getManager(322);
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
    bbjv.a(null, "Recent_clk_enterchat");
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramBaseActivity, SplashActivity.class.getName());
    localObject = actn.a((Intent)localObject, new int[] { 1 });
    ((Intent)localObject).putExtra("uin", amtc.b());
    ((Intent)localObject).putExtra("uintype", 1038);
    ((Intent)localObject).putExtra("uinname", amtc.c());
    ((Intent)localObject).putExtra("entrance", 22);
    ahpf.a((Intent)localObject);
    paramBaseActivity.startActivity((Intent)localObject);
    bbjv.a("Recent_clk_enterchat", null);
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
  
  private void setContentViewThemeBackground()
  {
    if (this.mThemeBackgroudView != null)
    {
      if ((!ThemeUtil.isDefaultTheme()) && (!MiniAppUtils.isNightMode()) && (!ThemeUtil.isGoldenTheme()) && (!DisplayUtil.isWhiteModeTheme()) && (!axmt.b(ThemeUtil.getCurrentThemeId()))) {
        break label68;
      }
      this.mThemeBackgroudView.setImageResource(2130849133);
      if (this.mCollapseDesktopView != null) {
        this.mCollapseDesktopView.setBackgroundResource(2130849133);
      }
    }
    label68:
    do
    {
      return;
      this.mThemeBackgroudView.setVisibility(0);
      this.mThemeBackgroudView.setImageResource(2130838515);
    } while (this.mCollapseDesktopView == null);
    this.mCollapseDesktopView.setBackgroundResource(2130838515);
  }
  
  private void updateCapsuleLeftButtonDrawable()
  {
    if (this.mCapsuleLeftButton != null)
    {
      if (!this.mShowCapsuleLeftButtonAsNotificationButton) {
        break label25;
      }
      this.mCapsuleLeftButton.setImageResource(2130840626);
    }
    label25:
    do
    {
      return;
      if (MiniAppUtils.isNightMode())
      {
        this.mCapsuleLeftButton.setImageResource(2130849149);
        return;
      }
    } while (!ThemeUtil.isDefaultTheme());
    this.mCapsuleLeftButton.setImageResource(2130847459);
  }
  
  public void checkContentViewLayoutChanged(int paramInt)
  {
    if (paramInt > 0) {}
    for (;;)
    {
      setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      requestLayout();
      return;
      paramInt = DisplayUtil.getScreenHeight(this.mContext);
    }
  }
  
  public void desktopClosed()
  {
    if (this.mDesktopChangeListener != null) {
      this.mDesktopChangeListener.onDesktopClosed();
    }
  }
  
  public void desktopOpened()
  {
    if (this.mDesktopChangeListener != null) {
      this.mDesktopChangeListener.onDesktopOpened();
    }
    updateHongBaoRes();
    notificationButtonExposureReport();
    updateLeftButtonRedDot();
    ThreadManager.getUIHandler().postDelayed(new MiniAppDesktopLayout.4(this), 500L);
    MiniProgramLpReportDC04239.reportAsync("desktop", "pulldown", null, null);
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
    boolean bool3 = isSlideToBottom(this.mRecyclerView);
    if ((bool3) && (this.mLimitY == -1000)) {
      this.mLimitY = ((int)f1);
    }
    label298:
    label321:
    boolean bool2;
    if ((this.mScrollMode == 2) && (f1 - this.mLastY < 0.0F))
    {
      i = 1;
      if ((!bool3) || (this.mLimitY - f1 < MINI_APP_MOVE_UP_CLOSE_DISTANCE)) {
        break label464;
      }
      bool1 = true;
      if (this.mPressY < bbkx.b() - MINI_APP_TRIGGER_CLOSE_DISTANCE) {
        break label470;
      }
      bool2 = true;
      label340:
      if ((i == 0) || ((!bool1) && (!bool2))) {
        break label476;
      }
    }
    label464:
    label470:
    label476:
    for (i = 1;; i = 0)
    {
      if ((this.mScrollMode == 2) && (this.result) && (!this.mIsDragging) && (i != 0))
      {
        this.result = false;
        paramMotionEvent.setAction(3);
        dispatchTouchEvent(paramMotionEvent);
        QLog.d("MicroAppEntryLayout", 1, "interceptDrawer, isSlideToBottom=" + bool3 + ", exceedMoveUpLimit=" + bool1 + ", fromScreenBottom=" + bool2);
      }
      this.mLastY = f1;
      break;
      i = 0;
      break label298;
      bool1 = false;
      break label321;
      bool2 = false;
      break label340;
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
        ((MiniAppExposureManager)((AppInterface)localObject).getManager(322)).putReportDataToMap("notification", new MiniAppExposureManager.CommonExposureData("desktop", "notification", "expo", str2, str1));
      }
      return;
    }
  }
  
  public void notifyMiniAppDataChanged()
  {
    int i = 0;
    Object localObject = (DesktopDataManager)this.mContext.app.getManager(336);
    List localList = ((DesktopDataManager)localObject).getData();
    if ((localList == null) || (localList.size() == 0)) {
      if (((DesktopDataManager)localObject).getPullDownEntryExtInfo() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MicroAppEntryLayout", 1, "[DesktopDataManager]. updateMicroAppItemData");
        }
        MiniAppUtils.checkMiniAppDesktopSendRequest();
      }
    }
    label196:
    for (;;)
    {
      return;
      localObject = ((DesktopDataManager)localObject).getRedDotData();
      if ((this.mAdapter != null) && (localList != null))
      {
        this.mAdapter.setData(localList, (Map)localObject);
        this.mAdapter.notifyDataSetChanged();
      }
      MiniAppDesktop.dittoBannerHeight = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label196;
        }
        localObject = (DesktopItemInfo)localList.get(i);
        if (((localObject instanceof DesktopAppModuleInfo)) && (((DesktopItemInfo)localObject).getModuleType() == 2)) {
          break;
        }
        if (((localObject instanceof DesktopDittoInfo)) && (((DesktopItemInfo)localObject).getModuleType() == 7))
        {
          localObject = getRecyclerView().getChildAt(i);
          if (localObject != null)
          {
            int j = MiniAppDesktop.dittoBannerHeight;
            MiniAppDesktop.dittoBannerHeight = ((View)localObject).getMeasuredHeight() + j;
          }
        }
        i += 1;
      }
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((DesktopDataManager)paramQQAppInterface.getManager(336)).setDataChangeListener(this.mAdapter);
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
    if (paramView.getId() == 2131370173)
    {
      if (this.mShowCapsuleLeftButtonAsNotificationButton)
      {
        handleJumpToNotificationClick(this.mContext);
        return;
      }
      handleJumpToSettingClick(this.mContext);
      return;
    }
    if (paramView.getId() == 2131370169)
    {
      MiniAppUtils.updateMiniAppList(100);
      MiniProgramLpReportDC04239.reportAsync("desktop", "off", "off_right", null);
      return;
    }
    if (paramView.getId() == 2131370218)
    {
      MiniAppUtils.updateMiniAppList(100);
      MiniProgramLpReportDC04239.reportAsync("desktop", "off", "off_bottom", null);
      return;
    }
    MiniAppUtils.handleMiniAppMoreClick(this.mContext);
  }
  
  public void onPostThemeChanged()
  {
    QLog.i("MicroAppEntryLayout", 2, "onPostThemeChanged");
    try
    {
      this.mRecyclerView.setBackgroundDrawable(null);
      updateHongBaoRes();
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.mContext != null)
      {
        localObject1 = localObject2;
        if (this.mContext.app != null) {
          localObject1 = (ahfz)this.mContext.app.getManager(342);
        }
      }
      if ((localObject1 != null) && (((ahfz)localObject1).h())) {
        updateHongBaoRes();
      }
      for (;;)
      {
        this.mAdapter.notifyDataSetChanged();
        return;
        setContentViewThemeBackground();
        updateCapsuleLeftButtonDrawable();
      }
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
    for (;;)
    {
      try
      {
        if ((this.mContext == null) || (this.mContext.app == null)) {
          break label576;
        }
        localObject1 = (ahfz)this.mContext.app.getManager(342);
        if ((localObject1 == null) || (!((ahfz)localObject1).h())) {
          break label507;
        }
        DesktopDataManager.HongBaoResBuilder localHongBaoResBuilder = ((ahfz)localObject1).a();
        Object localObject2 = (DesktopDataManager)this.mContext.app.getManager(336);
        if (((DesktopDataManager)localObject2).getHongBaoResBuilder() == null) {
          break label573;
        }
        localHongBaoResBuilder = ((DesktopDataManager)localObject2).getHongBaoResBuilder();
        if (localHongBaoResBuilder == null) {
          break;
        }
        if (this.mThemeBackgroudView != null)
        {
          if (((ahfz)localObject1).a() != null) {
            this.mThemeBackgroudView.setImageBitmap(((ahfz)localObject1).a());
          }
        }
        else
        {
          if ((localHongBaoResBuilder.getTextColor() != 2147483647) && (this.mTitleView != null)) {
            this.mTitleView.setTextColor(localHongBaoResBuilder.getTextColor());
          }
          if ((localHongBaoResBuilder.getCapsuleLeftNormalResId() != -1) && (localHongBaoResBuilder.getCapsuleLeftPressResId() != -1) && (this.mCapsuleLeftButton != null))
          {
            localObject1 = new StateListDrawable();
            localObject2 = getResources().getDrawable(localHongBaoResBuilder.getCapsuleLeftPressResId());
            ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
            localObject2 = getResources().getDrawable(localHongBaoResBuilder.getCapsuleLeftNormalResId());
            ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, (Drawable)localObject2);
            this.mCapsuleLeftButton.setImageDrawable((Drawable)localObject1);
          }
          if ((localHongBaoResBuilder.getCapsuleRightNormalResId() != -1) && (localHongBaoResBuilder.getCapsuleRightPressResId() != -1) && (this.mCloseDesktopView != null))
          {
            localObject1 = new StateListDrawable();
            localObject2 = getResources().getDrawable(localHongBaoResBuilder.getCapsuleRightPressResId());
            ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
            localObject2 = getResources().getDrawable(localHongBaoResBuilder.getCapsuleRightNormalResId());
            ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, (Drawable)localObject2);
            this.mCloseDesktopView.setImageDrawable((Drawable)localObject1);
          }
          if ((localHongBaoResBuilder.getMoveUpGuideIconResId() != -1) && (this.mCollapseDesktopImage != null)) {
            this.mCollapseDesktopImage.setImageResource(localHongBaoResBuilder.getMoveUpGuideIconResId());
          }
          if ((localHongBaoResBuilder.getMoveUpGuideBgIconResId() != -1) && (this.mCollapseDesktopView != null)) {
            this.mCollapseDesktopView.setBackgroundResource(localHongBaoResBuilder.getMoveUpGuideBgIconResId());
          }
          if (this.mAdapter == null) {
            break;
          }
          this.mAdapter.notifyDataSetChanged();
          return;
        }
        if ((localHongBaoResBuilder.getBackgroundUrl() != null) && (localHongBaoResBuilder.getBackgroundLoadingResId() != -1) && (localHongBaoResBuilder.getBackgroundFailedResId() != -1))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(localHongBaoResBuilder.getBackgroundLoadingResId());
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(localHongBaoResBuilder.getBackgroundFailedResId());
          this.mThemeBackgroudView.setImageDrawable(URLDrawable.getDrawable(localHongBaoResBuilder.getBackgroundUrl(), (URLDrawable.URLDrawableOptions)localObject1));
          continue;
        }
        if (localThrowable.getBackgroundResId() == -1) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MicroAppEntryLayout", 1, "updateHongBaoRes error.", localThrowable);
        return;
      }
      this.mThemeBackgroudView.setImageResource(localThrowable.getBackgroundResId());
      continue;
      label507:
      if (this.mTitleView != null) {
        this.mTitleView.setTextColor(getContext().getResources().getColor(2131166861));
      }
      if (this.mCloseDesktopView != null) {
        this.mCloseDesktopView.setImageResource(2130840617);
      }
      if (this.mCollapseDesktopImage != null) {
        this.mCollapseDesktopImage.setImageResource(2130840618);
      }
      setThemeBackgroundDrawable();
      return;
      label573:
      continue;
      label576:
      Object localObject1 = null;
    }
  }
  
  public void updateLeftButtonRedDot()
  {
    if (this.mCapsuleLeftButtonRedDotView != null)
    {
      boolean bool1 = amtc.k();
      boolean bool2 = ((ahjz)this.mContext.app.getManager(315)).a();
      if ((!bool1) || (!bool2)) {
        break label109;
      }
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
      int i = this.mContext.app.a().a(str, 1038);
      if (i > 0)
      {
        bfqb.a(this.mCapsuleLeftButtonRedDotView, 7, i, 0);
        this.mCapsuleLeftButtonRedDotView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.mCapsuleLeftButtonRedDotView.setVisibility(8);
    return;
    label109:
    this.mCapsuleLeftButtonRedDotView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout
 * JD-Core Version:    0.7.0.1
 */