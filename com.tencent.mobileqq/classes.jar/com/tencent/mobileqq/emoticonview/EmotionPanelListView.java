package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import asoh;
import aspu;
import avvv;
import blih;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private aspu jdField_a_of_type_Aspu;
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
    blih localblih = getOnScrollListener();
    if ((localblih instanceof asoh)) {
      ((asoh)localblih).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    blih localblih = getOnScrollListener();
    if ((localblih instanceof asoh)) {
      ((asoh)localblih).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(blih paramblih)
  {
    if ((this.jdField_a_of_type_Boolean) && (!(paramblih instanceof asoh)) && (paramblih != null))
    {
      super.setOnScrollListener(new asoh(this, this.jdField_a_of_type_Aspu, paramblih));
      return;
    }
    super.setOnScrollListener(paramblih);
  }
  
  public void setPullAndFastScrollListener(aspu paramaspu)
  {
    this.jdField_a_of_type_Aspu = paramaspu;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    blih localblih = getOnScrollListener();
    if ((!bool) && ((localblih instanceof asoh)) && (paramInt2 < 0)) {
      ((asoh)localblih).a().a(Math.abs(paramInt2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */