package com.tencent.mobileqq.nearby.gameroom;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class GameRoomFloatView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GameRoomFloatView$3(GameRoomFloatView paramGameRoomFloatView, WindowManager.LayoutParams paramLayoutParams, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.b)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = i;
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView.3
 * JD-Core Version:    0.7.0.1
 */