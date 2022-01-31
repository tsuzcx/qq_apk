package com.tencent.mobileqq.troopgift;

import aejb;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import azqt;

public class TroopInteractGiftAnimationController$5
  implements Runnable
{
  public TroopInteractGiftAnimationController$5(azqt paramazqt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Aejb == null) {
      return;
    }
    this.this$0.jdField_a_of_type_Aejb.c.removeView(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null) {
      this.this$0.jdField_a_of_type_AndroidViewViewGroup.removeView(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton);
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = null;
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.5
 * JD-Core Version:    0.7.0.1
 */