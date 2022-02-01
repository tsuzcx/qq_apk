package com.tencent.mobileqq.emoticonview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class EmoticonPanelOnScrollListener
  implements View.OnTouchListener, ScrollVelometer.SpeedListener, AbsListView.OnScrollListener
{
  private static final int PULL_UP_THRESHOLD = 120;
  private static final String TAG = "EmotionPanelListView";
  private float downY = 0.0F;
  private EmotionPanelListView emotionPanelListView;
  boolean isPanelOpen = false;
  private boolean mDisUpdateAlpha = false;
  private int mLastState = 0;
  private int mLastTop = 0;
  private ScrollVelometer mScrollVelometer = new ScrollVelometer(120, this);
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
    this.spacing = ViewUtils.a(5.0F);
    this.mScrollVelometer.setCheckTime(30);
  }
  
  private boolean isFirstCompletelyVisible(ListView paramListView)
  {
    int i = paramListView.getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged mLastState :");
        localStringBuilder.append(this.mLastState);
        QLog.d("EmotionPanelListView", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void updateSystemSmallEmojiAlpha(AbsListView paramAbsListView, boolean paramBoolean)
  {
    if (paramAbsListView != null)
    {
      int m = paramAbsListView.getChildCount();
      int i = 0;
      while (i < m)
      {
        Object localObject = paramAbsListView.getChildAt(i);
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          int k = ((ViewGroup)localObject).getChildCount() - 1;
          int j = k;
          while (j >= 0)
          {
            View localView = ((ViewGroup)localObject).getChildAt(k);
            localView.getLocationOnScreen(this.point);
            this.point[0] = localView.getLeft();
            if ((paramBoolean) && (this.minAlphaLeft > 0) && (this.point[0] + localView.getWidth() * 2.0F / 3.0F > this.minAlphaLeft) && (this.minAlphaTop > 0) && (this.point[1] + localView.getWidth() - this.spacing > this.minAlphaTop)) {
              updateViewAlpha(localView);
            } else {
              localView.setAlpha(1.0F);
            }
            j -= 1;
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
      int i = this.point[1];
      int j = paramView.getWidth();
      int k = this.spacing;
      int m = this.minAlphaTop;
      float f1 = paramView.getWidth() / 2.0F;
      float f2 = i + j - k - m;
      if (f2 < f1)
      {
        paramView.setAlpha((f1 - f2) * 1.0F / f1);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  public ScrollVelometer getScrollVelometer()
  {
    return this.mScrollVelometer;
  }
  
  public void onCheckSpeed(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.pullAndFastScrollListener;
      if (localObject != null)
      {
        ((EmotionPanelListView.PullAndFastScrollListener)localObject).onPullUp();
        this.mScrollVelometer.switchOn(false);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckSpeed overSpeed :");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("EmotionPanelListView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.onScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((isFirstCompletelyVisible(this.emotionPanelListView)) && (this.mLastState == 2) && (this.pullAndFastScrollListener != null)) {
      updateOnScrollStateChanged(0);
    }
    updateViewAlpha(paramAbsListView);
    this.mLastTop = this.emotionPanelListView.getListViewScrollY();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.onScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    updateOnScrollStateChanged(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.downY = paramMotionEvent.getY();
      this.mScrollVelometer.switchOn(true);
      paramView = this.pullAndFastScrollListener;
      if (paramView != null) {
        this.isPanelOpen = paramView.isPanelOpen();
      }
    }
    else if ((i == 1) && (this.isPanelOpen))
    {
      if ((isFirstCompletelyVisible(this.emotionPanelListView)) && (this.emotionPanelListView.getListViewScrollY() < this.mLastTop))
      {
        paramView = this.pullAndFastScrollListener;
        if (paramView != null)
        {
          paramView.onPullDown();
          if (!QLog.isColorLevel()) {
            break label168;
          }
          QLog.d("EmotionPanelListView", 2, "onTouch scroll top pull down");
          break label168;
        }
      }
      if ((isFirstCompletelyVisible(this.emotionPanelListView)) && (paramMotionEvent.getY() > this.downY))
      {
        paramView = this.pullAndFastScrollListener;
        if (paramView != null)
        {
          paramView.onPullDown();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelListView", 2, "onTouch no scroll top pull down");
          }
        }
      }
    }
    label168:
    return false;
  }
  
  public void setDisUpdateViewAlpha(boolean paramBoolean)
  {
    this.mDisUpdateAlpha = paramBoolean;
  }
  
  public void updateViewAlpha(AbsListView paramAbsListView)
  {
    if (this.mDisUpdateAlpha) {
      return;
    }
    if (((paramAbsListView.getAdapter() instanceof SystemAndEmojiAdapter)) || (((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).isSmallEmotionDownloadedAdapter(paramAbsListView.getAdapter())))
    {
      boolean bool2 = false;
      ImageButton localImageButton = ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getDeleteImageBtn(this.pullAndFastScrollListener);
      boolean bool1 = bool2;
      if (localImageButton != null)
      {
        bool1 = bool2;
        if (localImageButton.getVisibility() == 0)
        {
          int[] arrayOfInt = new int[2];
          localImageButton.getLocationOnScreen(arrayOfInt);
          this.minAlphaLeft = localImageButton.getLeft();
          this.minAlphaTop = arrayOfInt[1];
          bool1 = true;
        }
      }
      updateSystemSmallEmojiAlpha(paramAbsListView, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener
 * JD-Core Version:    0.7.0.1
 */