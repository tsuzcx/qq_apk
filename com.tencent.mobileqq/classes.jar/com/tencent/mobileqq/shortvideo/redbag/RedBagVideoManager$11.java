package com.tencent.mobileqq.shortvideo.redbag;

import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;

class RedBagVideoManager$11
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  RedBagVideoManager$11(RedBagVideoManager paramRedBagVideoManager, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.c > 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    RedBagVideoManager localRedBagVideoManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager;
    localRedBagVideoManager.c += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.11
 * JD-Core Version:    0.7.0.1
 */