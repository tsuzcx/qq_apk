package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$4
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$4(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, String paramString, JSONObject paramJSONObject1, int paramInt2, JSONObject paramJSONObject2) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds / 1000L > this.jdField_a_of_type_Int)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject.optString("videoPath", "2.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject, new TroopInteractGiftAnimationController.1.1.4.1(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, this.jdField_b_of_type_Int - 300);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.4
 * JD-Core Version:    0.7.0.1
 */