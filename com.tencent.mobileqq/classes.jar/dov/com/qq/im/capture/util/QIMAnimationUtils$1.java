package dov.com.qq.im.capture.util;

import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.qphone.base.util.QLog;

final class QIMAnimationUtils$1
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QIMAnimationUtils", 2, "heightAnimation value = " + paramInteger);
    }
    paramValueAnimation = this.a.getLayoutParams();
    paramValueAnimation.height = paramInteger.intValue();
    this.a.setLayoutParams(paramValueAnimation);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.QIMAnimationUtils.1
 * JD-Core Version:    0.7.0.1
 */