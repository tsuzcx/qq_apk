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
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    if ((RainView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView).incrementAndGet() == RainView.a() * RainView.b() * RainView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView).get()) && (RainView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView) != null))
    {
      RainView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView).set(0);
      RainView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView).set(0);
      RainView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView).a();
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RainView.1
 * JD-Core Version:    0.7.0.1
 */