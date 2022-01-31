package com.tencent.mobileqq.nearby.gift;

import aeyg;
import android.content.Context;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import java.lang.ref.WeakReference;

public class TroopGiftPanelForNearby
  extends TroopGiftPanel
{
  protected WeakReference c;
  protected boolean e;
  protected boolean f;
  
  public TroopGiftPanelForNearby(QQAppInterface paramQQAppInterface, Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramOnShowOrHideListerner, false);
    this.c = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "OidbSvc.0x7f8";
    this.jdField_a_of_type_Int = 2040;
    this.jdField_e_of_type_Boolean = paramBoolean1;
    this.f = paramBoolean3;
    this.jdField_a_of_type_Boolean = true;
    this.b = new WeakReference(paramBaseChatPie);
    if (paramBoolean3) {
      this.jdField_e_of_type_Int = 8;
    }
    for (;;)
    {
      setBackgroundColor(-1);
      return;
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_e_of_type_Int = 6;
      } else if (paramBoolean2) {
        this.jdField_e_of_type_Int = 5;
      } else {
        this.jdField_e_of_type_Int = 4;
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(112);
    TroopGiftAioItemData localTroopGiftAioItemData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
    int j = localTroopGiftAioItemData.b;
    if (localTroopGiftAioItemData.b == 0) {
      j = a();
    }
    int i;
    if (this.jdField_e_of_type_Boolean)
    {
      i = 4;
      if (!this.f) {
        break label176;
      }
      i = 5;
    }
    label176:
    for (;;)
    {
      int m = this.jdField_e_of_type_Int;
      String str = a();
      long l = Long.parseLong(paramString);
      int n = localTroopGiftAioItemData.c;
      if (localTroopGiftAioItemData.b == 0) {}
      for (int k = 1;; k = 0)
      {
        ((TroopGiftManager)localObject).a("OidbSvc.0x7f6", 2038, i, m, str, 2, j, l, n, k, localTroopGiftAioItemData.jdField_a_of_type_Int, 0, new aeyg(this), localTroopGiftAioItemData.jdField_e_of_type_Int);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = null;
        return;
        i = 2;
        break;
      }
    }
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.c.get();
    if (localQQAppInterface == null) {}
    label78:
    label90:
    for (;;)
    {
      return;
      Object localObject = (HotChatManager)localQQAppInterface.getManager(59);
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          break label78;
        }
        HotChatUtil.a((HotChatInfo)localObject, localQQAppInterface, a(), 0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner == null) {
          break label90;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
        return;
        localObject = null;
        break;
        b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void setIsPttRoom(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_Int = 5;
      return;
    }
    this.jdField_e_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby
 * JD-Core Version:    0.7.0.1
 */