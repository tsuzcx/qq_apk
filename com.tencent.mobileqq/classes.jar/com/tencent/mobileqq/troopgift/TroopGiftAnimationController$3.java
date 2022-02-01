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
    Object localObject1;
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      paramSprite = TroopGiftAnimationController.a(this.a).frienduin;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(TroopGiftUtil.b(TroopGiftAnimationController.a(this.a)));
      ((StringBuilder)localObject1).append("");
      NearbyFlowerManager.a("cartoon", "clk_inter", paramSprite, ((StringBuilder)localObject1).toString(), "", "");
    }
    else
    {
      if (TroopGiftAnimationController.a(this.a) != null) {
        paramSprite = "0";
      } else {
        paramSprite = "1";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(TroopGiftAnimationController.a(this.a).frienduin);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(TroopGiftUtil.b(TroopGiftAnimationController.a(this.a)));
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), TroopGiftAnimationController.a(this.a).frienduin));
      ReportController.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, (String)localObject1, (String)localObject2, paramSprite, localStringBuilder.toString());
    }
    paramSprite = TroopGiftAnimationController.a(this.a);
    if ((paramSprite != null) && (NetworkUtil.getSystemNetwork(paramSprite) == 0))
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
      paramSprite = paramSprite.getString(2131697616);
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramSprite, TroopGiftAnimationController.a(this.a).n, DisplayUtil.a(TroopGiftAnimationController.a(this.a), 16.0F));
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.3
 * JD-Core Version:    0.7.0.1
 */