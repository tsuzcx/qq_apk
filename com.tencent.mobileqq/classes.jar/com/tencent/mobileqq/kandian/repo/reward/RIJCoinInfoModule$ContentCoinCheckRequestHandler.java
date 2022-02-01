package com.tencent.mobileqq.kandian.repo.reward;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ContentCoinCheckReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class RIJCoinInfoModule$ContentCoinCheckRequestHandler
  implements RIJCoinInfoModule.RequestHandler
{
  public int a()
  {
    return 4;
  }
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if (paramRequest0xed4Params != null)
    {
      if (paramReqBody == null) {
        return;
      }
      paramReqBody.meta.type.set(4);
      paramReqBody.content_coin_check_req.setHasFlag(true);
      paramReqBody.content_coin_check_req.uin.set(RIJQQAppInterfaceUtil.c());
      paramReqBody.content_coin_check_req.rowkey.set(paramRequest0xed4Params.b);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ThreadManager.c(new RIJCoinInfoModule.ContentCoinCheckRequestHandler.1(this, bool, paramInt2, paramString, (String)paramToServiceMsg.getAttributes().get("RequestRowkey"), paramRspBody.content_has_coin.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.reward.RIJCoinInfoModule.ContentCoinCheckRequestHandler
 * JD-Core Version:    0.7.0.1
 */