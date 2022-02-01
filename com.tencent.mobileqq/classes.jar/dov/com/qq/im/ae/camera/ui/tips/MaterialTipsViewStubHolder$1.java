package dov.com.qq.im.ae.camera.ui.tips;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MaterialTipsViewStubHolder$1
  implements Animation.AnimationListener
{
  MaterialTipsViewStubHolder$1(MaterialTipsViewStubHolder paramMaterialTipsViewStubHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (MaterialTipsViewStubHolder.a(this.a) != null)
    {
      MaterialTipsViewStubHolder.a(this.a).clearAnimation();
      MaterialTipsViewStubHolder.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.tips.MaterialTipsViewStubHolder.1
 * JD-Core Version:    0.7.0.1
 */