package com.tencent.mobileqq.transfile.protohandler;

import anza;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttUpHandler
  extends BaseHandler
{
  private static int s0x346Seq;
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    int j = 0;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    Object localObject = localReqBody.uint32_seq;
    int i = s0x346Seq;
    s0x346Seq = i + 1;
    ((PBUInt32Field)localObject).set(i);
    localReqBody.uint32_business_id.set(17);
    localReqBody.uint32_client_type.set(104);
    RichProto.RichProtoReq.PttUpReq localPttUpReq;
    if (paramList.size() == 1)
    {
      localPttUpReq = (RichProto.RichProtoReq.PttUpReq)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localPttUpReq.selfUin));
      try
      {
        localObject = localPttUpReq.peerUin;
        paramList = (List<RichProto.RichProtoReq.ReqCommon>)localObject;
        if (((String)localObject).startsWith("+")) {
          paramList = ((String)localObject).substring(1);
        }
        long l = Long.valueOf(paramList).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l);
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          paramList.printStackTrace();
          continue;
          i = j;
          if (localPttUpReq.forceViaOffline)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localPttUpReq.peerUin);
            i = 102;
            continue;
            i = 104;
            continue;
            i = 104;
            continue;
            i = 105;
            continue;
            i = 101;
            continue;
            i = 103;
            continue;
            i = 100;
            continue;
            i = 114;
            continue;
            i = 130;
            continue;
            if (localPttUpReq.uinType == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localPttUpReq.fileName);
      localApplyUploadReq.uint64_file_size.set(localPttUpReq.fileSize);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localPttUpReq.md5));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localPttUpReq.voiceType);
      paramList.uint32_ptt_time.set(localPttUpReq.voiceLength);
      i = getHandlerNetType();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localPttUpReq.audioPanelType);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localPttUpReq.audioPanelType + "] type[" + localPttUpReq.voiceType + "] length[" + localPttUpReq.voiceLength + "] size[" + localPttUpReq.fileSize + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localPttUpReq.uinType)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localPttUpReq.uinType == 1008)
        {
          paramList.uint32_file_type.set(3);
          localReqBody.msg_extension_req.set(paramList);
          return localReqBody.toByteArray();
        }
        break;
      }
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
      RichProto.RichProtoResp.C2CPttUpResp localC2CPttUpResp = new RichProto.RichProtoResp.C2CPttUpResp();
      localRichProtoResp.resps.add(i, localC2CPttUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject2 = paramProtoResp.resp;
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    anza localanza = paramProtoResp.statisInfo;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        paramProtoReq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, (String)localObject1, paramProtoResp, localanza, localRichProtoResp.resps);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    RichProto.RichProtoResp.C2CPttUpResp localC2CPttUpResp;
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      paramProtoReq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, (String)localObject1, paramProtoResp, localanza, localRichProtoResp.resps);
      continue;
      try
      {
        paramProtoResp = new cmd0x346.RspBody();
        paramProtoResp.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramProtoResp.msg_apply_upload_rsp.get();
        localC2CPttUpResp = (RichProto.RichProtoResp.C2CPttUpResp)localRichProtoResp.resps.get(0);
        if (localC2CPttUpResp != null)
        {
          if (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp")) {
            localC2CPttUpResp.isSendByQuickHttp = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localC2CPttUpResp.isSendByQuickHttp);
          }
          i = localApplyUploadRsp.int32_ret_code.get();
          if (i != 0) {
            break label589;
          }
          localC2CPttUpResp.uuid = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
          if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
            break;
          }
          localC2CPttUpResp.isExist = true;
        }
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localanza, localRichProtoResp.resps);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localC2CPttUpResp.blockSize = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localC2CPttUpResp.mUkey = ((String)localObject2);
    paramProtoReq = localApplyUploadRsp.str_upload_ip.get();
    paramProtoResp = paramProtoReq;
    if (paramProtoReq == null) {
      paramProtoResp = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label482:
      throw new Exception("ukey or ip missing");
      label589:
      do
      {
        paramProtoResp = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() > 0))
        {
          paramProtoResp = paramProtoResp.iterator();
          while (paramProtoResp.hasNext())
          {
            paramProtoReq = (String)paramProtoResp.next();
            localObject2 = new ServerAddr();
            ((ServerAddr)localObject2).mIp = paramProtoReq;
            localC2CPttUpResp.ipList.add(localObject2);
          }
        }
        setResult(0, 0, "", "", localanza, localC2CPttUpResp);
        break;
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", localanza, localC2CPttUpResp);
        break;
        if (localObject2 == null) {
          break label482;
        }
      } while (paramProtoResp != null);
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttUpHandler
 * JD-Core Version:    0.7.0.1
 */