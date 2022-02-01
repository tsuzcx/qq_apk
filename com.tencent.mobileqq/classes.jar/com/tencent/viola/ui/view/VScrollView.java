package com.tencent.viola.ui.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import com.tencent.viola.ui.component.VScroller;
import com.tencent.viola.ui.view.refresh.VRefreshContentView.ContentViewProvider;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import java.lang.ref.WeakReference;

public class VScrollView
  extends ScrollView
  implements IVView<VScroller>, VRefreshContentView.ContentViewProvider<VScrollView>
{
  public static final String TAG = "XScrollView";
  private boolean inTouch = false;
  private float lastY;
  private boolean mIsLoadMoring = false;
  private int mLastX = 0;
  private int mLastY = 0;
  private int mMinOffset = 5;
  private int mPreloadDistance = 200;
  private Runnable mRunnable = new VScrollView.1(this);
  private VScrollView.OnScrollListener mScrollListener;
  private VScrollView.VScrollViewListener mScrollViewListeners;
  private int mTouchSlop;
  private WeakReference<VScroller> mWeakReference;
  private VScrollView.OnScrollListener onScrollListener;
  
  public VScrollView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public VScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private boolean isBottom()
  {
    return getScrollY() + getHeight() >= computeVerticalScrollRange();
  }
  
  private void onLoadMore(int paramInt1, int paramInt2)
  {
    this.mIsLoadMoring = true;
    this.mScrollViewListeners.onLoadMore(this, paramInt1, paramInt2);
  }
  
  private void onScroll(int paramInt1, int paramInt2)
  {
    this.mScrollViewListeners.onScroll(this, paramInt1, paramInt2);
  }
  
  private void onScrollEnd()
  {
    VScrollView.VScrollViewListener localVScrollViewListener = this.mScrollViewListeners;
    int i = this.mLastX;
    float f = i;
    int j = this.mLastY;
    localVScrollViewListener.onScrollEnd(this, f, j, i, j);
  }
  
  public void addParentTouchLifeCycle(VRefreshViewGroup paramVRefreshViewGroup)
  {
    if (paramVRefreshViewGroup == null) {
      return;
    }
    paramVRefreshViewGroup.addTouchLifeCycle(new VScrollView.2(this));
  }
  
  public void addScrollViewListener(VScrollView.VScrollViewListener paramVScrollViewListener)
  {
    this.mScrollViewListeners = paramVScrollViewListener;
  }
  
  public void bindComponent(VScroller paramVScroller)
  {
    this.mWeakReference = new WeakReference(paramVScroller);
  }
  
  public boolean canChildPullDown()
  {
    return (ViewCompat.canScrollVertically(this, -1)) || (getScrollY() > 0);
  }
  
  public boolean canChildPullUp()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null) {
      if (!ViewCompat.canScrollVertically(this, 1))
      {
        bool1 = bool2;
        if (getScrollY() >= localView.getHeight() - getHeight()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public VScroller getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VScroller)localWeakReference.get();
    }
    return null;
  }
  
  public VScrollView getContentView()
  {
    return this;
  }
  
  public void loadMoreFinish(Boolean paramBoolean)
  {
    this.mIsLoadMoring = paramBoolean.booleanValue();
  }
  
  public void onHeaderRebounded() {}
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    onScroll(getScrollX(), getScrollY());
    Object localObject = getChildAt(getChildCount() - 1);
    if (localObject == null) {
      return;
    }
    if ((((View)localObject).getBottom() - (getHeight() + getScrollY()) <= this.mPreloadDistance) && (!this.mIsLoadMoring)) {
      onLoadMore(paramInt1, paramInt2);
    }
    localObject = this.onScrollListener;
    if (localObject == null) {
      return;
    }
    if (this.inTouch)
    {
      if (paramInt2 != paramInt4)
      {
        ((VScrollView.OnScrollListener)localObject).onScrollStateChanged(this, 1, isBottom());
        localObject = this.mScrollListener;
        if (localObject != null) {
          ((VScrollView.OnScrollListener)localObject).onScrollStateChanged(this, 1, isBottom());
        }
      }
    }
    else if (paramInt2 != paramInt4)
    {
      ((VScrollView.OnScrollListener)localObject).onScrollStateChanged(this, 2, isBottom());
      localObject = this.mScrollListener;
      if (localObject != null) {
        ((VScrollView.OnScrollListener)localObject).onScrollStateChanged(this, 2, isBottom());
      }
      this.mLastY = paramInt2;
      this.mLastX = paramInt1;
      removeCallbacks(this.mRunnable);
      postDelayed(this.mRunnable, 20L);
    }
    this.onScrollListener.onScroll(getScrollX(), getScrollY());
    localObject = this.mScrollListener;
    if (localObject != null) {
      ((VScrollView.OnScrollListener)localObject).onScroll(getScrollX(), getScrollY());
    }
  }
  
  public void scrollToTop(boolean paramBoolean)
  {
    fullScroll(33);
  }
  
  public void setMinOffset(int paramInt)
  {
    this.mMinOffset = paramInt;
  }
  
  public void setOnScrollListener(VScrollView.OnScrollListener paramOnScrollListener)
  {
    this.onScrollListener = paramOnScrollListener;
  }
  
  public void setPreloadDistance(int paramInt)
  {
    this.mPreloadDistance = paramInt;
  }
  
  public void setShowScrollerIndicator(boolean paramBoolean)
  {
    setVerticalScrollBarEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VScrollView
 * JD-Core Version:    0.7.0.1
 */