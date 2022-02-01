package com.tencent.mobileqq.text;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;

public class ClickableImageSpan
  extends OffsetableImageSpan
{
  private static final int[] statePressed = { 16842919 };
  private boolean beEnable = true;
  private ClickableImageSpan.ClickableImageSpanListener mClickListener;
  private Drawable mDrawable;
  
  public ClickableImageSpan(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    super(null, 0);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(statePressed, paramDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, paramDrawable1);
    this.mDrawable = localStateListDrawable;
    this.mDrawable.setBounds(0, 0, paramDrawable2.getBounds().right, paramDrawable2.getBounds().bottom);
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public boolean isEnable()
  {
    return this.beEnable;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.beEnable) {}
    int i;
    do
    {
      return false;
      i = paramMotionEvent.getAction();
    } while (i == 2);
    if (i == 0) {
      this.mDrawable.setState(statePressed);
    }
    for (;;)
    {
      if ((i == 1) && (this.mClickListener != null)) {
        this.mClickListener.onClick(this);
      }
      paramView.invalidate();
      return true;
      this.mDrawable.setState(StateSet.WILD_CARD);
    }
  }
  
  public void setClickListener(ClickableImageSpan.ClickableImageSpanListener paramClickableImageSpanListener)
  {
    this.mClickListener = paramClickableImageSpanListener;
  }
  
  public void setDisselected(View paramView)
  {
    this.mDrawable.setState(StateSet.WILD_CARD);
    paramView.invalidate();
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.beEnable = paramBoolean;
  }
  
  public void setSelected(View paramView)
  {
    this.mDrawable.setState(statePressed);
    paramView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.ClickableImageSpan
 * JD-Core Version:    0.7.0.1
 */