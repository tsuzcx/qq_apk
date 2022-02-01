package dov.com.qq.im.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEMaterialPanel$6
  implements Animation.AnimationListener
{
  AEMaterialPanel$6(AEMaterialPanel paramAEMaterialPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AEMaterialPanel.a(this.a) != null)
    {
      AEMaterialPanel.a(this.a).setAlpha(1.0F);
      AEMaterialPanel.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.6
 * JD-Core Version:    0.7.0.1
 */