package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class RichTextPanelRecyclerView
  extends RecyclerView
{
  private RichTextPanelScrollListener a;
  
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
    RichTextPanelScrollListener localRichTextPanelScrollListener = this.a;
    if (localRichTextPanelScrollListener != null) {
      localRichTextPanelScrollListener.a(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    RichTextPanelScrollListener localRichTextPanelScrollListener = this.a;
    if (localRichTextPanelScrollListener != null) {
      localRichTextPanelScrollListener.a(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPanelExtendHelper(RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    if (paramRichTextPanelExtendHelper == null) {
      return;
    }
    this.a = new RichTextPanelScrollListener(paramRichTextPanelExtendHelper);
    addOnScrollListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */