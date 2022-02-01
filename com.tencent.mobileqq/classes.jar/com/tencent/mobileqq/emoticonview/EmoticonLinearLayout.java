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
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.emoticonview.api.IPanelPopupApi;
import com.tencent.mobileqq.qroute.QRoute;
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
  private IPanelDependListener panelDependListener;
  public int panelViewType = 6;
  List<RelativeLayout> viewCache = new ArrayList();
  
  public EmoticonLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.emoticonTextColor = super.getResources().getColor(2131167263);
    setOrientation(1);
    super.setClickable(true);
    super.setLongClickable(true);
    this.panelDependListener = ((IPanelPopupApi)QRoute.api(IPanelPopupApi.class)).createPanelDependListener();
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
    IPanelDependListener localIPanelDependListener = this.panelDependListener;
    if (localIPanelDependListener != null) {
      localIPanelDependListener.hidePopupWindow(getContext(), this.callback);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          setPressed(false);
          paramMotionEvent = this.mPendingCheckForLongPress;
          if (paramMotionEvent != null) {
            removeCallbacks(paramMotionEvent);
          }
          removeCallbacks(this.mDelete);
          hidePopupWindow();
          this.mPointView = null;
          return true;
        }
        if ((this.mHasPerformedLongPress) && ((!getChildRect(this.mPointView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
        {
          this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
          paramMotionEvent = this.mPointView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (EmoticonInfo)this.mPointView.getTag();
            if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.action)) && (!"add".equals(paramMotionEvent.action)) && (!"setting".equals(paramMotionEvent.action)))
            {
              paramMotionEvent = this.mPointView;
              showPopupEmo(paramMotionEvent, (EmoticonInfo)paramMotionEvent.getTag());
              return true;
            }
          }
          else
          {
            hidePopupWindow();
            return true;
          }
        }
        else if (!this.mHasPerformedLongPress)
        {
          View localView = this.mPointView;
          if ((localView != null) && ((!getChildRect(localView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.mPointView = null;
            return true;
          }
        }
      }
      else
      {
        if (!this.mHasPerformedLongPress)
        {
          paramMotionEvent = this.mPendingCheckForLongPress;
          if (paramMotionEvent != null) {
            removeCallbacks(paramMotionEvent);
          }
        }
        paramMotionEvent = this.mPointView;
        if ((paramMotionEvent != null) && (!this.mHasPerformedLongPress)) {
          performClick(paramMotionEvent);
        }
        hidePopupWindow();
        this.mPointView = null;
        super.removeCallbacks(this.mDelete);
        return true;
      }
    }
    else
    {
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
        if ((paramMotionEvent != null) && (this.callback != null) && ("delete".equals(paramMotionEvent.action))) {
          this.callback.delete();
        }
      }
    }
    return true;
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
    IPanelDependListener localIPanelDependListener = this.panelDependListener;
    if (localIPanelDependListener != null) {
      localIPanelDependListener.showPopupEmo(paramView, paramEmoticonInfo, tmp, getContext(), this.callback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout
 * JD-Core Version:    0.7.0.1
 */