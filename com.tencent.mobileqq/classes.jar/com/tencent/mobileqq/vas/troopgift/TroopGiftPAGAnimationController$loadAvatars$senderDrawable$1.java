package com.tencent.mobileqq.vas.troopgift;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.utils.ImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "curState", "onLoadingStateChanged"}, k=3, mv={1, 1, 16})
final class TroopGiftPAGAnimationController$loadAvatars$senderDrawable$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  TroopGiftPAGAnimationController$loadAvatars$senderDrawable$1(TroopGiftPAGAnimationController paramTroopGiftPAGAnimationController, TroopGiftData paramTroopGiftData, Drawable paramDrawable) {}
  
  public final void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      Object localObject = FaceDrawable.getFaceDrawable((AppInterface)((BaseActivity)TroopGiftPAGAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController)).app, 1, this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftData.giftData.dataForClient.sendUin, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      TroopGiftComboView localTroopGiftComboView = TroopGiftPAGAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController);
      localObject = ImageUtil.b((Drawable)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ImageUtil.drawableToBitmap(senderDrawable)");
      localTroopGiftComboView.setSenderAvatar((Bitmap)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.loadAvatars.senderDrawable.1
 * JD-Core Version:    0.7.0.1
 */