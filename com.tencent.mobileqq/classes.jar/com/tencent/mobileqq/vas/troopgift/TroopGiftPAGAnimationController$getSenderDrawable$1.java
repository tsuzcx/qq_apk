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
final class TroopGiftPAGAnimationController$getSenderDrawable$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  TroopGiftPAGAnimationController$getSenderDrawable$1(TroopGiftPAGAnimationController paramTroopGiftPAGAnimationController, TroopGiftData paramTroopGiftData, Drawable paramDrawable) {}
  
  public final void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      Object localObject1 = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a().app;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftData.giftData.dataForClient.sendUin;
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject2 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, (String)localObject2, 3, localDrawable, localDrawable);
      localObject1 = TroopGiftPAGAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController);
      localObject2 = ImageUtil.b((Drawable)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ImageUtil.drawableToBitmap(senderDrawable)");
      ((TroopGiftComboView)localObject1).setSenderAvatar((Bitmap)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.getSenderDrawable.1
 * JD-Core Version:    0.7.0.1
 */