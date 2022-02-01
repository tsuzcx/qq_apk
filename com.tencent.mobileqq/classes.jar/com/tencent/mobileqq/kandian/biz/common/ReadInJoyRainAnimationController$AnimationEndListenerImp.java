package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.base.view.widget.RainView.AnimationEndListener;
import java.lang.ref.WeakReference;

class ReadInJoyRainAnimationController$AnimationEndListenerImp
  implements RainView.AnimationEndListener
{
  private WeakReference<ReadInJoyRainAnimationController> a;
  
  public ReadInJoyRainAnimationController$AnimationEndListenerImp(ReadInJoyRainAnimationController paramReadInJoyRainAnimationController)
  {
    this.a = new WeakReference(paramReadInJoyRainAnimationController);
  }
  
  public void a()
  {
    ReadInJoyRainAnimationController localReadInJoyRainAnimationController = (ReadInJoyRainAnimationController)this.a.get();
    if (localReadInJoyRainAnimationController != null)
    {
      if (!localReadInJoyRainAnimationController.b()) {
        return;
      }
      ReadInJoyRainAnimationController.a(localReadInJoyRainAnimationController).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyRainAnimationController.AnimationEndListenerImp
 * JD-Core Version:    0.7.0.1
 */