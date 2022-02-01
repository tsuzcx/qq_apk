package com.tencent.mobileqq.nearby.gift;

import aawl;
import aaxw;
import android.content.Context;
import axug;
import ayac;
import bgsu;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import java.lang.ref.WeakReference;

public class TroopGiftPanelForNearby
  extends TroopGiftPanel
{
  protected WeakReference<QQAppInterface> c;
  protected boolean e;
  protected boolean f;
  
  public TroopGiftPanelForNearby(QQAppInterface paramQQAppInterface, Context paramContext, aaxw paramaaxw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramaaxw, false);
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
    localObject = (bgsu)((AppInterface)localObject).getManager(113);
    aawl localaawl = this.jdField_a_of_type_Aawl;
    int j = localaawl.b;
    if (localaawl.b == 0) {
      j = b();
    }
    int i;
    if (this.e)
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
      int m = this.k;
      String str = a();
      long l = Long.parseLong(paramString);
      int n = localaawl.c;
      if (localaawl.b == 0) {}
      for (int k = 1;; k = 0)
      {
        ((bgsu)localObject).a("OidbSvc.0x7f6", 2038, i, m, str, 2, j, l, n, k, localaawl.jdField_a_of_type_Int, 0, new ayac(this), localaawl.e);
        this.jdField_a_of_type_Aawl.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aawl = null;
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
    label78:
    label90:
    for (;;)
    {
      return;
      Object localObject = (HotChatManager)localQQAppInterface.getManager(60);
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if (localObject == null) {
          break label78;
        }
        axug.a((HotChatInfo)localObject, localQQAppInterface, a(), 0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Aaxw == null) {
          break label90;
        }
        this.jdField_a_of_type_Aaxw.b();
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