package com.tencent.mobileqq.vas.troopgift;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "curState", "onLoadingStateChanged"}, k=3, mv={1, 1, 16})
final class AbsTroopGiftController$registerAvatars$receiverDrawable$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  AbsTroopGiftController$registerAvatars$receiverDrawable$1(AbsTroopGiftController paramAbsTroopGiftController, Drawable paramDrawable) {}
  
  public final void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      AppInterface localAppInterface = (AppInterface)this.a.m().app;
      String str = this.a.k().giftData.dataForClient.recvUin;
      Drawable localDrawable = this.b;
      FaceDrawable.getFaceDrawable(localAppInterface, 1, str, 3, localDrawable, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.AbsTroopGiftController.registerAvatars.receiverDrawable.1
 * JD-Core Version:    0.7.0.1
 */