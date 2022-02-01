package com.tencent.mobileqq.transfile.protohandler;

import anza;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
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
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    paramProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = paramProtoReq.resp;
    anza localanza = paramProtoResp.statisInfo;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      int i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        setResult(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localanza, localRichProtoResp.resps);
      }
      for (;;)
      {
        RichProtoProc.onBusiProtoResp(paramProtoReq, localRichProtoResp);
        return;
        setResult(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localanza, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      try
      {
        paramProtoResp = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)new subcmd0x501.RspBody().mergeFrom(arrayOfByte)).msg_subcmd_0x501_rsp_body.get()).bytes_httpconn_sig_session.get();
        if ((paramProtoResp == null) || (paramProtoResp.toByteArray().length <= 0)) {
          break label264;
        }
        paramProtoResp = paramProtoResp.toByteArray();
        localObject = (RichProto.RichProtoResp.NearbyPeoplePicUpResp)localRichProtoResp.resps.get(0);
        ((RichProto.RichProtoResp.NearbyPeoplePicUpResp)localObject).sessionKey = paramProtoResp;
        setResult(0, 0, "", "", localanza, (RichProto.RichProtoResp.RespCommon)localObject);
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanza, localRichProtoResp.resps);
      }
      break;
      label264:
      paramProtoResp = null;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "HttpConn.0x6ff_501";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.NearbyPeoplePicUpHandler
 * JD-Core Version:    0.7.0.1
 */