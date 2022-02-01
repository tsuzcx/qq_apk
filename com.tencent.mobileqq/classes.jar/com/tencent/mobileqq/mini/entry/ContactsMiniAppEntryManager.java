package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.MiniAppScrollListener;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.StoryTouchEventInterceptor;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class ContactsMiniAppEntryManager
  implements CommonRefreshLayout.MiniAppScrollListener, DrawerFrame.StoryTouchEventInterceptor, BaseContactsMiniAppEntryManager, BusinessObserver
{
  public static final int MODE_IDLE = 1;
  public static final int MODE_REFRESH = 2;
  public static final int MODE_SHOW_NODE = 3;
  private static final int OFFSET_NODE_OPEN = ViewUtils.dip2px(-50.0F);
  private static final int OFFSET_NODE_SCROLL = ViewUtils.dip2px(-50.0F);
  private static final int OFFSET_NODE_SCROLL_FAST = ViewUtils.dip2px(-100.0F);
  private static final float SPEED_2 = 1.5F;
  private static final int STORY_TRANSLATE = ViewUtils.dip2px(-70.0F);
  public static final String TAG = "ContactsMiniAppEntryManager";
  public static long sScrollTimestamp;
  private int OFFSET_SCROLL_OVER;
  boolean flag = false;
  private QQAppInterface mApp;
  private MiniAppEntryLayout mContentView;
  private Context mContext;
  private int mCurrentTab = -1;
  private ViewGroup mMiniAppListLayout;
  private IPullRefreshHeaderControl mPullRefreshHeader;
  private int mode = 1;
  private int preMode = 1;
  
  public ContactsMiniAppEntryManager(Context paramContext, QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout, int paramInt)
  {
    this.mContext = paramContext;
    this.mPullRefreshHeader = ((IPullRefreshHeaderControl)paramRelativeLayout);
    this.mApp = paramQQAppInterface;
    this.mContentView = new MiniAppEntryLayout(paramContext, null, paramInt);
    this.mMiniAppListLayout = this.mContentView.getContainerView();
    this.mApp.registObserver(this);
  }
  
  private void doOnScroll(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.preMode != 3)) {
      this.mContentView.dotViewOnScroll(paramFloat);
    }
    QLog.d("ContactsMiniAppEntryManager", 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%d,offset_scroll_over:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(OFFSET_NODE_SCROLL), Integer.valueOf(this.OFFSET_SCROLL_OVER) }));
    int i = OFFSET_NODE_SCROLL;
    float f1 = i;
    float f2 = 0.0F;
    if (paramFloat <= f1)
    {
      int j = this.OFFSET_SCROLL_OVER;
      if (paramFloat > j)
      {
        int k = OFFSET_NODE_SCROLL_FAST;
        if (paramFloat <= k)
        {
          f1 = (k - paramFloat) / (k - j);
          f2 = STORY_TRANSLATE + (i - k);
          f1 = f2 - f1 * f2 * 1.5F;
        }
        else
        {
          f1 = STORY_TRANSLATE;
          f1 = i - paramFloat + f1;
        }
        f2 = this.mMiniAppListLayout.getTranslationY();
        this.mMiniAppListLayout.setTranslationY(f1);
        f1 = this.mMiniAppListLayout.getTranslationY();
        i = STORY_TRANSLATE;
        if (f1 < i) {
          this.mMiniAppListLayout.setTranslationY(i);
        }
        if (this.mMiniAppListLayout.getTranslationY() > 0.0F) {
          this.mMiniAppListLayout.setTranslationY(0.0F);
        }
        f1 = this.mMiniAppListLayout.getTranslationY() - f2;
        setMicroAppEntryPanelAlpha(1.0F - this.mMiniAppListLayout.getTranslationY() / STORY_TRANSLATE + 0.8F);
        break label294;
      }
    }
    i = this.OFFSET_SCROLL_OVER;
    f1 = f2;
    if (paramFloat <= i)
    {
      f1 = f2;
      if (i != 0)
      {
        setMicroAppEntryCompleteVisible(true);
        f1 = f2;
      }
    }
    label294:
    if (paramFloat > ViewUtils.dpToPx(-70.0F))
    {
      localMiniAppEntryLayout = this.mContentView;
      localMiniAppEntryLayout.setDotViewTranslationY((paramFloat + localMiniAppEntryLayout.getDotViewHeight()) / 2.0F);
      return;
    }
    MiniAppEntryLayout localMiniAppEntryLayout = this.mContentView;
    localMiniAppEntryLayout.setDotViewTranslationY(localMiniAppEntryLayout.getDotViewTranslationY() + f1);
  }
  
  private void onNodeScrollOut()
  {
    sScrollTimestamp = SystemClock.uptimeMillis();
  }
  
  private void removeDrawerFrameEvent(int paramInt)
  {
    Object localObject = FrameHelperActivity.aq;
    if (localObject != null)
    {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
      if (localObject != null) {
        ((DrawerFrame)localObject).a(paramInt);
      }
    }
    else
    {
      QLog.e("ContactsMiniAppEntryManager", 1, "removeDrawerFrameEvent. ref=null");
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
      float f = this.mMiniAppListLayout.getTranslationY();
      int i = STORY_TRANSLATE;
      if (f != i) {
        this.mMiniAppListLayout.setTranslationY(i);
      }
      if (this.mMiniAppListLayout.getAlpha() != 0.0F) {
        setMicroAppEntryPanelAlpha(0.0F);
      }
    }
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    ViewGroup localViewGroup = this.mMiniAppListLayout;
    if (localViewGroup != null) {
      localViewGroup.setAlpha(paramFloat);
    }
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    IPullRefreshHeaderControl localIPullRefreshHeaderControl = this.mPullRefreshHeader;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localIPullRefreshHeaderControl.a(4, Integer.valueOf(i));
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mode != 1) {
      return this.mContentView.interceptDrawer(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mApp.unRegistObserver(this);
    paramQQAppInterface.registObserver(this);
    this.mApp = paramQQAppInterface;
    QLog.d("ContactsMiniAppEntryManager", 1, "[MiniAppUserAppInfoListManager].onAccountChanged");
  }
  
  public void onAccountChanged(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      onAccountChanged((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if (this.mContentView != null)
    {
      if ((paramInt1 > 2) && (this.OFFSET_SCROLL_OVER != 0)) {
        doOnScroll(paramInt2, false);
      }
      if ((paramInt2 <= -this.mContentView.getHeight()) && (this.mContentView.getHeight() != 0))
      {
        setMicroAppEntryCompleteVisible(true);
        this.mContentView.resetDotViewStatus();
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    this.mContentView.onPostThemeChanged();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = this.mContentView;
    if (paramBundle != null) {
      paramBundle.updateMicroAppItemData();
    }
  }
  
  public void onTouchMoving(CommonRefreshLayout paramCommonRefreshLayout, int paramInt, MotionEvent paramMotionEvent)
  {
    if (this.mContentView.getVisibility() != 0) {
      this.mContentView.setVisibility(0);
    }
    if (this.OFFSET_SCROLL_OVER == 0) {
      this.OFFSET_SCROLL_OVER = (-this.mContentView.getHeight());
    }
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
            this.mContentView.resetDotViewStatus();
          }
          if ((paramInt <= 0) && (this.mode == 1))
          {
            doOnScroll(paramInt, true);
            return;
          }
          if (paramInt >= 0) {
            return;
          }
          paramCommonRefreshLayout = new StringBuilder();
          paramCommonRefreshLayout.append("fight...onTouchMoving.onMove..scrollY = ");
          paramCommonRefreshLayout.append(paramInt);
          QLog.d("ContactsMiniAppEntryManager", 2, paramCommonRefreshLayout.toString());
          return;
        }
      }
      this.flag = false;
      this.preMode = this.mode;
      if (paramInt >= 0)
      {
        this.mode = 1;
        paramCommonRefreshLayout.setShowMiniAppPanel(false);
      }
      else if (paramCommonRefreshLayout.g())
      {
        if (paramInt <= -paramCommonRefreshLayout.getHeaderViewHeight())
        {
          paramMotionEvent = (String)this.mPullRefreshHeader.b(11, null);
          if ((paramMotionEvent != null) && (paramMotionEvent.contains(HardCodeUtil.a(2131900736))))
          {
            this.mode = 3;
          }
          else
          {
            QLog.d("ContactsMiniAppEntryManager", 2, "story node start refresh onTouchMoving");
            this.mode = 2;
          }
          paramCommonRefreshLayout.setShowMiniAppPanel(true);
        }
        else if (paramInt <= -this.mContentView.getHeight())
        {
          this.mode = 3;
          paramCommonRefreshLayout.setShowMiniAppPanel(true);
        }
        else
        {
          this.mode = 1;
          paramCommonRefreshLayout.setShowMiniAppPanel(false);
        }
      }
      else if (paramInt <= -this.mContentView.getHeight())
      {
        if (this.mode != 2)
        {
          this.mode = 3;
          paramCommonRefreshLayout.setShowMiniAppPanel(true);
          onNodeScrollOut();
        }
      }
      else if (paramInt <= OFFSET_NODE_OPEN)
      {
        if (this.mode == 2)
        {
          setMicroAppEntryCompleteVisible(false);
        }
        else
        {
          this.mode = 3;
          paramCommonRefreshLayout.setShowMiniAppPanel(true);
          onNodeScrollOut();
        }
      }
      else
      {
        this.mode = 1;
        paramCommonRefreshLayout.setShowMiniAppPanel(false);
      }
      setRefreshLayoutVisible(paramCommonRefreshLayout.g());
      if ((this.preMode == 1) && (this.mode == 3))
      {
        this.mContentView.recordExposureItem();
        if (this.mCurrentTab == FrameControllerUtil.c) {
          MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_contact");
        } else if (this.mCurrentTab == FrameControllerUtil.d) {
          MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_more");
        }
      }
      if ((this.preMode == 3) && (this.mode == 1)) {
        MiniAppEntryLayout.exposureReport();
      }
    }
    else if (this.mode == 1)
    {
      this.flag = true;
      setMicroAppEntryCompleteVisible(false);
      this.mContentView.resetDotViewStatus();
    }
  }
  
  public int onViewCompleteAfterRefresh(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewCompleteAfterRefresh, mode:");
      localStringBuilder.append(this.mode);
      localStringBuilder.append(", showMiniApp: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ContactsMiniAppEntryManager", 2, localStringBuilder.toString());
    }
    this.mContentView.updateMicroAppItemData();
    int i = this.mode;
    if (i == 2) {
      if (paramBoolean) {
        this.mode = 3;
      }
    }
    for (i = this.mContentView.getHeight();; i = this.mContentView.getHeight())
    {
      return -i;
      this.mode = 1;
      return 0;
      if (i != 3) {
        break;
      }
    }
    return 0;
  }
  
  public void setDrawerFrameEvent(int paramInt)
  {
    Object localObject = FrameHelperActivity.aq;
    if (localObject != null)
    {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
      if (localObject != null) {
        ((DrawerFrame)localObject).setMiniAppTouchEventInterceptor(paramInt, this);
      }
    }
    else
    {
      QLog.e("ContactsMiniAppEntryManager", 1, "setDrawerFrameEvent. ref=null");
    }
  }
  
  public void showMicroAppPanel(int paramInt)
  {
    this.mContentView.updateMicroAppItemData();
    this.mCurrentTab = paramInt;
    IPullRefreshHeaderControl localIPullRefreshHeaderControl = this.mPullRefreshHeader;
    if ((localIPullRefreshHeaderControl != null) && (((Integer)localIPullRefreshHeaderControl.b(8, this.mContentView)).intValue() < 0))
    {
      this.mPullRefreshHeader.a(9, this.mContentView);
      this.mode = 1;
      this.mContentView.setVisibility(8);
      setDrawerFrameEvent(paramInt);
    }
  }
  
  public void shutdownMiniAppPullDownEntry(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramViewGroup instanceof CommonRefreshLayout)) {
      shutdownMiniAppPullDownEntry((CommonRefreshLayout)paramViewGroup, paramInt);
    }
  }
  
  public void shutdownMiniAppPullDownEntry(CommonRefreshLayout paramCommonRefreshLayout, int paramInt)
  {
    try
    {
      setMicroAppEntryCompleteVisible(false);
      paramCommonRefreshLayout.setShowMiniAppPanel(false);
      paramCommonRefreshLayout.h();
      if (((Integer)this.mPullRefreshHeader.b(8, this.mContentView)).intValue() >= 0)
      {
        this.mPullRefreshHeader.a(10, this.mContentView);
        setRefreshLayoutVisible(true);
        this.mode = 1;
        removeDrawerFrameEvent(paramInt);
        paramCommonRefreshLayout.setMiniAppScrollListener(null);
        return;
      }
    }
    catch (Exception paramCommonRefreshLayout)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shutdownMiniAppPullDownEntry, ");
      localStringBuilder.append(Log.getStackTraceString(paramCommonRefreshLayout));
      QLog.e("ContactsMiniAppEntryManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager
 * JD-Core Version:    0.7.0.1
 */