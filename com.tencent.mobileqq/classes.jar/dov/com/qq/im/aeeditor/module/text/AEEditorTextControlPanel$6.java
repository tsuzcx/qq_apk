package dov.com.qq.im.aeeditor.module.text;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import bpjt;

public class AEEditorTextControlPanel$6
  implements Runnable
{
  AEEditorTextControlPanel$6(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void run()
  {
    Object localObject = ObjectAnimator.ofFloat(AEEditorTextControlPanel.a(this.this$0), "translationY", new float[] { 150.0F, 0.0F });
    ((ObjectAnimator)localObject).addListener(new bpjt(this));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.setDuration(350L);
    localAnimatorSet.start();
    localObject = AEEditorTextControlPanel.a(this.this$0).a();
    if (((TextView)localObject).getVisibility() == 0) {
      ((TextView)localObject).postDelayed(new AEEditorTextControlPanel.6.2(this, (TextView)localObject), 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.6
 * JD-Core Version:    0.7.0.1
 */