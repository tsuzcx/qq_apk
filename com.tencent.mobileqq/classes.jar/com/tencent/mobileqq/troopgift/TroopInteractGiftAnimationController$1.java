package com.tencent.mobileqq.troopgift;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1
  implements Runnable
{
  TroopInteractGiftAnimationController$1(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController, String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean, FrameSprite.OnFrameEndListener paramOnFrameEndListener, TroopGiftManager paramTroopGiftManager) {}
  
  public void run()
  {
    JSONObject localJSONObject = TroopGiftUtil.a(this.jdField_a_of_type_JavaLangString);
    this.this$0.a.post(new TroopInteractGiftAnimationController.1.1(this, localJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1
 * JD-Core Version:    0.7.0.1
 */