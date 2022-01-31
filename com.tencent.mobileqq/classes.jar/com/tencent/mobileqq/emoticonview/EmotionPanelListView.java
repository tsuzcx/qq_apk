package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import anzj;
import aoaq;
import arbn;
import bfos;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private aoaq jdField_a_of_type_Aoaq;
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
    bfos localbfos = getOnScrollListener();
    if ((localbfos instanceof anzj)) {
      ((anzj)localbfos).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bfos localbfos = getOnScrollListener();
    if ((localbfos instanceof anzj)) {
      ((anzj)localbfos).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(bfos parambfos)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(parambfos instanceof anzj)) && (parambfos != null))
    {
      super.setOnScrollListener(new anzj(this, this.jdField_a_of_type_Aoaq, parambfos));
      return;
    }
    super.setOnScrollListener(parambfos);
  }
  
  public void setPullAndFastScrollListener(aoaq paramaoaq)
  {
    this.jdField_a_of_type_Aoaq = paramaoaq;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    bfos localbfos = getOnScrollListener();
    if ((!bool) && ((localbfos instanceof anzj)) && (paramInt2 < 0)) {
      ((anzj)localbfos).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */