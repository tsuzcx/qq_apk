package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import bfjm;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;

public class TroopInteractGiftAnimationController$5
  implements Runnable
{
  public TroopInteractGiftAnimationController$5(bfjm parambfjm) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a.removeView(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null) {
      this.this$0.jdField_a_of_type_AndroidViewViewGroup.removeView(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton);
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = null;
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.5
 * JD-Core Version:    0.7.0.1
 */