package dov.com.qq.im.ae.camera.ui.aiscene;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import blpb;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

public class VideoStoryAIScenePart$19
  implements Runnable
{
  public VideoStoryAIScenePart$19(blpb paramblpb, AEMaterialPanel paramAEMaterialPanel, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight();
    int j = this.jdField_a_of_type_Int;
    int k = blpb.a(this.this$0).getMeasuredHeight();
    Object localObject = new int[2];
    blpb.a(this.this$0).getLocationInWindow((int[])localObject);
    i = j - i - k - 10 - localObject[1];
    localObject = ObjectAnimator.ofFloat(blpb.a(this.this$0), "translationY", new float[] { 0.0F, i });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(blpb.b(this.this$0), "translationY", new float[] { 0.0F, i });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(blpb.b(this.this$0), "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */