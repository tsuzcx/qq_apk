package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$4$1
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$4$1(TroopInteractGiftAnimationController.1.1.4 param4) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView == null) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds / 1000L > this.a.jdField_a_of_type_Int + this.a.jdField_b_of_type_Int)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.a.jdField_b_of_type_OrgJsonJSONObject.optString("videoPath", "3.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject, new TroopInteractGiftAnimationController.1.1.4.1.1(this));
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId, this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId, this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.4.1
 * JD-Core Version:    0.7.0.1
 */