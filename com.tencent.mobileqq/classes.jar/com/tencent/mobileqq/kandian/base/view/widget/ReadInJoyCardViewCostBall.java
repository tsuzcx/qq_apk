package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

public class ReadInJoyCardViewCostBall
  extends TextView
{
  private WindowManager.LayoutParams a;
  private WindowManager b;
  
  public ReadInJoyCardViewCostBall(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCardViewCostBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyCardViewCostBall(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setId(2131438809);
    setBackgroundColor(paramContext.getResources().getColor(2131165580));
    setText("60.00");
    setTextColor(-16711936);
    setGravity(17);
    setOnTouchListener(new ReadInJoyCardViewCostBall.SuspendedBallTouchListener(this, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCardViewCostBall
 * JD-Core Version:    0.7.0.1
 */