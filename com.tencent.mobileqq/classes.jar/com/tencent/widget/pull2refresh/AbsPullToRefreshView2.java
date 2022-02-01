package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.widget.pull2refresh.anim.DefaultAnimManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

public abstract class AbsPullToRefreshView2
  extends LinearLayout
  implements Handler.Callback
{
  private static final int CHANGE_STATE_TO_READY = 0;
  private static final int HANDLE_MOV_HEAD_TO = 1;
  private static final int REFRESH_TIME_OUT = 2;
  private static final int RESET_VIEW_POS = 3;
  public static final int STATE_HEADER_REFRESHING = 1;
  public static final int STATE_HEADER_REFRESH_FAILED = 3;
  public static final int STATE_HEADER_REFRESH_SUCCESS = 2;
  public static final int STATE_HEADER_RELEASE_TO_READY = 5;
  public static final int STATE_HEADER_RELEASE_TO_REFRESH = 4;
  public static final int STATE_READY = 0;
  public static final int STATE_RELEASE_TODEFAULT = 6;
  public static final String TAG = "AbsPullToRefreshView2";
  public static final int Y_X_RATIO = 5;
  protected boolean isRefreshing = false;
  private float lastTouchX = -1.0F;
  private float lastTouchY = -1.0F;
  protected IAnimManager mAnimManager;
  private int mAnimSpeed = 10;
  protected View mFooterView;
  private Handler mHandler;
  private Drawable mHeaderBgDrawable;
  private int mHeaderHeight;
  protected View mHeaderView;
  private int mHeaderVisibleHeight;
  private int mMaxVelocity;
  private int mPreFrameHeight;
  private int mState = 0;
  private PullToRefreshListener pullToRefreshListener;
  
  public AbsPullToRefreshView2(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AbsPullToRefreshView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void addViewToHeader(View paramView)
  {
    if (paramView == null) {
      return;
    }
    measureView(paramView);
    this.mHeaderVisibleHeight = configHeaderVisibleHeight();
    this.mHeaderHeight = paramView.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.mHeaderHeight);
    localLayoutParams.topMargin = (-this.mHeaderHeight);
    super.addView(paramView, localLayoutParams);
  }
  
  private void clearAnima()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(3);
  }
  
  private int getHeaderCurPos()
  {
    return ((LinearLayout.LayoutParams)this.mHeaderView.getLayoutParams()).topMargin;
  }
  
  private void init()
  {
    initAnimBaseManager();
    super.setOrientation(1);
    this.mState = 0;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mHeaderView = generateHeaderView();
    this.mFooterView = generateFooterView();
    this.mPreFrameHeight = QQUIDelegate.a(getContext(), 15.0F);
    this.mMaxVelocity = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    addViewToHeader(this.mHeaderView);
    setWillNotDraw(false);
  }
  
  private void log(String paramString)
  {
    Log.d("AbsPullToRefreshView2", paramString);
  }
  
  private void measureView(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(j, i);
  }
  
  private void moveHeaderBy(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("moveHeaderBy dy=");
    ((StringBuilder)localObject).append(paramInt);
    log(((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)this.mHeaderView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin -= paramInt;
    this.mHeaderView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    invalidate();
  }
  
  private void moveHeaderSmoothlyBy(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("moveHeaderSmoothlyBy dy=");
    localStringBuilder.append(paramInt);
    log(localStringBuilder.toString());
    if (Math.abs(paramInt) > this.mPreFrameHeight * 2) {
      return;
    }
    moveHeaderBy(paramInt);
  }
  
  private void moveHeaderTo(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("moveHeaderTo:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",duration=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",getHeaderCurPos()=");
    ((StringBuilder)localObject).append(getHeaderCurPos());
    log(((StringBuilder)localObject).toString());
    if (paramInt1 == getHeaderCurPos()) {
      return;
    }
    this.mHandler.removeMessages(1);
    localObject = this.mHandler;
    ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramInt1, paramInt2));
  }
  
  private void notifyHeaderRefreshStateChange(int paramInt)
  {
    Object localObject = this.pullToRefreshListener;
    if (localObject == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            int i = 100 - Math.abs((int)(getHeaderCurPos() * 1.0F / -this.mHeaderHeight * 100.0F));
            paramInt = i;
            if (i < 0) {
              paramInt = 0;
            }
            if (!this.isRefreshing) {
              this.pullToRefreshListener.onNotCompleteVisable(this.mHeaderView, paramInt);
            }
          }
          else if (!this.isRefreshing)
          {
            ((PullToRefreshListener)localObject).onViewCompleteVisable(this.mHeaderView);
          }
        }
        else
        {
          if (this.isRefreshing)
          {
            ((PullToRefreshListener)localObject).onRefreshCompleted(this.mHeaderView, false);
            localObject = this.mHandler;
            ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 1000L);
          }
          this.isRefreshing = false;
          this.mHandler.removeMessages(2);
        }
      }
      else
      {
        if (this.isRefreshing)
        {
          ((PullToRefreshListener)localObject).onRefreshCompleted(this.mHeaderView, true);
          localObject = this.mHandler;
          ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
        }
        this.isRefreshing = false;
        this.mHandler.removeMessages(2);
      }
    }
    else if (!this.isRefreshing)
    {
      this.isRefreshing = true;
      ((PullToRefreshListener)localObject).onViewCompleteVisableAndReleased(this.mHeaderView);
    }
  }
  
  private void shieldedConflictTouchEvent(boolean paramBoolean)
  {
    clearContentViewClickEvent(paramBoolean);
    getParent().requestDisallowInterceptTouchEvent(true);
  }
  
  private void stopLoadingState(long paramLong)
  {
    if (this.isRefreshing)
    {
      this.pullToRefreshListener.onRefreshCompleted(this.mHeaderView, true);
      Handler localHandler = this.mHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(0), paramLong);
      this.isRefreshing = false;
      this.mHandler.removeMessages(2);
    }
  }
  
  protected void changeToState(int paramInt)
  {
    if ((this.mState == paramInt) && (paramInt != 5)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change to state:");
    localStringBuilder.append(paramInt);
    log(localStringBuilder.toString());
    this.mState = paramInt;
    paramInt = this.mState;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        moveHeaderTo(this.mHeaderVisibleHeight - this.mHeaderHeight, 200);
      }
    }
    else
    {
      moveHeaderTo(-this.mHeaderHeight, 200);
      this.mHandler.removeMessages(2);
    }
    notifyHeaderRefreshStateChange(this.mState);
  }
  
  protected abstract void clearContentViewClickEvent(boolean paramBoolean);
  
  protected int configHeaderVisibleHeight()
  {
    return QQUIDelegate.a(getContext(), 60.0F);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label696;
          }
        }
        else
        {
          float f2 = this.lastTouchX - paramMotionEvent.getX();
          float f1 = this.lastTouchY - paramMotionEvent.getY();
          i = getHeaderCurPos();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dispatchTouchEvent: move getY=");
          ((StringBuilder)localObject).append(paramMotionEvent.getY());
          ((StringBuilder)localObject).append(",isScroll2Top()()=");
          ((StringBuilder)localObject).append(isScroll2Top());
          ((StringBuilder)localObject).append(",mHeaderHeight=");
          ((StringBuilder)localObject).append(this.mHeaderHeight);
          ((StringBuilder)localObject).append(",currentHeaderPos=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",dy=");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(",dx=");
          ((StringBuilder)localObject).append(f2);
          log(((StringBuilder)localObject).toString());
          this.lastTouchX = paramMotionEvent.getX();
          this.lastTouchY = paramMotionEvent.getY();
          if (Math.abs(f1) / Math.abs(f2) < 5.0F)
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            break label696;
          }
          if ((isScroll2Top()) && (f1 < 0.0F))
          {
            moveHeaderSmoothlyBy((int)f1 / 2);
            shieldedConflictTouchEvent(true);
          }
          else
          {
            j = this.mHeaderHeight;
            float f3;
            if (i > -j)
            {
              if (paramMotionEvent.getPointerCount() > 1)
              {
                shieldedConflictTouchEvent(true);
              }
              else if (Math.abs(f1) > 0.0F)
              {
                f3 = i;
                j = this.mHeaderHeight;
                f2 = f1;
                if (f3 - f1 < -j) {
                  f2 = i + j;
                }
                moveHeaderSmoothlyBy((int)f2);
                shieldedConflictTouchEvent(true);
              }
            }
            else if (i < -j)
            {
              if (paramMotionEvent.getPointerCount() > 1)
              {
                shieldedConflictTouchEvent(true);
              }
              else if (Math.abs(f1) > 0.0F)
              {
                f3 = i;
                j = this.mHeaderHeight;
                f2 = f1;
                if (f3 - f1 > -j) {
                  f2 = i + j;
                }
                moveHeaderSmoothlyBy((int)f2);
                shieldedConflictTouchEvent(true);
              }
            }
            else {
              shieldedConflictTouchEvent(false);
            }
          }
          i = getHeaderCurPos();
          int j = this.mHeaderVisibleHeight;
          int k = this.mHeaderHeight;
          if (i > j - k)
          {
            changeToState(4);
            break label696;
          }
          if (i > -k)
          {
            changeToState(5);
            break label696;
          }
          if (i >= -k) {
            break label696;
          }
          changeToState(6);
          break label696;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent: *******up****** mState=");
      ((StringBuilder)localObject).append(this.mState);
      log(((StringBuilder)localObject).toString());
      getParent().requestDisallowInterceptTouchEvent(false);
      this.lastTouchY = -1.0F;
      this.lastTouchX = -1.0F;
      i = this.mState;
      if (i == 4)
      {
        changeToState(1);
      }
      else if (i == 5)
      {
        changeToState(0);
      }
      else if (i == 6)
      {
        changeToState(0);
      }
      else if (getHeaderCurPos() != -this.mHeaderHeight)
      {
        localObject = this.mHandler;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(3));
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent: ------down------ getY=");
      ((StringBuilder)localObject).append(paramMotionEvent.getY());
      log(((StringBuilder)localObject).toString());
      clearAnima();
      this.lastTouchX = paramMotionEvent.getX();
      this.lastTouchY = paramMotionEvent.getY();
    }
    label696:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected abstract View generateFooterView();
  
  protected abstract View generateHeaderView();
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          moveHeaderTo(-this.mHeaderHeight, 100);
          this.mHandler.removeMessages(2);
          return true;
        }
        changeToState(3);
        return true;
      }
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      int m = getHeaderCurPos();
      int k = this.mAnimSpeed;
      m = (i - m) * k / j;
      j -= k;
      if ((j > 0) && ((m != 0) || (getHeaderCurPos() - i <= 0)))
      {
        moveHeaderBy(-m);
        paramMessage = this.mHandler;
        paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1, i, j), this.mAnimSpeed);
        return true;
      }
      moveHeaderBy(getHeaderCurPos() - i);
      return true;
    }
    changeToState(0);
    return true;
  }
  
  protected void initAnimBaseManager()
  {
    setAnimType(new DefaultAnimManager(getContext()));
  }
  
  protected abstract boolean isScroll2Bottom();
  
  protected abstract boolean isScroll2Top();
  
  public void onDestroy()
  {
    IAnimManager localIAnimManager = this.mAnimManager;
    if (localIAnimManager != null)
    {
      localIAnimManager.onDestroy();
      this.mAnimManager = null;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getHeaderCurPos() + this.mHeaderHeight;
    if (i > 0)
    {
      Drawable localDrawable = this.mHeaderBgDrawable;
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, getWidth(), i);
        this.mHeaderBgDrawable.draw(paramCanvas);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void pullRefreshCompleted(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      changeToState(2);
      return;
    }
    changeToState(3);
  }
  
  protected void rebound()
  {
    Handler localHandler;
    if (isScroll2Top())
    {
      this.mHandler.removeMessages(3);
      moveHeaderTo(this.mHeaderVisibleHeight / 2 - this.mHeaderHeight, 100);
      localHandler = this.mHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(3), 100L);
      return;
    }
    if (isScroll2Bottom())
    {
      this.mHandler.removeMessages(3);
      moveHeaderTo(-this.mHeaderHeight - this.mHeaderVisibleHeight, 100);
      localHandler = this.mHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(3), 100L);
    }
  }
  
  public void setAnimType(IAnimManager paramIAnimManager)
  {
    IAnimManager localIAnimManager = this.mAnimManager;
    if ((localIAnimManager != null) && (localIAnimManager.isSkinAnimManager())) {
      this.mAnimManager.onDestroy();
    }
    this.mAnimManager = paramIAnimManager;
  }
  
  public void setPullHeaderBgDrawable(Drawable paramDrawable)
  {
    this.mHeaderBgDrawable = paramDrawable;
  }
  
  protected void setPullToRefreshListener(PullToRefreshListener paramPullToRefreshListener)
  {
    this.pullToRefreshListener = paramPullToRefreshListener;
  }
  
  public void showRefreshResult(boolean paramBoolean, String paramString)
  {
    if ((this.mAnimManager != null) && (this.isRefreshing))
    {
      stopLoadingState(1500L);
      this.mAnimManager.showRefreshResult(paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.AbsPullToRefreshView2
 * JD-Core Version:    0.7.0.1
 */