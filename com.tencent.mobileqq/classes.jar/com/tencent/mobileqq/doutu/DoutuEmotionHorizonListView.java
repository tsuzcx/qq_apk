package com.tencent.mobileqq.doutu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.doutu.api.IDoutuEmotionAdapter;
import com.tencent.widget.HorizontalListView;

public class DoutuEmotionHorizonListView
  extends HorizontalListView
{
  private DoutuEmotionHorizonListView.HorizonListViewTouchListener a;
  
  public DoutuEmotionHorizonListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DoutuEmotionHorizonListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    DoutuEmotionHorizonListView.HorizonListViewTouchListener localHorizonListViewTouchListener = this.a;
    if (localHorizonListViewTouchListener != null) {
      localHorizonListViewTouchListener.a(paramMotionEvent.getAction());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt1 > 0) && ((getAdapter() instanceof IDoutuEmotionAdapter))) {
      ((IDoutuEmotionAdapter)getAdapter()).b();
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void setTouchListener(DoutuEmotionHorizonListView.HorizonListViewTouchListener paramHorizonListViewTouchListener)
  {
    this.a = paramHorizonListViewTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView
 * JD-Core Version:    0.7.0.1
 */