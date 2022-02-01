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
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static Deque<TouchInfo> touchInfoList = new LinkedList();
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
    SwipeBackLayout.Callback localCallback = this.mCallback;
    if (localCallback != null)
    {
      localCallback.onMoveAppBrandToBack();
      resetCaptureViewState();
    }
  }
  
  private void drawScrim(Canvas paramCanvas, View paramView)
  {
    int i = this.mScrimColor;
    int j = (int)(((0xFF000000 & i) >>> 24) * this.mScrimOpacity);
    paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    paramCanvas.drawColor(i & 0xFFFFFF | j << 24);
  }
  
  private void drawShadow(Canvas paramCanvas, View paramView)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    this.mShadowDrawable.setBounds(localRect.left - this.mShadowDrawable.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
    this.mShadowDrawable.draw(paramCanvas);
  }
  
  public static List<TouchInfo> getTouchInfoList()
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
    ViewDragHelper localViewDragHelper = this.mViewDragHelper;
    if ((localViewDragHelper != null) && (localViewDragHelper.continueSettling(true))) {
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
    else if (i == 1)
    {
      long l = SystemClock.uptimeMillis();
      TouchInfo localTouchInfo = new TouchInfo(this.mDownX, this.mDownY, j, k, l - this.mDownTime);
      touchInfoList.offer(localTouchInfo);
      while (touchInfoList.size() > 10) {
        touchInfoList.poll();
      }
      try
      {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateTouchInfoList(new ArrayList(touchInfoList));
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("SwipeBackLayout", "dispatchTouchEvent-updateTouchInfoList-failed", localThrowable);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
    if (!this.mEnable) {
      return false;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    boolean bool2 = true;
    boolean bool1 = true;
    if (k != 0)
    {
      if ((k == 1) || (k != 2)) {}
      int m;
      do
      {
        bool1 = false;
        break;
        k = this.lastX;
        m = this.lastY;
      } while (Math.abs(i - k) <= Math.abs(j - m));
      bool1 = bool2;
    }
    else
    {
      if (Math.abs(i) >= DisplayUtil.getDensity(getContext()) * 30.0F) {
        bool1 = false;
      }
      this.mAllowedSliding = bool1;
    }
    this.lastX = i;
    this.lastY = j;
    if (!bool1) {
      return false;
    }
    ViewDragHelper localViewDragHelper = this.mViewDragHelper;
    if ((localViewDragHelper != null) && (this.mAllowedSliding)) {
      return localViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
    }
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
    Object localObject = this.mPageGuestProxy;
    if ((localObject != null) && (this.mAllowedSliding)) {
      ((PageGestureProxy)localObject).onProcessTouchEvent(paramMotionEvent);
    }
    localObject = this.mViewDragHelper;
    if ((localObject != null) && (this.mAllowedSliding))
    {
      ((ViewDragHelper)localObject).processTouchEvent(paramMotionEvent);
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
    ViewDragHelper localViewDragHelper = this.mViewDragHelper;
    if (localViewDragHelper != null) {
      localViewDragHelper.setScrollDirection(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */