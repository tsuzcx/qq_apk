package com.tencent.mobileqq.olympic.activity;

import akyn;
import akyt;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import augf;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class PromotionEntry$UpdateOperateBtnStatusRunnable
  implements Runnable
{
  akyn jdField_a_of_type_Akyn = null;
  public ObjectAnimator a;
  public LottieDrawable a;
  OnCompositionLoadedListener jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener = null;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  public boolean a;
  
  private PromotionEntry$UpdateOperateBtnStatusRunnable()
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  }
  
  public void a()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView != null) {
      localImageView.setImageDrawable(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    }
  }
  
  public void a(ImageView paramImageView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Akyn == null)
      {
        QLog.w(PromotionEntry.a, 1, "createShowOperateBtnAnim, promotionItem为空");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null);
    Object localObject = akyt.a(this.jdField_a_of_type_Akyn);
    a((String)localObject);
    try
    {
      localObject = new FileInputStream((String)localObject + "entry.json");
      LottieComposition.Factory.fromInputStream(paramImageView.getContext(), (InputStream)localObject, this.jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener);
      return;
    }
    catch (Exception paramImageView)
    {
      QLog.i(PromotionEntry.a, 1, "createShowOperateBtnAnim, 读取json失败", paramImageView);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener = new augf(this, paramString);
  }
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (localImageView.getVisibility() == 0);
        localImageView.setVisibility(0);
        a(localImageView, 0);
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
      localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(5);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
      localImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.end();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable
 * JD-Core Version:    0.7.0.1
 */