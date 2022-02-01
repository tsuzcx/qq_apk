package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class SwipeUpAndDragListener$DragHandler$2
  implements OnCompositionLoadedListener
{
  SwipeUpAndDragListener$DragHandler$2(SwipeUpAndDragListener.DragHandler paramDragHandler) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("PhotoListPanel", 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    if (SwipeUpAndDragListener.DragHandler.a(this.a) == null)
    {
      SwipeUpAndDragListener.DragHandler.a(this.a, new LottieDrawable());
      SwipeUpAndDragListener.DragHandler.a(this.a).setComposition(paramLottieComposition);
      SwipeUpAndDragListener.DragHandler.a(this.a).setRepeatCount(-1);
      SwipeUpAndDragListener.DragHandler.a(this.a).setImageDrawable(SwipeUpAndDragListener.DragHandler.a(this.a));
      SwipeUpAndDragListener.DragHandler.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.DragHandler.2
 * JD-Core Version:    0.7.0.1
 */