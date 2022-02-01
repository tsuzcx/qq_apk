package com.tencent.mobileqq.qqgamepub.web.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

@SuppressLint({"AppCompatCustomView"})
public class UnreadTipLayout
  extends TextView
{
  public UnreadTipLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public UnreadTipLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public UnreadTipLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setBackgroundDrawable(getResources().getDrawable(2130847959));
    setVisibility(4);
  }
  
  public long a()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationX", new float[] { 0.0F, 20.0F, 0.0F });
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.setRepeatCount(5);
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.start();
    return localObjectAnimator.getDuration() * localObjectAnimator.getRepeatCount();
  }
  
  public void setUnreadNum(int paramInt)
  {
    setText(String.format(getContext().getString(2131893009), new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout
 * JD-Core Version:    0.7.0.1
 */