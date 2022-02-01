package com.tencent.mobileqq.troop.quickat.network;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;

public class TroopMembersHandler
{
  private QQAppInterface a;
  private long b;
  private TroopManager c;
  private int d;
  private long e;
  
  public TroopMembersHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.c = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER));
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return true;
    }
    if (this.d != paramTroopInfo.wMemberNum) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (paramTroopInfo.wMemberNum <= 500) {
      return l - this.e < 180000L;
    }
    return l - this.e < 1800000L;
  }
  
  public void a(String paramString)
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localITroopMemberListHandler != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).f(paramString);
        this.b = System.currentTimeMillis();
        localITroopMemberListHandler.a(true, paramString, ((TroopInfo)localObject).troopcode, true, 2, this.b, 0);
        this.d = ((TroopInfo)localObject).wMemberNum;
        this.e = System.currentTimeMillis();
      }
    }
  }
  
  public boolean b(String paramString)
  {
    return a(this.c.f(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.network.TroopMembersHandler
 * JD-Core Version:    0.7.0.1
 */