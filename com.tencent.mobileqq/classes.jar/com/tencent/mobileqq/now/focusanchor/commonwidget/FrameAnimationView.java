package com.tencent.mobileqq.now.focusanchor.commonwidget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FrameAnimationView
  extends ImageView
{
  private int a;
  
  public FrameAnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FrameAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FrameAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    setImageResource(this.a);
    ((AnimationDrawable)getDrawable()).start();
  }
  
  public void b()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)getDrawable();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.stop();
    }
  }
  
  public void setAnimationRes(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView
 * JD-Core Version:    0.7.0.1
 */