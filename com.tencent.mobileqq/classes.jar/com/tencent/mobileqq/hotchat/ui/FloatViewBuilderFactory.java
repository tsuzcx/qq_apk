package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;

public class FloatViewBuilderFactory
{
  protected BaseFloatViewBuilder a;
  protected BaseFloatViewBuilder b;
  protected BaseFloatViewBuilder c;
  protected Context d;
  
  public FloatViewBuilderFactory(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public BaseFloatViewBuilder a(int paramInt, HeartAnimator paramHeartAnimator)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (this.a == null) {
            this.a = new FloatViewBuilder(this.d, 2130847546, paramHeartAnimator);
          }
          return this.a;
        }
      }
      else
      {
        if (this.c == null) {
          this.c = new PayLikeFloatViewBuilder(this.d, 2130843642, paramHeartAnimator);
        }
        return this.c;
      }
    }
    if (this.b == null) {
      this.b = new FloatViewBuilder(this.d, 2130847550, paramHeartAnimator);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory
 * JD-Core Version:    0.7.0.1
 */