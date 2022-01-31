package com.tencent.mobileqq.doutu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter;
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
    if (this.a != null) {
      this.a.a(paramMotionEvent.getAction());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 > 0)
    {
      if (!(a() instanceof DoutuEmotionAdapter)) {
        break label34;
      }
      ((DoutuEmotionAdapter)a()).b();
    }
    for (;;)
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
      label34:
      if ((a() instanceof ZhituPicAdapter)) {
        ((ZhituPicAdapter)a()).b();
      }
    }
  }
  
  public void setTouchListener(DoutuEmotionHorizonListView.HorizonListViewTouchListener paramHorizonListViewTouchListener)
  {
    this.a = paramHorizonListViewTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView
 * JD-Core Version:    0.7.0.1
 */