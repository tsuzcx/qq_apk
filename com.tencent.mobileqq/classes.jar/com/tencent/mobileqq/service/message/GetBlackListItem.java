package com.tencent.mobileqq.service.message;

import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqHeader;
import AccostSvc.RespGetBlackList;
import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageHandlerService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class GetBlackListItem
  implements CheckUpdateItemInterface
{
  public static String a = "GetBlackListItem";
  private final AppInterface b;
  
  public GetBlackListItem(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
  }
  
  public static long a(long paramLong)
  {
    return paramLong | 0L;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 116;
    Object localObject = new ReqHeader();
    ((ReqHeader)localObject).shVersion = 0;
    ((ReqHeader)localObject).lMID = a(Long.parseLong(this.b.getAccount()));
    ((ReqHeader)localObject).iAppID = AppSetting.d();
    localObject = new ReqGetBlackList((ReqHeader)localObject, 0L, 1, 0);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccostObj");
    localUniPacket.setFuncName("CMD_GET_BlackList");
    localUniPacket.put("ReqGetBlackList", localObject);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 116) && (paramRespItem.cResult == 2))
    {
      Object localObject = new UniPacket();
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramRespItem.vecUpdate);
      paramRespItem = (RespGetBlackList)((UniPacket)localObject).getByClass("RespGetBlackList", new RespGetBlackList());
      localObject = new FromServiceMsg();
      ((FromServiceMsg)localObject).setMsgSuccess();
      ((FromServiceMsg)localObject).setServiceCmd("AccostSvc.ReqGetBlackList");
      ((IMessageHandlerService)QRoute.api(IMessageHandlerService.class)).handleGetBlackList(this.b, null, (FromServiceMsg)localObject, paramRespItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.GetBlackListItem
 * JD-Core Version:    0.7.0.1
 */