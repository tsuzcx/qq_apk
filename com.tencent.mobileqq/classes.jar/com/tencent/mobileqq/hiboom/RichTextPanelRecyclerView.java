package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import avad;
import avag;

public class RichTextPanelRecyclerView
  extends RecyclerView
{
  private avag a;
  
  public RichTextPanelRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextPanelRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextPanelRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.a != null) {
      this.a.a(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.a(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPanelExtendHelper(avad paramavad)
  {
    if (paramavad == null) {
      return;
    }
    this.a = new avag(paramavad);
    addOnScrollListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */