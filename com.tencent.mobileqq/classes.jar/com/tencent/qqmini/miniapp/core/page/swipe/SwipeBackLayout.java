package com.tencent.qqmini.miniapp.core.page.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqmini.miniapp.R.drawable;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static Deque<SwipeBackLayout.TouchInfo> touchInfoList = new LinkedList();
  private int lastX;
  private int lastY;
  private boolean mAllowedSliding = false;
  private SwipeBackLayout.Callback mCallback;
  private View mCapturedView;
  private View mChildView;
  private int mContentHeight;
  protected View mContentView;
  private int mContentWidth;
  private long mDownTime;
  private int mDownX;
  private int mDownY;
  private boolean mEnable = true;
  private volatile boolean mIsClose;
  private int mLeftMoveDistance;
  protected PageGestureProxy mPageGuestProxy;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private float mScrollPercent;
  private Drawable mShadowDrawable;
  private int mTouchSlop;
  private ViewDragHelper mViewDragHelper;
  
  public SwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void bringToBackground()
  {
    if (this.mCallback != null)
    {
      this.mCallback.onMoveAppBrandToBack();
      resetCaptureViewState();
    }
  }
  
  private void drawScrim(Canvas paramCanvas, View paramView)
  {
    int i = (int)(((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
    int j = this.mScrimColor;
    paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
  }
  
  private void drawShadow(Canvas paramCanvas, View paramView)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    this.mShadowDrawable.setBounds(localRect.left - this.mShadowDrawable.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
    this.mShadowDrawable.draw(paramCanvas);
  }
  
  public static List<SwipeBackLayout.TouchInfo> getTouchInfoList()
  {
    return new ArrayList(touchInfoList);
  }
  
  private void handleViewReleased(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getRawX() > this.mContentWidth / 2)
    {
      bringToBackground();
      this.mIsClose = true;
      return;
    }
    this.mViewDragHelper.settleCapturedViewAt(0, 0);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.mScrimOpacity = (1.0F - this.mScrollPercent);
    if ((this.mViewDragHelper != null) && (this.mViewDragHelper.continueSettling(true))) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      this.mDownTime = SystemClock.uptimeMillis();
      this.mDownX = j;
      this.mDownY = k;
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (i == 1)
      {
        long l = SystemClock.uptimeMillis();
        SwipeBackLayout.TouchInfo localTouchInfo = new SwipeBackLayout.TouchInfo(this.mDownX, this.mDownY, j, k, l - this.mDownTime);
        touchInfoList.offer(localTouchInfo);
        while (touchInfoList.size() > 10) {
          touchInfoList.poll();
        }
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void init()
  {
    ThreadManager.getUIHandler().post(new SwipeBackLayout.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() == 1)
    {
      this.mChildView = getChildAt(0);
      return;
    }
    throw new IllegalStateException("SwipeBackLayout can host only one direct child");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!this.mEnable) {
      return false;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      this.lastX = i;
      this.lastY = j;
      if (!bool1) {
        break;
      }
      if ((this.mViewDragHelper == null) || (!this.mAllowedSliding)) {
        break label181;
      }
      return this.mViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
      if (Math.abs(i) < DisplayUtil.getDensity(getContext()) * 30.0F) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.mAllowedSliding = bool1;
        break;
      }
      int k = this.lastX;
      int m = this.lastY;
      if (Math.abs(i - k) <= Math.abs(j - m))
      {
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
    label181:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mContentWidth = this.mContentView.getMeasuredWidth();
    this.mContentHeight = this.mChildView.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return false;
    }
    if ((this.mPageGuestProxy != null) && (this.mAllowedSliding)) {
      this.mPageGuestProxy.onProcessTouchEvent(paramMotionEvent);
    }
    if ((this.mViewDragHelper != null) && (this.mAllowedSliding))
    {
      this.mViewDragHelper.processTouchEvent(paramMotionEvent);
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetCaptureViewState()
  {
    ThreadManager.getUIHandler().postDelayed(new SwipeBackLayout.3(this), 200L);
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public void setScrollDirection(int paramInt)
  {
    if (this.mViewDragHelper != null) {
      this.mViewDragHelper.setScrollDirection(paramInt);
    }
  }
  
  public void setSwipeBackCallback(SwipeBackLayout.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setSwipeBackEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  protected void setViewDragHelper(ViewGroup paramViewGroup, View paramView)
  {
    this.mChildView = paramView;
    this.mViewDragHelper = ViewDragHelper.create(paramViewGroup, 1.0F, new SwipeBackLayout.2(this));
    this.mViewDragHelper.setEdgeTrackingEnabled(1);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mShadowDrawable = getResources().getDrawable(R.drawable.mini_sdk_swipe_shadow_left);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */