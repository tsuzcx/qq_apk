package com.tencent.mobileqq.lightReply;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.HorizontalListView;

public class LightReplyMenuHorizontalListView
  extends HorizontalListView
{
  private LightReplyMenuHorizontalListView.HorizonListViewTouchListener a;
  
  public LightReplyMenuHorizontalListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LightReplyMenuHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.a(paramMotionEvent.getAction());
    }
    if (paramMotionEvent.getAction() == 2) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setTouchListener(LightReplyMenuHorizontalListView.HorizonListViewTouchListener paramHorizonListViewTouchListener)
  {
    this.a = paramHorizonListViewTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.LightReplyMenuHorizontalListView
 * JD-Core Version:    0.7.0.1
 */