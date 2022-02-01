package com.tencent.mobileqq.kandian.repo.reward;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public abstract interface RIJCoinInfoModule$RequestHandler
{
  public abstract int a();
  
  public abstract void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, oidb_cmd0xed4.ReqBody paramReqBody);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.reward.RIJCoinInfoModule.RequestHandler
 * JD-Core Version:    0.7.0.1
 */