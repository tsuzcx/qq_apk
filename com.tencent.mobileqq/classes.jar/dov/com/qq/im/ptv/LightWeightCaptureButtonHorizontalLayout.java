package dov.com.qq.im.ptv;

import ajya;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arqn;
import axly;
import baww;
import bjpl;
import bjqa;
import bjqb;
import bjqc;
import bjqd;
import bjqe;
import bjqs;
import bjqt;
import bjqu;
import blcq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LightWeightCaptureButtonHorizontalLayout
  extends LightWeightCaptureButtonLayout
{
  private TextView a;
  private int e;
  private boolean g;
  
  public LightWeightCaptureButtonHorizontalLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public LightWeightCaptureButtonHorizontalLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Bjqs.i)
    {
      this.jdField_a_of_type_Bjqs.i = true;
      float f = this.jdField_a_of_type_Bjqs.jdField_f_of_type_Int;
      this.c.setTranslationX(f - paramFloat);
      if (AppSetting.d) {
        baww.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, ajya.a(2131706088));
      }
      return;
    }
    s();
  }
  
  private void b(float paramFloat)
  {
    if (!this.jdField_a_of_type_Bjqs.h)
    {
      this.jdField_a_of_type_Bjqs.h = true;
      float f = this.jdField_a_of_type_Bjqs.jdField_e_of_type_Int;
      this.b.setTranslationX(-(f - paramFloat));
      if (AppSetting.d) {
        baww.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, ajya.a(2131706103));
      }
      return;
    }
    r();
  }
  
  private void o()
  {
    int i = getResources().getColor(2131165323);
    int j = getResources().getColor(2131165324);
    p();
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setBackgroundColor(i);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowColor(j);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageWidth(blcq.a(32.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageHeight(blcq.a(32.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageResource(2130843630);
    i = getResources().getColor(2131165228);
    this.b.setBackgroundColor(-1);
    this.b.setImageWidth(blcq.a(30.0F));
    this.b.setImageHeight(blcq.a(30.0F));
    this.b.setImageResource(2130843619);
    this.b.setShadowColor(i);
    this.c.setBackgroundColor(-1);
    this.c.setShadowColor(i);
    this.c.setImageWidth(blcq.a(30.0F));
    this.c.setImageHeight(blcq.a(30.0F));
    this.c.setImageResource(2130843636);
  }
  
  private void p()
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeMaxWidth(blcq.a(10.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(blcq.a(10.0F));
  }
  
  private void q()
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeMaxWidth(blcq.a(30.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(blcq.a(2.0F));
  }
  
  private void r()
  {
    float f1 = this.b.getTranslationX();
    float f2 = this.jdField_a_of_type_Bjqs.jdField_e_of_type_Float;
    this.b.setTranslationX(f1 + f2);
  }
  
  private void s()
  {
    float f1 = this.c.getTranslationX();
    float f2 = this.jdField_a_of_type_Bjqs.jdField_e_of_type_Float;
    this.c.setTranslationX(f1 + f2);
  }
  
  private void t()
  {
    if (!this.jdField_a_of_type_Bjqs.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bjqs.jdField_e_of_type_Boolean = true;
      m();
    }
  }
  
  private void u()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.5F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.5F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3);
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.addListener(new bjqa(this));
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStatus(true);
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, "currentProgress", new float[] { 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
    localObjectAnimator1.addListener(new bjqb(this));
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "translationX", new float[] { this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX(), this.jdField_a_of_type_Bjqs.jdField_g_of_type_Float });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
  }
  
  private void v()
  {
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.start();
  }
  
  private void w()
  {
    int j = getResources().getColor(2131165228);
    int i = getResources().getColor(2131165528);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.b, "backgroundColor", new int[] { i, -1 });
    localObjectAnimator.setEvaluator(bjpl.a());
    int k = getResources().getColor(2131165529);
    Object localObject2 = ObjectAnimator.ofInt(this.b, "shadowColor", new int[] { k, j });
    ((ObjectAnimator)localObject2).setEvaluator(bjpl.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 180.0F, 0.0F });
    localObject2 = ObjectAnimator.ofFloat(this.b, "translationX", new float[] { this.b.getTranslationX(), 0.0F });
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObjectAnimator);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActive deleteView ScaleX:" + this.b.getScaleX() + " ScaleY:" + this.b.getScaleY());
    }
    localObject1 = a(this.b, 1.5F, 1.533F, 1.533F, 1.0F, (Animator)localObject1, this.jdField_a_of_type_JavaUtilArrayList, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bjqc(this));
    ((AnimatorSet)localObject1).start();
    this.b.setImageResource(2130843617);
    j = getResources().getColor(2131165319);
    k = getResources().getColor(2131165326);
    int m = getResources().getColor(2131165322);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, j });
    ((ObjectAnimator)localObject1).setEvaluator(bjpl.a());
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { m, k });
    localObjectAnimator.setEvaluator(bjpl.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bjqd(this));
    ((AnimatorSet)localObject1).start();
    i = getResources().getColor(2131166159);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, "deleteColor", new int[] { i, this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.a() });
    ((ObjectAnimator)localObject1).setStartDelay(90L);
    ((ObjectAnimator)localObject1).setDuration(50L);
    ((ObjectAnimator)localObject1).addListener(new bjqe(this));
    ((ObjectAnimator)localObject1).start();
  }
  
  protected int a()
  {
    return 2131560553;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_e_of_type_Int = blcq.a(5.0F);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375012));
    o();
    axly.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 0.0F, 0.0F, this.jdField_e_of_type_Int, 0.0F, 400, 0.0F, 1.0F);
    axly.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.0F, 0.0F, this.jdField_e_of_type_Int, 0.0F, 400, 0.0F, 1.0F);
  }
  
  protected void a(bjqt parambjqt, SimpleEffectsCaptureView paramSimpleEffectsCaptureView, LightWeightProgress paramLightWeightProgress)
  {
    super.a(parambjqt, paramSimpleEffectsCaptureView, paramLightWeightProgress);
    axly.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, 0.0F, 0.0F, this.jdField_e_of_type_Int, 0.0F, 400, 0.0F, 1.0F);
    axly.a(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, 0.0F, 0.0F, this.jdField_e_of_type_Int, 0.0F, 400, 0.0F, 1.0F);
  }
  
  protected void a(LWMotionEvent paramLWMotionEvent)
  {
    int i = getResources().getColor(2131165319);
    int j = getResources().getColor(2131165326);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setBackgroundColor(i);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowColor(j);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageWidth(blcq.a(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageHeight(blcq.a(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageResource(2130843629);
    q();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImPtvBaseButton.getLayoutParams();
    i = blcq.a('');
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    localLayoutParams.bottomMargin = blcq.a(2.5F);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setLayoutParams(localLayoutParams);
    this.jdField_g_of_type_Boolean = true;
    v();
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_Bjqu != null) {
      this.jdField_a_of_type_Bjqu.k();
    }
    arqn.c(this.d);
    super.a(paramLWMotionEvent);
  }
  
  protected boolean a(LWMotionEvent paramLWMotionEvent)
  {
    if (super.a(paramLWMotionEvent)) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Bjqs.jdField_b_of_type_Boolean)
      {
        u();
        return true;
      }
    } while (this.jdField_a_of_type_Bjqs.d < 2);
    t();
    return true;
  }
  
  protected void b()
  {
    super.b();
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImPtvBaseButton.getLayoutParams();
    int i = blcq.a(91.0F);
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    localLayoutParams.bottomMargin = blcq.a(32.0F);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setLayoutParams(localLayoutParams);
    o();
    axly.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 0.0F, 0.0F, 0.0F, 0.0F, 100, 0.0F, 1.0F);
    if (this.jdField_a_of_type_Bjqu != null) {
      this.jdField_a_of_type_Bjqu.j();
    }
  }
  
  protected void b(LWMotionEvent paramLWMotionEvent)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      if (this.jdField_a_of_type_DovComQqImPtvBaseButton.isLayoutRequested())
      {
        this.jdField_a_of_type_Bjqs.jdField_c_of_type_Boolean = true;
        return;
      }
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bjqs.jdField_c_of_type_Boolean)
      {
        super.a(paramLWMotionEvent);
        return;
      }
      super.b(paramLWMotionEvent);
      return;
    }
    super.b(paramLWMotionEvent);
  }
  
  protected void c()
  {
    float f2;
    if ((!this.jdField_a_of_type_Bjqs.jdField_a_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_Bjqs.jdField_e_of_type_Float) > bjqs.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Bjqs.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bjqs.jdField_e_of_type_Float > 0.0F)
      {
        this.jdField_a_of_type_Bjqs.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Bjqs.jdField_g_of_type_Float = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
        this.jdField_a_of_type_Bjqs.jdField_e_of_type_Int = b();
        this.jdField_a_of_type_Bjqs.jdField_f_of_type_Int = c();
        this.jdField_a_of_type_Bjqs.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Bjqs.jdField_g_of_type_Boolean = false;
      }
    }
    else if (this.jdField_a_of_type_Bjqs.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX(this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX() + this.jdField_a_of_type_Bjqs.jdField_e_of_type_Float);
      f1 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
      f2 = Math.abs(f1);
      if (!this.jdField_a_of_type_Bjqs.jdField_b_of_type_Boolean) {
        break label504;
      }
      switch (this.jdField_a_of_type_Bjqs.d)
      {
      }
    }
    label504:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_Bjqs.jdField_b_of_type_Boolean = false;
            break;
            if (f1 > bjqs.jdField_b_of_type_Int)
            {
              this.b.setImageResource(2130843617);
              this.jdField_a_of_type_Bjqs.d = 1;
              return;
            }
          } while ((f1 >= 0.0F) || (f2 <= bjqs.jdField_b_of_type_Int));
          this.jdField_a_of_type_Bjqs.jdField_b_of_type_Boolean = false;
          this.c.setImageResource(2130843635);
          this.jdField_a_of_type_Bjqs.d = 1;
          return;
          if (f1 > bjqs.jdField_c_of_type_Int)
          {
            this.jdField_a_of_type_Bjqs.d = 2;
            return;
          }
        } while (f1 > bjqs.jdField_b_of_type_Int);
        this.jdField_a_of_type_Bjqs.d = 0;
        this.b.setImageResource(2130843619);
        this.jdField_a_of_type_Bjqs.jdField_f_of_type_Boolean = true;
        return;
        k();
        this.jdField_a_of_type_Bjqs.h = false;
        return;
        f2 = this.jdField_a_of_type_Bjqs.jdField_e_of_type_Int;
        l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Bjqs.jdField_a_of_type_Long;
        l1 = l2;
        if (l2 >= this.jdField_a_of_type_Bjqs.jdField_b_of_type_Long) {
          l1 = this.jdField_a_of_type_Bjqs.jdField_b_of_type_Long;
        }
        f3 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_Bjqs.jdField_b_of_type_Long;
        this.b.setTranslationX(-(f3 * (f2 - f1)));
        return;
        b(f1);
        return;
        this.jdField_a_of_type_Bjqs.d = 6;
        b(f1);
        return;
        this.jdField_a_of_type_Bjqs.d = 7;
        r();
        return;
        if (f1 <= bjqs.jdField_c_of_type_Int)
        {
          w();
          this.jdField_a_of_type_Bjqs.d = 10;
          return;
        }
        r();
        return;
        switch (this.jdField_a_of_type_Bjqs.d)
        {
        default: 
          return;
        case 0: 
          if ((f1 < 0.0F) && (f2 > bjqs.jdField_b_of_type_Int))
          {
            this.c.setImageResource(2130843635);
            this.jdField_a_of_type_Bjqs.d = 1;
            return;
          }
          break;
        }
      } while (f1 <= bjqs.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bjqs.jdField_b_of_type_Boolean = true;
      this.b.setImageResource(2130843617);
      this.jdField_a_of_type_Bjqs.d = 1;
      return;
      if ((f1 < 0.0F) && (f2 > bjqs.jdField_c_of_type_Int))
      {
        this.jdField_a_of_type_Bjqs.d = 2;
        return;
      }
    } while ((f1 <= 0.0F) && (f2 > bjqs.jdField_b_of_type_Int));
    this.jdField_a_of_type_Bjqs.d = 0;
    this.c.setImageResource(2130843636);
    this.jdField_a_of_type_Bjqs.jdField_g_of_type_Boolean = true;
    return;
    l();
    this.jdField_a_of_type_Bjqs.i = false;
    return;
    float f1 = this.jdField_a_of_type_Bjqs.jdField_f_of_type_Int;
    long l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Bjqs.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 >= this.jdField_a_of_type_Bjqs.jdField_b_of_type_Long) {
      l1 = this.jdField_a_of_type_Bjqs.jdField_b_of_type_Long;
    }
    float f3 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_Bjqs.jdField_b_of_type_Long;
    this.c.setTranslationX(f3 * (f1 - f2));
    return;
    a(f2);
    return;
    this.jdField_a_of_type_Bjqs.d = 6;
    a(f2);
    return;
    this.jdField_a_of_type_Bjqs.d = 7;
    s();
    return;
    if ((f1 > 0.0F) || (f2 <= bjqs.jdField_c_of_type_Int))
    {
      n();
      this.jdField_a_of_type_Bjqs.d = 10;
      return;
    }
    s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout
 * JD-Core Version:    0.7.0.1
 */