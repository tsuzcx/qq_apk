package com.tencent.mobileqq.popanim.state;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class PopDeleteState
  extends BaseState
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private View jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372942);
  private TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364270);
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366851);
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private PopAnimState jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState;
  private DiniFlyAnimationView b = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372941);
  
  protected PopDeleteState(RelativeLayout paramRelativeLayout, StateContext paramStateContext)
  {
    super(paramRelativeLayout, paramStateContext);
    LottieHelper.a(this.jdField_a_of_type_AndroidContentContext, "emoc/pop_anim_del_confirm.json", null, 50, 50, 0, new PopDeleteState.1(this));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.f = true;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.a();
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.typeface).b();
    if (QLog.isColorLevel()) {
      QLog.d("PopDeleteState", 2, "pausePopAnim");
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.b();
    ThreadManager.getUIHandler().postDelayed(new PopDeleteState.2(this), 300L);
    if (QLog.isColorLevel()) {
      QLog.d("PopDeleteState", 2, "resumePopAnim");
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      float f = ViewUtils.b(95.0F);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { f });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(400L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new PopDeleteState.3(this));
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  protected void a()
  {
    this.b.setImageResource(2130839634);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = ViewUtils.b(85.0F);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839635);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  public void a(BaseState paramBaseState)
  {
    if (!(paramBaseState instanceof PopAnimState))
    {
      QLog.d("PopDeleteState", 1, new Exception(), new Object[] { "preState error, ", paramBaseState });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState = ((PopAnimState)paramBaseState);
    paramBaseState = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (paramBaseState != null) {
      this.b.setImageDrawable(paramBaseState);
    }
    PopOutAnimViewHelper.a(0, new View[] { this.b });
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = ViewUtils.b(95.0F);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839636);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
    PopOutAnimViewHelper.a(4, new View[] { this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView });
    b();
    int i = PopOutEmoticonUtil.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_AndroidWidgetEditText);
    paramBaseState = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramBaseState.setMargins(0, 0, 0, i);
    if (!this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.e = true;
      PopOutAnimViewHelper.a("0X800BBA2", this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void b(BaseState paramBaseState)
  {
    c();
    if ((paramBaseState instanceof PopAnimState))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.f = false;
      PopOutAnimViewHelper.a(0, new View[] { this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView });
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    d();
    PopOutAnimViewHelper.a(4, new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView });
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.PopDeleteState
 * JD-Core Version:    0.7.0.1
 */