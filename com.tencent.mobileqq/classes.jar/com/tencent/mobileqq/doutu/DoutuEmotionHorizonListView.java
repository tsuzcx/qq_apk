package com.tencent.mobileqq.doutu;

import aizo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import asce;
import asch;
import com.tencent.widget.HorizontalListView;

public class DoutuEmotionHorizonListView
  extends HorizontalListView
{
  private asch a;
  
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
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 > 0)
    {
      if (!(getAdapter() instanceof asce)) {
        break label34;
      }
      ((asce)getAdapter()).b();
    }
    for (;;)
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
      label34:
      if ((getAdapter() instanceof aizo)) {
        ((aizo)getAdapter()).b();
      }
    }
  }
  
  public void setTouchListener(asch paramasch)
  {
    this.a = paramasch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView
 * JD-Core Version:    0.7.0.1
 */