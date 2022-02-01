package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
  private static final int OFFSET_NODE_OPEN = ViewUtils.a(-50.0F);
  private static final int OFFSET_NODE_SCROLL = ViewUtils.a(-50.0F);
  private static final int OFFSET_NODE_SCROLL_FAST = ViewUtils.a(-100.0F);
  private static final float SPEED_2 = 1.5F;
  private static final int STORY_TRANSLATE = ViewUtils.a(-70.0F);
  public static final String TAG = "ContactsMiniAppEntryManager";
  public static long sScrollTimestamp = 0L;
  private int OFFSET_SCROLL_OVER;
  boolean flag = false;
  private QQAppInterface mApp;
  private MiniAppEntryLayout mContentView;
  private Context mContext;
  private int mCurrentTab = -1;
  private ViewGroup mMiniAppListLayout;
  private RelativeLayout mPullRefreshHeader;
  private int mode = 1;
  private int preMode = 1;
  
  public ContactsMiniAppEntryManager(Context paramContext, QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout, int paramInt)
  {
    this.mContext = paramContext;
    this.mPullRefreshHeader = paramRelativeLayout;
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
    float f1;
    if ((paramFloat <= OFFSET_NODE_SCROLL) && (paramFloat > this.OFFSET_SCROLL_OVER)) {
      if (paramFloat <= OFFSET_NODE_SCROLL_FAST)
      {
        f1 = (OFFSET_NODE_SCROLL_FAST - paramFloat) / (OFFSET_NODE_SCROLL_FAST - this.OFFSET_SCROLL_OVER);
        float f2 = STORY_TRANSLATE + (OFFSET_NODE_SCROLL - OFFSET_NODE_SCROLL_FAST);
        f1 = f2 - f1 * f2 * 1.5F;
        f2 = this.mMiniAppListLayout.getTranslationY();
        this.mMiniAppListLayout.setTranslationY(f1);
        if (this.mMiniAppListLayout.getTranslationY() < STORY_TRANSLATE) {
          this.mMiniAppListLayout.setTranslationY(STORY_TRANSLATE);
        }
        if (this.mMiniAppListLayout.getTranslationY() > 0.0F) {
          this.mMiniAppListLayout.setTranslationY(0.0F);
        }
        f1 = this.mMiniAppListLayout.getTranslationY() - f2;
        setMicroAppEntryPanelAlpha(1.0F - this.mMiniAppListLayout.getTranslationY() / STORY_TRANSLATE + 0.8F);
      }
    }
    for (;;)
    {
      if (paramFloat <= ViewUtils.b(-70.0F)) {
        break label299;
      }
      this.mContentView.setDotViewTranslationY((this.mContentView.getDotViewHeight() + paramFloat) / 2.0F);
      return;
      f1 = STORY_TRANSLATE + (OFFSET_NODE_SCROLL - paramFloat);
      break;
      if ((paramFloat <= this.OFFSET_SCROLL_OVER) && (this.OFFSET_SCROLL_OVER != 0)) {
        setMicroAppEntryCompleteVisible(true);
      }
      f1 = 0.0F;
    }
    label299:
    this.mContentView.setDotViewTranslationY(f1 + this.mContentView.getDotViewTranslationY());
  }
  
  private void onNodeScrollOut()
  {
    sScrollTimestamp = SystemClock.uptimeMillis();
  }
  
  private void removeDrawerFrameEvent(int paramInt)
  {
    Object localObject = FrameHelperActivity.a;
    if (localObject != null)
    {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
      if (localObject != null) {
        ((DrawerFrame)localObject).a(paramInt);
      }
      return;
    }
    QLog.e("ContactsMiniAppEntryManager", 1, "removeDrawerFrameEvent. ref=null");
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
    do
    {
      return;
      if (this.mMiniAppListLayout.getTranslationY() != STORY_TRANSLATE) {
        this.mMiniAppListLayout.setTranslationY(STORY_TRANSLATE);
      }
    } while (this.mMiniAppListLayout.getAlpha() == 0.0F);
    setMicroAppEntryPanelAlpha(0.0F);
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    if (this.mMiniAppListLayout != null) {
      this.mMiniAppListLayout.setAlpha(paramFloat);
    }
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mPullRefreshHeader.findViewById(2131376848);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
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
    if (this.mContentView != null) {
      this.mContentView.updateMicroAppItemData();
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label524:
    for (;;)
    {
      return;
      if (this.mode == 1)
      {
        this.flag = true;
        setMicroAppEntryCompleteVisible(false);
        this.mContentView.resetDotViewStatus();
        return;
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
        if (paramInt < 0)
        {
          QLog.d("ContactsMiniAppEntryManager", 2, "fight...onTouchMoving.onMove..scrollY = " + paramInt);
          return;
          this.flag = false;
          this.preMode = this.mode;
          if (paramInt >= 0)
          {
            this.mode = 1;
            paramCommonRefreshLayout.setShowMiniAppPanel(false);
            setRefreshLayoutVisible(paramCommonRefreshLayout.c());
            if ((this.preMode == 1) && (this.mode == 3))
            {
              this.mContentView.recordExposureItem();
              if (this.mCurrentTab != FrameControllerUtil.c) {
                break label504;
              }
              MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_contact");
            }
          }
          for (;;)
          {
            if ((this.preMode != 3) || (this.mode != 1)) {
              break label524;
            }
            MiniAppEntryLayout.exposureReport();
            return;
            if (paramCommonRefreshLayout.c())
            {
              if (paramInt <= -paramCommonRefreshLayout.a())
              {
                paramMotionEvent = (TextView)this.mPullRefreshHeader.findViewById(2131376853);
                if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(HardCodeUtil.a(2131702614)))) {}
                for (this.mode = 3;; this.mode = 2)
                {
                  paramCommonRefreshLayout.setShowMiniAppPanel(true);
                  break;
                  QLog.d("ContactsMiniAppEntryManager", 2, "story node start refresh onTouchMoving");
                }
              }
              if (paramInt <= -this.mContentView.getHeight())
              {
                this.mode = 3;
                paramCommonRefreshLayout.setShowMiniAppPanel(true);
                break;
              }
              this.mode = 1;
              paramCommonRefreshLayout.setShowMiniAppPanel(false);
              break;
            }
            if (paramInt <= -this.mContentView.getHeight())
            {
              if (this.mode == 2) {
                break;
              }
              this.mode = 3;
              paramCommonRefreshLayout.setShowMiniAppPanel(true);
              onNodeScrollOut();
              break;
            }
            if (paramInt <= OFFSET_NODE_OPEN)
            {
              if (this.mode == 2)
              {
                setMicroAppEntryCompleteVisible(false);
                break;
              }
              this.mode = 3;
              paramCommonRefreshLayout.setShowMiniAppPanel(true);
              onNodeScrollOut();
              break;
            }
            this.mode = 1;
            paramCommonRefreshLayout.setShowMiniAppPanel(false);
            break;
            label504:
            if (this.mCurrentTab == FrameControllerUtil.d) {
              MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_more");
            }
          }
        }
      }
    }
  }
  
  public int onViewCompleteAfterRefresh(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ContactsMiniAppEntryManager", 2, "onViewCompleteAfterRefresh, mode:" + this.mode + ", showMiniApp: " + paramBoolean);
    }
    this.mContentView.updateMicroAppItemData();
    if (this.mode == 2) {
      if (paramBoolean)
      {
        this.mode = 3;
        i = -this.mContentView.getHeight();
      }
    }
    while (this.mode != 3)
    {
      return i;
      this.mode = 1;
      return 0;
    }
    return -this.mContentView.getHeight();
  }
  
  public void setDrawerFrameEvent(int paramInt)
  {
    Object localObject = FrameHelperActivity.a;
    if (localObject != null)
    {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
      if (localObject != null) {
        ((DrawerFrame)localObject).setMiniAppTouchEventInterceptor(paramInt, this);
      }
      return;
    }
    QLog.e("ContactsMiniAppEntryManager", 1, "setDrawerFrameEvent. ref=null");
  }
  
  public void showMicroAppPanel(int paramInt)
  {
    this.mContentView.updateMicroAppItemData();
    this.mCurrentTab = paramInt;
    if ((this.mPullRefreshHeader != null) && (this.mPullRefreshHeader.indexOfChild(this.mContentView) < 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(3, 2131376848);
      this.mPullRefreshHeader.addView(this.mContentView, localLayoutParams);
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
      paramCommonRefreshLayout.e();
      if (this.mPullRefreshHeader.indexOfChild(this.mContentView) >= 0)
      {
        this.mPullRefreshHeader.removeView(this.mContentView);
        setRefreshLayoutVisible(true);
        this.mode = 1;
        removeDrawerFrameEvent(paramInt);
        paramCommonRefreshLayout.setMiniAppScrollListener(null);
      }
      return;
    }
    catch (Exception paramCommonRefreshLayout)
    {
      QLog.e("ContactsMiniAppEntryManager", 1, "shutdownMiniAppPullDownEntry, " + Log.getStackTraceString(paramCommonRefreshLayout));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager
 * JD-Core Version:    0.7.0.1
 */