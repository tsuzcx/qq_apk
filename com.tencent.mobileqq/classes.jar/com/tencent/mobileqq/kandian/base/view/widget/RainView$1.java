package com.tencent.mobileqq.kandian.base.view.widget;

import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class RainView$1
  implements Action.OnActionEndListener
{
  RainView$1(RainView paramRainView, Sprite paramSprite) {}
  
  public void a()
  {
    this.b.b(this.a);
    if ((RainView.a(this.b).incrementAndGet() == RainView.a() * RainView.b() * RainView.b(this.b).get()) && (RainView.c(this.b) != null))
    {
      RainView.a(this.b).set(0);
      RainView.b(this.b).set(0);
      RainView.c(this.b).a();
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RainView.1
 * JD-Core Version:    0.7.0.1
 */