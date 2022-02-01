package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.widget.FrameLayout;
import bhbt;

public class PhantomPicView$1
  implements Runnable
{
  PhantomPicView$1(PhantomPicView paramPhantomPicView) {}
  
  public void run()
  {
    this.this$0.b.setVisibility(0);
    Object localObject4 = new Keyframe[3];
    localObject4[0] = Keyframe.ofFloat(0.0F, 1.0F);
    localObject4[1] = Keyframe.ofFloat(0.33F, 1.1F);
    localObject4[2] = Keyframe.ofFloat(1.0F, 1.0F);
    Object localObject2 = Keyframe.ofFloat(0.0F, 0.0F);
    Object localObject3 = Keyframe.ofFloat(0.33F, 0.8F);
    Keyframe localKeyframe1 = Keyframe.ofFloat(0.66F, 0.8F);
    Keyframe localKeyframe2 = Keyframe.ofFloat(1.0F, 0.0F);
    Object localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", (Keyframe[])localObject4);
    localObject4 = PropertyValuesHolder.ofKeyframe("scaleY", (Keyframe[])localObject4);
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.this$0.b, new PropertyValuesHolder[] { localObject1 }).setDuration(320L);
    localObject4 = ObjectAnimator.ofPropertyValuesHolder(this.this$0.b, new PropertyValuesHolder[] { localObject4 }).setDuration(320L);
    localObject2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject2, localObject3, localKeyframe1, localKeyframe2 });
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.this$0.b, new PropertyValuesHolder[] { localObject2 }).setDuration(320L);
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject4).with((Animator)localObject2);
    ((AnimatorSet)localObject3).start();
    this.this$0.b.setTag(localObject3);
    ((AnimatorSet)localObject3).addListener(new bhbt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.PhantomPicView.1
 * JD-Core Version:    0.7.0.1
 */