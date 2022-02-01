package com.tencent.mobileqq.swipe;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SwipeBackLayout
  extends FrameLayout
{
  protected static final int MSG_FINISH_ACTIVITY = 1;
  private static final String TAG = "SwipeBackLayout";
  public static int WEBVIEW_LEFT_SWIPE_SCOPE;
  protected boolean allowedSliding = false;
  protected int downX;
  protected int downY;
  private boolean isFinish;
  protected volatile boolean isFling;
  private boolean isScrolledRight = false;
  protected boolean isSilding;
  private boolean isStopped = false;
  public int leftSwipeScope;
  private SwipeBackLayout.OnSwipeListener listener;
  private Activity mActivity;
  protected View mContentView;
  protected Context mContext;
  protected boolean mEnableSwipe = true;
  protected GestureDetector mGestureDetector;
  protected final SwipeBackLayout.SwipeLayoutHandler mHandler = new SwipeBackLayout.SwipeLayoutHandler(this);
  protected OnPageSwipeListener mOnPageSwipeListener;
  protected Scroller mScroller;
  protected int mTouchSlop;
  private Animator mTransitionAnim;
  private List<ViewPager> mViewPagers = new LinkedList();
  protected int mViewWidth;
  private boolean readyToSlide = true;
  protected int screenWidth;
  protected int tempX;
  
  public SwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mScroller = new Scroller(paramContext);
    this.screenWidth = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.mGestureDetector = new GestureDetector(paramContext, new SwipeBackLayout.DefaultLayoutGestureDetector(this));
    this.leftSwipeScope = DisplayUtil.a(paramContext, 90.0F);
  }
  
  private void getAllViewPager(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      } else if ((localView instanceof ViewGroup)) {
        getAllViewPager(paramList, (ViewGroup)localView);
      }
      i += 1;
    }
  }
  
  private void setContentView(View paramView)
  {
    this.mContentView = ((View)paramView.getParent());
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    Object localObject = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int i = ((TypedArray)localObject).getResourceId(0, 0);
    ((TypedArray)localObject).recycle();
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    localObject = paramActivity.getChildAt(0);
    if (localObject == null) {
      return;
    }
    ((View)localObject).setBackgroundResource(i);
    paramActivity.removeView((View)localObject);
    addView((View)localObject);
    setContentView((View)localObject);
    paramActivity.addView(this, 0);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      this.mContentView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
      if ((this.mScroller.isFinished()) && (this.isFinish)) {
        scrollRight();
      }
    }
  }
  
  public void disableSwipe()
  {
    this.mEnableSwipe = false;
  }
  
  public void enableSwipe()
  {
    this.mEnableSwipe = true;
  }
  
  protected void fastScrollOrigin()
  {
    try
    {
      int i = this.mContentView.getScrollX();
      this.mScroller.startScroll(i, 0, -i, 0, Math.abs(i) / 2);
      postInvalidate();
      if (this.mOnPageSwipeListener != null) {
        this.mOnPageSwipeListener.b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected ViewPager getTouchViewPager(List<ViewPager> paramList, MotionEvent paramMotionEvent)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      Rect localRect = new Rect();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ViewPager localViewPager = (ViewPager)paramList.next();
        localViewPager.getHitRect(localRect);
        if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          return localViewPager;
        }
      }
    }
    return null;
  }
  
  public void onDestroy() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = getTouchViewPager(this.mViewPagers, paramMotionEvent);
    if ((localObject != null) && (((ViewPager)localObject).getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 2) && (this.allowedSliding) && (this.mEnableSwipe) && ((int)paramMotionEvent.getRawX() - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop)) {
        return true;
      }
    }
    else
    {
      this.allowedSliding = false;
      i = (int)paramMotionEvent.getRawX();
      this.tempX = i;
      this.downX = i;
      this.downY = ((int)paramMotionEvent.getRawY());
      if (this.downX < this.leftSwipeScope) {
        this.allowedSliding = true;
      }
    }
    if (this.mEnableSwipe)
    {
      localObject = this.mGestureDetector;
      if (localObject != null) {
        return ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.mViewWidth = getWidth();
      getAllViewPager(this.mViewPagers, this);
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      Object localObject;
      if (i != 1)
      {
        if ((i == 2) && (this.allowedSliding) && (this.mEnableSwipe))
        {
          i = (int)paramMotionEvent.getRawX();
          int j = this.tempX - i;
          if ((i - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop))
          {
            if (!this.isSilding)
            {
              localObject = this.listener;
              if (localObject != null) {
                ((SwipeBackLayout.OnSwipeListener)localObject).onSwipe(true);
              }
            }
            this.isSilding = true;
          }
          if (this.readyToSlide)
          {
            this.tempX = i;
            if ((i - this.downX > 0) && (this.isSilding))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("moveX:");
                ((StringBuilder)localObject).append(i);
                ((StringBuilder)localObject).append("downX:");
                ((StringBuilder)localObject).append(this.downX);
                ((StringBuilder)localObject).append("deltaX:");
                ((StringBuilder)localObject).append(j);
                QLog.i("SwipeBackLayout", 2, ((StringBuilder)localObject).toString());
              }
              i = j;
              if (this.mContentView.getScrollX() + j > 0) {
                i = -this.mContentView.getScrollX();
              }
              this.mContentView.scrollBy(i, 0);
            }
          }
        }
      }
      else if ((this.allowedSliding) && (this.mEnableSwipe) && (this.readyToSlide))
      {
        this.isSilding = false;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("event.getRawX():");
          ((StringBuilder)localObject).append(paramMotionEvent.getRawX());
          ((StringBuilder)localObject).append("screenWidth:");
          ((StringBuilder)localObject).append(this.screenWidth);
          ((StringBuilder)localObject).append("mViewWidth:");
          ((StringBuilder)localObject).append(this.mViewWidth);
          QLog.i("SwipeBackLayout", 2, ((StringBuilder)localObject).toString());
        }
        if (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2)
        {
          this.isFinish = true;
          if (this.mContentView.getScrollX() != 0) {
            scrollRight();
          }
          localObject = this.listener;
          if (localObject != null) {
            ((SwipeBackLayout.OnSwipeListener)localObject).onSwipe(false);
          }
        }
        else
        {
          postDelayed(new SwipeBackLayout.1(this), 100L);
          this.isFinish = false;
        }
      }
      if (this.mEnableSwipe)
      {
        localObject = this.mGestureDetector;
        if (localObject != null) {
          return ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  protected void scrollOrigin()
  {
    try
    {
      int i = this.mContentView.getScrollX();
      this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -i, 0, Math.abs(i));
      postInvalidate();
      if (this.mOnPageSwipeListener != null) {
        this.mOnPageSwipeListener.b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void scrollRight()
  {
    if (this.isScrolledRight) {
      return;
    }
    this.isScrolledRight = true;
    int i = this.mViewWidth + this.mContentView.getScrollX();
    double d1 = i;
    Double.isNaN(d1);
    double d2 = this.mViewWidth;
    Double.isNaN(d2);
    int j = (int)(d1 * 1.0D / d2 * 700.0D);
    try
    {
      this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -i + 1, 0, Math.abs(j));
      label85:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SwipeBackLayout scrollRight viewwithd=");
        localStringBuilder.append(this.mViewWidth);
        localStringBuilder.append("  startx+ ");
        localStringBuilder.append(this.mContentView.getScrollX());
        localStringBuilder.append("  left width = ");
        localStringBuilder.append(-i);
        localStringBuilder.append("  duration=");
        localStringBuilder.append(j);
        QLog.i("SwipeBackLayout", 2, localStringBuilder.toString());
      }
      this.mHandler.sendEmptyMessageDelayed(1, 200L);
      postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
  }
  
  public void setOnSwipeListener(SwipeBackLayout.OnSwipeListener paramOnSwipeListener)
  {
    this.listener = paramOnSwipeListener;
  }
  
  public void setReadyToSlide(boolean paramBoolean)
  {
    this.readyToSlide = paramBoolean;
  }
  
  public void setTransitionAnim(Animator paramAnimator)
  {
    this.mTransitionAnim = paramAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */