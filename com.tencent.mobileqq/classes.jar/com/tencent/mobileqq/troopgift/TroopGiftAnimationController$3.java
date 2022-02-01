package com.tencent.mobileqq.troopgift;

import android.content.Context;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

class TroopGiftAnimationController$3
  implements ImageButton.OnClickListener
{
  TroopGiftAnimationController$3(TroopGiftAnimationController paramTroopGiftAnimationController) {}
  
  public void a(Sprite paramSprite)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      NearbyFlowerManager.a("cartoon", "clk_inter", TroopGiftAnimationController.a(this.a).frienduin, TroopGiftUtil.b(TroopGiftAnimationController.a(this.a)) + "", "", "");
      paramSprite = TroopGiftAnimationController.a(this.a);
      if ((paramSprite != null) && (NetworkUtil.a(paramSprite) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        paramSprite = paramSprite.getString(2131697610);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramSprite, TroopGiftAnimationController.a(this.a).n, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
      }
    }
    else
    {
      if (TroopGiftAnimationController.a(this.a) != null) {}
      for (paramSprite = "0";; paramSprite = "1")
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + TroopGiftAnimationController.a(this.a).frienduin, "" + TroopGiftUtil.b(TroopGiftAnimationController.a(this.a)), paramSprite, "" + TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), TroopGiftAnimationController.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    paramSprite = (TroopGiftManager)localAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    TroopGiftAnimationController.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      paramSprite.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, TroopGiftAnimationController.a(this.a).frienduin, TroopGiftAnimationController.a(this.a).bagId, 3000L, TroopGiftAnimationController.a(this.a));
      return;
    }
    paramSprite.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, TroopGiftAnimationController.a(this.a).frienduin, TroopGiftAnimationController.a(this.a).bagId, 3000L, TroopGiftAnimationController.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.3
 * JD-Core Version:    0.7.0.1
 */