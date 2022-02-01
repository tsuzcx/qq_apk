package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.widget.DragView;

public class DragContainerLayout
  extends DragView
{
  private View.OnLongClickListener a;
  
  public DragContainerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DragContainerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.a;
    if (paramMotionEvent != null) {
      paramMotionEvent.onLongClick(null);
    }
  }
  
  public void setContainerLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a = paramOnLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.DragContainerLayout
 * JD-Core Version:    0.7.0.1
 */