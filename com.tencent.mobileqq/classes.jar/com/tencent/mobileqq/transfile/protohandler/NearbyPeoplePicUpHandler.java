package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;

public class NearbyPeoplePicUpHandler
  extends BaseHandler
{
  public static final int CIRCLE_SERVICE_TYPE = 5;
  public static final String CMD_GET_IP_LIST = "HttpConn.0x6ff_501";
  
  private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    subcmd0x501.ReqBody localReqBody = new subcmd0x501.ReqBody();
    subcmd0x501.SubCmd0x501ReqBody localSubCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramList = (RichProto.RichProtoReq.NearbyPeoplePicUpReq)paramList.get(0);
      localSubCmd0x501ReqBody.uint64_uin.set(Long.parseLong(paramList.uin));
      localSubCmd0x501ReqBody.uint32_idc_id.set(0);
      localSubCmd0x501ReqBody.uint32_appid.set(16);
      localSubCmd0x501ReqBody.uint32_login_sig_type.set(1);
      localSubCmd0x501ReqBody.uint32_request_flag.set(3);
      paramList = new ArrayList();
      paramList.add(Integer.valueOf(5));
      localSubCmd0x501ReqBody.rpt_uint32_service_types.set(paramList);
      localReqBody.msg_subcmd_0x501_req_body.set(localSubCmd0x501ReqBody);
      return localReqBody.toByteArray();
    }
    throw new RuntimeException("only support one request");
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.NearbyPeoplePicUpResp localNearbyPeoplePicUpResp = new RichProto.RichProtoResp.NearbyPeoplePicUpResp();
      localRichProtoResp.resps.add(i, localNearbyPeoplePicUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    Object localObject = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      int i = ((FromServiceMsg)localObject).getResultCode();
      if ((i != 1002) && (i != 1013)) {
        setResult(-1, 9044, BaseMessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.resps);
      } else {
        setResult(-1, 9311, BaseMessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.resps);
      }
    }
    else
    {
      try
      {
        paramProtoResp = (subcmd0x501.RspBody)new subcmd0x501.RspBody().mergeFrom(arrayOfByte);
        paramProtoReq = null;
        localObject = ((subcmd0x501.SubCmd0x501Rspbody)paramProtoResp.msg_subcmd_0x501_rsp_body.get()).bytes_httpconn_sig_session.get();
        paramProtoResp = paramProtoReq;
        if (localObject != null)
        {
          paramProtoResp = paramProtoReq;
          if (((ByteStringMicro)localObject).toByteArray().length > 0) {
            paramProtoResp = ((ByteStringMicro)localObject).toByteArray();
          }
        }
        paramProtoReq = (RichProto.RichProtoResp.NearbyPeoplePicUpResp)localRichProtoResp.resps.get(0);
        paramProtoReq.sessionKey = paramProtoResp;
        setResult(0, 0, "", "", localStatictisInfo, paramProtoReq);
      }
      catch (Exception paramProtoResp)
      {
        paramProtoReq = ProcessorReport.getServerReason("P", -9529L);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramProtoResp.getMessage());
        ((StringBuilder)localObject).append(" hex:");
        ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(arrayOfByte));
        setResult(-1, -9527, paramProtoReq, ((StringBuilder)localObject).toString(), localStatictisInfo, localRichProtoResp.resps);
      }
    }
    RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "HttpConn.0x6ff_501";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.NearbyPeoplePicUpHandler
 * JD-Core Version:    0.7.0.1
 */