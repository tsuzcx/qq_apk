package dov.com.qq.im.ptv;

import ajyc;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import axlw;
import bawi;
import bjou;
import bjpf;
import bjpg;
import bjph;
import bjpi;
import bjqb;
import bjqc;
import bjqd;
import blbz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LightWeightCaptureButtonCornerLayout
  extends LightWeightCaptureButtonLayout
{
  public LightWeightCaptureButtonCornerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public LightWeightCaptureButtonCornerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void o()
  {
    float f1 = this.jdField_b_of_type_DovComQqImPtvBaseButton.getTranslationY();
    float f2 = this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float;
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationY(f1 + f2);
  }
  
  private void p()
  {
    float f1 = this.jdField_c_of_type_DovComQqImPtvBaseButton.getTranslationX();
    float f2 = this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float;
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setTranslationX(f1 + f2);
  }
  
  private void q()
  {
    if (!this.jdField_a_of_type_Bjqb.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bjqb.jdField_e_of_type_Boolean = true;
      m();
    }
  }
  
  private void r()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 1.5F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 1.5F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3);
    localAnimatorSet.setDuration(100L);
    localAnimatorSet.addListener(new bjpf(this));
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
    a(100L);
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    localObjectAnimator1.start();
  }
  
  private void s()
  {
    int j = getResources().getColor(2131165228);
    int i = getResources().getColor(2131165528);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, -1 });
    localObjectAnimator.setEvaluator(bjou.a());
    int k = getResources().getColor(2131165529);
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { k, j });
    ((ObjectAnimator)localObject2).setEvaluator(bjou.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "rotation", new float[] { 180.0F, 0.0F });
    localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationY", new float[] { this.jdField_b_of_type_DovComQqImPtvBaseButton.getTranslationY(), 0.0F });
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObjectAnimator);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActiveCorner deleteView ScaleX:" + this.jdField_b_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.jdField_b_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
    localObject1 = a(this.jdField_b_of_type_DovComQqImPtvBaseButton, 1.5F, 1.533F, 1.533F, 1.0F, (Animator)localObject1, this.jdField_a_of_type_JavaUtilArrayList, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bjpg(this));
    ((AnimatorSet)localObject1).start();
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130843616);
    j = getResources().getColor(2131165319);
    k = getResources().getColor(2131165326);
    int m = getResources().getColor(2131165322);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, j });
    ((ObjectAnimator)localObject1).setEvaluator(bjou.a());
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { m, k });
    localObjectAnimator.setEvaluator(bjou.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bjph(this));
    ((AnimatorSet)localObject1).start();
    i = getResources().getColor(2131166159);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, "deleteColor", new int[] { i, this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.a() });
    ((ObjectAnimator)localObject1).setStartDelay(90L);
    ((ObjectAnimator)localObject1).setDuration(50L);
    ((ObjectAnimator)localObject1).addListener(new bjpi(this));
    ((ObjectAnimator)localObject1).start();
  }
  
  private void t()
  {
    u();
    axlw.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, 0.0F, 0.0F, this.jdField_c_of_type_Float, 0.0F, 400, 0.0F, 1.0F);
    axlw.a(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, 0.0F, 0.0F, this.jdField_c_of_type_Float, 0.0F, 400, 0.0F, 1.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    int i = getResources().getColor(2131165320);
    int j = getResources().getColor(2131165319);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { i, j });
    localObjectAnimator2.setEvaluator(bjou.a());
    localObjectAnimator2.setDuration(400L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 0.42F, 1.0F });
    localObjectAnimator3.setDuration(400L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 0.42F, 1.0F });
    localObjectAnimator4.setDuration(400L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator4);
    localAnimatorSet.start();
  }
  
  private void u()
  {
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setVisibility(0);
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    Object localObject = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "translationX", new float[] { 0.0F, -this.jdField_d_of_type_Float });
    ((ObjectAnimator)localObject).setDuration(330L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "translationX", new float[] { this.jdField_b_of_type_Float });
    localObjectAnimator2.setDuration(70L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).before(localObjectAnimator2);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localAnimatorSet);
    ((AnimatorSet)localObject).start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(400L);
    localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationY", new float[] { 0.0F, -this.jdField_d_of_type_Float });
    ((ObjectAnimator)localObject).setDuration(330L);
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "translationY", new float[] { this.jdField_b_of_type_Float });
    localObjectAnimator2.setDuration(70L);
    localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).before(localObjectAnimator2);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localAnimatorSet);
    ((AnimatorSet)localObject).start();
  }
  
  protected int a()
  {
    return 2131560553;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    int i = getResources().getColor(2131165319);
    int j = getResources().getColor(2131165326);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowStrokeMaxWidth(blbz.a(30.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setBackgroundColor(i);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowColor(j);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageWidth(blbz.a(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageHeight(blbz.a(40.0F));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setImageResource(2130843628);
    i = getResources().getColor(2131165228);
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setBackgroundColor(-1);
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageWidth(blbz.a(30.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageHeight(blbz.a(30.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130843618);
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setShadowColor(i);
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setBackgroundColor(-1);
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setShadowColor(i);
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageWidth(blbz.a(30.0F));
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageHeight(blbz.a(30.0F));
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageResource(2130843635);
  }
  
  protected void a(bjqc parambjqc, SimpleEffectsCaptureView paramSimpleEffectsCaptureView, LightWeightProgress paramLightWeightProgress)
  {
    super.a(parambjqc, paramSimpleEffectsCaptureView, paramLightWeightProgress);
    t();
  }
  
  protected void a(LWMotionEvent paramLWMotionEvent)
  {
    super.a(paramLWMotionEvent);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean a(LWMotionEvent paramLWMotionEvent)
  {
    if (super.a(paramLWMotionEvent)) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean)
      {
        r();
        return true;
      }
    } while (this.jdField_a_of_type_Bjqb.d < 2);
    q();
    return true;
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bjqd != null) {
      this.jdField_a_of_type_Bjqd.l();
    }
  }
  
  protected void c()
  {
    float f1;
    float f2;
    if (!this.jdField_a_of_type_Bjqb.jdField_a_of_type_Boolean)
    {
      f1 = Math.abs(this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float);
      f2 = Math.abs(this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float);
      if ((f1 <= bjqb.jdField_a_of_type_Int) || (f1 <= f2) || (this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float >= 0.0F)) {
        break label245;
      }
      this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bjqb.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bjqb.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bjqb.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Bjqb.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_Bjqb.jdField_e_of_type_Int = d();
        this.jdField_a_of_type_Bjqb.jdField_f_of_type_Int = c();
      }
    }
    if (this.jdField_a_of_type_Bjqb.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean) {
        break label767;
      }
      f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationY() + this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float;
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationY(f1);
      f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationY();
      f1 = Math.abs(f2);
      switch (this.jdField_a_of_type_Bjqb.d)
      {
      }
    }
    label245:
    label767:
    do
    {
      do
      {
        float f4;
        do
        {
          do
          {
            do
            {
              return;
              if ((f2 <= bjqb.jdField_a_of_type_Int) || (f2 <= f1) || (this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float >= 0.0F)) {
                break;
              }
              this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean = true;
              this.jdField_a_of_type_Bjqb.jdField_a_of_type_Boolean = true;
              break;
              if (this.jdField_a_of_type_Bjqb.jdField_f_of_type_Boolean)
              {
                f3 = Math.abs(this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float);
                f4 = Math.abs(this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float);
                if ((f3 > 6.0F) && (f3 > f4) && (this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float < 0.0F))
                {
                  this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean = false;
                  this.jdField_a_of_type_Bjqb.jdField_f_of_type_Boolean = false;
                  return;
                }
                if ((f4 > 6.0F) && (f4 > f3) && (this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float < 0.0F))
                {
                  this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean = true;
                  this.jdField_a_of_type_Bjqb.jdField_f_of_type_Boolean = false;
                }
              }
            } while ((f2 > 0.0F) || (f1 <= bjqb.jdField_b_of_type_Int));
            this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130843616);
            this.jdField_a_of_type_Bjqb.d = 1;
            return;
            if ((f2 <= 0.0F) && (f1 > bjqb.c))
            {
              this.jdField_a_of_type_Bjqb.d = 2;
              return;
            }
          } while ((f2 > 0.0F) || (f1 > bjqb.jdField_b_of_type_Int));
          this.jdField_a_of_type_Bjqb.d = 0;
          this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130843618);
          this.jdField_a_of_type_Bjqb.jdField_f_of_type_Boolean = true;
          return;
          k();
          this.jdField_a_of_type_Bjqb.jdField_g_of_type_Float = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
          this.jdField_a_of_type_Bjqb.jdField_h_of_type_Boolean = false;
          return;
          f3 = this.jdField_a_of_type_Bjqb.jdField_e_of_type_Int;
          l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Bjqb.jdField_a_of_type_Long;
          l1 = l2;
          if (l2 >= this.jdField_a_of_type_Bjqb.jdField_b_of_type_Long) {
            l1 = this.jdField_a_of_type_Bjqb.jdField_b_of_type_Long;
          }
          f2 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_Bjqb.jdField_b_of_type_Long;
          this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationY(f2 * (f3 - f1));
          f1 = this.jdField_a_of_type_Bjqb.jdField_g_of_type_Float;
          this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX((1.0F - f2) * f1);
          return;
          if (this.jdField_a_of_type_Bjqb.jdField_h_of_type_Boolean) {
            break label700;
          }
          this.jdField_a_of_type_Bjqb.jdField_h_of_type_Boolean = true;
          f2 = this.jdField_a_of_type_Bjqb.jdField_e_of_type_Int;
          this.jdField_b_of_type_DovComQqImPtvBaseButton.setTranslationY(f2 - f1);
          this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX(0.0F);
        } while (!AppSetting.jdField_d_of_type_Boolean);
        bawi.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, ajyc.a(2131706071));
        return;
        o();
        return;
        this.jdField_a_of_type_Bjqb.d = 6;
        o();
        return;
        this.jdField_a_of_type_Bjqb.d = 7;
        o();
        return;
        if ((f2 <= 0.0F) && (f1 <= bjqb.c))
        {
          s();
          this.jdField_a_of_type_Bjqb.d = 10;
          return;
        }
        o();
        return;
        f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX() + this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float;
        f1 = f2;
        if (f2 >= 0.0F) {
          f1 = 0.0F;
        }
        this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationX(f1);
        f2 = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX();
        f1 = Math.abs(f2);
        switch (this.jdField_a_of_type_Bjqb.d)
        {
        default: 
          return;
        case 0: 
          if (this.jdField_a_of_type_Bjqb.jdField_g_of_type_Boolean)
          {
            f3 = Math.abs(this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float);
            f4 = Math.abs(this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float);
            if ((f3 <= 6.0F) || (f3 <= f4) || (this.jdField_a_of_type_Bjqb.jdField_e_of_type_Float >= 0.0F)) {
              break label979;
            }
            this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_Bjqb.jdField_g_of_type_Boolean = false;
          }
          while ((f4 <= 6.0F) || (f4 <= f3) || (this.jdField_a_of_type_Bjqb.jdField_f_of_type_Float >= 0.0F))
          {
            if ((f2 > 0.0F) || (f1 <= bjqb.jdField_b_of_type_Int)) {
              break;
            }
            this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageResource(2130843634);
            this.jdField_a_of_type_Bjqb.d = 1;
            return;
          }
          this.jdField_a_of_type_Bjqb.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Bjqb.jdField_g_of_type_Boolean = false;
          return;
        case 1: 
          if ((f2 <= 0.0F) && (f1 > bjqb.c))
          {
            this.jdField_a_of_type_Bjqb.d = 2;
            return;
          }
          break;
        }
      } while ((f2 > 0.0F) || (f1 > bjqb.jdField_b_of_type_Int));
      this.jdField_a_of_type_Bjqb.d = 0;
      this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageResource(2130843635);
      this.jdField_a_of_type_Bjqb.jdField_g_of_type_Boolean = true;
      return;
      l();
      this.jdField_a_of_type_Bjqb.jdField_h_of_type_Float = this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationY();
      this.jdField_a_of_type_Bjqb.i = false;
      return;
      float f3 = this.jdField_a_of_type_Bjqb.jdField_f_of_type_Int;
      long l2 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Bjqb.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 >= this.jdField_a_of_type_Bjqb.jdField_b_of_type_Long) {
        l1 = this.jdField_a_of_type_Bjqb.jdField_b_of_type_Long;
      }
      f2 = (float)l1 * 1.0F / (float)this.jdField_a_of_type_Bjqb.jdField_b_of_type_Long;
      this.jdField_c_of_type_DovComQqImPtvBaseButton.setTranslationX(f2 * (f3 - f1));
      f1 = this.jdField_a_of_type_Bjqb.jdField_h_of_type_Float;
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationY((1.0F - f2) * f1);
      return;
      if (this.jdField_a_of_type_Bjqb.i) {
        break label1279;
      }
      this.jdField_a_of_type_Bjqb.i = true;
      f2 = this.jdField_a_of_type_Bjqb.jdField_f_of_type_Int;
      this.jdField_c_of_type_DovComQqImPtvBaseButton.setTranslationX(f2 - f1);
      this.jdField_a_of_type_DovComQqImPtvBaseButton.setTranslationY(0.0F);
    } while (!AppSetting.jdField_d_of_type_Boolean);
    label700:
    label979:
    bawi.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, ajyc.a(2131706085));
    return;
    label1279:
    p();
    return;
    this.jdField_a_of_type_Bjqb.d = 6;
    p();
    return;
    this.jdField_a_of_type_Bjqb.d = 7;
    p();
    return;
    if ((f2 <= 0.0F) && (f1 <= bjqb.c))
    {
      n();
      this.jdField_a_of_type_Bjqb.d = 10;
      return;
    }
    p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout
 * JD-Core Version:    0.7.0.1
 */