package com.tencent.mobileqq.qqgamepub.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;

class QQGameGrayTipsView$1
  implements Runnable
{
  QQGameGrayTipsView$1(QQGameGrayTipsView paramQQGameGrayTipsView) {}
  
  public void run()
  {
    int i = this.this$0.c.getWidth();
    int j = this.this$0.a.getWidth() - UIUtils.a(20.0F, this.this$0.getResources());
    if (i > 0)
    {
      if (j <= 0) {
        return;
      }
      QQGameGrayTipsView.a(this.this$0).setBackgroundDrawable(this.this$0.getContext().getResources().getDrawable(2130840209));
      i = (i - j) / 2;
      j = this.this$0.c.getLeft();
      int k = this.this$0.c.getRight();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(200L);
      localValueAnimator.addUpdateListener(new QQGameGrayTipsView.1.1(this, j, i, k));
      localValueAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView.1
 * JD-Core Version:    0.7.0.1
 */