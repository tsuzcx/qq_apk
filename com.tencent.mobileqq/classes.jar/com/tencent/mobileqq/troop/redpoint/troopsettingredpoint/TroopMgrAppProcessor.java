package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.RedPointInfo;
import com.tencent.mobileqq.troop.redpoint.RedPointItem;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;

public class TroopMgrAppProcessor
  extends AbsBaseProcessor
{
  public TroopMgrAppProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramQQAppInterface, paramString);
  }
  
  public String a()
  {
    return "TroopMgrAppProcessor";
  }
  
  public void b()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.a);
    if ((localTroopInfo == null) || (!localTroopInfo.isOwnerOrAdmin(this.b.getCurrentAccountUin()))) {
      ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.b, this.a, "troop", 5, 0);
    }
  }
  
  public void c()
  {
    Object localObject = ((IRedPointInfoService)this.b.getRuntimeService(IRedPointInfoService.class, "")).getRedPointInfo(this.a, "troop");
    if (localObject != null)
    {
      localObject = ((RedPointInfo)localObject).a(5);
      if ((localObject != null) && (((RedPointItem)localObject).unReadNum != 0))
      {
        ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.b, this.a, "troop", 5, 0);
        ((ITroopRedDotHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(this.a, 101913298);
      }
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.TroopMgrAppProcessor
 * JD-Core Version:    0.7.0.1
 */