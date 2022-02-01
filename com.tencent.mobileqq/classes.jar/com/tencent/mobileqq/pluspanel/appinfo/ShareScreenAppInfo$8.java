package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.av.ReqGroupVideo.ReqScreenShareAsk;
import com.tencent.av.ReqGroupVideo.RspScreenShareAsk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.av.common.ErrorInfo;
import com.tencent.qphone.base.util.QLog;

class ShareScreenAppInfo$8
  extends MessageHandler.MsgListener<ReqGroupVideo.ReqScreenShareAsk, ReqGroupVideo.RspScreenShareAsk>
{
  ShareScreenAppInfo$8(ShareScreenAppInfo paramShareScreenAppInfo) {}
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqScreenShareAsk paramReqScreenShareAsk, ReqGroupVideo.RspScreenShareAsk paramRspScreenShareAsk, Object paramObject)
  {
    int i = MessageHandler.a((common.ErrorInfo)paramRspScreenShareAsk.result.get());
    paramReqScreenShareAsk = new StringBuilder();
    paramReqScreenShareAsk.append("onSendMsgRsp RspScreenShareAsk errCode[");
    paramReqScreenShareAsk.append(i);
    paramReqScreenShareAsk.append("]");
    QLog.d("ShareScreenAppInfo", 1, paramReqScreenShareAsk.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo.8
 * JD-Core Version:    0.7.0.1
 */