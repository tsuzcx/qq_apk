package com.tencent.mobileqq.gamecenter.web.view;

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
    a();
  }
  
  public UnreadTipLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public UnreadTipLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setBackgroundDrawable(getResources().getDrawable(2130846606));
    setVisibility(4);
  }
  
  public long a()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationX", new float[] { 0.0F, 20.0F, 0.0F });
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.setRepeatCount(5);
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.start();
    long l = localObjectAnimator.getDuration();
    return localObjectAnimator.getRepeatCount() * l;
  }
  
  public void setUnreadNum(int paramInt)
  {
    setText(String.format(getContext().getString(2131697818), new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.UnreadTipLayout
 * JD-Core Version:    0.7.0.1
 */