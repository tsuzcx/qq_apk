package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import aryt;
import asag;
import avdt;
import bkhe;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private asag jdField_a_of_type_Asag;
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
    bkhe localbkhe = getOnScrollListener();
    if ((localbkhe instanceof aryt)) {
      ((aryt)localbkhe).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bkhe localbkhe = getOnScrollListener();
    if ((localbkhe instanceof aryt)) {
      ((aryt)localbkhe).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(bkhe parambkhe)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(parambkhe instanceof aryt)) && (parambkhe != null))
    {
      super.setOnScrollListener(new aryt(this, this.jdField_a_of_type_Asag, parambkhe));
      return;
    }
    super.setOnScrollListener(parambkhe);
  }
  
  public void setPullAndFastScrollListener(asag paramasag)
  {
    this.jdField_a_of_type_Asag = paramasag;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    bkhe localbkhe = getOnScrollListener();
    if ((!bool) && ((localbkhe instanceof aryt)) && (paramInt2 < 0)) {
      ((aryt)localbkhe).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */