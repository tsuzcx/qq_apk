package dov.com.qq.im.ae.camera.ui.aiscene;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import bkqa;

public class VideoStoryAIScenePart$20
  implements Runnable
{
  public VideoStoryAIScenePart$20(bkqa parambkqa) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(bkqa.a(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(bkqa.b(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(bkqa.b(this.this$0), "translationY", new float[] { 0.0F });
    Object localObject = new int[2];
    bkqa.a(this.this$0).getLocationInWindow((int[])localObject);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.20
 * JD-Core Version:    0.7.0.1
 */