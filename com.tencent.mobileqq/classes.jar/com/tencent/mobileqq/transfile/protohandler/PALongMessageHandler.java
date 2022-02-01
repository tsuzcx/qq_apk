package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class PALongMessageHandler
  extends BaseHandler
{
  private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (RichProto.RichProtoReq.LongStructMessageDownReq)paramList.get(0);
    mobileqq_mp.LongMsgUrlRequest localLongMsgUrlRequest = new mobileqq_mp.LongMsgUrlRequest();
    try
    {
      l = Long.parseLong(paramList.peerUin);
      localLongMsgUrlRequest.puin.set(l);
      localLongMsgUrlRequest.str_fileid.set(paramList.strFileid);
      return localLongMsgUrlRequest.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    paramRichProtoReq = paramRichProtoReq.resp;
    paramRichProtoReq.resps.clear();
    RichProto.RichProtoResp.LongStructMessageDownResp localLongStructMessageDownResp = new RichProto.RichProtoResp.LongStructMessageDownResp();
    paramRichProtoReq.resps.add(localLongStructMessageDownResp);
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    paramProtoReq = paramProtoResp.resp;
    Object localObject = paramProtoResp.resp.getWupBuffer();
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (paramProtoReq.getResultCode() == 1000) {}
    try
    {
      if (localRichProtoResp.resps.size() > 0)
      {
        paramProtoResp = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        paramProtoReq = (RichProto.RichProtoResp.LongStructMessageDownResp)localRichProtoResp.resps.get(0);
        paramProtoReq.retInfo = ((mobileqq_mp.RetInfo)paramProtoResp.ret_info.get());
        paramProtoReq.strUrl = paramProtoResp.str_url.get();
        paramProtoReq.strFileMd5 = paramProtoResp.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
        return;
        int i = paramProtoReq.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(paramProtoReq);
          paramProtoReq = paramProtoReq.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9311, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
        else
        {
          localObject = MessageHandler.a(paramProtoReq);
          paramProtoReq = paramProtoReq.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9044, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
      }
    }
    catch (Exception paramProtoResp)
    {
      break label126;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "PubAccountSvc.pull_long_msg_url";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.PALongMessageHandler
 * JD-Core Version:    0.7.0.1
 */