package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RingAvatarView
  extends FrameLayout
{
  public RingAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RingAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RingAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void showNormal()
  {
    setBackgroundDrawable(null);
  }
  
  public void showStarRing()
  {
    setBackgroundDrawable(getContext().getResources().getDrawable(2130851472));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView
 * JD-Core Version:    0.7.0.1
 */