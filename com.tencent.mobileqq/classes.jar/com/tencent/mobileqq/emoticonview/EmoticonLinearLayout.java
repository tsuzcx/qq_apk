package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import java.util.ArrayList;
import java.util.List;

public class EmoticonLinearLayout
  extends LinearLayout
{
  static final String LOG_TAG = "EmoticonLinearLayout";
  private static Rect tmp = new Rect();
  EmoticonCallback callback;
  Context context;
  public int emoticonTextColor;
  EmoticonLinearLayout.EmoticonAdapter mAdapter;
  Runnable mDelete = new EmoticonLinearLayout.2(this);
  boolean mHasPerformedLongPress;
  private EmoticonLinearLayout.CheckForLongPress mPendingCheckForLongPress;
  View mPointView;
  EmoticonLinearLayout.DataObserver observer = new EmoticonLinearLayout.1(this);
  public int panelViewType = 6;
  List<RelativeLayout> viewCache = new ArrayList();
  
  public EmoticonLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.emoticonTextColor = super.getResources().getColor(2131167232);
    setOrientation(1);
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  private View findPointChild(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int j = localLinearLayout.getChildCount() - 1;
        while (j >= 0)
        {
          View localView = localLinearLayout.getChildAt(j);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  private boolean getChildRect(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  private void performClick(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof EmoticonInfo)))
    {
      paramView = (EmoticonInfo)paramView.getTag();
      if (paramView != null)
      {
        super.sendAccessibilityEvent(1);
        super.playSoundEffect(0);
        this.callback.send(paramView);
      }
    }
  }
  
  public void clear()
  {
    this.viewCache.clear();
  }
  
  public EmoticonLinearLayout.EmoticonAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public void hidePopupWindow()
  {
    if (SystemEmotionPanelManager.a().a() != null) {
      SystemEmotionPanelManager.a().a().hidePopupWindow(getContext(), this.callback);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.mHasPerformedLongPress) && (this.mPendingCheckForLongPress != null)) {
        removeCallbacks(this.mPendingCheckForLongPress);
      }
      if ((this.mPointView != null) && (!this.mHasPerformedLongPress)) {
        performClick(this.mPointView);
      }
      hidePopupWindow();
      this.mPointView = null;
      super.removeCallbacks(this.mDelete);
      continue;
      this.mHasPerformedLongPress = false;
      this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.mPointView != null)
      {
        if (this.mPendingCheckForLongPress == null) {
          this.mPendingCheckForLongPress = new EmoticonLinearLayout.CheckForLongPress(this);
        }
        this.mPendingCheckForLongPress.rememberWindowAttachCount();
        postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
        paramMotionEvent = (EmoticonInfo)this.mPointView.getTag();
        if ((paramMotionEvent != null) && (this.callback != null) && ("delete".equals(paramMotionEvent.action)))
        {
          this.callback.delete();
          continue;
          setPressed(false);
          if (this.mPendingCheckForLongPress != null) {
            removeCallbacks(this.mPendingCheckForLongPress);
          }
          removeCallbacks(this.mDelete);
          hidePopupWindow();
          this.mPointView = null;
          continue;
          if ((this.mHasPerformedLongPress) && ((!getChildRect(this.mPointView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
            if ((this.mPointView != null) && (this.mPointView.getTag() != null))
            {
              paramMotionEvent = (EmoticonInfo)this.mPointView.getTag();
              if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.action)) && (!"add".equals(paramMotionEvent.action)) && (!"setting".equals(paramMotionEvent.action))) {
                showPopupEmo(this.mPointView, (EmoticonInfo)this.mPointView.getTag());
              }
            }
            else
            {
              hidePopupWindow();
            }
          }
          else if ((!this.mHasPerformedLongPress) && (this.mPointView != null) && ((!getChildRect(this.mPointView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.mPointView = null;
          }
        }
      }
    }
  }
  
  public void setAdapter(EmoticonLinearLayout.EmoticonAdapter paramEmoticonAdapter)
  {
    this.mAdapter = paramEmoticonAdapter;
    this.mAdapter.setDataSetObserver(this.observer);
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
  }
  
  public void setPanelViewType(int paramInt)
  {
    this.panelViewType = paramInt;
  }
  
  void showPopupEmo(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if (SystemEmotionPanelManager.a().a() != null) {
      SystemEmotionPanelManager.a().a().showPopupEmo(paramView, paramEmoticonInfo, tmp, getContext(), this.callback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout
 * JD-Core Version:    0.7.0.1
 */