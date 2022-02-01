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

public class PhantomPicView
  extends FrameLayout
  implements IPicView
{
  protected ImageView a;
  protected ImageView b;
  protected ImageView c;
  protected FrameLayout d;
  protected FrameLayout e;
  protected Handler f = new Handler(Looper.getMainLooper());
  protected boolean g;
  
  public PhantomPicView(Context paramContext)
  {
    super(paramContext);
    this.a = new ImageView(paramContext);
    this.b = new ImageView(paramContext);
    this.c = new ImageView(paramContext);
    this.d = new FrameLayout(paramContext);
    this.e = new FrameLayout(paramContext);
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.a, -1, -1);
    addView(this.d, -1, -1);
    addView(this.e, -1, -1);
    this.d.addView(this.b, -1, -1);
    this.e.addView(this.c, -1, -1);
  }
  
  public void a()
  {
    c();
  }
  
  public void b()
  {
    this.d.clearAnimation();
    this.d.setTag(null);
    this.e.clearAnimation();
    this.e.setTag(null);
    this.g = true;
    this.f.removeCallbacksAndMessages(null);
  }
  
  protected void c()
  {
    if (this.g) {
      return;
    }
    this.d.setVisibility(0);
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
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.d, new PropertyValuesHolder[] { localObject1 }).setDuration(320L);
    localObject4 = ObjectAnimator.ofPropertyValuesHolder(this.d, new PropertyValuesHolder[] { localObject4 }).setDuration(320L);
    localObject2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject2, localObject3, localKeyframe1, localKeyframe2 });
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.d, new PropertyValuesHolder[] { localObject2 }).setDuration(320L);
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject4).with((Animator)localObject2);
    ((AnimatorSet)localObject3).start();
    this.d.setTag(localObject3);
    this.f.postDelayed(new PhantomPicView.1(this), 80L);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), paramBitmap);
    localBitmapDrawable.setColorFilter(Color.parseColor("#D000FF"), PorterDuff.Mode.ADD);
    paramBitmap = new BitmapDrawable(getResources(), paramBitmap);
    paramBitmap.setColorFilter(Color.parseColor("#0005FF"), PorterDuff.Mode.ADD);
    this.b.setImageDrawable(localBitmapDrawable);
    this.c.setImageDrawable(paramBitmap);
    this.d.setVisibility(4);
    this.e.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.PhantomPicView
 * JD-Core Version:    0.7.0.1
 */