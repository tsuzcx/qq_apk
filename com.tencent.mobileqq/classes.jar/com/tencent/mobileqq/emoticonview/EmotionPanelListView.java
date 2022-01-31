package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import apvn;
import apww;
import aswk;
import bhtv;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private apww jdField_a_of_type_Apww;
  private boolean jdField_a_of_type_Boolean;
  
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
    if ((!this.jdField_a_of_type_Boolean) || (paramMotionEvent.getAction() != 0)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    bhtv localbhtv = getOnScrollListener();
    if ((localbhtv instanceof apvn)) {
      ((apvn)localbhtv).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bhtv localbhtv = getOnScrollListener();
    if ((localbhtv instanceof apvn)) {
      ((apvn)localbhtv).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(bhtv parambhtv)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(parambhtv instanceof apvn)) && (parambhtv != null))
    {
      super.setOnScrollListener(new apvn(this, this.jdField_a_of_type_Apww, parambhtv));
      return;
    }
    super.setOnScrollListener(parambhtv);
  }
  
  public void setPullAndFastScrollListener(apww paramapww)
  {
    this.jdField_a_of_type_Apww = paramapww;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    bhtv localbhtv = getOnScrollListener();
    if ((!bool) && ((localbhtv instanceof apvn)) && (paramInt2 < 0)) {
      ((apvn)localbhtv).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */