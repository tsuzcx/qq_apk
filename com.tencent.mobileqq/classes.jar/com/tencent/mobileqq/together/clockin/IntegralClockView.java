package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Observable;
import java.util.Observer;

public class IntegralClockView
  extends ClockView
  implements Observer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ClockInData jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
  
  public IntegralClockView(DiniFlyAnimationView paramDiniFlyAnimationView, RelativeLayout paramRelativeLayout, Context paramContext, ClockAnimController paramClockAnimController, ClockInData paramClockInData)
  {
    super(paramClockAnimController);
    if (paramClockAnimController != null) {
      paramClockAnimController.addObserver(this);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData = paramClockInData;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = paramDiniFlyAnimationView;
    paramDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (paramDiniFlyAnimationView != null)
    {
      paramDiniFlyAnimationView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new IntegralClockView.1(this));
      paramDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
      if ((paramDiniFlyAnimationView != null) && (!TextUtils.isEmpty(paramDiniFlyAnimationView.m))) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromUrl(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.m);
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((ClockInData)localObject).m)) {
          return;
        }
        int i = ScreenUtil.getInstantScreenHeight(this.jdField_a_of_type_AndroidContentContext);
        localObject = new int[2];
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationOnScreen((int[])localObject);
        int j = localObject[1];
        int k = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (i - j - k - ViewUtils.b(30.0F));
        if (((FrameLayout.LayoutParams)localObject).bottomMargin + ViewUtils.b(170.0F) > i) {
          ((FrameLayout.LayoutParams)localObject).bottomMargin = (i - ViewUtils.b(170.0F) + ViewUtils.b(30.0F));
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromUrl(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.m);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
  }
  
  public void a()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null)
    {
      localDiniFlyAnimationView.removeAllAnimatorListener();
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
    }
  }
  
  public void b(int paramInt)
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.setVisibility(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return;
    }
    if (((Integer)paramObject).intValue() == 4) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.IntegralClockView
 * JD-Core Version:    0.7.0.1
 */