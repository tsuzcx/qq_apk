package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import arid;
import arrb;
import com.nineoldandroids.animation.AnimatorInflater;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.mini.ui.RoundImageView;

public class MatchingView
  extends FrameLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimatorSet jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView;
  private boolean jdField_a_of_type_Boolean;
  
  public MatchingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MatchingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MatchingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561073, this, true);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView = ((RoundImageView)findViewById(2131370622));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370623));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370627);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setBorderColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setBorderWidth(6);
    c();
    d();
  }
  
  private void c()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localObject = arid.a((AppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void d()
  {
    ThreadManager.post(new MatchingView.1(this), 5, null, true);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet = ((AnimatorSet)AnimatorInflater.loadAnimator(getContext(), 2130903040));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.setTarget(this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView);
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.setStartDelay(1000L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.addListener(new arrb(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    c();
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.end();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.MatchingView
 * JD-Core Version:    0.7.0.1
 */