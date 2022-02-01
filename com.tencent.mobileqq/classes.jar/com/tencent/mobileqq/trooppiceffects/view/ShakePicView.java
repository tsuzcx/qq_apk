package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.util.DisplayUtil;

public class ShakePicView
  extends FrameLayout
  implements IPicView
{
  protected Handler a;
  protected ImageView a;
  protected boolean a;
  protected ImageView b;
  protected ImageView c;
  
  public ShakePicView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.b = new ImageView(paramContext);
    this.c = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, -1, -1);
    addView(this.b, -1, -1);
    addView(this.c, -1, -1);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a()
  {
    c();
  }
  
  public void b()
  {
    this.b.clearAnimation();
    this.b.setTag(null);
    this.c.clearAnimation();
    this.c.setTag(null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.142F, -DisplayUtil.a(getContext(), 2.5F)), Keyframe.ofFloat(0.285F, -DisplayUtil.a(getContext(), 7.5F)), Keyframe.ofFloat(0.426F, -DisplayUtil.a(getContext(), 2.5F)), Keyframe.ofFloat(0.568F, -DisplayUtil.a(getContext(), 2.5F)), Keyframe.ofFloat(0.71F, -DisplayUtil.a(getContext(), 7.5F)), Keyframe.ofFloat(0.852F, -DisplayUtil.a(getContext(), 2.5F)), Keyframe.ofFloat(1.0F, 0.0F) });
    Object localObject2 = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.142F, 0.0F), Keyframe.ofFloat(0.285F, -DisplayUtil.a(getContext(), 3.5F)), Keyframe.ofFloat(0.426F, -DisplayUtil.a(getContext(), 13.5F)), Keyframe.ofFloat(0.568F, 0.0F), Keyframe.ofFloat(0.71F, -DisplayUtil.a(getContext(), 3.5F)), Keyframe.ofFloat(0.852F, -DisplayUtil.a(getContext(), 13.5F)), Keyframe.ofFloat(1.0F, 0.0F) });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.b, new PropertyValuesHolder[] { localObject1 }).setDuration(280L);
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.b, new PropertyValuesHolder[] { localObject2 }).setDuration(280L);
    Object localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject2);
    ((AnimatorSet)localObject3).start();
    this.b.setTag(localObject3);
    localObject1 = PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.33F, 0.05F), Keyframe.ofFloat(0.66F, 0.05F), Keyframe.ofFloat(1.0F, 0.0F) });
    localObject3 = new Keyframe[2];
    localObject3[0] = Keyframe.ofFloat(0.0F, 1.0F);
    localObject3[1] = Keyframe.ofFloat(1.0F, 2.33F);
    localObject2 = PropertyValuesHolder.ofKeyframe(View.SCALE_X, (Keyframe[])localObject3);
    localObject3 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, (Keyframe[])localObject3);
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[] { localObject2 }).setDuration(320L);
    localObject3 = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[] { localObject3 }).setDuration(320L);
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[] { localObject1 }).setDuration(320L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject1);
    localAnimatorSet.start();
    this.c.setTag(localAnimatorSet);
    localAnimatorSet.addListener(new ShakePicView.1(this));
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    this.b.setImageBitmap(paramBitmap);
    this.c.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.ShakePicView
 * JD-Core Version:    0.7.0.1
 */