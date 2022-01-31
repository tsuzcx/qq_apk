package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bcsx;

public class PhantomPicView
  extends FrameLayout
  implements bcsx
{
  protected Handler a;
  protected FrameLayout a;
  protected ImageView a;
  protected boolean a;
  protected FrameLayout b;
  protected ImageView b;
  protected ImageView c;
  
  public PhantomPicView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.c = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, -1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, -1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, -1, -1);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.c, -1, -1);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(null);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
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
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetFrameLayout, new PropertyValuesHolder[] { localObject1 }).setDuration(320L);
    localObject4 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetFrameLayout, new PropertyValuesHolder[] { localObject4 }).setDuration(320L);
    localObject2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject2, localObject3, localKeyframe1, localKeyframe2 });
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetFrameLayout, new PropertyValuesHolder[] { localObject2 }).setDuration(320L);
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject4).with((Animator)localObject2);
    ((AnimatorSet)localObject3).start();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localObject3);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PhantomPicView.1(this), 80L);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), paramBitmap);
    localBitmapDrawable.setColorFilter(Color.parseColor("#D000FF"), PorterDuff.Mode.ADD);
    paramBitmap = new BitmapDrawable(getResources(), paramBitmap);
    paramBitmap.setColorFilter(Color.parseColor("#0005FF"), PorterDuff.Mode.ADD);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localBitmapDrawable);
    this.c.setImageDrawable(paramBitmap);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.PhantomPicView
 * JD-Core Version:    0.7.0.1
 */