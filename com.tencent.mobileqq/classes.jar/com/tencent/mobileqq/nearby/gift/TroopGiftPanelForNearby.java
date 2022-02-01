package com.tencent.mobileqq.nearby.gift;

import android.content.Context;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.OnGetGiveGiftCallback;
import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import java.lang.ref.WeakReference;

public class TroopGiftPanelForNearby
  extends TroopGiftPanel
  implements ITroopGiftPanelForNearby
{
  protected WeakReference<QQAppInterface> c = null;
  protected boolean e = false;
  protected boolean f = false;
  
  public TroopGiftPanelForNearby(QQAppInterface paramQQAppInterface, Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramOnShowOrHideListerner, false);
    this.c = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x7f8";
    this.g = 2040;
    this.e = paramBoolean1;
    this.f = paramBoolean3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    if (paramBoolean3) {
      this.k = 8;
    } else if (this.e) {
      this.k = 6;
    } else if (paramBoolean2) {
      this.k = 5;
    } else {
      this.k = 4;
    }
    setBackgroundColor(-1);
  }
  
  public void a(Object paramObject)
  {
    super.a((TroopGiftPanel.OnGetGiveGiftCallback)paramObject);
  }
  
  public void c(String paramString)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    TroopGiftAioItemData localTroopGiftAioItemData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
    int j = localTroopGiftAioItemData.b;
    if (localTroopGiftAioItemData.b == 0) {
      j = b();
    }
    int i;
    if (this.e) {
      i = 4;
    } else {
      i = 2;
    }
    if (this.f) {
      i = 5;
    }
    int m = this.k;
    String str = a();
    long l = Long.parseLong(paramString);
    int n = localTroopGiftAioItemData.c;
    int k;
    if (localTroopGiftAioItemData.b == 0) {
      k = 1;
    } else {
      k = 0;
    }
    ((TroopGiftManager)localObject).a("OidbSvc.0x7f6", 2038, i, m, str, 2, j, l, n, k, localTroopGiftAioItemData.jdField_a_of_type_Int, 0, new TroopGiftPanelForNearby.1(this), localTroopGiftAioItemData.e);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = null;
  }
  
  protected void e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.c.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject = (HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (localObject != null) {
      localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).startTroopMemberChooseForFlowerActivity(localObject, localQQAppInterface, a(), 0);
    } else {
      c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.b();
    }
  }
  
  public void setIsPttRoom(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.k = 5;
      return;
    }
    this.k = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby
 * JD-Core Version:    0.7.0.1
 */