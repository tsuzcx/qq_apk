package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import anze;
import aoal;
import arbl;
import bfob;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private aoal jdField_a_of_type_Aoal;
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) || (paramMotionEvent.getAction() != 0)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    bfob localbfob = getOnScrollListener();
    if ((localbfob instanceof anze)) {
      ((anze)localbfob).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bfob localbfob = getOnScrollListener();
    if ((localbfob instanceof anze)) {
      ((anze)localbfob).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(bfob parambfob)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(parambfob instanceof anze)) && (parambfob != null))
    {
      super.setOnScrollListener(new anze(this, this.jdField_a_of_type_Aoal, parambfob));
      return;
    }
    super.setOnScrollListener(parambfob);
  }
  
  public void setPullAndFastScrollListener(aoal paramaoal)
  {
    this.jdField_a_of_type_Aoal = paramaoal;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    bfob localbfob = getOnScrollListener();
    if ((!bool) && ((localbfob instanceof anze)) && (paramInt2 < 0)) {
      ((anze)localbfob).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */