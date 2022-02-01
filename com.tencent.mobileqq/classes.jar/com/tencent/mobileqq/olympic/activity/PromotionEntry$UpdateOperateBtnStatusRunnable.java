package com.tencent.mobileqq.olympic.activity;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

class PromotionEntry$UpdateOperateBtnStatusRunnable
  implements Runnable
{
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  PromotionConfigInfo.PromotionItem jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem = null;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  OnCompositionLoadedListener jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener = null;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  public boolean a;
  
  private PromotionEntry$UpdateOperateBtnStatusRunnable()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    Object localObject = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    }
  }
  
  public void a(ImageView paramImageView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem;
    if (localObject == null)
    {
      QLog.w(PromotionEntry.a, 1, "createShowOperateBtnAnim, promotionItem为空");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      localObject = PromotionPath.a((PromotionConfigInfo.PromotionItem)localObject);
      a((String)localObject);
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("entry.json");
        localObject = new FileInputStream(localStringBuilder.toString());
        LottieComposition.Factory.fromInputStream(paramImageView.getContext(), (InputStream)localObject, this.jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener);
        return;
      }
      catch (Exception paramImageView)
      {
        QLog.i(PromotionEntry.a, 1, "createShowOperateBtnAnim, 读取json失败", paramImageView);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener = new PromotionEntry.UpdateOperateBtnStatusRunnable.1(this, paramString);
  }
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      if (localImageView.getVisibility() != 0)
      {
        localImageView.setVisibility(0);
        a(localImageView, 0);
        localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
        if (localObject != null) {
          ((ObjectAnimator)localObject).start();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
        if (localObject != null)
        {
          localImageView.setImageDrawable((Drawable)localObject);
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(5);
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
        }
      }
    }
    else
    {
      localImageView.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
      if (localObject != null) {
        ((ObjectAnimator)localObject).end();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
      if (localObject != null)
      {
        localImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable
 * JD-Core Version:    0.7.0.1
 */