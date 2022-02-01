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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.MobileQQ;

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
    this.mTabWidth = EmotionUtils.a(51.0F, paramContext.getResources());
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
    List localList = tabCacheViews;
    if ((localList != null) && (localList.size() > 0)) {
      return (View)tabCacheViews.remove(0);
    }
    return null;
  }
  
  public static void destroyCacheView()
  {
    List localList = tabCacheViews;
    if (localList != null) {
      localList.clear();
    }
  }
  
  private void initPaint()
  {
    this.mRectPaint = new Paint();
    this.mRectPaint.setAntiAlias(true);
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectPaint.setColor(getResources().getColor(2131166553));
    this.mRoundRect = new RectF();
    this.mIndicatorRoundRectX = ViewUtils.a(18.0F);
  }
  
  public static void produceTabView(int paramInt)
  {
    if (inflater == null) {
      inflater = (LayoutInflater)MobileQQ.getContext().getSystemService("layout_inflater");
    }
    int i = 0;
    while (i < paramInt)
    {
      localObject3 = null;
      try
      {
        try
        {
          localObject1 = inflater.inflate(2131561591, null, false);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("OutOfMemoryError;err info:");
            ((StringBuilder)localObject1).append(localOutOfMemoryError.getMessage());
            QLog.e("HorizontalListViewEx", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject3;
          }
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("NotFoundException;err info:");
            ((StringBuilder)localObject1).append(localNotFoundException.getMessage());
            QLog.e("HorizontalListViewEx", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject3;
          }
        }
      }
      catch (InflateException localInflateException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = localObject3;
        }
      }
      if (localObject1 != null) {
        tabCacheViews.add(localObject1);
      }
      i += 1;
    }
  }
  
  protected void animTabIndicator()
  {
    if ((this.mOldSelectedAdapterIndex != this.mCurrentlySelectedAdapterIndex) && (getChildCount() > 0))
    {
      View localView = getChild(this.mOldSelectedAdapterIndex);
      if (localView != null) {
        this.mIndicatorStartX = localView.getLeft();
      } else if (this.mOldSelectedAdapterIndex < getFirstVisiblePosition()) {
        this.mIndicatorStartX = (-this.mTabWidth);
      } else if (this.mOldSelectedAdapterIndex > getLastVisiblePosition()) {
        this.mIndicatorStartX = (this.mScreenWidth - this.mTabWidth);
      }
      localView = getSelectedView();
      if (localView != null)
      {
        clearAllSelectedState();
        int i = this.mIndicatorStartX;
        int j = localView.getLeft();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
        localValueAnimator.setDuration(200L);
        this.mIsAnimTabIndicatoring = true;
        localValueAnimator.addUpdateListener(new HorizontalListViewEx.2(this, localView, j));
        localValueAnimator.start();
        return;
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1;
    int i;
    if ((this.mIsTabAnimateEnable) && (this.mIsAnimTabIndicatoring))
    {
      localObject1 = getSelectedView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = ((ViewGroup)localObject1).getChildAt(0);
        if (localObject1 == null) {
          return;
        }
        localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
        if (localObject1 == null) {
          return;
        }
        this.mRoundRect.set(this.mIndicatorStartX, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, this.mIndicatorStartX + this.mTabWidth, getMeasuredHeight() - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        localObject1 = this.mRoundRect;
        i = this.mIndicatorRoundRectX;
        paramCanvas.drawRoundRect((RectF)localObject1, i, i, this.mRectPaint);
      }
    }
    else
    {
      int j = getChildCount();
      if (getAdapter() != null)
      {
        paramCanvas = (EmoticonTabAdapter)getAdapter();
        i = 0;
        while (i < j)
        {
          localObject1 = getChildAt(i);
          Object localObject2 = paramCanvas.getItem(this.mLeftViewAdapterIndex + i);
          if (((View)localObject1).getTag() != null)
          {
            EmoticonTabAdapter.ViewHolder localViewHolder = (EmoticonTabAdapter.ViewHolder)((View)localObject1).getTag();
            if (localObject1 == getSelectedView())
            {
              ((View)localObject1).setSelected(true);
              localViewHolder.tabImage.setSelected(true);
              if (localObject2 != null) {
                ((View)localObject1).setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject2).description);
              }
            }
            else
            {
              ((View)localObject1).setSelected(false);
              localViewHolder.tabImage.setSelected(false);
              if (localObject2 != null) {
                ((View)localObject1).setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject2).description);
              }
            }
          }
          i += 1;
        }
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
    super.setSelection(paramInt);
    if (this.mAdapter == null) {
      return;
    }
    if (paramInt < this.mAdapter.getCount())
    {
      if (paramInt < 0) {
        return;
      }
      int k = getFirstVisiblePosition();
      int m = getLastVisiblePosition();
      int n;
      int i;
      int j;
      Object localObject1;
      Object localObject2;
      if ((paramInt > m) && (m != -1))
      {
        n = (paramInt + 1) * this.mTabWidth;
        i = this.mNextX;
        j = this.mScreenWidth;
        int i1 = this.mTabWidth;
        j = n - i - (j - i1 - i1);
        i = j;
        if (DEBUG)
        {
          i = j;
          if (QLog.isDevelopLevel())
          {
            localObject1 = HorizontalListView.class.getSimpleName();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("setSelectionEx: view beyond right screen, position:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(",lastPosition:");
            ((StringBuilder)localObject2).append(m);
            ((StringBuilder)localObject2).append(",tabPosition:");
            ((StringBuilder)localObject2).append(n);
            ((StringBuilder)localObject2).append(",mNextX:");
            ((StringBuilder)localObject2).append(this.mNextX);
            ((StringBuilder)localObject2).append(",deltaX:");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",mScreenWidth");
            ((StringBuilder)localObject2).append(this.mScreenWidth);
            QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
            i = j;
          }
        }
      }
      else if ((paramInt < k) && (k != -1))
      {
        n = this.mTabWidth * paramInt;
        j = n - this.mNextX;
        i = j;
        if (DEBUG)
        {
          i = j;
          if (QLog.isDevelopLevel())
          {
            localObject1 = HorizontalListView.class.getSimpleName();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("setSelectionEx: view beyond l eft screen, position:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(",firstPosition:");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(",tabPosition:");
            ((StringBuilder)localObject2).append(n);
            ((StringBuilder)localObject2).append(",mNextX:");
            ((StringBuilder)localObject2).append(this.mNextX);
            ((StringBuilder)localObject2).append(",deltaX:");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",mScreenWidth");
            ((StringBuilder)localObject2).append(this.mScreenWidth);
            QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
            i = j;
          }
        }
      }
      else
      {
        StringBuilder localStringBuilder;
        if (paramInt == k)
        {
          localObject2 = getChildAt(0);
          localObject1 = new int[2];
          ((View)localObject2).getLocationOnScreen((int[])localObject1);
          j = localObject1[0] - getLeft();
          i = j;
          if (DEBUG)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              localObject2 = HorizontalListView.class.getSimpleName();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("setSelectionEx: view on half left screen, position:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(",location:");
              localStringBuilder.append(localObject1[0]);
              localStringBuilder.append(",mNextX:");
              localStringBuilder.append(this.mNextX);
              localStringBuilder.append(",deltaX:");
              localStringBuilder.append(j);
              QLog.i((String)localObject2, 4, localStringBuilder.toString());
              i = j;
            }
          }
        }
        else if (paramInt == m)
        {
          localObject2 = getChildAt(getChildCount() - 1);
          localObject1 = new int[2];
          ((View)localObject2).getLocationOnScreen((int[])localObject1);
          i = localObject1[0] + this.mTabWidth - getRight();
          j = i;
          if (i < 0) {
            j = 0;
          }
          i = j;
          if (DEBUG)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              localObject2 = HorizontalListView.class.getSimpleName();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("setSelectionEx: view on half right screen, position:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(",location:");
              localStringBuilder.append(localObject1[0]);
              localStringBuilder.append(",mNextX:");
              localStringBuilder.append(this.mNextX);
              localStringBuilder.append(",deltaX:");
              localStringBuilder.append(j);
              QLog.i((String)localObject2, 4, localStringBuilder.toString());
              i = j;
            }
          }
        }
        else
        {
          if ((DEBUG) && (QLog.isDevelopLevel()))
          {
            localObject1 = HorizontalListView.class.getSimpleName();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("setSelectionEx: view inside screen, position:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(",mNextX:");
            ((StringBuilder)localObject2).append(this.mNextX);
            QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
          }
          i = 0;
        }
      }
      if (i != 0) {
        scrollBy(i);
      } else if ((k == -1) && (m == -1)) {
        ViewCompat.postOnAnimation(this, new HorizontalListViewEx.1(this));
      } else {
        requestLayout();
      }
      if (this.mIsTabAnimateEnable)
      {
        animTabIndicator();
        this.mOldSelectedAdapterIndex = this.mCurrentlySelectedAdapterIndex;
      }
    }
  }
  
  public void setTabAnimateEnable(boolean paramBoolean)
  {
    this.mIsTabAnimateEnable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx
 * JD-Core Version:    0.7.0.1
 */