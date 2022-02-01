package com.tencent.mobileqq.troop.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopHandler.Oidb0xb36;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import mqq.app.AppRuntime;

public class TroopHandlerServiceImpl
  implements ITroopHandlerService
{
  protected AppRuntime mApp;
  
  public void activeExtTroop(String paramString)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      ((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).w(paramString);
    }
  }
  
  public Bitmap getGroupFaceIcon(String paramString, boolean paramBoolean)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      return ((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramString, paramBoolean);
    }
    return null;
  }
  
  public void handleMemberExit(String paramString1, String paramString2)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      ((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c(paramString1, paramString2);
    }
  }
  
  public void notifyUI_genNewTroopName(boolean paramBoolean, Object paramObject)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      ((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.bm, paramBoolean, paramObject);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void send_oidb_0x899_0(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      ((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void send_oidb_0xb36_1(String paramString, int paramInt)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      TroopHandler.Oidb0xb36.a((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER), paramString, paramInt);
    }
  }
  
  public void updateGroupIcon(String paramString, boolean paramBoolean)
  {
    if ((this.mApp instanceof QQAppInterface)) {
      ((TroopHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).f(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */