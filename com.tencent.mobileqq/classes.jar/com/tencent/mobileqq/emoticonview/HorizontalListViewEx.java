package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalListViewEx
  extends HorizontalListView
{
  private static LayoutInflater inflater;
  private static List<View> tabCacheViews = Collections.synchronizedList(new ArrayList());
  private int mIndicatorRoundRectX;
  protected int mIndicatorStartX = 0;
  private boolean mIsAnimTabIndicatoring = false;
  private boolean mIsTabAnimateEnable = false;
  private int mOldSelectedAdapterIndex = -1;
  private Paint mRectPaint;
  private RectF mRoundRect;
  private int mScreenWidth;
  private int mTabWidth;
  
  public HorizontalListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTabWidth = AIOUtils.a(51.0F, paramContext.getResources());
    paramAttributeSet = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramAttributeSet);
    this.mScreenWidth = paramAttributeSet.widthPixels;
    initPaint();
  }
  
  private void clearAllSelectedState()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getTag() != null)
      {
        EmoticonTabAdapter.ViewHolder localViewHolder = (EmoticonTabAdapter.ViewHolder)localView.getTag();
        localView.setSelected(false);
        localViewHolder.tabImage.setSelected(false);
      }
      i += 1;
    }
  }
  
  public static View consumeView()
  {
    if ((tabCacheViews != null) && (tabCacheViews.size() > 0)) {
      return (View)tabCacheViews.remove(0);
    }
    return null;
  }
  
  public static void destroyCacheView()
  {
    if (tabCacheViews != null) {
      tabCacheViews.clear();
    }
  }
  
  private void initPaint()
  {
    this.mRectPaint = new Paint();
    this.mRectPaint.setAntiAlias(true);
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectPaint.setColor(getResources().getColor(2131166539));
    this.mRoundRect = new RectF();
    this.mIndicatorRoundRectX = ViewUtils.a(18.0F);
  }
  
  public static void produceTabView(int paramInt)
  {
    int j = 0;
    int i = j;
    if (inflater == null)
    {
      inflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
      i = j;
    }
    for (;;)
    {
      if (i < paramInt) {
        try
        {
          View localView = inflater.inflate(2131559214, null, false);
          if (localView != null) {
            tabCacheViews.add(localView);
          }
          i += 1;
        }
        catch (InflateException localInflateException)
        {
          for (;;)
          {
            Object localObject1 = null;
          }
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("HorizontalListViewEx", 2, "NotFoundException;err info:" + localNotFoundException.getMessage());
            }
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("HorizontalListViewEx", 2, "OutOfMemoryError;err info:" + localOutOfMemoryError.getMessage());
            }
            Object localObject3 = null;
          }
        }
      }
    }
  }
  
  protected void animTabIndicator()
  {
    if ((this.mOldSelectedAdapterIndex != this.mCurrentlySelectedAdapterIndex) && (getChildCount() > 0))
    {
      View localView = getChild(this.mOldSelectedAdapterIndex);
      if (localView != null) {
        this.mIndicatorStartX = localView.getLeft();
      }
      for (;;)
      {
        localView = getSelectedView();
        if (localView == null) {
          break;
        }
        clearAllSelectedState();
        int i = this.mIndicatorStartX;
        int j = localView.getLeft();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
        localValueAnimator.setDuration(200L);
        this.mIsAnimTabIndicatoring = true;
        localValueAnimator.addUpdateListener(new HorizontalListViewEx.2(this, localView, j));
        localValueAnimator.start();
        return;
        if (this.mOldSelectedAdapterIndex < getFirstVisiblePosition()) {
          this.mIndicatorStartX = (-this.mTabWidth);
        } else if (this.mOldSelectedAdapterIndex > getLastVisiblePosition()) {
          this.mIndicatorStartX = (this.mScreenWidth - this.mTabWidth);
        }
      }
    }
    this.mIsAnimTabIndicatoring = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getParent() != null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HorizontalListView", 4, "dispatch touchEvent down");
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1;
    if ((this.mIsTabAnimateEnable) && (this.mIsAnimTabIndicatoring))
    {
      localObject1 = getSelectedView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = ((ViewGroup)localObject1).getChildAt(0);
        if (localObject1 != null) {
          break label50;
        }
      }
    }
    label50:
    int j;
    do
    {
      do
      {
        return;
        localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      } while (localObject1 == null);
      this.mRoundRect.set(this.mIndicatorStartX, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, this.mIndicatorStartX + this.mTabWidth, getMeasuredHeight() - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      paramCanvas.drawRoundRect(this.mRoundRect, this.mIndicatorRoundRectX, this.mIndicatorRoundRectX, this.mRectPaint);
      return;
      j = getChildCount();
    } while (getAdapter() == null);
    paramCanvas = (EmoticonTabAdapter)getAdapter();
    int i = 0;
    label149:
    Object localObject2;
    EmoticonTabAdapter.ViewHolder localViewHolder;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      localObject2 = paramCanvas.getItem(this.mLeftViewAdapterIndex + i);
      if (((View)localObject1).getTag() != null)
      {
        localViewHolder = (EmoticonTabAdapter.ViewHolder)((View)localObject1).getTag();
        if (localObject1 != getSelectedView()) {
          break label240;
        }
        ((View)localObject1).setSelected(true);
        localViewHolder.tabImage.setSelected(true);
        if (localObject2 != null) {
          ((View)localObject1).setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject2).description);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label149;
      break;
      label240:
      ((View)localObject1).setSelected(false);
      localViewHolder.tabImage.setSelected(false);
      if (localObject2 != null) {
        ((View)localObject1).setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject2).description);
      }
    }
  }
  
  public void resetCurrentX(int paramInt)
  {
    int k = this.mTabWidth;
    int j = getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = ViewUtils.a();
    }
    i = paramInt * k - (i - this.mTabWidth);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    this.mCurrentX = paramInt;
  }
  
  public int scrollBy(int paramInt)
  {
    int i = this.mNextX + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.mMaxX) {
      return 1;
    }
    this.mScroller.startScroll(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public void setSelection(int paramInt)
  {
    int j = 0;
    super.setSelection(paramInt);
    if (this.mAdapter == null) {}
    label671:
    label703:
    for (;;)
    {
      return;
      if ((paramInt < this.mAdapter.getCount()) && (paramInt >= 0))
      {
        int k = getFirstVisiblePosition();
        int m = getLastVisiblePosition();
        int n;
        int i;
        if ((paramInt > m) && (m != -1))
        {
          n = (paramInt + 1) * this.mTabWidth;
          j = n - this.mNextX - (this.mScreenWidth - this.mTabWidth - this.mTabWidth);
          i = j;
          if (DEBUG)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + paramInt + ",lastPosition:" + m + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.mScreenWidth);
              i = j;
            }
          }
          if (i == 0) {
            break label671;
          }
          scrollBy(i);
        }
        for (;;)
        {
          if (!this.mIsTabAnimateEnable) {
            break label703;
          }
          animTabIndicator();
          this.mOldSelectedAdapterIndex = this.mCurrentlySelectedAdapterIndex;
          return;
          if ((paramInt < k) && (k != -1))
          {
            n = this.mTabWidth * paramInt;
            j = n - this.mNextX;
            i = j;
            if (!DEBUG) {
              break;
            }
            i = j;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + paramInt + ",firstPosition:" + k + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.mScreenWidth);
            i = j;
            break;
          }
          View localView;
          int[] arrayOfInt;
          if (paramInt == k)
          {
            localView = getChildAt(0);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            i = arrayOfInt[0] - getLeft();
            if ((DEBUG) && (QLog.isDevelopLevel())) {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
            }
            break;
          }
          if (paramInt == m)
          {
            localView = getChildAt(getChildCount() - 1);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            j = arrayOfInt[0] + this.mTabWidth - getRight();
            i = j;
            if (j < 0) {
              i = 0;
            }
            if ((DEBUG) && (QLog.isDevelopLevel())) {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
            }
            break;
          }
          i = j;
          if (!DEBUG) {
            break;
          }
          i = j;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + paramInt + ",mNextX:" + this.mNextX);
          i = j;
          break;
          if ((k == -1) && (m == -1)) {
            ViewCompat.postOnAnimation(this, new HorizontalListViewEx.1(this));
          } else {
            requestLayout();
          }
        }
      }
    }
  }
  
  public void setTabAnimateEnable(boolean paramBoolean)
  {
    this.mIsTabAnimateEnable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx
 * JD-Core Version:    0.7.0.1
 */