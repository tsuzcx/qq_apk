package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$5
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$5(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds / 1000L > this.jdField_a_of_type_Int + this.b)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject.optString("videoPath", "3.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject, new TroopInteractGiftAnimationController.1.1.5.1(this));
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
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.5
 * JD-Core Version:    0.7.0.1
 */