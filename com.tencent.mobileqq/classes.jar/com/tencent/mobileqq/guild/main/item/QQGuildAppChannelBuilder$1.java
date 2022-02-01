package com.tencent.mobileqq.guild.main.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import java.util.List;

class QQGuildAppChannelBuilder$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QQGuildAppChannelBuilder$1(QQGuildAppChannelBuilder paramQQGuildAppChannelBuilder, List paramList1, List paramList2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = 0;
    while (i < this.a.size())
    {
      ((TextView)this.a.get(i)).setAlpha(1.0F - f);
      ((TextView)this.b.get(i)).setAlpha(f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildAppChannelBuilder.1
 * JD-Core Version:    0.7.0.1
 */