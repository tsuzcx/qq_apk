package com.tencent.mobileqq.emoticonview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import avop;
import avoq;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.List;

public class EmoticonPanelOnScrollListener
  implements View.OnTouchListener, avoq, AbsListView.OnScrollListener
{
  private static final int PULL_UP_THRESHOLD = 120;
  private static final String TAG = "EmotionPanelListView";
  private float downY;
  private EmotionPanelListView emotionPanelListView;
  boolean isPanelOpen = false;
  private boolean mDisUpdateAlpha;
  private int mLastState = 0;
  private int mLastTop;
  private avop mScrollVelometer = new avop(120, this);
  private int minAlphaLeft;
  private int minAlphaTop;
  private AbsListView.OnScrollListener onScrollListener;
  private int[] point = new int[2];
  private EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener;
  private int spacing;
  
  public EmoticonPanelOnScrollListener(EmotionPanelListView paramEmotionPanelListView, EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.onScrollListener = paramOnScrollListener;
    this.emotionPanelListView = paramEmotionPanelListView;
    this.pullAndFastScrollListener = paramPullAndFastScrollListener;
    this.spacing = ViewUtils.dip2px(5.0F);
    this.mScrollVelometer.b(30);
  }
  
  private boolean isFirstCompletelyVisible(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListView.getChildCount() > 0)
    {
      bool1 = bool2;
      if (paramListView.getFirstVisiblePosition() == 0)
      {
        bool1 = bool2;
        if (paramListView.getChildAt(0) != null)
        {
          bool1 = bool2;
          if (paramListView.getChildAt(0).getTop() >= paramListView.getPaddingTop()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void updateOnScrollStateChanged(int paramInt)
  {
    if (paramInt != this.mLastState)
    {
      if ((this.emotionPanelListView.getChildAt(0) != null) && (paramInt == 0) && (this.mLastState != 1) && (isFirstCompletelyVisible(this.emotionPanelListView)) && (this.pullAndFastScrollListener != null) && (this.emotionPanelListView.getListViewScrollY() < this.mLastTop) && (this.isPanelOpen))
      {
        this.pullAndFastScrollListener.onPullDown();
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelListView", 2, "onScrollStateChanged onPullDown");
        }
      }
      this.mLastState = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelListView", 2, "onScrollStateChanged mLastState :" + this.mLastState);
      }
    }
  }
  
  private void updateSystemSmallEmojiAlpha(AbsListView paramAbsListView, boolean paramBoolean)
  {
    if (paramAbsListView != null)
    {
      int k = paramAbsListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = paramAbsListView.getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = m - 1;
          if (j >= 0)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(m - 1);
            localView2.getLocationOnScreen(this.point);
            this.point[0] = localView2.getLeft();
            if ((paramBoolean) && (this.minAlphaLeft > 0) && (this.point[0] + localView2.getWidth() * 2.0F / 3.0F > this.minAlphaLeft) && (this.minAlphaTop > 0) && (this.point[1] + localView2.getWidth() - this.spacing > this.minAlphaTop)) {
              updateViewAlpha(localView2);
            }
            for (;;)
            {
              j -= 1;
              break;
              localView2.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void updateViewAlpha(View paramView)
  {
    if ((paramView instanceof URLImageView))
    {
      int i = this.point[1] + paramView.getWidth() - this.spacing - this.minAlphaTop;
      float f = paramView.getWidth() / 2.0F;
      if (i < f)
      {
        paramView.setAlpha((f - i) * 1.0F / f);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  public avop getScrollVelometer()
  {
    return this.mScrollVelometer;
  }
  
  public void onCheckSpeed(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.pullAndFastScrollListener != null))
    {
      this.pullAndFastScrollListener.onPullUp();
      this.mScrollVelometer.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListView", 2, "onCheckSpeed overSpeed :" + paramBoolean);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.onScrollListener != null) {
      this.onScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((isFirstCompletelyVisible(this.emotionPanelListView)) && (this.mLastState == 2) && (this.pullAndFastScrollListener != null)) {
      updateOnScrollStateChanged(0);
    }
    updateViewAlpha(paramAbsListView);
    this.mLastTop = this.emotionPanelListView.getListViewScrollY();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.onScrollListener != null) {
      this.onScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    updateOnScrollStateChanged(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.downY = paramMotionEvent.getY();
      this.mScrollVelometer.a(true);
      if (this.pullAndFastScrollListener != null) {
        this.isPanelOpen = this.pullAndFastScrollListener.isPanelOpen();
      }
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (this.isPanelOpen)) {
        if ((isFirstCompletelyVisible(this.emotionPanelListView)) && (this.emotionPanelListView.getListViewScrollY() < this.mLastTop) && (this.pullAndFastScrollListener != null))
        {
          this.pullAndFastScrollListener.onPullDown();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch scroll top pull down");
          }
        }
        else if ((isFirstCompletelyVisible(this.emotionPanelListView)) && (paramMotionEvent.getY() > this.downY) && (this.pullAndFastScrollListener != null))
        {
          this.pullAndFastScrollListener.onPullDown();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch no scroll top pull down");
          }
        }
      }
    }
  }
  
  public void setDisUpdateViewAlpha(boolean paramBoolean)
  {
    this.mDisUpdateAlpha = paramBoolean;
  }
  
  public void updateViewAlpha(AbsListView paramAbsListView)
  {
    if (this.mDisUpdateAlpha) {}
    while ((!(paramAbsListView.getAdapter() instanceof SystemAndEmojiAdapter)) && (!(paramAbsListView.getAdapter() instanceof SmallEmotionDownloadedAdapter))) {
      return;
    }
    if (((this.pullAndFastScrollListener instanceof EmoticonMainPanel)) && (((EmoticonMainPanel)this.pullAndFastScrollListener).getEmoController().pageAdapter != null))
    {
      int i = EmoticonPanelController.sLastSelectedSecondTabIndex;
      List localList = ((EmoticonMainPanel)this.pullAndFastScrollListener).getEmoController().panelDataList;
      EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = ((EmoticonMainPanel)this.pullAndFastScrollListener).getEmoController().pageAdapter;
      if ((i >= 0) && (localList != null) && (i < localList.size()))
      {
        Object localObject2 = localEmotionPanelViewPagerAdapter.getDeleteButtonFromCache(i);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (i - 1 >= 0) {
            localObject1 = localEmotionPanelViewPagerAdapter.getDeleteButtonFromCache(i - 1);
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (i + 1 < localList.size()) {
            localObject2 = localEmotionPanelViewPagerAdapter.getDeleteButtonFromCache(i + 1);
          }
        }
        if ((localObject2 != null) && (((ImageButton)localObject2).getVisibility() == 0))
        {
          localObject1 = new int[2];
          ((ImageButton)localObject2).getLocationOnScreen((int[])localObject1);
          this.minAlphaLeft = ((ImageButton)localObject2).getLeft();
          this.minAlphaTop = localObject1[1];
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      updateSystemSmallEmojiAlpha(paramAbsListView, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener
 * JD-Core Version:    0.7.0.1
 */