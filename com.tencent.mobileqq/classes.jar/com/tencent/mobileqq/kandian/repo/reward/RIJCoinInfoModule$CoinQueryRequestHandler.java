package com.tencent.mobileqq.kandian.repo.reward;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinQueryReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.UserCoin;

public class RIJCoinInfoModule$CoinQueryRequestHandler
  implements RIJCoinInfoModule.RequestHandler
{
  public int a()
  {
    return 1;
  }
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if (paramRequest0xed4Params != null)
    {
      if (paramReqBody == null) {
        return;
      }
      paramReqBody.meta.type.set(1);
      paramReqBody.query_req.setHasFlag(true);
      paramReqBody.query_req.uin.set(RIJQQAppInterfaceUtil.c());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRspBody.retobj.has())
    {
      paramToServiceMsg = new UserCoinInfo();
      paramToServiceMsg.a = ((int)paramRspBody.retobj.platformCoin.get());
      paramToServiceMsg.b = ((int)paramRspBody.retobj.userCoin.get());
    }
    else
    {
      paramToServiceMsg = null;
    }
    boolean bool;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ThreadManager.c(new RIJCoinInfoModule.CoinQueryRequestHandler.1(this, bool, paramInt2, paramString, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.reward.RIJCoinInfoModule.CoinQueryRequestHandler
 * JD-Core Version:    0.7.0.1
 */