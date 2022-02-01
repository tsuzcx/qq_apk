package com.tencent.mobileqq.qqgamepub.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class QQGameGrayTipsView$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QQGameGrayTipsView$1$1(QQGameGrayTipsView.1 param1, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QQGameGrayTipsView.a(this.d.this$0, true);
    float f1 = paramValueAnimator.getAnimatedFraction();
    float f2 = this.a;
    int j = this.b;
    int i = (int)(f2 + j * f1);
    j = (int)(this.c - j * f1);
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("onAnimationUpdate...newLeft:");
      paramValueAnimator.append(i);
      paramValueAnimator.append(",newRight:");
      paramValueAnimator.append(j);
      paramValueAnimator.append(",l:");
      paramValueAnimator.append(this.a);
      paramValueAnimator.append(",r:");
      paramValueAnimator.append(this.c);
      QLog.i("QQGamePub_GameGrayTipsView", 2, paramValueAnimator.toString());
    }
    this.d.this$0.c.layout(i, this.d.this$0.c.getTop(), j, this.d.this$0.c.getBottom());
    if (f1 >= 1.0F)
    {
      QQGameGrayTipsView.a(this.d.this$0, false);
      QQGameGrayTipsView.b(this.d.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView.1.1
 * JD-Core Version:    0.7.0.1
 */