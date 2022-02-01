package com.tencent.mobileqq.newfriend.poke;

import android.animation.Animator;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class NewFriendNotifyPokeMsgHelper$2$1
  extends D8SafeAnimatorListener
{
  NewFriendNotifyPokeMsgHelper$2$1(NewFriendNotifyPokeMsgHelper.2 param2) {}
  
  private void a(ImageView paramImageView, Object paramObject)
  {
    if ((paramImageView != null) && (paramImageView.getAnimation() != null)) {
      paramImageView.getAnimation().cancel();
    }
    NewFriendNotifyPokeMsgHelper.a(paramObject, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a(this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_JavaLangObject);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a(this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_JavaLangObject);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper.2.1
 * JD-Core Version:    0.7.0.1
 */