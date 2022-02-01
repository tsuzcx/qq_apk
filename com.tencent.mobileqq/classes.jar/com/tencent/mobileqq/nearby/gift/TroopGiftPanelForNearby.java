package com.tencent.mobileqq.nearby.gift;

import android.content.Context;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import java.lang.ref.WeakReference;

public class TroopGiftPanelForNearby
  extends TroopGiftPanel
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
    }
    for (;;)
    {
      setBackgroundColor(-1);
      return;
      if (this.e) {
        this.k = 6;
      } else if (paramBoolean2) {
        this.k = 5;
      } else {
        this.k = 4;
      }
    }
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
    if (this.e)
    {
      i = 4;
      if (!this.f) {
        break label177;
      }
      i = 5;
    }
    label177:
    for (;;)
    {
      int m = this.k;
      String str = a();
      long l = Long.parseLong(paramString);
      int n = localTroopGiftAioItemData.c;
      if (localTroopGiftAioItemData.b == 0) {}
      for (int k = 1;; k = 0)
      {
        ((TroopGiftManager)localObject).a("OidbSvc.0x7f6", 2038, i, m, str, 2, j, l, n, k, localTroopGiftAioItemData.jdField_a_of_type_Int, 0, new TroopGiftPanelForNearby.1(this), localTroopGiftAioItemData.e);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = null;
        return;
        i = 2;
        break;
      }
    }
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.c.get();
    if (localQQAppInterface == null) {}
    label79:
    label91:
    for (;;)
    {
      return;
      Object localObject = (HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if (localObject == null) {
          break label79;
        }
        HotChatUtil.a((HotChatInfo)localObject, localQQAppInterface, a(), 0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner == null) {
          break label91;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.b();
        return;
        localObject = null;
        break;
        c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby
 * JD-Core Version:    0.7.0.1
 */