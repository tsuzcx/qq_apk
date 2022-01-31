package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;

class GLLittleBoyManager$3
  implements Animation.AnimationListener
{
  GLLittleBoyManager$3(GLLittleBoyManager paramGLLittleBoyManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    for (;;)
    {
      if (i < GLLittleBoyManager.access$200(this.this$0).size())
      {
        GLLittleBoy localGLLittleBoy = (GLLittleBoy)GLLittleBoyManager.access$200(this.this$0).get(i);
        if (localGLLittleBoy.getAnimation() == paramAnimation)
        {
          localGLLittleBoy.setFilterPrivateImage(ResourceManager.getInstance().getPostureById(localGLLittleBoy.getDanceData().id).blastPicture, true, true);
          paramAnimation = localGLLittleBoy.getSaveMatchedPointRegion();
          if (GLLittleBoyManager.access$300(this.this$0) == 0.0F) {
            GLLittleBoyManager.access$302(this.this$0, paramAnimation.width() / 2.2F);
          }
          float f1 = paramAnimation.centerX();
          float f2 = paramAnimation.centerY();
          GLLittleBoyManager.access$400(this.this$0).set(f1 - GLLittleBoyManager.access$300(this.this$0), f2 - GLLittleBoyManager.access$300(this.this$0), f1 + GLLittleBoyManager.access$300(this.this$0), f2 + GLLittleBoyManager.access$300(this.this$0));
          localGLLittleBoy.setConvertedImageAndClipRegion(GLLittleBoyManager.access$400(this.this$0));
          localGLLittleBoy.clearAnimation();
          localGLLittleBoy.startAnimation(this.this$0.getBlastAnimation());
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager.3
 * JD-Core Version:    0.7.0.1
 */