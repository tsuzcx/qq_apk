package dov.com.qq.im.ae.camera.ui.aiscene;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import biku;

public class VideoStoryAIScenePart$19
  implements Runnable
{
  public VideoStoryAIScenePart$19(biku parambiku) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(biku.a(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(biku.b(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(biku.b(this.this$0), "translationY", new float[] { 0.0F });
    Object localObject = new int[2];
    biku.a(this.this$0).getLocationInWindow((int[])localObject);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */