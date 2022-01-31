package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import aniv;
import ankc;
import aqhj;
import begh;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private ankc jdField_a_of_type_Ankc;
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
    begh localbegh = getOnScrollListener();
    if ((localbegh instanceof aniv)) {
      ((aniv)localbegh).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    begh localbegh = getOnScrollListener();
    if ((localbegh instanceof aniv)) {
      ((aniv)localbegh).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(begh parambegh)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(parambegh instanceof aniv)) && (parambegh != null))
    {
      super.setOnScrollListener(new aniv(this, this.jdField_a_of_type_Ankc, parambegh));
      return;
    }
    super.setOnScrollListener(parambegh);
  }
  
  public void setPullAndFastScrollListener(ankc paramankc)
  {
    this.jdField_a_of_type_Ankc = paramankc;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    begh localbegh = getOnScrollListener();
    if ((!bool) && ((localbegh instanceof aniv)) && (paramInt2 < 0)) {
      ((aniv)localbegh).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */