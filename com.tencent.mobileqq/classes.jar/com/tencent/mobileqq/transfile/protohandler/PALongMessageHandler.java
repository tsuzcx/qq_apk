package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.BaseMessageHandler;
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
    mobileqq_mp.LongMsgUrlRequest localLongMsgUrlRequest;
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = (RichProto.RichProtoReq.LongStructMessageDownReq)paramList.get(0);
      localLongMsgUrlRequest = new mobileqq_mp.LongMsgUrlRequest();
    }
    try
    {
      l = Long.parseLong(paramList.peerUin);
    }
    catch (Exception localException)
    {
      long l;
      label47:
      break label47;
    }
    l = 0L;
    localLongMsgUrlRequest.puin.set(l);
    localLongMsgUrlRequest.str_fileid.set(paramList.strFileid);
    return localLongMsgUrlRequest.toByteArray();
    return new byte[0];
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
    paramProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = paramProtoReq.resp;
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    Object localObject2 = paramProtoResp.resp.getWupBuffer();
    Object localObject1 = paramProtoResp.statisInfo;
    if (localFromServiceMsg.getResultCode() == 1000) {}
    try
    {
      if (localRichProtoResp.resps.size() <= 0) {
        break label241;
      }
      paramProtoResp = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject2);
      localObject1 = (RichProto.RichProtoResp.LongStructMessageDownResp)localRichProtoResp.resps.get(0);
      ((RichProto.RichProtoResp.LongStructMessageDownResp)localObject1).retInfo = ((mobileqq_mp.RetInfo)paramProtoResp.ret_info.get());
      ((RichProto.RichProtoResp.LongStructMessageDownResp)localObject1).strUrl = paramProtoResp.str_url.get();
      ((RichProto.RichProtoResp.LongStructMessageDownResp)localObject1).strFileMd5 = paramProtoResp.str_file_md5.get();
    }
    catch (Exception paramProtoResp)
    {
      int i;
      break label241;
    }
    i = localFromServiceMsg.getResultCode();
    if ((i != 1002) && (i != 1013))
    {
      localObject2 = BaseMessageHandler.a(localFromServiceMsg);
      paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
      if (paramProtoResp == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, (String)localObject2, paramProtoResp, (StatictisInfo)localObject1, localRichProtoResp.resps);
    }
    else
    {
      localObject2 = BaseMessageHandler.a(localFromServiceMsg);
      paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
      if (paramProtoResp == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9311, (String)localObject2, paramProtoResp, (StatictisInfo)localObject1, localRichProtoResp.resps);
    }
    label241:
    RichProtoProc.onBusiProtoResp(paramProtoReq, localRichProtoResp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.PALongMessageHandler
 * JD-Core Version:    0.7.0.1
 */