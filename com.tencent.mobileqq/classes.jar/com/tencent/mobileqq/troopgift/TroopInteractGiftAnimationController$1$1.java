package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1
  implements Runnable
{
  TroopInteractGiftAnimationController$1$1(TroopInteractGiftAnimationController.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInteractGiftAnimationController", 2, "TroopGiftUtil.getInteractConfig = null, packageId: " + this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_OrgJsonJSONObject.optInt("type", 2) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null) {
          break label156;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = new SpriteVideoView(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a, bool);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setCenterCrop(true);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b != null) {
          break label158;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TroopInteractGiftAnimationController", 2, "mTroopChatPie.bgAnimationLayout == null");
        return;
      }
      label156:
      continue;
      label158:
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b.addView(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView, -1, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.m);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = new TroopGiftActionButton(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a, this.jdField_a_of_type_OrgJsonJSONObject, new TroopInteractGiftAnimationController.1.1.1(this));
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setOnProgressChangedListener(new TroopInteractGiftAnimationController.1.1.2(this));
        localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a, 175.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a, 175.0F));
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.m - DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a, 85.0F));
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = (-DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a, 25.0F));
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton, (ViewGroup.LayoutParams)localObject1);
      }
      Object localObject1 = TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
      Object localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("animation1");
      Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("animation2");
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("animation3");
      int i = ((JSONObject)localObject3).optInt("duration");
      int j = ((JSONObject)localObject2).optInt("duration");
      int k = localJSONObject.optInt("duration");
      int m = (int)(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.alreadyPlayMicroseconds / 1000L);
      int n = (int)(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds / 1000L);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState == 2) || (!this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_Boolean))
      {
        localObject3 = (String)localObject1 + ((JSONObject)localObject3).optString("videoPath", "1.mp4");
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject3, new TroopInteractGiftAnimationController.1.1.3(this, n, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId, new TroopInteractGiftAnimationController.1.1.7(this));
        return;
        if (m < i)
        {
          localObject3 = (String)localObject1 + ((JSONObject)localObject3).optString("videoPath", "1.mp4");
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject3, m, new TroopInteractGiftAnimationController.1.1.4(this, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, i - m - 300);
        }
        else if (m < i + j)
        {
          localObject2 = (String)localObject1 + ((JSONObject)localObject2).optString("videoPath", "2.mp4");
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject2, m - i, new TroopInteractGiftAnimationController.1.1.5(this, i, j, (String)localObject1, localJSONObject));
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, i + j - m - 300);
        }
        else if (m < i + j + k)
        {
          localObject1 = (String)localObject1 + localJSONObject.optString("videoPath", "3.mp4");
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController$1.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject1, m - i - j, new TroopInteractGiftAnimationController.1.1.6(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1
 * JD-Core Version:    0.7.0.1
 */