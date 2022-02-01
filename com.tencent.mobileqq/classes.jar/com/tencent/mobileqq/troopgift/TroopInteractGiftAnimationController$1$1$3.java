package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$3
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$3(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject1, int paramInt3, JSONObject paramJSONObject2) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject.optString("videoPath", "2.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a.a((String)localObject, new TroopInteractGiftAnimationController.1.1.3.1(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.this$0.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1$1.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.3
 * JD-Core Version:    0.7.0.1
 */