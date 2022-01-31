package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import apre;
import apsn;
import assb;
import bhpo;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private apsn jdField_a_of_type_Apsn;
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
    bhpo localbhpo = getOnScrollListener();
    if ((localbhpo instanceof apre)) {
      ((apre)localbhpo).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bhpo localbhpo = getOnScrollListener();
    if ((localbhpo instanceof apre)) {
      ((apre)localbhpo).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(bhpo parambhpo)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(parambhpo instanceof apre)) && (parambhpo != null))
    {
      super.setOnScrollListener(new apre(this, this.jdField_a_of_type_Apsn, parambhpo));
      return;
    }
    super.setOnScrollListener(parambhpo);
  }
  
  public void setPullAndFastScrollListener(apsn paramapsn)
  {
    this.jdField_a_of_type_Apsn = paramapsn;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    bhpo localbhpo = getOnScrollListener();
    if ((!bool) && ((localbhpo instanceof apre)) && (paramInt2 < 0)) {
      ((apre)localbhpo).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */