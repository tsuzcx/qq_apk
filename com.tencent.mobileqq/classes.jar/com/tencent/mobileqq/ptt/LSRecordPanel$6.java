package com.tencent.mobileqq.ptt;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class LSRecordPanel$6
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  LSRecordPanel$6(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startCloseAnimation onAnimationEnd");
    }
    if (LSRecordPanel.d(this.a))
    {
      if (paramAnimation == this.a.c) {
        LSRecordPanel.e(this.a);
      }
      paramAnimation = this.a;
      paramAnimation.b = null;
      paramAnimation.c = null;
      paramAnimation = (RelativeLayout.LayoutParams)LSRecordPanel.f(paramAnimation).getLayoutParams();
      int i = (int)(this.a.getResources().getDisplayMetrics().density * 4.0F);
      paramAnimation.height -= i;
      paramAnimation.width -= i;
      paramAnimation.rightMargin += i / 2;
      LSRecordPanel.a(this.a, false);
      LSRecordPanel.f(this.a).setLayoutParams(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.6
 * JD-Core Version:    0.7.0.1
 */