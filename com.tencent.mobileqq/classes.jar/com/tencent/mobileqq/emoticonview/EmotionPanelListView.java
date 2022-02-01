package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import avop;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  public static final String TAG = "EmotionPanelListView";
  private boolean enableExtendPanle;
  private EmotionPanelListView.PullAndFastScrollListener mPullAndFastScrollListener;
  
  public EmotionPanelListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionPanelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmotionPanelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void abordFling()
  {
    super.abordFling();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.enableExtendPanle) || (paramMotionEvent.getAction() != 0)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    AbsListView.OnScrollListener localOnScrollListener = getOnScrollListener();
    if ((localOnScrollListener instanceof EmoticonPanelOnScrollListener)) {
      ((EmoticonPanelOnScrollListener)localOnScrollListener).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.enableExtendPanle) {
      return super.onTouchEvent(paramMotionEvent);
    }
    AbsListView.OnScrollListener localOnScrollListener = getOnScrollListener();
    if ((localOnScrollListener instanceof EmoticonPanelOnScrollListener)) {
      ((EmoticonPanelOnScrollListener)localOnScrollListener).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.enableExtendPanle = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((this.enableExtendPanle) && (!(paramOnScrollListener instanceof EmoticonPanelOnScrollListener)) && (paramOnScrollListener != null))
    {
      super.setOnScrollListener(new EmoticonPanelOnScrollListener(this, this.mPullAndFastScrollListener, paramOnScrollListener));
      return;
    }
    super.setOnScrollListener(paramOnScrollListener);
  }
  
  public void setPullAndFastScrollListener(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener)
  {
    this.mPullAndFastScrollListener = paramPullAndFastScrollListener;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.enableExtendPanle) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    AbsListView.OnScrollListener localOnScrollListener = getOnScrollListener();
    if ((!bool) && ((localOnScrollListener instanceof EmoticonPanelOnScrollListener)) && (paramInt2 < 0)) {
      ((EmoticonPanelOnScrollListener)localOnScrollListener).getScrollVelometer().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */