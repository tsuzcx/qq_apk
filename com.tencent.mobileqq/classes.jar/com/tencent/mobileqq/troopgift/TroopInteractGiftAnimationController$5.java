package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;

class TroopInteractGiftAnimationController$5
  implements Runnable
{
  TroopInteractGiftAnimationController$5(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.removeView(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView);
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